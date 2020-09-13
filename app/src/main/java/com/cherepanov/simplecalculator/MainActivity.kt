package com.cherepanov.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_0.setOnClickListener { setTextFields("0") }
        btn_1.setOnClickListener { setTextFields("1") }
        btn_2.setOnClickListener { setTextFields("2") }
        btn_3.setOnClickListener { setTextFields("3") }
        btn_4.setOnClickListener { setTextFields("4") }
        btn_5.setOnClickListener { setTextFields("5") }
        btn_6.setOnClickListener { setTextFields("6") }
        btn_7.setOnClickListener { setTextFields("7") }
        btn_8.setOnClickListener { setTextFields("8") }
        btn_9.setOnClickListener { setTextFields("9") }
        btn_minus.setOnClickListener { setTextFields("-") }
        btn_plus.setOnClickListener { setTextFields("+") }
        btn_division.setOnClickListener { setTextFields("/") }
        btn_multiplications.setOnClickListener { setTextFields("*") }
        btn_bracket_left.setOnClickListener { setTextFields("(") }
        btn_bracket_right.setOnClickListener { setTextFields(")") }

        btn_ac.setOnClickListener {
            operation_text.text = ""
            res_text.text = ""
        }

        btn_back.setOnClickListener {

            val str = operation_text.text.toString()
            if(str.isNotEmpty()) {
                operation_text.text = str.substring(0, str.length - 1)
            }
            res_text.text = ""

        }

        btn_equally.setOnClickListener {
            try {
                val ex = ExpressionBuilder(operation_text.text.toString()).build()
                val res = ex.evaluate()

                val longRes = res.toLong()
                if(res == longRes.toDouble())
                    res_text.text = longRes.toString()
                else
                    res_text.text = res.toString()

            }catch (e: Exception){
                Log.d("Ошибка", "сообщение: ${e.message}")
            }
        }

    }


    fun setTextFields(str: String){
        if(res_text.text != ""){
            operation_text.text = res_text.text
            res_text.text = ""
        }

        operation_text.append(str)
    }
}