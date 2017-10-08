package com.example.whatisyourgrade;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class MainActivity extends AppCompatActivity {
    private EditText eNameEditText,eScoreEditText;
    private Button eFindGradeButton,eExitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        eNameEditText.setError("ป้อนชื่อ");
//        eScoreEditText.setError("ป้อนเกรด");
        eNameEditText = (EditText) findViewById(R.id.name_Edit_Text);
        eScoreEditText = (EditText) findViewById(R.id.score_Edit_Text);
        eFindGradeButton = (Button) findViewById(R.id.find_grade_button);
        eExitButton = (Button) findViewById(R.id.exit_button);

        String eName = eNameEditText.getText().toString();
        String eScore = eScoreEditText.getText().toString();

        if (eName.length()==0 ) {
            eNameEditText.setError("ป้อนชื่อ");
        }

        if (eScore.length()==0) {
            eScoreEditText.setError("ป้อนเกรด");
        }

            eFindGradeButton.setOnClickListener(new View.OnClickListener() {
                @Override


                public void onClick(View v) {
                    String eName = eNameEditText.getText().toString();
                    String eScore = eScoreEditText.getText().toString();

                    if (eName.length()==0) {
                        eNameEditText.setError("ป้อนชื่อ");
                    }
                    if (eScore.length()==0) {
                        eScoreEditText.setError("ป้อนเกรด");
                    }

                    if (eScore.length()!=0 && eName.length()!=0) {
                    Double grade = Double.valueOf(eScoreEditText.getText().toString());
                    Intent intent = new Intent(MainActivity.this, gradeActivity.class);
                    intent.putExtra("GradeText", getGrade(grade));

                    intent.putExtra("NameText", eNameEditText.getText().toString());

                            startActivity(intent);
                    }

                }

                private String getGrade(Double grade) {
                    String gradeText = "";

                    if (grade >= 80) {
                        gradeText = "A";
                    } else if (grade >= 70) {
                        gradeText = "B";
                    } else if (grade >= 60) {
                        gradeText = "C";
                    } else if (grade >= 50) {
                        gradeText = "D";
                    } else {
                        gradeText = "F";
                    }
                    return gradeText;

                }
            });

            eExitButton.setOnClickListener(new View.OnClickListener() {
                @Override


                public void onClick(View v) {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("Confirm Exit");
                    dialog.setCancelable(true);
                    dialog.setMessage("แน่ใจว่าต้องการออกจากแอพ?");

                    dialog.setPositiveButton("ออก", new OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });

                    dialog.setNegativeButton("ยกเลิก", new OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    dialog.show();
                }
            });
        }



}
