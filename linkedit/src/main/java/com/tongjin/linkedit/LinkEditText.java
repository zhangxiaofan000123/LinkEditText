package com.tongjin.linkedit;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.Spanned;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;


/**
 * Created by user on 2016/12/14.
 */

public class LinkEditText extends EditText {
    private static final String TAG = "CopyEditext";
    public Context mContext;

    public int type = EDITE;

    public static final int SHOW = 0;
    public static final int EDITE = 1;


    public LinkEditText(Context context) {
        this(context, null);
    }

    public LinkEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LinkEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mask = getAutoLinkMask();
        mContext = context;
        init();
    }

    private int mask = 0;


    public void init() {
        Log.i(TAG, "init: mask " + mask);
        switch (type) {
            case SHOW:

                setAutoLinkMask(mask);
                setHint("");
                setFocusable(false);
                setFocusableInTouchMode(true);
                setTextIsSelectable(true);
                setLinksClickable(true);
                setBackgroundResource(R.drawable.oa_editext_show_shape);
                setTextColor(Color.GRAY);
                if (mask != 0) {
                    NoUnderlineBlueSpan mNoUnderlineBlueSpan = new NoUnderlineBlueSpan();
                    if (this.getText() instanceof Spannable) {
                        Spannable s = this.getText();
                        s.setSpan(mNoUnderlineBlueSpan, 0, s.length(), Spanned.SPAN_MARK_MARK);
                    }
                } else {
                    NoUnderlineGreySpan mNoUnderlineGreySpan = new NoUnderlineGreySpan();
                    if (this.getText() instanceof Spannable) {
                        Spannable s = this.getText();
                        s.setSpan(mNoUnderlineGreySpan, 0, s.length(), Spanned.SPAN_MARK_MARK);
                    }
                }

                break;
            case EDITE:
                setLinksClickable(false);
                setEnabled(true);
                setFocusable(true);
                setFocusableInTouchMode(true);
                requestFocus();
                requestFocusFromTouch();
                setBackgroundResource(R.drawable.oa_editext_edit_shape);
                NoUnderlineSpan mNoUnderlineSpan = new NoUnderlineSpan();
                if (this.getText() instanceof Spannable) {
                    Spannable s = this.getText();
                    s.setSpan(mNoUnderlineSpan, 0, s.length(), Spanned.SPAN_MARK_MARK);
                }

                break;
            default:
                break;
        }


    }


    public void setType(int type) {
        LinkEditText.this.type = type;
        init();
    }

    public int getType() {
        return type;
    }

    @Override
    public void setOnClickListener(OnClickListener l) {
        this.setEnabled(true);
        super.setOnClickListener(l);
    }


}
