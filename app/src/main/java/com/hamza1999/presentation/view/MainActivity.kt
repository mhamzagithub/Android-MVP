package com.hamza1999.presentation.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.hamza1999.presentation.Presenter.LoginPresenter
import com.hamza1999.presentation.R
import com.hamza1999.presentation.model.LoginInteractor
import kotlinx.android.synthetic.main.activity_main.*

/**
 * classname: class/interface is the style for inheritence in kotlin
 */
class MainActivity : AppCompatActivity(),ILoginView {

    // "override fun" keyword is used for overriden functions
    // ": Bundle?" the question mark indicates that
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val uname:EditText = username_etxt
        val pass:EditText = password_etxt
        val loginBtn:Button = login_btn
        val presenter = LoginPresenter(this, LoginInteractor())

        loginBtn.setOnClickListener {
            presenter.validate(uname.text.toString(),pass.text.toString())
        }

    }

    //overriden iloginview function
    override fun showToast(message: String){
//        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
        if(message.equals("Success")){
            startActivity(Intent(this,Home::class.java))
        }else{
            startActivity(Intent(this,Error::class.java))
        }
    }
}
