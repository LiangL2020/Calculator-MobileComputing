package com.example.testapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class rename : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rename)


        //Yoko try
        val save = findViewById<Button>(R.id.back_main_rename)

        save.setOnClickListener {
            call_activity()
        }


//        val rename = findViewById<Button>(R.id.renameBNT)
//        rename.setOnClickListener(){
//            call_activity()
//        }
//        val save = findViewById<Button>(R.id.back_main_rename)
//        val user_input = findViewById<EditText>(R.id.rename_input)
//
//        save.setOnClickListener {
//            val intent = Intent(this, MainActivity::class.java).also {
//                val message = user_input.text.toString()
//                it.putExtra("user_input_rename", message)
//                startActivity(it)
//            }
//        }
    }

    private fun call_activity(){
        val calc_txt = findViewById<EditText>(R.id.rename_input)
        val message = calc_txt.text.toString()

        val intent = Intent(this, MainActivity::class.java).also {
            it.putExtra("user_input_rename", message)
            startActivity(it)
        }
    }
}