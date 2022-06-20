package com.cafeyn.presentation.ui.news

import com.cafeyn.presentation.databinding.MyNewsActivityBinding
import com.cafeyn.presentation.ui.coreview.BaseActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MyNewsActivity :
    BaseActivity<MyNewsActivityBinding>(
        MyNewsActivityBinding::inflate
    ) {

    override fun afterOnCreate() {
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}