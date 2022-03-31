package com.example.fragmentrecycleview.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contact(val name: String, val phoneNumber: Int) : Parcelable
