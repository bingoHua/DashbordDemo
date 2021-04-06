package com.example.drawabledemo

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View

class DrawableView(context: Context?, attrs: AttributeSet?) :
    View(context, attrs) {

    private val meshDrawable = MeshDrawable()
    override fun onDraw(canvas: Canvas) {
        meshDrawable.setBounds(0, 0, width, height)
        meshDrawable.draw(canvas)
    }
}

val Float.dp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        Resources.getSystem().displayMetrics
    )

val Int.dp
    get() = this.toFloat().dp