package com.alliebe.mastersejin

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Answer(val answer: String, val imageURI: String)
    : Parcelable

@Parcelize
data class QuestionCard(var question: String, var answers: ArrayList<Answer>, var img_URI: String)
    : Parcelable

