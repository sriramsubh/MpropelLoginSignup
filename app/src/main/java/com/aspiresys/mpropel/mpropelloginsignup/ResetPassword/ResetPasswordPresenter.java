package com.aspiresys.mpropel.mpropelloginsignup.ResetPassword;

/**
 * Created by sriram.thiyagaraja on 7/7/2017.
 */

      /**
       * ResetPasswordPresenter to provide the business logic when the reset password button is clicked
       * */
public interface ResetPasswordPresenter {
    /**
            * EmailValidator function to validate the given email for the validation.
            * TODO: after validating give your own Web service call and perform the reset check
     ** @param :useremail
     */
    boolean EmailValidator(String useremail);
}
