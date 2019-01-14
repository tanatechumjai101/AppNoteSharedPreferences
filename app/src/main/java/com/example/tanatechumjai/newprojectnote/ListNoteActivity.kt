package com.example.tanatechumjai.newprojectnote

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_editor.*
import kotlinx.android.synthetic.main.activity_main.*

class ListNoteActivity : AppCompatActivity() {
    var adapter : ListNoteAdapter?=null
    val data  = ArrayList<Data>()

//    val sharedPreference = getSharedPreferences("editdata", Context.MODE_PRIVATE)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Newfilenote()

        Recycle1.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)

        adapter = ListNoteAdapter(this,data)

        Recycle1.adapter = adapter

    }

//    override fun onRestart() {
//        val sharedPreference = getSharedPreferences("editdata",Context.MODE_PRIVATE)
//        sharedPreference.edit().putString("${data.size}","index_data").apply()
//        val now =  sharedPreference.getString("TextNow","")
//
//        data.add(Data("${data.size+1}", "${now}"))
//        super.onRestart()
//    }

    override fun onResume() {
        val sharedPreference = getSharedPreferences("editdata",Context.MODE_PRIVATE)
        sharedPreference.edit().putString("${data.size}","index_data").apply()
        val now =  sharedPreference.getString("TextNow","")
        data.add(Data("${data.size+1}", "${now}"))
        super.onResume()
    }
    fun Newfilenote(){

        newfile.apply {
            setOnClickListener {
                val intent = Intent(this@ListNoteActivity,EditorActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
