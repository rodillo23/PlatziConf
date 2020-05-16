package com.example.platziconf.view.adapter

import com.example.platziconf.model.Speaker

interface SpeakersListener {
    fun onSpeakersListener(speaker : Speaker, position : Int)
}