package com.dostonbek.preyerapp

import android.content.ClipData
import com.dostonbek.preyerapp.model.Item

interface SalatView {
    fun onDataCompleteFromApi(salat: Item)
    fun onDataErrorFromApi(throwable: Throwable)
}