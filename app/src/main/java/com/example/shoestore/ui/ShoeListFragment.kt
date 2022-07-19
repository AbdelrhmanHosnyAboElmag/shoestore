package com.example.shoestore.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentShoeListBinding
import com.example.shoestore.model.Shoe
import com.example.shoestore.viewmodel.ShoeViewModel
import kotlinx.android.synthetic.main.fragment_shoe_list.*


class ShoeListFragment : Fragment() {
    lateinit var binding: FragmentShoeListBinding
    private lateinit var viewModel: ShoeViewModel
    private val args by navArgs<ShoeListFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[ShoeViewModel::class.java]
        viewModel.addInfo(args.shoeData)
        Log.d("test", args.shoeData.shoe_name)
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false
        )
        binding.sendToDetailFloatButton.setOnClickListener {
            it.findNavController()
                .navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }
        return binding.root
    }

    fun createAndView(
        shoename: String,
        shoesize: String,
        companyname: String,
        description: String
    ) {
        val shoe_name_tv = TextView(context)
        val shoe_size_tv = TextView(context)
        val company_name_tv = TextView(context)
        val description_tv = TextView(context)
        shoe_name_tv.text = shoename
        shoe_size_tv.text = shoesize
        company_name_tv.text = companyname
        description_tv.text = description
        binding.linearlayout.addView(shoe_name_tv)
        binding.linearlayout.addView(shoe_size_tv)
        binding.linearlayout.addView(company_name_tv)
        binding.linearlayout.addView(description_tv)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        val inflater = inflater
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.login_menu -> requireView().findNavController()
                .navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
        }
        return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.handleshoelist.observe(viewLifecycleOwner, Observer {
            Log.d("viewmodel:", "in")
            for (i in it) {
                Log.d("viewmodel:", i.shoe_name)
                createAndView(
                    i.shoe_name,
                    i.shoe_size,
                    i.company_name,
                    i.description
                )
            }
        })
    }

}