/* CENG BOIZ
QuickStudy
Ruel John Cootauco - N01114847
Adam Warrington - N01110575
Raymond Dang - N01048235
*/

package cengboiz.quickstudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class PostActivity extends AppCompatActivity {

    private Firebase mSubject;
    private Firebase mName;
    private Firebase mAddtn;
    private Firebase mTime;
    private TextView subjectView;
    private TextView nameView;
    private TextView timeView;
    private TextView addtnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        //Intent intent =  getIntent();
        subjectView = (TextView) findViewById(R.id.subjectInfo);
        nameView = (TextView) findViewById(R.id.nameInfo);
        timeView = (TextView) findViewById(R.id.timeInfo);
        addtnView = (TextView) findViewById(R.id.addtnInfo);

        mSubject = new Firebase("https://quickstudy-8d8ce.firebaseio.com/Entry/Subject");
        mName = new Firebase("https://quickstudy-8d8ce.firebaseio.com/Entry/Name");
        mAddtn = new Firebase("https://quickstudy-8d8ce.firebaseio.com/Entry/Additional Info");
        mTime = new Firebase("https://quickstudy-8d8ce.firebaseio.com/Entry/Time Duration");

        mSubject.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                subjectView.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mName.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                nameView.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mAddtn.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                addtnView.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mTime.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                timeView.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }
}