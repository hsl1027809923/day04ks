package adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/*
 *@auther:郝世龙
 *@Date: 2019-12-04
 *@Time:14:22
 *@Description:${DESCRIPTION}
 **/public class MyFragmentAdapter extends FragmentPagerAdapter {
    List<Fragment> list;
    Context context;

    public MyFragmentAdapter(FragmentManager fm, List<Fragment> list, Context context) {
        super(fm);
        this.list = list;
        this.context = context;
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
