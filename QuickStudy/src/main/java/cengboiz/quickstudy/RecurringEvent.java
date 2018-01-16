/* CENG BOIZ
QuickStudy
Ruel John Cootauco - N01114847
Adam Warrington - N01110575
Raymond Dang - N01048235
*/

package cengboiz.quickstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RecurringEvent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recurring_event);


        CalendarView cv = (CalendarView)findViewById(R.id.calendarView);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat ss = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String currentdate= ss.format(date);
        TextView editText = (TextView) this.findViewById(R.id.tvDate);
        editText.setText(currentdate);
    }
}
