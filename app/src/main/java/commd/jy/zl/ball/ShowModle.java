package commd.jy.zl.ball;

import java.util.Map;

import commd.jy.zl.commonframe.ICommonModel;
import commd.jy.zl.commonframe.ICommonPresenter;
import commd.jy.zl.commonframe.NetManger;
import commd.jy.zl.commonframe.configs.Apiconfig;

class ShowModle implements ICommonModel {
    NetManger netManger = NetManger.getInstance();

    @Override
    public void getData(ICommonPresenter pPresenter, int whichApi, int dataType, Object[] t) {
        if (whichApi == Apiconfig.TEST_API) {
            netManger.netWork(netManger.getService().getTestInfo((Map<String, String>) t[0]), pPresenter, whichApi, dataType);
        }
    }
}
