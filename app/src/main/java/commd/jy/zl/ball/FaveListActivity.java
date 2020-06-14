package commd.jy.zl.ball;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.google.android.material.tabs.TabLayout;

import butterknife.ButterKnife;
import commd.jy.zl.ball.desighView.commonTitle;
import commd.jy.zl.beanlibrary.FavTeamEntity;
import commd.jy.zl.commonframe.BaseMvpActivity;
import commd.jy.zl.commonframe.ICommonView;
import commd.jy.zl.commonframe.configs.Apiconfig;
import commd.jy.zl.commonframe.utils.model.FavaModel;

public class FaveListActivity extends BaseMvpActivity<FavaModel> implements ICommonView, View.OnClickListener {


    private commonTitle mCommonTiTle;
    private TabLayout mTab;
    private FrameLayout mFrame;

    /**
     * 确定
     */
    private Button mBut;
    private FavTeamEntity localEntity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fave_list);
        ButterKnife.bind(this);
        initView();
    }


    @Override
    public int setLayout() {
        return R.layout.activity_fave_list;
    }

    @Override
    public void setUpView() {
    }

    @Override
    public void setUpData() {
        mPresenter.getData(Apiconfig.FAVE_LIST_API, 0);
    }

    @Override
    public FavaModel setModel() {
        return new FavaModel();
    }

    @Override
    public void onSuccess(int whichApi, int dataType, Object[] t) {
        super.onSuccess(whichApi, dataType, t);
        switch (whichApi) {
            case Apiconfig.FAVE_LIST_API:
                localEntity = (FavTeamEntity) t[0];
                Log.i("TAG", localEntity.toString());
                break;
        }
    }

    private void initView() {
        mCommonTiTle = (commonTitle) findViewById(R.id.commonTiTle);
        mCommonTiTle.mTvTitle.setText("请选择你喜欢的球队");
        mFrame = (FrameLayout) findViewById(R.id.frame);
        mTab = (TabLayout) findViewById(R.id.tab);
        mBut = (Button) findViewById(R.id.but);
        mBut.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.but:
                startActivity(new Intent(FaveListActivity.this,ShowActivity.class));
                break;
        }
    }
}
