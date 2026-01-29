package com.sharom.wmsqr.data.util

import android.content.Context
import android.media.SoundPool
import com.sharom.wmsqr.R

class SoundManager(context: Context) {

    private val soundPool = SoundPool.Builder()
        .setMaxStreams(3)
        .build()

    private val scanSound = soundPool.load(context, R.raw.beep_sound, 1)
    private val okSound = soundPool.load(context, R.raw.beep_ok, 1)
    private val warnSound = soundPool.load(context, R.raw.beep_warn, 1)

    fun playScanSound() {
        soundPool.play(scanSound, 1f, 1f, 1, 0, 1f)
    }

    fun playOkSound() {
        soundPool.play(okSound, 1f, 1f, 1, 0, 1f)
    }

    fun playWarn() {
        soundPool.play(warnSound, 1f, 1f, 1, 0, 1f)
    }
}