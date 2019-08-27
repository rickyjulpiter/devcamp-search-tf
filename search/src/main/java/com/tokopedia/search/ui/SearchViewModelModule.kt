package com.tokopedia.search.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tokopedia.abstraction.helper.viewmodel.ViewModelFactory
import com.tokopedia.abstraction.helper.viewmodel.ViewModelKey
import com.tokopedia.search.di.SearchScope
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module abstract class SearchViewModelModule {

		@SearchScope
		@Binds
		internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

		@SearchScope
		@Binds
		@IntoMap
		@ViewModelKey(SearchViewModel::class)
		internal abstract fun bindSearchViewModel(viewModel: SearchViewModel): ViewModel

}