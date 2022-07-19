package com.example.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentInstructionBinding
import com.example.shoestore.model.Shoe

class InstructionFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentInstructionBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_instruction, container, false)
        binding.letsStartButton.setOnClickListener { it.findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToShoeListFragment(Shoe("sda","asd","asd","sad"))) }
        return binding.root
    }

}