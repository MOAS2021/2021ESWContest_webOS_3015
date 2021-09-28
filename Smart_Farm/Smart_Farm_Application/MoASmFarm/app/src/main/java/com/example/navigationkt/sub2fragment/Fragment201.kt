package com.example.navigationkt.sub2fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.navigationkt.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import kotlinx.android.synthetic.main.fragment_201.*

class Fragment201 : Fragment() {

    lateinit var storage: FirebaseStorage
    lateinit var navController1 : NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_201, container, false)



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val database = Firebase.database
        storage = Firebase.storage
        // [END storage_field_initialization]



        val myRef1 = database.getReference("Smartfarm").child("THS").child("t")

        myRef1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                var A = dataSnapshot.getValue<String>()
                temtext.setText(A)

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value

            }
        })

        val myRef2 = database.getReference("Smartfarm").child("THS").child("h")

        myRef2.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                var B = dataSnapshot.getValue<String>()
                humtext.setText(B)

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value

            }
        })

        val myRef3 = database.getReference("Smartfarm").child("THS").child("s")

        myRef3.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                var C = dataSnapshot.getValue<String>()
                soil1.setText(C)

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value

            }
        })



        navController1 = Navigation.findNavController(view)
        temtext.setOnClickListener {
            navController1.navigate(R.id.action_fragment201_to_fragment202)
        }


    }


}

