package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.models.ShoeViewModel
import androidx.fragment.app.activityViewModels
import com.udacity.shoestore.models.Shoe


class ShoeDetailFragment: Fragment() {

   // private val viewModel: ShoeViewModel
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        //Inflate layout for fragment
        val binding: ShoeDetailFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_detail_fragment, container, false)

        binding.vm = viewModel
        binding.shoe = Shoe("", 0.0, "", "")

        //WITH BINDING Listeners for confirm and cancel buttons
//        binding.confirmButton.setOnClickListener() {
        //TODO fix bug: Enters blank entry to shoe list is left empty
        //TODO Fix awkward use of keyboard, possibly with different layout container
        //TODO Justify use of Linear or Constraint Layout in each XML

        binding.cancelButton.setOnClickListener() {
            findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }

        return binding.root
    }
}