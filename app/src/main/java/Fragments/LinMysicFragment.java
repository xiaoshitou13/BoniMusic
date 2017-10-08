package Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.List;

import Bean.ZhudaData;
import Net.net;
import mAdater.MyExpandAdater;
import test.bwie.com.bonimusic.R;


public class LinMysicFragment extends Fragment{


    private View view;
    private ExpandableListView mExpand;
    private List<String> list= new ArrayList<>();
    private MyExpandAdater myExpandAdater;
    private ArrayList<List<ZhudaData.ContentBeanX>> lists;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lin_mysic, container, false);

        String st =  net.REGE;

        list.add("主打榜单"); list.add("分类榜单");  list.add("媒体榜单");

        initView(v);

        return v;
    }

    private void initView(View v) {
        mExpand = (ExpandableListView) v.findViewById(R.id.expand);
        myExpandAdater = new MyExpandAdater(getContext(),list);
        mExpand.setAdapter(myExpandAdater);
    }


}