package com.example.information_d1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Dashboard extends AppCompatActivity {

    // hooks
    TextView tvName, tvId, tvPhone, tvEmail, tvAddress;
    Button btnGetInformation;
    ImageView ivPhone, ivAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        Intent information = getIntent();
        String name = information.getStringExtra("key_name");
        String id = information.getStringExtra("key_id");
        String phone = information.getStringExtra("key_phone");
        String address = information.getStringExtra("key_address");
        String email = information.getStringExtra("key_email");

        tvName.setText("Welcome "+name+"!");
        tvId.setText(id);
        tvPhone.setText(phone);
        tvAddress.setText(address);
        tvEmail.setText(email);

        btnGetInformation.setOnClickListener((v)->{
            Intent i = new Intent(Dashboard.this, MainActivity.class);
            startActivity(i);
            finish();
        });

        ivPhone.setOnClickListener((v)->{
            Intent i = new Intent(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:"+phone));
            startActivity(i);
        });

        ivAddress.setOnClickListener((v)->{
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("geo:(0,0)?q="+address));

            startActivity(i);
        });

    }

    private void init()
    {
        tvName = findViewById(R.id.tvName);
        tvId = findViewById(R.id.tvId);
        tvAddress = findViewById(R.id.tvAddress);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        btnGetInformation = findViewById(R.id.btnGetInformation);
        ivAddress = findViewById(R.id.ivAddress);
        ivPhone = findViewById(R.id.ivPhone);
    }

}