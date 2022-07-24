package dev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Mechanism {

	private static List<Integer> layer0 = new LinkedList<>(Collections.nCopies(8, 0));
	private static List<Integer> layer1 = new LinkedList<>(Collections.nCopies(8, 0));
	private static List<Integer> layer2 = new LinkedList<>(Collections.nCopies(8, 0));

	private static List<List<Integer>> board = new ArrayList<>(4);

	public static void main(String[] var) {
		createRandomBoard();
		System.out.println(toString(board));
		move(2, 3, 3);
		System.out.println(toString(board));
	}

	public static void createBoard() {
		board.add(layer0);
		board.add(layer1);
		board.add(layer2);
	}

	private static void createRandomBoard() {
		layer0 = generate(8);
		layer1 = generate(8);
		layer2 = generate(8);

		board.add(layer0);
		board.add(layer1);
		board.add(layer2);
	}

	private static void move(int layer, int pos, int track) {
		// int track could be one of the following, 1 = North
		// 2 = South, 3 = East, 4 = West;

		if (track < 1 || track > 4) {
			throw new IllegalArgumentException("Move cannot be on given track");
		}

		// TODO South
		if (track == 2) {
			boolean case1 = layer == 2 && pos == 1;
			boolean case2 = layer == 2 && (pos == 4 || pos == 6);
			boolean case3 = layer == 1 && (pos == 4 || pos == 6);
			boolean case4 = layer == 0 && (pos == 4 || pos == 5 || pos == 6);

			if (case1 || case2 || case3 || case4) {
				throw new IllegalArgumentException("The supplied position cannot move south");
			}

			int val = board.get(layer).get(pos);

			boolean caseA = pos == 0 || pos == 7;
			boolean caseB = pos == 2 || pos == 3;
			boolean caseC = pos == 1;
			boolean caseD = pos == 5;

			if (caseA) {
				set(layer, pos, 0);
				pos = remainder(pos - 1, 8);
				if (board.get(layer).get(pos) != 0)
					throw new IllegalArgumentException("Cannot move to specified position");
				// System.out.println("Transferring to : (" + layer + ", " + pos + ")");
				set(layer, pos, val);
				return;
			}
			if (caseB) {
				set(layer, pos, 0);
				pos = remainder(pos + 1, 8);
				if (board.get(layer).get(pos) != 0)
					throw new IllegalArgumentException("Cannot move to specified position");
				// System.out.println("Transferring to : (" + layer + ", " + pos + ")");
				set(layer, pos, val);
				return;
			}
			if (caseC) {
				set(layer, pos, 0);
				layer += 1;
				if (board.get(layer).get(pos) != 0)
					throw new IllegalArgumentException("Cannot move to specified position");
				// System.out.println("Transferring to : (" + layer + ", " + pos + ")");
				set(layer, pos, val);
				return;
			}
			if (caseD) {
				set(layer, pos, 0);
				layer -= 1;
				if (board.get(layer).get(pos) != 0)
					throw new IllegalArgumentException("Cannot move to specified position");
				// System.out.println("Transferring to : (" + layer + ", " + pos + ")");
				set(layer, pos, val);
				return;
			}
		}

		// TODO North
		if (track == 1) {
			boolean case1 = layer == 2 && pos == 5;
			boolean case2 = layer == 2 && (pos == 0 || pos == 2);
			boolean case3 = layer == 1 && (pos == 0 || pos == 2);
			boolean case4 = layer == 0 && (pos == 0 || pos == 1 || pos == 2);

			if (case1 || case2 || case3 || case4) {
				throw new IllegalArgumentException("The supplied position cannot move north");
			}

			int val = board.get(layer).get(pos);

			boolean caseA = pos == 6 || pos == 7;
			boolean caseB = pos == 4 || pos == 3;
			boolean caseC = pos == 1;
			boolean caseD = pos == 5;

			if (caseA) {
				set(layer, pos, 0);
				pos = remainder(pos + 1, 8);
				if (board.get(layer).get(pos) != 0)
					throw new IllegalArgumentException("Cannot move to specified position");
				// System.out.println("Transferring to : (" + layer + ", " + pos + ")");
				set(layer, pos, val);
				return;
			}
			if (caseB) {
				set(layer, pos, 0);
				pos = remainder(pos - 1, 8);
				if (board.get(layer).get(pos) != 0)
					throw new IllegalArgumentException("Cannot move to specified position");
				// System.out.println("Transferring to : (" + layer + ", " + pos + ")" + " State
				// = " + val);
				set(layer, pos, val);
				return;
			}
			if (caseC) {
				set(layer, pos, 0);
				layer -= 1;
				if (board.get(layer).get(pos) != 0)
					throw new IllegalArgumentException("Cannot move to specified position");
				// System.out.println("Transferring to : (" + layer + ", " + pos + ")");
				set(layer, pos, val);
				return;
			}
			if (caseD) {
				set(layer, pos, 0);
				layer += 1;
				if (board.get(layer).get(pos) != 0)
					throw new IllegalArgumentException("Cannot move to specified position");
				// System.out.println("Transferring to : (" + layer + ", " + pos + ")");
				set(layer, pos, val);
				return;
			}

		}

		// TODO East
		if (track == 3) {
			boolean case1 = layer == 2 && pos == 7;
			boolean case2 = layer == 2 && (pos == 2 || pos == 4);
			boolean case3 = layer == 1 && (pos == 2 || pos == 4);
			boolean case4 = layer == 0 && (pos == 2 || pos == 3 || pos == 4);

			if (case1 || case2 || case3 || case4) {
				throw new IllegalArgumentException("The supplied position cannot move east");
			}

			int val = board.get(layer).get(pos);

			boolean caseA = pos == 0 || pos == 1;
			boolean caseB = pos == 6 || pos == 5;
			boolean caseC = pos == 3;
			boolean caseD = pos == 7;

			if (caseA) {
				set(layer, pos, 0);
				pos = remainder(pos + 1, 8);
				if (board.get(layer).get(pos) != 0)
					throw new IllegalArgumentException("Cannot move to specified position");
				// System.out.println("Transferring to : (" + layer + ", " + pos + ")");
				set(layer, pos, val);
				return;
			}
			if (caseB) {
				set(layer, pos, 0);
				pos = remainder(pos - 1, 8);
				if (board.get(layer).get(pos) != 0)
					throw new IllegalArgumentException("Cannot move to specified position");
				// System.out.println("Transferring to : (" + layer + ", " + pos + ")");
				set(layer, pos, val);
				return;
			}
			if (caseC) {
				set(layer, pos, 0);
				layer -= 1;
				if (board.get(layer).get(pos) != 0)
					throw new IllegalArgumentException("Cannot move to specified position");
				// System.out.println("Transferring to : (" + layer + ", " + pos + ")");
				set(layer, pos, val);
				return;
			}
			if (caseD) {
				set(layer, pos, 0);
				layer += 1;
				if (board.get(layer).get(pos) != 0)
					throw new IllegalArgumentException("Cannot move to specified position");
				// System.out.println("Transferring to : (" + layer + ", " + pos + ")");
				set(layer, pos, val);
				return;
			}

		}

		// TODO West
		if (track == 4) {
			boolean case1 = layer == 2 && pos == 3;
			boolean case2 = layer == 2 && (pos == 0 || pos == 6);
			boolean case3 = layer == 1 && (pos == 0 || pos == 6);
			boolean case4 = layer == 0 && (pos == 0 || pos == 7 || pos == 6);

			if (case1 || case2 || case3 || case4) {
				throw new IllegalArgumentException("The supplied position cannot move west");
			}

			int val = board.get(layer).get(pos);

			boolean caseA = pos == 1 || pos == 2;
			boolean caseB = pos == 4 || pos == 5;
			boolean caseC = pos == 3;
			boolean caseD = pos == 7;

			if (caseA) {
				set(layer, pos, 0);
				pos = remainder(pos - 1, 8);
				if (board.get(layer).get(pos) != 0)
					throw new IllegalArgumentException("Cannot move to specified position");
				// System.out.println("Transferring to : (" + layer + ", " + pos + ")");
				set(layer, pos, val);
				return;
			}
			if (caseB) {
				set(layer, pos, 0);
				pos = remainder(pos + 1, 8);
				if (board.get(layer).get(pos) != 0)
					throw new IllegalArgumentException("Cannot move to specified position");
				// System.out.println("Transferring to : (" + layer + ", " + pos + ")");
				set(layer, pos, val);
				return;
			}
			if (caseC) {
				set(layer, pos, 0);
				layer += 1;
				if (board.get(layer).get(pos) != 0)
					throw new IllegalArgumentException("Cannot move to specified position");
				// System.out.println("Transferring to : (" + layer + ", " + pos + ")");
				set(layer, pos, val);
				return;
			}
			if (caseD) {
				set(layer, pos, 0);
				layer -= 1;
				if (board.get(layer).get(pos) != 0)
					throw new IllegalArgumentException("Cannot move to specified position");
				// System.out.println("Transferring to : (" + layer + ", " + pos + ")");
				set(layer, pos, val);
				return;
			}

		}
	}

	// TODO INSERT
	public static void insert(int layer, int position, int x) {
		if (board.get(layer).get(position) != 0) {
			throw new IndexOutOfBoundsException("Cannot insert into an occupied square");
		}

		set(layer, position, x);
	}

	private static int remainder(int num, int mod) {
		return (num % mod + mod) % mod;
	}

	private static void set(int layer, int position, int x) {
		System.out.println("New Position = (" + layer + ", " + position + ")" + " , State = " + x);
		if (x != 0 && x != 1 && x != -1)
			throw new IllegalArgumentException("set can only set to 1, -1, or 0");

		// replace the relevant stuffs
		board = new LinkedList<>(replaceList(board, layer, new LinkedList<>(replace(board.get(layer), position, x))));

	}

	public static List<Integer> replace(List<Integer> list, int index, int val) {
		List<Integer> ans = new LinkedList<>();
		for (int i = 0; i < list.size(); i++) {
			if (i == index) {
				ans.add(val);
				continue;
			}
			ans.add(list.get(i));
		}
		return ans;
	}

	public static List<List<Integer>> replaceList(List<List<Integer>> list, int index, List<Integer> val) {
		List<List<Integer>> ans = new LinkedList<>();
		for (int i = 0; i < list.size(); i++) {
			if (i == index) {
				ans.add(val);
				continue;
			}
			ans.add(list.get(i));
		}
		System.out.println("Original : " + list);
		System.out.println("New : " + ans);
		return ans;
	}

	public static String toString(List<List<Integer>> board) {
		StringBuilder sb = new StringBuilder();

		var l1 = board.get(0);
		var l2 = board.get(1);
		var l3 = board.get(2);

		sb.append(l1.get(0)).append("  ");
		sb.append(l1.get(1)).append("  ");
		sb.append(l1.get(2)).append("\n");
		sb.append(" ").append(l2.get(0)).append(" ");
		sb.append(l2.get(1)).append(" ");
		sb.append(l2.get(2)).append("\n");

		sb.append("  ").append(l3.get(0));
		sb.append(l3.get(1));
		sb.append(l3.get(2)).append("\n");

		sb.append(l1.get(7));
		sb.append(l2.get(7));
		sb.append(l3.get(7)).append(" ");
		sb.append(l3.get(3));
		sb.append(l2.get(3));
		sb.append(l1.get(3)).append("\n");

		sb.append("  ").append(l3.get(6));
		sb.append(l3.get(5)).append("");
		sb.append(l3.get(4)).append("\n");
		sb.append(" ").append(l2.get(6)).append(" ");
		sb.append(l2.get(5)).append(" ");
		sb.append(l2.get(4)).append("\n");

		sb.append(l1.get(6)).append("  ");
		sb.append(l1.get(5)).append("  ");
		sb.append(l1.get(4)).append("\n");

		return sb.toString();
	}

	public static void remove(int layer, int pos, int x) {
		if (board.get(layer).get(pos) != x)
			throw new IllegalArgumentException("Something wrong somewhere!");
		set(layer, pos, 0);
	}

	private static List<Integer> generate(int size) {
		List<Integer> list = new ArrayList<>();
		Random rand = new Random();

		for (int i = 0; i < size; i++) {
			int test = rand.nextInt(12);
			if (test < 4) {
				list.add(-1);
			} else if (test < 8) {
				list.add(0);
			} else {
				list.add(1);
			}
		}
		return list;

	}

}
