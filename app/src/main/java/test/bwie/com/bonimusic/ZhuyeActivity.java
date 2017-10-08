package test.bwie.com.bonimusic;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import Fragments.LinMysicFragment;
import Fragments.MyMusicFragment;
import Utils.Cengjing;

public class ZhuyeActivity extends AppCompatActivity {

    String[] str = new String[]{"我的音乐", "在线音乐"};
    private ImageView mLeftcela;
    private TabLayout mTablay;
    private RelativeLayout mTou;
    private ViewPager mVp;
    private RelativeLayout mWei;
    private ImageView mRighticol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuye);
        initView();
        Build b = new Build();
        Cengjing cengjing = new Cengjing(b, this, getSupportActionBar());

    }

    private void initView() {
        mLeftcela = (ImageView) findViewById(R.id.leftcela);
        mTablay = (TabLayout) findViewById(R.id.tablay);
        mTou = (RelativeLayout) findViewById(R.id.tou);
        mVp = (ViewPager) findViewById(R.id.vp);
        mWei = (RelativeLayout) findViewById(R.id.wei);
        mRighticol = (ImageView) findViewById(R.id.right_icon);
        for(int i =0 ; i < str.length ; i++){
            mTablay.addTab(mTablay.newTab().setText(str[i]));
        }
        mVp.setAdapter(new MyViewPagerAdater(getSupportFragmentManager()));
        mTablay.setupWithViewPager(mVp);

        final SlidingMenu menu = new SlidingMenu(this);//初始化滑动菜单
        menu.setMode(SlidingMenu.LEFT);//设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        menu.setShadowWidthRes(R.dimen.shadow_width);//设置阴影的宽度
        //menu.setShadowDrawable(R.drawable.shadow);//设置滑动菜单的阴影效果
        // 设置滑动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        // 设置渐入渐出效果的值
        menu.setFadeEnabled(true);
        menu.setFadeDegree(0.35f);
        /**
         *SLIDING_WINDOW will include the Title/ActionBar in the content
         *section of the SlidingMenu, while SLIDING_CONTENT does not.
         */
        // 把滑动菜单添加进所有的Activity中
       // menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        //侧拉  沉浸式
        menu.attachToActivity(ZhuyeActivity.this,SlidingMenu.SLIDING_CONTENT,true);
        // 为侧滑菜单设置布局
        View v = LayoutInflater.from(this).inflate(R.layout.leftmenu,null);

        menu.setMenu(v);


        mLeftcela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               menu.showMenu();
            }
        });

       mRighticol.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(ZhuyeActivity.this,Shousuo.class));
           }
       });
    }

    private class MyViewPagerAdater extends FragmentPagerAdapter {
        public MyViewPagerAdater(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment f = null;
            switch (position){
                case 0:
                    f = new MyMusicFragment();
                    break;
                case 1:
                    f = new LinMysicFragment();
                    break;
            }
            return f;
        }

        @Override
        public int getCount() {
            return str.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return str[position];
        }
    }
}
