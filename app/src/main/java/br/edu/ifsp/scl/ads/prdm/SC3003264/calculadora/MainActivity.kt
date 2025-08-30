package br.edu.ifsp.scl.ads.prdm.SC3003264.calculadora

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    val sun = "+"
    val sub = "-"
    val mult = "*"
    val div = "/"
    val perc = "%"

    var operationActual = ""
    var firstNumber:Double = Double.NaN
    var secondNumber:Double = Double.NaN

    lateinit var  tvTemp: TextView
    lateinit var  tvResult: TextView

    lateinit var formatDecimal: DecimalFormat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        formatDecimal = DecimalFormat("#.##########")
        tvTemp = findViewById(R.id.tvTemp)
        tvResult = findViewById(R.id.tvResult)
    }

    fun suapOperation(b: View){
        if (tvTemp.text.isNotEmpty()){
            calc()
            val button: Button = b as Button
            if(button.text.toString().trim() == "÷"){
                operationActual = "/"
            }else if(button.text.toString().trim() == "X"){
                operationActual = "*"
            }else{
                operationActual = button.text.toString().trim()
            }

            tvResult.text = formatDecimal.format(firstNumber) + operationActual
            tvTemp.text = ""
        }

    }

    fun calc(){
        try {
            if(firstNumber.toString() != "NaN"){
                if (tvTemp.text.toString().isEmpty()){
                    tvTemp.text = tvResult.text.toString()
                }
                secondNumber = tvTemp.text.toString().toDouble()
                tvTemp.text = ""

                when(operationActual){
                    "+" -> firstNumber = (firstNumber + secondNumber)
                    "-" -> firstNumber = (firstNumber - secondNumber)
                    "*" -> firstNumber = (firstNumber * secondNumber)
                    "/" -> firstNumber = (firstNumber / secondNumber)
                    "%" -> firstNumber = (firstNumber % secondNumber)
                }
            }else {
                firstNumber = tvTemp.text.toString().toDouble()
            }
        }catch (e: Exception){

        }
    }

    fun selectNumber(b: View){
        val button: Button = b as Button
        if (tvTemp.text.toString() == "0"){
            tvTemp.text = ""
        }
        tvTemp.text = tvTemp.text.toString() + button.text.toString()
    }

    fun result(b: View){
        if (tvTemp.text.isNotEmpty()){
            calc()
            tvResult.text = formatDecimal.format(firstNumber)
            //firstNumber = Double.NaN

            operationActual = ""
        }
    }

    fun clear(b: View){

        val button: Button = b as Button
        if(button.text.toString().trim() == "C"){
            if(tvTemp.text.toString().isNotEmpty()){
                var dataActual: CharSequence = tvTemp.text as CharSequence
                tvTemp.text = dataActual.subSequence(0, dataActual.length - 1)
            }else{
                firstNumber = Double.NaN
                secondNumber = Double.NaN
                tvTemp.text = ""
                tvResult.text = ""
            }
        }else if(button.text.toString().trim() == "CA"){
            firstNumber = Double.NaN
            secondNumber = Double.NaN
            tvTemp.text = ""
            tvResult.text = ""

        }

    }
}