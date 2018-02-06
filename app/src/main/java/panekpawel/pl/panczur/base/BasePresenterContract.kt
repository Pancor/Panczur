package panekpawel.pl.panczur.base


interface BasePresenterContract<in T> {

    fun onSetView(view: T)

    fun onDestroy()
}