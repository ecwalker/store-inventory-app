package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.udacity.shoestore.databinding.InstructionFragmentBinding
import com.udacity.shoestore.databinding.ShoeListFragmentBinding

class ShoeListFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        //Inflate layout for fragment
        val binding: ShoeListFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_list_fragment, container, false)

        //binding.continueButton.setOnClickListener() {
        //findNavController().navigate(R.id)
        //}

        return binding.root
    }
}