package com.udacity.shoestore.models

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class ShoeViewModel: ViewModel() {


    //LiveData variables for shoe list with encapsulation:
    //Shoe name
    private val _shoeName = MutableLiveData<String>()
    val shoeName: LiveData<String>
        get() = _shoeName
    //Shoe size
    private val _shoeSize = MutableLiveData<Double>()
    val shoeSize: LiveData<Double>
        get() = _shoeSize
    //Shoe company
    private val _shoeCompany = MutableLiveData<String>()
    val shoeCompany: LiveData<String>
        get() = _shoeCompany
    //Shoe description
    private val _shoeDesc = MutableLiveData<String>()
    val shoeDesc: LiveData<String>
        get() = _shoeDesc
    //New shoe parcel
    private val _newShoeInstance = MutableLiveData<Shoe>()
    val newShoeInstance: LiveData<Shoe>
        get() = _newShoeInstance

    //Shoe list
    private val _shoeList = MutableLiveData<MutableList<Shoe?>>()
    val shoeList: LiveData<MutableList<Shoe?>>
        get() = _shoeList

    init {
        Timber.i("ShoeViewModel initialised")
        _shoeName.value = "Name Example"
        _shoeSize.value = "0".toDouble()
        _shoeCompany.value = "Company Example"
        _shoeDesc.value = "Description Example"
        _shoeList.value = arrayListOf()
    }

    fun updateLiveData(name: String, size: Double, company: String, desc: String) {
        //TODO Need to handle null/no entry in each field
        //What about limiting the size of description?
        _shoeName.value = name
        _shoeSize.value = size
        _shoeCompany.value = company
        _shoeDesc.value = desc
        _newShoeInstance.value = Shoe(name, size, company, desc)
//        if (name == null | size == null | company == null | desc == null) {
//            Toast.makeText(lifeCycleOwner, "Please fill in all fields")
//        }
//        else {
//            _newShoeInstance.value = Shoe(name, size, company, desc)
//        }

    }

    fun AddShoe() {
        //For adding newShoeInstance to shoe_list
        Timber.i("AddShoe called")
        _shoeList.value?.add(_newShoeInstance.value)
    }
}