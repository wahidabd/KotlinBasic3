package com.udacoding.kotlinbasic3.view.fisika

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.textfield.TextInputLayout
import com.udacoding.kotlinbasic3.R
import com.udacoding.kotlinbasic3.model.Model
import com.udacoding.kotlinbasic3.presenter.FisikaPresenter
import kotlinx.android.synthetic.main.activity_luas.*

class LuasActivity : AppCompatActivity(), View.OnClickListener, FisikaPresenter.FisikaView {

    private var presenter: FisikaPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_luas)

        presenter = FisikaPresenter(this)
        btn_submit_luas.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            btn_submit_luas -> {
                val panjang = edt_luas_panjang.editText?.text.toString().trim()
                val lebar = edt_luas_lebar.editText?.text.toString().trim()

                errorField(edt_luas_panjang)
                errorField(edt_luas_lebar)

                var isEmptyField = false

                when{
                    panjang.isEmpty() ->{
                        isEmptyField = true
                        edt_luas_panjang.error = "Tidak boleh kosong"
                    }

                    lebar.isEmpty() -> {
                        isEmptyField = true
                        edt_luas_lebar.error = "Tidak boleh kosong"
                    }
                }

                if(!isEmptyField){
                    presenter?.fisikaLuas(panjang, lebar)
                }
            }
        }
    }

    private fun errorField(s: TextInputLayout){
        if (s.editText?.text?.length != null){
            s.isErrorEnabled = false
        }
    }

    override fun bind(hasil: Model) {
        val hasil = hasil.hasil
        tv_hasil_hitung_luas.text = "${hasil.toString()} m2"
    }
}