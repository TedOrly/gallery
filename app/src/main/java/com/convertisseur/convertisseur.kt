package com.example.convertisseur

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.convertisseur.R

class ConvertisseurActivity : AppCompatActivity() {

    private lateinit var inputNumber: EditText
    private lateinit var outputResult: TextView
    private lateinit var convertToFrench: Button
    private lateinit var convertToEnglish: Button
    private lateinit var convertToMassango: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_convertisseur)

        // Initialisation des vues
        inputNumber = findViewById(R.id.inputNumber)
        outputResult = findViewById(R.id.outputResult)
        convertToFrench = findViewById(R.id.convertToFrench)
        convertToEnglish = findViewById(R.id.convertToEnglish)
        convertToMassango = findViewById(R.id.convertToMassango)

        // Bouton pour convertir en français
        convertToFrench.setOnClickListener {
            handleConversion { number -> convertNumberToFrench(number) }
        }

        // Bouton pour convertir en anglais
        convertToEnglish.setOnClickListener {
            handleConversion { number -> convertNumberToEnglish(number) }
        }

        // Bouton pour convertir en Massango
        convertToMassango.setOnClickListener {
            handleConversion { number -> convertNumberToMassango(number) }
        }
    }

    // Fonction générique pour gérer les conversions
    private fun handleConversion(conversionFunction: (Int) -> String) {
        val number = inputNumber.text.toString().toIntOrNull()
        if (number != null) {
            outputResult.text = conversionFunction(number)
        } else {
            outputResult.text = getString(R.string.next)
        }
    }

    // Fonction pour convertir le nombre en français
    private fun convertNumberToFrench(number: Int): String {
        return when (number) {
            1 -> "Un"
            2 -> "Deux"
            3 -> "Trois"
            4 -> "Quatre"
            5 -> "Cinq"
            6 -> "Six"
            7 -> "Sept"
            8 -> "Huit"
            9 -> "Neuf"
            10 -> "Dix"
            else -> "Nombre non pris en charge"
        }
    }

    // Fonction pour convertir le nombre en anglais
    private fun convertNumberToEnglish(number: Int): String {
        return when (number) {
            1 -> "One"
            2 -> "Two"
            3 -> "Three"
            4 -> "Four"
            5 -> "Five"
            6 -> "Six"
            7 -> "Seven"
            8 -> "Eight"
            9 -> "Nine"
            10 -> "Ten"
            else -> "Number not supported"
        }
    }

    // Fonction pour convertir le nombre en Massango
    private fun convertNumberToMassango(number: Int): String {
        return when (number) {
            1 -> "imosi"
            2 -> "béyi"
            3 -> "iréru"
            4 -> "tsiyine"
            5 -> "iraanu"
            6 -> "isamenu"
            7 -> "tsaambu"
            8 -> "pombe"
            9 -> "iwè"
            10 -> "dighumi"
            else -> "massa soundze iye"
        }
    }
}
