package com.klassroomtask1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.LineBackgroundSpan;
import android.util.Log;

/**
 * Created by Avdhesh AKhani on 10/11/2016.
 */
public class TextBackgroundSpan  implements LineBackgroundSpan {

    private final Paint paint;
    private RectF rectF = new RectF();

    public TextBackgroundSpan() {
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
    }

    @Override
    public void drawBackground(Canvas c, Paint p, int left, int right, int top, int baseline, int bottom, CharSequence text, int start, int end, int lnum) {

        float charx = left;
        for (int i = start; i < end; i++) {
            String charAt = extractText(text, i, i + 1);
            float charWidth = p.measureText(charAt);

            Paint.FontMetrics fontMetrics = p.getFontMetrics();
/*
            Log.e("Char width",charWidth+"");
            Log.e("LetterLineBackgroundSpa", "drawBackground()"+lnum);
            Log.e("Font Metrics",fontMetrics+"");*/

            rectF.set(charx, baseline+fontMetrics.ascent+5, (charx += charWidth), baseline+fontMetrics.descent-5);
            c.drawRect(rectF, paint);
        }
    }

    private String extractText(CharSequence text, int start, int end) {
        return text.subSequence(start, end).toString();
    }

}