package com.ckworld.lifequotesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListViewAdapter(val list: MutableList<String>): BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return list.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var convertView = p1
        if (convertView == null)
            convertView = LayoutInflater.from(p2?.context).inflate(R.layout.listview_item, p2, false)
        val id = convertView!!.findViewById<TextView>(R.id.listViewItem)
        id.text = list.get(p0)
//        val subId = convertView!!.findViewById<TextView>(R.id.listViewSubItem)
//        subId.text = list.get(p0).content
        return convertView!!
    }
}