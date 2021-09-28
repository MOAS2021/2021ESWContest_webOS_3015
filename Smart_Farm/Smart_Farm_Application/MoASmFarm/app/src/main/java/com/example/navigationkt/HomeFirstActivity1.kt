package com.example.navigationkt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home_first1.*

class HomeFirstActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_first1)

        mainmenubtn1.setOnClickListener {
            val nextIntent = Intent(this, SubActivity::class.java)
            startActivity(nextIntent)
        }

        mainmenubtn2.setOnClickListener {
            val nextIntent = Intent(this, SubActivity2::class.java)
            startActivity(nextIntent)
        }

        mainmenubtn3.setOnClickListener {
            val nextIntent = Intent(this, SubActivity4::class.java)
            startActivity(nextIntent)
        }

        mainmenubtn4.setOnClickListener {
            val nextIntent = Intent(this, SubActivity6::class.java)
            startActivity(nextIntent)
        }

        mainmenubtn5.setOnClickListener {
            val nextIntent = Intent(this, SubActivity7::class.java)
            startActivity(nextIntent)
        }

    }

}