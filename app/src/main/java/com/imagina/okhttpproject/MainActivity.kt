package com.imagina.okhttpproject

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.imagina.okhttpproject.data.Person
import com.imagina.okhttpproject.networking.SWAPIRetriever
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val swapiRetriever = SWAPIRetriever()

        bLoad.setOnClickListener{
            val call = swapiRetriever.service.getPerson(1)

            call.enqueue(object : Callback<Person> {
                override fun onResponse(call: Call<Person>, response: Response<Person>) {
                    if (response.isSuccessful){
                        val person = response.body() as Person
                        textResult.append("\n" + person.name)
                    }
                }
                override fun onFailure(call: Call<Person>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
                    Log.e("ERROR_RETROFIT", t.message)
                }
            })
        }
    }

}
