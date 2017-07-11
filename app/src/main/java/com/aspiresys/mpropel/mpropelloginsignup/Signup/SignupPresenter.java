package com.aspiresys.mpropel.mpropelloginsignup.Signup;

/**
 * Created by sriram.thiyagaraja on 7/7/2017.
 */

/*
 * SignupPresenter to provide the business logic for the signup
 */

/**
 * SignupValidator method to check the useremail and password during the signup
 * @param : useremail,password
 */
public interface SignupPresenter {
    boolean SignupValidator(String useremail, String password);
}
