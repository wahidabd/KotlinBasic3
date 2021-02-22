package com.udacoding.kotlinbasic3.view.konvert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.udacoding.kotlinbasic3.R
import com.udacoding.kotlinbasic3.model.Model
import com.udacoding.kotlinbasic3.presenter.KonvertPresenter
import kotlinx.android.synthetic.main.activity_konvert.*

class KonvertActivity : AppCompatActivity(), KonvertPresenter.KonView {

    private var presenter: KonvertPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_konvert)

        presenter = KonvertPresenter(this)

        submit_konvert.setOnClickListener{
            val value = edt_input_konvert.text.toString()
            val spinA = input_spinner.selectedItemId.toInt()
            val spinB = konvert_spinner.selectedItemId.toInt()

            presenter?.konvert(value, spinA, spinB)
        }
    }

    override fun bind(hasil: Model) {
        val hasil = hasil.hasil
        tv_hasil_konvert.text = "${hasil.toString()}"
    }
}