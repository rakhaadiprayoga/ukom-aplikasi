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

public class buatakun extends AppCompatActivity {

    Button btnlanjut;
    EditText edusername, edEmail,edPassword;
    TextView tvbuatakun;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buatakun);

        btnlanjut = findViewById(R.id.btnlanjut);
        edusername = findViewById(R.id.edusername);
        edEmail = findViewById(R.id.edEmail);
        edPassword = findViewById(R.id.edpassword);
        tvbuatakun = findViewById(R.id.tvbuatakun);

        tvbuatakun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(buatakun.this,sudahpunyaakunlogin.class));
            }
        });

        btnlanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(edEmail.getText().toString()) || TextUtils.isEmpty(edPassword.getText().toString()) || TextUtils.isEmpty(edusername.getText().toString())){

                    String message = "masukkan email dan password!";
                    Toast.makeText(buatakun.this,message,Toast.LENGTH_LONG).show();
                }else {
                    RegisterRequest registerRequest = new RegisterRequest();
                    registerRequest.setEmail(edEmail.getText().toString());
                    registerRequest.setPassword(edPassword.getText().toString());
                    registerRequest.setNama(edusername.getText().toString());
                    registeruser(registerRequest);
                }
            }
        });
    }

    public void registeruser(RegisterRequest registerRequest){
        Call<RegisterResponse> registerResponseCall = ApiClientLogin.getService().registerUser(registerRequest);
        registerResponseCall.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

                if(response.isSuccessful()){

                    String message = "nice bro...";
                    Toast.makeText(buatakun.this,message,Toast.LENGTH_LONG).show();

                    startActivity(new Intent(buatakun.this,sudahpunyaakunlogin.class));
                    finish();

                }else{

                    String message = "eror 404..";
                    Toast.makeText(buatakun.this,message,Toast.LENGTH_LONG).show();
                }
                
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {

                String message = t.getLocalizedMessage();
                Toast.makeText(buatakun.this,message,Toast.LENGTH_LONG).show();
            }
        });
    }

    public void btnlanjut(View view) {
        Intent intent = new Intent(this,beranda.class);
        startActivity(intent);

    }
}