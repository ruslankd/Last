package com.example.last.mvpexample

import android.os.Bundle
import com.example.last.databinding.ActivityExampleBinding
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class ExampleActivity : MvpAppCompatActivity(), ExampleView {

    private lateinit var binding: ActivityExampleBinding

    private val presenter by moxyPresenter { ExamplePresenter(CountersModel()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExampleBinding.inflate(layoutInflater)
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