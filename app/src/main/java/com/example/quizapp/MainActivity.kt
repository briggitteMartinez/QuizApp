package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    private lateinit var job : Job
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    var questionList : Constants?= null

    //var questionList : Constants.getQuestions() = null
    private lateinit var db  : AppDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start.setOnClickListener {

            val intent = Intent(this, QuizQuestionsActivity::class.java)
            startActivity(intent)
            finish()
        }

        job = Job()
        db = AppDatabase.getInstance(this)

        //loadAllQuestions()

       /* addNewQuestion(Question(1,
            "Who is this?",
            R.drawable.disney_jasmine,
            "Jamila", "Jasmine",
            "Janine", 2 ))
        addNewQuestion(Question(2,
            "Who is this?",
            R.drawable.aurora2,
            "Anastasia", "Alice",
            "Aurora", 3))
        addNewQuestion(Question(
            3,
            "Who is this?",
            R.drawable.belle2,
            "Belle", "Ella",
            "Ariel", 1 ))
        addNewQuestion(Question(4,
            "Who is this?",
            R.drawable.mulan2,
            "Pocahontas", "Mulan",
            "Ling", 2 ))
        addNewQuestion(Question(5,
            "Who is this?",
            R.drawable.tiana,
            "Arianna", "Alana",
            "Tiana", 3))                 */


    }
fun addNewQuestion(question:Question){
    launch(Dispatchers.IO){
        db.questionDao.insert(question)
    }
}
    /*fun loadAllQuestions() {
        val questions = async(Dispatchers.IO) {
            db.questionDao.getAll()
        }

        launch {
            val list = questions.await().toMutableList()
            questionList = Constants(list)

        }

    }*/



    }
