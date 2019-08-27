package com.tokopedia.abstraction.util

import android.graphics.Bitmap
import java.nio.ByteBuffer
import java.nio.ByteOrder

object BitmapConverter {

		private const val BATCH_SIZE = 1
		private const val PIXEL_SIZE = 3

		fun bitmapToTypeBuffer(bitmap: Bitmap, inputSize: Int): ByteBuffer {
				val byteBuffer = ByteBuffer.allocateDirect(BATCH_SIZE * inputSize * inputSize * PIXEL_SIZE)
				byteBuffer.order(ByteOrder.nativeOrder())
				val values = IntArray(inputSize * inputSize)
				bitmap.getPixels(values, 0, bitmap.width, 0, 0, bitmap.width, bitmap.height)
				var pixel = 0
				for (i: Int in 0 until inputSize) {
						for (j: Int in 0 until inputSize) {
								val value = values[pixel++]
								byteBuffer.put((value shr 16 and 0xFF).toByte())
								byteBuffer.put((value shr 8 and 0xFF).toByte())
								byteBuffer.put((value and 0xFF).toByte())
						}
				}
				return byteBuffer
		}


}