package commd.jy.zl.ball.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import commd.jy.zl.ball.R;

public class ShouYeFragment extends Fragment {
    public static ShouYeFragment onIntence(){
        ShouYeFragment shouYeFragment = new ShouYeFragment();
        return shouYeFragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.layout_shouye,null);
        return inflate;
    }
}
