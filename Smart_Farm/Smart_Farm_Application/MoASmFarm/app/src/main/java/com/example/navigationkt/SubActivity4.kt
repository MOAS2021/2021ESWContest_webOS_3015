package com.example.navigationkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sub4.*

class SubActivity4 : AppCompatActivity() {

    lateinit var mWebView: WebView
    lateinit var mWebSettings: WebSettings



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub4)

        val database = Firebase.database
        val myRef = database.getReference("back")

        myRef.setValue("1")

        mWebView = findViewById<View>(R.id.WebView) as WebView


        mWebView.setWebViewClient(WebViewClient())
        mWebSettings = mWebView.getSettings()
        mWebSettings.setJavaScriptEnabled(true) // 웹페이지 자바스클비트 허용 여부

        mWebSettings.setSupportMultipleWindows(false) // 새창 띄우기 허용 여부

        mWebSettings.setJavaScriptCanOpenWindowsAutomatically(true) // 자바스크립트 새창 띄우기(멀티뷰) 허용 여부

        mWebSettings.setLoadWithOverviewMode(true) // 메타태그 허용 여부

        mWebSettings.setUseWideViewPort(true) // 화면 사이즈 맞추기 허용 여부

        mWebSettings.setSupportZoom(false) // 화면 줌 허용 여부

        mWebSettings.setBuiltInZoomControls(false) // 화면 확대 축소 허용 여

        mWebSettings.setCacheMode(WebSettings.LOAD_NO_CACHE) // 브라우저 캐시 허용 여부

        mWebSettings.setDomStorageEnabled(true) // 로컬저장소 허용 여부

        mWebView.loadUrl("http://192.168.0.66:8090/?action=stream") // 웹뷰에 표시할 라즈베리파이 주소, 웹뷰 시작

        section1.setOnClickListener {
            val database = Firebase.database
            val myRef = database.getReference("plant")

            myRef.setValue("7")
        }

        section2.setOnClickListener {
            val database = Firebase.database
            val myRef = database.getReference("plant")

            myRef.setValue("8")
        }

        section3.setOnClickListener {
            val database = Firebase.database
            val myRef = database.getReference("plant")

            myRef.setValue("9")
        }

        section4.setOnClickListener {
            val database = Firebase.database
            val myRef = database.getReference("plant")

            myRef.setValue("10")
        }

        btnHome.setOnClickListener {
            val database = Firebase.database
            val myRef = database.getReference("plant")

            myRef.setValue("19")
        }

        btnback.setOnClickListener {
            val database = Firebase.database
            val myRef = database.getReference("plant")

            myRef.setValue("19")

            val myRef1 = database.getReference("back")

            myRef1.setValue("0")
            super.onBackPressed()
        }



    }
    override fun onBackPressed() {

        val database = Firebase.database
        val myRef = database.getReference("cameramove")

        myRef.setValue("5")

        val myRef1 = database.getReference("back")

        myRef1.setValue("0")

        super.onBackPressed()
    }



}