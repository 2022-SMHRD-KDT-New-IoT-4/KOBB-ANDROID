package org.techtown.kobb

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class InventoryAdapter(val context : Context, val data : ArrayList<InventoryVO>) : RecyclerView.Adapter<InventoryAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val invent_num : TextView // 순번
        val invent_name : TextView // 이름
        val invent_price : TextView // 가격
        val invent_stock :TextView  // 잔여수량
        val invent_partner : TextView // 거래처
        val invent_partNum : TextView // 거래처 연락처

        init {
            invent_name = itemView.findViewById(R.id.invent_name)
            invent_price = itemView.findViewById(R.id.invent_price)
            invent_stock = itemView.findViewById(R.id.invent_stock)
            invent_partner = itemView.findViewById(R.id.invent_partner)
            invent_partNum = itemView.findViewById(R.id.invent_partNum)
            invent_num = itemView.findViewById(R.id.invent_num)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.inventory_list,parent,false)
            val viewHolder = ViewHolder(view)
            return viewHolder
    }

    override fun getItemCount(): Int {
            return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.invent_num.setText(data.get(position).invent_num)
            holder.invent_name.setText(data.get(position).invent_name)
            holder.invent_price.setText(data.get(position).invent_price)
            holder.invent_stock.setText(data.get(position).invent_stock)
            holder.invent_partner.setText(data.get(position).invent_partner)
            holder.invent_partNum.setText(data.get(position).invent_partNum)
        Log.d("데이터 확인",data.get(position).invent_num)

    }


}
