package com.example.information_d1;

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

        etName = findViewById(R.id.etName);
        etId = findViewById(R.id.etId);
        etAddress = findViewById(R.id.etAddress);
        etEmail = findViewById(R.id.etEmail);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnCancel = findViewById(R.id.btnCancel);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etName.setText("");
                etPhoneNumber.setText("");
                etAddress.setText("");
                etEmail.setText("");
                etId.setText("");
            }
        });

        btnSubmit.setOnClickListener((v)->{

            String name = etName.getText().toString();
            String id = etId.getText().toString();
            String phone = etPhoneNumber.getText().toString();
            String email = etEmail.getText().toString();
            String address = etAddress.getText().toString();

            if(name.isEmpty())
            {
                etName.setError("Empty Name");
            }
            else if(id.isEmpty())
            {
                Toast.makeText(this, "Invalid ID", Toast.LENGTH_SHORT).show();
            }

        });
















    }


}