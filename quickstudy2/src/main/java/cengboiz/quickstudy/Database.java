/* CENGB BOIZ
QuickStudy
Ruel John Cootauco - N01114847
Adam Warrington - N01110575
Acefiel Eroma - N01101571
*/

package cengboiz.quickstudy;

import android.app.Application;
import com.firebase.client.Firebase;

public class Database extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}
