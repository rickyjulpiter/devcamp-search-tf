package com.tokopedia.search.repository

import com.tokopedia.search.data.SearchServices
import com.tokopedia.search.data.entity.ProductData
import com.tokopedia.search.data.entity.Search
import io.reactivex.Flowable
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
		private val services: SearchServices
): SearchRepository {

		override fun productSearch(query: String): Flowable<Search<ProductData>> {
				return services.getProductResult(query)
		}

}