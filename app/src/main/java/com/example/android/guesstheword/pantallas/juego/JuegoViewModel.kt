package com.example.android.guesstheword.pantallas.juego

import android.util.Log
import androidx.lifecycle.ViewModel

class JuegoViewModel : ViewModel()  {

    var palabra = ""

    // The current score
    var puntuacion = 0

    // The list of words - the front of the list is the next word to guess
    private lateinit var listaDePalabras: MutableList<String>


    init{
        Log.i("JuegoViewModel","JuegoViewModel Creado!!")
        reiniciarLista()
        siguientePalabra()

    }

    override fun onCleared() {
        super.onCleared()
        Log.i("JuegoViewModel","JuegoViewModel Destruido!!")
    }
    private fun reiniciarLista() {
        listaDePalabras = mutableListOf(
            "princesa",
            "hospital",
            "baloncesto",
            "gato",
            "monedas",
            "perro",
            "sopa",
            "calendario",
            "triste",
            "escritorio",
            "guitarra",
            "casa",
            "carretera",
            "elefante",
            "llanta",
            "carro",
            "silla",
            "teléfono",
            "bolsa",
            "botella",
            "arma"
        )
        listaDePalabras.shuffle()
    }
    private fun siguientePalabra() {
        //Select and remove a word from the list
        if (listaDePalabras.isEmpty()) {
            //juegoTerminado()
        } else {
            palabra = listaDePalabras.removeAt(0)
        }

    }
    /**
     * Recuerda que si un metodod es private solo se puede usar en la misma clase**/
     fun clickOmitir() {
        puntuacion--
        siguientePalabra()
    }
     fun clickLoConseguiste() {
        puntuacion++
        siguientePalabra()
    }

}