package com.github.dudgns0507.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.github.dudgns0507.sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            lifecycleOwner = this@MainActivity

            loadPref()

            binding.btSavePref.setOnClickListener {
                PrefManager.instance.kString = binding.etPref.text.toString()
                toast("Save Complete")

                loadPref()
            }
        }
    }

    private fun loadPref() {
        binding.tvPref.text = PrefManager.instance.kString
    }
}