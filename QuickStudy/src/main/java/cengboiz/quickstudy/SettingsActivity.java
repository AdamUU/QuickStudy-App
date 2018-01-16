/* CENG BOIZ
QuickStudy
Ruel John Cootauco - N01114847
Adam Warrington - N01110575
Raymond Dang - N01048235
*/

package cengboiz.quickstudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {

    Switch langSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Toolbar toolbar = (Toolbar) findViewById(R.id.mToolbar);
        setSupportActionBar(toolbar);


    }
}
