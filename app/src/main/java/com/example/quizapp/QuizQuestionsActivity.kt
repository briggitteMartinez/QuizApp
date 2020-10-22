package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        val questionsList = Constants.getQuestions()

        // kolla storleken på frågorna
        // Log.i("Questions Size", "${questionsList.size}")

        // plats på frågorna minus 1 pga index börjar på 0
        val currentPosition = 1
        val question: Question? = questionsList[currentPosition-1]

        progressBar.progress = currentPosition
        tv_progress.text = "$currentPosition" + "/" + progressBar.max

        tv_question.text = question!!.question
        iv_image.setImageResource(question.image)
        tv_opt_one.text = question.optOne
        tv_opt_two.text = question.optTwo
        tv_opt_three.text = question.optThree



    }
}