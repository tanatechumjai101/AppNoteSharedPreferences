package com.example.tanatechumjai.newprojectnote

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_editor.*
import org.json.JSONArray

class EditorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)

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
                onBackPressed()
            }

        }
    }

    override fun onBackPressed() {
        val sharedPreference = getSharedPreferences("SAVE_DATAs", Context.MODE_PRIVATE)
        val data = sharedPreference.getString("DATALIST", null)
//
//        intent.extras.getString("DataText")?.let {
//            val builder = AlertDialog.Builder(this)
//                        .setTitle("are you sure?")
//                        .setMessage("Do you want to Back or No Save Text?")
//                        .setPositiveButton("Yes") { dialog: DialogInterface?, which: Int ->
//                            finish()
//                        }
//                        .setNegativeButton("No") { dialog: DialogInterface?, which: Int ->
//                        }
//                        .show()
//        } ?: checkCreateNewNote()


        if (intent.extras.getString("DataText") != null) {
            val builder = AlertDialog.Builder(this)
                .setTitle("are you sure?")
                .setMessage("Do you want to Back or No Save Text?")
                .setPositiveButton("Yes") { dialog: DialogInterface?, which: Int ->
                    finish()
                }
                .setNegativeButton("No") { dialog: DialogInterface?, which: Int ->
                }
                .show()
        } else if (dataText.text.isNotEmpty()) {
            val builder = AlertDialog.Builder(this)
                .setTitle("are you sure?")
                .setMessage("Do you want to Back or No Save Text?")
                .setPositiveButton("Yes") { dialog: DialogInterface?, which: Int ->
                    finish()
                }
                .setNegativeButton("No") { dialog: DialogInterface?, which: Int ->
                }
                .show()
        } else {
            finish()
        }

    }

//    private fun checkCreateNewNote() {
//        if (dataText.text.isNotEmpty()) {
//            val builder = AlertDialog.Builder(this)
//                .setTitle("are you sure?")
//                .setMessage("Do you want to Back or No Save Text?")
//                .setPositiveButton("Yes") { dialog: DialogInterface?, which: Int ->
//                    finish()
//                }
//                .setNegativeButton("No") { dialog: DialogInterface?, which: Int ->
//                }
//                .show()
//        } else {
//            finish()
//        }
//    }

}
