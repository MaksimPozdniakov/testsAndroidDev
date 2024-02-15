package com.project.test1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.project.test1.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        /* блок с примером для Progress Bar
        progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val button30 = findViewById<Button>(R.id.bt30)
        val button60 = findViewById<Button>(R.id.bt60)
        val button90 = findViewById<Button>(R.id.bt90)

        button30.setOnClickListener {
            progressBarMethod2(30)
        }

        button60.setOnClickListener {
            progressBarMethod2(60)
        }

        button90.setOnClickListener {
            progressBarMethod2(90)
        }

        //progressBarMethod()
        */

        radioGroupMethod()

        binding.move.setOnClickListener{
            val intent = Intent(this, Test2::class.java)
            startActivity(intent)
        }
        binding.move2.setOnClickListener{
            val intent = Intent(this, Test3::class.java)
            startActivity(intent)
        }
    }

    // Пример с циклом
    private fun progressBarMethod() {

        // Начать загрузку данных
        // Например, выполнить запрос к серверу
        // Во время загрузки обновлять прогресс
        // Примерно так (в реальном приложении это будет зависеть от вашей реализации загрузки данных):
        progressBar.visibility = View.VISIBLE // Показать ProgressBar

        // Запустить асинхронную задачу с использованием Coroutine
        CoroutineScope(Dispatchers.Main).launch {
            // В цикле обновляем прогресс
            for (i in 0 until 100) {
                // Имитируем задержку загрузки
                delay(100)

                // Обновляем прогресс в основном потоке
                progressBar.progress = i
            }

            // По завершении загрузки скрываем ProgressBar
            progressBar.visibility = View.GONE
        }
    }

    // Пример без цикла
    private fun progressBarMethod2(progress: Int) {
        progressBar.progress = progress
    }

    private fun radioGroupMethod() {
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val radioButton1 = findViewById<RadioButton>(R.id.radioButton1)
        val radioButton2 = findViewById<RadioButton>(R.id.radioButton2)
        val radioButton3 = findViewById<RadioButton>(R.id.radioButton3)

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            val radioButton: RadioButton = findViewById(checkedId)
            // Действия при выборе RadioButton
            when (radioButton) {
                radioButton1 -> {
                    // Обработка выбора варианта 1
                    Toast.makeText(this, "radioButton1", Toast.LENGTH_SHORT).show()
                }
                radioButton2 -> {
                    // Обработка выбора варианта 2
                    Toast.makeText(this, "radioButton2", Toast.LENGTH_SHORT).show()
                }
                radioButton3 -> {
                    // Обработка выбора варианта 3
                    val text: String = radioButton3.text.toString()
                    Snackbar.make(findViewById(android.R.id.content), text, Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }
}