package com.vahairston.diceroller

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.FrameLayout
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var modeSelectionSpinner: Spinner
    lateinit var fragmentHolder: FrameLayout
    lateinit var statsFragment: StatsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpLayout()
    }

    private fun setUpLayout() {
        modeSelectionSpinner = findViewById(R.id.modeSelectionDropdown)
        modeSelectionSpinner.adapter = ArrayAdapter(
            this,
            R.layout.support_simple_spinner_dropdown_item,
            resources.getStringArray(R.array.modes)
        )

        fragmentHolder = findViewById(R.id.fragmentHolder)

        statsFragment = StatsFragment.newInstance()

        supportFragmentManager.beginTransaction().add(R.id.fragmentHolder, statsFragment).commit()

    }
}
