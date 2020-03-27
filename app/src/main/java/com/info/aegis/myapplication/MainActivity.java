package com.info.aegis.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.info.aegis.myapplication.activity.GetWeChatNotificationActivity;
import com.info.aegis.myapplication.activity.HistogramActivity;
import com.info.aegis.myapplication.adapter.MainActivityRecyclerViewAdapter;
import com.info.aegis.myapplication.model.MainActivityRecyclerViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<MainActivityRecyclerViewModel> mDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.idRecyclerView);

        initData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        MainActivityRecyclerViewAdapter adapter = new MainActivityRecyclerViewAdapter(mDataList);
        mRecyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new MainActivityRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, GetWeChatNotificationActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, HistogramActivity.class));
                        break;
                }
            }
        });
    }

    private void initData() {
        mDataList.add(new MainActivityRecyclerViewModel(getResources().getString(R.string.getNotificationInfo)));
        mDataList.add(new MainActivityRecyclerViewModel(getResources().getString(R.string.histogram)));
    }
}
