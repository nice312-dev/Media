package ru.netology.music_player_homework.ui

import android.media.MediaPlayer
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MediaLifecycleObserver : LifecycleObserver {
    var player: MediaPlayer? = MediaPlayer()
    private var length = 0
    private var previousID = 0

    fun onPLay(id: Int) {
        player?.setDataSource("https://raw.githubusercontent.com/netology-code/andad-homeworks/master/09_multimedia/data/$id.mp3")
//        player?.setDataSource("https://github.com/tyupik/google_maps_test/tree/master/samples/$id.mp3")

//        player?.setDataSource("https://cloud.mail.ru/public/1vtk/xVy5fCEPW/$id.mp3")

        player?.setOnPreparedListener {
            it.start()
        }
        player?.prepareAsync()
        previousID = id
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        length = player!!.currentPosition
        player?.pause()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        player?.seekTo(length)
        player?.start()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stop() {
        player?.reset()
//        player = null
//        player?.prepareAsync()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        player?.reset()
        onPLay(previousID + 1)

//        player = null
//        player?.prepareAsync()
    }
}