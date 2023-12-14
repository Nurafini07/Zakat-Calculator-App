package com.example.myzakatcalculator;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Calculation extends AppCompatActivity {

    private EditText weightEditText, typeEditText, valueEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);

        Toolbar calculationToolbar = findViewById(R.id.calculation_toolbar);
        setSupportActionBar(calculationToolbar);
        getSupportActionBar().setTitle("My Calculator");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        weightEditText = findViewById(R.id.editTextWeight);
        typeEditText = findViewById(R.id.editTextType);
        valueEditText = findViewById(R.id.editTextValue);
        resultTextView = findViewById(R.id.textViewResult);

        Button calculateButton = findViewById(R.id.buttonCalculate);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateZakat();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void calculateZakat() {
        try {
            // Your existing calculation logic
            String type = typeEditText.getText().toString().trim().toLowerCase();
            String weightStr = weightEditText.getText().toString().trim();
            String valueStr = valueEditText.getText().toString().trim();

            // Check if any of the required fields is empty
            if (type.isEmpty() || weightStr.isEmpty() || valueStr.isEmpty()) {
                resultTextView.setText("Please enter all required data.");
                return;
            }

            // Parse input values
            double weight = Double.parseDouble(weightStr);
            double value = Double.parseDouble(valueStr);

            // Continue with Zakat calculation
            double x = (type.equals("keep")) ? 85 : 200;
            double goldValue = weight * value;
            double zakatPayable = Math.max(weight - x, 0) * value;
            double totalZakat = zakatPayable * 0.025;

            // Display the result
            String result = String.format("Value of Gold: RM%.2f\n" +
                            "Zakat Payable: RM%.2f\n" +
                            "Total Zakat: RM%.2f",
                    goldValue, zakatPayable, totalZakat);

            resultTextView.setText(result);
        } catch (NumberFormatException e) {
            resultTextView.setText("Invalid input. Please enter valid numbers.");
        }
    }
}
