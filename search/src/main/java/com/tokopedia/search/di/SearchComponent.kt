package com.tokopedia.search.di

import com.tokopedia.search.ui.SearchActivity
import com.tokopedia.search.ui.SearchModule
import com.tokopedia.search.ui.SearchViewModelModule
import dagger.Component

@SearchScope
@Component(modules = [SearchModule::class, SearchViewModelModule::class])
interface SearchComponent {
		fun inject(activity: SearchActivity)
}