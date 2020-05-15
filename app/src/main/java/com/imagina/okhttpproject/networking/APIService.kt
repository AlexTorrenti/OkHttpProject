package com.imagina.okhttpproject.networking

import com.imagina.okhttpproject.data.Person
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {
    @GET("people/{id}")
    fun getPerson(@Path("id") id: Int): Call<Person>

}