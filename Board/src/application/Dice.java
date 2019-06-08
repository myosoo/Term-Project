package application;

public class Dice {
	public int dice() {
		int dice[] = new int[4];
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			dice[i] = (int) ((Math.random() * 100) % 2);
			if (dice[i] == 0) // 1이 위, 0이 아래
				cnt++;
		}
		if (dice[0] == 0 && dice[1] == 1 && dice[2] == 1 && dice[3] == 1) {
			System.out.println("빽도가 나왔습니다. (뒤로 한 칸)");
			return -1;
		} else if (cnt == 0) {
			System.out.println("모가 나왔습니다. (앞으로 다섯 칸)");
			return 5;
		} else if (cnt == 1) {
			System.out.println("도가 나왔습니다. (앞으로 한 칸)");
			return 1;
		} else if (cnt == 2) {
			System.out.println("개가 나왔습니다. (앞으로 두 칸)");
			return 2;
		} else if (cnt == 3) {
			System.out.println("걸이 나왔습니다. (앞으로 세 칸)");
			return 3;
		} else if (cnt == 4) {
			System.out.println("윷이 나왔습니다. (앞으로 네 칸)");
			return 4;
		}
		return 0;
	}
	
	public int setdice(String select) {
		if (select.equals("빽도")) {
			System.out.println("빽도가 나왔습니다. (뒤로 한 칸)");
			return -1;
		} else if (select.equals("모")) {
			System.out.println("모가 나왔습니다. (앞으로 다섯 칸)");
			return 5;
		} else if (select.equals("도")) {
			System.out.println("도가 나왔습니다. (앞으로 한 칸)");
			return 1;
		} else if (select.equals("개")) {
			System.out.println("개가 나왔습니다. (앞으로 두 칸)");
			return 2;
		} else if (select.equals("걸")) {
			System.out.println("걸이 나왔습니다. (앞으로 세 칸)");
			return 3;
		} else if (select.equals("윷")) {
			System.out.println("윷이 나왔습니다. (앞으로 네 칸)");
			return 4;
		}
		return 0;
	}
}
