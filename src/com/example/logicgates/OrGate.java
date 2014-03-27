package com.example.logicgates;

import android.content.Context;

public class OrGate extends Gate {

	public OrGate(Context c) {
		super(c);
		
	}

	@Override
	public boolean hasPower() {
		
		if (inTop == null || inBottom == null) return false;
		
		return (inTop.hasPower() || inBottom.hasPower()); 
		
	}

}