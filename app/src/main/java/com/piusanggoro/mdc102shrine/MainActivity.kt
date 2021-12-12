package com.piusanggoro.mdc102shrine

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.piusanggoro.mdc102shrine.gridfragment.ProductGridFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shr_main_activity)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container, ProductGridFragment())
                .commit()
        }
    }
}