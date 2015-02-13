package org.devel.reportfx;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import org.devel.reportfx.tasks.JasperReporter;

import de.saxsys.mvvmfx.ViewModel;

public class ReportViewModel implements ViewModel {

	private StringProperty previewFilePath = new SimpleStringProperty(
			ReportViewModel.class.getResource(JasperReporter.EXPORT_URL)
					.toExternalForm());

	public StringProperty previewFilePathProperty() {
		return previewFilePath;
	}

	public String getPreviewFilePath() {
		return previewFilePath.get();
	}

	public void setPreviewFilePath(String previewFilePath) {
		this.previewFilePath.set(previewFilePath);
	}

	private BooleanProperty dirty = new SimpleBooleanProperty(false);

	public BooleanProperty dirtyProperty() {
		return dirty;
	}

	public boolean isDirty() {
		return dirty.get();
	}

	public void setDirty(boolean dirty) {
		this.dirty.set(dirty);
	}

}
