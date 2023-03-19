package org.techtown.kobb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter (val context: Context , val data:ArrayList<MenuVO>) : RecyclerView.Adapter<MenuAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val menu_num : TextView // 순번
        val menu_name: TextView  // 이름
        val menu_price: TextView  // 가격
        val menu_sort : TextView  // 카테고리
        val menu_status : TextView  // 메뉴 상태 (판매/품절)
        val menu_image : TextView // 메뉴 이미지

        init {
            menu_num = itemView.findViewById(R.id.inventory_num)
            menu_name = itemView.findViewById(R.id.menu_name)
            menu_price = itemView.findViewById(R.id.menu_price)
            menu_sort = itemView.findViewById(R.id.menu_sort)
            menu_status = itemView.findViewById(R.id.menu_status)
            menu_image = itemView.findViewById(R.id.menu_image)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.menu_list,parent,false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun getItemCount(): Int {
       return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.menu_num.setText(data.get(position).menu_num.toString())
        holder.menu_name.setText(data.get(position).menu_name)
        holder.menu_price.setText(data.get(position).menu_price.toString())
        holder.menu_sort.setText(data.get(position).menu_sort)
        holder.menu_status.setText(data.get(position).menu_status.toString())
        holder.menu_image.setText(data.get(position).menu_image.toString())
    }


}




