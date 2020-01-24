package com.example.fitnesspro

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var LapNumber: TextView
    lateinit var Image: ImageView

    var Lap = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LapNumber = findViewById(R.id.LapNumberImage)
        Image = findViewById(R.id.ImageTrophy)
    }

    /**
     * Next Lap le suma uno al contador que es el numero de vueltas
     */
    fun nextLap(view: View){
        if(Lap < 20) {//solamente le va a sumar al contador si es menor a 20
            Lap++
            if(Lap == 10){//Si es 10 muestra el mensaje de la meta y la imagen del trofeo
                Image.setImageResource(R.drawable.trophy1)
                val toast = Toast.makeText(applicationContext, "Llego a la primera meta.", Toast.LENGTH_SHORT)
                toast.show()
            }
            if(Lap == 11)//para quitar la imagen
                Image.setImageResource(R.drawable.empty_dice) //con visible se puede quitar la imagen
            if (Lap == 20){//Cuando llega a 20 dice que termino las metas del dia y muestra la imagen
                Image.setImageResource(R.drawable.trofeo)
                val toast = Toast.makeText(applicationContext, "Felicidades a cumplido las metas del dia.", Toast.LENGTH_SHORT)
                toast.show()
            }

        }

        LapButton.setOnLongClickListener(){//si mantiene presionado el boton muestra el numero de vueltas que le faltan para llegar a la meta mas cercana
            if(Lap < 10){
                //envia el mensaje toast
                val toast1 = Toast.makeText(this, "Le faltan " + (10-Lap).toString() + " para llegar a la meta.", Toast.LENGTH_SHORT)
                toast1.show()
            }
            if(Lap >=10 && Lap < 20 ){
                //envia el mensaje toast
                val toast1 = Toast.makeText(this, "Le faltan " + (20-Lap).toString() + " para llegar a la meta.", Toast.LENGTH_SHORT)
                toast1.show()
            }
            Lap--
            return@setOnLongClickListener false
        }
        LapNumber.setText(Lap.toString())//muesta el contador en pantalla

    }

    fun restarLap(view: View){//reinicia el contador
        Lap=0
        LapNumber.setText(Lap.toString())
        Image.setImageResource(R.drawable.empty_dice)//quita la imagen del trofeo
    }
}
