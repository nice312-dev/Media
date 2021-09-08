package ru.netology.music_player_homework.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.music_player_homework.dto.Track
import ru.netology.music_player_homework.ui.MediaLifecycleObserver

interface TrackRepository {
    fun get(): LiveData<List<Track>>
    fun play(track: Track)
}

class TrackRepositoryImpl : TrackRepository {
    private val mediaObserver = MediaLifecycleObserver()
    private var tracks = listOf(
        Track(
            id = 1,
            file = "1.mp3"
        ),
        Track(
            id = 2,
            file = "2.mp3"
        )
    )
    private val data = MutableLiveData(tracks)

    override fun get(): LiveData<List<Track>> = data

    private var previousId = 0


    override fun play(track: Track) {
        val id = track.id
        if (previousId == 0) {
            print("good")
        } else {
            if (id != previousId) {
                track.action = "stop"
                mediaObserver.stop()
            }
        }
        previousId = id

        when (track.action) {
            "stop" -> {
                track.action = "play"
                mediaObserver.onPLay(id)
            }
            "pause" -> {
                track.action = "play"
                mediaObserver.onResume()
            }
            "play" -> {
                track.action = "pause"
                mediaObserver.onPause()
            }
        }
    }
}