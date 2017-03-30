package com.tongjin.linkedit;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.UnderlineSpan;

/**
 * Created by zhang on 2017/3/29.
 */

public class NoUnderlineSpan extends UnderlineSpan {

    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setColor(Color.BLACK);
        ds.setUnderlineText(false);
    }
}
