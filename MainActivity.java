package com.example.login_activity;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;


public class MainActivity extends AppCompatActivity {
EditText FirstName,LastName,Phone,Email,password, age;
Button submit;
AwesomeValidation awesomeValidation;
private String Fname,Lname,pass,email;
private int Age,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirstName=findViewById(R.id.fn);
        LastName=findViewById(R.id.ln);
        Phone=findViewById(R.id.phone);
        Email=findViewById(R.id.mEmail);
        password=findViewById(R.id.pass);
        age =findViewById(R.id.Age);
        submit=findViewById(R.id.submit);

        awesomeValidation =new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this,R.id.fn, RegexTemplate.NOT_EMPTY,R.string.invalidname);
        awesomeValidation.addValidation(this,R.id.ln, RegexTemplate.NOT_EMPTY,R.string.invalidname);
        awesomeValidation.addValidation(this,R.id.phone,RegexTemplate.NOT_EMPTY,R.string.invalidphone);
        awesomeValidation.addValidation(this,R.id.Age,RegexTemplate.NOT_EMPTY,R.string.invalidAge);
        awesomeValidation.addValidation(this,R.id.mEmail, Patterns.EMAIL_ADDRESS,R.string.invalidEmail);
        awesomeValidation.addValidation(this,R.id.pass,".{6,}",R.string.invalidpassword);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(awesomeValidation.validate()){
                    SendData();

                }
                else {
                    Toast.makeText(getApplicationContext(),"From validate Faild",Toast.LENGTH_SHORT).show();

                }
            }
        });






    }
    public void SendData(){
        Fname=FirstName.getText().toString().trim();
        Lname=LastName.getText().toString().trim();
        email=Email.getText().toString().trim();
        pass=password.getText().toString().trim();
        Age=Integer.parseInt(age.getText().toString().trim());
        phone=Integer.parseInt(Phone.getText().toString().trim());

        Intent intent=new Intent(MainActivity.this,MainActivity2.class);

        intent.putExtra(MainActivity2.F_Name,Fname);
        intent.putExtra(MainActivity2.L_Name,Lname);
        intent.putExtra(MainActivity2.E_Mail,email);
        intent.putExtra(MainActivity2.Pass_Word,pass);
        intent.putExtra(MainActivity2.Age_,Age);
        intent.putExtra(MainActivity2.Phone_,phone);

        startActivity(intent);

    }

}