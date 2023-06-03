package com.volie.lolguidestats.data.model.item

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemImage(
    val full: String,
    val sprite: String,
    val group: String,
    val x: Int,
    val y: Int,
    val w: Int,
    val h: Int
) : Parcelable