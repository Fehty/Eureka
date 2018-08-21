package com.fehtystudio.eurika

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.fehtystudio.eurika.Chat.Chat
import com.fehtystudio.eurika.HomeWork.HomeWork
import com.fehtystudio.eurika.R.id.menu_chat
import com.fehtystudio.eurika.Schedule.Schedule
import com.fehtystudio.eurika.Site.Site
import com.fehtystudio.eurika.ToDo.ToDo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val manager = this.supportFragmentManager

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.menu_chat -> {
                val transaction = manager.beginTransaction()
                transaction.replace(R.id.container, Chat())
                transaction.addToBackStack(null)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.menu_schedule -> {
                val transaction = manager.beginTransaction()
                transaction.replace(R.id.container, Schedule())
                transaction.addToBackStack(null)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.menu_toDo -> {
                val transaction = manager.beginTransaction()
                transaction.replace(R.id.container, ToDo())
                transaction.addToBackStack(null)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.menu_site -> {
                val transaction = manager.beginTransaction()
                transaction.replace(R.id.container, Site())
                transaction.addToBackStack(null)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.menu_homeWork -> {
                val transaction = manager.beginTransaction()
                transaction.replace(R.id.container, HomeWork())
                transaction.addToBackStack(null)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigation.selectedItemId = menu_chat
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, Chat())
        transaction.commit()
    }


}
