package com.example.recycle

import android.os.Bundle
import com.example.recycle.SetMyTime.DateCallback
import androidx.appcompat.app.AppCompatActivity
import com.example.recycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), DateCallback {
    var binding: ActivityMainBinding? = null
    private var currentCrime: Crime? = null
    private var isUpdate = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        binding!!.Date.setOnClickListener {
            val setMyTime = SetMyTime()
            setMyTime.show(supportFragmentManager, "设置时间")
        }
        val bundle = intent.extras
        if (bundle != null) {
            currentCrime = bundle["Crime"] as Crime?
        }
        if (currentCrime != null) {
            isUpdate = true
            binding!!.bigTitle.setText(currentCrime!!.bigtitle)
            binding!!.Date.text = currentCrime!!.date
            binding!!.checkBox.isChecked = currentCrime!!.isSolved
        }
    }

    override fun getDate(date: String?) {
        binding!!.Date.text = date
    }
}