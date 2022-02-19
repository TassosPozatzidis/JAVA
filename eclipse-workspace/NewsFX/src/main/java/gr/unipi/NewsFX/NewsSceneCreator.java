package gr.unipi.NewsFX;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import model.NewsInfo;


public class NewsSceneCreator  extends SceneCreator implements EventHandler<MouseEvent>{
	
	//List of News
	ArrayList<NewsInfo> newsList;
	
	//Flow pane
	FlowPane buttonFlowPane,buttonFlowPane2;
	//Grid pane
	GridPane rootGridPane, inputFieldsPane;
	// buttons
	Button searchNewsBtn,saveNewsBtn,clearBtn,backBtn;
	
	//label
	Label keywordLbl,categoryLbl,sourceLbl,languageLbl,dateFromLbl,dateToLbl;
	
	//text fields
	TextField keywordField,categoryField,sourceField,languageField,dateFromField,dateToField;

	//Table view
	TableView<NewsInfo> newsTableView;

	public NewsSceneCreator(double width,double height) {
		
		super(width,height);
		newsList = new ArrayList<NewsInfo>();
		rootGridPane =new GridPane();
		buttonFlowPane = new FlowPane();
		buttonFlowPane2 = new FlowPane();
		
		keywordLbl =new Label("Keyword: ");
		categoryLbl = new Label("Category: ");
		sourceLbl = new Label("Source: ");
		languageLbl = new Label("Language: ");
		dateFromLbl = new Label("From: ");
		dateToLbl = new Label("To: ");
		
		keywordField = new TextField();
		categoryField = new TextField();
		sourceField = new TextField();
		languageField = new TextField();
		dateFromField = new TextField();
		dateToField = new TextField();
		
		searchNewsBtn = new Button("Search");
		saveNewsBtn = new Button("Save");
		backBtn = new Button("Back");
		clearBtn = new Button("Clear");
		
		inputFieldsPane = new GridPane();
		newsTableView = new TableView<NewsInfo>();
		
		//customize Flow Pane
		buttonFlowPane.setHgap(10);
		buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
		buttonFlowPane.getChildren().add(searchNewsBtn);
		buttonFlowPane.getChildren().add(saveNewsBtn);
		
		buttonFlowPane.setHgap(10);
		buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
		buttonFlowPane2.getChildren().add(clearBtn);
		buttonFlowPane2.getChildren().add(backBtn);
	
		//customize input field Grid Pane
		inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
		inputFieldsPane.setVgap(10);
		inputFieldsPane.setHgap(10);
		inputFieldsPane.add(keywordLbl, 0, 0);
		inputFieldsPane.add(keywordField, 1, 0);
		inputFieldsPane.add(categoryLbl, 0, 1);
		inputFieldsPane.add(categoryField, 1, 1);
		inputFieldsPane.add(sourceLbl, 0, 2);
		inputFieldsPane.add(sourceField, 1, 2);
		inputFieldsPane.add(languageLbl, 0, 3);
		inputFieldsPane.add(languageField, 1, 3);
		inputFieldsPane.add(dateFromLbl, 0, 4);
		inputFieldsPane.add(dateFromField, 1, 4);
		inputFieldsPane.add(dateToLbl, 0, 5);
		inputFieldsPane.add(dateToField, 1, 5);
		
		// Customize Root Grid Pane
		rootGridPane.setVgap(10);
		rootGridPane.setHgap(10);
		rootGridPane.add(inputFieldsPane, 1, 0);
		rootGridPane.add(newsTableView, 0, 0);
		rootGridPane.add(buttonFlowPane, 0, 1);
		//rootGridPane.add(backBtn, 1, 1);
		rootGridPane.add(buttonFlowPane2, 1, 1);
		
		
		TableColumn<NewsInfo, String> titleColumn = new TableColumn<>("Title");
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
		newsTableView.getColumns().add(titleColumn);

		TableColumn<NewsInfo, String> descriptionColumn = new TableColumn<>("Description");
		descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
		newsTableView.getColumns().add(descriptionColumn);

		TableColumn<NewsInfo, String> ratingColumn = new TableColumn<>("Url");
		ratingColumn.setCellValueFactory(new PropertyValueFactory<>("url"));
		newsTableView.getColumns().add(ratingColumn);

		TableColumn<NewsInfo, String> releaseDateColumn = new TableColumn<>("Release Date");
		releaseDateColumn.setCellValueFactory(new PropertyValueFactory<>("upload_date"));
		newsTableView.getColumns().add(releaseDateColumn);

		// Attach events
		backBtn.setOnMouseClicked(this);
		searchNewsBtn.setOnMouseClicked(this);
		saveNewsBtn.setOnMouseClicked(this);
		backBtn.setOnMouseClicked(this);
		clearBtn.setOnMouseClicked(this);
	
	}

	@Override
	Scene createScene() {
		// TODO Auto-generated method stub
		return new Scene(rootGridPane, width, height);
	}
	
	
	@Override
	public void handle(MouseEvent event) {
		if (event.getSource() == backBtn) {
			App.mainStage.setTitle("MainFX Window");
			App.mainStage.setScene(App.mainScene);
		} 
		else if (event.getSource() == clearBtn) {
			keywordField.setText("");
			categoryField.setText("");
			sourceField.setText("");
			languageField.setText("");
			dateFromField.setText("");
			dateToField.setText("");
		} 

	}

}

