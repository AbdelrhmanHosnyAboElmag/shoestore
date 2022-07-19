package com.example.shoestore.model

import android.os.Parcelable
import android.text.Editable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(var shoe_name:String, var company_name:String, var shoe_size:String, var description: String):Parcelable

