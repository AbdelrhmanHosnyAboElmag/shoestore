package com.example.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentShoeDetailBinding
import com.example.shoestore.model.Shoe
import com.example.shoestore.viewmodel.ShoeViewModel


class ShoeDetailFragment : Fragment() {
    private lateinit var viewModel: ShoeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]

        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false
        )

        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        binding.saveButton.setOnClickListener { view ->
            viewModel.shoedetail.observe(viewLifecycleOwner, Observer {
            view.findNavController()
               .navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
                viewModel.addInfo(it)

            })

        }

        return binding.root
    }


}