package com.fehtystudio.eurika.Chat

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.fehtystudio.eurika.R
import com.google.firebase.FirebaseApp
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.chat.*
import java.util.*

class Chat : android.support.v4.app.Fragment() {

    var databaseReference: DatabaseReference? = null

    companion object {
        fun schedule(): Chat {
            return Chat()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initFirebase()
        createFirebaseListener()
        sendMessage.setOnClickListener {
            when {
                inputMessage.text.toString().isEmpty() -> Toast.makeText(activity, "Введите текст", Toast.LENGTH_SHORT).show()
                inputMessage.text.toString().isNotEmpty() -> sendData()
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initFirebase() {
        FirebaseApp.initializeApp(activity)
        databaseReference = FirebaseDatabase.getInstance().reference
    }

    private fun createFirebaseListener() {
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val toReturn: ArrayList<Message> = ArrayList()
                for (data in dataSnapshot.children) {
                    val messageData = data.getValue<Message>(Message::class.java)
                    val message = messageData?.let { it } ?: continue
                    toReturn.add(message)
                }
                toReturn.sortBy { message ->
                    message.timestamp
                }
                setupAdapter(toReturn)
            }
            override fun onCancelled(databaseError: DatabaseError) {
            }
        }
        databaseReference?.child("messages")?.addValueEventListener(postListener)
    }

    private fun setupAdapter(data: ArrayList<Message>) {
        if (mainActivityRecyclerView == null) {

        } else if (mainActivityRecyclerView !== null) {
            val linearLayoutManager = LinearLayoutManager(activity)
            mainActivityRecyclerView.layoutManager = linearLayoutManager
            mainActivityRecyclerView.adapter = MessageAdapter(data) {
            }
            mainActivityRecyclerView.scrollToPosition(data.size - 1)
        }
    }

    private fun sendData() {
        databaseReference?.
                child("messages")?.
                child(java.lang.String.valueOf(System.currentTimeMillis()))?.
                setValue(Message(inputMessage.text.toString()))
        inputMessage.setText("")
    }

}


