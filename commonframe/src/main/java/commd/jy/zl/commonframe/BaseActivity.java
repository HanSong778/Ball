package commd.jy.zl.commonframe;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import commd.jy.zl.utils.utils.ext.StatusBarUtil;

/**
 * Created by 任小龙 on 2019/12/18.
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBar();
    }

    public void showErrorLog(Object object){
        Log.e(this.getClass().getSimpleName(), object.toString() );
    }
    public void showToast(Object object){
        Toast.makeText(this, object.toString(), Toast.LENGTH_SHORT).show();
    }
    protected void setStatusBar() {
        //这里做了两件事情，1.使状态栏透明并使contentView填充到状态栏 2.预留出状态栏的位置，防止界面上的控件离顶部靠的太近。这样就可以实现开头说的第二种情况的沉浸式状态栏了
        StatusBarUtil.setTransparent(this);
    }
}
