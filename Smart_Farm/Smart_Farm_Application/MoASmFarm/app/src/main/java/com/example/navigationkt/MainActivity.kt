package com.example.navigationkt

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.navigationkt.Homefragment.Leftsidefragment
import com.example.navigationkt.Homefragment.MainHomefragment
import com.example.navigationkt.Homefragment.Rightsidefragment
import com.example.navigationkt.databinding.ActivityMainBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.core.Tag
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener {  //네비게이션뷰를 같이


    lateinit var mainhomefragment: MainHomefragment
    lateinit var leftsidefragment: Leftsidefragment
    lateinit var rightsidefragment: Rightsidefragment
    lateinit var A : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = Firebase.database
        // [END storage_field_initialization]



        val myRef1 = database.getReference("back")

        myRef1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                A = dataSnapshot.getValue<String>().toString()

                if (A == "1"){
                    notification1()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value

            }
        })

        val myRef2 = database.getReference("back")

        myRef2.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                A = dataSnapshot.getValue<String>().toString()

                if (A == "2"){
                    notification2()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value

            }
        })

        val myRef3 = database.getReference("back")

        myRef3.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                A = dataSnapshot.getValue<String>().toString()

                if (A == "3"){
                    notification3()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value

            }
        })

        val myRef4 = database.getReference("back")

        myRef4.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                A = dataSnapshot.getValue<String>().toString()

                if (A == "4"){
                    notification4()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value

            }
        })

        val myRef5 = database.getReference("back")

        myRef5.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                A = dataSnapshot.getValue<String>().toString()

                if (A == "5"){
                    notification5()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value

            }
        })



        mybottomnav.setOnNavigationItemSelectedListener(onBottomNavItemSelectedListener)

        mainhomefragment = MainHomefragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.fragment_frame, mainhomefragment).commit()




        btn_navi.setOnClickListener{

            layout_drawer.openDrawer(GravityCompat.START)
        }

        btn_setting.setOnClickListener {
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
        }

        naviView.setNavigationItemSelectedListener(this) // 네비게이션 메뉴 아이템 클릭 시 수행

    }

    private val onBottomNavItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener{

        when(it.itemId){
            R.id.homebutton -> {
                mainhomefragment = MainHomefragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragment_frame, mainhomefragment).commit()
            }
            R.id.leftbutton -> {
                leftsidefragment = Leftsidefragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragment_frame, leftsidefragment).commit()
            }
            R.id.rightbutton -> {
                rightsidefragment = Rightsidefragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragment_frame, rightsidefragment).commit()
            }
        }
        true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean { //네비게이션 메뉴 아이템 클릭 시 수행

        when (item.itemId){    //메뉴 아이디
            R.id.menu1 -> {
                val intent = Intent(this, SubActivity::class.java)
                startActivity(intent)
            }
            R.id.menu2 -> {
                val intent = Intent(this, SubActivity2::class.java)
                startActivity(intent)
            }
            R.id.menu3 -> {
                val intent = Intent(this, SubActivity3::class.java)
                startActivity(intent)
            }
            R.id.menu4 -> {
                val intent = Intent(this, SubActivity4::class.java)
                startActivity(intent)
            }
            R.id.menu5 -> {
                val intent = Intent(this, SubActivity5::class.java)
                startActivity(intent)
            }
            R.id.menu6 -> {
                val intent = Intent(this, SubActivity6::class.java)
                startActivity(intent)
            }
            R.id.menu7 -> {
                val intent = Intent(this, SubActivity7::class.java)
                startActivity(intent)
            }

        }

        layout_drawer.closeDrawers() //네비게이션 뷰 닫기
        return false

    }
    //백버튼을 눌렀을 때 수행하는 메소드
    override fun onBackPressed() {

        if(layout_drawer.isDrawerOpen(GravityCompat.START)){
            layout_drawer.closeDrawers()
        }
        else{
            //super.onBackPressed() //일반 백버튼 실행
            ActivityCompat.finishAffinity(this); // 액티비티를 종료하고
            System.exit(0); // 프로세스를 종료
        }

    }

    fun notification1 () {
        var builder = NotificationCompat.Builder(this, "MY_channel")
            .setSmallIcon(R.drawable.ic_baseline_notifications_none_24)
            .setContentTitle("첫번째 칸의 식물이 시들기 시작했어요")
            .setContentText("앱을 통해 확인해주세요!!")

        var intent2= Intent(this, SubActivity4::class.java)
        var paddingIntent2 = PendingIntent.getActivity(this, 0, intent2, 0)

        var intent1= Intent(this, SubActivity4::class.java)
        intent1.putExtra("data1","데이터 보낸다.")
        intent1.putExtra("data2","1002")
        var paddingIntent1 = PendingIntent.getActivity(this, 0, intent1, PendingIntent.FLAG_UPDATE_CURRENT)

        builder.setContentIntent(paddingIntent1)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { // 오레오 버전 이후에는 알림을 받을 때 채널이 필요
            val channel_id = "MY_channel" // 알림을 받을 채널 id 설정
            val channel_name = "채널이름" // 채널 이름 설정
            //val descriptionText = "설명글" // 채널 설명글 설정
            val importance = NotificationManager.IMPORTANCE_DEFAULT // 알림 우선순위 설정
            val channel = NotificationChannel(channel_id, channel_name, importance)

            // 만든 채널 정보를 시스템에 등록
            val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)

            // 알림 표시: 알림의 고유 ID(ex: 1002), 알림 결과
            notificationManager.notify(1002, builder.build())
        }
    }

    fun notification2 () {
        var builder = NotificationCompat.Builder(this, "MY_channel")
            .setSmallIcon(R.drawable.ic_baseline_notifications_none_24)
            .setContentTitle("두번째 칸의 식물이 시들기 시작했어요")
            .setContentText("앱으로 돌아와 확인해주세요!!")

        var intent2= Intent(this, SubActivity4::class.java)
        var paddingIntent2 = PendingIntent.getActivity(this, 0, intent2, 0)

        var intent1= Intent(this, SubActivity4::class.java)
        intent1.putExtra("data1","데이터 보낸다.")
        intent1.putExtra("data2","1002")
        var paddingIntent1 = PendingIntent.getActivity(this, 0, intent1, PendingIntent.FLAG_UPDATE_CURRENT)

        builder.setContentIntent(paddingIntent1)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { // 오레오 버전 이후에는 알림을 받을 때 채널이 필요
            val channel_id = "MY_channel" // 알림을 받을 채널 id 설정
            val channel_name = "채널이름" // 채널 이름 설정
            //val descriptionText = "설명글" // 채널 설명글 설정
            val importance = NotificationManager.IMPORTANCE_DEFAULT // 알림 우선순위 설정
            val channel = NotificationChannel(channel_id, channel_name, importance)

            // 만든 채널 정보를 시스템에 등록
            val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)

            // 알림 표시: 알림의 고유 ID(ex: 1002), 알림 결과
            notificationManager.notify(1003, builder.build())
        }
    }

    fun notification3 () {
        var builder = NotificationCompat.Builder(this, "MY_channel")
            .setSmallIcon(R.drawable.ic_baseline_notifications_none_24)
            .setContentTitle("세번째 칸의 식물이 시들기 시작했어요")
            .setContentText("앱에서 확인해주세요!!")

        var intent2= Intent(this, SubActivity4::class.java)
        var paddingIntent2 = PendingIntent.getActivity(this, 0, intent2, 0)

        var intent1= Intent(this, SubActivity4::class.java)
        intent1.putExtra("data1","데이터 보낸다.")
        intent1.putExtra("data2","1002")
        var paddingIntent1 = PendingIntent.getActivity(this, 0, intent1, PendingIntent.FLAG_UPDATE_CURRENT)

        builder.setContentIntent(paddingIntent1)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { // 오레오 버전 이후에는 알림을 받을 때 채널이 필요
            val channel_id = "MY_channel" // 알림을 받을 채널 id 설정
            val channel_name = "채널이름" // 채널 이름 설정
            //val descriptionText = "설명글" // 채널 설명글 설정
            val importance = NotificationManager.IMPORTANCE_DEFAULT // 알림 우선순위 설정
            val channel = NotificationChannel(channel_id, channel_name, importance)

            // 만든 채널 정보를 시스템에 등록
            val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)

            // 알림 표시: 알림의 고유 ID(ex: 1002), 알림 결과
            notificationManager.notify(1004, builder.build())
        }
    }

    fun notification4 () {
        var builder = NotificationCompat.Builder(this, "MY_channel")
            .setSmallIcon(R.drawable.ic_baseline_notifications_none_24)
            .setContentTitle("두번째 칸의 식물이 시들기 시작했어요")
            .setContentText("상태를 확인하러 와주세요!!")

        var intent2= Intent(this, SubActivity4::class.java)
        var paddingIntent2 = PendingIntent.getActivity(this, 0, intent2, 0)

        var intent1= Intent(this, SubActivity4::class.java)
        intent1.putExtra("data1","데이터 보낸다.")
        intent1.putExtra("data2","1002")
        var paddingIntent1 = PendingIntent.getActivity(this, 0, intent1, PendingIntent.FLAG_UPDATE_CURRENT)

        builder.setContentIntent(paddingIntent1)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { // 오레오 버전 이후에는 알림을 받을 때 채널이 필요
            val channel_id = "MY_channel" // 알림을 받을 채널 id 설정
            val channel_name = "채널이름" // 채널 이름 설정
            //val descriptionText = "설명글" // 채널 설명글 설정
            val importance = NotificationManager.IMPORTANCE_DEFAULT // 알림 우선순위 설정
            val channel = NotificationChannel(channel_id, channel_name, importance)

            // 만든 채널 정보를 시스템에 등록
            val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)

            // 알림 표시: 알림의 고유 ID(ex: 1002), 알림 결과
            notificationManager.notify(1005, builder.build())
        }
    }

    fun notification5 () {
        var builder = NotificationCompat.Builder(this, "MY_channel")
            .setSmallIcon(R.drawable.ic_baseline_notifications_none_24)
            .setContentTitle("물통에 물이 부족해요.. 물좀 주세요")
            .setContentText("물통 확인하기!")

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { // 오레오 버전 이후에는 알림을 받을 때 채널이 필요
            val channel_id = "MY_channel" // 알림을 받을 채널 id 설정
            val channel_name = "채널이름" // 채널 이름 설정
            //val descriptionText = "설명글" // 채널 설명글 설정
            val importance = NotificationManager.IMPORTANCE_DEFAULT // 알림 우선순위 설정
            val channel = NotificationChannel(channel_id, channel_name, importance)

            // 만든 채널 정보를 시스템에 등록
            val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)

            // 알림 표시: 알림의 고유 ID(ex: 1002), 알림 결과
            notificationManager.notify(1006, builder.build())
        }
    }

}



