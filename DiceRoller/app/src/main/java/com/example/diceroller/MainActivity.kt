package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allow the user to roll a dice and see the result on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        //Roll a dice when the app starts
        rollDice()
    }

    /**
     * Roll dice and see the result on screen
     */
    private fun rollDice() {
        //Create new dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Find image the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        //Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when(diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        //Update the content description
        diceImage.contentDescription = diceRoll.toString()
    }
}

/**
 * Dice with a fixed number of sides
 */
class Dice(private val numSides: Int) {

    //Return random number between 1 and the number of sides
    fun roll(): Int {
        return (1..numSides).random()
    }
}