package com.udacoding.kotlinbasic3.presenter

import com.udacoding.kotlinbasic3.model.Model
import kotlin.math.pow

class KonvertPresenter(val konView: KonView) {

    fun konvert(value: String, spinA: Int?, spinB: Int?){
        val value = value.toDouble()
        val spinA = spinA
        val spinB = spinB

        val hasil = Model()
        var spin = 0


        if (spinA!! < spinB!!){
            for (i in spinA+1..spinB){
                spin++
            }

            hasil.hasil = value / (10.0.pow(spin))
        }else if(spinA > spinB){
            for (i in spinB+1..spinA){
                spin++
            }

            hasil.hasil = value * (10.0.pow(spin))

        }else{
            hasil.hasil = value
        }

        konView.bind(hasil)
    }

    interface KonView{
        fun bind(hasil: Model)
    }
}