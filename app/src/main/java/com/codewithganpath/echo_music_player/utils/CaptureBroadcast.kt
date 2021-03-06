package com.codewithganpath.echo_music_player.utils

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager

import com.codewithganpath.echo_music_player.R
import com.codewithganpath.echo_music_player.activities.MainActivity
import com.codewithganpath.echo_music_player.fragments.SongPlayingFragment

import java.util.Objects

class CaptureBroadcast : BroadcastReceiver() {
    override fun onReceive(p0: Context, p1: Intent) {
        if (p1.action === Intent.ACTION_NEW_OUTGOING_CALL) {
            try {
                MainActivity.notificationManager!!.cancel(1978)
            } catch (e: Exception) {
                e.printStackTrace()
            }

            try {
                if (SongPlayingFragment.mediaplayer!!.isPlaying) {
                    SongPlayingFragment.mediaplayer!!.pause()
                    SongPlayingFragment.playpauseImageButton!!.setBackgroundResource(R.drawable.play_icon)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

        } else {
            val tm = p0.getSystemService(Service.TELEPHONY_SERVICE) as TelephonyManager
            if (Objects.requireNonNull(tm).callState == TelephonyManager.CALL_STATE_RINGING) {
                try {
                    MainActivity.notificationManager!!.cancel(1978)
                } catch (e: Exception) {
                    e.printStackTrace()
                }

                try {
                    if (SongPlayingFragment.mediaplayer!!.isPlaying) {
                        SongPlayingFragment.mediaplayer!!.pause()
                        SongPlayingFragment.playpauseImageButton!!.setBackgroundResource(R.drawable.play_icon)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
        }
    }
}
