package com.aspiresys.mpropel.mpropelloginsignup.Signup;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.aspiresys.mpropel.mpropelloginsignup.Login.LoginFragment;
import com.aspiresys.mpropel.mpropelloginsignup.R;


public class SignupFragment extends Fragment implements SignupView, View.OnClickListener {


    private SignupPresenterImpl signupPresenter;
    private ProgressBar progressbar;
    private Button Signup;
    private AppCompatEditText useremailEditText, passwordEditText;
    private TextView loginTextView;
    private View view = null;

    public SignupFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SignupFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SignupFragment newInstance(String param1, String param2) {
        SignupFragment fragment = new SignupFragment();
        Bundle args = new Bundle();
        args.putString("useremail", param1);
        args.putString("password", param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signupPresenter = new SignupPresenterImpl(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        if (view == null) {
            view = inflater.inflate(R.layout.fragment_signup, container, false);
        }
        return view;

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        //initialising the views here
        super.onViewCreated(view, savedInstanceState);
        initialiseViews();
    }
    /**
     * initialiseViews function to initialise the views which are required by the SignUp Fragment
     */
    protected void initialiseViews() {
        Signup = (Button) view.findViewById(R.id.email_signup_button);
        useremailEditText = view.findViewById(R.id.email);
        passwordEditText = view.findViewById(R.id.password);
        loginTextView = (TextView) view.findViewById(R.id.haveAccountLogin);
        Signup.setOnClickListener(this);
        loginTextView.setOnClickListener(this);
        progressbar = (ProgressBar) view.findViewById(R.id.progressBar);
    }


    @Override
    public void onDetach() {
        super.onDetach();

    }

    @Override
    public void onClick(View view) {
        int item = view.getId();
       //signUp validation when the signup button is clicked
        if (item == R.id.email_signup_button) {
            onSignUpButtonCicked();
            return;
        }
        //text view incase user already has the login
        if (item == R.id.haveAccountLogin) {
            haveAccountLoginClicked();
            return;
            //   Toast.makeText(getActivity(),"have account login is under development",Toast.LENGTH_SHORT).show();

        }

    }

    /**
     * onSignUpButtonCLicked method to do the action when user clicks the signUp Button
     */
    protected void onSignUpButtonCicked() {
        progressbar.setProgress(View.VISIBLE);
        String useremail = useremailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        setUserEmail(useremail);
        setPassword(password);
        if (signupPresenter.SignupValidator(useremail, password)) {
            progressbar.setProgress(View.GONE);
            Toast.makeText(getActivity(), "signup sucessful", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "failure", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * haveAccountLoginClicked method to do the action when the user clicks the haveAccount textView
     */
    protected void haveAccountLoginClicked() {
        LoginFragment loginFragment = new LoginFragment();
        FragmentManager fragmentManager = getFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, loginFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }


    @Override
    public void setUserEmail(String useremail) {
        useremailEditText.setText(useremail);
    }

    @Override
    public void setPassword(String password) {
        passwordEditText.setText(password);
    }

    @Override
    public void showUseremailError(String useremail) {
        Toast.makeText(getActivity(), "useremail error", Toast.LENGTH_SHORT).show();
        useremailEditText.setError(useremail);

    }

    @Override
    public void showPasswordError(String password) {
        Toast.makeText(getActivity(), "password error", Toast.LENGTH_SHORT).show();
        passwordEditText.setError(password);
    }
}
