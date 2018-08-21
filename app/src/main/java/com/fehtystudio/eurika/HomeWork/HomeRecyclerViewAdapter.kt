package com.fehtystudio.eurika.HomeWork

import android.content.ContentValues.TAG
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.fehtystudio.eurika.R
import java.util.*


class HomeRecyclerViewAdapter(var subject: ArrayList<RawSubject>, var description: ArrayList<RawDescription>) : RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder>() {

    private var position: Int = 0

    fun getPosition(): Int {
        return position
    }

    fun setPosition(position: Int) {
        this.position = position
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindSubject(subject[position])
        holder?.bindDescription(description[position])
        holder?.itemView?.setOnLongClickListener({
            setPosition(holder.adapterPosition)
            false
        })
    }

    override fun onViewRecycled(holder: ViewHolder?) {
        holder?.itemView?.setOnLongClickListener(null)
        super.onViewRecycled(holder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecyclerViewAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.home_work_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return subject.size
        return description.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnCreateContextMenuListener {

        fun bindSubject(subject: RawSubject) {
            val itemSub: TextView = itemView.findViewById(R.id.homeWorkSubjectI)
            itemSub.text = subject.subject
            itemView.setOnClickListener({
                Log.d(TAG, "ItemClick" + " AdapterPosition = " + (adapterPosition + 1) + " ItemText = " + itemSub.text)
            })
            itemView.setOnCreateContextMenuListener(this)
        }

        fun bindDescription(description: RawDescription) {
            val itemDesc: TextView = itemView.findViewById(R.id.homeWorkDescriptionI)
            itemDesc.text = description.description
            itemView.setOnCreateContextMenuListener(this)
        }

        override fun onCreateContextMenu(menu: ContextMenu?, view: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
            menu?.setHeaderTitle("Опции")
            menu?.add(0, R.id.upgrade, 0, "Изменить")
            menu?.add(0, R.id.delete, 0, "Удалить")
        }
    }

}

