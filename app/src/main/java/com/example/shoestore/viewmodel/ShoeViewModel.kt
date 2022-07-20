package com.example.shoestore.viewmodel

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.model.Shoe

class ShoeViewModel : ViewModel() {
    val _shoedetail = MutableLiveData<Shoe>()
    val _handleshoelist = MutableLiveData<ArrayList<Shoe>>(arrayListOf<Shoe>())
    val handleshoelist: LiveData<ArrayList<Shoe>> get() = _handleshoelist
    val shoedetail: LiveData<Shoe> get() = _shoedetail

    init
    {
        _shoedetail.value = Shoe("lets walk shoe","nick","45","its for run")
    }
    fun addInfo(){
        _handleshoelist.value?.add(shoedetail.value!!.copy())
   }
}