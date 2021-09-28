package com.example.navigationkt

import android.app.NotificationManager
import android.content.DialogInterface
import android.content.Intent
import android.app.NotificationChannel
import android.app.PendingIntent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.NotificationCompat
import android.content.Context
import android.os.Build
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.navigationkt.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.android.synthetic.main.activity_sub3.*
import kotlinx.android.synthetic.main.activity_sub5.*
import kotlinx.android.synthetic.main.fragment_201.*

class SubActivity5 : AppCompatActivity() {

    lateinit var A : String

    //lateinit var binding : ActivityMainBinding

    //val positiveButtonClick = { dialogInterface: DialogInterface, i: Int ->
      //  toast("Negative")
      //  val intent = Intent(this, SubActivity7::class.java)
     //   startActivity(intent)
   // }

 //   val negativeButtonClick = { dialogInterface: DialogInterface, i: Int -> toast("Negative") }

 //   val neutralButtonClick = { dialogInterface: DialogInterface, i: Int -> toast("Neutral") }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub5)


        /*binding = ActivityMainBinding.inflate(layoutInflater)

        btnpop.setOnClickListener {

            val builder = AlertDialog.Builder(this)

                .setTitle("안녕 ㅎㅎ")

                .setMessage("나도 안녕 ㅎㅎ")

                .setPositiveButton("긍정", positiveButtonClick)

                .setNegativeButton("부정", negativeButtonClick)

                .setNeutralButton("자연", neutralButtonClick)

                .setCancelable(false)

                .setIcon(R.drawable.cgc)

                .show()

        }*/

    }





   // fun toast(message:String){

     //   Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

   // }

}