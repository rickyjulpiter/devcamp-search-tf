package com.tokopedia.search.ui

import com.tokopedia.abstraction.base.BaseViewModel
import com.tokopedia.abstraction.helper.thread.SchedulerProvider
import com.tokopedia.search.repository.SearchRepository
import javax.inject.Inject

class SearchViewModel @Inject constructor(
		private val repository: SearchRepository,
		private val scheduler: SchedulerProvider
): BaseViewModel()