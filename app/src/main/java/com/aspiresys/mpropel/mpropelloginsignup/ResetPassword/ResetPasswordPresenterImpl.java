package com.aspiresys.mpropel.mpropelloginsignup.ResetPassword;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sriram.thiyagaraja on 7/7/2017.
 */

public class ResetPasswordPresenterImpl implements ResetPasswordPresenter {
    private ResetPasswordView resetPasswordView;
    private ResetPasswordFragment resetPasswordFragment;
    ResetPasswordPresenterImpl(ResetPasswordView resetPasswordView, ResetPasswordFragment resetPasswordFragment)
    {
        this.resetPasswordView = resetPasswordView;
        this.resetPasswordFragment = resetPasswordFragment;
    }
    @Override
    public boolean EmailValidator(String useremail) {
        Pattern pattern;
        Matcher matcher;
//TODO add up extra email modules here
        final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(useremail);
        //TODO: set you own password validation here
        if(matcher.matches() ) {


                return true;
            }else{

                resetPasswordFragment.showUseremailError("check useremail");
            }

        return false;


    }


}
