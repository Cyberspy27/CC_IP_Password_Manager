package com.example.passwordmanager.models.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.passwordmanager.R;
import com.example.passwordmanager.models.password.Password;

public class SavePassword extends AppCompatActivity {

    private EditText editPwdName,editPwdValue,editPwdLogin;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_password);

        initViews();
    }

    private void initViews(){
        editPwdLogin = findViewById(R.id.edit_pwd_login);
        editPwdValue = findViewById(R.id.edit_pwd_value);
        editPwdName = findViewById(R.id.edit_pwd_name);
        btnSave = findViewById(R.id.btn_save);

        String generatedPassword = getIntent().getStringExtra("pwd");
        editPwdValue.setText(generatedPassword);

        btnSave.setOnClickListener(v -> {
            DatabaseHelper dbHelper = new DatabaseHelper(SavePassword.this);
            Password password = new Password(editPwdName.getText().toString(),editPwdLogin.getText().toString(),editPwdValue.getText().toString());
            boolean saved = dbHelper.insert(password);
            if(saved){
                Toast.makeText(this,"Password Is Saved", Toast.LENGTH_SHORT).show();
                btnSave.setEnabled(false);
            }
        });
    }
}