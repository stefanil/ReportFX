package org.devel.reportfx;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;

public class ReportView implements FxmlView<ReportViewModel>, Initializable {

	@FXML
	private WebView preview;

	@InjectViewModel
	private ReportViewModel viewModel;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		viewModel.dirtyProperty().addListener(obs -> loadPreview());
	}

	public void showPreview() {
		viewModel.setDirty(true);
	}

	private void loadPreview() {
		if (!viewModel.isDirty()
				|| viewModel.getPreviewFilePath().trim().isEmpty())
			return;
		preview.getEngine().load(viewModel.getPreviewFilePath());
		viewModel.setDirty(false);
	}

}
