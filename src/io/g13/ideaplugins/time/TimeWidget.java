package io.g13.ideaplugins.time;

import com.intellij.openapi.wm.CustomStatusBarWidget;
import com.intellij.openapi.wm.StatusBar;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.UUID;

public class TimeWidget implements CustomStatusBarWidget {

	private JLabel myLabel = new JLabel("   00:00   ");

	@Override
	public JComponent getComponent() {
		return myLabel;
	}

	@NotNull
	@Override
	public String ID() {
		return "CurrentTime";
	}

	@Nullable
	@Override
	public WidgetPresentation getPresentation(@NotNull PlatformType platformType) {
		return null;
	}

	@Override
	public void install(@NotNull StatusBar statusBar) {

	}

	@Override
	public void dispose() {

	}
}
