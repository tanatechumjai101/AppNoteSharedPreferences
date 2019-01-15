package com.example.tanatechumjai.newprojectnote

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import kotlinx.android.synthetic.main.activity_editor.*

class EditorActivity : AppCompatActivity() {


    interface onFinishEdited {
        fun onSave(Index: String, DataText: String)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)
        val sharedPreference = getSharedPreferences("editdata", Context.MODE_PRIVATE)
        val editor = sharedPreference.edit()

        intent.extras?.let {
            dataText.setText(it.getString("DataText"))
        }

        Btnsavedata.apply {
            setOnClickListener {
                val innn = Intent()

                innn.putExtra("text", "${dataText.text}")

                intent.extras.getString("Index")?.let {
                    innn.putExtra("index", intent.extras.getString("Index"))
                }

                setResult(Activity.RESULT_OK, innn)
                finish()
            }
        }
        Btncancledata.apply {
            setOnClickListener {
                finish()
            }
        }
    }


}
