package com.moby.apply.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.moby.apply.MobiApplyApplication;
import com.moby.apply.R;
import com.moby.apply.presenters.LoginPresenter;
import com.moby.apply.utils.StringUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginPresenter.LoginView{

    @BindView(R.id.edit_email)
    EditText emailEditText;

    @BindView(R.id.edit_password)
    EditText passwordEditText;

    @BindView(R.id.button_login)
    Button loginButton;

    @BindView(R.id.button_register)
    Button registerButton;
    
    @Inject
    LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        ((MobiApplyApplication)getApplication()).getCoreComponent().inject(this);
        mPresenter.attachView(this);
        setPresenter(mPresenter);
    }

    @Override
    public void loginSuccessful() {
        Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.button_login)
    public void onLoginClicked() {

        if(StringUtils.isNullOrEmpty(emailEditText.getText().toString())) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            return;
        }

        if(StringUtils.isNullOrEmpty(passwordEditText.getText().toString())) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        mPresenter.login();
    }

    @OnClick(R.id.button_register)
    public void onRegistrationClicked() {
        RegistrationActivity.startActivity(this);
    }
}
