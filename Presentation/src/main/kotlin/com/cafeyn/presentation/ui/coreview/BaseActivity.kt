package com.cafeyn.presentation.ui.coreview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.cafeyn.presentation.R

abstract class BaseActivity<VB : ViewBinding>(
    private val bindingFactory: (LayoutInflater) -> VB
) : AppCompatActivity() {

    lateinit var binding: VB
    private var loadingView: View? = null

    abstract fun afterOnCreate()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindingFactory(layoutInflater)
        val view = binding.root
        setContentView(view)

        initView(view)
        afterOnCreate()
    }

    private fun initView(view: View) {
        loadingView = view.findViewById(R.id.loadingView)
    }

    /**
     * This method to set if [AppCompatActivity] is loading data or not
     * If it is loading data we will show the loader
     */
    fun setLoading(isLoading: Boolean) {
        loadingView?.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}