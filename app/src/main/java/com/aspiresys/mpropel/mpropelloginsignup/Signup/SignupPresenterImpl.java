package com.aspiresys.mpropel.mpropelloginsignup.Signup;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sriram.thiyagaraja on 7/7/2017.
 */

public class SignupPresenterImpl implements SignupPresenter {
    private SignupFragment signupFragment;
    SignupPresenterImpl( SignupFragment signupFragment)
    {
       this.signupFragment = signupFragment;
    }
    @Override
    public boolean SignupValidator(String username, String password) {
        Pattern pattern;
        Matcher matcher;
        //TODO add up extra signup modules here
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

                signupFragment.showPasswordError("check password");
            }
        }else{
            signupFragment.showUseremailError("username error");
        }
return  false;

    }


}
