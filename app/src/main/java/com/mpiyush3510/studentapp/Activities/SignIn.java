package com.mpiyush3510.studentapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.mpiyush3510.studentapp.R;
import com.mpiyush3510.studentapp.databinding.SignInBinding;

public class SignIn extends AppCompatActivity {
SignInBinding binding;
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=SignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Caller();

    }

    private void Caller() {
            binding.SignIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(isValidate()){
                        intent=new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                }
            });
    }

    private boolean isValidate() {
        if(binding.EmailOrPhone.getText().toString().isEmpty()){
            showToast("Please Enter User ID");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(binding.EmailOrPhone.getText().toString()).matches() && !Patterns.PHONE.matcher(binding.EmailOrPhone.getText().toString()).matches()){
            showToast("Enter Valid User iD");
            return false;
        } else if (binding.Password.getText().toString().isEmpty()) {
            showToast("Password Can't be empty");
            return false;
        }else{
            return true;
        }
    }

    private void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}