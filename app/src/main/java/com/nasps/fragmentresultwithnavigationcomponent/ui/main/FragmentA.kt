package com.nasps.fragmentresultwithnavigationcomponent.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.nasps.fragmentresultwithnavigationcomponent.databinding.FragmentABinding
import java.util.Observer


class FragmentA : Fragment() {

    private val binding get() = _binding!!

    private var _binding: FragmentABinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentABinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val currentBackStackEntry = findNavController().currentBackStackEntry
        val savedStateHandle = currentBackStackEntry?.savedStateHandle
        savedStateHandle?.getLiveData<String>(RESULT_FROM_FRAGMENT_B)
            ?.observe(currentBackStackEntry, androidx.lifecycle.Observer { s ->
                print(s)
                binding.textView.text = s

            })


        binding.button2.setOnClickListener(View.OnClickListener {

            navigateToFragmentB()
        })
    }

    private fun navigateToFragmentB() {


        val navDirection = FragmentADirections.actionFragmentAToFragmentB()
        findNavController().navigate(navDirection)
    }

    companion object {
        const val RESULT_FROM_FRAGMENT_B = "RESULT_FROM_FRAGMENT_B"
    }
}