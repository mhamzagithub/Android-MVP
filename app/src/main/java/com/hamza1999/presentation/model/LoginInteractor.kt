package com.hamza1999.presentation.model

import com.hamza1999.presentation.Presenter.ILoginPresenter

class LoginInteractor {
    private var presenter:ILoginPresenter? = null;

    fun addPresenter(p:ILoginPresenter){
        this.presenter = p
    }

    /**
     *
     */
    fun authenticate(username:String,password:String){
        if(username.isEmpty() or password.isEmpty()){
            this.presenter!!.validated(false)
        }else{
            Thread.sleep(5000)
            this.presenter!!.validated(true)
        }
    }

}