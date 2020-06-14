package commd.jy.zl.commonframe;
import commd.jy.zl.commonframe.configs.ServerAddressConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetManger {
    private NetManger() {
    }

    private static volatile NetManger sNetManger;

    public static NetManger getInstance() {
        if (sNetManger == null) {
            synchronized (NetManger.class) {
                sNetManger = new NetManger();
            }
        }
        return sNetManger;
    }

    public <T> IService getService(T... t) {
        String baseUrl = ServerAddressConfig.BASE_URL;
        if (t != null && t.length != 0) {
            baseUrl = (String) t[0];
        }
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(NetInterceptor.getNetInterceptor().getClientWithoutCache())
                .build()
                .create(IService.class);
    }

    public <T> void netWork(Observable<T> localTestInfo, final ICommonPresenter pPresenter, final int whichApi, final int dataType) {
        localTestInfo
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver() {

                    @Override
                    public void onSuccess(Object value) {
                        pPresenter.onSuccess(whichApi, dataType, value);
                    }

                    @Override
                    public void onFail(Throwable e) {
                        pPresenter.onFailed(whichApi, e);
                    }
                });
    }
}
