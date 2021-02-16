package com.alliebe.mastersejin.dtos

data class StoryParentDTO (
    var question: String? = null,
    var children: List<StoryChildDTO>? = null,
    var children_album: List<StoryChildAlbumDTO>? = null
)