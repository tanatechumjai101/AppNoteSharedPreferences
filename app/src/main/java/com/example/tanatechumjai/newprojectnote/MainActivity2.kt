package com.example.tanatechumjai.newprojectnote

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
//    var adapter : MainAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val newdata = dataText.toString()
        savedata.apply {
            setOnClickListener {
//                var intent = Intent()
//                intent.putExtra("newData",newdata)
//                startActivity(intent)
                finish()
            }
        }
        cancledata.apply {
            setOnClickListener {
                finish()
            }
        }
    }
}
