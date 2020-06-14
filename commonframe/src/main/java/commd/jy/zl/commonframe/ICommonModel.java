package commd.jy.zl.commonframe;

/**
 * Created by 任小龙 on 2019/12/18.
 */
public interface ICommonModel<T> {
    void getData(ICommonPresenter pPresenter, int whichApi, int dataType, T... t);
}
