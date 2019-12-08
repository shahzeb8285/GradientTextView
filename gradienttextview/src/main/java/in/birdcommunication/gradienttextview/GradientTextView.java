package in.birdcommunication.gradienttextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;


public class GradientTextView extends AppCompatTextView {
    public GradientTextView(Context context) {
        super(context);
    }



    private int[] mColors={getResources().getColor(R.color.colorStart),
            getResources().getColor(R.color.colorEnd)};

    private int mAngle = 0;

    private DIRECTION mDIRECTION;

    public enum DIRECTION {
        LEFT(0),
        TOP(90),
        RIGHT(180),
        BOTTOM(270);

        int angle;
        DIRECTION(int angle) {
            this.angle = angle;
        }
    }


    public GradientTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public GradientTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mColors != null) {
            int[] xyPositions = calculateGradientPositions(w, h);
            Shader shader= new LinearGradient(xyPositions[0], xyPositions[1], xyPositions[2],
                    xyPositions[3], mColors, null, Shader.TileMode.CLAMP);
            getPaint().setShader(shader);
        }

    }

    private int[] calculateGradientPositions(int w, int h) {
        if (mDIRECTION != null) {
            switch (mDIRECTION) {
                case TOP:
                    return new int[]{0, h, 0, 0};
                case RIGHT:
                    return new int[]{0, 0, w, 0};
                case BOTTOM:
                    return new int[]{0, 0, 0, h};
                case LEFT:
                default:
                    return new int[]{w, 0, 0, 0};
            }
        }
        return new int[]{0, 0, 0, 0};
    }

    private void init(Context context, AttributeSet attributeSet) {
        final TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.GradientTextView);


        try {


            int  font = typedArray.getResourceId(R.styleable.GradientTextView_fontFamily, 0);
            Typeface typeface;
            if(font != 0){
                Log.i("fddvc", "init:fds ");
                typeface = ResourcesCompat.getFont(context, font);
            }else{
                typeface = ResourcesCompat.getFont(context, R.font.amaranth_bold);
            }
            setTypeface(typeface);

            int startColor = typedArray.getColor(R.styleable.GradientTextView_gt_start_color, 0);
            int color = typedArray.getColor(R.styleable.GradientTextView_gt_start_color, 0);
            if (startColor != 0) {
                mColors[0] = color;
            }
            int endColor = typedArray.getColor(R.styleable.GradientTextView_gt_end_color, 0);
            if (endColor != 0) {
                mColors[1] =endColor;
            }

            if (typedArray.hasValue(R.styleable.GradientTextView_gt_direction)) {
                int value = typedArray.getInt(R.styleable.GradientTextView_gt_direction, 0);
                mDIRECTION = DIRECTION.values()[value];
            }else{
                mDIRECTION = DIRECTION.LEFT;
            }

            if (typedArray.hasValue(R.styleable.GradientTextView_gt_angle)) {
                mAngle = typedArray.getInt(R.styleable.GradientTextView_gt_angle, 0);
            }

        } finally {
            typedArray.recycle();
        }


    }
}