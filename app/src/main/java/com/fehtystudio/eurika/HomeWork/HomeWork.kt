package com.fehtystudio.eurika.HomeWork


import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.*
import android.widget.EditText
import android.widget.LinearLayout
import com.fehtystudio.eurika.R
import kotlinx.android.synthetic.main.home_work.*
import kotlinx.android.synthetic.main.home_work_item.*
import java.util.*


class HomeWork : Fragment() {

    private lateinit var database: SQLiteDatabase
    private var contentValues = ContentValues()
    private lateinit var cursor: Cursor
    private var idIndex: Int = 0
    private var itemIndexS: Int = 0
    private var itemIndexD: Int = 0
    private lateinit var dbHelper: HomeWorkDBHelper
    private var lv: RecyclerView? = null
    var itemSubject = ArrayList<RawSubject>()
    var itemDescription = ArrayList<RawDescription>()
    var adapter = HomeRecyclerViewAdapter(itemSubject, itemDescription)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.home_work, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbarToDo = view?.findViewById(R.id.toolbar_top_home_work) as Toolbar
        (activity as AppCompatActivity).setSupportActionBar(toolbarToDo)
        (activity as AppCompatActivity).title = null
        setHasOptionsMenu(true)

        lv = view.findViewById(R.id.homeWorkList)
        lv?.layoutManager = LinearLayoutManager(this.activity, LinearLayout.VERTICAL, false) as RecyclerView.LayoutManager?
        lv?.adapter = adapter
        adapter.notifyDataSetChanged()

        dbHelper = HomeWorkDBHelper(activity, "db2", 1)
        database = dbHelper.writableDatabase
        cursor = database.query(dbHelper.TABLE_HOMEWORK, null, null, null, null, null, null)
        if (cursor.moveToFirst()) {
            idIndex = cursor.getColumnIndex("_id")
            itemIndexS = cursor.getColumnIndex("itemS")
            itemIndexD = cursor.getColumnIndex("itemD")
            do {
                Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
                        ", S = " + cursor.getString(cursor.getColumnIndex("itemS")) +
                        ", D = " + cursor.getString(cursor.getColumnIndex("itemD")))
                itemSubject.add(RawSubject(cursor.getString(itemIndexS)))
                itemDescription.add(RawDescription(cursor.getString(itemIndexD)))
            } while (cursor.moveToNext())
        }
        homeWorkFab.setOnClickListener({
            showDialog()
        })
        registerForContextMenu(lv)
    }

    @SuppressLint("InflateParams")
    private fun showDialog() {
        val dialogBuilder = AlertDialog.Builder(context)
        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(R.layout.home_work_dialog, null)
        dialogBuilder.setView(dialogView)
        val inputHomeWorkSubject = dialogView.findViewById(R.id.homeWorkSubjectD) as EditText
        val inputHomeWorkDescription = dialogView.findViewById(R.id.homeWorkDescriptionD) as EditText
        dialogBuilder.setPositiveButton("Готово") { _, _ ->
            val itemS = inputHomeWorkSubject.text.toString()
            val itemD = inputHomeWorkDescription.text.toString()
            //   if (itemS.isEmpty()) {
            //       Toast.makeText(context, "Незаполненное поле", Toast.LENGTH_SHORT).show()
            //       showDialog()
            //   } else if (itemS.isNotEmpty()) {
            //  idS = 0
            //  idS += 1
            itemSubject.add(RawSubject(inputHomeWorkSubject.text.toString()))
            adapter.notifyDataSetChanged()
            contentValues.put("itemS", itemS)
            inputHomeWorkSubject.text = null

            itemDescription.add(RawDescription(inputHomeWorkDescription.text.toString()))
            adapter.notifyDataSetChanged()
            contentValues.put("itemD", itemD)
            inputHomeWorkSubject.text = null

            database.insert(dbHelper.TABLE_HOMEWORK, null, contentValues)

            //   }
        }
        dialogBuilder.setNegativeButton("Отмена") { _, _ ->
        }
        val b = dialogBuilder.create()
        b.show()
    }

    @SuppressLint("InflateParams")
    private fun changeTextDialog() {
        val dialogBuilder = AlertDialog.Builder(context)
        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(R.layout.home_work_dialog_change_text, null)
        dialogBuilder.setView(dialogView)
        val inputHomeWorkSubject = dialogView.findViewById(R.id.changeHomeWorkSubjectD) as EditText
        val inputHomeWorkDescription = dialogView.findViewById(R.id.changeHomeWorkDescriptionD) as EditText
        inputHomeWorkSubject.setText(homeWorkSubjectI.text.toString())
        inputHomeWorkDescription.setText(homeWorkDescriptionI.text.toString())
        inputHomeWorkSubject.setSelection(inputHomeWorkSubject.text.length)
        inputHomeWorkDescription.setSelection(inputHomeWorkDescription.text.length)
        dialogBuilder.setPositiveButton("Готово") { _, _ ->
            val itemS = inputHomeWorkSubject.text.toString()
            val itemD = inputHomeWorkDescription.text.toString()
            dbHelper = HomeWorkDBHelper(activity, "db2", 1)
            database = dbHelper.writableDatabase
            var contentValues = ContentValues()
            contentValues.put(dbHelper.KEY_SUBJECT, itemS)
            contentValues.put(dbHelper.KEY_HOME_WORK_DESCRIPTION, itemD)
            database.update(dbHelper.TABLE_HOMEWORK, contentValues, dbHelper.KEY_SUBJECT + " = ?", arrayOf(homeWorkSubjectI.text.toString()))
            var homeWork = HomeWork()
            fragmentManager.beginTransaction().replace(R.id.container, homeWork).commit()
        }
        dialogBuilder.setNegativeButton("Отмена") { _, _ ->
        }
        val b = dialogBuilder.create()
        b.show()
    }


    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.home_work_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.removeAll -> {
                lv?.removeAllViewsInLayout()
                itemSubject.removeAll(itemSubject)
                itemDescription.removeAll(itemDescription)
                database.delete(dbHelper.TABLE_HOMEWORK, null, null)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    //  override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
    //      super.onCreateContextMenu(menu, v, menuInfo)
    //      menu?.setHeaderTitle("Опции")
    //      menu?.add(0, UPGRADE, 0, "Изменить")
    //      menu?.add(0, DELETE, 0, "Удалить")
    //  }

    //  override fun onContextItemSelected(item: MenuItem?): Boolean {
    //      when (item?.itemId) {
    //          UPGRADE -> {
    //          }
    //          DELETE -> {
    //              dbHelper = HomeWorkDBHelper(activity, "db2", 1)
    //              database = dbHelper.writableDatabase
    //              database.delete(dbHelper.TABLE_HOMEWORK, dbHelper.KEY_HOME_WORK_DESCRIPTION + " = ?", arrayOf(homeWorkSubjectI.text.toString()))
    //              var homeWork = HomeWork()
    //              getFragmentManager().beginTransaction().replace(R.id.container, homeWork).commit()
    //          }
    //      }
    //      return super.onContextItemSelected(item)
    //  }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.upgrade -> {
                changeTextDialog()
            }
            R.id.delete -> {
                dbHelper = HomeWorkDBHelper(activity, "db2", 1)
                database = dbHelper.writableDatabase
                database.delete(dbHelper.TABLE_HOMEWORK, dbHelper.KEY_SUBJECT + " = ?", arrayOf(homeWorkSubjectI.text.toString()))
                var homeWork = HomeWork()
                fragmentManager.beginTransaction().replace(R.id.container, homeWork).commit()
            }
        }
        return super.onContextItemSelected(item)
    }


}

