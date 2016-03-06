package com.xuexiang.viewpager.fragment;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.SurfaceHolder.Callback;
import android.widget.Toast;
public class MySurfaceView extends SurfaceView implements Callback, Runnable {
	private Thread th;
	private SurfaceHolder sfh;
	private Canvas canvas;
	private Paint paint;
	private boolean flag;
	//固定摇杆背景圆形的X,Y坐标以及半径
	private int RockerCircleX = 540;
	private int RockerCircleY = 800;
	private int RockerCircleR = 300;
	//摇杆的X,Y坐标以及摇杆的半径
	private float SmallRockerCircleX = 540;
	private float SmallRockerCircleY = 800;
	private float SmallRockerCircleR = 80;
	public MySurfaceView(Context context){
		super(context);
		Log.v("Himi", "MySurfaceView");
		this.setKeepScreenOn(true);
		sfh = this.getHolder();
		sfh.addCallback(this);
		paint = new Paint();
		paint.setAntiAlias(true);
		setFocusable(true);
		setFocusableInTouchMode(true);
		draw();
		/*测试代码*/
		/*canvas = sfh.lockCanvas();
		canvas.drawColor(Color.WHITE);
		//测试
		paint.setColor(Color.BLACK);
		//绘制摇杆背景
		canvas.drawCircle(200, 200, 50, paint);
		sfh.unlockCanvasAndPost(canvas);*/
		
	}
	public void surfaceCreated(SurfaceHolder holder) {
		th = new Thread(this);
		flag = true;
		th.start();
	}
	/***
	 * 得到两点之间的弧度
	 */
	public double getRad(float px1, float py1, float px2, float py2) {
		//得到两点X的距离
		float x = px2 - px1;
		//得到两点Y的距离
		float y = py1 - py2;
		//算出斜边长
		float xie = (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		//得到这个角度的余弦值（通过三角函数中的定理 ：邻边/斜边=角度余弦值）
		float cosAngle = x / xie;
		//通过反余弦定理获取到其角度的弧度
		float rad = (float) Math.acos(cosAngle);
		//注意：当触屏的位置Y坐标<摇杆的Y坐标我们要取反值-0~-180
		if (py2 < py1) {
			rad = -rad;
		}
		return rad;
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN || 
					event.getAction() == MotionEvent.ACTION_MOVE) {
			// 当触屏区域不在活动范围内
			if (Math.sqrt(Math.pow((RockerCircleX - (int) event.getX()), 2) 
					+ Math.pow((RockerCircleY - (int) event.getY()), 2)) >= RockerCircleR) {
				//得到摇杆与触屏点所形成的角度
				double tempRad = getRad(RockerCircleX, RockerCircleY, event.getX(), event.getY());
				//保证内部小圆运动的长度限制
				getXY(RockerCircleX, RockerCircleY, RockerCircleR, tempRad);
			} else {//如果小球中心点小于活动区域则随着用户触屏点移动即可
				SmallRockerCircleX = (int) event.getX();
				SmallRockerCircleY = (int) event.getY();
			}
		} else if (event.getAction() == MotionEvent.ACTION_UP) {
			//当释放按键时摇杆要恢复摇杆的位置为初始位置
			SmallRockerCircleX = 540;
			SmallRockerCircleY = 800;
		}
		return true;
	}
	/**
	 * 
	 * @param R
	 *            圆周运动的旋转点
	 * @param centerX
	 *            旋转点X
	 * @param centerY
	 *            旋转点Y
	 * @param rad
	 *            旋转的弧度
	 */
	public void getXY(float centerX, float centerY, float R, double rad) {
		//获取圆周运动的X坐标 
		SmallRockerCircleX = (float) (R * Math.cos(rad)) + centerX;
		//获取圆周运动的Y坐标
		SmallRockerCircleY = (float) (R * Math.sin(rad)) + centerY;
	}
	public void draw() {
		try {
			canvas = sfh.lockCanvas();
			canvas.drawColor(Color.WHITE);  //test
			//设置透明度
			paint.setColor(Color.BLACK);
			//绘制摇杆背景
			canvas.drawCircle(RockerCircleX, RockerCircleY, RockerCircleR, paint);
			paint.setColor(Color.RED);
			//绘制摇杆
			canvas.drawCircle(SmallRockerCircleX, SmallRockerCircleY, 
					SmallRockerCircleR, paint);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (canvas != null)
					sfh.unlockCanvasAndPost(canvas);
			} catch (Exception e2) {
			}
		}
	}
	public void run() {
		// TODO Auto-generated method stub
		while (flag) {
			draw();
			try {
				Thread.sleep(50);
			} catch (Exception ex) {
			}
		}
	}
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		Log.v("Himi", "surfaceChanged");
	}
	public void surfaceDestroyed(SurfaceHolder holder) {
		flag = false;
		Log.v("Himi", "surfaceDestroyed");
	}
}