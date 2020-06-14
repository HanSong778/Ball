package commd.jy.zl.ball.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import commd.jy.zl.ball.R;

public class QuanZiFragment extends Fragment {
    public static QuanZiFragment onIntence(){
        QuanZiFragment quanZiFragment = new QuanZiFragment();
        return quanZiFragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.layout_quanzi,null);
        return inflate;
    }
}
