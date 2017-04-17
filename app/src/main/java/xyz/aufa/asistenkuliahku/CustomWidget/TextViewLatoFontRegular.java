package xyz.aufa.asistenkuliahku.CustomWidget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by SENSODYNE on 18/04/2017.
 */

public class TextViewLatoFontRegular extends android.support.v7.widget.AppCompatTextView{

    public TextViewLatoFontRegular(Context context) {
        super(context);
        init();
    }

    public TextViewLatoFontRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextViewLatoFontRegular(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Lato-Regular.ttf");
            setTypeface(tf);
        }
    }

}
