package com.example.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )
        binding.loginButton.setOnClickListener {
            if (binding.emailEdittext.text.toString().trim()
                    .isNotEmpty() || binding.passwordEdittext.text.toString().trim().isNotEmpty()
            ) {
                it.findNavController()
                    .navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            }else{
                Toast.makeText(context, "please check input value", Toast.LENGTH_SHORT).show()
            }
        }
        binding.createButton.setOnClickListener {
            if (binding.emailEdittext.text.toString().trim()
                    .isNotEmpty() || binding.passwordEdittext.text.toString().trim().isNotEmpty()
            ) {
                it.findNavController()
                    .navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            }else{
                Toast.makeText(context, "please check input value", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }


}