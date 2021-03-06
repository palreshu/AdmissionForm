package com.hello.reshu.com.admissionform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

class Student{
    String name,address,college;
    int phoneNo;

    Student(int phoneNo,String name,String address,String college)
    {
        this.name=name;
        this.address=address;
        this.college=college;
        this.phoneNo=phoneNo;
    }
}

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> stu=new ArrayList<Student>();
    TextView textview_name,display_data,studentDisplay;
    EditText edittext_name,studentName,studentPhoneNumber,studentAddress,studentCollege;
    Button button_displayresult,displaybtn,addbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentName=(EditText) findViewById(R.id.edittext_name);
        studentPhoneNumber=(EditText) findViewById(R.id.edittext_phone);
        studentAddress=(EditText) findViewById(R.id.edittext_address);
        studentCollege=(EditText) findViewById(R.id.edittext_college);
        studentDisplay=(TextView) findViewById(R.id.display_data);





        addbtn=(Button) findViewById(R.id.btn_add);
        displaybtn=(Button) findViewById(R.id.button_displayresult);



        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = String.valueOf(studentName.getText());
                try {
                    int phoneNo = Integer.parseInt(studentPhoneNumber.getText().toString());
                    String address=String.valueOf(studentAddress.getText());
                    String college=String.valueOf(studentCollege.getText());
                    stu.add(new Student(phoneNo,name,address,college));

                }

                catch (NumberFormatException e)
                {
                    Toast.makeText(getApplicationContext(), "Enter valid fees", Toast.LENGTH_LONG).show();
                }

            }
        });

        displaybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<stu.size();i++){
                    studentDisplay.setText(studentDisplay.getText() + "\n" +stu.get(i).name);
                    studentDisplay.setText(studentDisplay.getText() + "\n" +stu.get(i).phoneNo);
                    studentDisplay.setText(studentDisplay.getText() + "\n" +stu.get(i).address);
                    studentDisplay.setText(studentDisplay.getText() + "\n" +stu.get(i).college);
                    studentDisplay.setText(studentDisplay.getText() + "\n" +"**********");
                }

            }
        });
    }
}


