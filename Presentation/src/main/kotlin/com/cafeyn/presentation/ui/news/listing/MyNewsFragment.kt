package com.cafeyn.presentation.ui.news.listing

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.cafeyn.core.misc.EmptySuccess
import com.cafeyn.core.misc.Failure
import com.cafeyn.core.misc.Loading
import com.cafeyn.core.misc.Success
import com.cafeyn.presentation.R
import com.cafeyn.presentation.databinding.MyNewsFragmentBinding
import com.cafeyn.presentation.ui.coreview.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MyNewsFragment : BaseFragment<MyNewsFragmentBinding>(
    MyNewsFragmentBinding::inflate
) {

    private val myNewsViewModel: MyNewsViewModel by viewModels()
    private val allNewsAdapter by lazy { MyNewsAdapter() }


    override fun afterOnViewCreated(view: View, savedInstanceState: Bundle?) {
        super.afterOnViewCreated(view, savedInstanceState)

        initView()
        observeData()
    }


    private fun initView() {
        mBinding.allNewsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = allNewsAdapter
        }

        allNewsAdapter.apply {
            itemClickListener = {

            }
        }

        myNewsViewModel.fetchData()
    }

    private fun observeData() {
        myNewsViewModel.myNews.observe(viewLifecycleOwner) {
            when (it) {
                is EmptySuccess -> mBinding.textNoItem.visibility = View.VISIBLE
                is Success -> {
                    mBinding.textNoItem.visibility = View.GONE
                    allNewsAdapter.submitList(it.data)
                }
                is Loading -> setLoading(it.loading)
                is Failure -> {
                    val alertDialogBuilder = AlertDialog.Builder(requireContext())
                    alertDialogBuilder.setTitle(R.string.text_error)
                    alertDialogBuilder.setMessage(R.string.error_message)
                    alertDialogBuilder.setPositiveButton(R.string.text_Ok) { dialog, _ ->
                        dialog.dismiss()
                        activity?.recreate()
                    }
                    alertDialogBuilder.setCancelable(false)
                    alertDialogBuilder.show()
                }
            }
        }
    }
}