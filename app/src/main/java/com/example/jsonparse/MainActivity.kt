package com.example.jsonparse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jsonparse.databinding.ActivityMainBinding
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var JsonString = "{\"employee\":{\"name\":\"Biden\",\"salary\":65.000$}}"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        try {
            val obj = JSONObject(JsonString)

            val emp:JSONObject = obj.getJSONObject("employee")

            val name = emp.getString("name")
            val salary = emp.getString("salary")

            binding.myName.text = "Name:  $name"

            binding.mySalary.text = "Salary $salary"

        }catch (e:JSONException){
            e.printStackTrace()
        }
    }
}