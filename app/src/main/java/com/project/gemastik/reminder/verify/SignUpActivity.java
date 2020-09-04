package com.project.gemastik.reminder.verify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.dx.dxloadingbutton.lib.LoadingButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.project.gemastik.reminder.R;
import com.subhrajyoti.passwordview.PasswordView;

public class SignUpActivity extends AppCompatActivity {

    EditText username, email;
    PasswordView pw, cpw;
    LoadingButton signin;

    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = findViewById(R.id.usersign);
        email = findViewById(R.id.mailsign);
        pw = findViewById(R.id.pwsign);
        cpw = findViewById(R.id.cpwsign);

        fAuth = FirebaseAuth.getInstance();

        signin = findViewById(R.id.btnsignup);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registUser();
            }
        });
    }

    private void registUser(){
        String txuser, txmail, txpass, txcpass;

        txuser = username.getText().toString();
        txmail = email.getText().toString();
        txpass = pw.getText().toString();
        txcpass = cpw.getText().toString();


        if (TextUtils.isEmpty(txuser)){
            Toast.makeText(getApplicationContext(),"Username tidak boleh kosong!",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(txmail)){
            Toast.makeText(getApplicationContext(),"Email tidak boleh kosong!",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(txpass)){
            Toast.makeText(getApplicationContext(),"Password tidak boleh kosong!",Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(txcpass)){
            Toast.makeText(getApplicationContext(),"Konfirmasi Password tidak boleh kosong!",Toast.LENGTH_SHORT).show();
            return;
        }

        fAuth.createUserWithEmailAndPassword(txmail, txpass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Email tidak boleh kosong!",Toast.LENGTH_SHORT).show();

                            Intent intentup = new Intent(SignUpActivity.this, LoginActivity.class);
                            startActivity(intentup);
                            signin.loadingSuccessful();
                        } else {
                            Toast.makeText(getApplicationContext(),"Password tidak boleh kosong!",Toast.LENGTH_SHORT).show();
                            signin.loadingFailed();
                        }

                    }
                });
    }
}
