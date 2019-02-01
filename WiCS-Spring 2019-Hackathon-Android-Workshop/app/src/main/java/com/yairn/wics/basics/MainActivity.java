package com.yairn.wics.basics;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    static final int REQUEST_IMAGE_CAPTURE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        ArrayList<TypeData> container = new ArrayList<>();
        container.add(new TypeData(Type.Browser, "https://www.cs.utexas.edu/~wics/"));
        container.add(new TypeData(Type.Image, "https://images.unsplash.com/photo-1529933037705-0d537317ae7b?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=2524b7a67224f19e9a89dfbd33365c39&dpr=1&auto=format&fit=crop&w=1000&q=80&cs=tinysrgb"));
        container.add(new TypeData(Type.Maps, null));
        container.add(new TypeData(Type.Calc, null));
        container.add(new TypeData(Type.Activity, null));

        setupRecyclerView(container);
    }

    /*
     * The setupRecyclerView method binds the recyclerView to the code, and sets up the recyclerView
     * to have an adapter and the number of items in the adapter.
     */
    private void setupRecyclerView(ArrayList<TypeData> container) {
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

        CardAdapter adapter = new CardAdapter(container);
        recyclerView.setAdapter(adapter);
    }

    /*
     * This is where the all the logic for clicking the button goes.
     *
     * In the method onClickBrowser, an Intent is made to start the Browser app.
     * If the device does not have a Browser app, a message (Toast) will be displayed.
     */
    public void onClickFloatingActionButton(View view) {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
            }
        } catch (Exception e) {
            Toast.makeText(this, "No Camera App Found.", Toast.LENGTH_LONG).show();
        }
    }


}
