package com.example.mvvm_modelview

import android.app.Application
import android.os.CountDownTimer
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(application: Application, val text:String): AndroidViewModel(application) {
    val liveData = MutableLiveData<String>()

    init {
        startTimer()
    }

    fun startTimer(){
        object : CountDownTimer(11000, 1000){

            override fun onFinish() {
                Toast.makeText(getApplication(), text, Toast.LENGTH_SHORT).show()
            }

            override fun onTick(p0: Long) {
                liveData.value = (p0/1000).toString()
            }

        }.start()
    }

}