package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Boardgame implements Initializable {
	static int player; // 플레이어 인원
	static int count; // 말 개수
	static int malmove, flag = 0; // 플레이어 및 윷의 결과
	static Button[][] btnmal;
	Dice dice = new Dice();
	static public Player[] team;
	PlayGame playgame = new PlayGame();
	static boolean[] confirm = { false, false }; // 0인데스 : 말 잡을 때, 1인덱스 : 우승 여부
	static boolean yootdice = false;
	Image backdo = new Image("빽도.png");
	Image doo = new Image("도.png");
	Image gae = new Image("개.png");
	Image gul = new Image("걸.png");
	Image yoot = new Image("윷.png");
	Image mo = new Image("모.png");
	@FXML
	private Button btn1;
	@FXML
	private Rectangle mal;
	@FXML
	private ImageView image;
	@FXML
	private Button selectyoot;
	@FXML
	private TextField selyoot;
	@FXML
	private Button p1one;
	@FXML
	private Button p1two;
	@FXML
	private Button p1three;
	@FXML
	private Button p1four;
	@FXML
	private Button p1five;
	@FXML
	private Button p2one;
	@FXML
	private Button p2two;
	@FXML
	private Button p2three;
	@FXML
	private Button p2four;
	@FXML
	private Button p2five;
	@FXML
	private Button p3one;
	@FXML
	private Button p3two;
	@FXML
	private Button p3three;
	@FXML
	private Button p3four;
	@FXML
	private Button p3five;
	@FXML
	private Button p4one;
	@FXML
	private Button p4two;
	@FXML
	private Button p4three;
	@FXML
	private Button p4four;
	@FXML
	private Button p4five;
	@FXML
	private Button gamerestart;
	@FXML
	private Button gameexit;
	@FXML
	private Label p3label;
	@FXML
	private Label p4label;
	@FXML
	private Label turn;
	@FXML
	private Label victory;

	// 플레이어 인원과 말 개수 값 설정
	public void setnumber(int play, int cnt) {
		player = play;
		count = cnt;
	}

	// 플레이어 인원과 말 개수에 맞게 화면 표시
	void Init() {
		if (player == 2) {
			p3label.setVisible(false);
			p3one.setVisible(false);
			p3two.setVisible(false);
			p3three.setVisible(false);
			p3four.setVisible(false);
			p3five.setVisible(false);
			p4label.setVisible(false);
			p4one.setVisible(false);
			p4two.setVisible(false);
			p4three.setVisible(false);
			p4four.setVisible(false);
			p4five.setVisible(false);
			if (count == 2) {
				p1three.setVisible(false);
				p1four.setVisible(false);
				p1five.setVisible(false);
				p2three.setVisible(false);
				p2four.setVisible(false);
				p2five.setVisible(false);
			}

			else if (count == 3) { 
				p1four.setVisible(false);
				p1five.setVisible(false);
				p2four.setVisible(false);
				p2five.setVisible(false);
			} else if (count == 4) {
				p1five.setVisible(false);
				p2five.setVisible(false);
			}
		} else if (player == 3) {
			p4label.setVisible(false);
			p4one.setVisible(false);
			p4two.setVisible(false);
			p4three.setVisible(false);
			p4four.setVisible(false);
			p4five.setVisible(false);

			if (count == 2) {
				p1three.setVisible(false);
				p1four.setVisible(false);
				p1five.setVisible(false);
				p2three.setVisible(false);
				p2four.setVisible(false);
				p2five.setVisible(false);
				p3three.setVisible(false);
				p3four.setVisible(false);
				p3five.setVisible(false);
			} else if (count == 3) {
				p1four.setVisible(false);
				p1five.setVisible(false);
				p2four.setVisible(false);
				p2five.setVisible(false);
				p3four.setVisible(false);
				p3five.setVisible(false);
			} else if (count == 4) {
				p1five.setVisible(false);
				p2five.setVisible(false);
				p3five.setVisible(false);
			}
		} else if (player == 4) {
			if (count == 2) {
				p1three.setVisible(false);
				p1four.setVisible(false);
				p1five.setVisible(false);
				p2three.setVisible(false);
				p2four.setVisible(false);
				p2five.setVisible(false);
				p3three.setVisible(false);
				p3four.setVisible(false);
				p3five.setVisible(false);
				p4three.setVisible(false);
				p4four.setVisible(false);
				p4five.setVisible(false);
			} else if (count == 3) {
				p1four.setVisible(false);
				p1five.setVisible(false);
				p2four.setVisible(false);
				p2five.setVisible(false);
				p3four.setVisible(false);
				p3five.setVisible(false);
				p4four.setVisible(false);
				p4five.setVisible(false);
			} else if (count == 4) {
				p1five.setVisible(false);
				p2five.setVisible(false);
				p3five.setVisible(false);
				p4five.setVisible(false);
			}
		}
	}

	// 말들을 팀별로 묶은 배열
	void malstore(Button[][] button) {
		if (player == 2) {
			if (count == 2) {
				button[0][0] = p1one;
				button[0][1] = p1two;
				button[1][0] = p2one;
				button[1][1] = p2two;
			} else if (count == 3) {
				button[0][0] = p1one;
				button[0][1] = p1two;
				button[0][2] = p1three;
				button[1][0] = p2one;
				button[1][1] = p2two;
				button[1][2] = p2three;
			} else if (count == 4) {
				button[0][0] = p1one;
				button[0][1] = p1two;
				button[0][2] = p1three;
				button[0][3] = p1four;
				button[1][0] = p2one;
				button[1][1] = p2two;
				button[1][2] = p2three;
				button[1][3] = p2four;
			} else if (count == 5) {
				button[0][0] = p1one;
				button[0][1] = p1two;
				button[0][2] = p1three;
				button[0][3] = p1four;
				button[0][4] = p1five;
				button[1][0] = p2one;
				button[1][1] = p2two;
				button[1][2] = p2three;
				button[1][3] = p2four;
				button[1][4] = p2five;
			}
		} else if (player == 3) {
			if (count == 2) {
				button[0][0] = p1one;
				button[0][1] = p1two;
				button[1][0] = p2one;
				button[1][1] = p2two;
				button[2][0] = p3one;
				button[2][1] = p3two;
			} else if (count == 3) {
				button[0][0] = p1one;
				button[0][1] = p1two;
				button[0][2] = p1three;
				button[1][0] = p2one;
				button[1][1] = p2two;
				button[1][2] = p2three;
				button[2][0] = p3one;
				button[2][1] = p3two;
				button[2][2] = p3three;
			} else if (count == 4) {
				button[0][0] = p1one;
				button[0][1] = p1two;
				button[0][2] = p1three;
				button[0][3] = p1four;
				button[1][0] = p2one;
				button[1][1] = p2two;
				button[1][2] = p2three;
				button[1][3] = p2four;
				button[2][0] = p3one;
				button[2][1] = p3two;
				button[2][2] = p3three;
				button[2][3] = p3four;
			} else if (count == 5) {
				button[0][0] = p1one;
				button[0][1] = p1two;
				button[0][2] = p1three;
				button[0][3] = p1four;
				button[0][4] = p1five;
				button[1][0] = p2one;
				button[1][1] = p2two;
				button[1][2] = p2three;
				button[1][3] = p2four;
				button[1][4] = p2five;
				button[2][0] = p3one;
				button[2][1] = p3two;
				button[2][2] = p3three;
				button[2][3] = p3four;
				button[2][4] = p3five;
			}
		} else if (player == 4) {
			if (count == 2) {
				button[0][0] = p1one;
				button[0][1] = p1two;
				button[1][0] = p2one;
				button[1][1] = p2two;
				button[2][0] = p3one;
				button[2][1] = p3two;
				button[3][0] = p4one;
				button[3][1] = p4two;
			} else if (count == 3) {
				button[0][0] = p1one;
				button[0][1] = p1two;
				button[0][2] = p1three;
				button[1][0] = p2one;
				button[1][1] = p2two;
				button[1][2] = p2three;
				button[2][0] = p3one;
				button[2][1] = p3two;
				button[2][2] = p3three;
				button[3][0] = p4one;
				button[3][1] = p4two;
				button[3][2] = p4three;
			} else if (count == 4) {
				button[0][0] = p1one;
				button[0][1] = p1two;
				button[0][2] = p1three;
				button[0][3] = p1four;
				button[1][0] = p2one;
				button[1][1] = p2two;
				button[1][2] = p2three;
				button[1][3] = p2four;
				button[2][0] = p3one;
				button[2][1] = p3two;
				button[2][2] = p3three;
				button[2][3] = p3four;
				button[3][0] = p4one;
				button[3][1] = p4two;
				button[3][2] = p4three;
				button[3][3] = p4four;
			} else if (count == 5) {
				button[0][0] = p1one;
				button[0][1] = p1two;
				button[0][2] = p1three;
				button[0][3] = p1four;
				button[0][4] = p1five;
				button[1][0] = p2one;
				button[1][1] = p2two;
				button[1][2] = p2three;
				button[1][3] = p2four;
				button[1][4] = p2five;
				button[2][0] = p3one;
				button[2][1] = p3two;
				button[2][2] = p3three;
				button[2][3] = p3four;
				button[2][4] = p3five;
				button[3][0] = p4one;
				button[3][1] = p4two;
				button[3][2] = p4three;
				button[3][3] = p4four;
				button[3][4] = p4five;
			}
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Init();
		team = new Player[player];
		btnmal = new Button[player][count];
		malstore(btnmal);
		for (int i = 0; i < player; i++) {
			team[i] = new Player("player" + (i + 1), count);
		}
		btn1.setOnAction(event -> handleBtn1Action(event));
		selectyoot.setOnAction(event -> handleselectyoot(event));
		p1one.setOnAction(event -> turn(event, p1one));
		p1two.setOnAction(event -> turn(event, p1two));
		p1three.setOnAction(event -> turn(event, p1three));
		p1four.setOnAction(event -> turn(event, p1four));
		p1five.setOnAction(event -> turn(event, p1five));
		p2one.setOnAction(event -> turn(event, p2one));
		p2two.setOnAction(event -> turn(event, p2two));
		p2three.setOnAction(event -> turn(event, p2three));
		p2four.setOnAction(event -> turn(event, p2four));
		p2five.setOnAction(event -> turn(event, p2five));
		p3one.setOnAction(event -> turn(event, p3one));
		p3two.setOnAction(event -> turn(event, p3two));
		p3three.setOnAction(event -> turn(event, p3three));
		p3four.setOnAction(event -> turn(event, p3four));
		p3five.setOnAction(event -> turn(event, p3five));
		p4one.setOnAction(event -> turn(event, p4one));
		p4two.setOnAction(event -> turn(event, p4two));
		p4three.setOnAction(event -> turn(event, p4three));
		p4four.setOnAction(event -> turn(event, p4four));
		p4five.setOnAction(event -> turn(event, p4five));
		gameexit.setOnAction(event -> exit(event));
		gamerestart.setOnAction(event -> restart(event));
	}

	// 윷던지기 버튼 클릭
	public void handleBtn1Action(ActionEvent event) {
		int num = dice.dice();
		if (num == -1) {
			image.setImage(backdo);
		} else if (num == 1) {
			image.setImage(doo);
		} else if (num == 2) {
			image.setImage(gae);
		} else if (num == 3) {
			image.setImage(gul);
		} else if (num == 4) {
			image.setImage(yoot);
		} else if (num == 5) {
			image.setImage(mo);
		}
		malmove = num;
		turn.setText(team[flag].getName() + " 입니다.");
		turn.getText();
		yootdice = true;
	}

	// 지정된 윷 던지기 버튼 클릭
	public void handleselectyoot(ActionEvent event) {
		String setyoot;
		setyoot = selyoot.getText();
		int num = dice.setdice(setyoot);
		if (num == -1) {
			image.setImage(backdo);
		} else if (num == 1) {
			image.setImage(doo);
		} else if (num == 2) {
			image.setImage(gae);
		} else if (num == 3) {
			image.setImage(gul);
		} else if (num == 4) {
			image.setImage(yoot);
		} else if (num == 5) {
			image.setImage(mo);
		}
		malmove = num;
		turn.setText(team[flag].getName() + " 입니다.");
		turn.getText();
		yootdice = true;
	}

	// 플레이어의 순서
	public void turn(ActionEvent event, Button buttonmal) {
		if (yootdice == true && game(buttonmal) != -1) { // 윷을 던졌을 경우
			if (flag == 0 ) {
				if (malmove == 4 || malmove == 5 || confirm[0] == true)
					;// 말을 잡거나 율 또는 모가 나올경우
				else
					flag += 1;
			} else if (flag == 1   ) {
				if (malmove == 4 || malmove == 5 || confirm[0] == true)
					; // 말을 잡거나 율 또는 모가 나올경우
				else {
					if (player >= 3)
						flag += 1;
					else
						flag = 0;
				}
			} else if (flag == 2   ) {
				// 말을 잡거나 율 또는 모가 나올경우
				if (malmove == 4 || malmove == 5 || confirm[0] == true);
				else {
					if (player == 4)
						flag += 1;
					else
						flag = 0;
				}
			} else if (flag == 3   ) {
				if (malmove == 4 || malmove == 5 || confirm[0] == true)
					;
				else
					flag = 0;
			}
		yootdice = false;
		}
		else if(yootdice == false) { // 윷을 던지지 않았을 경우
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setHeaderText("Look, a Warning Dialog");
			alert.setContentText("윷을 던져주세요!!");
			alert.showAndWait();
		}
	}

	// 게임의 진행
	int game(Button buttonmal) {
		int malnum = -1;
		for (int i = 0; i < count; i++) {
			if (btnmal[flag][i].equals(buttonmal)) { // 한 플레이어의 말만 하기 위해서
				malnum = Integer.parseInt(btnmal[flag][i].getText());
				break;
			}
		}
		if (malnum != -1) {
			confirm = playgame.run(malnum, malmove, team, flag);
			btnmal[flag][malnum].setLayoutX(team[flag].getX(malnum));
			btnmal[flag][malnum].setLayoutY(team[flag].getY(malnum));
			if (confirm[1])
				win();
		} else if (malnum == -1) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setHeaderText("Look, a Warning Dialog");
			alert.setContentText("잘못된 선택입니다. 다시선택해주세요!");
			alert.showAndWait();
		}
		return malnum;
	}

	// 잡힌 말 제자리로
	public void malposition(int player, int mal, Player[] teamm) {
		btnmal[player][mal].setLayoutX(team[player].getX(mal));
		btnmal[player][mal].setLayoutY(team[player].getY(mal));
	}

	// 업은말들 이동 표현
	public void groupmove(int cnt, int first) {
		btnmal[flag][first].setLayoutX(team[flag].getX(first));
		btnmal[flag][first].setLayoutY(team[flag].getY(first));
	}

	// 승리표현
	public void win() {
		victory.setText(team[flag].getName() + "승리!!");
		victory.getText();
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("승리");
		alert.setHeaderText(null);
		alert.setContentText(team[flag].getName() + "의 승리!! 재시작 또는 종료를 선택해주세요");
		alert.showAndWait();
	}

	// 게임 종료
	public void exit(ActionEvent event) {
		System.exit(0);
	}

	// 게임 재시작
	public void restart(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Select.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) gamerestart.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		flag = 0;
		malmove = 0;
	}
}
