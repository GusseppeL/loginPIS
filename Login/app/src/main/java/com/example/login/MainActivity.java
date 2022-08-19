package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView logLinkRegistro;
    EditText logInputPass;
    EditText logInputCorreo;
    Button logBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logLinkRegistro=findViewById(R.id.linkRegistro);
        logInputCorreo=findViewById(R.id.inputCorreo);
        logInputPass=findViewById(R.id.inputPass);
        logBtnLogin=findViewById(R.id.btnLogin);

        logLinkRegistro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        logBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

    }

    private void login() {
        String correo=logInputCorreo.getText().toString();
        String pass=logInputPass.getText().toString();

        Log.d("Campo","Correo: "+correo);
        Log.d("Campo","Contraseña: "+pass);
    }
}