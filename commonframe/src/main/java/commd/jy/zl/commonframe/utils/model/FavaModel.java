package commd.jy.zl.commonframe.utils.model;


import commd.jy.zl.commonframe.ICommonModel;
import commd.jy.zl.commonframe.ICommonPresenter;
import commd.jy.zl.commonframe.NetManger;
import commd.jy.zl.commonframe.configs.Apiconfig;

/**
 * Created by 任小龙 on 2019/12/21.
 */
public class FavaModel implements ICommonModel {
    NetManger mManger = NetManger.getInstance();

    @Override
    public void getData(ICommonPresenter pPresenter, int whichApi, int dataType, Object[] t) {
        switch (whichApi) {
            case Apiconfig.FAVE_LIST_API:
                mManger.netWork(mManger.getService().getFavorList(), pPresenter, whichApi, dataType);
                break;
        }
    }
}
