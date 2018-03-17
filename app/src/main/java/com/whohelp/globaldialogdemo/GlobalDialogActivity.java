package com.whohelp.globaldialogdemo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * 思路就是通过非 Activity 的 Context 来启动一个透明 activity，
 * 然后使用这个 activity 来显示一个 dialog
 */
public class GlobalDialogActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, GlobalDialogActivity.class);
        //设置启动方式
        starter.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global_dialog);
        //显示dialog
        new AlertDialog.Builder(this)
                .setTitle("全局dialog")
                .setMessage("这是一个全局dialog")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setCancelable(false)
                .show();
    }
}
