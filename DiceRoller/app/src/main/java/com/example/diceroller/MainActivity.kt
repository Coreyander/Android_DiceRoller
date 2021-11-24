package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //===== Dice roll button
        var rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            rollDice()
        }
        //=====
    }

    class Dice (private var sides: Int) {
        private var currentRoll = 0;

        fun roll(): Int {
            currentRoll = (1..sides).random()
            return currentRoll
        }

        fun getSize(): Int {
            return sides
        }

        fun getLastRoll(): Int {
            return currentRoll
        }
    }

    /*
    rolls the dice and updates the screen with the result. Also toasts
    */
    private fun rollDice() {
        var dice = Dice(6)
        val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
        toast.show()

        val rollResult: TextView = findViewById(R.id.roll_result)
        val diceImageDisplay: ImageView = findViewById(R.id.dice_image_display)
        rollResult.text = "${dice.roll()}"
        when(dice.getLastRoll()) {
            1 -> diceImageDisplay.setImageResource(R.drawable.dice_1)
            2 -> diceImageDisplay.setImageResource(R.drawable.dice_2)
            3 -> diceImageDisplay.setImageResource(R.drawable.dice_3)
            4 -> diceImageDisplay.setImageResource(R.drawable.dice_4)
            5 -> diceImageDisplay.setImageResource(R.drawable.dice_5)
            6 -> diceImageDisplay.setImageResource(R.drawable.dice_6)
        }

       // luckyNumber(dice)
    }
    /*
        Rolls a lucky number based on the size of the dice. Assigns a win or lose message and displays the lucky number
        This is part of the Google Android Developer's Course and was disabled for general use. Yay learning!
        Creds: https://developer.android.com/courses
     */
   // private fun luckyNumber(dice: Dice) {
   //     var lucky = (1..dice.getSize()).random()
   //     val luckyWinMessage: TextView = findViewById(R.id.lucky_number_message)
   //     val luckyNumberDisplay: TextView = findViewById(R.id.lucky_number_display)
   //     luckyNumberDisplay.text = "$lucky"
   //     if (lucky == dice.getLastRoll()) { luckyWinMessage.text = "You rolled the lucky number!" }
   //     else { luckyWinMessage.text = "No Dice kid LOL" }
   // }



}