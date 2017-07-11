package com.aspiresys.mpropel.mpropelloginsignup.Login;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sriram.thiyagaraja on 7/7/2017.
 */

public class LoginPresenterImpl implements LoginPresenter{
    private LoginView loginView;
    private LoginFragment loginFragment;

    LoginPresenterImpl(LoginView loginView,LoginFragment loginFragment)
    {
        this.loginView = loginView;
        this.loginFragment = loginFragment;
    }
    @Override
    public boolean LoginValidator(String username, String password) {
        Pattern pattern;
        Matcher matcher;
     //regex pattern to validate the email address
        final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(username);
        //TODO: set you own password validation here
        if(matcher.matches() ) {
            if( !TextUtils.isEmpty(password) && password.length()>6) {

                return true;
            }else{

                loginFragment.showPasswordError("check password");
            }
        }else{
            loginFragment.showUsernameError("username error");
        }
             return false;


    }


}
