package org.devel.reportfx;

import de.saxsys.mvvmfx.FluentViewLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import de.saxsys.mvvmfx.ViewTuple;


public class Starter extends Application {
	
	
	public static void main(String... args) {
		Application.launch(args);
	}
	
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("ReportFX");

		ViewTuple<MainView, MainViewModel> viewTuple = FluentViewLoader.fxmlView(MainView.class).load();
		
		Parent root = viewTuple.getView();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
