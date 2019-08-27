package com.tokopedia.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by isfaaghyth on 20/04/19.
 * github: @isfaaghyth
 */

object Network {
		private const val PING_INTERVAL = 30L
		private const val REQUEST_TIME_OUT = 60L

		fun service(url: String = BuildConfig.MAIN_URL): Retrofit {
				return Retrofit.Builder()
						.baseUrl(url)
						.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
						.addConverterFactory(GsonConverterFactory.create())
						.client(httpClient())
						.build()
		}

		private fun httpClient(): OkHttpClient {
				return OkHttpClient.Builder()
						.retryOnConnectionFailure(true)
						.addInterceptor(createLoggingInterceptor())
						.pingInterval(PING_INTERVAL, TimeUnit.SECONDS)
						.readTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)
						.connectTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)
						.build()
		}

		private fun createLoggingInterceptor(): HttpLoggingInterceptor {
				val interceptor = HttpLoggingInterceptor()
				interceptor.level = HttpLoggingInterceptor.Level.BODY
				return interceptor
		}
}