package com.example.studentgradescalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class DataResult extends AppCompatActivity {
    private BarChart student_grades_chart;
    private BarDataSet student_grades_data_set;
    private Button clear_button, ratio_button;
    private AlertDialog.Builder ratio_dialog;
    private DecimalFormat percent_format, whole_number_format;
    private final String[] grades = new String[]{null, "A", "B", "C", "D", "F"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_result);
        clear_button = findViewById(R.id.clear_button);
        ratio_button = findViewById(R.id.ratio_button);
        student_grades_chart = findViewById(R.id.student_grade_graph);
        //To create formatting rules for outputting ratio results
        percent_format = new DecimalFormat("#.####%");
        whole_number_format = new DecimalFormat("#,###,###");
        //To create a dialog box that will display the calculated ratio results
        ratio_dialog = new AlertDialog.Builder(DataResult.this);
        ratio_dialog.setTitle("STUDENT GRADE RATIOS");
        ratio_dialog.setMessage(getResources().getString(R.string.students_with_grade_a_label) + ": " + percent_format.format(InputData.grade_a_students/InputData.total_number_of_students) + "\n\n" + getResources().getString(R.string.students_with_grade_b_label)  + ": " + percent_format.format(InputData.grade_b_students/InputData.total_number_of_students) + "\n\n" +  getResources().getString(R.string.students_with_grade_c_label)  + ": " + percent_format.format(InputData.grade_c_students/InputData.total_number_of_students) + "\n\n" +  getResources().getString(R.string.students_with_grade_d_label)  + ": " + percent_format.format(InputData.grade_d_students/InputData.total_number_of_students) + "\n\n" + getResources().getString(R.string.students_with_grade_f_label)  + ": " + percent_format.format(InputData.grade_f_students/InputData.total_number_of_students));
        //To create a data set for the new graph which will contain all the users input
        student_grades_data_set = new BarDataSet(new ArrayList<BarEntry>(Arrays.asList(new BarEntry(1, InputData.grade_a_students), new BarEntry(2, InputData.grade_b_students), new BarEntry(3, InputData.grade_c_students), new BarEntry(4, InputData.grade_d_students), new BarEntry(5, InputData.grade_f_students))), "GRADES");
        student_grades_data_set.setColors(ColorTemplate.COLORFUL_COLORS);
        student_grades_data_set.setValueTextColor(Color.BLACK);
        student_grades_data_set.setValueTextSize(11f);
        student_grades_data_set.setValueFormatter(new ValueFormatter() {
            @Override
            public String getBarLabel(BarEntry barEntry) {
                return whole_number_format.format(barEntry.getY());
            }
        });
        //To set up the configuration for the graph itself
        student_grades_chart.setFitBars(true);
        student_grades_chart.setData(new BarData(student_grades_data_set));
        student_grades_chart.getDescription().setText("STUDENT GRADES");
        student_grades_chart.getDescription().setTextSize(15f);
        student_grades_chart.getDescription().setTextColor(Color.BLACK);
        student_grades_chart.getDescription().setPosition(500f, 35f);
        student_grades_chart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(grades));
        student_grades_chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        student_grades_chart.getXAxis().setGranularity(1f);
        student_grades_chart.getXAxis().setGranularityEnabled(true);
        student_grades_chart.getXAxis().setTextColor(Color.BLACK);
        student_grades_chart.getXAxis().setTextSize(15f);
        student_grades_chart.getAxisLeft().setGranularity(1f);
        student_grades_chart.getAxisLeft().setGranularityEnabled(true);
        student_grades_chart.getAxisRight().setGranularity(1f);
        student_grades_chart.getAxisRight().setGranularityEnabled(true);
        student_grades_chart.animateY(2000);
        //This will button will reset all variables and return the user back to the previous activity
        clear_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputData.total_number_of_students = 0;
                InputData.grade_a_students = 0;
                InputData.grade_b_students = 0;
                InputData.grade_c_students = 0;
                InputData.grade_d_students = 0;
                InputData.grade_f_students = 0;
                Intent back_to_student_grade_data_input = new Intent(DataResult.this, InputData.class);
                startActivity(back_to_student_grade_data_input);
                finish();
            }
        });
        //This will button will will make the dialog box appear which will show the ratio results
        ratio_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratio_dialog.create().show();
            }
        });
    }
}