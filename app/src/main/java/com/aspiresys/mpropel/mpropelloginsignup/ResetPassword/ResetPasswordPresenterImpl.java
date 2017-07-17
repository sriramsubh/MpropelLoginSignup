package com.aspiresys.mpropel.mpropelloginsignup.ResetPassword;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sriram.thiyagaraja on 7/7/2017.
 */

public class ResetPasswordPresenterImpl implements ResetPasswordPresenter {
    private ResetPasswordFragment resetPasswordFragment;
    ResetPasswordPresenterImpl(ResetPasswordFragment resetPasswordFragment)
    {
       this.resetPasswordFragment = resetPasswordFragment;
    }
    @Override
    public boolean EmailValidator(String userEmail) {
        Pattern pattern;
        Matcher matcher;
        //TODO add up extra email modules here
        final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(userEmail);
        //TODO: set you own password validation here
        if(matcher.matches() ) {


                return true;
            }else{

                resetPasswordFragment.showUseremailError("check userEmail");
            }

        return false;


    }


}
