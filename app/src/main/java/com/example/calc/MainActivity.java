package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etNum1, etNum2, etOperation;
    TextView tvResultText;

    Button buttonCalculateResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNum1 = findViewById(R.id.num1_edit_text);
        etNum2 = findViewById(R.id.num2_edit_text);
        etOperation = findViewById(R.id.operation_edit_text);
        tvResultText = findViewById(R.id.result_text_view);
        buttonCalculateResult = findViewById(R.id.calculate_result_button);
        buttonCalculateResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        float num1, num2, result = 0;
        boolean correctOperation = true;
        String operation = "";
        operation = etOperation.getText().toString();

        try {
            num1 = Float.parseFloat(etNum1.getText().toString());
            num2 = Float.parseFloat(etNum2.getText().toString());

            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0)
                        throw new ArithmeticException();
                    result = num1 / num2;
                    break;
                default:
                    correctOperation = false;
                    break;
            }
        } catch (ArithmeticException e) {
            tvResultText.setText(R.string.divided_zero);
            return;
        } catch (NullPointerException e) {
            tvResultText.setText(R.string.null_data);
            return;
        } catch (NumberFormatException e) {
            tvResultText.setText(R.string.wrong_format);
            return;
        }
        if(correctOperation){
            tvResultText.setText(num1 + "" + operation + "" + num2 + "=" + result);
        }
        else{
            tvResultText.setText(R.string.wrong_operation);
        }

    }
}
