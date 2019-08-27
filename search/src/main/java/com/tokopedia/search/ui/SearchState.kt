package com.tokopedia.search.ui

sealed class SearchState {
		object ShowLoading: SearchState()
		object HideLoading: SearchState()
}