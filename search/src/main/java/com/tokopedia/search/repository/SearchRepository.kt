package com.tokopedia.search.repository

import com.tokopedia.search.data.entity.ProductData
import com.tokopedia.search.data.entity.Search
import io.reactivex.Flowable

interface SearchRepository {
		fun productSearch(query: String): Flowable<Search<ProductData>>
}