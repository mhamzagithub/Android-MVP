package com.hamza1999.presentation.presenter

/**
This is the interface of Presenter.
It will be used to reference the presenter's instance
in Model Class. This interface will allow data abstraction
for Presenter class.
 */

interface ILoginPresenter {
    fun validated(answer:Boolean)
}