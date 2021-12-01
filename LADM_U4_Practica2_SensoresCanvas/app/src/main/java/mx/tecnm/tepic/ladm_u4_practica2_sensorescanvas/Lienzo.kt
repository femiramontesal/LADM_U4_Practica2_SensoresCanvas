package mx.tecnm.tepic.ladm_u4_practica2_sensorescanvas

import android.content.Context
import android.content.Context.SENSOR_SERVICE
import android.graphics.*
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService

class Lienzo(p:MainActivity, d: SensorManager, l: SensorManager): View(p), SensorEventListener {

        var acelerometro = d
        var x = 0

        var sensorBrillo = l
        var brillo = 0

    override fun onSensorChanged(event: SensorEvent?) {
        if(event?.sensor?.type == Sensor.TYPE_ACCELEROMETER){
            x = (event.values[0].toInt()*-5)

        }

        if(event?.sensor?.type == Sensor.TYPE_LIGHT){
            brillo = event.values[0].toInt()

        }

    }


    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        return
    }


    var circuloX = (1..1000).random()
    var circuloY = 0


    var circuloX2 = (1..1000).random()
    var circuloY2 = 0

    var circuloX3 = (1..1000).random()
    var circuloY3 = 0

    var circuloX4 = (1..1000).random()
    var circuloY4 = 0

    var circuloX5 = (1..1000).random()
    var circuloY5 = 0

    public var cambioX = 0

    val movimientos = object : CountDownTimer(2000,80){

        override fun onTick(p0: Long) {

            cambioX = x

            circuloX = circuloX+cambioX
            if(circuloX<-50){
                circuloX=1100
            }else if(circuloX>1200){
                circuloX=0
            }
            circuloY= circuloY+(1..50).random()
            if(circuloY>2000){
                circuloY = -300

                circuloX = (10..1000).random() // generated random from 0 to 10 included

            }
            circuloX2 = circuloX2 + cambioX
            if(circuloX2<-50){
                circuloX2=1100
            }else if(circuloX2>1200){
                circuloX2=0
            }
            circuloY2= circuloY2+(1..50).random()
            if(circuloY2>2000){
                circuloY2 = -300

                circuloX2 = (10..1000).random() // generated random from 0 to 10 included

            }

            circuloX3 = circuloX3 + cambioX
            if(circuloX3<-50){
                circuloX3=1100
            }else if(circuloX3>1200){
                circuloX3=0
            }
            circuloY3= circuloY3+(1..50).random()
            if(circuloY3>2000){
                circuloY3 = -300

                circuloX3 = (10..1000).random() // generated random from 0 to 10 included

            }

            circuloX4 = circuloX4 + cambioX
            if(circuloX4<-50){
                circuloX4=1100
            }else if(circuloX4>1200){
                circuloX4=0
            }
            circuloY4= circuloY4+  (1..50).random()
            if(circuloY4>2000){
                circuloY4 = -300

                circuloX4 = (10..1000).random() // generated random from 0 to 10 included

            }

            circuloX5 = circuloX5 + cambioX
            if(circuloX5<-50){
                circuloX5=1100
            }else if(circuloX5>1200){
                circuloX5=0
            }
            circuloY5= circuloY5+  (1..50).random()
            if(circuloY5>2000){
                circuloY5 = -300

                circuloX5 = (10..1000).random() // generated random from 0 to 10 included

            }

            invalidate() //forzas a onDraw a repintar

        }

        override fun onFinish() {
            start()
        }

    }
    //constructor
    init {
        movimientos.start()

    }

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        val p = Paint()

        acelerometro.registerListener(this,
            acelerometro.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL)

        sensorBrillo.registerListener(this,
            sensorBrillo.getDefaultSensor(Sensor.TYPE_LIGHT), SensorManager.SENSOR_DELAY_NORMAL)

        var col = Color.parseColor("#3283a8")

        if (brillo < 100){
            col = Color.parseColor("#000000")
        }else{
            col = Color.parseColor("#3283a8")
        }

        c.drawColor(col)
        //Bola 1
        p.color = Color.WHITE
        c.drawCircle(0f+circuloX, circuloY-100f, 90f, p)
        //Bola 2
        p.color = Color.WHITE
        c.drawCircle(0f+circuloX2, circuloY2-100f, 90f, p)
        //Bola 3
        p.color = Color.WHITE
        c.drawCircle(0f+circuloX3, circuloY3-100f, 90f, p)
        //Bola 4
        p.color = Color.WHITE
        c.drawCircle(0f+circuloX4, circuloY4-100f, 90f, p)
        //Bola 5
        p.color = Color.WHITE
        c.drawCircle(0f+circuloX5, circuloY5-100f, 90f, p)

        //c.drawBitmap(bruja,posX,150f,p)

    }

}