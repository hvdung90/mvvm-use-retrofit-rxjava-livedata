package com.example.myapplication.view

import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.core.lib.common.base.ui.BaseActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.viewModel.MainViewModel
import com.jakewharton.rxbinding2.view.RxView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {
    override val mViewModel: MainViewModel by viewModels()
    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }

    override fun init() {
        initLayout()
        initBehavior()
        initData()
    }

    override fun initLayout() {

    }

    override fun initData() {
        mViewModel.getReport("2020/06/01", "2020/06/23", "10.0037")
        mViewModel.reports.observe(this, Observer { datas ->
            run {
              //  binding.txt.text = "size = " + datas.size
            }
        })
        mViewModel.reportError.observe(this, Observer { data ->
            run {
                if (data)
                 //  binding.txt.text = "Lỗi nha"
            }
        })
    }

    override fun initBehavior() {
//        compositeDisposable?.add(RxView.clicks(binding.txt).subscribe {
////            val host = OneFragment.create(R.navigation.welcome_nav)
////            supportFragmentManager.beginTransaction().replace(R.id.container, host)
////                .setPrimaryNavigationFragment(host).commit()
//        })
    }


}