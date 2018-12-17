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
public class EditDialog extends Dialog {
    TextView tv_message;
    TextView tv_negative;
    TextView tv_positive;
    TextView tv_title;
    View line_bottom;
    ClearEditText edit_first;
    ClearEditText edit_sec;
    private Context mContext;
    public EditDialog(@NonNull Context context) {
        this(context, R.style.MyDialog);
    }

    public EditDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        mContext = context;
        setContentView(R.layout.dialog_edit);
        initView();
    }

    private void initView() {
        tv_message=findViewById(R.id.tv_message);
        tv_negative=findViewById(R.id.tv_negative);
        tv_positive=findViewById(R.id.tv_positive);
        tv_title=findViewById(R.id.tv_title);
        line_bottom=findViewById(R.id.line_bottom);
        edit_first=findViewById(R.id.edit_first);
        edit_sec=findViewById(R.id.edit_sec);
    }
    public EditDialog setTitle(String title) {
        if (title != null) {
            tv_title.setText(title);
        }
        return this;
    }
    public EditDialog setMessage(String msg) {
        if (msg != null) {
            tv_message.setText(msg);
            tv_message.setVisibility(View.VISIBLE);
        }
        return this;
    }
    public EditDialog setEditFirstHint(String msg) {
        if (msg != null) {
            edit_first.setHint(msg);
            edit_first.setVisibility(View.VISIBLE);
        }
        return this;
    }
    public EditDialog setEditSecHint(String msg) {
        if (msg != null) {
            edit_sec.setHint(msg);
            edit_sec.setVisibility(View.VISIBLE);
        }
        return this;
    }
    public EditDialog setPositiveButton(final String text, final OnMyDialogButtonClickListener listener) {
        if (text != null) {
            tv_positive.setText(text);
        }
        tv_positive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onClickPosition(edit_first.getText().toString(),edit_sec.getText().toString());
                }
                dismiss();
            }
        });
        return this;
    }
    public EditDialog setNegativeButton(String text, final OnMyDialogButtonClickListener listener) {
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
        void onClickPosition(String content1,String content2);
    }
}
