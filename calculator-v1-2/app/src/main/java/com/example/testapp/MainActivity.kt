package com.example.testapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // DEFINE COMPONENTS
    private lateinit var calc_txt: TextView
    private lateinit var b0: Button
    private lateinit var b1: Button
    private lateinit var b2: Button
    private lateinit var b3: Button
    private lateinit var b4: Button
    private lateinit var b5: Button
    private lateinit var b6: Button
    private lateinit var b7: Button
    private lateinit var b8: Button
    private lateinit var b9: Button
    private lateinit var bequal: Button
    private lateinit var bplus: Button
    private lateinit var bminus: Button
    private lateinit var bmul: Button
    private lateinit var bdiv: Button
    private lateinit var clear: Button
    private lateinit var del: ImageButton

    // DEFINE PARAMETERS
    var exp = ""
    var currInt = ""
    var ans = 0
    var lastOp = ""
    val activityTag = "activityTag"

    // ONCREATE; ACTION LISTENERS
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(activityTag, "in onCreate")

        // ASSIGN COMPONENTS TO ID
        calc_txt = findViewById(R.id.input) as TextView
        b0 = findViewById(R.id.button0)
        b1 = findViewById(R.id.button1)
        b2 = findViewById(R.id.button2)
        b3 = findViewById(R.id.button3)
        b4 = findViewById(R.id.button4)
        b5 = findViewById(R.id.button5)
        b6 = findViewById(R.id.button6)
        b7 = findViewById(R.id.button7)
        b8 = findViewById(R.id.button8)
        b9 = findViewById(R.id.button9)
        bequal = findViewById(R.id.buttonequal)
        bplus = findViewById(R.id.buttonplus)
        bminus = findViewById(R.id.buttonminus)
        bmul = findViewById(R.id.buttonmul)
        bdiv = findViewById(R.id.buttondiv)
        clear = findViewById(R.id.clear)
        del = findViewById(R.id.del)

        // SEND US TO RENAME ACTIVITY
        val renameBNT = findViewById<Button>(R.id.renameBNT)
        renameBNT.setOnClickListener{
            val intent = Intent(this, rename::class.java)
            startActivity(intent)
        }

        val message = intent.getStringExtra("user_input_rename")
        val display = findViewById<TextView>(R.id.displayName).apply {
            text = message
        }

        // ACTION LISTENERS FOR CALCULATOR BUTTONS
        b0.setOnClickListener{
            exp = exp + "0"
            currInt = currInt + "0"
            calc_txt.text = exp
            Log.i(activityTag, "button '0' pressed")
        }
        b1.setOnClickListener{
            exp = exp + "1"
            currInt = currInt + "1"
            calc_txt.text = exp
            Log.i(activityTag, "button '1' pressed")
        }
        b2.setOnClickListener{
            exp = exp + "2"
            currInt = currInt + "2"
            calc_txt.text = exp
            Log.i(activityTag, "button '2' pressed")
        }
        b3.setOnClickListener{
            exp = exp + "3"
            currInt = currInt + "3"
            calc_txt.text = exp
            Log.i(activityTag, "button '3' pressed")
        }
        b4.setOnClickListener{
            exp = exp + "4"
            currInt = currInt + "4"
            calc_txt.text = exp
            Log.i(activityTag, "button '4' pressed")
        }
        b5.setOnClickListener{
            exp = exp + "5"
            currInt = currInt + "5"
            calc_txt.text = exp
            Log.i(activityTag, "button '5' pressed")
        }
        b6.setOnClickListener{
            exp = exp + "6"
            currInt = currInt + "6"
            calc_txt.text = exp
            Log.i(activityTag, "button '6' pressed")
        }
        b7.setOnClickListener{
            exp = exp + "7"
            currInt = currInt + "7"
            calc_txt.text = exp
            Log.i(activityTag, "button '7' pressed")
        }
        b8.setOnClickListener{
            exp = exp + "8"
            currInt = currInt + "8"
            calc_txt.text = exp
            Log.i(activityTag, "button '8' pressed")
        }
        b9.setOnClickListener{
            exp = exp + "9"
            currInt = currInt + "9"
            calc_txt.text = exp
            Log.i(activityTag, "button '9' pressed")
        }
        bequal.setOnClickListener{
            checkLastOp()
            calc_txt.text = ans.toString()
            exp = ans.toString()
            currInt = ans.toString()
            lastOp = "="
            Log.i(activityTag, "expression evaluated")
        }
        bplus.setOnClickListener{
            checkLastOp()
            exp = exp + "+"
            currInt = ""
            lastOp = "+"
            calc_txt.text = exp
            Log.i(activityTag, "addition button pressed")
        }
        bminus.setOnClickListener{
            checkLastOp()
            exp = exp + "-"
            currInt = ""
            lastOp = "-"
            calc_txt.text = exp
            Log.i(activityTag, "subtraction button pressed")
        }
        bmul.setOnClickListener{
            checkLastOp()
            exp = exp + "*"
            currInt = ""
            lastOp = "*"
            calc_txt.text = exp
            Log.i(activityTag, "multiplication button pressed")
        }
        bdiv.setOnClickListener{
            checkLastOp()
            exp = exp + "/"
            currInt = ""
            lastOp = "/"
            calc_txt.text = exp
            Log.i(activityTag, "division button pressed")
        }
        clear.setOnClickListener{
            calc_txt.text = ""
            exp = ""
            currInt = ""
            ans = 0
            Log.i(activityTag, "evaluations cleared")
        }
        del.setOnClickListener{
            exp = exp.substring(0,exp.length-1)
            currInt = currInt.substring(0,currInt.length-1)
            calc_txt.text = exp
            Log.i(activityTag, "last input deleted")
        }
    }

    // SAVE PARAMETERS
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("ans", ans)
        outState.putString("exp", exp)
        outState.putString("currInt", currInt)
        outState.putString("lastOp", lastOp)
        Log.i(activityTag, "in onSaveInstanceState: saving states")
    }

    // RESTORE PARAMETERS
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        ans = savedInstanceState.getInt("ans", 0)
        currInt = savedInstanceState.getString("currInt", "")
        lastOp = savedInstanceState.getString("lastOp", "")
        exp = savedInstanceState.getString("exp", "")
        var textview = findViewById<TextView>(R.id.input)
        textview.text = exp
        Log.i(activityTag, "in onRestoreInstanceState: restoring states")
    }

    // CALCULATE AFTER OBTAINING TWO NUMBERS USING LAST OPERATOR PRESSED
    private fun checkLastOp(){
        if(lastOp == "+")
            ans = ans + currInt.toInt()
        else if(lastOp == "-")
            ans = ans - currInt.toInt()
        else if(lastOp == "*")
            ans = ans * currInt.toInt()
        else if(lastOp == "/")
            ans = ans / currInt.toInt()
        else
            ans = ans + currInt.toInt()
    }
}