package com.tokopedia.search.ui

import com.tokopedia.abstraction.helper.thread.AppSchedulerProvider
import com.tokopedia.abstraction.helper.thread.SchedulerProvider
import com.tokopedia.network.Network.service
import com.tokopedia.search.data.SearchServices
import com.tokopedia.search.di.SearchScope
import com.tokopedia.search.repository.SearchRepository
import com.tokopedia.search.repository.SearchRepositoryImpl
import dagger.Module
import dagger.Provides

@Module class SearchModule {

		@SearchScope
		@Provides
		fun provideServices(): SearchServices {
				return service().create(SearchServices::class.java)
		}

		@SearchScope
		@Provides
		fun provideSearchRepository(services: SearchServices): SearchRepository {
				return SearchRepositoryImpl(services)
		}

		@SearchScope
		@Provides
		fun provideSchedulerProvider(): SchedulerProvider {
				return AppSchedulerProvider()
		}

}