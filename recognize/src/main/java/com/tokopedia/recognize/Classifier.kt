package com.tokopedia.recognize

import android.graphics.Bitmap

interface Classifier {
		fun recognize(bitmap: Bitmap): List<Mapper>
		fun close()
}