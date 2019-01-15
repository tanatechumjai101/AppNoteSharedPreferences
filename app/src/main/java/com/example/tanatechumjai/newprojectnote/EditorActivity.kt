package com.example.tanatechumjai.newprojectnote

import android.app.Activity
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

    var adapteredit : ListNoteAdapter?=null
    val dataedit  = ArrayList<Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)
        val sharedPreference = getSharedPreferences("editdata", Context.MODE_PRIVATE)
        val editor = sharedPreference.edit()


        intent.extras?.let {
            dataText.setText(it.getString("DataText"))
        }

        Log.e("txtcomming","${dataText.toString()}")
//        Recycle1.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)

        savedata.apply {

            setOnClickListener {
//                Recycle1.adapter = adapteredit
                var innn = Intent()
                innn.putExtra("text", "")
                setResult(Activity.RESULT_OK, innn)

//
//                 editor.putString("TextNow", dataText.text.toString())
////                 adapteredit = ListNoteAdapter(context,dataedit)
////                dataedit.add(Data("${dataedit.size}","${txtcomming}"))
//                editor.commit()
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
