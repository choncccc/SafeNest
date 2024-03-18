package com.example.safenest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.safenest.databinding.ActivityHomeBinding
import com.example.safenest.databinding.FragmentReadingBinding


class home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        updateFragment(fragment_home())

        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> updateFragment(fragment_home())
                R.id.book -> updateFragment(ReadingFragment())
                else -> {
                }
            }
            true
        }

    }



    private fun updateFragment(fragment: Fragment) {
        val fragmentManage = supportFragmentManager
        val fragmentTransac = fragmentManage.beginTransaction()
        fragmentTransac.replace(R.id.frame_layout, fragment)
        fragmentTransac.commit()
    }
}