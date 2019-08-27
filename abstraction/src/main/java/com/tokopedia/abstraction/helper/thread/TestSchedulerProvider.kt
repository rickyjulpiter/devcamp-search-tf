package com.tokopedia.abstraction.helper.thread

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class TestSchedulerProvider: SchedulerProvider {
		override fun io(): Scheduler = Schedulers.io()
		override fun ui(): Scheduler = Schedulers.trampoline()
}