package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Player {
	private String name; // ����
	private Mal[] mal;
	public boolean grouping[][]; // ������ ���� ����
	Boardgame groupmal = new Boardgame();

	public Player(String name, int numOfmal) {
		this.name = name;
		mal = new Mal[numOfmal];
		for (int i = 0; i < mal.length; i++)
			mal[i] = new Mal();
		// ������ ���� ���踦 �ʱ�ȭ
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

	// �̵�
	public boolean move(int nMal, int nDice) {
		boolean b = false;
		int cnt = 2;
		for (int i = 0; i < this.grouping[nMal].length; i++) {
			if (this.grouping[nMal][i] == true) {
				cnt++;
			}
		}

		// �ش� ���� ���� ������ �̵�
		for (int i = 0; i < this.grouping[nMal].length; i++) {
			if (this.grouping[nMal][i] == true) {
				b = mal[i].move(nDice);
				groupmal.groupmove(cnt, i);
			}
		}
		if (group(nMal, mal[nMal].getX(), mal[nMal].getY())) {
			Alert alert = new Alert(AlertType.INFORMATION); // �����ٴ� �˸�â
			alert.setTitle("����");
			alert.setHeaderText(null);
			alert.setContentText("���� �������ϴ�");
			alert.showAndWait();
		}

		return b;
	}

	// ����
	public boolean group(int nMal, int x, int y) {
		boolean bool = false;
		for (int i = 0; i < grouping.length; i++) {
			if (grouping[nMal][i] == false) { // ���� �� ������
				if (mal[i].getX() == x && mal[i].getY() == y) { // ������ ��ǥ�� �ְ�
					if (mal[nMal].getIsFinish() == false && mal[i].getIsStart() == true) { // �������� ���̶��
						this.grouping[nMal][i] = true;
						this.grouping[i][nMal] = true;
						bool = true;

					}
				}
			}
		}
		return bool;
	}
	
	// �ٸ� �� �� ���
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

							// ���� ���� �ʱ�ȭ
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
	
	// ��� ����
		public boolean win(int i, Player[] team) {
			for (int j = 0; j <= team[i].numOfmal(); j++) {
				if (team[i].numOfmal() == j) {
					return true;
				} else if (team[i].getIsFinish(j) == false)
					break;
			}
			return false;
		}

	// ����������
	public void setReady(int player, int malnum) {
		mal[malnum].setReady(player, malnum);
	}

	// ���� ���� ����
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
