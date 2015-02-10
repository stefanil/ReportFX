package org.devel.reportfx;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
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
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;

public class MainView implements FxmlView<MainViewModel>, Initializable {

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

	@InjectViewModel
	private MainViewModel viewModel;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		duckPane.setRotationAxis(new Point3D(0, 1, 0));
		duckPane.rotateProperty().bind(viewModel.duckRotateProperty());
		menuExportHtml.setAccelerator(KeyCombination.keyCombination("Ctrl+E"));
		menuExportHtml.setOnAction(e -> {
			Report.export();
			final Timeline timeline = new Timeline();
			timeline.setCycleCount(1);
			timeline.getKeyFrames().add(
					new KeyFrame(Duration.millis(500), new KeyValue(
							viewModel.duckRotateProperty(), 360,
							Interpolator.EASE_OUT)));
			timeline.setOnFinished(ae -> viewModel.setDuckRotate(0.0));
			timeline.play();
		});
		menuFileExit.setOnAction(e -> System.exit(0));
	}
}
