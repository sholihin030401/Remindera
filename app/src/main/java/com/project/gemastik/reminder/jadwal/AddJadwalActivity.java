package com.project.gemastik.reminder.jadwal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.kunzisoft.switchdatetime.SwitchDateTimeDialogFragment;
import com.project.gemastik.reminder.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class AddJadwalActivity extends AppCompatActivity {

    EditText nama_agenda;
    ImageButton btn_time;
    TextView tx_time;
    SwitchDateTimeDialogFragment dateTimeDialogFragment;

    private static final String TAG_DATETIME = "TAG_DATETIME";
    private static final String TAG = "DateTimePicker";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_jadwal);

        tx_time = findViewById(R.id.mulai_agenda);
        btn_time = findViewById(R.id.btn_mulai_agenda);

        dateTimePicker();

        btn_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateTimeDialogFragment.startAtCalendarView();
                dateTimeDialogFragment.show(getSupportFragmentManager(),TAG_DATETIME);
            }
        });
  }

    private void dateTimePicker(){
        dateTimeDialogFragment = (SwitchDateTimeDialogFragment) getSupportFragmentManager().findFragmentByTag(TAG_DATETIME);
        if (dateTimeDialogFragment == null){
            dateTimeDialogFragment = SwitchDateTimeDialogFragment.newInstance(
                    getString(R.string.mulai_agenda),
                    getString(android.R.string.ok),
                    getString(android.R.string.cancel)
            );
        }

        dateTimeDialogFragment.setTimeZone(TimeZone.getDefault());

        final SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyyy HH:mm", java.util.Locale.getDefault());
        dateTimeDialogFragment.setHighlightAMPMSelection(false);
        dateTimeDialogFragment.set24HoursMode(true);
        dateTimeDialogFragment.setMinimumDateTime(new GregorianCalendar(2016, Calendar.JANUARY,1).getTime());
        dateTimeDialogFragment.setMaximumDateTime(new GregorianCalendar(2045, Calendar.DECEMBER,31).getTime());

        try {
            dateTimeDialogFragment.setSimpleDateMonthAndDayFormat(new SimpleDateFormat("dd MMM", Locale.getDefault()));
        } catch (SwitchDateTimeDialogFragment.SimpleDateMonthAndDayFormatException e){
            Log.e(TAG, e.getMessage());
        }

        dateTimeDialogFragment.setOnButtonClickListener(new SwitchDateTimeDialogFragment.OnButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Date date) {
                tx_time.setText(dateFormat.format(date));
            }

            @Override
            public void onNegativeButtonClick(Date date) {

            }
        });
    }


}
