package com.udacoding.kotlinbasic3.presenter

import com.udacoding.kotlinbasic3.model.Model

class FisikaPresenter(val fisikaView: FisikaView) {


    fun fisikaLuas(panjang: String, lebar: String){
        val panjang = panjang.toDouble()
        val lebar = lebar.toDouble()

        val hasil = Model()
        hasil.hasil = panjang.times(lebar)

        fisikaView.bind(hasil)
    }

    fun fisikaVolume(panjang: String, lebar: String, tinggi: String){
        val panjang = panjang.toDouble()
        val lebar = lebar.toDouble()
        val tinggi = tinggi.toDouble()

        val hasil = Model()
        hasil.hasil = panjang.times(lebar).times(tinggi)

        fisikaView.bind(hasil)
    }

    interface FisikaView{
        fun bind(hasil: Model)
    }
}