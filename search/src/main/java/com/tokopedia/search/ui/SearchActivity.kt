package com.tokopedia.search.ui

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.tokopedia.abstraction.base.BaseActivity
import com.tokopedia.search.R
import com.tokopedia.search.data.entity.Product
import com.tokopedia.search.di.DaggerSearchComponent
import javax.inject.Inject

class SearchActivity: BaseActivity() {

		override fun contentView(): Int = R.layout.activity_search

		@Inject lateinit var viewModelFactory: ViewModelProvider.Factory
		private lateinit var viewModel: SearchViewModel

		override fun initView() {
				viewModel = ViewModelProviders
						.of(this, viewModelFactory)
						.get(SearchViewModel::class.java)
		}

		override fun injector() {
				DaggerSearchComponent.builder()
						.searchModule(SearchModule())
						.build()
						.inject(this)
		}

		companion object {
				private const val KEY_LABEL = "label"

				fun show(context: Context, label: String): Intent {
						val intent = Intent(context, SearchActivity::class.java)
						intent.putExtra(KEY_LABEL, label)
						return intent
				}
		}

}