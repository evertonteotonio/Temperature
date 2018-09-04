package com.teotonio.everton.br.temperature

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_temperatura.*

class TemperaturaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temperatura)

        lerTemperature()

    }

    private fun lerTemperature() {

        val database = FirebaseDatabase.getInstance().reference

        database.child("temperature")
                .addValueEventListener(object: ValueEventListener {
                    override fun onCancelled(p0: DatabaseError?) {

                    }

                    override fun onDataChange(p0: DataSnapshot?) {
                        val temp: Double? = p0?.getValue(Double::class.java)
                        tvTempretatura.text = "${temp.toString()}"
                    }


                })

    }
}
