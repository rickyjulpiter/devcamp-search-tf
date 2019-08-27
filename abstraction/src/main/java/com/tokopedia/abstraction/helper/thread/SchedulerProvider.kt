package com.tokopedia.abstraction.helper.thread

import io.reactivex.Scheduler

interface SchedulerProvider {
		fun io(): Scheduler
		fun ui(): Scheduler
}