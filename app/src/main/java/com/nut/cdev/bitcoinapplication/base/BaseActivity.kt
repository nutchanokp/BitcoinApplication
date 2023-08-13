package com.nut.cdev.bitcoinapplication.base

import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.nut.cdev.bitcoinapplication.router.MainRouter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import org.koin.android.ext.android.inject
import kotlin.coroutines.CoroutineContext

abstract class BaseActivity<Binding : ViewDataBinding> :
    AppCompatActivity(),
    CoroutineScope {

    lateinit var router: MainRouter
    protected lateinit var binding: Binding

    val prefs: PreferenceManager by inject()

    override val coroutineContext: CoroutineContext get() = Job() + Dispatchers.Main
    protected abstract fun getLayoutResId(): Int
    private fun initRouter() {
        router = MainRouter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutResId())
        binding.lifecycleOwner = this

        initRouter()

        initView()
        initInstances()

        setupObserve()
    }

    abstract fun initView()
    abstract fun initInstances()
    abstract fun setupObserve()

}
