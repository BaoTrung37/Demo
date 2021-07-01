package com.example.appcuatrung;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private ImageButton imbtSave;
    private Button btTune;
    private TextView tvTime, tvDate, tvTag, tvWeeks;
    private TimePicker timePicker;
    private ArrayList<String> list;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        convertView();

        tvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                displayAlertDialogTime();
                displayDialogTime();
            }
        });
        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayDialogDate();
            }
        });
        imbtSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getBaseContext(), v);
                MenuInflater inflater = popupMenu.getMenuInflater();
                inflater.inflate(R.menu.menu_save, popupMenu.getMenu());
                popupMenu.show();
            }
        });
        tvTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTag();
            }
        });
        tvWeeks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayWeeks();
            }
        });
        btTune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu menu = new PopupMenu(getBaseContext(), v);
                MenuInflater menuInflater = menu.getMenuInflater();
                menuInflater.inflate(R.menu.menu_tune, menu.getMenu());
                menu.show();

                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu_tune_fromfile:
                                break;
                            case R.id.menu_tune_fromdefaults:
                                displayMenuDefaults();
                                break;

                        }
                        return true;
                    }
                });
            }
        });

        AdapterType adapterType = new AdapterType(list);
        spinner.setAdapter(adapterType);
    }

    private void displayMenuDefaults() {
        String[] defaults = {"Nexus Tune","Winphone Tune","Peep Tune","Nokia Tune","Etc"};
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Choose tag:")
                .setSingleChoiceItems(defaults, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create();
        dialog.show();
    }

    private void displayWeeks() {
        String[] weeks = {"Monday", "Tuesday", "Wednesday", "Thusday",
                "Friday", "Saturday", "Sunday"};
        boolean[] booleans = {false, false, false, false, false, false, false};
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Choose tags:")
                .setMultiChoiceItems(weeks, booleans, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        booleans[which] = isChecked;
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ArrayList<String> list = new ArrayList<>();
                        for (int i = 0; i < weeks.length; i++) {
                            if (booleans[i]) {
                                list.add(weeks[i]);
                            }
                        }
                        String s = "";
                        for (int i = 0; i < list.size(); i++) {
                            s += list.get(i);
                            if (i + 1 < list.size()) s += ", ";
                        }
                        tvWeeks.setText(s);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create();
        dialog.show();
    }

    private void displayTag() {
        String[] tags = {"Family", "Game", "Android", "VTC", "Friend"};
        boolean[] booleans = {false, false, false, false, false};
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Choose tags:")
                .setMultiChoiceItems(tags, booleans, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        booleans[which] = isChecked;
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ArrayList<String> list = new ArrayList<>();
                        for (int i = 0; i < tags.length; i++) {
                            if (booleans[i]) {
                                list.add(tags[i]);
                            }
                        }
                        String s = "";
                        for (int i = 0; i < list.size(); i++) {
                            s += list.get(i);
                            if (i + 1 < list.size()) s += ", ";
                        }
                        tvTag.setText(s);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create();
        dialog.show();
    }

    private void displayDialogDate() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                tvDate.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, year, month, day);
        datePickerDialog.show();
    }

    private void displayDialogTime() {
        Calendar calendar = Calendar.getInstance();
        int gio = calendar.get(Calendar.HOUR);
        int phut = calendar.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                calendar.set(0, 0, 0, hourOfDay, minute);
                tvTime.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, gio, phut, true);
        timePickerDialog.show();
    }

//    private void displayAlertDialogTime() {
//        LayoutInflater layoutInflater = getLayoutInflater();
//        View view = layoutInflater.inflate(R.layout.dailog_time,null);
//
//        AlertDialog.Builder alert = new AlertDialog.Builder(this);
//        alert.setTitle("Time Picker Dialog");
//        alert.setView(view);
//        AlertDialog dialog = alert.create();
//        dialog.show();
//    }

    private void convertView() {
        imbtSave = findViewById(R.id.imbt_save);
        btTune = findViewById(R.id.bt_tune);
        tvTime = findViewById(R.id.text_time);
        tvDate = findViewById(R.id.text_date);
        tvTag = findViewById(R.id.text_item_tags);
        tvWeeks = findViewById(R.id.text_item_weeks);
        timePicker = findViewById(R.id.timepicker);
        spinner = findViewById(R.id.spinnerType);

        list = new ArrayList<>();
        list.add("Word");
        list.add("Friend");
        list.add("Family");
    }

}