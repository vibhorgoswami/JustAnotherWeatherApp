package com.govibs.core.ui.base

abstract class BasePresenter<V> {

    protected var mView: V? = null

    fun attachView(view: V) {
        mView = view
    }

    fun detachView() {
        mView = null
    }

    protected fun isViewAttached(): Boolean {
        return mView != null
    }
}