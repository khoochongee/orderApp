package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {
    int quantity=1;
    int basePrice=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDecrease= findViewById(R.id.decrease);
        Button btnIncrease= findViewById(R.id.increase);
        final TextView totalQuantity= findViewById(R.id.quantity);
        totalQuantity.setText(Integer.toString(quantity));
        final CheckBox checkboxCream= findViewById(R.id.checkbox_cream);
        final CheckBox checkboxChip= findViewById(R.id.checkbox_chip);
        final CheckBox checkboxVanilla= findViewById(R.id.checkbox_vanilla);
        final TextView totalAmount=findViewById(R.id.amount);
        Button btnOrder=findViewById(R.id.order);

        btnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quantity>0){
                    quantity--;
                }
                totalQuantity.setText(Integer.toString(quantity));
            }
        });

        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity++;
                totalQuantity.setText(Integer.toString(quantity));
            }
        });
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double finalPrice=basePrice;
                TextView thankyou=findViewById(R.id.thank_you);

                if(checkboxCream.isChecked()){
                    finalPrice+=1;
                }
                if(checkboxChip.isChecked()){
                    finalPrice+=2;
                }
                if(checkboxVanilla.isChecked()){
                    finalPrice+=3;
                }

                finalPrice*=quantity;

                totalAmount.setText("Amount: $"+finalPrice);

                Log.d("Final Price: ",Double.toString(finalPrice));
                thankyou.setText("Thank You For Your Order. \n The total price is $"+finalPrice);
            }
        });
    }

    /*public void order (View view){
        TextView totalAmount=findViewById(R.id.amount);
        double amount=quantity*basePrice;
        totalAmount.setText("Amount: "+amount);

    }*/


}
