package com.example.scaffoldiing.rocketviewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.scaffoldiing.model.Teams
import com.example.scaffoldiing.repository.Repository

class TeamViewmodel() : ViewModel() {

    private var teamLiveData = MutableLiveData<Teams>()
    private val repository = Repository.newInstance()

    fun getTeam(teamName: String): LiveData<Teams> {
        Log.d("viewmodel", "viewmodel")

        teamLiveData = repository.getTeams(teamName) as MutableLiveData<Teams>
        return teamLiveData
    }

    override fun onCleared() {
        super.onCleared()
        repository.clearDisposable()
    }

}