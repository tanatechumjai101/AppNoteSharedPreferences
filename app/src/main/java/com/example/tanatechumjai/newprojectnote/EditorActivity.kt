package com.example.tanatechumjai.newprojectnote

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_editor.*

class EditorActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)
        val sharedPreference = getSharedPreferences("editdata", Context.MODE_PRIVATE)
        val editor = sharedPreference.edit()
        
//        intent.extras.let {
//            it.getString("Index")
//            dataText.setText(it.getString("DataText"))
//        }




        savedata.apply {

            setOnClickListener {

                editor.putString("TextNow",dataText.text.toString())
                editor.commit()
                Log.e("save","${editor.toString()}")
//                intent.extras.let {
//
////                    it.getString("Index")
////                    dataText.setText(it.getString("DataText"))
////                    intent.putExtra("newdate",dataText.setText(it.getString("DataText")).toString())
//                }

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
