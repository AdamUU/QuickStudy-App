/* CENG BOIZ
QuickStudy
Ruel John Cootauco - N01114847
Adam Warrington - N01110575
Raymond Dang - N01048235
*/

package cengboiz.quickstudy;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

    ImageButton createButton, findButton, mapButton;
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        createButton = (ImageButton) findViewById(R.id.createsession);
        createButton.setBackgroundDrawable(null);
        findButton = (ImageButton) findViewById(R.id.findsession);
        findButton.setBackgroundDrawable(null);
        mapButton = (ImageButton) findViewById(R.id.gmaps);
        mapButton.setBackgroundDrawable(null);

        NavigationView nv = (NavigationView)findViewById(R.id.mainNav);

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case(R.id.create_recurring):
                    Intent recurringIntent = new Intent(getApplicationContext(),RecurringEvent.class);
                        startActivity(recurringIntent);
                    default:
                        break;
                }
                return true;
            }
        });

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent newActivity = new Intent(MainActivity.this, CreateActivity.class);
                    startActivity(newActivity);



            }
        });

        findButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent newActivity = new Intent(MainActivity.this, FindActivity.class);
                    startActivity(newActivity);
            }
        });

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent newActivity = new Intent(MainActivity.this, MapsActivity.class);
                    startActivity(newActivity);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }

        switch(item.getItemId()) {
            case R.id.app_info:
                appInfo();
                break;
            case R.id.app_contact:
                appContact();
                break;
            case R.id.app_help:
                appHelp();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void appInfo(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("QuickStudy Information");
        builder.setMessage("QuickStudy is an educational android app for students who are in search, or in aid of providing study sessions.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    public void appHelp(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Help");
        builder.setMessage("Q. How do I use this?\nA. There are two ways - you can create a session for people to come to you, or find one through the lists of hosts.\n\nQ. Do I need to pay?\nA. No.\n\nQ. Can I find any session anywhere?\nA. The app has a 0.5km radius to track other sessions.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    public void appContact(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Contact Us");
        builder.setMessage("Adam Warrington - adamW@quickstudy.ca\nRuel John Cootauco - rueljC@quickstudy.ca\nRaymond Dang - raymondD@quickstudy.ca\n\nFor more inquiries, please visit our website quickstudy.ca");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
    @Override
    public void onBackPressed() {

    }
}
