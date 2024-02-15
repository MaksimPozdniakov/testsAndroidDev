package com.project.test1

import android.animation.AnimatorInflater
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.project.test1.databinding.ActivityTest3Binding

class Test3 : AppCompatActivity() {
    private lateinit var binding : ActivityTest3Binding
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        binding = ActivityTest3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // для первого и второго варианта
//        binding.scrollView.viewTreeObserver.addOnScrollChangedListener {
//            val scrollView = binding.scrollView
//            val scrollViewHeight = scrollView.height
//            val scrollViewChildHeight = scrollView.getChildAt(0).height
//            val diff = scrollViewChildHeight - scrollViewHeight
//            val scrollY = scrollView.scrollY
//            if (scrollY == diff) {
//                expandBottomPanel()
//            } else {
//                collapseBottomPanel()
//            }
//        }

        // метод для третьего варианта
        animateBottomPanel()
    }
    private fun expandBottomPanel() {
        // Первый вариант
//        binding.llButtons.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_blue_dark))
//        // Реализуйте анимацию растягивания панели
//        binding.llButtons.layoutParams.width = resources.getDimensionPixelSize(R.dimen.new_layout_width)
//        binding.llButtons.requestLayout()


        // Второй вариант с доп файлом width_animator
//        binding.llButtons.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_blue_dark))
//
//        // Получение текущей ширины панели
//        val oldWidth = binding.llButtons.width
//
//        // Получение новой ширины панели из ресурсов
//        val newWidth = resources.getDimensionPixelSize(R.dimen.new_layout_width)
//
//        // Создание аниматора свойств
//        val widthAnimator = ValueAnimator.ofInt(oldWidth, newWidth)
//
//        // Установка продолжительности анимации
//        widthAnimator.duration = 500
//
//        // Установка слушателя для обновления параметров панели
//        widthAnimator.addUpdateListener { animation ->
//            val animatedValue = animation.animatedValue as Int
//            val layoutParams = binding.llButtons.layoutParams
//            layoutParams.width = animatedValue
//            binding.llButtons.layoutParams = layoutParams
//        }
//
//        // Применение анимации
//        widthAnimator.start()
    }

    private fun collapseBottomPanel() {
//        binding.llButtons.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_green_dark))
//        // Реализуйте анимацию сворачивания панели
//        binding.llButtons.layoutParams.width = resources.getDimensionPixelSize(R.dimen.old_layout_width)
//        binding.llButtons.requestLayout()



//        binding.llButtons.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_green_dark))
//
//        // Получение текущей ширины панели
//        val oldWidth = binding.llButtons.width
//
//        // Получение новой ширины панели из ресурсов
//        val newWidth = resources.getDimensionPixelSize(R.dimen.old_layout_width)
//
//        // Создание аниматора свойств
//        val widthAnimator = ValueAnimator.ofInt(oldWidth, newWidth)
//
//        // Установка продолжительности анимации
//        widthAnimator.duration = 500
//
//        // Установка слушателя для обновления параметров панели
//        widthAnimator.addUpdateListener { animation ->
//            val animatedValue = animation.animatedValue as Int
//            val layoutParams = binding.llButtons.layoutParams
//            layoutParams.width = animatedValue
//            binding.llButtons.layoutParams = layoutParams
//        }
//
//        // Применение анимации
//        widthAnimator.start()
    }

    // метод для третьего варианта
    private fun animateBottomPanel() {
        binding.scrollView.viewTreeObserver.addOnScrollChangedListener {
            val maxScroll = binding.scrollView.getChildAt(0).height - binding.scrollView.height
            val currentScroll = binding.scrollView.scrollY

            val percentageScrolled = currentScroll.toFloat() / maxScroll.toFloat()
            val initialPanelWidth = resources.getDimensionPixelSize(R.dimen.initial_panel_width)
            val newPanelWidth = initialPanelWidth + (percentageScrolled *
                    (resources.getDimensionPixelSize(R.dimen.max_panel_width) - initialPanelWidth)).toInt()

            val layoutParams = binding.llButtons.layoutParams
            layoutParams.width = newPanelWidth
            binding.llButtons.layoutParams = layoutParams
        }
    }

}
