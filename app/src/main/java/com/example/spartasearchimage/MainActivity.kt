package com.example.spartasearchimage

import com.example.spartasearchimage.ui.search.SearchFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.spartasearchimage.databinding.ActivityMainBinding
import com.example.spartasearchimage.ui.storage.StorageFragment

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