package commd.jy.zl.ball.Modle;

import commd.jy.zl.commonframe.ICommonModel;
import commd.jy.zl.commonframe.ICommonPresenter;
import commd.jy.zl.commonframe.NetManger;
import commd.jy.zl.commonframe.configs.Apiconfig;

public class FaveModle implements ICommonModel {
    NetManger manger = NetManger.getInstance();
    @Override
    public void getData(ICommonPresenter pPresenter, int whichApi, int dataType, Object[] t) {
        switch (whichApi){
            case Apiconfig.FAVE_LIST_API:
                manger.netWork(manger.getService().getFavorList(),pPresenter,whichApi,dataType);
                break;
        }

    }
}
