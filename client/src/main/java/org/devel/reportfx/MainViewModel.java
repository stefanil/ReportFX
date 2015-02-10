package org.devel.reportfx;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import de.saxsys.mvvmfx.ViewModel;

public class MainViewModel implements ViewModel {
	
	private DoubleProperty duckRotateProperty = new SimpleDoubleProperty(0);
	
	public DoubleProperty duckRotateProperty() {
		return duckRotateProperty;
	}
	
	public Double getDuckRotate() {
		return duckRotateProperty.get();
	}
	
	public void setDuckRotate(Double duckRotate) {
		duckRotateProperty.set(duckRotate);
	}
	
}
