package com.example.logicgates;

import android.content.Context;

public class NotGate extends Gate {
	
	// only use inTop for not gate since only one input

	public NotGate(Context c) {
		super(c);
		
	}

	@Override
	public boolean hasPower() {
		
		if (inTop == null) return false;
		
		return (!inTop.hasPower()); 
		
	}

}
