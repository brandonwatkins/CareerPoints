package edu.mhu.cs.brandonwatkins.careerpoints;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        cpData data = (cpData) getIntent().getSerializableExtra(MainActivity.CP_DATA);
        TextView txtGames = (TextView) findViewById(R.id.txtGames);
        TextView txtAVGs = (TextView) findViewById(R.id.txtAVGs);

        String neededGames = data.displayGames();
        String neededPointsAVG = data.calcAvgPointsNeeded();

        txtGames.setText(neededGames);
        txtAVGs.setText(neededPointsAVG);

    }
}
