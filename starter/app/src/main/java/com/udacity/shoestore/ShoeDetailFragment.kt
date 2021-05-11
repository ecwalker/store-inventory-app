package com.udacity.shoestore

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.models.ShoeViewModel
import timber.log.Timber
import androidx.fragment.app.activityViewModels


class ShoeDetailFragment: Fragment() {

   // private val viewModel: ShoeViewModel
    private val viewModel: ShoeViewModel by activityViewModels()

    //Initialise editText entry variables
    private var name: String? = ""
    private var size: Double? = "0".toDouble()
    private var company: String? = ""
    private var desc: String? = ""


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        //Inflate layout for fragment
        val binding: ShoeDetailFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_detail_fragment, container, false)

        //Listeners for confirm and cancel buttons
        binding.confirmButton.setOnClickListener() {
            //TODO fix bug: crashes on click if left fields left empty
            name = binding.nameEditTextTextShort.text.toString()
            size = binding.shoeSizeEditTextNumber.text.toString().toDouble()
            company = binding.companyEditTextTextShort.text.toString()
            desc = binding.descriptionEditTextTextLong.text.toString()

            if (name == null || size == null || company == null || desc == null) {
                Toast.makeText(this.activity, "Please complete all fields", Toast.LENGTH_SHORT).show()
            }
            else {
                viewModel.updateLiveData(binding.nameEditTextTextShort.text.toString(),
                    binding.shoeSizeEditTextNumber.text.toString().toDouble(),
                    binding.companyEditTextTextShort.text.toString(),
                    binding.descriptionEditTextTextLong.text.toString())
            }



            //Possibly don't need this if you can manage to make shoes list in the viewModel
//            val newShoeIntent = Intent(this.activity, ShoeListFragment::class.java)
//            val bundle = Bundle()
//            val parcel = (viewModel.newShoeParcel.value)
//
//            bundle.putParcelable(name, parcel)
//            newShoeIntent.putExtra("Bundle", bundle)
//            startActivity(newShoeIntent)

            viewModel.AddShoe()
            findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }

        binding.cancelButton.setOnClickListener() {
            findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }

        return binding.root
    }
}