package application;

import javafx.scene.control.Button;

public class Mal {
	private int x, y; // 7x7 ��� ��ǥ
	Button malname;
	private boolean isStart; // ������� �������� ����
	private boolean isFinish;

	public Mal() {
		this.x = 550;
		this.y = 550;
		isFinish = false;
		isStart = false;
	}

	// �̵�
	public boolean move(int n) {
		// ����
		if (n == -1) {
			if (isStart == false) {
				x = 550;
				y = 550;
				isStart = true;
			} else if (x == 550 && y != 550) {
				y += 100;
			} else if (y == 550 && x != 50) {
				x -= 100;
			} else if (x == 50 && y != 50) {
				y -= 100;
			} else if (y == 50 && x != 550) {
				x += 100;
			} else if (x == y) {
				x -= 80;
				y -= 80;

				if (x == 390 || x == 300) {
					x -= 10;
					y -= 10;
				}
			} else if (x + y == 600) {
				x += 80;
				y -= 80;

				if (x == 300 || x == 210) {
					x += 10;
					y -= 10;
				}
			}
		}
		// ���� �밢��
		else if (x == y && isStart == true) {
			for (int i = 0; i < n; i++) {
				x += 80;
				y += 80;

				if (x == 210 || x == 300) {
					x += 10;
					y += 10;
				}

				// ����
				if (x == 550) {
					x = 1100;
					y = 1100;
					isFinish = true;
					return true;
				}
			}
		}
		// ������ �밢��
		else if (x + y == 600 && x != 50) {
			if(x==300 && y==300) {
				if(n==1) {
					x=390;
					y=390;
				}
				else if(n==2) {
					x=470;
					y=470;
				}
				else if(n==3) {
					x=550;
					y=550;
				}
				else if(n>=4) {
					// ����
					if (x > 550 && x < 720) {
						x = 1100;
						y = 1100;
						isFinish = true;
						return true;
					}
				}
			}
			for (int i = 0; i < n; i++) {
				if (y == 550) {
					x += 100;
				} 
				else {
					x -= 80;
					y += 80;
					if (x == 390 || x == 300) {
						x -= 10;
						y += 10;
					}
				}
			}

		}
		// �簢�� �׵θ�
		else {
			for (int i = 0; i < n; i++) {
				if (x == 550) {
					if (y == 550 && isStart == true)
						x += 100;
					else if (y == 50)
						x -= 100;
					else
						y -= 100;
				} else if (y == 50) {
					if (x == 50)
						y += 100;
					else
						x -= 100;
				} else if (x == 50) {
					if (y == 550)
						x += 100;
					else
						y += 100;
				} else if (y == 550) {
					x += 100;
				} 
				
				// ���� ���� �ٽ� ���� �� ���
				else if (x >= 720 && y >= 450 && isStart == false) { 
					if (n == -1) {
						x = 550;
						y = 550;
					} else if (n == 1) {
						x = 550;
						y = 450;
					} else if (n == 2) {
						x = 550;
						y = 350;
					} else if (n == 3) {
						x = 550;
						y = 250;
					} else if (n == 4) {
						x = 550;
						y = 150;
					} else if (n == 5) {
						x = 550;
						y = 50;
					}
					break;
				}

				// ����
				if (x > 550 && x < 720) {
					x = 1100;
					y = 1100;
					isFinish = true;
					return true;
				}
			}
		}
		isStart = true;
		return false;
	}

	// ���������� �ٽý���
	public void setReady(int player, int malnum) {
		x = 720;
		y = 450;
		if (player == 0) {
			x = x + 40 * malnum;
		} else if (player == 1) {
			y = 500;
			x = x + 40 * malnum;
		} else if (player == 2) {
			y = 550;
			x = x + 40 * malnum;
		} else if (player == 3) {
			y = 600;
			x = x + 40 * malnum;
		}
		isStart = false;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean getIsStart() {
		return isStart;
	}

	public boolean getIsFinish() {
		return isFinish;
	}

}
