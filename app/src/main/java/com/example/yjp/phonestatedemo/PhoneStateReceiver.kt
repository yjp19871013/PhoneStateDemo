package com.example.yjp.phonestatedemo

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.widget.Toast

class PhoneStateReceiver : BroadcastReceiver() {

    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    override fun onReceive(context: Context, intent: Intent) {
        val phoneState = intent.getStringExtra(TelephonyManager.EXTRA_STATE)
        when (phoneState) {
            TelephonyManager.EXTRA_STATE_RINGING ->
                Toast.makeText(context, "拨入电话,铃声响起", Toast.LENGTH_SHORT).show()
            TelephonyManager.EXTRA_STATE_OFFHOOK ->
                Toast.makeText(context, "通话中", Toast.LENGTH_SHORT).show()
            TelephonyManager.EXTRA_STATE_IDLE ->
                Toast.makeText(context, "挂断电话", Toast.LENGTH_SHORT).show()
            else -> return
        }
    }

}
