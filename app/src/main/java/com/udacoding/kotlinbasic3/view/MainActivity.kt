package com.udacoding.kotlinbasic3.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.udacoding.kotlinbasic3.R
import com.udacoding.kotlinbasic3.view.fisika.LuasActivity
import com.udacoding.kotlinbasic3.view.fisika.VolumeActivity
import com.udacoding.kotlinbasic3.view.konvert.KonvertActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_hitung_luas.setOnClickListener(this)
        btn_hitung_volume.setOnClickListener(this)
        btn_konversi.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            btn_hitung_luas-> {
                startActivity(Intent(this, LuasActivity::class.java))
            }

            btn_hitung_volume -> {
                startActivity(Intent(this, VolumeActivity::class.java))
            }


            btn_konversi -> {
                startActivity(Intent(this, KonvertActivity::class.java))
            }
        }
    }
}