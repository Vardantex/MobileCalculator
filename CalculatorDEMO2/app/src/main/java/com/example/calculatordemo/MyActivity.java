package com.example.calculatordemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.TextView;

public class MyActivity extends Activity {

    //DATA MODEL FOR SHIP ITEM
    private ShipItem shipItem;

    //View Objects for layout UI Reference
    private EditText weightET;
    private TextView baseCostTV;
    private TextView addedCostTV;
    private TextView totalCostTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Task 1: SET Activity Content
        super.onCreate(savedInstanceState);
        setContentView((R.layout.activity_my);

        //Task2: Create a data model for sstoring an item to be shipped
        shipItem = new ShipItem();

        //Task3: Establish the references to input weight element
        weightET = (EditText) findViewById(R.id.editText1));

        //Task 4: Establish the references to output elements
        baseCostTV = (TextView) findViewById(R.id.textView4);
        addedCostTV = (TextView) findViewById(R.id.textView6);
        totalCostTV = (TextView) findViewById(R.id.textView8);


        //Task 5: Register the listener event for weight input
        weightET.addTextChangedListener(weightTextWatcher);
    }

    private TextWatcher weightTextWatcher = new TextWatcher() {
        //The Input element is attached to an editable
        //Therefore these methods are called when the text is changed

        public void onTextChanged(CharSequence s, int start, int before, int count) {

            try {
                shipItem.setWeight((int)
                        Double.parseDouble(s.toString()));
            } catch (NumberFormatException e) {
                shipItem.setWeight(0);
            }
            displayShipping();
        }

        public void afterTextChanged(Editable a) {
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        private void displayShipping() {
            //Display the base cost, added cost, and total cost
            baseCostTV.setText("$" + String.format("%.02f",  +
                    shipItem.getBaseCost());

            addedCostTV.setText("$" + String.format("%.02f",
                    shipItem.getAddedCost()));

            totalCostTV.setText("$" + String.format("%.02f",
                    shipItem.getTotalCost()));

        }
    @Override
        public boolean onCreateOptionsMenu(Menu menu) {

            //Inflate the menu
            getMenuInflater().inflate(R.menu.my, menu) ;
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            //Handle action bar item clicks here.

            int id = item.getItemId();
            if (id == R.id.action_settings) {
                return true;
            }
            return super.onOptionsItemSelected(item);
        }
    }
}