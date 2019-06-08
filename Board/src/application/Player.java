package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Player {
	private String name; // 팀명
	private Mal[] mal;
	public boolean grouping[][]; // 말들의 업힌 관계
	Boardgame groupmal = new Boardgame();

	public Player(String name, int numOfmal) {
		this.name = name;
		mal = new Mal[numOfmal];
		for (int i = 0; i < mal.length; i++)
			mal[i] = new Mal();
		// 말들의 업힌 관계를 초기화
		grouping = new boolean[numOfmal][numOfmal];
		for (int i = 0; i < numOfmal; i++) {
			for (int j = 0; j < numOfmal; j++) {
				if (i == j)
					grouping[i][j] = true;
				else
					grouping[i][j] = false;
			}
		}
	}

	// 이동
	public boolean move(int nMal, int nDice) {
		boolean b = false;
		int cnt = 2;
		for (int i = 0; i < this.grouping[nMal].length; i++) {
			if (this.grouping[nMal][i] == true) {
				cnt++;
			}
		}

		// 해당 말과 업힌 말들의 이동
		for (int i = 0; i < this.grouping[nMal].length; i++) {
			if (this.grouping[nMal][i] == true) {
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
		for (int i = 0; i < grouping.length; i++) {
			if (grouping[nMal][i] == false) { // 아직 안 업혔고
				if (mal[i].getX() == x && mal[i].getY() == y) { // 동일한 좌표에 있고
					if (mal[nMal].getIsFinish() == false && mal[i].getIsStart() == true) { // 진행중인 말이라면
						this.grouping[nMal][i] = true;
						this.grouping[i][nMal] = true;
						bool = true;

					}
				}
			}
		}
		return bool;
	}
	
	// 다른 팀 말 잡기
	public boolean capture(Mal mal, int nTeam, Player[] team) {
		Boardgame btn = new Boardgame();
		boolean bool = false;
		for (int k = 0; k < team.length; k++) {
			if (k != nTeam) {
				for (int i = 0; i < team[k].numOfmal(); i++) {
					int x = team[k].getX(i);
					int y = team[k].getY(i);
					if (mal.getX() == x && mal.getY() == y) {
						if (team[k].getIsStart(i) == true && team[k].getIsFinish(i) == false) {
							team[k].setReady(k, i);
							btn.malposition(k, i, team);

							// 업은 말들 초기화
							for (int j = 0; j < team[k].numOfmal(); j++) {
								team[k].setgrouping(i, j, false);
							}
							team[k].setgrouping(i, i, true);
							bool = true;
						}
					}
				}
			}
		}
		if(bool)
			return true;
		return false;
	}
	
	// 우승 여부
		public boolean win(int i, Player[] team) {
			for (int j = 0; j <= team[i].numOfmal(); j++) {
				if (team[i].numOfmal() == j) {
					return true;
				} else if (team[i].getIsFinish(j) == false)
					break;
			}
			return false;
		}

	// 시작점으로
	public void setReady(int player, int malnum) {
		mal[malnum].setReady(player, malnum);
	}

	// 업힌 정보 설정
	public void setgrouping(int i, int j, boolean b) {
		grouping[i][j] = b;
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
