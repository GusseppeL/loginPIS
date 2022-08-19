package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    TextView regVolver;
    EditText reginputNombre;
    EditText reginputAp;
    EditText reginputCorreo;
    EditText reginputPass;
    Button regButtonRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        reginputNombre = findViewById(R.id.inputNombre);
        reginputAp = findViewById(R.id.inputAp);
        reginputCorreo = findViewById(R.id.inputCorreo);
        reginputPass = findViewById(R.id.inputPass);
        regButtonRegistro = findViewById(R.id.btnRegistro);


        regButtonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });

        regVolver=findViewById(R.id.volver);

        regVolver.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void register() {
        String nombre = reginputNombre.getText().toString();
        String apellido = reginputAp.getText().toString();
        String correo = reginputCorreo.getText().toString();
        String contraseña = reginputPass.getText().toString();
        Pattern correoPl = Pattern.compile("^[a-z0-9]+([.][a-z0-9]+)*[@]+[a-z0-9]+[.]+[a-z]{3,4}$");
        boolean validaCorreo = correoPl.matcher(correo).matches();
        Pattern passPl = Pattern.compile("^\\S*(?=\\S{6,})(?=\\S*\\d)(?=\\S*[A-Z])(?=\\S*[a-z])(?=\\S*[!@#$%^&*?.])\\S*$");
        boolean validaContra = passPl.matcher(contraseña).matches();

        if (!nombre.isEmpty() && !apellido.isEmpty() && !correo.isEmpty() && !contraseña.isEmpty()) {
            if (validaCorreo==true ) {
                Toast.makeText(this, "el correo es valido", Toast.LENGTH_SHORT).show();
                if (validaContra==true ) {
                    Toast.makeText(this, "el contraseña es valida", Toast.LENGTH_SHORT).show();
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