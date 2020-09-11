package com.example.interntetbanking

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_operacoes2.*

class Operacoes : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operacoes2)
        if(supportActionBar != null){
            supportActionBar?.hide()}
        var saldo = intent.getIntExtra("SALDO", -1)
        var nconta = intent.getStringExtra("CONTA")
        conta_num.text = nconta?.toString()


        text.text = saldo.toString()
        btn_depositar.setOnClickListener{
            val valor = edit_valor.text.toString().toIntOrNull()
            saldo += valor!!
            text.text = saldo.toString()
            edit_valor.text.clear()


            Toast.makeText(this,"Deposito realizado no valor de R$ $valor" ,Toast.LENGTH_SHORT).show()
        }
        btn_sacar.setOnClickListener{

          val valor = edit_valor.text.toString().toIntOrNull()
            if(saldo - valor!! >= 0){
                saldo -= valor
                text.text = saldo.toString()
                edit_valor.text.clear()
                Toast.makeText(this,"Saque realizado no valor de R$ $valor" ,Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this,"Saldo Insuficiente" ,Toast.LENGTH_LONG).show()

            }




            }




    }
}
