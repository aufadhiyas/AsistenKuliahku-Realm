package xyz.aufa.asistenkuliahku.CustomWidget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by SENSODYNE on 18/04/2017.
 */

public class TextViewLatoFontMedium extends android.support.v7.widget.AppCompatTextView{
    public TextViewLatoFontMedium(Context context) {
        super(context);
    }

    public TextViewLatoFontMedium(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TextViewLatoFontMedium(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Lato-Medium.ttf");
            setTypeface(tf);
        }
    }

}
