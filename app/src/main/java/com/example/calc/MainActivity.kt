package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var operator = "*"
    var oldCount = ""
    var newOperator = true


    var et_Info = findViewById(R.id.et_Info) as EditText
    var btn_Zero = findViewById(R.id.btn_Zero) as Button
    var btn_One = findViewById(R.id.btn_One) as Button
    var btn_Two = findViewById(R.id.btn_Two) as Button
    var btn_Three = findViewById(R.id.btn_Three) as Button
    var btn_Four = findViewById(R.id.btn_Four) as Button
    var btn_Five = findViewById(R.id.btn_Five) as Button
    var btn_Six = findViewById(R.id.btn_Six) as Button
    var btn_Seven = findViewById(R.id.btn_Seven) as Button
    var btn_Eight = findViewById(R.id.btn_Eight) as Button
    var btn_Nine = findViewById(R.id.btn_Nine) as Button
    var btn_Sub = findViewById(R.id.btn_Sub) as Button
    var btn_Div = findViewById(R.id.btn_Div) as Button
    var btn_Mul = findViewById(R.id.btn_Mul) as Button
    var btn_Sum = findViewById(R.id.btn_Sum) as Button

    fun btn_Click(view : View)
    {
        if (newOperator){
            et_Info.setText("")
        }
        newOperator=false
        var btnSelect = view as Button
        var btnClickValue:String = et_Info.text.toString()
        when(btnSelect.id){
            btn_Zero.id->{
                btnClickValue+="0"
            }
            btn_One.id->{
                btnClickValue+="1"
            }
            btn_Two.id->{
                btnClickValue+="2"
            }
            btn_Three.id->{
                btnClickValue+="3"
            }
            btn_Four.id->{
                btnClickValue+="4"
            }
            btn_Five.id->{
                btnClickValue+="5"
            }
            btn_Six.id->{
                btnClickValue+="6"
            }
            btn_Seven.id->{
                btnClickValue+="7"
            }
            btn_Eight.id->{
                btnClickValue+="8"
            }
            btn_Nine.id->{
                btnClickValue+="9"
            }

            btn_Sub.id->{
                btnClickValue="-"+btnClickValue
            }
        }
        et_Info.setText(btnClickValue)

    }

    fun btn_Operator(view: View) {
        var btn_Select= view as Button
        when(btn_Select.id){
            btn_Div.id->{
                operator="/"
            }
            btn_Mul.id->{
                operator="*"
            }
            btn_Sub.id->{
                operator="-"
            }
            btn_Sum.id->{
                operator="+"
            }
        }
        oldCount=et_Info.text.toString()
        newOperator=true
    }
    fun Equals(view: View) {
        var newCount=et_Info.text.toString()
        var result:Double?=null
        when(operator){
            "/"->{
                result=oldCount.toDouble()/newCount.toDouble()
            }
            "*"->{
                result=oldCount.toDouble()*newCount.toDouble()
            }
            "-"->{
                result=oldCount.toDouble()-newCount.toDouble()
            }
            "+"->{
                result=oldCount.toDouble()+newCount.toDouble()
            }
        }
        et_Info.setText(result.toString())
        newOperator=true

    }
    fun Ac(view: View) {
        et_Info.setText("0")
        newOperator=true
    }
    fun Per(view: View) {
        //sayi veri tipini double yaptık , edit textin ilk stringe sonra double cevirdik ve 100 e bolduk
        var count:Double=et_Info.text.toString().toDouble()/100
        et_Info.setText(count.toString())
        newOperator=true
    }

}