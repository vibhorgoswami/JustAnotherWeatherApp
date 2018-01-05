package com.govibs.justanotherweatherapp.list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.govibs.core.data.DataManager
import com.govibs.core.data.model.WeatherModel
import com.govibs.core.ui.list.ListContract
import com.govibs.core.ui.list.ListPresenter
import com.govibs.justanotherweatherapp.R
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_weather_list.*

/**
 * Weather List activity
 * Created by Vibhor on 1/4/18.
 */
class WeatherListActivity : AppCompatActivity(), ListContract.ListView {

    private var mPresenter: ListPresenter? = null
    private var mCompositeDisposable: CompositeDisposable? = null
    private var mWeatherListAdapter: WeatherListAdapter? = null

    companion object {
        fun createWeatherListActivity(context: Context): Intent {
            return Intent(context, WeatherListActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_list)
        mCompositeDisposable = CompositeDisposable()
        mPresenter = ListPresenter(DataManager.getInstance(), mCompositeDisposable!!)
        mPresenter?.attachView(this)
        setupWeatherList()
        mPresenter?.onInitialRequest()
    }

    override fun onDestroy() {
        if (null != mCompositeDisposable && !mCompositeDisposable!!.isDisposed) {
            mCompositeDisposable!!.dispose()
        }
        mPresenter?.detachView()
        super.onDestroy()
    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }

    override fun showUnauthorizedError() {

    }

    override fun showEmpty() {

    }

    override fun showError(errorMessage: String?) {

    }

    override fun showMessageLayout(show: Boolean) {

    }

    override fun showWeatherList(weatherModelList: List<WeatherModel>) {
        mWeatherListAdapter?.swapAdapter(weatherModelList)
    }

    override fun showWeatherDetail(weatherModel: WeatherModel) {

    }

    private fun setupWeatherList() {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvWeatherList.layoutManager = linearLayoutManager
        rvWeatherList.setHasFixedSize(true)
        rvWeatherList.addItemDecoration(DividerItemDecoration(rvWeatherList.context, linearLayoutManager.orientation))
        mWeatherListAdapter = WeatherListAdapter(ArrayList<WeatherModel>(), { weatherModel -> showWeatherDetail(weatherModel) })
        rvWeatherList.adapter = mWeatherListAdapter
    }
}