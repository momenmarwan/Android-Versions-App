package com.example.androidversions;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<AndroidVersion> versionList;
    private AndroidVersionAdapter adapter;

    private boolean sortAscending = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        versionList = buildVersionList();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new AndroidVersionAdapter(this, versionList);
        recyclerView.setAdapter(adapter);

        Button btnSort = findViewById(R.id.btn_sort);
        btnSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortByCodeName();
            }
        });
    }

    private List<AndroidVersion> buildVersionList() {
        List<AndroidVersion> list = new ArrayList<>();
        list.add(new AndroidVersion(R.drawable.ic_donut, "Donut", "1.6"));
        list.add(new AndroidVersion(R.drawable.ic_eclair, "Éclair", "2.0 - 2.1"));
        list.add(new AndroidVersion(R.drawable.ic_froyo, "Froyo", "2.2 - 2.2.3"));
        list.add(new AndroidVersion(R.drawable.ic_gingerbread, "Gingerbread", "2.3 - 2.3.7"));
        list.add(new AndroidVersion(R.drawable.ic_honeycomb, "Honeycomb", "3.0 - 3.2.6"));
        list.add(new AndroidVersion(R.drawable.ic_ice_cream_sandwich, "Ice Cream Sandwich", "4.0 - 4.0.4"));
        list.add(new AndroidVersion(R.drawable.ic_jelly_bean, "Jelly Bean", "4.1 - 4.3.1"));
        list.add(new AndroidVersion(R.drawable.ic_kitkat, "KitKat", "4.4 - 4.4.4"));
        list.add(new AndroidVersion(R.drawable.ic_lollipop, "Lollipop", "5.0 - 5.1.1"));
        list.add(new AndroidVersion(R.drawable.ic_marshmallow, "Marshmallow", "6.0 - 6.0.1"));
        list.add(new AndroidVersion(R.drawable.ic_nougat, "Nougat", "7.0 - 7.1.2"));
        list.add(new AndroidVersion(R.drawable.ic_oreo, "Oreo", "8.0 - 8.1"));
        return list;
    }

    private void sortByCodeName() {
        Comparator<AndroidVersion> byCodeName = new Comparator<AndroidVersion>() {
            @Override
            public int compare(AndroidVersion a, AndroidVersion b) {
                return a.getCodeName().compareToIgnoreCase(b.getCodeName());
            }
        };

        Collections.sort(versionList, byCodeName);
        if (!sortAscending) {
            Collections.reverse(versionList);
        }
        sortAscending = !sortAscending;

        adapter.notifyDataSetChanged();
    }
}
