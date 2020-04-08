package com.info.aegis.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.info.aegis.myapplication.activity.utils.GetWeChatNotificationActivity;
import com.info.aegis.myapplication.activity.view.CanvasOrderActivity_5;
import com.info.aegis.myapplication.activity.view.ClipMatrixActivity_4;
import com.info.aegis.myapplication.activity.view.DrawingBasicActivity_1;
import com.info.aegis.myapplication.activity.view.PaintUsageActivity_2;
import com.info.aegis.myapplication.activity.view.TextPaintActivity_3;
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
                        startActivity(new Intent(MainActivity.this, DrawingBasicActivity_1.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, PaintUsageActivity_2.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, TextPaintActivity_3.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this, ClipMatrixActivity_4.class));
                        break;
                    case 5:
                        startActivity(new Intent(MainActivity.this, CanvasOrderActivity_5.class));
                        break;
                }
            }
        });
    }

    private void initData() {
        mDataList.add(new MainActivityRecyclerViewModel(getResources().getString(R.string.getNotificationInfo)));
        mDataList.add(new MainActivityRecyclerViewModel(getResources().getString(R.string.drawing_basic)));
        mDataList.add(new MainActivityRecyclerViewModel(getResources().getString(R.string.paint_usage)));
        mDataList.add(new MainActivityRecyclerViewModel(getResources().getString(R.string.text_paint)));
        mDataList.add(new MainActivityRecyclerViewModel(getResources().getString(R.string.clip_matrix)));
        mDataList.add(new MainActivityRecyclerViewModel(getResources().getString(R.string.draw_order)));
    }
}
