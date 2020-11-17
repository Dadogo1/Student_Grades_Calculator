package com.example.studentgradescalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class InputData extends AppCompatActivity {
    private EditText input_total_number_of_students, input_grade_a_students, input_grade_b_students, input_grade_c_students, input_grade_d_students, input_grade_f_students;
    private Button calculate_button;
    public static float total_number_of_students, grade_a_students, grade_b_students, grade_c_students, grade_d_students, grade_f_students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);
        input_total_number_of_students = findViewById(R.id.input_total_number_of_students);
        input_grade_a_students = findViewById(R.id.input_grade_a_students);
        input_grade_b_students = findViewById(R.id.input_grade_b_students);
        input_grade_c_students = findViewById(R.id.input_grade_c_students);
        input_grade_d_students = findViewById(R.id.input_grade_d_students);
        input_grade_f_students = findViewById(R.id.input_grade_f_students);
        calculate_button = findViewById(R.id.calculate_button);
        //This button will initiate calculating all inputs
        calculate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //To check total number of students field
                if (input_total_number_of_students.getText().toString().isEmpty()) {
                    input_total_number_of_students.setError("This is empty!");
                }
                else if (!Pattern.compile("^\\d{1,7}$").matcher(input_total_number_of_students.getText().toString()).matches()){
                    input_total_number_of_students.setError("Only a number from 0 to 1000000!");
                }
                else {
                    input_total_number_of_students.setError(null);
                }
                //To check grade A students field
                if (input_grade_a_students.getText().toString().isEmpty()) {
                    input_grade_a_students.setError("This is empty!");
                }
                else if (!Pattern.compile("^\\d{1,7}$").matcher(input_grade_a_students.getText().toString()).matches()){
                    input_grade_a_students.setError("Only a number from 0 to 1000000!");
                }
                else {
                    input_grade_a_students.setError(null);
                }
                //To check grade B students field
                if (input_grade_b_students.getText().toString().isEmpty()) {
                    input_grade_b_students.setError("This is empty!");
                }
                else if (!Pattern.compile("^\\d{1,7}$").matcher(input_grade_b_students.getText().toString()).matches()){
                    input_grade_b_students.setError("Only a number from 0 to 1000000!");
                }
                else {
                    input_grade_b_students.setError(null);
                }
                //To check grade C students field
                if (input_grade_c_students.getText().toString().isEmpty()) {
                    input_grade_c_students.setError("This is empty!");
                }
                else if (!Pattern.compile("^\\d{1,7}$").matcher(input_grade_c_students.getText().toString()).matches()){
                    input_grade_c_students.setError("Only a number from 0 to 1000000!");
                }
                else {
                    input_grade_c_students.setError(null);
                }
                //To check grade D students field
                if (input_grade_d_students.getText().toString().isEmpty()) {
                    input_grade_d_students.setError("This is empty!");
                }
                else if (!Pattern.compile("^\\d{1,7}$").matcher(input_grade_d_students.getText().toString()).matches()){
                    input_grade_d_students.setError("Only a number from 0 to 1000000!");
                }
                else {
                    input_grade_d_students.setError(null);
                }
                //To check grade F students field
                if (input_grade_f_students.getText().toString().isEmpty()) {
                    input_grade_f_students.setError("This is empty!");
                }
                else if (!Pattern.compile("^\\d{1,7}$").matcher(input_grade_f_students.getText().toString()).matches()){
                    input_grade_f_students.setError("Only a number from 0 to 1000000!");
                }
                else {
                    input_grade_f_students.setError(null);
                }
                //If all fields are properly formatted, all inputs will be saved to the each respective variable and send the user to the graph activity
                if (!input_grade_a_students.getText().toString().isEmpty() && !input_grade_b_students.getText().toString().isEmpty() && !input_grade_c_students.getText().toString().isEmpty() && !input_grade_d_students.getText().toString().isEmpty() && !input_grade_f_students.getText().toString().isEmpty() && Pattern.compile("^\\d{1,7}$").matcher(input_grade_a_students.getText().toString()).matches() && Pattern.compile("^\\d{1,7}$").matcher(input_grade_b_students.getText().toString()).matches() && Pattern.compile("^\\d{1,7}$").matcher(input_grade_c_students.getText().toString()).matches() && Pattern.compile("^\\d{1,7}$").matcher(input_grade_d_students.getText().toString()).matches() && Pattern.compile("^\\d{1,7}$").matcher(input_grade_f_students.getText().toString()).matches() && Integer.parseInt(input_grade_a_students.getText().toString()) + Integer.parseInt(input_grade_b_students.getText().toString()) + Integer.parseInt(input_grade_c_students.getText().toString()) + Integer.parseInt(input_grade_d_students.getText().toString()) + Integer.parseInt(input_grade_f_students.getText().toString()) == Integer.parseInt(input_total_number_of_students.getText().toString())) {
                    total_number_of_students = Float.parseFloat(input_total_number_of_students.getText().toString());
                    grade_a_students = Float.parseFloat(input_grade_a_students.getText().toString());
                    grade_b_students = Float.parseFloat(input_grade_b_students.getText().toString());
                    grade_c_students = Float.parseFloat(input_grade_c_students.getText().toString());
                    grade_d_students = Float.parseFloat(input_grade_d_students.getText().toString());
                    grade_f_students = Float.parseFloat(input_grade_f_students.getText().toString());
                    Intent to_student_grade_data_result = new Intent(InputData.this, DataResult.class);
                    startActivity(to_student_grade_data_result);
                    finish();
                }
                else if (!input_grade_a_students.getText().toString().isEmpty() && !input_grade_b_students.getText().toString().isEmpty() && !input_grade_c_students.getText().toString().isEmpty() && !input_grade_d_students.getText().toString().isEmpty() && !input_grade_f_students.getText().toString().isEmpty() && Pattern.compile("^\\d{1,7}$").matcher(input_grade_a_students.getText().toString()).matches() && Pattern.compile("^\\d{1,7}$").matcher(input_grade_b_students.getText().toString()).matches() && Pattern.compile("^\\d{1,7}$").matcher(input_grade_c_students.getText().toString()).matches() && Pattern.compile("^\\d{1,7}$").matcher(input_grade_d_students.getText().toString()).matches() && Pattern.compile("^\\d{1,7}$").matcher(input_grade_f_students.getText().toString()).matches() && Integer.parseInt(input_grade_a_students.getText().toString()) + Integer.parseInt(input_grade_b_students.getText().toString()) + Integer.parseInt(input_grade_c_students.getText().toString()) + Integer.parseInt(input_grade_d_students.getText().toString()) + Integer.parseInt(input_grade_f_students.getText().toString()) < Integer.parseInt(input_total_number_of_students.getText().toString())) {
                    Toast.makeText(InputData.this, "YOUR DATA IS " + (Integer.parseInt(input_total_number_of_students.getText().toString()) - (Integer.parseInt(input_grade_a_students.getText().toString()) + Integer.parseInt(input_grade_b_students.getText().toString()) + Integer.parseInt(input_grade_c_students.getText().toString()) + Integer.parseInt(input_grade_d_students.getText().toString()) + Integer.parseInt(input_grade_f_students.getText().toString()))) + " LESS THAN YOUR TOTAL!", Toast.LENGTH_LONG).show();
                }
                else if (!input_grade_a_students.getText().toString().isEmpty() && !input_grade_b_students.getText().toString().isEmpty() && !input_grade_c_students.getText().toString().isEmpty() && !input_grade_d_students.getText().toString().isEmpty() && !input_grade_f_students.getText().toString().isEmpty() && Pattern.compile("^\\d{1,7}$").matcher(input_grade_a_students.getText().toString()).matches() && Pattern.compile("^\\d{1,7}$").matcher(input_grade_b_students.getText().toString()).matches() && Pattern.compile("^\\d{1,7}$").matcher(input_grade_c_students.getText().toString()).matches() && Pattern.compile("^\\d{1,7}$").matcher(input_grade_d_students.getText().toString()).matches() && Pattern.compile("^\\d{1,7}$").matcher(input_grade_f_students.getText().toString()).matches() && Integer.parseInt(input_grade_a_students.getText().toString()) + Integer.parseInt(input_grade_b_students.getText().toString()) + Integer.parseInt(input_grade_c_students.getText().toString()) + Integer.parseInt(input_grade_d_students.getText().toString()) + Integer.parseInt(input_grade_f_students.getText().toString()) > Integer.parseInt(input_total_number_of_students.getText().toString())) {
                    Toast.makeText(InputData.this, "YOUR DATA IS " + ((Integer.parseInt(input_grade_a_students.getText().toString()) + Integer.parseInt(input_grade_b_students.getText().toString()) + Integer.parseInt(input_grade_c_students.getText().toString()) + Integer.parseInt(input_grade_d_students.getText().toString()) + Integer.parseInt(input_grade_f_students.getText().toString())) - Integer.parseInt(input_total_number_of_students.getText().toString())) + " MORE THAN YOUR TOTAL!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
