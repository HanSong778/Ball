package commd.jy.zl.commonframe;

/**
 * Created by 任小龙 on 2019/12/18.
 */
public interface ICommonPresenter<P> extends ICommonView {
    void getData(int whichApi, int dataType, P... pPS);
}
