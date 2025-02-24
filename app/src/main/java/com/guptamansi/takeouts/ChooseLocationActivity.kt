package com.guptamansi.takeouts

import com.guptamansi.takeouts.R
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.guptamansi.takeouts.databinding.ActivityChooseLocationBinding

class ChooseLocationActivity : AppCompatActivity() {

    private val binding: ActivityChooseLocationBinding by lazy {
        ActivityChooseLocationBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val locationList = arrayOf("Delhi", "Mumbai", "Kolkata", "Chennai", "Bangalore")
        val adapter = ArrayAdapter(this, R.layout.custom_dropdown_item1, locationList)
        binding.listOfLocation.setAdapter(adapter)

        binding.listOfLocation.setOnFocusChangeListener{
                _, hasFocus ->
            if(hasFocus){
                binding.listOfLocation.post{
                    binding.listOfLocation.dropDownWidth = binding.textInputLayout.width
                }
            }
        }


        binding.btnSetLocation.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}