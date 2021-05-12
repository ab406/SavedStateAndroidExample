package com.ab406.simplesavedstateexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import com.ab406.simplesavedstateexample.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, SavedStateViewModelFactory(this.application, this))
            .get(MainViewModel::class.java)

        binding.image1.setOnClickListener {
            it?.let { img1 ->
                saveAndNavigateToSecondActivity(img1)
            }
        }

        binding.image2.setOnClickListener {
            it?.let { img2 ->
                saveAndNavigateToSecondActivity(img2)
            }
        }

        binding.image3.setOnClickListener {
            it?.let { img3 ->
                saveAndNavigateToSecondActivity(img3)
            }
        }


    }

    private fun saveAndNavigateToSecondActivity(imageView: View) {
        imageView.alpha = 0.5f
        viewModel.saveImage(imageView.tag.toString())
        Intent(this, SecondActivity::class.java).apply {
            putExtra("key", imageView.tag.toString())
        }.also {
            startActivity(it)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.savedImage.observe(this) {
            it?.let { tag ->
                binding.image1.alpha = if (binding.image1.tag.toString() == tag) 0.5f else 1.0f
                binding.image2.alpha = if (binding.image2.tag.toString() == tag) 0.5f else 1.0f
                binding.image3.alpha = if (binding.image3.tag.toString() == tag) 0.5f else 1.0f
            }
        }
    }
}


