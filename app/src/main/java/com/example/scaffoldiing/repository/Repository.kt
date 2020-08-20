package com.example.scaffoldiing.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.scaffoldiing.model.Teams
import com.example.scaffoldiing.service.RetrofitBuilder
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class Repository {

    private val mCompositeDisposable = CompositeDisposable()
    val teamDataSet = MutableLiveData<Teams>()

    fun getTeams(teamName: String): LiveData<Teams> {
        getTeamFromNetwork(teamName)
        return teamDataSet
    }

    private fun getTeamFromNetwork(teamName: String) {
        Log.d("make call", "make call")

        mCompositeDisposable.add(
            teamsObservable(teamName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, this::onError)
        )
    }

    private fun teamsObservable(teamName: String): Single<Teams> =
        RetrofitBuilder.teamEndpoint.getTeams(teamName)

    private fun onSuccess(team: Teams) {
        teamDataSet.value = team
        Log.d("success", "network call success")
    }

    private fun onError(e: Throwable) {
        Log.d("error", "error in  network call")
        Log.d("Error", e.message.toString())
    }

    companion object {
        fun newInstance() = Repository()
    }

    fun clearDisposable() {
        if (!mCompositeDisposable.isDisposed)
            mCompositeDisposable.dispose()
    }
}