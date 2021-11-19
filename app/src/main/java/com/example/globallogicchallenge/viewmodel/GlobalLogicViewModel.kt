package com.example.globallogicchallenge.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.globallogicchallenge.ApiClient
import com.example.globallogicchallenge.model.Item
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class GlobalLogicViewModel : ViewModel () {

        val globalLogicModel = MutableLiveData <List<Item>>()


        fun obtenerListaItems ()  {


                CoroutineScope(Dispatchers.IO).launch {

                        val client = ApiClient.apiService.getItemList()

                        client.enqueue(object : retrofit2.Callback<List<Item>> {

                                override fun onResponse(
                                        call: Call<List<Item>>,
                                        response: Response<List<Item>>
                                )

                                {
                                        if (response.isSuccessful) {


                                                val resultadosItem = response.body()

                                                resultadosItem?.let {


                                                        globalLogicModel.postValue(resultadosItem!!)  // ACTUALIZA LA LISTA CON LOS NUEVOS RESULTADOS

                                                }

                                        }

                                }

                                override fun onFailure(call: Call<List<Item>>, t: Throwable) {

                                        mostrarMensaje("ERROR AL OBTENER LOS ITEMS")


                                }

                        })

                }

        }

        private fun mostrarMensaje (x: String) {

               // Toast.makeText(this, x, Toast.LENGTH_LONG).show()

        }


}