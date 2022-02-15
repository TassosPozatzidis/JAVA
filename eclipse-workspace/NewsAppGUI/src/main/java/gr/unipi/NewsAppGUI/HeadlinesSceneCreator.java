package gr.unipi.NewsAppGUI;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import exception.NewsAPIException;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import model.IpAPI;
import model.NewsAPI;
import model.NewsInfo;
import services.IpAPIService;
import services.NewsAPIService;


public class HeadlinesSceneCreator  extends SceneCreator implements EventHandler<MouseEvent>{
	
	//List of News
	ArrayList<NewsInfo> newsList;
	
	//Flow pane
	FlowPane buttonFlowPane,buttonFlowPane2,buttonFlowPane3;
	//Grid pane
	GridPane rootGridPane, inputFieldsPane;
	// buttons
	Button searchNewsBtn,saveNewsBtn,clearBtn,backBtn,closeBtn;
	
	//combo box
	ComboBox comboBoxcat;
	
	//label
	Label countryLbl,categoryLbl;
	
	//text fields
	TextField countryField;

	//Table view
	TableView<NewsInfo> newsTableView;

	public HeadlinesSceneCreator(double width,double height) {
		
		super(width,height);
		newsList = new ArrayList<NewsInfo>();
		rootGridPane =new GridPane();
		buttonFlowPane = new FlowPane();
		buttonFlowPane2 = new FlowPane();
		buttonFlowPane3= new FlowPane();
		
		countryLbl =new Label("Country: ");
		categoryLbl = new Label("Category: ");
		
		countryField = new TextField();

		
		searchNewsBtn = new Button("Search");
		saveNewsBtn = new Button("Search History");
		backBtn = new Button("Back");
		clearBtn = new Button("Clear");
		closeBtn = new Button("Exit");
		
		saveNewsBtn.setMinSize(120, 30);
		backBtn.setMinSize(120, 30);
		closeBtn.setMinSize(120, 30);
		
		comboBoxcat = new ComboBox();					//combobox for categories selection

		comboBoxcat.getItems().add("");
		comboBoxcat.getItems().add("business");
		comboBoxcat.getItems().add("entertainment");
		comboBoxcat.getItems().add("general");
		comboBoxcat.getItems().add("health");
		comboBoxcat.getItems().add("science");
		comboBoxcat.getItems().add("sports");
		comboBoxcat.getItems().add("technology");

		comboBoxcat.setOnAction((event) -> {
			int selectedIndex = comboBoxcat.getSelectionModel().getSelectedIndex();
		    Object selectedItem = comboBoxcat.getSelectionModel().getSelectedItem();

		});
		
		
		
		
		inputFieldsPane = new GridPane();
		newsTableView = new TableView<NewsInfo>();
		
		//customize Flow Pane
		buttonFlowPane.setHgap(10);
		buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
		buttonFlowPane.getChildren().add(saveNewsBtn);
		
		buttonFlowPane3.setHgap(10);
		buttonFlowPane3.setAlignment(Pos.BOTTOM_CENTER);
		buttonFlowPane3.getChildren().add(backBtn);
		buttonFlowPane3.getChildren().add(closeBtn);
		
		buttonFlowPane2.setHgap(10);
		buttonFlowPane2.setAlignment(Pos.BOTTOM_CENTER);
		buttonFlowPane2.setPrefWrapLength(210);
		buttonFlowPane2.getChildren().add(clearBtn);
		buttonFlowPane2.getChildren().add(searchNewsBtn);
	
		//customize input field Grid Pane
		inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
		inputFieldsPane.setVgap(10);
		inputFieldsPane.setHgap(10);
		rootGridPane.getColumnConstraints().add(new ColumnConstraints(780));
		rootGridPane.getColumnConstraints().add(new ColumnConstraints(300));
		inputFieldsPane.add(countryLbl, 0, 1);
		inputFieldsPane.add(countryField, 1, 1);
		inputFieldsPane.add(categoryLbl, 0, 2);
		inputFieldsPane.add(comboBoxcat, 1, 2);
		inputFieldsPane.add(buttonFlowPane2, 1, 7);
		// Customize Root Grid Pane
		rootGridPane.setVgap(10);
		rootGridPane.setHgap(10);
		rootGridPane.add(inputFieldsPane, 1, 0);
		rootGridPane.add(newsTableView, 0, 0);
		rootGridPane.add(buttonFlowPane, 0, 1);
		//rootGridPane.add(backBtn, 1, 1);
		rootGridPane.add(buttonFlowPane3, 1, 1);
		
		
		TableColumn<NewsInfo, String> titleColumn = new TableColumn<>("Title");
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
		titleColumn.setMinWidth(180);
		newsTableView.getColumns().add(titleColumn);

		TableColumn<NewsInfo, String> descriptionColumn = new TableColumn<>("Description");
		descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
		descriptionColumn.setMinWidth(250);
		newsTableView.getColumns().add(descriptionColumn);

		TableColumn<NewsInfo, String> urlColumn = new TableColumn<>("Url");
		urlColumn.setCellValueFactory(new PropertyValueFactory<>("url"));
		urlColumn.setMinWidth(220);
		newsTableView.getColumns().add(urlColumn);

		TableColumn<NewsInfo, String> releaseDateColumn = new TableColumn<>("Release Date");
		releaseDateColumn.setCellValueFactory(new PropertyValueFactory<>("upload_date"));
		releaseDateColumn.setMinWidth(150);
		newsTableView.getColumns().add(releaseDateColumn);

		// Attach events
		backBtn.setOnMouseClicked(this);
		searchNewsBtn.setOnMouseClicked(this);
		saveNewsBtn.setOnMouseClicked(this);
		backBtn.setOnMouseClicked(this);
		clearBtn.setOnMouseClicked(this);
		closeBtn.setOnMouseClicked(this);
	
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
		else if (event.getSource() == saveNewsBtn) {
			App.mainStage.setTitle("Search History Window");
			App.mainStage.setScene(App.hsScene);
		} 
		else if (event.getSource() == clearBtn) {
			clearTextFields();
		}
		else if (event.getSource() == searchNewsBtn) {
			newsTableView.getItems().clear();
			String country = countryField.getText();				//get the value of country
		    String cat = (String) comboBoxcat.getValue();			//get the value of category
		    
		    try {
		    	if(cat==null) {
		    		DatabaseConnection.addNews(country," ", " ", " ", " ", " ", " "); 
		    	}else {
		    		DatabaseConnection.addNews(country,cat, " ", " ", " ", " ", " "); 	//add search to database table by calling addNews function
		    	}
		    } catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				newsTableView.getItems().clear();
				getTopHeadlines(country,cat);
				tableSync();
				clearTextFields();
				
			} catch (NewsAPIException e) {
				// TODO Auto-generated catch block
				newsTableView.getItems().clear();
				e.printStackTrace();
			}
		} else if (event.getSource() == closeBtn) {
			handleCloseButtonAction(event);
		}

	}
	public void handleCloseButtonAction(MouseEvent event) {//function for close button 
		closeBtn.getScene().getWindow();					//returns a stage
		App.mainStage.close();								//close main stage

	}

	public void getTopHeadlines(String country,String category) throws NewsAPIException {
		final IpAPIService IpSearchService = IpAPI.getIpAPIService();										//Function for getting the Country through IP Geolocation API results based on parameters
		final String Country = IpSearchService.findCountry(null);
		final NewsAPIService newsSearchService = NewsAPI.getNewsAPIService();
		List<NewsInfo> results = null;
		if (country == null || country.equals("")) {
			 results = newsSearchService.getTopHeadlinesInaCountryByCategory(Country,category);

		}
		else {
			 results = newsSearchService.getTopHeadlinesInaCountryByCategory(country,category);

		}
		results.forEach(System.out::println);
		newsList.addAll(results);

	}

	public void tableSync() {
		List<NewsInfo> items = newsTableView.getItems();
		items.clear();

		for (NewsInfo news : newsList) {
			if (news instanceof NewsInfo) {
				items.add(news);
			}
		}

	}
	public void clearTextFields() {
		countryField.setText("");
		

	}

}


