package com.example.platziconf.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.platziconf.R
import com.example.platziconf.model.Speaker
import kotlinx.android.synthetic.main.item_speaker.view.*

class SpeakersAdapter(val speakersListener: SpeakersListener) : RecyclerView.Adapter<SpeakersAdapter.ViewHolder>() {

    var speakersList = ArrayList<Speaker>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.item_speaker, parent, false))

    override fun getItemCount() = speakersList.size

    override fun onBindViewHolder(holder: SpeakersAdapter.ViewHolder, position: Int) {
        val speaker = speakersList[position]
        holder.tvSpeakerName.text = speaker.name
        holder.tvSpeakerJob.text = speaker.jobtitle

        Glide.with(holder.itemView.context).load(speaker.image).apply(RequestOptions.circleCropTransform()).into(holder.ivSpeakerimage)

        holder.itemView.setOnClickListener {
            speakersListener.onSpeakersListener(speaker, position)
        }
    }

    fun updateData(data : List<Speaker>){
        speakersList.clear()
        speakersList.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val ivSpeakerimage = itemView.ivSpeakerImage
        val tvSpeakerName = itemView.tvSpeakerName
        val tvSpeakerJob = itemView.tvSpeakerJobTitle
    }
}