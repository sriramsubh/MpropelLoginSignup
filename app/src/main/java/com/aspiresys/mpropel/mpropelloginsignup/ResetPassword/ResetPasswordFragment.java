package com.aspiresys.mpropel.mpropelloginsignup.ResetPassword;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.aspiresys.mpropel.mpropelloginsignup.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResetPasswordFragment extends Fragment implements ResetPasswordView, View.OnClickListener {
    ResetPasswordPresenterImpl resetPasswordPresenter;
    private AppCompatEditText useremailEditText;
    private Button back, resetPassword;
    private ProgressBar progressbar;

    public ResetPasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment        Res = new LoginPresenterImpl(this,this);

        View rootview =  inflater.inflate(R.layout.fragment_reset_password, container, false);
        resetPasswordPresenter = new ResetPasswordPresenterImpl(this, this);
        return rootview;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //initialise the views here
        back = (Button) view.findViewById(R.id.btn_back);
        resetPassword = view.findViewById(R.id.btn_reset_password);
        useremailEditText = view.findViewById(R.id.useremail);
        back.setOnClickListener(this);
        resetPassword.setOnClickListener(this);

        progressbar = (ProgressBar) view.findViewById(R.id.progressBar);
    }

    @Override
    public void onClick(View view) {
        int item = view.getId();
        switch (item) {
            //logic to be performed when reset password button is clicked
            case R.id.btn_reset_password: {
                progressbar.setProgress(View.VISIBLE);

                //TODO: add up the progress bar thread
                String useremail = useremailEditText.getText().toString().trim();
                setUserEmail(useremail);
                if (resetPasswordPresenter.EmailValidator(useremail)) {
                    Toast.makeText(getActivity(), "successful", Toast.LENGTH_SHORT).show();
                    progressbar.setProgress(View.GONE);
                } else {
                    Toast.makeText(getActivity(), "check useremail", Toast.LENGTH_SHORT).show();
                    progressbar.setProgress(View.GONE);
                }
                break;
            }


            case R.id.btn_back: {
                Toast.makeText(getActivity(), "back button  underdevelopment", Toast.LENGTH_SHORT).show();
                break;
            }

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
