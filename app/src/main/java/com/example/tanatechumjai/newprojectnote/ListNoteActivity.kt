package com.example.tanatechumjai.newprojectnote

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import android.preference.PreferenceManager


const val ADD_NEW_NOTE = 12
const val EDIT_NOTE = 13

class ListNoteActivity : AppCompatActivity(), ListNoteAdapter.onEditInterface{

    var adapter: ListNoteAdapter? = null
    val listdata = ArrayList<Data>()

//    override fun onSave(Index: String, DataText: String) {
//        listdata.add(Index.toInt() - 1, Data(Index, DataText))
//        adapter!!.notifyDataSetChanged()
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Newfilenote()

//        val sharedPreference = getSharedPreferences("editdata", Context.MODE_PRIVATE)
//        val editor = sharedPreference.edit()
//        if (sharedPreference == null) {
//            listdata.add(Data("${listdata.size+1}","${}"))
//        } else {
//            listdata.add(Data("${listdata.size + 1}", "new note"))
//        }
//        sharedPreference.edit().putString("${listdata.size}","index_data").apply()
//        val now =  sharedPreference.getString("TextNow","")
//
//        listdata.add(Data("${listdata.size+1}", "${now}"))

        Recycle1.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        adapter = ListNoteAdapter(listdata, this)
        Recycle1.adapter = adapter

    }

    fun Newfilenote() {
        newfile.apply {
            setOnClickListener {
                val intent = Intent(this@ListNoteActivity, EditorActivity::class.java)
                intent.putExtra("Index", "${listdata.size}")
                startActivityForResult(intent, ADD_NEW_NOTE)
            }
        }
    }

    override fun onEditNote(Index: String, DataText: String) {
        val intent = Intent(this@ListNoteActivity, EditorActivity::class.java)
        intent.putExtra("Index", Index)
        intent.putExtra("DataText", DataText)
        startActivityForResult(intent, EDIT_NOTE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val sharedPreference = getSharedPreferences("editdata", Context.MODE_PRIVATE)
        val preferences = PreferenceManager.getDefaultSharedPreferences(this)

        if (requestCode == ADD_NEW_NOTE) {
            if (resultCode == Activity.RESULT_OK) {
                data!!.extras.let {
                    listdata.add(Data("${listdata.size}", data.extras.getString("text")))
                    adapter!!.notifyDataSetChanged()
                }
            }
        } else if (requestCode == EDIT_NOTE) {
            if (resultCode == Activity.RESULT_OK) {
                data!!.extras.let {
//                    if(listdata.size!=it.getString("index").toInt()-1){
////                        listdata.add(it.getString("index").toInt()+1, Data(it.getString("index"), it.getString("text")))
//
//                    }
                    listdata.add(Data("${listdata.size}", data.extras.getString("text")))
                    adapter!!.notifyDataSetChanged()


                }
            }
        }
    }
}
