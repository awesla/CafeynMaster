package com.cafeyn.presentation.ui.news.listing

import android.os.Bundle
import android.view.View
import com.cafeyn.presentation.databinding.MyNewsFragmentBinding
import com.cafeyn.presentation.ui.coreview.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyNewsFragment : BaseFragment<MyNewsFragmentBinding>(
    MyNewsFragmentBinding::inflate
) {
    override fun afterOnViewCreated(view: View, savedInstanceState: Bundle?) {
        super.afterOnViewCreated(view, savedInstanceState)
    }
}