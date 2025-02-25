package com.guptamansi.takeouts

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //before the theme was set to NOActionBar -MG
        //but the actionbar to used to set up the navcontroller so I had to change the theme -MG
        //I also did not want the action bar to be displayed in the app, so I hid it in all the activities -MG
        supportActionBar?.hide()

        // These insets were causing the bottomnavigation bar to not stick to the bottom of the screen so I removed them - MG
       // ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
        //    val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
       //     v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
       //     insets
       // }



        // here the fragment tag is used for navhostfragment which is not the right practice -MG
        //var NavController = findNavController(R.id.fragmentContainerView8)
        //var bottomnav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
       // bottomnav.setupWithNavController(NavController)



        // here the fragmentviewcontainer tag is used for navhostfragment which is the right practice -MG
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView8) as NavHostFragment
        navController = navHostFragment.navController

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setupWithNavController(navController)

        setupActionBarWithNavController(navController)


    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}