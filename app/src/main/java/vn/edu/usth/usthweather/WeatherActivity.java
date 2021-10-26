package vn.edu.usth.usthweather;

import static vn.edu.usth.usthweather.R.id.action_settings;
import static vn.edu.usth.usthweather.R.id.refresh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final Handler handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                String content = msg.getData().getString("server_response");
                Toast.makeText(getBaseContext(), content, Toast.LENGTH_SHORT).show();
            }
        };

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1311);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Bundle bundle = new Bundle();
                bundle.putString("server_response", "here okay");

                Message message = new Message();
                message.setData(bundle);
                handler.sendMessage(message);
            }
        });

        switch (item.getItemId()) {
            case refresh: {
                return true;
            }

            case action_settings: {
                Intent intent = new Intent(this, PrefActivity.class);
                startActivity(intent);
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
