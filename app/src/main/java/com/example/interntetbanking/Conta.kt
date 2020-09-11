package com.example.interntetbanking

class Conta(var numeroConta: String , var saldo : Int ,var titular:Cliente) {
    constructor(numeroConta: String,titular: Cliente): this(numeroConta,1500,titular)
    {


    }
fun deposit(valorf : Int){


    saldo += valorf




}
}