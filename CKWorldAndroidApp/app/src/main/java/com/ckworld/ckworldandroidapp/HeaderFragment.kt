package com.ckworld.ckworldandroidapp

import com.ckworld.ckworldandroidapp.user.LoginActivity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment

class HeaderFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // header.xml 레이아웃을 인플레이트
        return inflater.inflate(R.layout.header, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // profileBtn 클릭 시 LoginActivity로 이동
        val profileBtn = view.findViewById<ImageView>(R.id.profileBtn)
        profileBtn.setOnClickListener {
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}