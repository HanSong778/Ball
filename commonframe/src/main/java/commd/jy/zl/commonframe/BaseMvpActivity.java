package commd.jy.zl.commonframe;

import android.os.Bundle;
import android.text.TextUtils;

import androidx.annotation.Nullable;
import butterknife.ButterKnife;

/**
 * Created by 任小龙 on 2019/12/18.
 */
public abstract class BaseMvpActivity<M extends ICommonModel> extends BaseActivity implements ICommonView {
    public CommonPresenter mPresenter;
    private M mModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        ButterKnife.bind(this);
        setUpView();
        mModel = setModel();
        mPresenter = new CommonPresenter(this, mModel);
        setUpData();
    }

    @Override
    protected void onDestroy() {
        mPresenter.destroy();
        super.onDestroy();
    }

    public abstract int  setLayout();

    public abstract void setUpView();

    public abstract void setUpData();

    public abstract M setModel();

    @Override
    public void onSuccess(int whichApi, int dataType, Object[] t) {

    }

    @Override
    public void onFailed(int whichApi, Throwable e) {
        showErrorLog("网络请求发生错误----错误位置：" + whichApi + ",错误信息：" + e != null && !TextUtils.isEmpty(e.getMessage()) ? e.getMessage() : "错误原因未知！！！");
    }
}
