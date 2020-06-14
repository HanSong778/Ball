package commd.jy.zl.ball.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import commd.jy.zl.ball.R;
import commd.jy.zl.commonframe.frameTest.TestInfo;

public class DRL_RlvAdapter extends RecyclerView.Adapter<DRL_RlvAdapter.ViewHolder> {
    private List<TestInfo.ModulesInfo> mModulesInfoList;
    private Context context;

    public DRL_RlvAdapter(List<TestInfo.ModulesInfo> mModulesInfoList, Context context) {
        this.mModulesInfoList = mModulesInfoList;
        this.context = context;
    }

    @NonNull
    @Override
    public DRL_RlvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_drl_rlv, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DRL_RlvAdapter.ViewHolder holder, int position) {
        holder.name.setText(mModulesInfoList.get(position).getName());
        Glide.with(context).load(mModulesInfoList.get(position).getImage()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return mModulesInfoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_drl);
            name = itemView.findViewById(R.id.name);
        }
    }
}
