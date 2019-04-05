package io.gameper.gampingmall.domain

import io.reactivex.Scheduler

interface Schedulers {
    val subscribeOn: Scheduler
    val observeOn: Scheduler?
}