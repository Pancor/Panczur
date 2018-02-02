package panekpawel.pl.panczur.base


interface BasePresenter<in T> {

    fun onSetView(view: T)
}