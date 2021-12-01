package mx.tecnm.tepic.ladm_u4_practica2_sensorescanvas

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import mx.tecnm.tepic.ladm_u4_practica2_sensorescanvas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()  {
    lateinit var b : ActivityMainBinding

    lateinit var sensorManager : SensorManager
    lateinit var sensorManagerLuz : SensorManager //lateinit = no se asigna memoria, ni null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        val view = b.root
        setContentView(view)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        sensorManagerLuz = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        setContentView(Lienzo(this,sensorManager, sensorManagerLuz))
    }



}


