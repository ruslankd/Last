package com.example.last

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.last.databinding.ActivityMainBinding
import com.example.last.mvpexample.MainPresenter
import com.example.last.mvpexample.MainView

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            btnCounter1.setOnClickListener {
                presenter.firstCounterClick()
            }
            btnCounter2.setOnClickListener {
                presenter.secondCounterClick()
            }
            btnCounter3.setOnClickListener {
                presenter.thirdCounterClick()
            }
        }
    }

    override fun setFirstCounterButtonText(text: String) {
        binding.btnCounter1.text = text
    }

    override fun setSecondCounterButtonText(text: String) {
        binding.btnCounter2.text = text
    }

    override fun setThirdCounterButtonText(text: String) {
        binding.btnCounter3.text = text
    }


}