package com.info.aegis.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.info.aegis.myapplication.activity.BitmapShaderActivity;
import com.info.aegis.myapplication.activity.ClipMatrixActivity;
import com.info.aegis.myapplication.activity.ColorMatrixColorFilterActivity;
import com.info.aegis.myapplication.activity.ComposeShaderActivity;
import com.info.aegis.myapplication.activity.FillPathActivity;
import com.info.aegis.myapplication.activity.FiveStarActivity;
import com.info.aegis.myapplication.activity.GetWeChatNotificationActivity;
import com.info.aegis.myapplication.activity.LightColorFilterActivity;
import com.info.aegis.myapplication.activity.LinearGradientActivity;
import com.info.aegis.myapplication.activity.HeartActivity;
import com.info.aegis.myapplication.activity.HistogramActivity;
import com.info.aegis.myapplication.activity.MaskFilterActivity;
import com.info.aegis.myapplication.activity.PathEffectActivity;
import com.info.aegis.myapplication.activity.PieActivity;
import com.info.aegis.myapplication.activity.RadiationGradientActivity;
import com.info.aegis.myapplication.activity.ShadowLayerActivity;
import com.info.aegis.myapplication.activity.StrokeCapActivity;
import com.info.aegis.myapplication.activity.StrokeJoinActivity;
import com.info.aegis.myapplication.activity.StrokeJoinMiterLengthActivity;
import com.info.aegis.myapplication.activity.SweepGradientActivity;
import com.info.aegis.myapplication.activity.TextPaintActivity;
import com.info.aegis.myapplication.activity.TextPathActivity;
import com.info.aegis.myapplication.activity.XferModeActivity;
import com.info.aegis.myapplication.adapter.MainActivityRecyclerViewAdapter;
import com.info.aegis.myapplication.model.MainActivityRecyclerViewModel;
import com.info.aegis.myapplication.view.ComposeShaderView;
import com.info.aegis.myapplication.view.RadiationGradientView;

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
                    case 2:
                        startActivity(new Intent(MainActivity.this, PieActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, HeartActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this, FiveStarActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(MainActivity.this, LinearGradientActivity.class));
                        break;
                    case 6:
                        startActivity(new Intent(MainActivity.this, RadiationGradientActivity.class));
                        break;
                    case 7:
                        startActivity(new Intent(MainActivity.this, SweepGradientActivity.class));
                        break;
                    case 8:
                        startActivity(new Intent(MainActivity.this, BitmapShaderActivity.class));
                        break;
                    case 9:
                        startActivity(new Intent(MainActivity.this, ComposeShaderActivity.class));
                        break;
                    case 10:
                        startActivity(new Intent(MainActivity.this, LightColorFilterActivity.class));
                        break;
                    case 11:
                        startActivity(new Intent(MainActivity.this, ColorMatrixColorFilterActivity.class));
                        break;
                    case 12:
                        startActivity(new Intent(MainActivity.this, XferModeActivity.class));
                        break;
                    case 13:
                        startActivity(new Intent(MainActivity.this, StrokeCapActivity.class));
                        break;
                    case 14:
                        startActivity(new Intent(MainActivity.this, StrokeJoinActivity.class));
                        break;
                    case 15:
                        startActivity(new Intent(MainActivity.this, StrokeJoinMiterLengthActivity.class));
                        break;
                    case 16:
                        startActivity(new Intent(MainActivity.this, PathEffectActivity.class));
                        break;
                    case 17:
                        startActivity(new Intent(MainActivity.this, ShadowLayerActivity.class));
                        break;
                    case 18:
                        startActivity(new Intent(MainActivity.this, MaskFilterActivity.class));
                        break;
                    case 19:
                        startActivity(new Intent(MainActivity.this, FillPathActivity.class));
                        break;
                    case 20:
                        startActivity(new Intent(MainActivity.this, TextPathActivity.class));
                        break;
                    case 21:
                        startActivity(new Intent(MainActivity.this, TextPaintActivity.class));
                        break;
                    case 22:
                        startActivity(new Intent(MainActivity.this, ClipMatrixActivity.class));
                        break;
                }
            }
        });
    }

    private void initData() {
        mDataList.add(new MainActivityRecyclerViewModel(getResources().getString(R.string.getNotificationInfo)));
        mDataList.add(new MainActivityRecyclerViewModel(getResources().getString(R.string.histogram)));
        mDataList.add(new MainActivityRecyclerViewModel(getResources().getString(R.string.pie)));
        mDataList.add(new MainActivityRecyclerViewModel(getResources().getString(R.string.heart)));
        mDataList.add(new MainActivityRecyclerViewModel(getResources().getString(R.string.fiveStar)));
        mDataList.add(new MainActivityRecyclerViewModel(getResources().getString(R.string.linearGradient)));
        mDataList.add(new MainActivityRecyclerViewModel(getResources().getString(R.string.radiationGradient)));
        mDataList.add(new MainActivityRecyclerViewModel(getResources().getString(R.string.sweepGradient)));
        mDataList.add(new MainActivityRecyclerViewModel(getResources().getString(R.string.bitmapShader)));
        mDataList.add(new MainActivityRecyclerViewModel(getResources().getString(R.string.composeShader)));
        mDataList.add(new MainActivityRecyclerViewModel(getResources().getString(R.string.lightColorFilter)));
        mDataList.add(new MainActivityRecyclerViewModel(getResources().getString(R.string.colorMatrixColorFilter)));
        mDataList.add(new MainActivityRecyclerViewModel(getResources().getString(R.string.xFerMode)));
        mDataList.add(new MainActivityRecyclerViewModel(getResources().getString(R.string.strokeCap)));
        mDataList.add(new MainActivityRecyclerViewModel(getResources().getString(R.string.strokeJoin)));
        mDataList.add(new MainActivityRecyclerViewModel(getResources().getString(R.string.strokeJoinMiterLength)));
        mDataList.add(new MainActivityRecyclerViewModel(getResources().getString(R.string.pathEffect)));
        mDataList.add(new MainActivityRecyclerViewModel(getResources().getString(R.string.shadowLayer)));
        mDataList.add(new MainActivityRecyclerViewModel(getResources().getString(R.string.maskFilter)));
        mDataList.add(new MainActivityRecyclerViewModel(getResources().getString(R.string.fillPath)));
        mDataList.add(new MainActivityRecyclerViewModel(getResources().getString(R.string.textPath)));
        mDataList.add(new MainActivityRecyclerViewModel(getResources().getString(R.string.textPaint)));
        mDataList.add(new MainActivityRecyclerViewModel(getResources().getString(R.string.clip_matrix)));
    }
}
