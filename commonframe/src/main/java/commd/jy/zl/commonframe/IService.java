package commd.jy.zl.commonframe;

import java.util.Map;
import commd.jy.zl.beanlibrary.FavTeamEntity;
import commd.jy.zl.commonframe.frameTest.TestInfo;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface IService {
    @GET("app/global/2/android.json")
    Observable<TestInfo> getTestInfo(@QueryMap Map<String, String> params);
    @GET("v2/league/favlists")
    Observable<FavTeamEntity> getFavorList();
}
