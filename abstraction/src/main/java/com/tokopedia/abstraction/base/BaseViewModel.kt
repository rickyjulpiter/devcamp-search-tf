package com.tokopedia.abstraction.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class BaseViewModel: ViewModel() {

		protected val compositeDisposable = CompositeDisposable()

		fun add(invoke:() -> Disposable) {
				compositeDisposable.add(invoke())
		}

		override fun onCleared() {
				super.onCleared()
				compositeDisposable.clear()
		}

}