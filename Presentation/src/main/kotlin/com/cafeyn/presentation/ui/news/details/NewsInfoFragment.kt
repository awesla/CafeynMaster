package com.cafeyn.presentation.ui.news.details

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.cafeyn.presentation.databinding.NewsInfoFragmentBinding
import com.cafeyn.presentation.ui.coreview.BaseFragment

class NewsInfoFragment : BaseFragment<NewsInfoFragmentBinding>(
    NewsInfoFragmentBinding::inflate
) {
    private val arguments: NewsInfoFragmentArgs by navArgs()

    override fun afterOnViewCreated(view: View, savedInstanceState: Bundle?) {
        super.afterOnViewCreated(view, savedInstanceState)
        fillView()
        initListener()
    }

    private fun fillView() {
        mBinding.pictureImageView.loadUrl(arguments.newsInfo.url)
        mBinding.textTitle.text = arguments.newsInfo.title
    }

    private fun initListener() {
        mBinding.imageViewBack.setOnClickListener {
            activity?.onBackPressed()
        }
    }
}