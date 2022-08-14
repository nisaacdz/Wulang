package dev;

class Point {
	/*
	 * Activation can be 0 to mean an empty corner, 1 to mean a corner with one
	 * piece from player 1 or -1 to mean a corner with one piece from player 2
	 */
	int acitivation = 0;

	Point left, right, top, down;
}

public class TempPack {

	public static void main(String[] args) {
		// Top layer
		Point topL = new Point();
		Point topR = new Point();
		Point topC = new Point();

		// Second layer
		Point tp1L = new Point();
		Point tp1R = new Point();
		Point tp1C = new Point();

		// Third layer
		Point tp2L = new Point();
		Point tp2R = new Point();
		Point tp2C = new Point();

		// Bottom layer
		Point botL = new Point();
		Point botR = new Point();
		Point botC = new Point();

		// Bottom but one layer
		Point bt1L = new Point();
		Point bt1R = new Point();
		Point bt1C = new Point();

		// Bottom but two layer
		Point bt2L = new Point();
		Point bt2R = new Point();
		Point bt2C = new Point();

		// Left and Right side
		Point lefL = new Point();
		Point lefC = new Point();
		Point lefR = new Point();
		Point rigR = new Point();
		Point rigL = new Point();
		Point rigC = new Point();

		topL.right = topC;
		topL.down = lefL;

		topC.left = topL;
		topC.right = topR;
		topC.down = tp1C;

		topR.left = topC;
		topR.down = rigR;

		tp1L.right = tp1C;
		tp1L.down = lefC;

		tp1C.left = tp1L;
		tp1C.top = topC;
		tp1C.down = tp2C;
		tp1C.right = tp1R;

		tp1R.left = tp1C;
		tp1R.down = rigC;

		tp2L.right = tp2C;
		tp2L.down = lefR;

		tp2C.left = tp2L;
		tp2C.right = tp2R;
		tp2C.top = tp1C;

		tp2R.left = tp2C;
		tp2R.down = rigL;

		lefL.top = topL;
		lefL.down = botL;
		lefL.right = lefC;

		lefC.left = lefL;
		lefC.top = tp1L;
		lefC.down = bt1L;
		lefC.right = lefR;

		lefR.left = lefC;
		lefR.top = tp2L;
		lefR.down = bt2L;

		rigR.top = topR;
		rigR.down = botR;
		rigR.left = rigC;

		rigC.left = rigL;
		rigC.right = rigR;
		rigC.top = tp1R;
		rigC.down = bt1R;

		rigL.top = tp2R;
		rigL.down = bt2R;
		rigR.right = rigC;

		botL.top = lefC;
		botL.right = botC;

		botC.left = botL;
		botC.right = botR;
		botC.top = bt1C;

		botR.top = rigC;
		botR.left = botC;
		botR.top = bt1C;

		bt1L.top = lefC;
		bt1L.right = bt1C;

		bt1R.top = rigC;
		bt1R.left = bt1C;

		bt1C.left = bt1L;
		bt1C.right = bt1R;
		bt1C.top = bt2C;
		bt1C.down = botC;

		bt2L.top = lefR;
		bt2L.right = bt2C;

		bt2R.top = rigL;
		bt2R.left = bt2C;

		bt2C.left = bt2L;
		bt2C.right = bt2R;
		bt2C.down = bt1C;
		
		
	}
	
	

}
