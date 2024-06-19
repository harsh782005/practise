package com.harsh.practise

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.harsh.practise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    var activityInterface: ActivityInterface? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        //   setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding?.btnChangeFragmentText?.setOnClickListener {
            activityInterface?.ChangeFragmentText("${binding?.edittext1?.text?.toString()}")
        }

    }

    fun changeActivityTextI(string: String) {
        binding?.btnChangeFragmentText?.setText(string.toString())
    }

}

