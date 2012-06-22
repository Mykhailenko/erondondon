package task6_2;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

public class SequenceHelper {
	private static JProgressBar progressBar = null;
	private static JFrame f;
	public static void show(int percent) {
		if(progressBar == null){
			f = new JFrame("weird process...");
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container content = f.getContentPane();
			progressBar = new JProgressBar();
			progressBar.getModel().setMinimum(0);
			progressBar.getModel().setMaximum(100);
			Border border = BorderFactory.createTitledBorder("Calculating...");
			progressBar.setBorder(border);
			progressBar.setStringPainted(true);
			content.add(progressBar, BorderLayout.NORTH);
			f.setSize(300, 100);
			f.setLocationRelativeTo(null);
			f.setVisible(true);
		}
		if(percent >= 100){
			f.setVisible(false);
		}else{
			f.setVisible(true);
			progressBar.setString(percent + "%");
			progressBar.setValue(percent);
		}
	}
}
