package com.example.TestAndroidApp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MyActivity extends Activity {
    private EditText text;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        text = (EditText) findViewById(R.id.editText1);
    }

//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//    }
//    @Override
//    protected void onPause() {
//    }
//    @Override
//    protected void onResume() {
////        this.getSystemService("213");
//    }

    // This method is called at button click because we assigned the name to the
    // "On Click property" of the button
    public void myClickHandler(View view) {
        switch (view.getId()) {
            case R.id.button1:
                RadioButton celsiusButton = (RadioButton) findViewById(R.id.radio0);
                RadioButton fahrenheitButton = (RadioButton) findViewById(R.id.radio1);
                if (text.getText().length() == 0) {
                    Toast.makeText(this, "Please enter a valid number",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                float inputValue = Float.parseFloat(text.getText().toString());
                if (celsiusButton.isChecked()) {
                    text.setText(String
                            .valueOf(convertFahrenheitToCelsius(inputValue)));
                } else {
                    text.setText(String
                            .valueOf(convertCelsiusToFahrenheit(inputValue)));
                }
                // Switch to the other button
                if (fahrenheitButton.isChecked()) {
                    fahrenheitButton.setChecked(false);
                    celsiusButton.setChecked(true);
                } else {
                    fahrenheitButton.setChecked(true);
                    celsiusButton.setChecked(false);
                }
                break;
        }
    }

    // Converts to celsius
    private float convertFahrenheitToCelsius(float fahrenheit) {
        return ((fahrenheit - 32) * 5 / 9);
    }

    // Converts to fahrenheit
    private float convertCelsiusToFahrenheit(float celsius) {
        return ((celsius * 9) / 5) + 32;
    }



}
