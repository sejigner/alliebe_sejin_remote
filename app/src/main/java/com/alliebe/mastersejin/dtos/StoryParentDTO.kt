package com.alliebe.mastersejin.dtos

data class StoryParentDTO (
    var question: String? = null,
    var album_URI: String? = null,
    var children: List<StoryChildDTO>? = null
)