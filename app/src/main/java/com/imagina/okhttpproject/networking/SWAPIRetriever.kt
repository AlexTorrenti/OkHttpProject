package com.imagina.okhttpproject.networking

import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SWAPIRetriever {

    val hostname = "swapi.dev"
    val certificatePinner = CertificatePinner.Builder()
    .add(hostname, "sha256/eSiyNwaNIbIkI94wfLFmhq8/ATxm30i973pMZ569tZo=")
    .build();

    // Con SSL Pinning
    private val client = OkHttpClient.Builder().certificatePinner(certificatePinner).build()

    // Sin SSL Pinning
   // private val client = OkHttpClient.Builder().build()
    val service: APIService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        service = retrofit.create(APIService::class.java)
    }
}