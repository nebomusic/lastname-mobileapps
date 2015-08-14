package com.marist.michaudc.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Fields
    private EditText editText;
    private TextView textView;
    private Button calculateButton;

    private SeekBar seekBar;
    private TextView textDisplayPercent;
    private EditText editBill;
    private TextView textTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind to XML Objects
        editText = (EditText)findViewById(R.id.editText);
        textView = (TextView)findViewById(R.id.textView);
        calculateButton = (Button)findViewById(R.id.calculateButton);

        // Seek Bar and Tip Conversion Fields to Bind to XML
        seekBar = (SeekBar)findViewById(R.id.seekBar1);
        textDisplayPercent = (TextView)findViewById(R.id.textDisplayPercent);
        editBill = (EditText)findViewById(R.id.editTextBill);
        textTotal = (TextView)findViewById(R.id.textViewTotal);

        // Set Listener for Seek Bar
        seekBar.setOnSeekBarChangeListener(seekBarChangeListenter);

        // Default Values
        editText.setText("10");
        editBill.setText("0.00");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void calculateCtoF(View v) {
        // Get Data from textView
        Editable input = editText.getText();
        // Convert to a String
        String inputString = String.valueOf(input);
        // Convert to a float
        float celsius = Float.valueOf(inputString);

        // Do the Math
        float fah = (float) (celsius*1.8 + 32.00);

        // Convert to String and display
        textView.setText(String.valueOf(fah));
    } // end calculateCtoF20

    private SeekBar.OnSeekBarChangeListener seekBarChangeListenter =
            new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int arg1, boolean fromUser) {
                    int progress = seekBar.getProgress();
                    textDisplayPercent.setText(String.valueOf(progress));

                    Editable eBill = editBill.getText();
                    String sBill = String.valueOf(eBill);
                    float bill = Float.valueOf(sBill);
                    float percent = (float) (progress/100.0);
                    float total = bill + (bill*percent);

                    textTotal.setText(String.valueOf(total));
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            };
}
