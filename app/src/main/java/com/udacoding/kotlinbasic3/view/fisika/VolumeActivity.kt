package com.udacoding.kotlinbasic3.view.fisika

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.textfield.TextInputLayout
import com.udacoding.kotlinbasic3.R
import com.udacoding.kotlinbasic3.model.Model
import com.udacoding.kotlinbasic3.presenter.FisikaPresenter
import kotlinx.android.synthetic.main.activity_volume.*

class VolumeActivity : AppCompatActivity(), View.OnClickListener, FisikaPresenter.FisikaView {

    private var presenter: FisikaPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volume)


        presenter = FisikaPresenter(this)
        btn_submit_volume.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.btn_submit_volume){
            val panjang = edt_volume_panjang.editText?.text.toString().trim()
            val lebar = edt_volume_lebar.editText?.text.toString().trim()
            val tinggi = edt_volume_tinggi.editText?.text.toString().trim()

            errorField(edt_volume_panjang)
            errorField(edt_volume_lebar)
            errorField(edt_volume_tinggi)

            var isEmptyField = false

            when{
                panjang.isEmpty() -> {
                    isEmptyField = true
                    edt_volume_panjang.error = "Tidak boleh kosong"
                }

                lebar.isEmpty() -> {
                    isEmptyField = true
                    edt_volume_lebar.error = "Tidak boleh kosong"
                }

                tinggi.isEmpty() -> {
                    isEmptyField = true
                    edt_volume_lebar.error = "Tidak boleh kosong"
                }
            }

            if (!isEmptyField){
                presenter?.fisikaVolume(panjang, lebar, tinggi)
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
        tv_hasil_hitung_volume.text = "${hasil.toString()} m3"
    }
}