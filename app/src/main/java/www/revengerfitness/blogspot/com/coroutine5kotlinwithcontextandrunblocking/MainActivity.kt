package www.revengerfitness.blogspot.com.coroutine5kotlinwithcontextandrunblocking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
/**
 *    |
 *    | io thread
 *    O ----O    ( context switching by withContext(Dispatchers.Main)
 *          |
 *          | main thread
 *          */
class MainActivity : AppCompatActivity() {
    private val TAG = "prashant chauhan"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            executeTask()
        }
    }

    private suspend fun executeTask() {
        Log.d(TAG, "before")
        /** GlobalScope.launch {// non blocking nature
        delay(1000)
        Log.d(TAG,"inside")
        }*/
        withContext(Dispatchers.IO) {//  blocking nature and suspend coroutine until it completed
            delay(1000)
            Log.d(TAG, "inside")

        }
        Log.d(TAG, "After")
    }
}