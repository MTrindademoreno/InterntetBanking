package com.example.interntetbanking

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_operacoes2.*

class Operacoes : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operacoes2)
        if(supportActionBar != null){
            supportActionBar?.hide()}

        //USAR PARCELABLE
        var saldo = intent.getIntExtra("SALDO", -1)
        var nomeop = intent.getStringExtra("NOME")
        var sobrenomeop = intent.getStringExtra("SOBRENOME")
        var nconta = intent.getStringExtra("CONTA")
        conta_num.text = nconta?.toString()
        text.text = saldo.toString()
        val cliente = Cliente(nomeop,sobrenomeop)
        val contaop =Conta(nconta, cliente)



        btn_depositar.setOnClickListener{
            //usando funçao na classe
            val valor = edit_valor.text.toString().toIntOrNull()
            if (valor != null) {
                contaop.deposit(valor)
                text.text = contaop.saldo.toString()
                edit_valor.text.clear()
            }else {
                Toast.makeText(this,"Valor da operação inválido" , Toast.LENGTH_SHORT).show()
            }


            Toast.makeText(this,"Deposito realizado no valor de R$ $valor e saldo $saldo"  , Toast.LENGTH_SHORT).show()
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
