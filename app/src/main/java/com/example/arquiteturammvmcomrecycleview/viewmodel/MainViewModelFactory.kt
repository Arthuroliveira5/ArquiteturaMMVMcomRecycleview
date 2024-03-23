package com.example.arquiteturammvmcomrecycleview.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.arquiteturammvmcomrecycleview.repository.MainRepository

//Nao podemos criar viewmodel por conta propria.Precisamos do utilitario ViewModelProviders dorenecido pelo Android para criar ViewModels
//
//Ponto de  Atencao : ViewModelProviders só pode instanciar ViewModels sem nenhum construtor com argumentos
//
//Portando se eu tiver um ViewModel com varios argumentos,como é o caso desse app que estou fazendo,preciso usar
//um Factory que possa passar para ViewModelProviders para usar quando uma instancia do MainViewModel for necessaria

class MainViewModelFactory constructor(private val repository: MainRepository): ViewModelProvider.Factory {


    //padrao
    //basciamente criar uma viewmodel dependendo da classe que passamos pra ela
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }



}