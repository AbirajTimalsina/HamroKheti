package com.example.hamrokheti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;

import de.hdodenhof.circleimageview.CircleImageView;

public class MordernDashboardActivity extends AppCompatActivity {
    CircleImageView circleImageView;
    ImageView profile;
    GoogleSignInClient mGoogleSignInClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mordern_dashboard);
        circleImageView = findViewById(R.id.profileImage);
        profile = findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MordernDashboardActivity.this,DasboardActivity.class);
                startActivity(intent);
            }
        });
    }
}