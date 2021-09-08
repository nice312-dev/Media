package ru.netology.music_player_homework.dto

data class Album(
    val id: String?,
    val title: String?,
    val subtitle: String?,
    val artist: String?,
    val published: String?,
    val genre: String?,
    val tracks: List<Track>?
)

data class Track(
    val id: Int,
    val file: String,
    var action: String = "stop"
)
