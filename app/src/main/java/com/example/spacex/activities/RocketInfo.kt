package com.example.spacex.activities

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.spacex.R
import com.example.spacex.classes.Constants
import com.example.spacex.classes.Rocket
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class RocketInfo : AppCompatActivity() {

    private lateinit var wikiBtn: Button
    private lateinit var rocketName: TextView
    private lateinit var rocketDescription: TextView
    private lateinit var firstLaunch: TextView
    private lateinit var launchCost: TextView
    private lateinit var success: TextView
    private lateinit var mass: TextView
    private lateinit var height: TextView
    private lateinit var diameter: TextView
    private var rocket: Rocket? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rocket_info)

        getIntentData()
        init()
        setHandlers()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun init() {
        wikiBtn = findViewById(R.id.wikipedia)
        rocketName = findViewById(R.id.rocketName)
        rocketDescription = findViewById(R.id.rocketDescription)
        firstLaunch = findViewById(R.id.textView2)
        launchCost = findViewById(R.id.textView4)
        success = findViewById(R.id.textView6)
        mass = findViewById(R.id.textView8)
        height = findViewById(R.id.textView10)
        diameter = findViewById(R.id.textView12)

        val date = LocalDate.parse(rocket?.first_flight, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        firstLaunch.text = (date.month.toString().substring(0,1) +
                date.month.toString().substring(1).lowercase() +
                " " + date.dayOfMonth + ", " + date.year)

        rocketName.text = rocket?.name
        rocketDescription.text = rocket?.description
        launchCost.text = rocket?.cost_per_launch.toString().plus("$")
        success.text = rocket?.success_rate_pct.toString().plus("%")
        mass.text = rocket?.mass?.kg.toString().plus(" kg")
        height.text = rocket?.height?.meters.toString().plus(" meters")
        diameter.text = rocket?.diameter?.meters.toString().plus(" meters")
    }

    private fun getIntentData() {
        val extras = intent.extras
        if (extras != null) {
            rocket = extras.getSerializable(Constants.ROCKET_INFO) as Rocket?
        }
    }

    private fun setHandlers() {
        wikiBtn.setOnClickListener {
            val newPage = Intent(this, WebPage::class.java).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            newPage.putExtra(Constants.ROCKET_URL, rocket?.wikipedia)
            newPage.putExtra(Constants.ROCKET_NAME, rocket?.name)
            startActivity(newPage)
        }
    }
}