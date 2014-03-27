package com.example.logicgates;

import android.os.Bundle;
import android.app.Activity;
import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.view.DragEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		findViewById(R.id.image0).setOnLongClickListener(new MyTouchListener());
	    findViewById(R.id.image1).setOnLongClickListener(new MyTouchListener());
	    findViewById(R.id.image2).setOnLongClickListener(new MyTouchListener());
	    findViewById(R.id.image3).setOnLongClickListener(new MyTouchListener());
	    findViewById(R.id.image4).setOnLongClickListener(new MyTouchListener());
	    findViewById(R.id.image5).setOnLongClickListener(new MyTouchListener());
	    findViewById(R.id.image6).setOnLongClickListener(new MyTouchListener());
	    findViewById(R.id.image7).setOnLongClickListener(new MyTouchListener());
	    findViewById(R.id.image8).setOnLongClickListener(new MyTouchListener());
	    	    	    
	    findViewById(R.id.con0_0).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con0_1).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con0_2).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con0_3).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con0_4).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con0_5).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con1_0).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con1_1).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con1_2).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con1_3).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con1_4).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con1_5).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con2_0).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con2_1).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con2_2).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con2_3).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con2_4).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con2_5).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con3_0).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con3_1).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con3_2).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con3_3).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con3_4).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con3_5).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con4_0).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con4_1).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con4_2).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con4_3).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con4_4).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con4_5).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con5_0).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con5_1).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con5_2).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con5_3).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con5_4).setOnDragListener(new MyDragListener());
	    findViewById(R.id.con5_5).setOnDragListener(new MyDragListener());
	}
	    
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private final class MyTouchListener implements OnLongClickListener {
	    public boolean onLongClick(View view) {
	    	ClipData data = ClipData.newPlainText("", "");
	    	DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
	    	view.startDrag(data, shadowBuilder, view, 0);
	    	view.setVisibility(View.VISIBLE);
	    	return true;
	    }
	}

	class MyDragListener implements OnDragListener {
		Drawable enterShape = getResources().getDrawable(R.drawable.shape_droptarget);
	    Drawable normalShape = getResources().getDrawable(R.drawable.shape);

	    @Override
	    public boolean onDrag(View v, DragEvent event) {
	    	int action = event.getAction();
	    	switch (action) {
	    	case DragEvent.ACTION_DRAG_STARTED:
	    		// do nothing
	    		break;
	    	case DragEvent.ACTION_DRAG_ENTERED:
	    		v.setBackground(enterShape);
	    		break;
	    	case DragEvent.ACTION_DRAG_EXITED:
	    		v.setBackground(normalShape);
	    		break;
	    	case DragEvent.ACTION_DROP:
	    		
	    		View view = (View) event.getLocalState();
	    		Drawable copyImage = ((ImageView) view).getDrawable();
	    		ImageView image = new ImageView(MainActivity.this);
	    		image.setImageDrawable(copyImage);
	    		ViewGroup owner = (ViewGroup) view.getParent();
	    		owner.removeView(view);
	    		LinearLayout container = (LinearLayout) v;
	    		container.addView(image);
	    		view.setVisibility(View.VISIBLE);
	    		owner.addView(view);
	    		break;
	    	case DragEvent.ACTION_DRAG_ENDED:
	    		v.setBackground(normalShape);
	    	default:
	    		break;
	    	}
	    	return true;
	    }
	}
}
