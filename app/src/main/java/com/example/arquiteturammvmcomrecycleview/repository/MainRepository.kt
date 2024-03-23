package com.example.arquiteturammvmcomrecycleview.repository

import com.example.arquiteturammvmcomrecycleview.rest.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    //criamos o repositorio da classe MainActivity
    //Na classe do repositorio precisamops passar a instancia do serviço de retrofit para realizar a chamada de rede
    //nao precisamos lidar com a resposta aqui no repositorio.Isso faz parte do trabalho ViewModel
    //passsamos no construtor uma instancia do nosso RetrofitService
    //aqui abstraimos as chamadas do retrofitService para nosso repositorio
    //é importante ter um repositorio caso mudamos a dependecia do construtor ,mudamos tudo no codigo mais rapido sem precisar editar cada retrofitService

    fun getAllLives() = retrofitService.getAllLives()


}