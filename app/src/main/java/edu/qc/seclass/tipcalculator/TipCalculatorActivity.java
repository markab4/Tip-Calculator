package edu.qc.seclass.tipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    EditText checkAmount;
    EditText partySize;
    Button computeTip;
    TextView tip15;
    TextView tip20;
    TextView tip25;
    TextView total15;
    TextView total20;
    TextView total25;
    double money;
    int people;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkAmount = findViewById(R.id.checkAmountValue);
        partySize = findViewById(R.id.partySizeValue);
        computeTip = findViewById(R.id.buttonCompute);
        computeTip.setOnClickListener(this);
        tip15 = findViewById(R.id.fifteenPerceptTipValue);
        tip20 = findViewById(R.id.twentyPercentTipValue);
        tip25 = findViewById(R.id.twentyfivePercentTipValue);
        total15 = findViewById(R.id.fifteenPercentTotalValue);
        total20 = findViewById(R.id.twentyPercentTotalValue);
        total25 = findViewById(R.id.twentyfivePercentTotalValue);
    }


    @Override
    public void onClick(View v) {
        try {
        money = Double.parseDouble(checkAmount.getText().toString());
        people = Integer.parseInt(partySize.getText().toString());
        updateAmount(money/people, 0.15, tip15, total15);
        updateAmount(money/people, 0.2, tip20, total20);
        updateAmount(money/people, 0.25, tip25, total25);
        } catch(Exception e) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Empty or incorrect value(s)!",
                    Toast.LENGTH_SHORT);

            toast.show();
        }
    }

    private void updateAmount(double money, double percent, TextView tip, TextView total){
        long amount = Math.round(percent * money);
        money = Math.round(money);
        tip.setText(String.format("$%s", amount));
        total.setText(String.format("$%s", amount + (long)money));
    }
}
