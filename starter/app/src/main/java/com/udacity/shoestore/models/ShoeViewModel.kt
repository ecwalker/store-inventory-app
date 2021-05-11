package com.udacity.shoestore.models

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import timber.log.Timber

class ShoeViewModel: ViewModel() {

    //Shoe list LiveData variable for shoe list with encapsulation:
    private val _shoeList = MutableLiveData<MutableList<Shoe?>>()
    val shoeList: LiveData<MutableList<Shoe?>>
        get() = _shoeList

    init {
        Timber.i("ShoeViewModel initialised")
        _shoeList.value = arrayListOf()
    }

    fun addShoe(v: View, shoe: Shoe) {
        //For adding new shoe instance to shoe_list
        Timber.i("AddShoe called")
        _shoeList.value?.add(shoe)
        navigateUp(v)
    }

    private fun navigateUp(v: View) {
        Timber.i("navigateUp called")
        v.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
    }
}