package commd.jy.zl.ball.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import commd.jy.zl.ball.R;

public class ShuJuFragment extends Fragment {
    public static ShuJuFragment onIntence(){
        ShuJuFragment shuJuFragment = new ShuJuFragment();
        return shuJuFragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.layout_shuju,null);
        return inflate;
    }
}
