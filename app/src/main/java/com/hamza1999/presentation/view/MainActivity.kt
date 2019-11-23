package com.hamza1999.presentation.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.hamza1999.presentation.R
import com.hamza1999.presentation.model.LoginInteractor
import com.hamza1999.presentation.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_main.*

/**
 * classname: class/interface is the style for inheritence in kotlin
 */
class MainActivity : AppCompatActivity(), ILoginView {

    // "override fun" keyword is used for overriden functions
    // ": Bundle?" the question mark indicates that Bundle can be null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Login Activity's fields
        val userName: EditText = username_etxt
        val pass: EditText = password_etxt
        val loginBtn: Button = login_btn
        val progressBar: ProgressBar = loginProgressBar
        //Initializing our Presenter
        val presenter = LoginPresenter(this, LoginInteractor())

        //Setting a listener on the Login Button
        loginBtn.setOnClickListener {

//            //Dimming the visibility of input fields and login button
//            userName.alpha = 0.5f
//            pass.alpha = 0.5f
//            loginBtn.alpha = 0.5f
//
//            //Showing the progress bar circle
//            progressBar.alpha = 1f

            presenter.validate(userName.text.toString(), pass.text.toString())
        }

    }

    override fun onResume() {
        super.onResume()
        //Login Activity's fields
        val userName: EditText = username_etxt
        val pass: EditText = password_etxt
        val loginBtn: Button = login_btn
        val progressBar: ProgressBar = loginProgressBar

        //Dimming the visibility of input fields and login button
        userName.alpha = 1f
        pass.alpha = 1f
        loginBtn.alpha = 1f

        //Showing the progress bar circle
        progressBar.alpha = 0f
    }

    /**
     * This is the overridden function of IloginView
     * It shows an appropriate Toast message and also
     * moves to the next activity. (Success of Error)
     */
    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        if (message == "Success") {
            startActivity(Intent(this, Home::class.java))
        } else {
            startActivity(Intent(this, Error::class.java))
        }
    }
}
