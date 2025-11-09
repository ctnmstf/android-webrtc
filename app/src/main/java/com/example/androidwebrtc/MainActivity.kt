package com.example.androidwebrtc

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.example.androidwebrtc.databinding.ActivityStartBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding
    val db = Firebase.firestore
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Constants.isIntiatedNow = true
        Constants.isCallEnded = true

        binding.startMeeting.setOnClickListener {
            if (binding.meetingId.text.toString().trim().isNullOrEmpty())
                binding.meetingId.error = "Please enter meeting id"
            else {
                db.collection("calls")
                    .document(binding.meetingId.text.toString())
                    .get()
                    .addOnSuccessListener {
                        if (it["type"]=="OFFER" || it["type"]=="ANSWER" || it["type"]=="END_CALL") {
                            binding.meetingId.error = "Please enter new meeting ID"
                        } else {
                            val intent = Intent(this@MainActivity, RTCActivity::class.java)
                            intent.putExtra("meetingID",binding.meetingId.text.toString())
                            intent.putExtra("isJoin",false)
                            startActivity(intent)
                        }
                    }
                    .addOnFailureListener {
                        binding.meetingId.error = "Please enter new meeting ID"
                    }
            }
        }
        binding.joinMeeting.setOnClickListener {
            if (binding.meetingId.text.toString().trim().isNullOrEmpty())
                binding.meetingId.error = "Please enter meeting id"
            else {
                db.collection("calls")
                    .document(binding.meetingId.text.toString())
                    .get()
                    .addOnSuccessListener {
                        if(it.data.isNullOrEmpty()) {
                            binding.meetingId.error = "Please enter valid meeting ID"
                        } else {
                            val intent = Intent(this@MainActivity, RTCActivity::class.java)
                            intent.putExtra("meetingID",binding.meetingId.text.toString())
                            intent.putExtra("isJoin",true)
                            startActivity(intent)
                        }
                    }
                    .addOnFailureListener {
                        binding.meetingId.error = "Please enter valid meeting ID"
                    }
            }
        }
    }
}