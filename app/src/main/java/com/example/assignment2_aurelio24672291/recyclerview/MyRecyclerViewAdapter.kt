package com.example.assignment2_aurelio24672291.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment2_aurelio24672291.R
import com.example.assignment2_aurelio24672291.data.ResponseItem

class MyRecyclerViewAdapter(private val dataList: MutableList<ResponseItem> = mutableListOf(), private val navigationFunction: (ResponseItem) -> Unit) : RecyclerView.Adapter<ResponseItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResponseItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_restful_api_dev, parent, false)
        return ResponseItemViewHolder(view, navigationFunction = navigationFunction)
    }

    override fun onBindViewHolder(viewHolder: ResponseItemViewHolder, position: Int) {
        viewHolder.bind(dataList[position])
    }

    override fun getItemCount() = dataList.size

    fun setData(newDataList: List<ResponseItem>) {
        dataList.clear()
        dataList.addAll(newDataList)
        notifyDataSetChanged()
    }
}
