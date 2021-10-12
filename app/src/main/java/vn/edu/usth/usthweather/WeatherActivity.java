package vn.edu.usth.usthweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;

public class WeatherActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Log.i("here", "create");


        ForecastFragment ff = new ForecastFragment();
        WeatherFragment wf = new WeatherFragment();
        if (ff == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.forecastFragment, ff, null).commit();
        }
        if (wf == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.weatherFragment, wf, null).commit();
        }



    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Weather", "onStart() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Weather", "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Weather", "onDestroy() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Weather", "onPause() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Weather", "onResume() called");
    }
}