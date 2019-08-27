package com.tokopedia.productsearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tokopedia.search.ui.SearchActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity() {

		override fun onCreate(savedInstanceState: Bundle?) {
				super.onCreate(savedInstanceState)
				setContentView(R.layout.activity_main)

				btnSearch.setOnClickListener {
						startActivity(SearchActivity.show(this, "sepeda"))
				}
		}

}