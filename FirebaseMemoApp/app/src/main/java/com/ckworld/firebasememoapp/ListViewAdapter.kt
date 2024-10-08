package com.ckworld.firebasememoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListViewAdapter(val list: MutableList<DataModel>): BaseAdapter() {
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
        if (convertView == null) {
            convertView = LayoutInflater.from(p2?.context).inflate(R.layout.listview_item, p2, false)
        }
        val dateArea = convertView?.findViewById<TextView>(R.id.listViewDate)
        val memoArea = convertView?.findViewById<TextView>(R.id.listViewMemo)
        dateArea!!.text = list.get(p0).date
        memoArea!!.text = list.get(p0).memo
        return convertView!!
    }

}