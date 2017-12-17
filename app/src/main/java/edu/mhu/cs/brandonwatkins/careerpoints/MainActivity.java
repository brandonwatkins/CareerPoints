package edu.mhu.cs.brandonwatkins.careerpoints;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.io.Serializable;

import static android.R.attr.data;
import static edu.mhu.cs.brandonwatkins.careerpoints.R.id.currentPoints;
import static edu.mhu.cs.brandonwatkins.careerpoints.R.id.txtViewCurrentPoints;

public class MainActivity extends AppCompatActivity {

    public final static String CP_DATA = "edu.mhu.cs.brandonwatkins.CP_DATA";
    public final static String CURR_POINTS = "edu.mhu.cs.brandonwatkins.CURR_POINTS";
    public final static String DES_POINTS = "edu.mhu.cs.brandonwatkins.DES_POINTS";
    public final static String MIN_GAMES = "edu.mhu.cs.brandonwatkins.MIN_GAMES";
    public final static String MAX_GAMES = "edu.mhu.cs.brandonwatkins.MAX_GAMES";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    /*
    @Override
    protected void OnResume() {
        super.onResume();
        Log.d("Career Points", "In onResume()");

        EditText txtCurrentPoints = (EditText) findViewById(R.id.currentPoints);
        EditText txtDesiredPoints = (EditText) findViewById(R.id.desiredPoints);
        EditText txtMinGames = (EditText) findViewById(R.id.minGames);
        EditText txtMaxGames = (EditText) findViewById(R.id.maxGames);

        data = new cpData();

        SharedPreferences settings = getSharedPreferences(CP_DATA, 0);

        data.setCurrentPoints(settings.getInt(CURR_POINTS, 0));
        data.setDesiredPoints(settings.getInt(DES_POINTS, 0));
        data.setMinGames(settings.getInt(MIN_GAMES, 0));
        data.setMaxGames(settings.getInt(MAX_GAMES, 0));

        if (data.getCurrentPoints() != 0){
            txtCurrentPoints.setText(String.valueOf(data.getCurrentPoints()));
        }

        if (data.getDesiredPoints() != 0){
            txtCurrentPoints.setText(String.valueOf(data.getDesiredPoints()));
        }

        if (data.getMinGames() != 0){
            txtCurrentPoints.setText(String.valueOf(data.getMinGames()));
        }

        if (data.getMaxGames() != 0){
            txtCurrentPoints.setText(String.valueOf(data.getMaxGames()));
        }


    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Career Points", "In onPause()");

        SharedPreferences settings = getSharedPreferences(CP_DATA, 0);
        SharedPreferences.Editor editor = settings.edit();

        editor.putInt(CURR_POINTS, data.getCurrentPoints);
        editor.putInt(DES_POINTS, data.getDesiredPoints);
        editor.putInt(MIN_GAMES, data.getMinGames);
        editor.putInt(MAX_GAMES, data.getMaxGames);

        editor.commit();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Career Points", "In onDestroy()");

    }
    */
    public void calculateBtn(View view) {
        Intent i = new Intent(this, ResultsActivity.class);

        EditText txtCurrentPoints = (EditText) findViewById(R.id.currentPoints);
        EditText txtDesiredPoints = (EditText) findViewById(R.id.desiredPoints);
        EditText txtMinGames = (EditText) findViewById(R.id.minGames);
        EditText txtMaxGames = (EditText) findViewById(R.id.maxGames);

        if (txtCurrentPoints.getText().toString().length() == 0) {
            txtCurrentPoints.setError("Current Points cannot be blank");
            return;
        }

        if (txtDesiredPoints.getText().toString().length() == 0) {
            txtDesiredPoints.setError("Desired Points cannot be blank");
            return;
        }

        if (txtMinGames.getText().toString().length() == 0) {
            txtMinGames.setError("Minimum Games cannot be blank");
            return;
        }

        if (txtMaxGames.getText().toString().length() == 0) {
            txtMaxGames.setError("Maximum Games cannot be blank");
            return;
        }

        int currentPoints = Integer.parseInt(txtCurrentPoints.getText().toString());
        int desiredPoints = Integer.parseInt(txtDesiredPoints.getText().toString());
        int minGames = Integer.parseInt(txtMinGames.getText().toString());
        int maxGames = Integer.parseInt(txtMaxGames.getText().toString());

        if (currentPoints < 1) {
            Toast.makeText(this, "Current Points must be greater than 0", Toast.LENGTH_LONG).show();
            return;
        }

        if (desiredPoints < currentPoints){
            Toast.makeText(this, "Desired Points must be greater than Current Points", Toast.LENGTH_LONG).show();
            return;
        }

        if (minGames < 1) {
            Toast.makeText(this, "Min Games must be greater than 0", Toast.LENGTH_LONG).show();
            return;
        }

        if (maxGames < 1) {
            Toast.makeText(this, "Max Games must be greater than 0", Toast.LENGTH_LONG).show();
            return;
        }

        if (minGames > maxGames){
            Toast.makeText(this, "Max Games must be greater than Min Games", Toast.LENGTH_LONG).show();
            return;
        }

        cpData data = new cpData(currentPoints, desiredPoints, minGames, maxGames);

        i.putExtra(CP_DATA, data);

        startActivity(i);

    }
}
