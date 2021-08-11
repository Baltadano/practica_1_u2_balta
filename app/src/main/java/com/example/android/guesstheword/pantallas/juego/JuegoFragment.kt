/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.guesstheword.pantallas.juego

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.android.guesstheword.R
import com.example.android.guesstheword.databinding.JuegoFragmentBinding

/**
 * Fragment where the game is played
 * Aqui debe de ir lo que tenga que ver con
 * logica, variables, datos
 */
class JuegoFragment : Fragment() {


    /**
     *Aqui inicializamos unicamente una variable de tipo ViewModel
     ***/
    lateinit var vistaModelo: JuegoViewModel





    private lateinit var binding: JuegoFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.juego_fragment,
                container,
                false
        )


        /**
         * Variable que conecta con el JuegoViewModel para a traves de la variable
         * vistaModelo antreriormente declarada
         * * **/
        //Primer parametro: Contexto
        Log.i("JuegoFragment", "ViewModelProvider LLamado!!")
 /**
  *Esta linea siguiente es el vinculo con la logica o accion del botton con la clase JuegoViewModel
  *  **/
        vistaModelo = ViewModelProvider(this).get(JuegoViewModel::class.java)


        binding.loConseguisteButton.setOnClickListener {
            vistaModelo.clickLoConseguiste()
            actualizarTextoDePalabra()
            actualizarTextoDePuntuacion()
        }
        binding.omitirButton.setOnClickListener {
            vistaModelo.clickOmitir()
            actualizarTextoDePalabra()
            actualizarTextoDePuntuacion()
            }
        actualizarTextoDePuntuacion()
        actualizarTextoDePalabra()
        return binding.root

    }

    /**
     * Resets the list of words and randomizes the order
     */


    /**
     * Called when the game is finished
     */
    private fun juegoTerminado() {
        val action = JuegoFragmentDirections.actionGameToScore(vistaModelo.puntuacion)
        findNavController(this).navigate(action)
    }

    /**
     * Moves to the next word in the list
     */


    /** Methods for buttons presses **/



    /** Methods for updating the UI **/

    private fun actualizarTextoDePalabra() {
        binding.palabraText.text = vistaModelo.palabra

    }

    private fun actualizarTextoDePuntuacion() {
        binding.puntuacionText.text = vistaModelo.puntuacion.toString()
    }
}
