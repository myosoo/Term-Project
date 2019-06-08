package application;

public class PlayGame {
	// ����
	public boolean[] run(int nMal, int nDice, Player[] team, int play) {
		boolean[] confirm = { false, false }; // 0�ε��� : �� ���� ��, 1�ε��� : ��� ����

		// ���� �̵�
		if (team[play].move(nMal, nDice) == true)
			System.out.println("GOAL IN ~");

		// �� ���
		if (team[play].capture(team[play].getMal(nMal), play, team))
			confirm[0] = true;

		// ��� ����
		if (team[play].win(play, team) == true)
			confirm[1] = true;

		return confirm;
	}

}
