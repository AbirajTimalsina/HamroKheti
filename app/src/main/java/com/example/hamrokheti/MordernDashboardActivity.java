package com.example.hamrokheti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class MordernDashboardActivity extends AppCompatActivity{
    CircleImageView circleImageView;
    TextView name,email;
    ImageView imgWheather,ImgProfile,imgMarket;
    GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mordern_dashboard);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        circleImageView = findViewById(R.id.Dash_profileImage);
        ImgProfile = findViewById(R.id.imgprofile);
        imgWheather = findViewById(R.id.imgWheather);
        imgMarket = findViewById(R.id.imgMarket);

        imgMarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MordernDashboardActivity.this,CategoryActivity.class);
                startActivity(intent);
            }
        });

        imgWheather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MordernDashboardActivity.this,WheatherActivity.class);
                startActivity(intent);
            }
        });

        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MordernDashboardActivity.this,ProfileActivity.class);
                startActivity(intent);
            }
        });
        ImgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MordernDashboardActivity.this,ProfileActivity.class);
                startActivity(intent);
            }
        });


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            String personName = acct.getDisplayName();
            String personEmail = acct.getEmail();
            Uri personPhoto = acct.getPhotoUrl();

            name.setText(personName);
            email.setText(personEmail);
            Glide.with(this).load(String.valueOf(personPhoto)).into(circleImageView);

        }
    }
}