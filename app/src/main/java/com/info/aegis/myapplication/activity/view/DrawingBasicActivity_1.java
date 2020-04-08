package com.info.aegis.myapplication.activity.view;

import com.info.aegis.myapplication.R;
import com.info.aegis.myapplication.activity.base.BaseActivity;

public class DrawingBasicActivity_1 extends BaseActivity {

    {
        pageModels.add(new PageModel(R.layout.activity_histogram,R.string.histogram));
        pageModels.add(new PageModel(R.layout.activity_pie,R.string.pie));
        pageModels.add(new PageModel(R.layout.activity_heart,R.string.heart));
        pageModels.add(new PageModel(R.layout.activity_five_star,R.string.fiveStar));
    }
}
