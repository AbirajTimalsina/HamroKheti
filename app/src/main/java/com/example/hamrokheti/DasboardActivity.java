package com.example.hamrokheti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import de.hdodenhof.circleimageview.CircleImageView;

public class DasboardActivity extends AppCompatActivity {
    
    CircleImageView circleImageView;
    TextView Name, Email;
    Button Btn_Logout;

    GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasboard);

        circleImageView = findViewById(R.id.profile_image);
        Name = findViewById(R.id.txt_Name);
        Email = findViewById(R.id.txt_Email);
        Btn_Logout = findViewById(R.id.Btn_Logout);
        Btn_Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                switch (view.getId()) {
                    case R.id.Btn_Logout:
                        signOut();
                        break;
                }
            }
        });

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            String personName = acct.getDisplayName();
            String personEmail = acct.getEmail();
//            String personId = acct.getId();
            Uri personPhoto = acct.getPhotoUrl();

            Name.setText(personName);
            Email.setText(personEmail);
            Glide.with(this).load(personPhoto).into(circleImageView);

        }

    }

    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(DasboardActivity.this, "Signed out successfully", Toast.LENGTH_LONG).show();
                        finish();
                    }
                });
    }
}