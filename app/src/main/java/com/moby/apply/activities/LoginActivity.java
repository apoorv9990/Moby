package com.moby.apply.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.moby.apply.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.edit_email)
    EditText emailEditText;

    @BindView(R.id.edit_password)
    EditText passwordEditText;

    @BindView(R.id.button_login)
    Button loginButton;

    @BindView(R.id.button_register)
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        
    }
}
