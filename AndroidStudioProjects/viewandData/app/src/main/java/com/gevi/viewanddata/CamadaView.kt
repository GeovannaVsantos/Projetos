package com.gevi.viewanddata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CamadaView : ViewModel() {


    var cont = MutableLiveData<Int>(0)

    fun addNum () {
        cont.value = cont.value?.plus(1)
    }



}