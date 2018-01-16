<<<<<<< HEAD
package cengboiz.quickstudy;
// Team Name: cengboiz
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RecurringEvent extends AppCompatActivity {

=======
/* CENG BOIZ
QuickStudy
Ruel John Cootauco - N01114847
Adam Warrington - N01110575
Raymond Dang - N01048235
*/

package cengboiz.quickstudy;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
public class RecurringEvent extends AppCompatActivity {

    private CalendarView mCalendarView;

>>>>>>> Ruel
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recurring_event);
<<<<<<< HEAD
=======

        mCalendarView = (CalendarView) findViewById(R.id.createView);

        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = (month + 1 + "/" + dayOfMonth + "/" + year);

                Intent newActivity = new Intent(getApplicationContext(), CreateRecurringActivity.class);
                newActivity.putExtra("date", date);
                startActivity(newActivity);
            }
        });
>>>>>>> Ruel
    }
}
