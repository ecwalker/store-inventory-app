package com.udacity.shoestore.models

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parceler
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(var name: String, var size: Double, var company: String, var description: String,
                val images: List<String> = mutableListOf()) : Parcelable {

//    private companion object: Parceler<ShoeParcel> {
//        override fun create(parcel: Parcel): ShoeParcel {
//            TODO("Not yet implemented")
//        }
//
//        override fun ShoeParcel.write(parcel: Parcel, flags: Int) {
//            TODO("Not yet implemented")
//        }
//    }
}