package panekpawel.pl.panczur.base

import io.reactivex.disposables.CompositeDisposable

open class BasePresenter<T: BaseView> : BasePresenterContract<T>{

    protected val disposable = CompositeDisposable()
    protected lateinit var view: T

    override fun onSetView(view: T) {
        this.view = view
    }

    override fun onDestroy() {
        disposable.dispose()
    }
}