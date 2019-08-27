package com.tokopedia.search.data.entity

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by isfaaghyth on 14/02/19.
 * github: @isfaaghyth
 */
data class Product(
		@SerializedName("product_url") val productUrl: String? = "",
		@SerializedName("product_name") val productName: String? = "",
		@SerializedName("product_id") val productId: String? = "",
		@SerializedName("product_image") val productImage: String? = "",
		@SerializedName("product_price") val productPrice: String? = "",
		@SerializedName("shop_location") val shopLocation: String? = ""): Parcelable {

		constructor(parcel: Parcel) : this(
				parcel.readString(),
				parcel.readString(),
				parcel.readString(),
				parcel.readString(),
				parcel.readString(),
				parcel.readString()
		)

		override fun writeToParcel(dest: Parcel?, flags: Int) {
				dest?.writeString(productUrl)
				dest?.writeString(productName)
				dest?.writeString(productId)
				dest?.writeString(productImage)
				dest?.writeString(productPrice)
				dest?.writeString(shopLocation)
		}

		override fun describeContents(): Int = 0

		companion object CREATOR : Parcelable.Creator<Product> {
				override fun createFromParcel(parcel: Parcel): Product {
						return Product(parcel)
				}

				override fun newArray(size: Int): Array<Product?> {
						return arrayOfNulls(size)
				}
		}

}