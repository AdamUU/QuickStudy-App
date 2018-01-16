/* CENG BOIZ
QuickStudy
Ruel John Cootauco - N01114847
Adam Warrington - N01110575
Raymond Dang - N01048235
*/
// Team Name: cengboiz
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
                    Intent recurringIntent = new Intent(getApplicationContext(), RecurringEvent.class);
                        startActivity(recurringIntent);
                        break;

                    case(R.id.settings_activity):
                        Intent settingsIntent = new Intent(getApplicationContext(), SettingsActivity.class);
                        startActivity(settingsIntent);
                        break;

                    default:
                        break;
                }
                return true;
            }
        });

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent newActivity = new Intent(getApplicationContext(), CreateActivity.class);
                    startActivity(newActivity);

            }
        });

        findButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent newActivity = new Intent(getApplicationContext(), FindActivity.class);
                    startActivity(newActivity);
            }
        });

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent newActivity = new Intent(getApplicationContext(), MapsActivity.class);
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
        builder.setTitle(R.string.qs_info);
        builder.setMessage(R.string.info_app);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    public void appHelp(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(R.string.app_help);
        builder.setMessage(R.string.help_app);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    public void appContact(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(R.string.app_contact);
        builder.setMessage(R.string.contact_app);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}
