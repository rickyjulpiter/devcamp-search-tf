package com.tokopedia.abstraction.util

import android.graphics.Bitmap
import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito.mock

class BitmapConverterTest {

		private var bitmap = mock(Bitmap::class.java)

		@Test fun `convert bitmap to bytebuffer`() {
				val convert = BitmapConverter.bitmapToTypeBuffer(bitmap, INPUT_SIZE)
				assertEquals(POS, convert.position())
				assertEquals(LIM, convert.limit())
				assertEquals(CAP, convert.capacity())
		}

		companion object {
				/**
				 * if input size is 100 should return a buffer with;
				 * position, limit, and capacity are 30000 values.
				 * based on ByteBuffer.allocateDirect(BATCH_SIZE * inputSize * inputSize * PIXEL_SIZE)
				 */
				const val INPUT_SIZE = 100

				const val POS = 30000
				const val LIM = 30000
				const val CAP = 30000
		}

}