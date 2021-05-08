package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.InstructionFragmentBinding
import timber.log.Timber

class InstructionFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        //Inflate layout for fragment
        val binding: InstructionFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.instruction_fragment, container, false)

        binding.seeShoesButton.setOnClickListener() {
            findNavController().navigate(R.id.action_instructionFragment_to_shoeListFragment)
            Timber.i("See button onClickListener called")
        }

        return binding.root
    }
}