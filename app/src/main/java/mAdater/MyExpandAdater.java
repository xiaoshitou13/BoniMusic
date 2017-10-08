package mAdater;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import test.bwie.com.bonimusic.R;

/**
 * Created by 白玉春 on 2017/10/6.
 */

public class MyExpandAdater extends BaseExpandableListAdapter {

    Context context ;
    List<String> Yiji;

    public MyExpandAdater(Context context, List<String> yiji) {
        this.context = context;
        Yiji = yiji;
    }

    @Override
    public int getGroupCount() {
        return Yiji.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return 0;
    }

    @Override
    public Object getGroup(int i) {
        return Yiji.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return i1;
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        view = View.inflate(context, R.layout.linmusicyiji,null);
        TextView tv = view.findViewById(R.id.yijitext);
        tv.setText(Yiji.get(i));
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
