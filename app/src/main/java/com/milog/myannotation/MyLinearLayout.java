package com.milog.myannotation;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.milog.annotation.MiloConfig2;
import com.milog.myannotation.annnotation.MiloConfig;

/**
 * Created by miloway on 2018/6/21.
 */

public class MyLinearLayout extends LinearLayout {

    @MiloConfig(R.bool.my_linear_layout_state1)
    @MiloConfig2(R.bool.my_linear_layout_state1)
    private boolean state;

    @MiloConfig(stringType = "string :")
    private String state1;

    @MiloConfig(R.string.my_linear_layout_state)
    private String state2;

    private TextView tvDeal;

    public MyLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        tvDeal = findViewById(R.id.tv_deal);

        init();
        test();
    }

    private void init() {
        Class<?> class1 = MiloConfig.class;

        tvDeal.setText("");
    }

    public void test() {
        System.out.println("MyLinearLayout here");
    }


}
