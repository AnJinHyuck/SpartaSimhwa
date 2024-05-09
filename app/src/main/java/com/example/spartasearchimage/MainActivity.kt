package com.example.spartasearchimage

import com.example.spartasearchimage.ui.SearchFragment
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.spartasearchimage.R
import com.example.spartasearchimage.databinding.ActivityMainBinding
import com.example.spartasearchimage.ui.StorageFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFragment(SearchFragment())

        binding.btnSearchImage.setOnClickListener {
            setFragment(SearchFragment())
        }
        binding.btnImageStorage.setOnClickListener {
            setFragment(StorageFragment())
        }
    }

    private fun setFragment(frag: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.frameLayout, frag)
            setReorderingAllowed(true)
            addToBackStack("")
        }

    }
}