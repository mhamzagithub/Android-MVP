package com.hamza1999.presentation.model

import com.hamza1999.presentation.presenter.ILoginPresenter

class LoginInteractor {

    /**
     * The interface reference of our Presenter
     */
    private var presenter: ILoginPresenter? = null;

    /**
     * This function will initialize the Presenter Reference of this Model
     */
    fun addPresenter(p: ILoginPresenter) {
        this.presenter = p
    }

    /**
     * This function checks if the entered id and password are correct or not.
     */
    fun authenticate(username: String, password: String) {
        if (username.isEmpty() or password.isEmpty()) {
            this.presenter!!.validated(false)

            //For Example purpose, id=hamza and password=123 are used here.
        } else if ((username == "hamza") and (password == "123")) {
            //Thread.sleep shows the time delay of fetching data from the database.
            this.presenter!!.validated(true)
            Thread.sleep(5000)
        } else {
            this.presenter!!.validated(false)
            Thread.sleep(5000)
        }
    }

}