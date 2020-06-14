package commd.jy.zl.commonframe.frameTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import commd.jy.zl.commonframe.BaseMvpActivity;
import commd.jy.zl.commonframe.ICommonModel;
import commd.jy.zl.commonframe.ICommonView;
import commd.jy.zl.commonframe.R;
import commd.jy.zl.commonframe.R2;
import commd.jy.zl.commonframe.configs.Apiconfig;

public class FrameTestActivity extends BaseMvpActivity implements ICommonView {

    @BindView(R2.id.rlv)
    RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private List<TestInfo.ModulesInfo> mModulesInfoList = new ArrayList<>();
    private FrameTestAdapter mAdapter;

    @Override
    public int setLayout() {
        return R.layout.activity_frame_test;
    }

    @Override
    public void setUpView() {
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mAdapter = new FrameTestAdapter(this, mModulesInfoList);
        mRecyclerView.setAdapter(mAdapter);
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
    public ICommonModel setModel() {
        return new FrameTestModel();
    }

    @Override
    public void onSuccess(int whichApi, int dataType, Object[] t) {
        switch (whichApi) {
            case Apiconfig.TEST_API:
                TestInfo localInfo = (TestInfo) t[0];
                mModulesInfoList.addAll(localInfo.getModules());
                mAdapter.notifyDataSetChanged();
                break;
        }
    }

}
