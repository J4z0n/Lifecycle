package traf1.hejason.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView local, sharedPrefs;
    SharedPreferences mPreferences;
    SharedPreferences.Editor preferencesEditor;
    String localOutput = "Local", sharedOutput = "";

    String[] methods = {"onCreate", "onStart", "onResume", "onPause", "onStop", "onRestart", "onDestroy"};
    int[] count = new int[7];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        local = findViewById(R.id.local);
        sharedPrefs = findViewById(R.id.sharedPrefs);
        mPreferences = getSharedPreferences("myPref", MODE_PRIVATE);
        preferencesEditor = mPreferences.edit();
        update(0);
    }

    @Override
    protected void onStart() {
        super.onStart();
        update(1);
    }

    @Override
    protected void onResume() {
        super.onResume();
        update(2);
    }

    @Override
    protected void onPause() {
        super.onPause();
        update(3);
    }

    @Override
    protected void onStop() {
        super.onStop();
        update(4);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        update(5);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        update(6);
    }

    public void resetLocal(View view){
        for(int x = 0; x < methods.length; x++)
            count[x] = 0;
        display();
    }

    public void resetAll(View view) {
        resetLocal(view);
        for (String s : methods){
            preferencesEditor.putInt(s, 0);
            preferencesEditor.apply();
        }
        display();
    }

    private void update(int i){
        count[i]++;
        preferencesEditor.putInt(methods[i], mPreferences.getInt(methods[i], -1) + 1);
        preferencesEditor.apply();
        display();
    }

    private void display(){
        localOutput = "Local";
        for(int x = 0; x < count.length; x++)
            localOutput += "\n" + methods[x] + ": " + count[x];
        local.setText(localOutput);
        sharedOutput = "Total";
        for(int x = 0; x < count.length; x++)
            sharedOutput += "\n" + methods[x] + ": " + mPreferences.getInt(methods[x], -1);
        sharedPrefs.setText(sharedOutput);
    }
}
