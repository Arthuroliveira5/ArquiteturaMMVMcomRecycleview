package com.example.arquiteturammvmcomrecycleview.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.arquiteturammvmcomrecycleview.models.Live
import com.example.arquiteturammvmcomrecycleview.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository) : ViewModel() {

    //Apos criar a classe MainViewModel precisamos extender o ViewModel(que é do lifecycle)
    //É a classe ViewModel que fica a logica de negocios e implementaçoes de chamadas de Api
    //EX:lOGICA DE VALIDAR EMAIL,VERIFICAR SE E VALIDO.lOGICA DA APLICACAO
    //vamos adiconar um construtor para passar o repositorio de dados que criamos no repositorio e rtorfit

    //-------------------------------------------------------------------------------
    //Aqui vamos trabalhar com Livedata para exibir nos resultados da enqueue
    //Os dados do tipo Live atualizam para a Interface do Usuario
    //
    //Como O LiveData respeita o ciclo de vida do Android,isso significa que ele nao invocara seu retorno de chamada do observador
    //a menos que a activity ou fragment tenha passado pelo onStart() e nao tenha passado pelo onStop();
    //Além disso o LiveData  também remove automaticamente o observador quando seu host receber onDestroy()
    val liveList = MutableLiveData<List<Live>>()
    val errorMessage = MutableLiveData<String>()

//criamos a funcao
fun getAllLives() {

    //a val response vai chamar o metodo getAllLives presente no repositorio
    val response = repository.getAllLives()

    //apos a chamada é necessario executar a acao. entao chamamos o enqueue
    //quando usamos o enqueie precisamos executar um Callback que é o que ele vai executar quando terminar a requisiçao
    response.enqueue(object : Callback<List<Live>> {
        override fun onResponse(call: Call<List<Live>>, response: Response<List<Live>>) {
            //quando dar certo
            //Vamos postar um valor no corpo d
            liveList.postValue(response.body())
        }

        override fun onFailure(call: Call<List<Live>>, t: Throwable) {
            //qiando dar errado
            errorMessage.postValue(t.message)
        }
    })
}
}