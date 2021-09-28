package com.example.navigationkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.view.GravityCompat
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class HomeSecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_second)


    }

    override fun onBackPressed() {

        val database = Firebase.database
        val myRef = database.getReference("back")

        myRef.setValue("0")

        super.onBackPressed()
    }
}