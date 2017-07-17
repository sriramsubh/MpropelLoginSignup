package com.aspiresys.mpropel.mpropelloginsignup.Login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.aspiresys.mpropel.mpropelloginsignup.ResetPassword.ResetPasswordFragment;
import com.aspiresys.mpropel.mpropelloginsignup.R;
import com.aspiresys.mpropel.mpropelloginsignup.Signup.SignupFragment;

public class LoginFragment extends Fragment implements LoginView, View.OnClickListener {


    public LoginPresenterImpl loginPresenter;
    private ProgressBar progressbar;
    private Button Login, Signup;
    private AppCompatEditText usernameEditText, passwordEditText;
    private TextView forgotPasswordTextView;
    private View view = null;

    //Default constructor injected for testing
     public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginPresenter = new LoginPresenterImpl(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_login, container, false);
        }
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Initialising the views
        initialiseViews();

    }

    /**
     * initialiseViews function to initialise the views which are required by the Login Fragment
     */
    private void initialiseViews() {
        Login = view.findViewById(R.id.email_Login_button);
        Signup = view.findViewById(R.id.email_signup_button);
        usernameEditText = view.findViewById(R.id.email);
        passwordEditText = view.findViewById(R.id.password);
        forgotPasswordTextView = view.findViewById(R.id.forgetPassword);
        Login.setOnClickListener(this);
        Signup.setOnClickListener(this);
        forgotPasswordTextView.setOnClickListener(this);
        progressbar = view.findViewById(R.id.login_progress);
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            //when login button is pressed perform the login actions
            case R.id.email_Login_button:
                onLoginButtonCLicked();
                break;

            //when the signUp button is pressed perform the necessary actions
            case R.id.email_signup_button: {
                // Toast.makeText(getActivity(), "development in progress", Toast.LENGTH_SHORT).show();
                onSignUpButtonClicked();
                break;
            }
            case R.id.forgetPassword: {
                //when the forgot password textView is pressed perform the  necessary actions
                onForgotPasswordClicked();
                break;
            }
        }


    }

    /**
     * onLoginButtonCLicked function to do the action when the user clicks the login button
     */
    protected void onLoginButtonCLicked() {
        progressbar.setProgress(View.VISIBLE);
        //TODO: add up the progress bar thread
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        setUserEmail(username);
        setPassword(password);
        if (loginPresenter.LoginValidator(username, password)) {
            Toast.makeText(getActivity(), "successfully logged in", Toast.LENGTH_SHORT).show();
            progressbar.setProgress(View.GONE);
        } else {
            //Toast.makeText(getActivity(), "check username and password", Toast.LENGTH_SHORT).show();
            progressbar.setProgress(View.GONE);
        }
    }

    /**
     * onSignUpButtonClicked function to do the action when the user clicks the signUp button
     */
    protected void onSignUpButtonClicked() {
        SignupFragment signupFragment = new SignupFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, signupFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    /**
     * onForgotPasswordClicked function to do the action when the user clicks the ForgotPassword option
     */
    protected void onForgotPasswordClicked() {
        ResetPasswordFragment resetPasswordFragment = new ResetPasswordFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, resetPasswordFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    @Override
    public void setUserEmail(String username) {
        usernameEditText.setText(username);
    }

    @Override
    public void setPassword(String password) {
        passwordEditText.setText(password);
    }

    @Override
    public void showUsernameError(String username) {
        Toast.makeText(getActivity(), "username error", Toast.LENGTH_SHORT).show();
        usernameEditText.setError(username);
    }

    @Override
    public void showPasswordError(String password) {
        Toast.makeText(getActivity(), "password error", Toast.LENGTH_SHORT).show();
        passwordEditText.setError(password);
    }

    @Override
    public String getUserName() {
        return  usernameEditText.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return passwordEditText.getText().toString().trim();
    }
}
