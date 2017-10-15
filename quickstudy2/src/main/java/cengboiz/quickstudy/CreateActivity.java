/* CENGB BOIZ
QuickStudy
Ruel John Cootauco - N01114847
Adam Warrington - N01110575
Acefiel Eroma - N01101571
*/

package cengboiz.quickstudy;

import java.util.Calendar;
import java.util.Date;

import android.content.Intent;
import android.text.format.DateFormat;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class CreateActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener{

    ImageButton clock_button;
    TextView clock_result;
    int hour, minutes;
    private static final String TAG = "CreateActivity";
    DatabaseHelper mDatabaseHelper;
    private Button btnPost;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        Toolbar toolbar = (Toolbar) findViewById(R.id.fToolbar);
        setSupportActionBar(toolbar);

        //TimePicker
        clock_button = (ImageButton) findViewById(R.id.clock);
        clock_result = (TextView) findViewById(R.id.clock_result);
        clock_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    TimePickerDialog timePickerDialog = new TimePickerDialog(CreateActivity.this, CreateActivity.this, hour,
                            minutes, DateFormat.is24HourFormat(CreateActivity.this));

                timePickerDialog.show();

            }
        });


        //Database
        editText = (EditText) findViewById(R.id.nameCreate);
        btnPost = (Button) findViewById(R.id.postCreate);
        mDatabaseHelper = new DatabaseHelper(this);

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String entry = editText.getText().toString();
                if(editText.length() !=0) {
                    addData(entry);
                    editText.setText("");
                    toastMessage("Post successfully made");
                    Intent intent = new Intent(CreateActivity.this, FindActivity.class);
                    startActivity(intent);
                }
                else {
                    toastMessage("You must enter something to post!");
                }
            }
        });


    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Date currentTime = Calendar.getInstance().getTime();
        String delegate = "hh:mm aaa";
        String meridiem;

        if(hourOfDay > 11)
            meridiem = "PM";
        else
            meridiem = "AM";

        clock_result.setText(DateFormat.format(delegate, currentTime) + " - " + hourOfDay + ":" + minute + " " + meridiem);
    }

    public void addData(String entry) {
        boolean insertData = mDatabaseHelper.addData(entry);

    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }
}


