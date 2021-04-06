package com.example.drawabledemo

import android.graphics.*
import android.graphics.drawable.Drawable

class MeshDrawable : Drawable() {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        paint.strokeWidth = 2.dp
        paint.color  = Color.RED
    }
    override fun draw(canvas: Canvas) {
        var x = bounds.left.toFloat()
        while (x < bounds.right) {
            canvas.drawLine(
                x, bounds.top.toFloat(),
                x, bounds.bottom.toFloat(), paint
            )
            x += 10.dp
        }
        var y = bounds.top.toFloat()
        while (y < bounds.bottom) {
            canvas.drawLine(
                bounds.left.toFloat(), y,
                bounds.right.toFloat(), y, paint
            )
            y += 10.dp
        }
    }

    override fun setAlpha(alpha: Int) {
        paint.alpha = alpha
    }

    override fun getAlpha(): Int {
        return paint.alpha
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        paint.colorFilter = colorFilter
    }

    override fun getColorFilter(): ColorFilter? {
        return paint.colorFilter
    }

    override fun getOpacity(): Int {
        return when (paint.alpha) {
            0 -> PixelFormat.TRANSPARENT
            0xff -> PixelFormat.OPAQUE
            else -> PixelFormat.TRANSLUCENT
        }
    }

}