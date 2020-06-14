package commd.jy.zl.commonframe;

/**
 * Created by 任小龙 on 2019/12/18.
 */
public interface ICommonView<T> {
    void onSuccess(int whichApi, int dataType, T... t);
    void onFailed(int whichApi, Throwable e);
}
