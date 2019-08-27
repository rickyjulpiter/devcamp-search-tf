package com.tokopedia.search.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tokopedia.abstraction.base.BaseViewModel
import com.tokopedia.abstraction.helper.thread.SchedulerProvider
import com.tokopedia.search.data.entity.ProductData
import com.tokopedia.search.repository.SearchRepository
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class SearchViewModel @Inject constructor(
		private val repository: SearchRepository,
		private val scheduler: SchedulerProvider
): BaseViewModel() {

		private val _result = MutableLiveData<ProductData>()
		val result: LiveData<ProductData>
				get() = _result

		private val _error = MutableLiveData<String>()
		val error: LiveData<String>
				get() = _error

		fun getProductSearch(query: String) {
				add {
						repository.productSearch(query)
								.observeOn(scheduler.ui())
								.subscribeOn(scheduler.io())
								.subscribeBy(
										onNext = {
												_result.postValue(it.result)
										},
										onError = {
												_error.postValue(it.message)
										}
								)
				}
		}

}