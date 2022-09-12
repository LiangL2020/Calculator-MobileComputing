package com.example.testapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class rename : AppCompatActivity() {

    // ONCREATE; ACTION LISTENER
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rename)

        // GO TO MAIN ACTIVITY (CALCULATOR)
        val save = findViewById<Button>(R.id.back_main_rename)
        save.setOnClickListener {
            call_main_calculator()
        }

        // REPLACE INPUT BOX TEXT WITH ORIGINAL TITLE
        val origMessage = intent.getStringExtra("display_name")
        val title = findViewById<TextView>(R.id.displayName)
        val inputBox = findViewById<EditText>(R.id.rename_input)
        inputBox.setText(origMessage)

    }

    // GO TO MAIN ACTIVITY (CALCULATOR)
    private fun call_main_calculator(){
        // FIND USER INPUT
        val replaceTxt = findViewById<EditText>(R.id.rename_input)
        val message = replaceTxt.text.toString()

        // GO BACK TO MAIN WITH USER INPUT
        val intent = Intent(this, MainActivity::class.java).also {
            it.putExtra("user_input_rename", message)
            startActivity(it)
        }
    }
}