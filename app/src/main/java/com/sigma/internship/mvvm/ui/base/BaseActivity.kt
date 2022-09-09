package  com.sigma.internship.mvvm.ui.base

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity() {

    abstract val viewModel: VM
    private var rootView: ViewGroup? = null
    abstract fun liveDataObserver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rootView = window.decorView.findViewById(android.R.id.content)
        viewModel.onCreated()
        liveDataObserver()
    }


}