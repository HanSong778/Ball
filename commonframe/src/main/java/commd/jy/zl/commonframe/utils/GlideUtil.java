package commd.jy.zl.commonframe.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import commd.jy.zl.commonframe.FrameApplication;


public class GlideUtil {
    public static void loadImage(ImageView imageView, String filePath) {
        ColorDrawable drawable = new ColorDrawable(Color.GRAY);
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(drawable);
        Glide.with(FrameApplication.getFrameContext())
                .load(filePath)
                .apply(options)
                .into(imageView);
    }

    public static void loadImageWithSize(Context context, int resizeX, int resizeY, ImageView imageView, String url) {
        Glide.with(context)
                .load(url)
                .apply(new RequestOptions()
                        .override(resizeX, resizeY))
                .into(imageView);
    }

    public static void loadCornerImage(ImageView imageView, String filePath, RequestListener listener, float radius) {
        CornerTransform transform = new CornerTransform(FrameApplication.getFrameContext(), radius);
        ColorDrawable drawable = new ColorDrawable(Color.GRAY);
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(drawable)
                .transform(transform);
        Glide.with(FrameApplication.getFrameContext())
                .load(filePath)
                .apply(options)
                .listener(listener)
                .into(imageView);
    }
}
