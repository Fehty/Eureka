package com.fehtystudio.eurika.ToDo

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.*
import android.widget.LinearLayout
import android.widget.Toast
import com.fehtystudio.eurika.R
import kotlinx.android.synthetic.main.to_do_main.*

class ToDo : android.support.v4.app.Fragment() {

    var item: String = ""
    lateinit var database: SQLiteDatabase
    var contentValues = ContentValues()
    lateinit var cursor: Cursor
    var idIndex: Int = 0
    var itemIndex: Int = 0
    var items = ArrayList<MyData>()
    lateinit var dbHelper: DBHelper

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.to_do_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val toolbarToDo = view.findViewById(R.id.toolbar_top_to_do) as Toolbar
        (activity as AppCompatActivity).setSupportActionBar(toolbarToDo)
        (activity as AppCompatActivity).title = null
        setHasOptionsMenu(true)

        val adapter = RecyclerViewAdapter(items, activity)//activity
        toDoRecyclerView.layoutManager = LinearLayoutManager(this.activity, LinearLayout.VERTICAL, false)
        toDoRecyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

        dbHelper = DBHelper(activity, "db", 1)
        database = dbHelper.writableDatabase
        cursor = database.query(dbHelper.TABLE_TO_DO, null, null, null, null, null, null)

        if (cursor.moveToFirst()) {
            idIndex = cursor.getColumnIndex("_id")
            itemIndex = cursor.getColumnIndex("item")
            do {
                items.add(MyData(cursor.getString(itemIndex)))
            } while (cursor.moveToNext())
        }

        addItem.setOnClickListener{
            if (inputText.text.toString().isEmpty()) {
                Toast.makeText(activity, "Введите текст", Toast.LENGTH_SHORT).show()
            } else if (inputText.text.toString().isNotEmpty()) {
                items.add(MyData(inputText.text.toString()))
                adapter.notifyDataSetChanged()
                item = inputText.text.toString()
                contentValues.put("item", item)
                database.insert(dbHelper.TABLE_TO_DO, null, contentValues)
                inputText.text = null
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.to_do_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.removeAll -> {
                toDoRecyclerView.removeAllViewsInLayout()
                database.delete(dbHelper.TABLE_TO_DO, null, null)
                items.removeAll(items)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}