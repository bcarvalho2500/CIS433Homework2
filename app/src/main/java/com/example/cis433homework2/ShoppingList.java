package com.example.cis433homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShoppingList extends AppCompatActivity {

    private ArrayList<String> shoppingList = new ArrayList<>(15);
    private ArrayList<TextView> listView = new ArrayList<TextView>(15);
    private EditText deleteIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        listView.add(findViewById(R.id.item_1));
        listView.add(findViewById(R.id.item_2));
        listView.add(findViewById(R.id.item_3));
        listView.add(findViewById(R.id.item_4));
        listView.add(findViewById(R.id.item_5));
        listView.add(findViewById(R.id.item_6));
        listView.add(findViewById(R.id.item_7));
        listView.add(findViewById(R.id.item_8));
        listView.add(findViewById(R.id.item_9));
        listView.add(findViewById(R.id.item_10));
        listView.add(findViewById(R.id.item_11));
        listView.add(findViewById(R.id.item_12));
        listView.add(findViewById(R.id.item_13));
        listView.add(findViewById(R.id.item_14));
        listView.add(findViewById(R.id.item_15));

        deleteIndex = findViewById(R.id.indexToDelete);

        Intent intent = getIntent();
        shoppingList = intent.getStringArrayListExtra("ShoppingList");
        renderShoppingList();
    }
    private void renderShoppingList(){
        for (int i = 0; i < listView.size(); i++){
            listView.get(i).setText("");
        }
        for (int i = 0; i < shoppingList.size(); i++){
            listView.get(i).setText(getString(R.string.list_item, i + 1, shoppingList.get(i)));
        }
        System.out.println(shoppingList);
    }
    public void onDeleteAllClick(View view){
        shoppingList.clear();
        renderShoppingList();
    }

    public void onDeleteSpecificItem(View view){
        int index = Integer.parseInt(deleteIndex.getText().toString());
        if (index > shoppingList.size()){
            Toast.makeText(this, "Not a valid index", Toast.LENGTH_SHORT).show();
            return;
        }
        shoppingList.remove(index - 1);
        deleteIndex.setText("");
        renderShoppingList();
    }

    public void onAddMoreItemsClick(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putStringArrayListExtra("ShoppingList", shoppingList);
        startActivity(intent);
    }
}