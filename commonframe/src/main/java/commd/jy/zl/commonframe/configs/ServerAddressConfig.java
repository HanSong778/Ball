package commd.jy.zl.commonframe.configs;

/**
 * Created by 任小龙 on 2019/12/19.
 */
public class ServerAddressConfig {
    private static int API_TYPE = 1;
    public static String BASE_URL;
    public static final String BASE_URL2 = "http://sport-data.dqdgame.com/?a=1";
    static {
        if (API_TYPE == 1)BASE_URL = "https://bkbapi.dqdgame.com/";
        else if (API_TYPE == 2)BASE_URL = "https://www.baidu.com";
        else BASE_URL = "https://www.sina.com";
    }
}
