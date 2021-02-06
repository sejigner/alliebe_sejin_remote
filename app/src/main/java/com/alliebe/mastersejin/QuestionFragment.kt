package com.alliebe.mastersejin.com.alliebe.mastersejin

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.alliebe.mastersejin.ChapterWriteActivity
import com.alliebe.mastersejin.R
import com.alliebe.mastersejin.StoryEditActivity
import com.alliebe.mastersejin.StoryEditFragment
import kotlinx.android.synthetic.main.fragment__story_edit.*
import kotlinx.android.synthetic.main.fragment_question.*

class QuestionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view =
            LayoutInflater.from(activity).inflate(R.layout.fragment_question, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_editStory_temp.setOnClickListener {
            activity?.let {
                val intent = Intent(context, StoryEditActivity::class.java)
                startActivity(intent)
            }
        }
    }
}