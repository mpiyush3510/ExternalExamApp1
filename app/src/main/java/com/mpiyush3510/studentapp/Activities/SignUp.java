package com.mpiyush3510.studentapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.mpiyush3510.studentapp.R;
import com.mpiyush3510.studentapp.databinding.SignUpBinding;

public class SignUp extends AppCompatActivity {
SignUpBinding binding;
Intent intent;
ArrayAdapter<String> arrayAdapter;
String[] division={"SYBCA_1","SYBCA_2","SYBCA_3","SYBCA_4","SYBCA_5","SYBCA_6","SYBCA_7","SYBCA_8"};
String[] Rno={
        "171","172","173","174","175",
        "271","272","273","274","275",
        "371","72","373","374","375",
        "471","472","473","474","475",
        "571","572","573","574","575",
        "671","672","673","674","675",
        "771","772","773","774","775",
        "871","872","873","874","875"};
MaterialDatePicker<Long> materialDatePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=SignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        arrayAdapter = new ArrayAdapter<>(getApplication(),R.layout.bg_spinner,division);
        binding.Division.setAdapter(arrayAdapter);

        arrayAdapter = new ArrayAdapter<>(getApplication(),R.layout.bg_spinner,Rno);
        binding.Rno.setAdapter(arrayAdapter);

        Callers();

    }

    private void Callers() {
        binding.SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(IsItValid()) {
                    intent = new Intent(getApplicationContext(), MainActivity.class);
                    exportData();
                    startActivity(intent);
                }
            }
        });
        materialDatePicker();
        binding.BirthDateImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDatePicker.show(getSupportFragmentManager(),"Material date picker");
                materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Long>() {
                    @Override
                    public void onPositiveButtonClick(Long selection) {
                        binding.BirtDate.setText(materialDatePicker.getHeaderText());
                    }
                });
            }
        });
    }
    private void materialDatePicker(){
        materialDatePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select your date ")
                .setSelection(MaterialDatePicker.thisMonthInUtcMilliseconds())
                .build();
    }

    private boolean IsItValid(){
        if(binding.FirstName.getText().toString().isEmpty() ){
            showToast("Please Enter Your first Name");
            return false;
//        } else if (binding.LastName.getText().toString().isEmpty()) {
//            showToast("Please Enter your Last Name");
//            return false;
//        } else if (binding.Email.getText().toString().isEmpty()) {
//            showToast(" Email Needed");
//            return false;
//        }else if (!Patterns.EMAIL_ADDRESS.matcher(binding.Email.getText().toString()).matches()){
//            showToast("enter Valid Email");
//            return false;
//        } else if (binding.BirtDate.getText().toString().isEmpty()) {
//            showToast("Selected Your Bdate");
//            return false;
//        } else if (binding.PhoneNo.getText().toString().isEmpty()) {
//            showToast("Enter Your Phone No");
//            return false;
//        } else if (binding.PhoneNo.getText().toString().length()<10) {
//            showToast("Enter Valid phone no");
//            return false;
        } else if (!binding.Male.isChecked() && !binding.Female.isChecked() && !binding.Other.isChecked()) {
            showToast("Choose Your Gender");
            return false;
//        } else if (binding.Division.getText().toString().isEmpty()) {
//            showToast("Select Your Division");
//            return false;
//        } else if (binding.Rno.getText().toString().isEmpty()) {
//            showToast("Select your Roll No");
//            return false;
//        } else if (binding.Area.getText().toString().isEmpty()) {
//            showToast("Enter Your Area ");
//            return false;
//        } else if (Patterns.PHONE.matcher(binding.Area.getText().toString()).matches()) {
//            showToast("Area must be text");
//            return false;
        }
        return true;
    }

    private void exportData(){
        String Gender=((RadioButton)findViewById(binding.Gender.getCheckedRadioButtonId())).getText().toString();
        intent.putExtra("t1",binding.FirstName.getText().toString());
        intent.putExtra("t2",binding.LastName.getText().toString());
        intent.putExtra("t3",binding.Email.getText().toString());
        intent.putExtra("t4",binding.BirtDate.getText().toString());
        intent.putExtra("t5",binding.PhoneNo.getText().toString());
        intent.putExtra("t6",Gender);
        intent.putExtra("t7",binding.Division.getText().toString());
        intent.putExtra("t8",binding.Rno.getText().toString());
        intent.putExtra("t9",binding.Area.getText().toString());
    }
    private void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}