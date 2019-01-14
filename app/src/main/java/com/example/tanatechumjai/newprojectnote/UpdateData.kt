package com.example.tanatechumjai.newprojectnote

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_update_data.*

class UpdateData : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_data)

        OkPageEdit.apply {
            setOnClickListener {

//                EditData.text = dataText.text
                finish()
            }
        }
        CancelPageEdit.apply {
            setOnClickListener {
                finish()
            }
        }
    }
}
