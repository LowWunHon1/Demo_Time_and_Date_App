package sg.edu.rp.c346.id21012050.demotimeanddateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;
    TextView tvDisplay;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnDisplayDate = findViewById(R.id.buttonDisplayDate);
        btnDisplayTime = findViewById(R.id.buttonDisplayTime);
        tvDisplay = findViewById(R.id.textViewDisplay);
        btnReset = findViewById(R.id.buttonReset);

        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              int h = tp.getCurrentHour();
              int m = tp.getCurrentMinute();

              if (m < 10) {
                  String message = "Time is " + h + ": 0" + m;
                  tvDisplay.setText(message);
              } else {
                  String message = "Time is " + h + ":" + m;
                  tvDisplay.setText(message);
              }


            }
        });

        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int d = dp.getDayOfMonth();
                int m = dp.getMonth();
                int y = dp.getYear();
                int m2 = m + 1;
                String message = "Date is " + d + "/" + m2 + "/" + y;
                tvDisplay.setText(message);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dp.updateDate(2020, 0, 1);
                tp.setCurrentHour(00);
                tp.setCurrentMinute(00);
            }
        });

    }
}