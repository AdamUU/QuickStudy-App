/* CENGB BOIZ
QuickStudy
Ruel John Cootauco - N01114847
Adam Warrington - N01110575
Acefiel Eroma - N01101571
*/

package cengboiz.quickstudy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;

public class PostActivity extends AppCompatActivity {

    private DatabaseReference mDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        Intent intent =  getIntent();
        String val = intent.getStringExtra("detail");

        TextView tv = (TextView) findViewById(R.id.subjectInfo);
        tv.setText(val);

    }
}