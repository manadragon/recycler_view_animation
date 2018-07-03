package com.eodeun.recyclerview_animation_01.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import android.widget.Toast
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.eodeun.recyclerview_animation_01.AnimationUtil
import com.eodeun.recyclerview_animation_01.Modal.Information
import com.eodeun.recyclerview_animation_01.R


class MyCustomAdapter(private val context: Context, private val data: ArrayList<Information>) : RecyclerView.Adapter<MyCustomAdapter.MyViewHolder>(){

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var textview = itemView.findViewById(R.id.txv_row) as TextView
    var imageView=itemView.findViewById(R.id.img_row) as ImageView
}

    private val inflater= LayoutInflater.from(context)
    private var previousPosition = 0

    override fun getItemCount(): Int {
       return data.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, position: Int): MyViewHolder {

        val view = inflater.inflate(R.layout.list_item_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(myViewHolder: MyViewHolder, position: Int) {

        myViewHolder.textview.setText(data[position].title)
        myViewHolder.imageView.setImageResource(data[position].imageId)

        if (position > previousPosition) { // We are scrolling DOWN
            AnimationUtil().animate(myViewHolder, true)

        } else { // We are scrolling UP

            AnimationUtil().animate(myViewHolder, false)
        }

        previousPosition = position
        val infoData = data[position]

        myViewHolder.imageView.setOnClickListener{
            Toast.makeText(context, "OnClick Called at position $position", Toast.LENGTH_SHORT).show()
            addItem(position, infoData)
        }
        myViewHolder.imageView.setOnLongClickListener{
            Toast.makeText(context, "OnLongClick Called at position $position", Toast.LENGTH_SHORT).show()

            removeItem(infoData)
            return@setOnLongClickListener true
        }

    }


    // This removes the data from our Dataset and Updates the Recycler View.
    private fun removeItem(infoData: Information) {
        val currPosition = data.indexOf(infoData)
        data.removeAt(currPosition)
        notifyItemRemoved(currPosition)
    }

    // This method adds(duplicates) a Object (item ) to our Data set as well as Recycler View.
    private fun addItem(position: Int, infoData: Information) {

        data.add(position, infoData)
        notifyItemInserted(position)
    }
}