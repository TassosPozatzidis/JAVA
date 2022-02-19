package gr.unipi.NewsFX;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application{
	
	 //Stage
    static Stage mainStage;
    //Scene
    static Scene mainScene, NewsScene,TopHeadlinesScene, logoutScene;
    //Flow pane root
    //Button scene 

    @Override
    public void start(Stage mainStage) {

        this.mainStage=mainStage;
    
        SceneCreator mainSceneCreator = new MainSceneCreator(640,480);
       mainScene = mainSceneCreator.createScene();
        

        
        mainStage.setTitle("Main Window");
        mainStage.setScene(mainScene);
        mainStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    

    	

}