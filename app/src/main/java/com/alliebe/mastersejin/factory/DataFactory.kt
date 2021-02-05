package com.alliebe.mastersejin.factory

import com.alliebe.mastersejin.dtos.StoryChildDTO
import com.alliebe.mastersejin.dtos.StoryParentDTO
import kotlin.random.Random

object DataFactory {

    // to generate random numbers
    private val rand = Random(123123123L)

    // Sample titles
    private val comment = listOf("Vertigo",
        "The Innocents",
        "Lawrence of Arabia",
        "The Deer Hunter",
        "Amadeus",
        "Blade Runner",
        "Eyes Wide Shut"
    )


    // Sample descriptions
    private val album_URI = listOf(
        "사진1",
        "사진2",
        "사진3",
        "사진4",
        "사진5",
        "사진6",
        "사진7",
        "사진8"
    )


    // Returns a sample `StoryParentDTO` Object
    fun getParentList(): List<StoryParentDTO> {
        val list = ArrayList<StoryParentDTO>()
        for (i in 1..rand.nextInt(5, 10)) {
            list.add(StoryParentDTO(
                comment[rand.nextInt(comment.size)], album_URI[rand.nextInt(comment.size)],
                getChildList()
            ))
        }
        return list
    }

    // Returns a sample `List<ChildDTO>` Object to populate the parent object
    private fun getChildList(): List<StoryChildDTO> {
        val list = ArrayList<StoryChildDTO>()
        for (i in 1..rand.nextInt(5, 10)) {
            list.add(getRandomChild())
        }
        return list
    }

    // Returns a sample `ChildDTO` Object
    private fun getRandomChild(): StoryChildDTO {
        return StoryChildDTO(
            comment[rand.nextInt(comment.size)],  "@mipmap/img_sample"
        )
    }
}