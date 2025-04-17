package com.example.information_d1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Hooks
    EditText etName, etId, etPhoneNumber, etAddress, etEmail;
    Button btnSubmit, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        btnCancel.setOnClickListener((v)->{
            clear();
        });

        btnSubmit.setOnClickListener((v)->{
            String name = etName.getText().toString();
            String id = etId.getText().toString();
            String phone = etPhoneNumber.getText().toString();
            String email = etEmail.getText().toString();
            String address = etAddress.getText().toString();

            if(name.isEmpty())
            {
                etName.setError("Plz provide name");
                return;
            }

            if(id.isEmpty())
            {
                etId.setError("Plz provide id");
                return;
            }

            if(phone.isEmpty())
            {
                etPhoneNumber.setError("Plz provide phone");
                return;
            }

            if(address.isEmpty())
            {
                etAddress.setError("Plz provide Address");
                return;
            }

            // Intent = Connect two activities
            Intent intent = new Intent(MainActivity.this, Dashboard.class);
            intent.putExtra("key_name", name);
            intent.putExtra("key_id", id);
            intent.putExtra("key_phone", phone);
            intent.putExtra("key_address", address);
            intent.putExtra("key_email", email);
            startActivity(intent);

            finish();

        });


    }


    private void init()
    {
        etName = findViewById(R.id.etName);
        etId = findViewById(R.id.etId);
        etAddress = findViewById(R.id.etAddress);
        etEmail = findViewById(R.id.etEmail);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnCancel = findViewById(R.id.btnCancel);
    }

    private void clear()
    {
        etName.setText("");
        etPhoneNumber.setText("");
        etAddress.setText("");
        etEmail.setText("");
        etId.setText("");
    }

}