package org.devel.reportfx;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.util.Duration;

import org.devel.reportfx.tasks.JasperReporter;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;

public class MainView implements FxmlView<MainViewModel>, Initializable {

	@FXML
	private ReportView reportViewController;

	@InjectViewModel
	private MainViewModel viewModel;

	@FXML
	private MenuItem menuExportHtml;

	@FXML
	private MenuItem menuFileExit;

	@FXML
	private AnchorPane duckPane;

	@FXML
	private MeshView duckView;

	@FXML
	private PhongMaterial duckMaterial;

	@FXML
	private TriangleMesh duckMesh;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		duckPane.setRotationAxis(new Point3D(0, 1, 0));
		duckPane.rotateProperty().bind(viewModel.duckRotateProperty());
		menuExportHtml.setAccelerator(KeyCombination.keyCombination("Ctrl+E"));
		menuExportHtml.setOnAction(e -> handleExport());
		menuFileExit.setOnAction(e -> System.exit(0));
	}

	private void handleExport() {
		// progress view
		duckView.setOpacity(1);
		final Timeline timeline = new Timeline();
		timeline.setCycleCount(1);
		timeline.getKeyFrames().addAll(
				new KeyFrame(Duration.millis(2000), new KeyValue(
						viewModel.duckRotateProperty(), 360,
						Interpolator.EASE_BOTH)));
		timeline.setOnFinished(ae -> {
			viewModel.setDuckRotate(0.0);
			duckView.setOpacity(0);
		});
		timeline.play();
		new Thread(new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				// export report (TODO)
				JasperReporter.export();
				Platform.runLater(()->reportViewController.showPreview());
				return null;
			}
		}).start();
	}
	
}
