package ru.vkwebsites.android.simpleweatherapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText city;
    private Button btnShow;
    private Switch isWeatherText, isHumidity;

    public final static String inputCity = "inputCity";
    public final static String swWeatherText = "swWeatherText";
    public final static String swHumidity = "swHumidity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setOnShowClickListener();
    }

    private void initViews() {
        city = findViewById(R.id.city);
        btnShow = findViewById(R.id.btnShow);
        isWeatherText = findViewById(R.id.swWeatherText);
        isHumidity = findViewById(R.id.swHumidity);
    }

    private void setOnShowClickListener() {
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //Toast.makeText(getApplicationContext(), city.getText(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, ResultsActivity.class);
            intent.putExtra(inputCity, city.getText().toString());
            intent.putExtra(swWeatherText, isWeatherText.isChecked());
            intent.putExtra(swHumidity, isHumidity.isChecked());
            startActivity(intent);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("city", city.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        city.setText(savedInstanceState.getString("city", ""));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // можно посмотреть как изменилась конфигурация
        // newConfig.orientation == Configuration.ORIENTATION_PORTRAIT
    }
}
