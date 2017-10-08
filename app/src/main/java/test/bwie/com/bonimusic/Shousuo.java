package test.bwie.com.bonimusic;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import Utils.Cengjing;

public class Shousuo extends AppCompatActivity implements View.OnClickListener{

    private ImageView mLeftjiantou;
    /**
     * 歌曲名，歌手名
     */
    private EditText mSousuogqgs;
    private ImageView mRightIcons;
    private RelativeLayout mTou;
    private RecyclerView mSousuoRecy;
    private RelativeLayout mwei;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shousuo);
        initView();
        Build build = new Build();
        Cengjing cengjing = new Cengjing(build, this, getSupportActionBar());
    }

    private void initView() {
        mLeftjiantou = (ImageView) findViewById(R.id.leftjiantou);
        mLeftjiantou.setOnClickListener(this);
        mSousuogqgs = (EditText) findViewById(R.id.sousuogqgs);
        mRightIcons = (ImageView) findViewById(R.id.right_icons);
        mRightIcons.setOnClickListener(this);
        mTou = (RelativeLayout) findViewById(R.id.tou);
        mSousuoRecy = (RecyclerView) findViewById(R.id.sousuoRecy);
        mwei = (RelativeLayout) findViewById(R.id.wei);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.leftjiantou:
                finish();
                break;
            case R.id.right_icons:
                    mwei.setVisibility(View.GONE);
                    mSousuoRecy.setVisibility(View.VISIBLE);
                break;
        }
    }
}
