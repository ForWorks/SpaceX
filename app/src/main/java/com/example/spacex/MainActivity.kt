package com.example.spacex

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spacex.adapters.RocketsAdapter
import com.example.spacex.classes.Rocket
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.*
import java.net.URL

class MainActivity : AppCompatActivity() {

    private lateinit var rockets: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        fillRocketAdapter(this)
    }

    private fun fillRocketAdapter(context: Context) {
        CoroutineScope(Dispatchers.IO).launch {
            val jsonStr = URL("https://api.spacexdata.com/v4/rockets").readText()
            val builder = GsonBuilder()
            val gson = builder.create()
            val listType = object: TypeToken<ArrayList<Rocket?>>() {}.type
            val rocketsList: ArrayList<Rocket?> = gson.fromJson(jsonStr, listType)
            runOnUiThread {
                rockets.adapter = RocketsAdapter(context, rocketsList)
            }
        }
    }

    private fun init() {
        rockets = findViewById(R.id.mainItems)
        val layoutManager:RecyclerView.LayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rockets.layoutManager = layoutManager
    }
}


