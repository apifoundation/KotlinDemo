package com.example.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

/**
 * Created by Jorge Mendoza, for API Foundation on 2020/02/21.
 */
class CustomView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint()
    private val oval = RectF()
    private var startAngle = 120f
    private var sweepAngle = 150f
    private var runnable: Runnable = object : Runnable {
        override fun run() {

            if (startAngle <= 360) {
                startAngle += 10
            } else {
                startAngle = 10f
            }
            invalidate();
            postDelayed(this, 30)
        }
    }

    init {
        post(runnable)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //changes color of our spinner icon
        paint.color = Color.GREEN
//        paint.color = Color.BLUE


        paint.isAntiAlias = true


        //Changes thickness of spinner icon stroke
        paint.strokeWidth = 22f
//        paint.strokeWidth = 7f


        //Changes whether the spinner will be filled in or only the outline will display
//        paint.style = Paint.Style.FILL_AND_STROKE
        paint.style = Paint.Style.STROKE

        //Changes general size and shape of our spinner icon
        oval.set(width / 2 - 50f, height / 2 - 50f, width / 2 + 50f, height / 2 + 50f)

        //Draws our spinner on the screen
        canvas?.drawArc(oval, startAngle, sweepAngle, false, paint)
    }


}