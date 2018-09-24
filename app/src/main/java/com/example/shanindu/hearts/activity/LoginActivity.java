package com.example.shanindu.hearts.activity;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.shanindu.hearts.R;
import com.example.shanindu.hearts.model.user;
import com.example.shanindu.hearts.support.DBConnection;
import com.example.shanindu.hearts.support.InternetObserver;
import com.example.shanindu.hearts.support.sharedPref;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class LoginActivity extends AppCompatActivity {


    private final int elder = 1; //elder identifies from 1
    private final int careGiver = 0; //caregiver identifies from 2


    private Button logIn;
    private TextView Register;
    private CheckBox Remeber;
    private TextInputEditText userName,Password;
    private String user,pword;
    private boolean internetAvailability;
    private ProgressDialog pDialog;
    sharedPref pref = new sharedPref(getApplicationContext());

    user userInstance = new user();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setTitle("Login");

        initialize();

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerActivity = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerActivity);
            }
        });

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                internetAvailability= InternetObserver.isConnectedToInternet(LoginActivity.this);
                user = userName.toString().trim();
                pword=Password.toString().trim();

                if (internetAvailability != true)
                {
                    new SweetAlertDialog(LoginActivity.this, SweetAlertDialog.ERROR_TYPE).setTitleText("Error")
                            .setContentText("No Internet Connection").setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            setResult(RESULT_OK);
                            sweetAlertDialog.cancel();
                        }
                    }).show();

                }

                else if (validateUserame() && validatePassword())
                {

                    if(checkLogin(user,pword))
                    {
                        if(Remeber.isChecked())
                        {
                            pref.setLogin(true);

                        }

                        Toast.makeText(getApplicationContext(), "user logged in", Toast.LENGTH_LONG).show();
                                int userType = userInstance.getUserType();
                                if(userType==1)
                                {
                                    // Launch ConfigActivity
                                    Intent intent = new Intent(LoginActivity.this, ConfigActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                                if(userType==2)
                                {
                                    // Launch Home Activity
                                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                    startActivity(intent);
                                    finish();

                                }


                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "invalid user name or password", Toast.LENGTH_LONG).show();
                    }


                }
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private boolean checkLogin(String PuserName, String Ppassword)
    {
        userInstance.setUserName(PuserName);
        userInstance.setPassword(Ppassword);
           if(userInstance.logIn())
           {
                return true;

           }
           else
           {
               return false;
           }


    }


    private void initialize() {
        logIn = findViewById(R.id.btnLogin);
        Remeber = findViewById(R.id.chk_remember);
        Register = findViewById(R.id.tv_register);
        userName = findViewById(R.id.edt_username);
        Password = findViewById(R.id.edt_password);
    }

    private boolean validateUserame() {
        if (userName.getText().toString().trim().isEmpty()) {
            userName.setError(getString(R.string.err_msg_username));
            userName.requestFocus();
            return false;

        }

        return true;
    }

    private boolean validatePassword() {
        if (Password.getText().toString().trim().isEmpty()) {
            Password.setError(getString(R.string.err_msg_password));
            Password.requestFocus();
            return false;

        }

        return true;
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
