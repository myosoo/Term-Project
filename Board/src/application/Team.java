package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Team {
	private String name; // ����
	private Mal[] mal;
	public boolean arr[][]; // ������ ���� ����
	Boardgame groupmal = new Boardgame();

	public Team(String name, int numOfmal) {
		this.name = name;
		mal = new Mal[numOfmal];
		for (int i = 0; i < mal.length; i++)
			mal[i] = new Mal();
		// ������ ���� ���踦 �ʱ�ȭ
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

	// �̵�
	public boolean move(int nMal, int nDice) {
		boolean b = false;
		int cnt = 2;
		for (int i = 0; i < this.arr[nMal].length; i++) {
			if (this.arr[nMal][i] == true) {
				cnt++;
			}
		}

		// �ش� ���� ���� ������ �̵�
		for (int i = 0; i < this.arr[nMal].length; i++) {
			if (this.arr[nMal][i] == true) {
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
		for (int i = 0; i < arr.length; i++) {
			if (arr[nMal][i] == false) { // ���� �� ������
				if (mal[i].getX() == x && mal[i].getY() == y) { // ������ ��ǥ�� �ְ�
					if (mal[nMal].getIsFinish() == false && mal[i].getIsStart() == true) { // �������� ���̶��
						this.arr[nMal][i] = true;
						this.arr[i][nMal] = true;
						bool = true;

					}
				}
			}
		}
		return bool;
	}

	// ����������
	public void setReady(int player, int malnum) {
		mal[malnum].setReady(player, malnum);
	}

	// ���� ���� ����
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
