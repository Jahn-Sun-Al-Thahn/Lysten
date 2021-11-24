import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.*;

public class Pad extends JButton{

	public Pad() {
		this.setText("Pad");
		this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		this.setSize(40, 40);
		this.setBackground(Color.yellow);
	}

	public static void main(String[] arg) {
		new Pad();
	}
}
