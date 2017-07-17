package com.aspiresys.mpropel.mpropelloginsignup.ResetPassword;


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
import android.widget.Toast;

import com.aspiresys.mpropel.mpropelloginsignup.R;


/**
 * Reset Password Fragment to initiate the reset details
 */
public class ResetPasswordFragment extends Fragment implements ResetPasswordView, View.OnClickListener {
    private ResetPasswordPresenterImpl resetPasswordPresenter;
    private AppCompatEditText useremailEditText;
    private Button back, resetPassword;
    private ProgressBar progressbar;
    private View view = null;
    //Default constructor
    public ResetPasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //check for the nullness of the view before inflating
        if (view == null)
            view = inflater.inflate(R.layout.fragment_reset_password, container, false);
        //Field initialisation
        resetPasswordPresenter = new ResetPasswordPresenterImpl(this);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //initialise the views here
       initialiseViews();
    }
    /**
     * initialiseViews function to initialise the views which are required by the ResetPasswordFragment
     */
    protected void initialiseViews()
    {
        back = view.findViewById(R.id.btn_back);
        resetPassword = view.findViewById(R.id.btn_reset_password);
        useremailEditText = view.findViewById(R.id.useremail);
        back.setOnClickListener(this);
        resetPassword.setOnClickListener(this);

        progressbar = view.findViewById(R.id.progressBar);
    }

    @Override
    public void onClick(View view) {
        int item = view.getId();
        switch (item) {
            //logic to be performed when reset password button is clicked
            case R.id.btn_reset_password: {
                onResetPasswordButtonCLicked();
                break;
            }


            case R.id.btn_back: {
                //logic to be performed when back button is clicked
                Toast.makeText(getActivity(), "back button  underdevelopment", Toast.LENGTH_SHORT).show();
                break;
            }

        }


    }

    /**
     * onResetPasswordButtonCLicked method to the action when the user clicks the reset password button
     */
    protected void onResetPasswordButtonCLicked() {
        progressbar.setProgress(View.VISIBLE);

        //TODO: add up the progress bar thread
        String userEmail = useremailEditText.getText().toString().trim();
        setUserEmail(userEmail);
        if (resetPasswordPresenter.EmailValidator(userEmail)) {
            Toast.makeText(getActivity(), "successful", Toast.LENGTH_SHORT).show();
            progressbar.setProgress(View.GONE);
        } else {
            Toast.makeText(getActivity(), "check useremail", Toast.LENGTH_SHORT).show();
            progressbar.setProgress(View.GONE);
        }
    }

    @Override
    public void setUserEmail(String username) {
        useremailEditText.setText(username);
    }

    @Override
    public void showUseremailError(String username) {
        useremailEditText.setError(username);
    }

}
