package com.tokopedia.search.data

import com.tokopedia.search.data.entity.ProductData
import com.tokopedia.search.data.entity.Search
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchServices {

		@GET("search/v1/product")
		fun getProductResult(
				@Query("q") query: String,
				@Query("device") device: String = DEVICE,
				@Query("rows") rows: String = ROWS
		): Flowable<Search<ProductData>>

		companion object {
				private const val DEVICE = "android"
				private const val ROWS = "10"
		}

}