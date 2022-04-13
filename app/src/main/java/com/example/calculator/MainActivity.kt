package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        fun setTextFields(str: String) {
            bindingClass.mathOperation.append(str)

        }


        bindingClass.btnPoint.setOnClickListener { setTextFields(".") }
        bindingClass.btn0.setOnClickListener { setTextFields("0") }
        bindingClass.btn1.setOnClickListener { setTextFields("1") }
        bindingClass.btn2.setOnClickListener { setTextFields("2") }
        bindingClass.btn3.setOnClickListener { setTextFields("3") }
        bindingClass.btn4.setOnClickListener { setTextFields("4") }
        bindingClass.btn5.setOnClickListener { setTextFields("5") }
        bindingClass.btn6.setOnClickListener { setTextFields("6") }
        bindingClass.btn7.setOnClickListener { setTextFields("7") }
        bindingClass.btn8.setOnClickListener { setTextFields("8") }
        bindingClass.btn9.setOnClickListener { setTextFields("9") }

        bindingClass.btnMinus.setOnClickListener { setTextFields("-") }
        bindingClass.btnPlus.setOnClickListener { setTextFields("+") }
        bindingClass.btnDobutok.setOnClickListener { setTextFields("*") }
        bindingClass.btnDivision.setOnClickListener { setTextFields("/") }
        bindingClass.btnDugaRight.setOnClickListener { setTextFields(")") }
        bindingClass.btnDugaLeft.setOnClickListener { setTextFields("(") }


        bindingClass.btnEqual.setOnClickListener {
            try {
                val ex = ExpressionBuilder(bindingClass.mathOperation.text.toString()).build()
                val result = ex.evaluate()
                val longRes = ex.evaluate().toLong()
                if (result == longRes.toDouble())
                    bindingClass.resultText.text = longRes.toString()
                else
                    bindingClass.resultText.text = result.toString()


            } catch (e: Exception) {
                Log.d("Mylog", "сообщение: ${e.message}")


            }
        }

        bindingClass.btnAC.setOnClickListener {
            bindingClass.mathOperation.text = ""
            bindingClass.resultText.text = ""
        }
        bindingClass.btnBACK.setOnClickListener {
            val str = bindingClass.mathOperation.text.toString()
            if (str.isNotEmpty()) {
                bindingClass.mathOperation.text = str.substring(0, str.length - 1)
                bindingClass.resultText.text != ""
            }
        }
    }


}






