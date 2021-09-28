package com.example.navigationkt.sub1fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.navigationkt.HomeFirstActivity1
import com.example.navigationkt.MainActivity
import com.example.navigationkt.R
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_103.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class Fragment103 : Fragment() {




    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_103, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var now = LocalDate.now()

        var Strnow = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"))

        var Mixnow = now.plusDays(45)

        var Strnow1 = Mixnow.format(DateTimeFormatter.ofPattern("yyyy"))
        var Strnow2 = Mixnow.format(DateTimeFormatter.ofPattern("MM"))
        var Strnow3 = Mixnow.format(DateTimeFormatter.ofPattern("dd"))
        var Strnow4 = Mixnow.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"))

        fns1.setText(Strnow4)

        val database = Firebase.database

        val myRef = database.getReference("yyyy")

        myRef.setValue(Strnow1)

        val myReff = database.getReference("mm")

        myReff.setValue(Strnow2)

        val myRefff = database.getReference("dd")

        myRefff.setValue(Strnow3)

        val myReffff = database.getReference("ymd")

        myReffff.setValue(Strnow4)

        val myRef2 = database.getReference("plantname")

        myRef2.setValue("상추를")

        val myRef3 = database.getReference("Smartfarm").child("plantNumber")

        myRef3.setValue("1")

        val myRef4 = database.getReference("remember")

        myRef4.setValue("1")

        //btn_back.setOnClickListener {
            //val intent = Intent(getActivity(), MainActivity::class.java)
            //startActivity(intent)
        //}

    }


}

//fun main() {
//
//    val dateFormat = SimpleDateFormat("yyyyMMdd")
//
//    val startDate = dateFormat.parse("20200425").time
//    val endDate = dateFormat.parse("20250425").time
//    val today = Calendar.getInstance().apply {
//        set(Calendar.HOUR_OF_DAY, 0)
//        set(Calendar.MINUTE, 0)
//        set(Calendar.SECOND, 0)
//        set(Calendar.MILLISECOND, 0)
//    }.time.time
//
//
//    println("두 날짜간의 차이(일) : ${(endDate - startDate) / (24 * 60 * 60 * 1000)}")
//    println("시작일 부터 경과 일 : ${(today - startDate) / (24 * 60 * 60 * 1000)}")
//    println("목표일 까지 남은 일(D-DAY) : ${(endDate - today) / (24 * 60 * 60 * 1000)}")
//
//}