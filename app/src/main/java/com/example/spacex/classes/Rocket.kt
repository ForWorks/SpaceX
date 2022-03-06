package com.example.spacex.classes
import java.io.Serializable

class Rocket: Serializable {
    val height: Height? = null
    val diameter: Diameter? = null
    val mass: Mass? = null
    val first_stage: FirstStage? = null
    val second_stage: SecondStage? = null
    val engines: Engines? = null
    val landingLegs: LandingLegs? = null
    val payload_weights: MutableList<Any?> = ArrayList<Any?>().toMutableList()
    val flickr_images: MutableList<String?> = ArrayList<String?>().toMutableList()
    val name: String? = null
    val type: String? = null
    val active: Boolean? = null
    val stages: Int? = null
    val boosters: Int? = null
    val cost_per_launch: Int? = null
    val success_rate_pct: Int? = null
    val first_flight: String? = null
    val country: String? = null
    val company: String? = null
    val wikipedia: String? = null
    val description: String? = null
    val id: String? = null
}

class Height: Serializable {
    val meters: Double? = null
    val feet: Double? = null
}

class Diameter: Serializable {
    val meters: Double? = null
    val feet: Double? = null
}

class Mass: Serializable {
    val kg: Int? = null
    val lb: Int? = null
}

class FirstStage: Serializable {
    val thrust_sea_level: ThrustSeaLevel? = null
    val thrust_vacuum: ThrustVacuum? = null
    val reusable: Boolean? = null
    val engines: Int? = null
    val fuel_amount_tons: Double? = null
    val burn_time_sec: Int? = null
}

class ThrustSeaLevel: Serializable {
    val kN: Int? = null
    val lbf: Int? = null
}

class ThrustVacuum: Serializable {
    val kN: Int? = null
    val lbf: Int? = null
}

class SecondStage: Serializable {
    val thrust: Thrust? = null
    val payloads: Payloads? = null
    val reusable: Boolean? = null
    val engines: Int? = null
    val fuel_amount_tons: Double? = null
    val burn_time_sec: Int? = null
}

class Thrust: Serializable {
    val kN: Int? = null
    val lbf: Int? = null
}

class Payloads: Serializable {
    val composite_fairing: CompositeFairing? = null
    val option1: String? = null
}

class CompositeFairing: Serializable {
    val height: Height? = null
    val diameter: Diameter? = null
}

class Engines: Serializable {
    val isp: Isp? = null
    val thrust_sea_level: ThrustSeaLevel? = null
    val thrust_vacuum: ThrustVacuum? = null
    val number: Int? = null
    val type: String? = null
    val version: String? = null
    val layout: String? = null
    val engine_loss_max: Int? = null
    val propellant1: String? = null
    val propellant2: String? = null
    val thrust_to_weight: Double? = null
}

class Isp: Serializable {
    val sea_level: Int? = null
    val vacuum: Int? = null
}

class LandingLegs: Serializable {
    val number: Int? = null
    val material: Any? = null
}