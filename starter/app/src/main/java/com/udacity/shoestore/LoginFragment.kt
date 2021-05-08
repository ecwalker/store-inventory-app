package com.udacity.shoestore

import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.login_fragment.view.*
import androidx.databinding.DataBindingUtil
import com.udacity.shoestore.databinding.LoginFragmentBinding

/*
Fragment where users login in or sign up
 */

class LoginFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        //Inflate layout for fragment
        val binding: LoginFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.login_fragment, container, false)

        binding.signUpButton.setOnClickListener() {
            findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
        }

        binding.signInButton.setOnClickListener() {
            findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
        }

        return binding.root
    }
}
