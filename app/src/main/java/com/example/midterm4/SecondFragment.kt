package com.example.midterm4

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.example.midterm4.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val MONTHS =
            arrayOf("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")

        binding.buttonSecond.setOnClickListener {
            val reservationMonth = MONTHS[binding.datePicker.month]
            val arrivalDate = "$reservationMonth ${binding.datePicker.dayOfMonth} ${binding.datePicker.year}"

            val bundle = bundleOf("nb_nights_arg" to binding.editTextTextPersonName.text.toString().trim(),
                                         "arrival_date" to arrivalDate)

            Navigation.findNavController(binding.root).navigate(R.id.action_SecondFragment_to_ThirdFragment, bundle )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


