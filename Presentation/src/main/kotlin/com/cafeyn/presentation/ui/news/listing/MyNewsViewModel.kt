package com.cafeyn.presentation.ui.news.listing

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cafeyn.core.extentions.setLoadingState
import com.cafeyn.core.misc.*
import com.cafeyn.domain.FetchMyNewsUseCase
import com.cafeyn.domain.ValidateNewsDataUseCase
import com.cafeyn.domain.models.MyNews
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MyNewsViewModel @Inject constructor(
    private val fetchMyNewsUseCase: FetchMyNewsUseCase,
    private val validateNewsDataUseCase: ValidateNewsDataUseCase
) : ViewModel() {

    private val _myNews = MutableLiveData<DataWrapper<List<MyNews>?>>()
    val myNews: MutableLiveData<DataWrapper<List<MyNews>?>> get() = _myNews

    fun fetchData() {
        _myNews.setLoadingState(true)
        viewModelScope.launch {
            try {
                val listNews = fetchMyNewsUseCase()

                _myNews.setLoadingState(false)
                if (validateNewsDataUseCase.invoke(listNews).successful) {
                    _myNews.value = Success(listNews)
                } else {
                    _myNews.value = EmptySuccess(null)
                }

            } catch (exception: Exception) {
                _myNews.setLoadingState(false)
                _myNews.value = Failure(TechnicalError)
            }
        }
    }
}