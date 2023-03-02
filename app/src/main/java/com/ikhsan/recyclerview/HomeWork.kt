package com.ikhsan.recyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HomeWork(
    val name: String,
    val rating: String,
    val description: String,
    val photo: Int,
    val descriptionClass: String,
    val target: String
): Parcelable
