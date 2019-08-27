package com.tokopedia.abstraction.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity() {

		abstract fun contentView(): Int
		abstract fun injector()
		abstract fun initView()

		override fun onCreate(savedInstanceState: Bundle?) {
				super.onCreate(savedInstanceState)
				setContentView(contentView())
				injector()
				initView()
		}

}