package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

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
        String contraseña=logInputPass.getText().toString();
        Pattern correoPl = Pattern.compile("^[a-z0-9]+([.][a-z0-9]+)*[@]+[a-z0-9]+[.]+[a-z]{3,4}$");
        boolean validaCorreo = correoPl.matcher(correo).matches();
        Pattern passPl = Pattern.compile("^\\S*(?=\\S{6,})(?=\\S*\\d)(?=\\S*[A-Z])(?=\\S*[a-z])(?=\\S*[!@#$%^&*?.])\\S*$");
        boolean validaContra = passPl.matcher(contraseña).matches();

        if (!correo.isEmpty() && !contraseña.isEmpty()) {
            if (validaCorreo==true ) {
                Toast.makeText(this, "el correo es valido", Toast.LENGTH_SHORT).show();
                if (validaContra==true ) {
                    Toast.makeText(this, "el contraseña es valida", Toast.LENGTH_SHORT).show();
                    Log.d("Campo","Correo: "+correo);
                    Log.d("Campo","Contraseña: "+contraseña);
                } else {
                    Toast.makeText(this, " El contraseña no es valida", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, " El correo no es valido", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Para continuar inserta todos los campos", Toast.LENGTH_SHORT).show();

        }


    }
}