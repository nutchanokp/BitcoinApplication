package com.nut.cdev.bitcoinapplication.views.main

import android.os.Bundle
import com.nut.cdev.bitcoinapplication.R
import com.nut.cdev.bitcoinapplication.base.BaseActivity
import com.nut.cdev.bitcoinapplication.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initView() {
    }

    override fun initInstances() {
    }
}