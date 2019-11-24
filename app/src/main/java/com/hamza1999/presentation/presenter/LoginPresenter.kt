package com.hamza1999.presentation.presenter

import com.hamza1999.presentation.model.LoginInteractor
import com.hamza1999.presentation.view.ILoginView

class LoginPresenter(i: ILoginView, m: LoginInteractor) : ILoginPresenter {

    /**
     * The following 2 lines are the constructor lines in Kotlin
     * In Kotlin, the class constructor's parameters are written in
     * parenthesis (after class name). And the arguments are assigned to
     * the member variables at the start of class declaration.
     */

    //View reference(in the form of interface) in Presenter class.
    private var view: ILoginView = i

    //Model Reference
    private var interactor: LoginInteractor = m

    //function to communicate with the model.
    fun validate(username: String, password: String) {
        this.interactor.addPresenter(this)
        this.interactor.authenticate(username, password)
    }

    //function to show the result.
    override fun validated(answer: Boolean) {
        if (answer) {
            this.view.showToast("Success")
        } else {
            this.view.showToast("Failed")
        }
    }
}