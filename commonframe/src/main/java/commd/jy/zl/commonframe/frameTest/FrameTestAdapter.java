package commd.jy.zl.commonframe.frameTest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import commd.jy.zl.commonframe.R;
import commd.jy.zl.commonframe.utils.GlideUtil;

/**
 * Created by 任小龙 on 2019/12/12.
 */
public class FrameTestAdapter extends RecyclerView.Adapter<FrameTestAdapter.ViewHolder> {
    private Context mContext;
    private List<TestInfo.ModulesInfo> mModulesInfoList;

    public FrameTestAdapter(Context pContext, List<TestInfo.ModulesInfo> pModulesInfoList) {
        mContext = pContext;
        mModulesInfoList = pModulesInfoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.test_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GlideUtil.loadImage(holder.mImageView,mModulesInfoList.get(position).getImage());
        holder.mTextView.setText(mModulesInfoList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mModulesInfoList != null ? mModulesInfoList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;
        private ImageView mImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image);
            mTextView = itemView.findViewById(R.id.text);
        }
    }
}
