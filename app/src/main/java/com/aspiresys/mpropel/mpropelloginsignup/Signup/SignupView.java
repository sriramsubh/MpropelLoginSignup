package com.aspiresys.mpropel.mpropelloginsignup.Signup;

/**
 * Created by sriram.thiyagaraja on 7/7/2017.
 */

public interface SignupView {
     /**setUserEmail method to validate username
      @Param Username to set the username
        */
     void setUserEmail(String username);
    /**setPassword method to set the password
    @Param password to set the password
     */
     void setPassword(String password);

     /**showUsernameError to show username error
    @Param username to set username

     */
    void showUseremailError(String username);
    /**showPasswordError to show username error
    @Param username to set username

     */
    void showPasswordError(String password);


}
