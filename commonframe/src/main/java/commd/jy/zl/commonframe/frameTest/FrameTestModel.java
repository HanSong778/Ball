package commd.jy.zl.commonframe.frameTest;


import java.util.Map;

import commd.jy.zl.commonframe.ICommonModel;
import commd.jy.zl.commonframe.ICommonPresenter;
import commd.jy.zl.commonframe.NetManger;
import commd.jy.zl.commonframe.configs.Apiconfig;

/**
 * Created by 任小龙 on 2019/12/18.
 */
public class FrameTestModel implements ICommonModel {
    NetManger mManger = NetManger.getInstance();

    @Override
    public void getData(final ICommonPresenter pPresenter, final int whichApi, final int dataType, Object[] t) {
        if (whichApi == Apiconfig.TEST_API)
            mManger.netWork(mManger.getService().getTestInfo((Map<String, String>) t[0]), pPresenter, whichApi, dataType);
    }
}
