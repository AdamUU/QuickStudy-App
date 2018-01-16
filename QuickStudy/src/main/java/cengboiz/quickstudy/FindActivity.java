/* CENG BOIZ
QuickStudy
Ruel John Cootauco - N01114847
Adam Warrington - N01110575
Raymond Dang - N01048235
*/
// Team Name: cengboiz
package cengboiz.quickstudy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import java.util.ArrayList;


public class FindActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private Firebase mRef;
    private ListView mListView;
    private ArrayList<String> mPosts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        Toolbar toolbar = (Toolbar) findViewById(R.id.fToolbar);
        setSupportActionBar(toolbar);

        mRef = new Firebase("https://quickstudy-8d8ce.firebaseio.com/Entry");

        mListView = (ListView) findViewById(R.id.postView);
        mListView.setOnItemClickListener(this);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mPosts);
        mListView.setAdapter(arrayAdapter);


        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value = dataSnapshot.getValue(String.class);
                String key = dataSnapshot.getKey();

                if(key == "Name")
                    mPosts.add(value);


                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.find_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.app_filter:
                break;
            case R.id.app_google:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(FindActivity.this, PostActivity.class);
        startActivity(intent);

    }

    @Override
    public void onBackPressed() {
        Intent newActivity = new Intent(FindActivity.this, MainActivity.class);
        startActivity(newActivity);
    }
}
