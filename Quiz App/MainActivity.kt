package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //variable to store the score
    var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set onclicklistener on the button
        submit.setOnClickListener {
            //get the scores for each question
            questionOne()
            questionTwo()
            questionThree()
            questionFour()
            questionFive()
            questionSix()

            //display the total score in a toast message
            Toast.makeText(this, "Your score is " + score + " out of 6!", Toast.LENGTH_SHORT).show()

            //reset the score
            score = 0

            //reset the view
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);

        }
    }

    //function to update the score if question1 is correct
    fun questionOne() {
        //update the value of score
        if (ohms.isChecked) {
            score += 1
        }
    }

    //function to update the score if question2 is correct
    fun questionTwo() {
        //determine whether or not the checkboxes have been selected
        var checkbox1: Boolean = muon.isChecked
        var checkBox2: Boolean = quarkon.isChecked //wrong answer
        var checkBox3: Boolean = neutrino.isChecked
        var checkBox4: Boolean = tau.isChecked
        //update the score if all correct answers are selected
        if (checkbox1 && checkBox3 && checkBox4 && !checkBox2) {
            score += 1
        }
    }

    //function to update the score if question3 is correct
    fun questionThree() {
        if (answer3.isChecked)
            score += 1
    }

    //function to update the score if question4 is correct
    fun questionFour() {
        //get the response from the edittext and convert to string
        var answer: String = answer4.text.toString()
        //string containing correct answer
        var isaac = "Isaac"
        //check if the answer is correct and update the score
        if (answer.equals(isaac, ignoreCase = true)) {
            score += 1
        }
    }

    //function to update the score if question5 is correct
    fun questionFive() {
        //update the score if the answer is correct
        if (answer5.isChecked) {
            score += 1
        }
    }

    //function to update the score if question6 is correct
    fun questionSix() {
        //update the score if the answer is correct
        if (answer6.isChecked) {
            score += 1
        }
    }


}
