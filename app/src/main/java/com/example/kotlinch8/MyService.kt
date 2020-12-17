package com.example.kotlinch8

import android.app.Service
import android.content.Intent
import android.os.IBinder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyService : Service() {
    override fun onCreate() {
        super.onCreate()
        val scope = CoroutineScope(Dispatchers.Default)
        scope.launch {
            run1();
        }
    }
    private suspend fun run1(){
        try{
            delay(5000)
            var intent=Intent(this,MainActivity2::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        return START_STICKY
    }
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

}