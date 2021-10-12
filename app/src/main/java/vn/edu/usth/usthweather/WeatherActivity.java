package vn.edu.usth.usthweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import android.util.Log;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import android.media.MediaPlayer;

public class WeatherActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Log.i("here", "create");
//
//
//        ForecastFragment ff = new ForecastFragment();
//        WeatherFragment wf = new WeatherFragment();
//        if (ff == null) {
//            getSupportFragmentManager().beginTransaction().add(R.id.forecastFragment, ff, null).commit();
//        }
//        if (wf == null) {
//            getSupportFragmentManager().beginTransaction().add(R.id.weatherFragment, wf, null).commit();
//        }

        TabLayout tabLayout = findViewById(R.id.tabs_layout);
        ViewPager2 viewPager = findViewById(R.id.view_pager);

        WeatherFragmentAdapter weatherFragmentAdapter = new WeatherFragmentAdapter(this);
        viewPager.setAdapter(weatherFragmentAdapter);
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Home");
                    break;
                case 1:
                    tab.setText("Another Home");
                    break;
                case 2:
                    tab.setText("Home Again");
                    break;
            }
        }).attach();

        MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.intro);
        mediaPlayer.start();

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