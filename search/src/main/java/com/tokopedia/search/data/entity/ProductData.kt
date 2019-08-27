package com.tokopedia.search.data.entity

import com.google.gson.annotations.SerializedName

data class ProductData(
		@SerializedName("products") val products: List<Product>
)