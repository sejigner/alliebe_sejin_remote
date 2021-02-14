package com.alliebe.mastersejin.factory

import android.graphics.drawable.Drawable
import android.nfc.Tag
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.alliebe.mastersejin.R
import com.alliebe.mastersejin.dtos.StoryChildDTO
import com.alliebe.mastersejin.dtos.StoryParentDTO
import com.bumptech.glide.Glide
import kotlin.random.Random

object DataFactory {

    // to generate random numbers
    private val rand = Random(123123123L)

    // Sample titles
    private val comment = listOf("코멘트1",
        "코멘트2",
        "코멘트3",
        "코멘트4",
        "코멘트5",
        "코멘트6",
        "코멘트7"
    )

    private val question = listOf("질문1",
        "질문2",
        "질문3",
        "질문4",
        "질문5",
        "질문6",
        "질문7"
    )


    // Sample descriptions
    private val album_URI = listOf(
        "R.drawable.album_ex",
        "R.drawable.album_ex2",
        "R.drawable.album_ex3",
        "R.drawable.album_ex4",
        "R.drawable.album_ex5"
    )


    // Returns a sample `StoryParentDTO` Object
    fun getParentList(): List<StoryParentDTO> {
        val list = ArrayList<StoryParentDTO>()
        for (i in 1..rand.nextInt(5, 10)) {
            list.add(StoryParentDTO(
                question[rand.nextInt(question.size)], album_URI[rand.nextInt(album_URI.size)],
                getChildList()
            ))
            Log.d("list", "$list[i]")
        }
        return list
    }

    // Returns a sample `List<ChildDTO>` Object to populate the parent object
    private fun getChildList(): List<StoryChildDTO> {
        val list = ArrayList<StoryChildDTO>()
        for (i in 1..rand.nextInt(1, 4)) {
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

    @BindingAdapter("imageResource")
    @JvmStatic
    fun loadImage(imageView : ImageView, url : String){

        Glide.with(imageView.context).load(url)
            .error(R.drawable.error)
            .override(200, 200)
            .centerCrop()
            .into(imageView)
    }
}