package  com.sigma.internship.mvvm.ui.base

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.sigma.internship.mvvm.ui.dialogs.LoadingDialog

abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity() {

    abstract val viewModel: VM
    private var rootView: ViewGroup? = null
    abstract fun liveDataObserver()
    private var loadingDialog: LoadingDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rootView = window.decorView.findViewById(android.R.id.content)
        viewModel.onCreated()
        liveDataObserver()
        observeToError()
        observeLoading()
    }

    fun startLoadingDialog() {
        runOnUiThread {
            if (loadingDialog == null) {
                loadingDialog = LoadingDialog.start(supportFragmentManager)
            }
        }
    }

    fun stopLoadingDialog() {
        runOnUiThread {
            if (loadingDialog != null && !isFinishing) {
                loadingDialog?.dismissAllowingStateLoss()
                loadingDialog = null
            }
        }
    }

    private fun observeLoading(){
        viewModel.isLoading.observe(this, {
            if(it){
                startLoadingDialog()
            } else {
                stopLoadingDialog()
            }
        })
    }

    private fun observeToError() {
        viewModel.publicExceptionHandlerLiveData.observe(this, {
            stopLoadingDialog()
        })
    }
}