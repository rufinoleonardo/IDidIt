package com.rufino.ididit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)


        if(savedInstanceState == null){

            val homeFragment = HomeFragment()

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_fragment_container, homeFragment)
                commit()
            }
        }
    }
}