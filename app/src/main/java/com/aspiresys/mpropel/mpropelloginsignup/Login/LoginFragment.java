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



    LoginPresenterImpl loginPresenter;
    private ProgressBar progressbar;
    private Button Login,Signup;
    private AppCompatEditText usernameEditText,passwordEditText;
    private TextView forgotPasswordTextView;
    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment
     * @return A new instance of fragment SignupFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginPresenter = new LoginPresenterImpl(this,this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_login,container,false);

        return view;

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        //Initialising the views
        Login = (Button) view.findViewById(R.id.email_Login_button);
        Signup = (Button)view.findViewById(R.id.email_signup_button);
        usernameEditText = view.findViewById(R.id.email);
        passwordEditText = view.findViewById(R.id.password);
        forgotPasswordTextView = (TextView)view.findViewById(R.id.forgetPassword);
        Login.setOnClickListener(this);
        Signup.setOnClickListener(this);
        forgotPasswordTextView.setOnClickListener(this);
        progressbar = (ProgressBar)view.findViewById(R.id.login_progress);
    }






    @Override
    public void onDetach() {
        super.onDetach();

    }

    @Override
    public void onClick(View view) {
        int item =  view.getId();
        switch(item) {
            //when login button is pressed perform the login actions
            case R.id.email_Login_button: {
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
                break;
            }
            //when the signup button is pressed perform the necessary actions
            case R.id.email_signup_button: {
                // Toast.makeText(getActivity(), "development in progress", Toast.LENGTH_SHORT).show();
                SignupFragment signupFragment = new SignupFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, signupFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                break;
            }
            case R.id.forgetPassword: {
                //when the forgot password textview is pressed perform the  necessary actions
                ResetPasswordFragment resetPasswordFragment = new ResetPasswordFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, resetPasswordFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
        }



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
        Toast.makeText(getActivity(),"username error",Toast.LENGTH_SHORT).show();
        usernameEditText.setError(username);

    }

    @Override
    public void showPasswordError(String password) {
        Toast.makeText(getActivity(),"password error",Toast.LENGTH_SHORT).show();
         passwordEditText.setError(password);
    }
}
