package commd.jy.zl.ball;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import commd.jy.zl.ball.Adapter.DRL_RlvAdapter;
import commd.jy.zl.ball.Adapter.VpAdapter;
import commd.jy.zl.ball.Fragment.BiSaiFragment;
import commd.jy.zl.ball.Fragment.QuanZiFragment;
import commd.jy.zl.ball.Fragment.ShouYeFragment;
import commd.jy.zl.ball.Fragment.ShuJuFragment;
import commd.jy.zl.commonframe.BaseMvpActivity;
import commd.jy.zl.commonframe.ICommonView;
import commd.jy.zl.commonframe.configs.Apiconfig;
import commd.jy.zl.commonframe.frameTest.TestInfo;

public class ShowActivity extends BaseMvpActivity<ShowModle> implements ICommonView {

    private ViewPager mVpShoye;
    private TabLayout mTabShouye;
    private NavigationView mNaShouye;
    private DrawerLayout mDrl;
    private ArrayList<Fragment> fragments;
    private VpAdapter adapter;
    private List<TestInfo.ModulesInfo> mModulesInfoList = new ArrayList<>();
    private DRL_RlvAdapter adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initView();

    }

    @Override
    public int setLayout() {
        return R.layout.activity_show;
    }

    @Override
    public void setUpView() {

    }

    @Override
    public void setUpData() {
        Map<String, String> params = new HashMap<>();//mark=gif&platform=android&version=132&android-channel=website
        params.put("mark", "gif");
        params.put("platform", "android");
        params.put("version", "132");
        params.put("android-channel", "website");
        mPresenter.getData(Apiconfig.TEST_API, 0, params);
    }

    @Override
    public ShowModle setModel() {
        return new ShowModle();
    }


    private void initView() {
        mVpShoye = (ViewPager) findViewById(R.id.vp_shoye);
        mTabShouye = (TabLayout) findViewById(R.id.tab_shouye);
        mNaShouye = (NavigationView) findViewById(R.id.na_shouye);
        mDrl = (DrawerLayout) findViewById(R.id.drl);
        initFragment();
        initNa();
    }

    private void initNa() {
        View view = mNaShouye.getHeaderView(0);
        Button but = view.findViewById(R.id.but_denglu);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShowActivity.this,DengluActivity.class));
            }
        });
        RecyclerView rlv = view.findViewById(R.id.rlv_drl);
        rlv.setLayoutManager(new GridLayoutManager(this,3));
        adapter1 = new DRL_RlvAdapter(mModulesInfoList, this);
        rlv.setAdapter(adapter1);
    }


    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(ShouYeFragment.onIntence());
        fragments.add(BiSaiFragment.onIntence());
        fragments.add(QuanZiFragment.onIntence());
        fragments.add(ShuJuFragment.onIntence());
        adapter = new VpAdapter(getSupportFragmentManager(), fragments);
        mVpShoye.setAdapter(adapter);
        mTabShouye.setupWithViewPager(mVpShoye);
        mTabShouye.getTabAt(0).setText(R.string.shouye).setIcon(R.drawable.selector_shouye);
        mTabShouye.getTabAt(1).setText(R.string.bisai).setIcon(R.drawable.selector_bisai);
        mTabShouye.getTabAt(2).setText(R.string.quanzi).setIcon(R.drawable.selector_quanzi);
        mTabShouye.getTabAt(3).setText(R.string.shujv).setIcon(R.drawable.selector_shujv);
    }

    @Override
    public void onSuccess(int whichApi, int dataType, Object[] t) {
        super.onSuccess(whichApi, dataType, t);
        switch (whichApi){
            case Apiconfig.TEST_API:
            TestInfo localInfo = (TestInfo) t[0];
            mModulesInfoList.addAll(localInfo.getModules());
            adapter1.notifyDataSetChanged();
            break;
        }
    }
}
