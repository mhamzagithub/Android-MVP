package com.hamza1999.presentation.view

/**
This is the interface of our View.
It will be used to reference the View's instance
in Presenter Class. This interface will allow data abstraction
for View class.
 */
interface ILoginView {
    fun showToast(message:String)
}