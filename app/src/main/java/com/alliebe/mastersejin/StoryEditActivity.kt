package com.alliebe.mastersejin

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.alliebe.mastersejin.adapter.StoryParentAdapter
import com.alliebe.mastersejin.databinding.ActivityEditStoryBinding
import com.alliebe.mastersejin.factory.DataFactory
import kotlinx.android.synthetic.main.activity_edit_story.*
import kotlinx.android.synthetic.main.activity_main.*

class StoryEditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditStoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_story)
        val data = DataFactory.getParentList()
        rv_items.addItemDecoration(DividerItemDecoration(this, R.drawable.line_divider, 10, 10))
        binding.rvItems.adapter = StoryParentAdapter(data)
    }
}