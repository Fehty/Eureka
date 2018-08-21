package com.fehtystudio.eurika.Schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import com.fehtystudio.eurika.R

class Schedule : android.support.v4.app.Fragment() {

    private var lv: ListView? = null
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.schedule, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val products = arrayOf("Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота")
        lv = view.findViewById(R.id.list_view)
        adapter = ArrayAdapter(activity, R.layout.schedule_item, R.id.schedule_item_name, products)
        lv?.adapter = adapter

        lv!!.setOnItemClickListener { _, _, position, _ ->
            if (position == 0) {
                val transaction = fragmentManager!!.beginTransaction()
                val monday = Monday()
                transaction.replace(R.id.container, monday)
                transaction.addToBackStack(null)
                transaction.commit()
            }
            if (position == 1) {
                val transaction = fragmentManager?.beginTransaction()
                val tuesday = Tuesday()
                transaction?.replace(R.id.container, tuesday)
                transaction?.addToBackStack(null)
                transaction?.commit()
            }
            if (position == 2) {
                val transaction = fragmentManager!!.beginTransaction()
                val wednesday = Wednesday()
                transaction.replace(R.id.container, wednesday)
                transaction.addToBackStack(null)
                transaction.commit()
            }
            if (position == 3) {
                val transaction = fragmentManager!!.beginTransaction()
                val thursday = Thursday()
                transaction.replace(R.id.container, thursday)
                transaction.addToBackStack(null)
                transaction.commit()
            }
            if (position == 4) {
                val transaction = fragmentManager!!.beginTransaction()
                val friday = Friday()
                transaction.replace(R.id.container, friday)
                transaction.addToBackStack(null)
                transaction.commit()
            }
            if (position == 5) {
                val transaction = fragmentManager?.beginTransaction()
                val saturday = Saturday()
                transaction?.replace(R.id.container, saturday)
                transaction?.addToBackStack(null)
                transaction?.commit()
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }


}
