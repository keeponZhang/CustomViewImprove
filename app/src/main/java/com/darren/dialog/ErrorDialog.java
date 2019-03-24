package com.darren.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.darren.view_day01.R;

/*match_parent布局文件中,不起作用，会显示成wrap_content效果*/
public class ErrorDialog extends Dialog {
    public ErrorDialog(Context context) {
        this(context,0);
    }

    public ErrorDialog(Context context, int themeResId) {
        super(context, R.style.myDialog);


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialog);
        Window window = getWindow();
//        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
    }
}