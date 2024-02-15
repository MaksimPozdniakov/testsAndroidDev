package com.project.test1

import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class Test2 : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var constraintLayout: ConstraintLayout
    private lateinit var constraintSetStart: ConstraintSet
    private lateinit var constraintSetEnd: ConstraintSet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test2)

        editText = findViewById(R.id.editText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        constraintLayout = findViewById(R.id.mainConstraintLayout)

        // Initialize ConstraintSets
        constraintSetStart = ConstraintSet()
        constraintSetStart.clone(constraintLayout)

        constraintSetEnd = ConstraintSet()
        constraintSetEnd.clone(this, R.layout.activity_main_expanded)

        editText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                expandEditText()
            }
        }

        sendButton.setOnClickListener {
            collapseEditText()
        }
    }

    private fun expandEditText() {
        TransitionManager.beginDelayedTransition(constraintLayout, ChangeBounds().apply {
            duration = 300
            interpolator = AccelerateDecelerateInterpolator()
        })
        constraintSetEnd.applyTo(constraintLayout)
    }

    private fun collapseEditText() {
        TransitionManager.beginDelayedTransition(constraintLayout, ChangeBounds().apply {
            duration = 300
            interpolator = AccelerateDecelerateInterpolator()
        })
        constraintSetStart.applyTo(constraintLayout)
        editText.clearFocus() // Сброс фокуса, чтобы клавиатура скрылась
    }

    // Обработчик нажатия на пустую область экрана
    fun onEmptyAreaClicked(view: View) {
        collapseEditText()
    }
}