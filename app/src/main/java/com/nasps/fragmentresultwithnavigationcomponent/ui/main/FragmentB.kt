package com.nasps.fragmentresultwithnavigationcomponent.ui.main

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.nasps.fragmentresultwithnavigationcomponent.databinding.FragmentBBinding

class FragmentB : Fragment() {

    private val binding get() =_binding!!
    private var _binding :FragmentBBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.button.setOnClickListener(View.OnClickListener {
            val result = binding.editTextTextPersonName.text.toString()
            navigateBackToFragmentA(result = result)
        })


    }


    private fun navigateBackToFragmentA(result: String) {

        val savedStateHandle = findNavController().previousBackStackEntry?.savedStateHandle
        savedStateHandle?.set(FragmentA.RESULT_FROM_FRAGMENT_B, result)
        findNavController().navigateUp()
    }


}