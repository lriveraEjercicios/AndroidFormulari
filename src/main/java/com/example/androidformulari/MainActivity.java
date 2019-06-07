package com.example.androidformulari;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etPhone, etMail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etName);
        etMail = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etName);

    }

    public void btnOkPressed(View view) {

        if ("".equals(etName.getText().toString())) {
            etName.setError(getString(R.string.err_empty));
        } else if ("".equals(etMail.getText().toString())) {
            etMail.setError(getString(R.string.err_empty));
        } else if ("".equals(etPhone.getText().toString())) {
            etPhone.setError(getString(R.string.err_empty));
        } else if ("".equals(etPassword.getText().toString())) {
            etPassword.setError(getString(R.string.err_empty));
        } else {
            Toast.makeText(this, "Todo OK", Toast.LENGTH_LONG).show();
        }
    }
}
