package com.kira.appledialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @Description: java类作用描述
 * @Author: kirali
 * @CreateDate: 2018/12/17 0017 12:03
 * @UpdateUser: kirali
 * @UpdateDate: 2018/12/17 0017 12:03
 * @UpdateRemark: 更新说明
 */
public class AppleEditDialog extends Dialog {
    TextView tv_message;
    TextView tv_negative;
    TextView tv_positive;
    TextView tv_title;
    View line_bottom;
    EditText edit_first;
    EditText edit_sec;
    LinearLayout ll_edit_sec;
    ImageView iv_del1;
    ImageView iv_del2;
    private Context mContext;
    public AppleEditDialog(@NonNull Context context) {
        this(context, R.style.MyDialog);
    }

    public AppleEditDialog(@NonNull Context context, int themeResId) {
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
        ll_edit_sec=findViewById(R.id.ll_edit_sec);
        iv_del1=findViewById(R.id.iv_del1);
        iv_del2=findViewById(R.id.iv_del2);
        edit_first.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().length()>0){
                    iv_del1.setVisibility(View.VISIBLE);
                }else{
                    iv_del1.setVisibility(View.GONE);
                }
            }
        });
        edit_sec.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().length()>0){
                    iv_del2.setVisibility(View.VISIBLE);
                }else{
                    iv_del2.setVisibility(View.GONE);
                }
            }
        });
        iv_del1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit_first.setText("");
            }
        });
        iv_del2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit_sec.setText("");
            }
        });
    }
    public AppleEditDialog setTitle(String title) {
        if (title != null) {
            tv_title.setText(title);
        }
        return this;
    }
    public AppleEditDialog setMessage(String msg) {
        if (msg != null) {
            tv_message.setText(msg);
            tv_message.setVisibility(View.VISIBLE);
        }
        return this;
    }
    public AppleEditDialog setEditFirstHint(String msg) {
        if (msg != null) {
            edit_first.setHint(msg);
            edit_first.setVisibility(View.VISIBLE);
        }
        return this;
    }
    public AppleEditDialog setEditSecHint(String msg) {
        if (msg != null) {
            edit_sec.setHint(msg);
            edit_sec.setVisibility(View.VISIBLE);
        }
        return this;
    }
    public AppleEditDialog setPositiveButton(final String text, final OnMyDialogPositiveClickListener listener) {
        if (text != null) {
            tv_positive.setText(text);
        }
        tv_positive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onClick(edit_first.getText().toString(),edit_sec.getText().toString());
                }
                dismiss();
            }
        });
        return this;
    }
    public AppleEditDialog setNegativeButton(String text, final OnMyDialogButtonClickListener listener) {
        if (text != null) {
            tv_negative.setText(text);
            tv_negative.setVisibility(View.VISIBLE);
            ll_edit_sec.setVisibility(View.VISIBLE);
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
    public interface OnMyDialogPositiveClickListener {
        void onClick(String content1,String content2);
    }
    public interface OnMyDialogButtonClickListener {
        void onClick();
    }
}
