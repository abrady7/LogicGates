package com.example.logicgates;

import android.content.Context;
import android.widget.ImageView;

public abstract class Gate implements Power {

	protected Power inTop;
	protected Power inBottom;
	
	protected ImageView image;
	
	public Gate(Context c){
		image = new ImageView(c);
		image.setImageResource(getImgLoc());		
		
	}
	
	public void setTop(Power x){
		this.inTop = x;
	}
	
	public Power getTop(){
		return inTop;
	}
	
	public void setBottom(Power x){
		this.inBottom = x;
	}
	
	public Power getBottom(){
		return inBottom;
	}
	
	protected int getImgLoc(){
		return R.drawable.place;
	}
	
	
}
