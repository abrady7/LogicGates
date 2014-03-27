package com.example.logicgates;

import android.content.Context;

public class XorGate extends Gate {

	public XorGate(Context c) {
		super(c);
		
	}

	@Override
	public boolean hasPower() {
		
		if (inTop == null || inBottom == null) return false;
		
		if ((inTop.hasPower() && !inBottom.hasPower()) || (!inTop.hasPower() && inBottom.hasPower())) return true;
		
		return false;
		
	}
	
}