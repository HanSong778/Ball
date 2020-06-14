package commd.jy.zl.commonframe;

import android.app.Application;
import android.content.Context;

import java.util.UUID;

import commd.jy.zl.commonframe.utils.DeviceUuidFactory;
import commd.jy.zl.commonframe.utils.SharedPrefrenceUtils;

public class FrameApplication extends Application {
    private static FrameApplication sFrameApplication;
    public UUID mUuid;
    public String mToken;
    public static String mSeesion = "";
    @Override
    public void onCreate() {
        super.onCreate();
        sFrameApplication = this;
        mUuid = DeviceUuidFactory.getInstance(getApplicationContext()).getDeviceUuid();
        String session = SharedPrefrenceUtils.getString(this, "session");
        mSeesion = session;
    }

    public static FrameApplication getFrameApplication(){
        return sFrameApplication;
    }

    public static Context getFrameContext(){
        return sFrameApplication.getApplicationContext();
    }
}
