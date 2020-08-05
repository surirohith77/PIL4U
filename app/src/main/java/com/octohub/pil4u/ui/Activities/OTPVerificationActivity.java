package com.octohub.pil4u.ui.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.octohub.pil4u.R;
import com.octohub.pil4u.utils.AccoutUtils;
import com.octohub.pil4u.utils.shared_prefernece;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class OTPVerificationActivity extends AppCompatActivity {

    private String verifiacionId;
    private FirebaseAuth firebaseAuth;
    String mobile;
    private TextInputLayout editText;
    private shared_prefernece sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_t_p_verification);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        sp = new shared_prefernece(this);

        editText = findViewById(R.id.et_otp);
        firebaseAuth = FirebaseAuth.getInstance();

        mobile = getIntent().getStringExtra("phonenumber");
        sendverificationcod(mobile);

    }


    private void sendverificationcod(String number){
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                number,
                60,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mCALLBACK

        );
    }

    //ctrl + space after new
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks
            mCALLBACK = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);

            verifiacionId = s;
        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

            String code = phoneAuthCredential.getSmsCode();
            if (code != null){
                Objects.requireNonNull(editText.getEditText()).setText(code);
                verifycodes(code);
            }
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(OTPVerificationActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    };


    public void verifycode(View view) {
        String code = editText.getEditText().getText().toString().trim();
        if (code.isEmpty() || code.length()<6){
            editText.setError("Enter valid code");
            return;
        }
        verifycodes(code);
    }

    private void verifycodes(String code){
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verifiacionId, code);
        signInWithCredential(credential);
    }

    private void signInWithCredential(PhoneAuthCredential credential) {

        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {

                           // sp.writeloginstatus(true);

                         //   AccoutUtils.setMobile_number(OTPVerificationActivity.this,mobile);

                            setPreferences();

                            Intent intent = new Intent(OTPVerificationActivity.this,SelectRoleActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK );
                            startActivity(intent);
                        }else {
                            Toast.makeText(OTPVerificationActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void setPreferences(){

        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        sharedPref.edit().putString(getString(R.string.pref_mobile), mobile).apply();


    }
}

