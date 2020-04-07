package com.info.aegis.myapplication.activity;

import androidx.annotation.LayoutRes;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.info.aegis.myapplication.PageFragment;
import com.info.aegis.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class TextPaintActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager pager;
    List<PageModel> pageModels = new ArrayList<>();

    {
        pageModels.add(new PageModel(R.layout.sample_draw_text, R.string.title_draw_text));
        pageModels.add(new PageModel(R.layout.sample_static_layout, R.string.title_static_layout));
        pageModels.add(new PageModel(R.layout.sample_set_text_size, R.string.title_set_text_size));
        pageModels.add(new PageModel(R.layout.sample_set_typeface, R.string.title_set_typeface));
        pageModels.add(new PageModel(R.layout.sample_set_fake_bold_text, R.string.title_set_fake_bold_text));
        pageModels.add(new PageModel(R.layout.sample_set_strike_thru_text, R.string.title_set_strike_thru_text));
        pageModels.add(new PageModel(R.layout.sample_set_underline_text, R.string.title_set_underline_text));
        pageModels.add(new PageModel(R.layout.sample_set_text_skew_x, R.string.title_set_text_skew_x));
        pageModels.add(new PageModel(R.layout.sample_set_text_scale_x, R.string.title_set_text_scale_x));
        pageModels.add(new PageModel(R.layout.sample_set_text_align, R.string.title_set_text_align));
        pageModels.add(new PageModel(R.layout.sample_get_font_spacing, R.string.title_get_font_spacing));
        pageModels.add(new PageModel(R.layout.sample_measure_text, R.string.title_measure_text));
        pageModels.add(new PageModel(R.layout.sample_get_text_bounds, R.string.title_get_text_bounds));
        pageModels.add(new PageModel(R.layout.sample_get_font_metrics, R.string.title_get_font_metrics));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_paint);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                PageModel pageModel = pageModels.get(position);
                return PageFragment.newInstance(pageModel.sampleLayoutRes);
            }

            @Override
            public int getCount() {
                return pageModels.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return getString(pageModels.get(position).titleRes);
            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(pager);
    }

    private class PageModel {
        @LayoutRes
        int sampleLayoutRes;
        @StringRes
        int titleRes;

        PageModel(@LayoutRes int sampleLayoutRes, @StringRes int titleRes) {
            this.sampleLayoutRes = sampleLayoutRes;
            this.titleRes = titleRes;
        }
    }
}
