package commd.jy.zl.commonframe;

import java.lang.ref.WeakReference;

/**
 * Created by 任小龙 on 2019/12/18.
 */
public class CommonPresenter<V extends ICommonView, M extends ICommonModel> implements ICommonPresenter {
    private WeakReference<V> mView;
    private WeakReference<M> mModel;

    public CommonPresenter(V pView, M pModel) {
        mView = new WeakReference<>(pView);
        mModel = new WeakReference<>(pModel);
    }

    public void destroy() {
        if (mView != null) mView.clear();
        if (mModel != null) mModel.clear();
        mView = null;
        mModel = null;
    }

    @Override
    public void getData(int whichApi, int dataType, Object... pObjects) {
        if (mModel != null) mModel.get().getData(this, whichApi, dataType, pObjects);
    }

    @Override
    public void onSuccess(int whichApi, int dataType, Object[] t) {
        if (mView != null) mView.get().onSuccess(whichApi, dataType, t);
    }

    @Override
    public void onFailed(int whichApi, Throwable e) {
        if (mView != null) mView.get().onFailed(whichApi, e);
    }
}
