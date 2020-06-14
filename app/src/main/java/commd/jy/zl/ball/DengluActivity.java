package commd.jy.zl.ball;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import commd.jy.zl.commonframe.BaseActivity;

public class DengluActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mFhDl;
    /**
     * +86 >
     */
    private EditText mPhone;
    /**
     * 验证码
     */
    private EditText mCode;
    /**
     * 微信
     */
    private ImageView mWeixin;
    /**
     * 获取验证码
     */
    private TextView mYzM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denglu);
        initView();
    }

    private void initView() {
        mFhDl = (ImageView) findViewById(R.id.fh_dl);
        mPhone = (EditText) findViewById(R.id.phone);
        mCode = (EditText) findViewById(R.id.code);
        mWeixin = (ImageView) findViewById(R.id.weixin);
        mYzM = (TextView) findViewById(R.id.yzM);
        mYzM.setOnClickListener(this);
        mWeixin.setOnClickListener(this);
        mFhDl.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.fh_dl:
                finish();
                break;
            case R.id.yzM:
                break;
            case R.id.weixin:
                break;
        }
    }
}
