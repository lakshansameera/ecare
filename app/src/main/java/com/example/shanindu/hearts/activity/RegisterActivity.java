package com.example.shanindu.hearts.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.shanindu.hearts.R;
import com.example.shanindu.hearts.model.user;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class RegisterActivity extends AppCompatActivity {


    private final static int Elder = 1;
    private final static int Caregiver = 2;

    private Button btnRegister;
    private Spinner spinner_userType;
    private EditText edtUsername, edtContact, edtPassword;
    private RadioGroup radioGroup;
    private RadioButton radioMale, radioFemale;
    private ProgressDialog pDialog;

    private TextView tvLogin;
    private int UserType;

    private String username, password, contact, gender;

    user userInstance = new user();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Register");

        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        initialize();

        ArrayList spinner_list = new ArrayList();

        spinner_list.add("Select User Type");
        spinner_list.add("Elder");
        spinner_list.add("Caregiver");

        ArrayAdapter arrayAdapter = new ArrayAdapter(RegisterActivity.this, R.layout.support_simple_spinner_dropdown_item, spinner_list);

        spinner_userType.setAdapter(arrayAdapter);

        spinner_userType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == Elder) {
                    radioGroup.setVisibility(View.VISIBLE);
                } else {
                    radioGroup.setVisibility(View.GONE);
                }

                UserType = position;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginActivity = new Intent(RegisterActivity.this, com.example.shanindu.hearts.activity.LoginActivity.class);
                startActivity(LoginActivity);
                finish();


            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();

            }
        });
    }
        private void initialize() {
        edtUsername = findViewById(R.id.edt_username);
        edtContact = findViewById(R.id.edt_contact);
        edtPassword = findViewById(R.id.edt_password);
        radioGroup = findViewById(R.id.radio_gender);
        radioMale = findViewById(R.id.radio_male);
        radioFemale = findViewById(R.id.radio_female);


        tvLogin = findViewById(R.id.tv_login);
        btnRegister = findViewById(R.id.btnRegister);
        spinner_userType = findViewById(R.id.spinner_type);

    }


    private void submitForm() {
        if (!validateUserType()) {
            return;
        }

        if (!validateName()) {
            return;
        }

        if (!validateContact()) {
            return;
        }

        if (!validatePassword()) {
            return;
        }

        if (!validateRetypePassword()) {
            return;
        }


        username = edtUsername.getText().toString().trim();
        password = edtPassword.getText().toString().trim();
        contact = edtContact.getText().toString().trim();

        if (radioMale.isChecked()) {
            gender = "male";

        } else {
            gender = "female";
        }

        userInstance.setUserName(username);
        userInstance.setPassword(password);
        userInstance.setContact(contact);
        userInstance.setGender(gender);
        userInstance.setUserType(UserType);

        userInstance.RegisterUser();

    }

        private boolean validateUserType() {
        if (UserType == 0) {
            ((TextView) spinner_userType.getSelectedView()).setError("Error message");
//            spinner_userType.setBackgroundColor(getResources().getColor(R.color.red));

            return false;

        } else {

        }

        return true;
    }

        private boolean validateName() {
        if (edtUsername.getText().toString().trim().isEmpty()) {
            edtUsername.setError(getString(R.string.err_msg_username));
            edtUsername.requestFocus();
            return false;

        }

        return true;
    }

        private boolean validateContact() {
        if (edtContact.getText().toString().trim().isEmpty()) {
            edtContact.setError(getString(R.string.err_msg_contact));
            edtContact.requestFocus();
            return false;

        }

        return true;

        }

        private boolean validatePassword() {
        if (edtPassword.getText().toString().trim().isEmpty()) {
            edtPassword.setError(getString(R.string.err_msg_password));
            edtPassword.requestFocus();
            return false;

        }

        return true;
    }


        private boolean validateRetypePassword() {
        if (edtContact.getText().toString().trim().isEmpty()) {
            edtContact.setError(getString(R.string.err_msg_password));
            edtContact.requestFocus();
            return false;

        }

        return true;
    }



        @Override
        public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

        private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

        private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }







}
