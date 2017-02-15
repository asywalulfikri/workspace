package asywalul.finddifferen.android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

public class TouchImage extends ImageView {
	Paint paint = new Paint();
	Point point = new Point();

	public TouchImage(Context context, AttributeSet attrs) {
		super(context, attrs);
		paint.setColor(Color.BLUE);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(4);
	}

	@SuppressLint("WrongCall")
	protected void onDraw1(Canvas canvas) {
		super.onDraw(canvas);		
		//canvas.drawCircle(point.x, point.y, 50, paint);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			point.x = event.getX();
			point.y = event.getY();
			invalidate();
		}
		return true;
	}

	class Point {
		float x, y;
	}
}