package com.example.safenest
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.safenest.databinding.FragmentSecondTrimesterBinding


class SecondTrimester : Fragment() {
    private lateinit var binding: FragmentSecondTrimesterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding= FragmentSecondTrimesterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.weekThirteenDescrip.setOnClickListener{
           updateFragment(WeekThirteenDescrip())
        }
        binding.weekFourteenContents.setOnClickListener{
            updateFragment(WeekFourteenDescrip())
        }
        binding.weekFifteenContents.setOnClickListener{
            updateFragment(WeekFifteenDescrip())
        }
        binding.weekSixteenContents.setOnClickListener {
            updateFragment(WeekSixteenDescrip())
        }
        binding.weekSeventeenContents.setOnClickListener {
            updateFragment(WeekSeventeenDescrip())
        }
        binding.weekEighteenContents.setOnClickListener {
            updateFragment(WeekEighteenDescrip())
        }
        binding.weekNineteenContents.setOnClickListener {
            updateFragment(WeekNineteenDescrip())
        }
        binding.weekTwentyContents.setOnClickListener {
            updateFragment(WeekTwentyDescrip())
        }
        binding.weekTwentyOneContents.setOnClickListener {
            updateFragment(WeekTwentyOneDesctip())
        }
        binding.weekTwentyTwoContents.setOnClickListener {
            updateFragment(WeekTwentyTwoDescrip())
        }
        binding.weekTwentyThreeContents.setOnClickListener {
            updateFragment(WeekTwentyThreeDescrip())
        }
        binding.weekTwentyFourContents.setOnClickListener {
            updateFragment(WeekTwentyFourDescrip())
        }
        binding.weekTwentyFiveContents.setOnClickListener {
            updateFragment(WeekTwentyFiveDescrip())
        }
        binding.weekTwentySixContents.setOnClickListener {
            updateFragment(WeekTwentySixDescrip())
        }
        binding.weekTwentySevenContents.setOnClickListener {
            updateFragment(WeekTwentySevenDescrip())
        }
    }
    private fun updateFragment(fragment: Fragment) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.addToBackStack(null) // Add to back stack so the previous fragment can be restored
        fragmentTransaction.commit()
    }
}