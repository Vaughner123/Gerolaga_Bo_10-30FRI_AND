package com.ucb.calculatorgerolagafinal;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText number1EditText;
    private EditText number2EditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1EditText = findViewById(R.id.number1);
        number2EditText = findViewById(R.id.number2);
        resultTextView = findViewById(R.id.resultTextView);

        Button addButton = findViewById(R.id.addButton);
        Button subtractButton = findViewById(R.id.subtractButton);
        Button multiplyButton = findViewById(R.id.multiplyButton);
        Button divideButton = findViewById(R.id.divideButton);

        addButton.setOnClickListener(v -> calculate('+'));
        subtractButton.setOnClickListener(v -> calculate('-'));
        multiplyButton.setOnClickListener(v -> calculate('*'));
        divideButton.setOnClickListener(v -> calculate('/'));
    }

    private void calculate(char operation) {
        String num1String = number1EditText.getText().toString();
        String num2String = number2EditText.getText().toString();

        if (num1String.isEmpty() || num2String.isEmpty()) {
            resultTextView.setText("Please enter both numbers");
            return;
        }

        try {
            double num1 = Double.parseDouble(num1String);
            double num2 = Double.parseDouble(num2String);
            double result = 0;

            switch (operation) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        resultTextView.setText("Cannot divide by zero");
                        return;
                    }
                    result = num1 / num2;
                    break;
            }

            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            resultTextView.setText("Result: " + decimalFormat.format(result));

        } catch (NumberFormatException e) {
            resultTextView.setText("Invalid input");
        }
    }
}
