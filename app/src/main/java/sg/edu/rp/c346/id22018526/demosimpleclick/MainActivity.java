package sg.edu.rp.c346.id22018526.demosimpleclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Button btnDisplay; //Step 2, creating the object for UI element.
    TextView tvDisplay;
    EditText etinput;
    ToggleButton tbtn;

    RadioGroup rgGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDisplay = findViewById(R.id.displayBtn); //Step 3, Linking UI element with Java elemnt by ID
        tvDisplay = findViewById(R.id.enterDisplay);
        etinput = findViewById(R.id.enterText);
        tbtn = findViewById(R.id.toggleButtonEnabled);
        rgGender = findViewById(R.id.RadioGroupGender);

        etinput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etinput.getText().toString();
            }
        });
        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Text Displayed", Toast.LENGTH_SHORT).show();
                String stringResponse = etinput.getText().toString();
                tvDisplay.setText(stringResponse);

            }
        });
        tbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tbtn.isChecked()) {
                    etinput.setEnabled(true);
                    etinput.setFocusableInTouchMode(true);

                }
                else {
                    etinput.setEnabled(false);
                    etinput.setFocusableInTouchMode(false);

                }
            }
        });
        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringResponse = etinput.getText().toString();
                int checkRadioId = rgGender.getCheckedRadioButtonId();
                if(checkRadioId == R.id.radioButtonMale) {
                   String gender = "He says ";
                   stringResponse = gender + stringResponse;
                }
                else if(checkRadioId == R.id.radioButtonFemale) {
                   String gender = "She says ";
                   stringResponse = gender + stringResponse;

                }
                tvDisplay.setText(stringResponse);

            }
        });

    }
}