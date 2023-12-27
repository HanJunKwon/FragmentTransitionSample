package com.example.fragmenttransitionsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeFragment(AFragment.newInstance())

        findViewById<Button>(R.id.btn_change_fragment).setOnClickListener {
            changeFragment(BFragment.newInstance())
        }
    }

    /**
     * Fragment 전환 함수.
     */
    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.slide_in,
                R.anim.fade_out,
                R.anim.fade_in,
                R.anim.slide_out
            )
            .replace(R.id.fl_fragment_wrapper, fragment)        // replace() 메소드를 사용하면 결과가 다를까?
            .addToBackStack(null)
            .commit()
    }
}