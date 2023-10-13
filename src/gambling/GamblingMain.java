package gambling;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GamblingMain extends Application {
	Label la1 = new Label("0"), la2 = new Label("0"), la3 = new Label("0");
	Label result = new Label("시작합니다.");
	@Override
	public void start(Stage primaryStage) throws Exception{
		VBox root = new VBox();
		HBox subRoot = new HBox();	// Section of label to print rand_num
		HBox resultPane = new HBox();	// Section of label to print result
		
		//Section of label to print rand_num
		subRoot.setAlignment(Pos.CENTER);
		subRoot.setPrefSize(200, 200);
		subRoot.setSpacing(20);
		
		// Section of label to print result
		resultPane.setAlignment(Pos.CENTER);
		resultPane.setPrefSize(200, 100);
		
		// First Label to print rand_num
		la1.setAlignment(Pos.CENTER);	la1.setPrefWidth(70);
		la1.setStyle("-fx-background-color: #9F81F7;");	la1.setPrefHeight(50);
		la1.setPadding(new Insets(10));
		
		// Second Label to print rand_num
		la2.setAlignment(Pos.CENTER);	la2.setPrefWidth(70);
		la2.setStyle("-fx-background-color: #9F81F7;");	la2.setPrefHeight(50);
		la2.setPadding(new Insets(10));
				
		// Third Label to print rand_num
		la3.setAlignment(Pos.CENTER);	la3.setPrefWidth(70);
		la3.setStyle("-fx-background-color: #9F81F7;");	la3.setPrefHeight(50);
		la3.setPadding(new Insets(10));
		
		// Connect Container
		root.getChildren().add(subRoot);
		root.getChildren().add(resultPane);
		subRoot.getChildren().add(la1);
		subRoot.getChildren().add(la2);
		subRoot.getChildren().add(la3);
		resultPane.getChildren().add(result);
		
		Scene scene = new Scene(root, 400,300);
		// Setting event when you press keyboard
		scene.setOnKeyPressed(new EventHandler <KeyEvent>()
		{
			@Override
			public void handle(KeyEvent e) {
				KeyCode key = e.getCode();
				if(key==KeyCode.ENTER) {
					la1.setText(Integer.toString((int)(Math.random()*5)));
					la2.setText(Integer.toString((int)(Math.random()*5)));
					la3.setText(Integer.toString((int)(Math.random()*5)));
					
					if(la1.getText().equals(la2.getText())
							&& la1.getText().equals(la3.getText()))
					{
						result.setText("축하합니다.");
					}
					else {
						result.setText("아쉽군요.");
					}
				}
			}
		});
		primaryStage.setScene(scene);
		primaryStage.setTitle("Gambling_App");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);

	}

}
