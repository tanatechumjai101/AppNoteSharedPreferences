package com.example.tanatechumjai.newprojectnote

import android.app.Activity
import android.app.Person
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.LinearLayout
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray

const val ADD_NEW_NOTE = 12
const val EDIT_NOTE = 13

class ListNoteActivity : AppCompatActivity(), ListNoteAdapter.onEditInterface {


    lateinit var sharedPreference: SharedPreferences

    var adapter: ListNoteAdapter? = null
    val listdata = ArrayList<Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LoadData()
        Newfilenote()

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

    override fun onDeleteNote(Index: String) {
        listdata.removeAt(Index.toInt() - 1)
        adapter!!.notifyDataSetChanged()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == ADD_NEW_NOTE) {
            if (resultCode == Activity.RESULT_OK) {
                data!!.extras.let {
                    listdata.add(Data("${listdata.size + 1}", data.extras.getString("text")))
                    SavaData()
                    adapter!!.notifyDataSetChanged()
                }
            }
        } else if (requestCode == EDIT_NOTE) {
            if (resultCode == Activity.RESULT_OK) {
                data!!.extras.let {
                    listdata.removeAt(it.getString("index").toInt() - 1)
                    listdata.add(it.getString("index").toInt() - 1, Data(it.getString("index"), it.getString("text")))
                    SavaData()
                    adapter!!.notifyDataSetChanged()


                }
            }
        }
    }

    private fun SavaData() {
        var sharedPreference: SharedPreferences
        sharedPreference = getSharedPreferences("SAVE_DATAs", Context.MODE_PRIVATE)
        val editor = sharedPreference.edit()
        val gson = Gson()
        val json = gson.toJson(listdata)
        editor.putString("DATALIST", json)
        editor.commit()

    }

    private fun LoadData() {
        val sharedPreference = getSharedPreferences("SAVE_DATAs", Context.MODE_PRIVATE)
        if (sharedPreference != null) {
            val json = JSONArray(sharedPreference.getString("DATALIST", null))

            for (i in 0 until json.length()) {
                listdata.add(Data(json.getJSONObject(i).getString("index"), json.getJSONObject(i).getString("data")))
            }
        }
    }
}
