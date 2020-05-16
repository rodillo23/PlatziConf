package com.example.platziconf.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.platziconf.model.Speaker
import com.example.platziconf.network.Callback
import com.example.platziconf.network.FirestoreService
import java.lang.Exception

class SpeakersViewModel : ViewModel() {
    val firestoreService = FirestoreService()
    var speakersList : MutableLiveData<List<Speaker>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh(){
        getSpeakersFromFirestore()
    }

    fun getSpeakersFromFirestore(){
        firestoreService.getSpeakers(object : Callback<List<Speaker>>{
            override fun onSucces(result: List<Speaker>?) {
                speakersList.postValue(result)
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