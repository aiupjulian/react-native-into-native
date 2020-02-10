package com.example.rntest

import android.app.Activity
import android.os.Bundle
import android.content.Intent
import com.facebook.soloader.SoLoader
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStartAnotherActivity.setOnClickListener {
            val intent = Intent(this, MyReactActivity::class.java)
            // start your next activity
            startActivity(intent)
        }
        SoLoader.init(this, /* native exopackage */ false)
    }
}
