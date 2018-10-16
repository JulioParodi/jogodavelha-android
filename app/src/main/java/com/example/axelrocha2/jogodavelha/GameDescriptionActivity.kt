package com.example.axelrocha2.jogodavelha

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game_description.*

class GameDescriptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_description)
    }

    fun bttnClick(view: View){
        val bttnSelected = view as Button
        var cellID = 0
        when(bttnSelected.id){
            R.id.button1 -> cellID = 1
            R.id.button2 -> cellID = 2
            R.id.button3 -> cellID = 3
            R.id.button4 -> cellID = 4
            R.id.button5 -> cellID = 5
            R.id.button6 -> cellID = 6
            R.id.button7 -> cellID = 7
            R.id.button8 -> cellID = 8
            R.id.button9 -> cellID = 9
        }
        //Toast.makeText(this, "Cell ID: " +cellID, Toast.LENGTH_LONG).show()
        playGame(cellID, bttnSelected)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()


    var activePlayer = 1

    private fun playGame(cellID: Int, bttnSelected: Button) {

        if(activePlayer == 1){
            bttnSelected.text = "X"
            bttnSelected.setBackgroundColor(Color.parseColor("#808080"))
            player1.add(cellID)
            activePlayer = 2
        }else{
            bttnSelected.text = "O"
            bttnSelected.setBackgroundColor(Color.parseColor("#808080"))
            player2.add(cellID)
            activePlayer = 1
        }
        bttnSelected.isEnabled = false

        checkWinner()
    }

    private fun checkWinner() {
        var winner = -1


        //linha 1:
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
            disableButtons()
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
            disableButtons()
        }

        //linha 2:
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
            disableButtons()
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
            disableButtons()
        }

        //linha 3:
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
            disableButtons()
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
            disableButtons()
        }

        //coluna 1:
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
            disableButtons()
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
            disableButtons()
        }

        //coluna 2:
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
            disableButtons()
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(8)) {
            winner = 2
            disableButtons()
        }

        //coluna 3:
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
            disableButtons()
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
            disableButtons()
        }

        //diagonal 1:
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
            disableButtons()
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
            disableButtons()
        }
        //diagonal 2:
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
            disableButtons()
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
            disableButtons()
        }

        if (winner != -1){
            if(winner == 1){
                Toast.makeText(this, "Player 1 Venceu o Jogo!!", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Player 2 Venceu o Jogo!!", Toast.LENGTH_LONG).show()
            }
        }else if( (player1.size) == 5 ){
            Toast.makeText(this, "Empate!!", Toast.LENGTH_LONG).show()
        }
    }
    private fun disableButtons(){
        button1.isEnabled = false
        button2.isEnabled = false
        button3.isEnabled = false
        button4.isEnabled = false
        button5.isEnabled = false
        button6.isEnabled = false
        button7.isEnabled = false
        button8.isEnabled = false
        button9.isEnabled = false
    }
}
