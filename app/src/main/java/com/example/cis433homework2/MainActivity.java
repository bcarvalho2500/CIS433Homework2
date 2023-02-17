package com.example.cis433homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText addItemField;
    private ArrayList<String> shoppingList = new ArrayList<>(15);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        ArrayList<String> tempShoppingList = intent.getStringArrayListExtra("ShoppingList");
        if (tempShoppingList != null){
            shoppingList = tempShoppingList;
        }

        addItemField = findViewById(R.id.addItem);
    }

    private boolean checkListFull(){
        if (shoppingList.size() == 15){
            Toast.makeText(this, "Your shopping list is full", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
    private boolean checkItemExists(String item){
        if (shoppingList.contains(item)){
            Toast.makeText(this, item + " is already in your list", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
    public void onAddItemClick(View view) {
        try{
            if (checkListFull()) return;
            if (checkItemExists(addItemField.getText().toString())) return;
            shoppingList.add(String.valueOf(addItemField.getText()));
            Toast.makeText(this, addItemField.getText() + " has been successfully added", Toast.LENGTH_SHORT).show();
            addItemField.setText("");
            System.out.println(shoppingList);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void onFrequentItemClick(View view){
        try{
            Button buttonView = findViewById(view.getId());
            if (checkListFull()) return;
            if (checkItemExists(buttonView.getText().toString())) return;
            shoppingList.add(String.valueOf(buttonView.getText()));
            Toast.makeText(this, buttonView.getText() + " has been successfully added", Toast.LENGTH_SHORT).show();
            System.out.println(shoppingList);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void onShowListClick(View view){
        Intent intent = new Intent(this, ShoppingList.class);
        intent.putStringArrayListExtra("ShoppingList", shoppingList);
        startActivity(intent);
    }
}