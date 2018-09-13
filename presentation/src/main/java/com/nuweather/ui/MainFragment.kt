package com.nuweather.ui

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.nuweather.BR
import com.nuweather.R
import com.nuweather.base.BaseFragment
import com.nuweather.binding.FragmentDataBindingComponent
import com.nuweather.databinding.FragmentMainBinding

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {
    companion object {
        fun newInstance() = MainFragment()
    }

    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.fragment_main

    override val viewModel: MainViewModel
        get() = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

    private var bindingComponent = FragmentDataBindingComponent(this)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}