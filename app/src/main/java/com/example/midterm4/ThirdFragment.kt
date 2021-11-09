package com.example.midterm4

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.midterm4.databinding.FragmentThirdBinding
import java.util.*


/**
 * A simple [Fragment] subclass.
 * Use the [ThirdFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
            _binding = FragmentThirdBinding.inflate(inflater, container, false)
            val view = binding.root

            val nbNightsArg = requireArguments().getString("nb_nights_arg").toString()
            val arrivalDate = requireArguments().getString("arrival_date").toString()
                    binding.textviewThird.text = "We confirm your parking reservation from : " +
                            "\r\n" +
                            "${arrivalDate} " +
                            "\r\n" +
                            "For ${nbNightsArg} days"


            return view
    }

    override fun onDestroyView() {
         super.onDestroyView()
        _binding = null
    }
}
