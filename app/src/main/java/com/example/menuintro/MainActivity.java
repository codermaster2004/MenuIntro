package com.example.menuintro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    int[] images = {R.drawable.aaa,R.drawable.bbb,R.drawable.ccc,R.drawable.ddd};
    int status = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this,2, RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);

        ImagesAdapter imagesAdapter = new ImagesAdapter(MainActivity.this,images,status);
        recyclerView.setAdapter(imagesAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
            getMenuInflater().inflate(R.menu.grid2_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()==R.id.gridview)
        {
            status=2;
            GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this,2, RecyclerView.VERTICAL,false);
            recyclerView.setLayoutManager(gridLayoutManager);

            ImagesAdapter imagesAdapter = new ImagesAdapter(MainActivity.this,images,status);
            recyclerView.setAdapter(imagesAdapter);

        }
        else if(item.getItemId()==R.id.listview)
        {
            status=1;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL,false);
            recyclerView.setLayoutManager(linearLayoutManager);

            ImagesAdapter imagesAdapter = new ImagesAdapter(MainActivity.this,images,status);
            recyclerView.setAdapter(imagesAdapter);
        }
        return super.onOptionsItemSelected(item);
    }
}