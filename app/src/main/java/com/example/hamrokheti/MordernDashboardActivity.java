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

public class MordernDashboardActivity extends AppCompatActivity implements View.OnClickListener{
    CircleImageView circleImageView;
    TextView name,email;
    ImageView profile;
    GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mordern_dashboard);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        circleImageView = findViewById(R.id.profileImage);
        profile = findViewById(R.id.profile);
        circleImageView.setOnClickListener(this);
        profile.setOnClickListener(this);

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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.profileImage:
                Intent intent = new Intent(MordernDashboardActivity.this,ProfileActivity.class);
                startActivity(intent);

            case R.id.profile:
                Intent intent1 = new Intent(MordernDashboardActivity.this,ProfileActivity.class);
                startActivity(intent1);
        }
    }
}