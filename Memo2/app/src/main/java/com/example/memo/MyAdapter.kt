package com.example.memo

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_memo.view.*

class MyAdapter(val context : Context,
                val list : List<MemoEntity>) : RecyclerView.Adapter<MyAdapter.MyViewHolder> () {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_memo,parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val memo = list[position]

        holder.memo.text = memo.memo
        holder.root.setOnLongClickListener(object : View.OnLongClickListener {
            override fun onLongClick(v:View?):Boolean {

                return true
        }
        })
    }

    override fun getItemCount(): Int {

    }

    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val memo = itemView.textview_memo
        val root = itemView.root
    }



}