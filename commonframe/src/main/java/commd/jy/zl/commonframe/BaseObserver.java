package commd.jy.zl.commonframe;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by 任小龙 on 2019/12/19.
 */
public abstract class BaseObserver implements Observer {
    private Disposable mDisposable;

    private void disPose() {
        if (mDisposable != null && !mDisposable.isDisposed()) mDisposable.dispose();
    }

    @Override
    public void onSubscribe(Disposable d) {
        mDisposable = d;
    }

    @Override
    public void onNext(Object value) {
        onSuccess(value);
        disPose();
    }

    @Override
    public void onError(Throwable e) {
        onFail(e);
        disPose();
    }

    @Override
    public void onComplete() {

    }

    public abstract void onSuccess(Object value);

    public abstract void onFail(Throwable e);
}
