package com.app.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {

            /// Periodic
            val work = PeriodicWorkRequest.Builder(MyWorker::class.java, 5, TimeUnit.SECONDS, 5, TimeUnit.SECONDS)
            val periodicWorkRequest: PeriodicWorkRequest = work.build()

            WorkManager.getInstance(this).enqueue(periodicWorkRequest)
            /// OneTime
/*

        var request: OneTimeWorkRequest = OneTimeWorkRequest.Builder(MyWorker::class.java).setInitialDelay(5, TimeUnit.MILLISECONDS)
            .build()
        WorkManager.getInstance().enqueue(request)
*/

    }
    }


}
