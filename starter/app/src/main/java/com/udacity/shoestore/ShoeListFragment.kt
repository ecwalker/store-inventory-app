package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.models.ShoeViewModel
import androidx.lifecycle.Observer
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ShoeListIterableBinding

class ShoeListFragment: Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        //Inflate layout for fragment
        val binding: ShoeListFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_list_fragment, container, false)

        binding.setLifecycleOwner(this)

        binding.floatingActionButton.setOnClickListener() {
            findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }


        //Observe the shoes (list) variable from the ShoeViewModel
        viewModel.shoeList.observe(viewLifecycleOwner, Observer { newShoeList ->
            for (shoe in newShoeList) {
                DataBindingUtil.inflate<ShoeListIterableBinding>( inflater, R.layout.shoe_list_iterable,
                    binding.shoeListDisplay, true).apply {
                    this.shoe = shoe
                }
            }
        })

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}