package bmo5.bmo5tests.tools;

import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.Relative;
import org.sikuli.api.ScreenLocation;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.robot.Keyboard;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopKeyboard;
import org.sikuli.api.robot.desktop.DesktopMouse;
import org.sikuli.api.visual.Canvas;
import org.sikuli.api.visual.DesktopCanvas;
import org.sikuli.api.visual.ScreenPainter;

public class SikuliApi {

	public static ScreenRegion screen = new DesktopScreenRegion();
	public static Canvas canvas = new DesktopCanvas();
	public static Mouse mouse = new DesktopMouse();
	public static Keyboard keyboard = new DesktopKeyboard();
	static ScreenPainter painter = new ScreenPainter();

	public static void cancelPrint() {
		screen.wait(new ImageTarget(SikuliPictures.CancelButton), Constants.Wait_Time);
		ScreenRegion shop = screen.find(new ImageTarget(SikuliPictures.CancelButton));
		ScreenLocation shopButton = Relative.to(shop).center().getScreenLocation();
		mouse.doubleClick(shopButton);
	}
}
