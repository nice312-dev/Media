package ru.netology.music_player_homework.adapter

import android.os.Handler
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.netology.music_player_homework.R
import ru.netology.music_player_homework.databinding.ItemTrackBinding
import ru.netology.music_player_homework.dto.Track
import ru.netology.music_player_homework.ui.MediaLifecycleObserver
import java.lang.Exception
import java.util.logging.Handler as Handler1

typealias  OnPlayListener = (track: Track) -> Unit

class TrackAdapter(
    private val onPlayListener: OnPlayListener
) : ListAdapter<Track, TrackViewHolder>(TrackDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val binding = ItemTrackBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrackViewHolder(binding, onPlayListener)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        val track = getItem(position)
        holder.bind(track)
    }

}


class TrackDiffCallback : DiffUtil.ItemCallback<Track>() {
    override fun areItemsTheSame(oldItem: Track, newItem: Track): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Track, newItem: Track): Boolean {
        return oldItem == newItem
    }
}

class TrackViewHolder(
    private val binding: ItemTrackBinding,
    private val onPlayListener: OnPlayListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(track: Track) {
        binding.apply {
            fileNameTV.text = track.file
            playBtn.setOnClickListener {
                onPlayListener(track)
            }
            playBtn.setImageResource(
                if (track.action == "play") R.drawable.ic_pause_circle_24 else R.drawable.ic_play_circle_24
            )
        }
    }
}


