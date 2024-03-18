package com.example.safenest

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast

class fragment_selectLanguage : Fragment() {
    private lateinit var btnNext: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_select_language, container, false)
        val spinner = view.findViewById<Spinner>(R.id.languageSpinner)
        btnNext = view.findViewById<Button>(R.id.btnNext)
        val languages = arrayOf("English", "Filipino") // Replace with your languages array

        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_items, languages)
        arrayAdapter.setDropDownViewResource(R.layout.dropdown_items) // Set the custom layout for dropdown items
        spinner.adapter = arrayAdapter


        btnNext.setOnClickListener {
            val intent = Intent(activity, enter_name::class.java)
            startActivity(intent)
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long,
            ) {
                // Handle spinner item selection here
                Toast.makeText(
                    requireContext(),
                    "Selected language is: ${languages[position]}",
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }

        return view
    }

}

