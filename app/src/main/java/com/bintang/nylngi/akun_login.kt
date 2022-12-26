package com.bintang.nylngi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.bintang.nylngi.data.NetworkConfig
import com.bintang.nylngi.data.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class akun_login : AppCompatActivity() {

    lateinit var ETemail : EditText
    lateinit var ETpassword : EditText
    lateinit var btnRegister : Button
    lateinit var btnmasuk : Button
    lateinit var btnlogin : Button





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_akun_login)

        ETemail = findViewById(R.id.etEmail) as EditText
        ETpassword = findViewById(R.id.etPass) as EditText
        btnmasuk = findViewById(R.id.btnMasuk) as Button
        btnlogin = findViewById(R.id.btn_login) as Button
        btnRegister = findViewById(R.id.btn_regis) as Button



        btnmasuk.setOnClickListener{
            if(ETemail.text.equals("") && ETpassword.text.equals("")){
                Toast.makeText(this, "data masih kosong", Toast.LENGTH_SHORT).show()
            }else{
                NetworkConfig().getService().Login(ETemail.text.toString(), ETpassword.text.toString()).enqueue(object  : Callback<User> {
                    override fun onResponse(call: Call<User>, response: Response<User>) {
                        try {
                            if (response!!.body()!!.code == 1){
                                startActivity(Intent(applicationContext,MainActivity::class.java))
                            }else{
                                Toast.makeText(applicationContext, "Password salah", Toast.LENGTH_SHORT).show()
                            }
                        }catch (e:java.lang.Exception){
                            e.printStackTrace()
                        }
                    }

                    override fun onFailure(call: Call<User>, t: Throwable) {
                        Toast.makeText(applicationContext, "no internet access", Toast.LENGTH_SHORT).show()
                    }

                })


            }
        }

        btnRegister.setOnClickListener {
            startActivity(Intent(applicationContext,akun_register::class.java))
        }

        btnlogin.setOnClickListener {
            startActivity(Intent(applicationContext,akun_login::class.java))
        }



    }
}