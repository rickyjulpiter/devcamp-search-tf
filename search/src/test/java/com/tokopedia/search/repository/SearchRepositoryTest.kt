package com.tokopedia.search.repository

import com.tokopedia.abstraction.helper.thread.SchedulerProvider
import com.tokopedia.abstraction.helper.thread.TestSchedulerProvider
import com.tokopedia.search.data.SearchServices
import com.tokopedia.search.data.entity.Product
import com.tokopedia.search.data.entity.ProductData
import com.tokopedia.search.data.entity.Search
import io.reactivex.Flowable
import io.reactivex.rxkotlin.subscribeBy
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class SearchRepositoryTest {

		private var services = mock(SearchServices::class.java)
		private lateinit var schedulerProvider: SchedulerProvider
		private lateinit var repository: SearchRepository
		private var productsFlowable = Flowable.just(searchProducts)

		@Before fun setUp() {
				schedulerProvider = TestSchedulerProvider()
				repository = SearchRepositoryImpl(services)
		}

		@Test fun `should return product list`() {
				`when`(services.getProductResult(QUERY)).thenReturn(productsFlowable)
				repository.productSearch(QUERY)
				verify(services, atLeastOnce()).getProductResult(QUERY)
		}

		@Test fun `should success return error while querying empty`() {
				`when`(services.getProductResult("")).thenReturn(productsFlowable)
				repository.productSearch("")
				verify(services, atLeastOnce()).getProductResult("")
		}

		@After fun tearDown() {
				clearInvocations(services)
		}

		companion object {
				private const val QUERY = "jaket"

				//data mock
				private val product = Product()
				private val products = ProductData(arrayListOf(product))
				private val searchProducts = Search(products)
		}

}