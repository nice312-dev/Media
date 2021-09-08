package ru.netology.music_player_homework.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ru.netology.music_player_homework.ViewModel.TrackViewModel
import ru.netology.music_player_homework.adapter.TrackAdapter
import ru.netology.music_player_homework.databinding.ActivityMainBinding
import ru.netology.music_player_homework.databinding.ItemTrackBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: TrackViewModel by viewModels()
        val adapter = TrackAdapter {
            viewModel.play(it)
        }

        binding.list.adapter = adapter
        viewModel.data.observe(this) {tracks ->
            adapter.submitList(tracks)
        }


//        viewModel.data.observe(this) {tracks ->
//            binding.list.removeAllViews()
//            tracks.map { track ->
//                ItemTrackBinding.inflate(layoutInflater, binding.list, false).apply {
//                    fileNameTV.text = track.file
//                    playBtn.setOnClickListener {
//                        viewModel.play(track)
//                    }
//                }.root
//            }
//        }

    }
}