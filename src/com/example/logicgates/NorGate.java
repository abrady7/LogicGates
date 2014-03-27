package com.example.logicgates;

import android.content.Context;

public class NorGate extends Gate {

	public NorGate(Context c) {
		super(c);
		
	}

	@Override
	public boolean hasPower() {
		
		if (inTop == null || inBottom == null) return false;
		
		return (!inTop.hasPower() && !inBottom.hasPower()); 
		
	}

}