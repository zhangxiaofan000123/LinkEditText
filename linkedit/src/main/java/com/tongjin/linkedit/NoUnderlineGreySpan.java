package com.tongjin.linkedit;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.UnderlineSpan;

/**
 * Created by zhang on 2017/3/29.
 */

/**
 * 文字有颜色
 */
public class NoUnderlineGreySpan extends UnderlineSpan {

    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setColor(Color.GRAY);
        ds.setUnderlineText(false);
    }
}
