package innoviz.niec.com.musicui.graphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;

/**
 * Created by PROPHET on 31-08-2016.
 */
public class Anim extends View {
    private ShapeDrawable mDrawable;
    public Anim(Context context) {
        super(context);
        int x=100;
        int y=100;
        int width=100;
        int height=100;
        mDrawable=new ShapeDrawable(new OvalShape());
        mDrawable.getPaint().setColor(0xff744C23);
        mDrawable.setBounds(x,y,x+width,y+height);




    }

    @Override
    protected void onDraw(Canvas c){
    mDrawable.draw(c);

    }
}
