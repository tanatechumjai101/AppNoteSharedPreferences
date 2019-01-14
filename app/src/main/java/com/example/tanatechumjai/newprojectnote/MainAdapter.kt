package com.example.tanatechumjai.newprojectnote

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_data.view.*
import android.support.v4.content.ContextCompat.startActivity



class MainAdapter(val context: Context ,
                  val Listdate: ArrayList<Data>

): RecyclerView.Adapter<MainAdapter.ViewHolder>(){
    override fun getItemCount(): Int {
        return Listdate.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.list_data,p0,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val data: Data = Listdate[p1]

         p0.itemView.txt1.text = data.index
         p0.itemView.txt2.text = data.data

         val dataindex = data.index.toString()
        val dataText = data.index.toString()


        p0.itemView.btnEdit.setOnClickListener {
            val intent = Intent(context, UpdateData::class.java)
            intent.putExtra("Index",dataindex)
            intent.putExtra("DataText",dataText)
            context?.startActivity(intent)
        }


    }

    class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){

    }
}