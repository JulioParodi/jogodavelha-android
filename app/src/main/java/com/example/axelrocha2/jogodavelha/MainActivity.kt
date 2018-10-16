package com.example.axelrocha2.jogodavelha

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.graphics.Canvas
import android.graphics.Paint
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val ADD_TASK_REQUEST = 1


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        buttonStart.setOnClickListener { addTaskClicked() }

        val telaInicial = findViewById (R.id.telaInicial) as android.support.constraint.ConstraintLayout
        val background = Canvass(this)
        telaInicial.addView(background)
    }


    fun addTaskClicked() {
        val intent = Intent(this, GameDescriptionActivity::class.java)
        startActivityForResult(intent, ADD_TASK_REQUEST)

    }

    class Canvass (context: Context): View(context) {

        override fun onDraw(canvas: Canvas) {
            canvas.drawRGB(0,0,0)
            val ancho = getWidth()
            val alto = getHeight()
            val pincel1 = Paint()
            pincel1.setARGB(255, 255, 255, 255)
            for(x in 1..10000) {
                var alex = (Math.random() * ancho).toFloat()
                var aley = (Math.random() * alto).toFloat()
                canvas.drawPoint(alex, aley , pincel1)
            }
        }
    }
}