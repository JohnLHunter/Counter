package com.example.myapplication

import android.os.Bundle
import android.content.Context
import kotlinx.android.synthetic.main.activity_main.*


import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var count: Long = 0
    fun getStore() = getPreferences(Context.MODE_PRIVATE)

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState != null){
            count = savedInstanceState.getLong(COUNTER_KEY,0)
        }
        myButton.setOnClickListener {
            count++
            counter.text = count.toString()


            myButton.text = when (count) {
                1L -> "stop"
                in 2..9 -> myButton.text.toString().plus("!")
                else -> myButton.text
            }
        }

    }

    override fun onPause()
    {
        super.onPause()
        getStore().edit().putLong(COUNTER_KEY, count).apply()
    }

    override fun onSaveInstanceState(outState: Bundle?){
        outState?.run{
            putLong(COUNTER_KEY, count)
        }
        super.onSaveInstanceState(outState)
    }

    companion object{
        private const val COUNTER_KEY = "counter"
    }






    }

