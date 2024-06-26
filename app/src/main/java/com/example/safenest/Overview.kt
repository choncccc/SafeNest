package com.example.safenest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.safenest.databinding.FragmentOverviewBinding
class Overview : Fragment() {
    private lateinit var binding: FragmentOverviewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOverviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.OverviewCalendar.setOnClickListener {
            updateFragment(OverviewCalendar())
        }
        binding.OverviewDueDateCalcu.setOnClickListener {
            updateFragment(DueDateCalcu())
        }
        binding.OverviewBMI.setOnClickListener {
            updateFragment(bmiCalulator())
        }
        binding.OverviewAboutApp.setOnClickListener {
            updateFragment(InsideAboutApp())
        }
    }

    private fun updateFragment(fragment: Fragment) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}