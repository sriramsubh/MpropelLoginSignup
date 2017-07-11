package com.aspiresys.mpropel.mpropelloginsignup.Login;

/**
 * Created by sriram.thiyagaraja on 7/7/2017.
 */

/*
 * LoginPresenter to hold up the business logic of login validation
 *
 */
/**
@LoginValidator to check for the correct username and password
 @return boolean indicating login success or not
 */
public interface LoginPresenter {
    boolean LoginValidator(String username, String password);
}
