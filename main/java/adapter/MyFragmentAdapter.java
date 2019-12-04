package adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/*
 *@auther:郝世龙
 *@Date: 2019-12-03
 *@Time:9:28
 *@Description:${适配器}
 **/public class MyFragmentAdapter extends FragmentPagerAdapter {
    List<String> slist;
    List<Fragment> flist;

    public MyFragmentAdapter(FragmentManager fm, List<String> slist, List<Fragment> flist) {
        super(fm);
        this.slist = slist;
        this.flist = flist;
    }

    @Override
    public Fragment getItem(int i) {
        return flist.get(i);
    }

    @Override
    public int getCount() {
        return flist.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return slist.get(position);
    }

}
