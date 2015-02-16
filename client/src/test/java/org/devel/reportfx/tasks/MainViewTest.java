package org.devel.reportfx.tasks;

import javafx.scene.Parent;
import javafx.scene.input.KeyCode;

import org.devel.reportfx.MainView;
import org.junit.Test;
import org.loadui.testfx.GuiTest;

import de.saxsys.mvvmfx.FluentViewLoader;


public class MainViewTest extends GuiTest {

	@Override
	protected Parent getRootNode() {
		return FluentViewLoader.fxmlView(MainView.class).load().getView();
	}
	
	@Test
	public void generateReportTest() {
		release(KeyCode.CONTROL, KeyCode.E);
	}

}
