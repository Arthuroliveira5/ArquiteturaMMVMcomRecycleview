package com.example.arquiteturammvmcomrecycleview

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.arquiteturammvmcomrecycleview.adapters.MainAdapter
import com.example.arquiteturammvmcomrecycleview.databinding.ActivityMainBinding
import com.example.arquiteturammvmcomrecycleview.repository.MainRepository
import com.example.arquiteturammvmcomrecycleview.rest.RetrofitService
import com.example.arquiteturammvmcomrecycleview.viewmodel.MainViewModel
import com.example.arquiteturammvmcomrecycleview.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    //Apos configurar os Modelos,retrofit,repositorio,Viewmodel e viewmodel factory é hora de mecher nas Views (UI )e main activity
    lateinit var viewModel : MainViewModel

    private val TAG = "MainActivity"

    private val retrofitService = RetrofitService.getInstance()

    private val adapter = MainAdapter {
        //acao de click criado mais embaixo
            live ->
        openLink(live.link)

    }


    //Antes usavamos syntatic agora Viewbindiding

    private  lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Agora apos configurar o Viewbindig vamos comecar a usar o viewmodel,que deve foi  instanciado la em cima

        viewModel =
            ViewModelProvider(this, MainViewModelFactory(MainRepository(retrofitService))).get(
                MainViewModel::class.java
            )

        //settar o adapter

        binding.recyclerview.adapter = adapter


    }

    override fun onStart() {
        super.onStart()

        //aqui vamos startar os Observers

        viewModel.liveList.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setLiveList(it)
        })

        viewModel.errorMessage.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }
//precisamos chamar o metodo getallLives() que verifica se se há novos registros toda vez que o usuuario volta pra ela
    override fun onResume() {
        super.onResume()
        viewModel.getAllLives()
    }

    //criar funçao de click

    private fun openLink(link: String) {

        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        startActivity(browserIntent)

    }
}