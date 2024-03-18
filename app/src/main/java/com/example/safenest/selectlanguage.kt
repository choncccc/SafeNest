package com.example.safenest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.safenest.databinding.ActivitySelectLanguageBinding

class SelectLanguage : AppCompatActivity() {
    private lateinit var btnNext: Button
    private lateinit var bind : ActivitySelectLanguageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_language)
        bind = ActivitySelectLanguageBinding.inflate(layoutInflater)
        setContentView(bind.root)
        updateFragment(fragment_selectLanguage())

    }

    private fun updateFragment(fragment: Fragment) {
        val fragmentManage = supportFragmentManager
        val fragmentTransac = fragmentManage.beginTransaction()
        fragmentTransac.replace(R.id.frame_selectLang, fragment)
        fragmentTransac.commit()
    }
}