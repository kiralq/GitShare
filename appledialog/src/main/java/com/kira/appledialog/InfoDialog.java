package com.kira.appledialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

/**
 * @Description: java类作用描述
 * @Author: kirali
 * @CreateDate: 2018/12/17 0017 12:03
 * @UpdateUser: kirali
 * @UpdateDate: 2018/12/17 0017 12:03
 * @UpdateRemark: 更新说明
 */
public class InfoDialog extends Dialog {
    TextView tv_message;
    TextView tv_negative;
    TextView tv_positive;
    TextView tv_title;
    View line_bottom;
    private Context mContext;
    public InfoDialog(@NonNull Context context) {
        this(context, R.style.MyDialog);
    }

    public InfoDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        mContext = context;
        setContentView(R.layout.dialog_info);
        initView();
    }

    private void initView() {
        tv_message=findViewById(R.id.tv_message);
        tv_negative=findViewById(R.id.tv_negative);
        tv_positive=findViewById(R.id.tv_positive);
        tv_title=findViewById(R.id.tv_title);
        line_bottom=findViewById(R.id.line_bottom);
    }
    public InfoDialog setTitle(String title) {
        if (title != null) {
            tv_title.setText(title);
        }
        return this;
    }
    public InfoDialog setMessage(String msg) {
        if (msg != null) {
            tv_message.setText(msg);
            tv_message.setVisibility(View.VISIBLE);
        }
        return this;
    }
    public InfoDialog setPositiveButton(final String text, final OnMyDialogButtonClickListener listener) {
        if (text != null) {
            tv_positive.setText(text);
        }
        tv_positive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onClick();
                }
                dismiss();
            }
        });
        return this;
    }
    public InfoDialog setNegativeButton(String text, final OnMyDialogButtonClickListener listener) {
        if (text != null) {
            tv_negative.setText(text);
            tv_negative.setVisibility(View.VISIBLE);
            line_bottom.setVisibility(View.VISIBLE);
        }
        tv_negative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onClick();
                }
                dismiss();
            }
        });
        return this;
    }
    public interface OnMyDialogButtonClickListener {
        void onClick();
    }
}
