package com.devapps.notes.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.devapps.notes.R
import com.devapps.notes.databinding.ActivityMainBinding
import com.devapps.notes.presentation.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        replaceFragment(HomeFragment.newInstance())
        
    }

    private fun replaceFragment(fragment: Fragment) {

        val fragmentTransition = supportFragmentManager.beginTransaction()

        fragmentTransition.setCustomAnimations(
            android.R.anim.slide_out_right,
            android.R.anim.slide_in_left
        )
        fragmentTransition.replace(R.id.flFragmenet, fragment)
        fragmentTransition.commit()
    }

}
