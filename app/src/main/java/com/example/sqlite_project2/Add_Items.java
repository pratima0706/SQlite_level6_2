package com.example.sqlite_project2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import de.hdodenhof.circleimageview.CircleImageView;

public class Add_Items extends AppCompatActivity {
    CircleImageView imageView;
    EditText txt_name, txt_description;
    Button Add_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_items);

        imageView=findViewById(R.id.img);
        txt_name=findViewById(R.id.txt1);
        txt_description=findViewById(R.id.txt2);
        Add_btn=findViewById(R.id.btn);



        //We can give multiple setonclicklistener like the given below

        imageView.setOnClickListener(this::pickImage);
        // and give method

        Add_btn.setOnClickListener(this::clickAddItems);

    }

    private void pickImage(View view) {

        ImageUtility.pickImage(view, this);



    }

    private void clickAddItems(View view) {

        String name=txt_name.getText().toString().trim();
        //validating it
        if (name.isEmpty()){
            txt_name.setError("Name is Mandatory");
            txt_name.requestFocus();
            return;
        }

        String description=txt_description.getText().toString().trim();
        //Validating it
        if (description.isEmpty()){
            txt_description.setError("Description is Empty");
            txt_description.requestFocus();
            return;

        }

    }
}