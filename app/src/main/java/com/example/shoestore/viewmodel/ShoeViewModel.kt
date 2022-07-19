package com.example.shoestore.viewmodel

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.model.Shoe

class ShoeViewModel : ViewModel() {
    val _shoedetail = MutableLiveData<Shoe>()
    val _handleshoelist = MutableLiveData<MutableList<Shoe>>()
    val handleshoelist: LiveData<MutableList<Shoe>> get() = _handleshoelist
    val shoedetail: LiveData<Shoe> get() = _shoedetail

    init
    {
        _shoedetail.value = Shoe("lets walk shoe","nick","45","its for run")
    }
    fun addInfo(shoe:Shoe){
var list=_handleshoelist.value
        list?.add(shoe)
    _handleshoelist.value=list!!
    }
}