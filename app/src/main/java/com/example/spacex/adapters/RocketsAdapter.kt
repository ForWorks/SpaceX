package com.example.spacex.adapters

import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.spacex.R
import com.example.spacex.activities.RocketInfo
import com.example.spacex.classes.Constants
import com.example.spacex.classes.Rocket
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class RocketsAdapter(private val context: Context?, private val rockets: List<Rocket?>) : RecyclerView.Adapter<RocketsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.rocket_item, parent, false)
        return ViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text = rockets[position]?.name
        val date = LocalDate.parse(rockets[position]?.first_flight, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        holder.launchDate.text = (date.month.toString().substring(0,1) +
                                  date.month.toString().substring(1).lowercase() +
                                  " " + date.dayOfMonth + ", " + date.year)
        holder.launchCostData.text = rockets[position]?.cost_per_launch.toString().plus("$")
        holder.launchSuccessData.text = rockets[position]?.success_rate_pct.toString().plus("%")
        holder.itemLayout.setOnClickListener {
            val newPage = Intent(context, RocketInfo::class.java).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            newPage.putExtra(Constants.ROCKET_INFO, rockets[position])
            context?.startActivity(newPage)
        }
    }

    override fun getItemCount(): Int {
        return rockets.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val itemLayout: ConstraintLayout = itemView.findViewById(R.id.itemLayout)
        val itemTitle: TextView = itemView.findViewById(R.id.itemTitle)
        val launchDate: TextView = itemView.findViewById(R.id.launchDate)
        val launchCostData: TextView = itemView.findViewById(R.id.launchCostData)
        val launchSuccessData:TextView = itemView.findViewById(R.id.launchSuccessData)
    }
}