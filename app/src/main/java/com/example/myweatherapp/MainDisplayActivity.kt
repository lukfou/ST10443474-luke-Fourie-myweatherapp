package com.example.myweatherapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainDisplayActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)
         val txtView1 = findViewById<TextView>(R.id.txtView1)
                val txtView2 = findViewById<TextView>(R.id.txtView2)
                val avgText = findViewById<TextView>(R.id.avgText)

                val selectedDay = intent.getStringExtra("selectedDay")
                val weatherData = getWeatherData(selectedDay)

                txtView1.text = "Min Temperature: ${weatherData.minTemperature}°C"
                txtView2.text = "Max Temperature: ${weatherData.maxTemperature}°C"

                // Calculate the average temperature for the week
                val weeklyWeatherData = arrayOf(
                    WeatherData(13, 18, "Sunny"),
                    WeatherData(19, 23, "Partly Cloudy"),
                    WeatherData(16, 24, "Sunny"),
                    WeatherData(18, 21, "Cloudy"),
                    WeatherData(13, 15, "Rain"),
                    WeatherData(23, 26, "Sunny"),
                    WeatherData(27, 31, "Sunny")
                )

                var totalMinTemp = 0
                var totalMaxTemp = 0

                for (dayWeatherData in weeklyWeatherData) {
                    totalMinTemp += dayWeatherData.minTemperature
                    totalMaxTemp += dayWeatherData.maxTemperature
                }

                val averageMinTemp = totalMinTemp / weeklyWeatherData.size
                val averageMaxTemp = totalMaxTemp / weeklyWeatherData.size

                avgText.text = "Average Temperature for the Week: $averageMinTemp°C - $averageMaxTemp°C"
            }

            private fun getWeatherData(selectedDay: String?): WeatherData {
                return when (selectedDay) {
                    "Monday" -> WeatherData(13, 18, "Sunny")
                    "Tuesday" -> WeatherData(19, 23, "Partly Cloudy")
                    "Wednesday" -> WeatherData(16, 24, "Sunny")
                    "Thursday" -> WeatherData(18, 21, "Cloudy")
                    "Friday" -> WeatherData(13, 15, "Rain")
                    "Saturday" -> WeatherData(23, 26, "Sunny")
                    "Sunday" -> WeatherData(27, 31, "Sunny")
                    else -> WeatherData(0, 0, "")
                }
            }

    class WeatherData(i: Int, i1: Int, s: String) : Parcelable {
        constructor(parcel: Parcel) : this(
            TODO("i"),
            TODO("i1"),
            TODO("s")
        ) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {

        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<WeatherData> {
            override fun createFromParcel(parcel: Parcel): WeatherData {
                return WeatherData(parcel)
            }

            override fun newArray(size: Int): Array<WeatherData?> {
                return arrayOfNulls(size)
            }
        }

    }
}











