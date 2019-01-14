package com.example.tanatechumjai.newprojectnote

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_data.view.*


class ListNoteAdapter(
    val context: Context,
    val Listdate: ArrayList<Data>

) : RecyclerView.Adapter<ListNoteAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return Listdate.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.list_data, p0, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(view: ViewHolder, p1: Int) {
        val data: Data = Listdate[p1]

        view.itemView.txt1.text = data.index
        view.itemView.txt2.text = data.data

        view.itemView.btnEdit.setOnClickListener {
            val intent = Intent(context, EditorActivity::class.java)
            intent.putExtra("Index", view.itemView.txt1.text.toString())
            intent.putExtra("DataText", view.itemView.txt2.text.toString())
            context?.startActivity(intent)
        }


    }

    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

    }
}