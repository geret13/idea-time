package io.g13.ideaplugins.time;

import com.intellij.diagnostic.IdeMessagePanel;
import com.intellij.ide.DataManager;
import com.intellij.openapi.actionSystem.DataConstants;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.wm.StatusBar;
import com.intellij.openapi.wm.WindowManager;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimeComponent implements ProjectComponent {
	private Project project;

	private TimerTask timerTask = new TimerTask() {
		@Override
		public void run() {
			if (timeWidget != null) {
				((JLabel) timeWidget.getComponent()).setText(sdf.format(new Date()));
			}
		}
	};
	private TimeWidget timeWidget;

	private SimpleDateFormat sdf = new SimpleDateFormat("   HH:mm   ");

	public TimeComponent(Project project) {
		this.project = project;
	}

	// Returns the component name (any unique string value).
	@NotNull
	public String getComponentName() {
		return "Time";
	}


	// If you register the MyPluginRegistration class in the <application-components> section of
	// the plugin.xml file, this method is called on IDEA start-up.
	public void initComponent() {
		new Timer().schedule(timerTask, 0, 1000);

	}

	// Disposes system resources.
	public void disposeComponent() {
		timerTask.cancel();
	}

	@Override
	public void projectOpened() {
		StatusBar statusBar = WindowManager.getInstance().getStatusBar(project);

		timeWidget = new TimeWidget();
		statusBar.addWidget(timeWidget, Position);
	}
}
