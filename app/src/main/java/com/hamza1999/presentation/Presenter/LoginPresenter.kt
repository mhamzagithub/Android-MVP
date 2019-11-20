package com.hamza1999.presentation.Presenter

import com.hamza1999.presentation.model.LoginInteractor
import com.hamza1999.presentation.view.ILoginView

class LoginPresenter(i:ILoginView,m:LoginInteractor) :ILoginPresenter {
    private var view:ILoginView = i;
    private var interactor:LoginInteractor = m;

    public fun validate(username:String,password:String){
        this.interactor.addPresenter(this)
        this.interactor.authenticate(username, password)
    }

    override fun validated(answer: Boolean) {
        if(answer){
            this.view.showToast("Success")
        }else{
            this.view.showToast("Failed")
        }
    }
}