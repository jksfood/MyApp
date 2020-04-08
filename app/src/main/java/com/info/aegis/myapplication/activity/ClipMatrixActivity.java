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

public class ClipMatrixActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    List<PageModel> pageModels = new ArrayList<>();

    {
        pageModels.add(new PageModel(R.layout.sample_clip_rect, R.string.title_clip_rect));
        pageModels.add(new PageModel(R.layout.sample_clip_path, R.string.title_clip_path));
        pageModels.add(new PageModel(R.layout.sample_translate, R.string.title_translate));
        pageModels.add(new PageModel(R.layout.sample_scale, R.string.title_scale));
        pageModels.add(new PageModel(R.layout.sample_rotate, R.string.title_rotate));
        pageModels.add(new PageModel(R.layout.sample_skew, R.string.title_skew));
        pageModels.add(new PageModel(R.layout.sample_matrix_translate, R.string.title_matrix_translate));
        pageModels.add(new PageModel(R.layout.sample_matrix_scale, R.string.title_matrix_scale));
        pageModels.add(new PageModel(R.layout.sample_matrix_rotate, R.string.title_matrix_rotate));
        pageModels.add(new PageModel(R.layout.sample_matrix_skew, R.string.title_matrix_skew));
        pageModels.add(new PageModel(R.layout.sample_camera_rotate_fixed, R.string.title_camera_rotate));
        pageModels.add(new PageModel(R.layout.sample_camera_rotate_hitting_face, R.string.title_camera_rotate_hitting_face));
        pageModels.add(new PageModel(R.layout.sample_flipboard, R.string.title_flipboard));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clip_matrix);

        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

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
        tabLayout.setupWithViewPager(viewPager);
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
