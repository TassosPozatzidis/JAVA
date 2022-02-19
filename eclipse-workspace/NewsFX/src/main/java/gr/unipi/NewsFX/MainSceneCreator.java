package gr.unipi.NewsFX;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

public class MainSceneCreator extends SceneCreator implements EventHandler<MouseEvent>{
	
	
	 FlowPane rootFlowPane;
	    //Button scene 
	    Button Welcome;
	    Label label;
	    
	    
	public MainSceneCreator(double width, double height) {
       
			super(width, height);
	        var javaVersion = SystemInfo.javaVersion();
	        var javafxVersion = SystemInfo.javafxVersion();
			rootFlowPane = new FlowPane();
	        Welcome =new Button("welcome");
	        
	        
	        //attach handle event to Welcome button
	        Welcome.setOnMouseClicked(this);
	        
	        rootFlowPane.setHgap(10);
	        rootFlowPane.setAlignment(Pos.CENTER);
	        
	        Welcome.setMinSize(120, 30);
	        
	        label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
	        
	        //add label to Root pane
	        rootFlowPane.getChildren().add(label);
	        
	      //add button to Root pane
	        rootFlowPane.getChildren().add(Welcome);
		}


	@Override
	Scene createScene() {
		// TODO Auto-generated method stub
		return new Scene(rootFlowPane,width,height);
	}


	@Override
	public void handle(MouseEvent event) {
		// TODO Auto-generated method stub
		if (event.getSource()==Welcome) {
			App.mainStage.setTitle("News Window");
			App.mainStage.setScene(new Scene (new FlowPane(),650,300));
		}
	}
	


}
