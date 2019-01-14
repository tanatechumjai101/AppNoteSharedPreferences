package com.example.tanatechumjai.newprojectnote

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_update_data.*

class MainActivity : AppCompatActivity() {
    var adapter : MainAdapter?=null
    val data  = ArrayList<Data>()
    val mainActivity2 = MainActivity2()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Newfilenote()

        val sharedPreference = getSharedPreferences("editdata",Context.MODE_PRIVATE)
        val setIndex = sharedPreference.getString("index_data","no_set")
        val setText = sharedPreference.getString("data_text","no_set")
        sharedPreference.edit().putString("${data.size}","index_data").apply()

        Recycle1.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)


        data.add(Data("${data.size}","A"))
        data.add(Data("${data.size}","B"))
        data.add(Data("${data.size}","C"))
        data.add(Data("${data.size}","D"))
        data.add(Data("${data.size}","E"))

        adapter = MainAdapter(this,data)

        Recycle1.adapter = adapter
    }
    fun Newfilenote(){

        newfile.apply {
            setOnClickListener {
                val intent = Intent(this@MainActivity,MainActivity2::class.java)
                startActivity(intent)
            }
        }
    }
}
