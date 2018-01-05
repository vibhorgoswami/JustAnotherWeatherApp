package com.govibs.core.ui.list

import com.govibs.core.data.DataManager
import com.govibs.core.data.model.WeatherModel
import com.govibs.core.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class ListPresenter(dataManager: DataManager, compositeDisposable: CompositeDisposable) : BasePresenter<ListContract.ListView>(), ListContract.ViewActions {

    private val DEFAULT_POSTAL_CODE = "19333"
    private val DEFAULT_UNIT = "metric"
    private val ITEM_REQUEST_LIMIT = 7
    private val mDataManager: DataManager = dataManager
    private val mCompositeDisposable: CompositeDisposable = compositeDisposable

    override fun onInitialRequest() {
        requestWeather(DEFAULT_POSTAL_CODE, DEFAULT_UNIT, ITEM_REQUEST_LIMIT)
    }

    override fun onSearchWithPostalCode() {

    }

    private fun requestWeather(query: String, unit: String, count: Int) {
        if (!isViewAttached()) {
            return
        }
        mView?.showMessageLayout(false)
        mView?.showProgress()
        mCompositeDisposable.add(mDataManager.getWeatherInfo(query, unit, count).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    if (isViewAttached()) {
                        mView!!.hideProgress()
                        val responseResults: List<WeatherModel>? = response.weatherModelList
                        if (!responseResults!!.isEmpty()) {
                            mView!!.showWeatherList(responseResults)
                        } else {
                            mView!!.showEmpty()
                        }
                    }
                }, { e ->
                    if (isViewAttached()) {
                        mView!!.hideProgress()
                        mView!!.showError(e.message)
                        e.printStackTrace()
                    }
                }))
    }
}