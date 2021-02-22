package com.udacoding.kotlinbasic3.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import com.udacoding.kotlinbasic3.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.btn_login) {
            val username = edt_username.editText?.text.toString().trim()
            val password = edt_password.editText?.text.toString().trim()

            errorField(edt_username)
            errorField(edt_password)

            var isEmptyField = false
            when{
                username.isEmpty() -> {
                    isEmptyField = true
                    edt_username.error = "Username tidak boleh kosong"
                }

                password.isEmpty() -> {
                    isEmptyField = true
                    edt_password.error = "Password tidak boleh kosong"
                }

                password.length < 6 -> {
                    isEmptyField = true
                    edt_password.error = "Password harus lebih dari 6 digit"
                }
            }

            if (!isEmptyField){
                if(username.equals("udacodingid") && password.equals("udacodingJaya2021") || username.equals("wahid") && password.equals("wahidun")){
                    showToast("Berhasil Login")
                    startActivity(Intent(this, MainActivity::class.java))
                }else{
                    showToast("Username atau Password Salah")
                }
            }
        }
    }

    private fun errorField(s: TextInputLayout){
        if(s.editText?.text?.length != null){
            s.isErrorEnabled = false
        }
    }

    fun showToast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}