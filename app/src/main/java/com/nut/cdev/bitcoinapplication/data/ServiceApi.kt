//package com.nut.cdev.bitcoinapplication.data
//
//
//import com.feyverly.pos.rx.RxBus
//import com.feyverly.pos.rx.RxEvent
//import com.feyverly.pos.enums.EventAppEnums
//import io.reactivex.disposables.CompositeDisposable
//import retrofit2.*
//
//class ServiceApi {
//
//    private val eventDisposable: CompositeDisposable by lazy { CompositeDisposable() }
//
//    fun <Result> sendRequest(callRequest: Call<Result>, onLoadState: (UserResult<Result>) -> Unit) {
//        onLoadState.invoke(UserResult(Status.LOADING))
//        callRequest.enqueue(object : CallbackWrapper<Result>() {
//
//            override fun onSuccess(t: UserResult<Result>) {
//                onLoadState.invoke(t)
//            }
//
//            override fun onFailure(t: UserResult<Result>) {
//                if (t.status == Status.UNAUTHORIZED) {
//                    RxBus.publish(
//                        RxEvent.EventAppUpdate(
//                            EventAppEnums.UNAUTHORIZED,
//                            t.message?.error
//                        )
//                    )
//                }
//                onLoadState.invoke(t)
//            }
//
//            override fun onForceUpdate(t: UserResult<Result>) {
//                RxBus.publish(RxEvent.EventAppUpdate(EventAppEnums.FORCE_UPDATE, null))
//                onLoadState.invoke(t)
//            }
//
//            override fun onSoftUpdate(t: UserResult<Result>, version: String) {
//                RxBus.publish(RxEvent.EventAppUpdate(EventAppEnums.SOFT_UPDATE, version))
//                eventDisposable.add(RxBus.listen(RxEvent.EventContinueFlow::class.java).subscribe {
//                    t.status = Status.SUCCESS
//                    onSuccess(t)
//                    eventDisposable.clear()
//                })
//                onLoadState.invoke(t)
//            }
//
//            override fun onMaintenance(t: UserResult<Result>) {
//                RxBus.publish(RxEvent.EventAppUpdate(EventAppEnums.MAINTENANCE, null))
//                onLoadState.invoke(t)
//            }
//
//        })
//    }
//
//}
//
