package com.example.tanatechumjai.newprojectnote

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_editor.*
import kotlinx.android.synthetic.main.activity_main.*

const val FILE_PICKER_ID = 12

class ListNoteActivity : AppCompatActivity() {
    var adapter: ListNoteAdapter? = null
    val listdata = ArrayList<Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Newfilenote()

        val sharedPreference = getSharedPreferences("editdata", Context.MODE_PRIVATE)
        if (sharedPreference == null) {

        } else {
            listdata.add(Data("${listdata.size + 1}", "new note"))
        }
//        sharedPreference.edit().putString("${listdata.size}","index_data").apply()
//        val now =  sharedPreference.getString("TextNow","")
//
//        listdata.add(Data("${listdata.size+1}", "${now}"))

        Recycle1.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        adapter = ListNoteAdapter(this, listdata)
        Recycle1.adapter = adapter

    }

    fun Newfilenote() {
        newfile.apply {
            setOnClickListener {
                val intent = Intent(this@ListNoteActivity, EditorActivity::class.java)
                startActivityForResult(intent, FILE_PICKER_ID)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == FILE_PICKER_ID) {
            if (resultCode == Activity.RESULT_OK) {
                data!!.extras.let {
                    listdata.add(Data("${listdata.size + 1}", it.getString("text")))
                    adapter!!.notifyDataSetChanged()
                }

//                val sharedPreference = getSharedPreferences("editdata",Context.MODE_PRIVATE)
//                val now =  sharedPreference.getString("TextNow","")

//                adapter = null
//                data.add(Data("${data.size+1}", "${now}"))
//                adapter = ListNoteAdapter(this,data)
//                Recycle1.adapter = adapter
            }
        }
    }
}
