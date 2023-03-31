package com.mpiyush3510.studentapp.Startup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.mpiyush3510.studentapp.Activities.SignIn;
import com.mpiyush3510.studentapp.Activities.SignUp;
import com.mpiyush3510.studentapp.R;
import com.mpiyush3510.studentapp.databinding.GetStartedBinding;

public class GetStarted extends AppCompatActivity {
    GetStartedBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=GetStartedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Caller();
    }

    private void Caller() {
        binding.SignIn.setOnClickListener(v -> {startActivity(new Intent(GetStarted.this, SignIn.class));});
        binding.SignUp.setOnClickListener(v -> {startActivity(new Intent(GetStarted.this, SignUp.class));});
    }
}