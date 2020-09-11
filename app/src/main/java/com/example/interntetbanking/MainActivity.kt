package com.example.interntetbanking

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(supportActionBar != null){
            supportActionBar?.hide()}


            btn_entrar.setOnClickListener(){
            val cliente = Cliente(edit_name.text.toString(), edit_sobrenome.text.toString())
                val conta = Conta(edit_Conta.text.toString(),cliente)
                var saldo: Int = conta.saldo
                val nconta= conta.numeroConta


                val intent = Intent(this,Operacoes::class.java)
                intent.putExtra("SALDO",saldo)
                intent.putExtra("CONTA",nconta )
                intent.putExtra("NOME",cliente.nome)
                intent.putExtra("SOBRENOME", cliente.sobrenome)



                    startActivity(intent)

            }




    }
}
