package com.aspiresys.mpropel.mpropelloginsignup.ResetPassword;

/**
 * Created by sriram.thiyagaraja on 7/7/2017.
 */

public interface ResetPasswordView {
    /**setUserEmail method to validate username

     @Param Username to set the username
     */
    void setUserEmail(String username);

     /**showUsernameError to show username error
    @Param username to set username

     */
    void showUseremailError(String username);



}
