package com.rakhaadi.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class sudahpunyaakunlogin extends AppCompatActivity {
    Button btnmasuk;
    EditText et_Email, et_password;
    TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudahpunyaakunlogin);

        btnmasuk = findViewById(R.id.btnMasuk);
        et_Email = findViewById(R.id.et_Email);
        et_password = findViewById(R.id.et_Password);
        tvLogin = findViewById(R.id.tvLogin);

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(sudahpunyaakunlogin.this,buatakun.class));
            }
        });

        btnmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(et_Email.getText().toString()) || TextUtils.isEmpty(et_password.getText().toString())){
                    String message = "masukkan email dan password terlebih dahulu";
                    Toast.makeText(sudahpunyaakunlogin.this,message,Toast.LENGTH_LONG).show();
                }else{
                    LoginRequest loginRequest = new LoginRequest();
                    loginRequest.setEmail(et_Email.getText().toString());
                    loginRequest.setPassword(et_password.getText().toString());

                    loginUser(loginRequest);

                }
            }
        });
    }

    public void loginUser(LoginRequest loginRequest){
        Call<LoginResponse> loginResponseCall = ApiClientLogin.getService().loginUser(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()){
                    LoginResponse loginResponse = response.body();
                    startActivity(new Intent(sudahpunyaakunlogin.this,beranda.class));
                    finish();

                }else{

                    String message = "eror 404..";
                    Toast.makeText(sudahpunyaakunlogin.this,message,Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

                String message = t.getLocalizedMessage();
                Toast.makeText(sudahpunyaakunlogin.this,message,Toast.LENGTH_LONG).show();

            }
        });
    }

    public void btnmasuk(View view) {
        Intent intent = new Intent(this, beranda.class);
        startActivity(intent);
    }

    public void lupakatasandi(View view) {
        Intent intent = new Intent(this, Lupapassword.class);
        startActivity(intent);
    }
}