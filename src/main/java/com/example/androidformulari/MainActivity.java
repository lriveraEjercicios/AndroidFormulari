package com.example.androidformulari;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etPhone, etMail, etPassword,etDate;
    int pDay, pMonth, pYear = 0;
    Activity activity = this;

    public DatePickerDialog.OnDateSetListener pDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    pYear = year;
                    pMonth = month;
                    pDay = dayOfMonth;

                    String fromDay = Integer.toString(pDay);
                    String fromMonth = Integer.toString(pMonth + 1);

                    if (fromDay.length() == 1) fromDay = "0" + fromDay;
                    if (fromMonth.length() == 1) fromMonth = "0" + fromMonth;

                    etDate.setText(fromDay + "/" + fromMonth + "/" + pYear);
                }
            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etName);
        etMail = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etName);
        etDate = findViewById(R.id.etDate);

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obrir el datepicker
                DatePickerDialog dateDialog =
                        new DatePickerDialog(activity,
                                pDateSetListener,
                                pYear, pMonth, pDay);
                //Minima data seleccionable, avui:
                dateDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                dateDialog.show();

            }
        });

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
    private void deleteContent()
    {
        etName.setText("");
        etMail.setText("");
        etPhone.setText("");
        etPassword.setText("");
    }
    public void btnCancelPressed(View view)
    {
        openDialog();
    }

    public void openDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);
        alertDialogBuilder.setTitle(getString(R.string.app_name)); //modificar el titol
        alertDialogBuilder.setMessage( getString(R.string.questionDelete))
                .setCancelable(false)
                .setPositiveButton(getString(R.string.btn_yes), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        deleteContent();
                    }
                })
                .setNegativeButton(getString(R.string.btn_no), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel(); // No fem res, tanquem el Alert.

                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create(); //crear el alert dialog
        alertDialog.show(); //mostrar per pantalla
    }


}
