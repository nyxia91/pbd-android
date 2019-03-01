package com.daraa.androidwarner;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AlarmActivity extends AppCompatActivity {

    TimePicker timePicker;
    TextView textView;
    EditText txtTime;
    Button btnTimePicker;
    Button btnCancelAlarm;

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    int mHour, mMin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        textView = findViewById(R.id.time_set);
        btnTimePicker = findViewById(R.id.setAlarm_btn);
        txtTime = findViewById(R.id.in_time);

        btnTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get Current Time
                final Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int min = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(AlarmActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                txtTime.setText(hourOfDay+":"+minute);
                            }
                        }, hour, min, false);
                timePickerDialog.show();
            }
        });

        btnCancelAlarm = findViewById(R.id.cancel_alarm);
        btnCancelAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAlarm();
            }
        });

        // Using Time picker
//        timePicker = (TimePicker) findViewById(R.id.timePicker);
//        textView = (TextView) findViewById(R.id.text_alarm);
//
//        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
//            @Override
//            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
//
//                mHour = hourOfDay;
//                mMin = minute;
//                textView.setText(textView.getText().toString()
//                        + " " + mHour + ":" + mMin);
//
//            }
//        });

        // Nyoba nyoba
//        final Calendar myCalendar = Calendar.getInstance();
//
//        final EditText edittext= (EditText) findViewById(R.id.Birthday);
//        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
//
//            @Override
//            public void onDateSet(DatePicker view, int year, int monthOfYear,
//                                  int dayOfMonth) {

//                myCalendar.set(Calendar.YEAR, year);
//                myCalendar.set(Calendar.MONTH, monthOfYear);
//                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//
//                String myFormat = "MM/dd/yy"; //In which you need put here
//                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
//
//                edittext.setText(sdf.format(myCalendar.getTime()));
//            }
//
//        };
//
//        edittext.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {

//                new DatePickerDialog(AlarmActivity.this, date, myCalendar
//                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
//                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
//            }
//        });
    }




//    public void setTimer(View v) {
//        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//
//        Date date = new Date();
//
//        Calendar cal_alarm = Calendar.getInstance();
//        Calendar cal_now = Calendar.getInstance();
//
//        cal_now.setTime(date);
//        cal_alarm.setTime(date);
//
//        cal_alarm.set(Calendar.HOUR_OF_DAY,mHour);
//        cal_alarm.set(Calendar.MINUTE,mMin);
//        cal_alarm.set(Calendar.SECOND, 0);
//
////        Log.d(LOG_TAG, cal_alarm);
////        Log.d(LOG_TAG, "CURRENT TIME= "+cal_now);
//
//        if (cal_alarm.before(cal_now)) {
//            Log.d(LOG_TAG, "mASUK SINI NGGA");
//            cal_alarm.add(Calendar.DATE, 1);
//        }
//
//        Intent intent = new Intent(AlarmActivity.this, AlarmBroadcastReceiver.class);
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(AlarmActivity.this, 24444, intent, 0);
//        alarmManager.set(AlarmManager.RTC_WAKEUP, cal_alarm.getTimeInMillis(), pendingIntent);
//    }
}