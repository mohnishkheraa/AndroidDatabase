package com.ltts.retestproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.signup_page.*
import kotlinx.android.synthetic.main.signup_page.view.*
import androidx.recyclerview.widget.LinearLayoutManager


class MainActivity : AppCompatActivity() {
    internal var db = Database(this)

    fun showToast(text: String){
        Toast.makeText(this@MainActivity, text, Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataInsert()
    }
    fun dataInsert() {
        btnRegister.setOnClickListener {
            try {
                db.insertData(signupUsername.text.toString(),signupPassword.text.toString(),
                    signupEmail.text.toString(),signupMobile.text.toString())
            }
            catch (e: Exception){
                e.printStackTrace()
                showToast(e.message.toString())
            }
        }
    }
    fun dataShow()
    {
        btnShowUsers.setOnClickListener{
            var myrv = findViewById<RecyclerView>(R.id.myrecyclerview)

            myrv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

            var myDatalist = ArrayList<Database>()
            myrv.adapter = MyAdapter(myDatalist)


        }


    }

}
