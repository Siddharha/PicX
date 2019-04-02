package `in`.creativelizard.picx

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.view.MotionEvent






class MainActivity : AppCompatActivity() {

    var dX: Float = 0.toFloat()
    var dY:Float = 0.toFloat()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rbPanel.setOnTouchListener { view, event ->
            val action = event.action
            when (action) {

                MotionEvent.ACTION_DOWN -> {

                    dX = view.x - event.rawX
                    dY = view.y - event.rawY
                }

                MotionEvent.ACTION_MOVE ->

                    view.animate()
                        .x(event.rawX + dX)
                        .y(event.rawY + dY)
                        .setDuration(0)
                        .start()
                else -> return@setOnTouchListener false
            }
            return@setOnTouchListener true
        }
    }


}
