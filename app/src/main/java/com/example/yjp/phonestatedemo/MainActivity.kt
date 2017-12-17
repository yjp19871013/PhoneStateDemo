package com.example.yjp.phonestatedemo

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.telephony.PhoneStateListener
import android.telephony.TelephonyManager
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tm = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        tm.listen(phoneListener, PhoneStateListener.LISTEN_CALL_STATE)
    }

    inner private class PhoneListener : PhoneStateListener() {

        private var previousState = TelephonyManager.CALL_STATE_IDLE

        override fun onCallStateChanged(state: Int, incomingNumber: String?) {
            super.onCallStateChanged(state, incomingNumber)

            when (state) {
                TelephonyManager.CALL_STATE_RINGING ->
                    Toast.makeText(this@MainActivity,
                            "拨入电话,铃声响起", Toast.LENGTH_SHORT).show()
                TelephonyManager.CALL_STATE_OFFHOOK ->
                    Toast.makeText(this@MainActivity,
                            "通话中", Toast.LENGTH_SHORT).show()
                TelephonyManager.CALL_STATE_IDLE ->
                    if (previousState != TelephonyManager.CALL_STATE_IDLE) {
                        Toast.makeText(this@MainActivity,
                                "挂断电话", Toast.LENGTH_SHORT).show()
                    }
                else -> return
            }

            previousState = state
        }
    }

    private val phoneListener = PhoneListener()
}
