package com.ucb.bottomnavigationgerolaga;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import java.text.DecimalFormat;

public class CalculatorFragment extends Fragment {

    private EditText number1EditText, number2EditText;
    private TextView resultTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);

        number1EditText = view.findViewById(R.id.number1);
        number2EditText = view.findViewById(R.id.number2);
        resultTextView = view.findViewById(R.id.resultTextView);

        Button addButton = view.findViewById(R.id.addButton);
        addButton.setOnClickListener(v -> calculate('+'));

        return view;
    }

    private void calculate(char operation) {
        String num1String = number1EditText.getText().toString();
        String num2String = number2EditText.getText().toString();

        if (TextUtils.isEmpty(num1String) || TextUtils.isEmpty(num2String)) {
            resultTextView.setText("Please enter both numbers");
            return;
        }

        try {
            double num1 = Double.parseDouble(num1String);
            double num2 = Double.parseDouble(num2String);
            double result;

            if (operation == '+') {
                result = num1 + num2;
            } else {
                result = 0;
            }

            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            resultTextView.setText("Result: " + decimalFormat.format(result));
        } catch (NumberFormatException e) {
            resultTextView.setText("Invalid input");
        }
    }
}
