package com.example.login_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
public static final String F_Name="FName",L_Name="LName",E_Mail="Email",Pass_Word="pass",Age_="Age",Phone_="Phone";
TextView Lname2, Fname2,pass2,email2,phonen2,age2;
    private String Sfname,Slname,Spassw,Smail;
    private int IAge,Iphone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Fname2 =findViewById(R.id.mFname);
        phonen2=findViewById(R.id.mphonen);
        email2=findViewById(R.id.mEmail);
        pass2=findViewById(R.id.mpassw);
        age2 =findViewById(R.id.mage);

        Intent intent=getIntent();
        Sfname=intent.getStringExtra(F_Name);
        Slname=intent.getStringExtra(L_Name);
        Smail=intent.getStringExtra(E_Mail);
        Spassw=intent.getStringExtra(Pass_Word);
        IAge=intent.getIntExtra(Age_,0);
        Iphone=intent.getIntExtra(Phone_,0);

        Fname2.setText("Your name is "+Sfname+" "+Slname);
        email2.setText("Your Email is "+Smail);
        pass2.setText("Your password is "+Spassw);
        age2.setText("Your Age is "+IAge);
        phonen2.setText("Your Phone number is "+Iphone);








    }
}