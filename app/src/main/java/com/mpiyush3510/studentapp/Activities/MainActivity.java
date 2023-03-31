package com.mpiyush3510.studentapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.mpiyush3510.studentapp.R;
import com.mpiyush3510.studentapp.Startup.GetStarted;
import com.mpiyush3510.studentapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Callers();
    }

    private void Callers() {
        importData();
        binding.Main.setOnClickListener(v -> {startActivity(new Intent(getApplicationContext(), GetStarted.class));});
    }

    private void importData() {
        intent=getIntent();
        String s1=intent.getStringExtra("t1");
        String s2=intent.getStringExtra("t2");
        String s3=intent.getStringExtra("t3");
        String s4=intent.getStringExtra("t4");
        String s5=intent.getStringExtra("t5");
        String s6=intent.getStringExtra("t6");
        String s7=intent.getStringExtra("t7");
        String s8=intent.getStringExtra("t8");
        String s9=intent.getStringExtra("t9");
        binding.FirstName.setText(s1);
        binding.LastName.setText(s2);
        binding.Email.setText(s3);
        binding.BirtDate.setText(s4);
        binding.PhoneNo.setText(s5);
        binding.Gender.setText(s6);
        binding.Division.setText(s7);
        binding.Rno.setText(s8);
        binding.Area.setText(s9);
    }
}