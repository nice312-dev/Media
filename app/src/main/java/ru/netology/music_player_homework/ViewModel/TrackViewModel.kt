package ru.netology.music_player_homework.ViewModel

import androidx.lifecycle.ViewModel
import ru.netology.music_player_homework.dto.Track
import ru.netology.music_player_homework.repository.TrackRepository
import ru.netology.music_player_homework.repository.TrackRepositoryImpl

class TrackViewModel : ViewModel() {
    private val  repository: TrackRepository = TrackRepositoryImpl()
    val data = repository.get()
    fun play(track : Track) = repository.play(track)
}