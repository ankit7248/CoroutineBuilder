@file:Suppress("UNREACHABLE_CODE")

package com.example.coroutinebuilder

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            val time = measureTimeMillis {
                printFollowers()
            }
            Log.d(TAG,"Request took $time ms.")

        }
    }
}
    private suspend fun printFollowers()
            {
            val job = CoroutineScope(Dispatchers.IO).async {
                getfbfollowers()
            }
            val job2 = CoroutineScope(Dispatchers.IO).async {
                getinstafollowers()
            }
            Log.d(TAG,"fb - ${job.await()} , Instagram - ${job2.await()}")
        }


private suspend fun getfbfollowers():Int{
    delay(1000)
    return 78

}private suspend fun getinstafollowers():Int{
    delay(1000)
    return 67
}
