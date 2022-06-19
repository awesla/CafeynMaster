package com.cafeyn.presentation.ui.coreview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.cafeyn.presentation.ui.news.MyNewsActivity


abstract class BaseFragment<VB : ViewBinding>(
    private val bindingFactory: (LayoutInflater) -> VB,
) : Fragment() {

    private var _mBinding: VB? = null
    open val mBinding: VB get() = requireNotNull(_mBinding)

    /**
     * This method will be called after [onViewCreated]
     */
    open fun afterOnViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) = Unit

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (_mBinding == null) {
            _mBinding = bindingFactory(layoutInflater)
        }
        return mBinding.root
    }

    /**
     * This will handle simple [onViewCreated] behavior
     * If you want to make one time call for initialising view only when [Fragment] is launched ==
     * ==> you must call only [oneTimeViewCreated] in your [Fragment]
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        afterOnViewCreated(view, savedInstanceState)
    }

    /**
     * Set loading [ProgressBar] status
     */
    fun setLoading(loading: Boolean) {
        when (activity) {
            is MyNewsActivity -> {
                (activity as BaseActivity<*>).apply {
                    this.setLoading(loading)
                }
            }
        }
    }
}