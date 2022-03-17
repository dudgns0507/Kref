package com.github.dudgns0507.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.github.dudgns0507.sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var prefs: PrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        prefs = PrefManager(this@MainActivity)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            lifecycleOwner = this@MainActivity

            loadPref()

            binding.btSavePref.setOnClickListener {
                prefs.kString = binding.etPref.text.toString()
                toast("Save Complete")

                loadPref()
            }
        }
    }

    private fun loadPref() {
        binding.tvPref.text = prefs.kString
    }
}