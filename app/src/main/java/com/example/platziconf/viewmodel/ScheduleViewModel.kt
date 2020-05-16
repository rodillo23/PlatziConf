package com.example.platziconf.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.platziconf.model.Conference
import com.example.platziconf.network.Callback
import com.example.platziconf.network.FirestoreService
import java.lang.Exception

class ScheduleViewModel : ViewModel() {
    val firestoreService = FirestoreService()
    var scheduleList : MutableLiveData<List<Conference>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh(){
        getScheduleFromFirestore()
    }

    fun getScheduleFromFirestore(){
        firestoreService.getSchedule(object : Callback<List<Conference>>{
            override fun onSucces(result: List<Conference>?) {
                scheduleList.postValue(result)
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }

        })
    }

    fun processFinished(){
        isLoading.value = true
    }
}