package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Team {
	private String name; // 팀명
	private Mal[] mal;
	public boolean arr[][]; // 말들의 업힌 관계
	Boardgame groupmal = new Boardgame();

	public Team(String name, int numOfmal) {
		this.name = name;
		mal = new Mal[numOfmal];
		for (int i = 0; i < mal.length; i++)
			mal[i] = new Mal();
		// 말들의 업힌 관계를 초기화
		arr = new boolean[numOfmal][numOfmal];
		for (int i = 0; i < numOfmal; i++) {
			for (int j = 0; j < numOfmal; j++) {
				if (i == j)
					arr[i][j] = true;
				else
					arr[i][j] = false;
			}
		}
	}

	// 이동
	public boolean move(int nMal, int nDice) {
		boolean b = false;
		int cnt = 2;
		for (int i = 0; i < this.arr[nMal].length; i++) {
			if (this.arr[nMal][i] == true) {
				cnt++;
			}
		}

		// 해당 말과 업힌 말들의 이동
		for (int i = 0; i < this.arr[nMal].length; i++) {
			if (this.arr[nMal][i] == true) {
				b = mal[i].move(nDice);
				groupmal.groupmove(cnt, i);
			}
		}
		if (group(nMal, mal[nMal].getX(), mal[nMal].getY())) {
			Alert alert = new Alert(AlertType.INFORMATION); // 업었다는 알림창
			alert.setTitle("업기");
			alert.setHeaderText(null);
			alert.setContentText("말을 업었습니다");
			alert.showAndWait();
		}

		return b;
	}

	// 업기
	public boolean group(int nMal, int x, int y) {
		boolean bool = false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[nMal][i] == false) { // 아직 안 업혔고
				if (mal[i].getX() == x && mal[i].getY() == y) { // 동일한 좌표에 있고
					if (mal[nMal].getIsFinish() == false && mal[i].getIsStart() == true) { // 진행중인 말이라면
						this.arr[nMal][i] = true;
						this.arr[i][nMal] = true;
						bool = true;

					}
				}
			}
		}
		return bool;
	}

	// 시작점으로
	public void setReady(int player, int malnum) {
		mal[malnum].setReady(player, malnum);
	}

	// 업힌 정보 설정
	public void setArr(int i, int j, boolean b) {
		arr[i][j] = b;
	}

	public int numOfmal() {
		return mal.length;
	}

	public Mal getMal(int i) {
		return mal[i];
	}

	public String getName() {
		return name;
	}

	public int getX(int i) {
		return mal[i].getX();
	}

	public int getY(int i) {
		return mal[i].getY();
	}

	public boolean getIsFinish(int i) {
		return mal[i].getIsFinish();
	}

	public boolean getIsStart(int i) {
		return mal[i].getIsStart();
	}

}
