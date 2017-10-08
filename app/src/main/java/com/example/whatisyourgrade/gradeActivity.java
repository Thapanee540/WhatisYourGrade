package com.example.whatisyourgrade;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by TO_MANG on 8/10/2560.
 */

public class gradeActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grade_activity);
        Intent intent = getIntent();

        TextView view = (TextView)findViewById(R.id.Name_textView);
        view.setText(intent.getStringExtra("NameText"));

        TextView view1 = (TextView)findViewById(R.id.grade_textView);
        view1.setText(intent.getStringExtra("GradeText"));
    }
    public void onBackPressed(){
        Intent intent = new Intent(gradeActivity.this, MainActivity.class);
        TextView view = (TextView)findViewById(R.id.Name_textView);
        view.setText(null);

        TextView view1 = (TextView)findViewById(R.id.grade_textView);
        view1.setText(null);
        startActivity(intent);

    }
}
