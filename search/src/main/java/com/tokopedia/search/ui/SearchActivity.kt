package com.tokopedia.search.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tokopedia.search.R
import com.tokopedia.search.di.DaggerSearchComponent

class SearchActivity: AppCompatActivity() {

		override fun onCreate(savedInstanceState: Bundle?) {
				super.onCreate(savedInstanceState)
				setContentView(R.layout.activity_search)
				injector()
		}

		private fun injector() {
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