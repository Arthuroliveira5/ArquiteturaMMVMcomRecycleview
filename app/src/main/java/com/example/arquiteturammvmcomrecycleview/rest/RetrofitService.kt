package com.example.arquiteturammvmcomrecycleview.rest

import com.example.arquiteturammvmcomrecycleview.models.Live
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
    //APOS CRIAR A CLASSE RETOFICE SERVICE ,MUDA A CLASS PARA INTERFACE

    //ANOTACAO DO CAMINHO PARA BUSCAR OS DADOS NO API(path ou endpoint)
        @GET("lista-lives.json")
        //CRIAR A FUNCAO PARA PEGAR OS VALORES
        //Vai retornar uma call de uma lista do tipo Live(model)
        fun getAllLives(): Call<List<Live>>

        //iniciar o retrofit
        companion object {
        //o by lazy serve para instanciar o objeto uma vez só e quando ele for utilizado
        private val retrofitService: RetrofitService by lazy {

            val retrofit = Retrofit.Builder()
                .baseUrl("https://d3c0cr0sze1oo6.cloudfront.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            //aqui o retofit pe criado
            retrofit.create(RetrofitService::class.java)

        }
//criar uma instancia para retornar o retrofitService
    fun getInstance() : RetrofitService {
        return retrofitService
    }

}
}