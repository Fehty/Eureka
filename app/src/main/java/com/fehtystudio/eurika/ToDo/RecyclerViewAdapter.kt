package com.fehtystudio.eurika.ToDo

import android.content.ContentValues
import android.content.Context
import android.graphics.Paint
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import com.fehtystudio.eurika.R
import kotlin.collections.ArrayList
import android.widget.CompoundButton

class RecyclerViewAdapter(var list: ArrayList<MyData>, var context: Context) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    var toDo: ToDo = ToDo()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.to_do_item_main, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {

        holder.bindItems(list[position])

        //in some cases, it will prevent unwanted situations
        holder.checkBox.setOnCheckedChangeListener(null)

        //if true, your checkbox will be selected, else unselected
        holder.checkBox.isChecked = numbers.get(position).isSelected()

        holder.checkBox.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { _, isChecked -> numbers.get(holder.adapterPosition).setSelected(isChecked) })
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var dbHelper = DBHelper(itemView.context, "db", 1)
        var database = dbHelper.writableDatabase
        val checkBox: CheckBox = itemView.findViewById(R.id.checkBox)
        val itemText: TextView = itemView.findViewById(R.id.itemText)
        val removeItem: ImageButton = itemView.findViewById(R.id.removeItem)
        var contentValues = ContentValues()
        var cursor = database.query(dbHelper.TABLE_TO_DO, null, null, null, null, null, null)
        var idIndex = cursor.getColumnIndex("_id")
        var checkB = cursor.getColumnIndex("checkBox")
        var itemT = cursor.getColumnIndex("item")
        var arr = ArrayList<Any>()
        var hashM = mutableMapOf<Int, Boolean>()

        fun bindItems(data: MyData) {

            itemText.text = data.text
            database = DBHelper(itemView.context, "db", 1).writableDatabase

            if (cursor.moveToFirst()) {
                do {
                    Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
                            ", checkBox = " + cursor.getInt(checkB)
                            + ", text = " + cursor.getString(itemT))
                   if (cursor.getInt(checkB) == 1) {
                     //  arr.add(cursor.getString(itemT).toString())
                   }
                } while (cursor.moveToNext())
            }

        //    for (i in 0 until arr.size) {
//                if(checkBox.id == arr[i]) {
//
//                }
                Log.d("#*#**#*#", arr.toString())
     //       }
            // Log.d("#*#**#*#", )

            checkBox.setOnClickListener({
                var checkBoxId = 0
                var checked = checkBox.isChecked
                if (checked) {
                   // hashM.put(checkBoxId + 1, true)
                    checkBox.id = position + 1
                    arr.add(position + 1)
                    Log.d("#*#**#*#", checkBox.id.toString())
                    contentValues.put(dbHelper.KEY_CHECKBOX, 1)
                    database.update(dbHelper.TABLE_TO_DO, contentValues, dbHelper.KEY_ITEM + " = ?", arrayOf(itemText.text.toString()))
                    itemText.paintFlags = itemText.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                } else if (!checked) {
                    contentValues.put(dbHelper.KEY_CHECKBOX, 0)
                    database.update(dbHelper.TABLE_TO_DO, contentValues, dbHelper.KEY_ITEM + " = ?", arrayOf(itemText.text.toString()))
                    itemText.paintFlags = itemText.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
                }
            })

            removeItem.setOnClickListener({
                dbHelper = DBHelper(removeItem.context, "db", 1)
                dbHelper.writableDatabase.delete(dbHelper.TABLE_TO_DO, dbHelper.KEY_ITEM + " = ?", arrayOf(itemText.text.toString()))
                position.toString()
                list.removeAt(position)
                notifyItemRemoved(position)
            })
        }
    }
}
