package co.edu.poli.Proyecto_3.Vista;


	import javafx.application.Application;
	import javafx.fxml.FXMLLoader;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.scene.layout.AnchorPane;
	import javafx.stage.Stage;

	import java.io.IOException;

	/**
	 * JavaFX App
	 */
	public class App extends Application {

	    private static Scene scene;

	    @Override
	    public void start(Stage stage) throws IOException {
	        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/co/edu/poli/Proyecto_3/Vista/AppArbol.fxml"));
	        scene = new Scene(root);
	        stage.setScene(scene);
	        stage.setTitle("CRUD Y ARCHIVO (clase Arbol)");
	        stage.show();
	    }

	    static void setRoot(String fxml) throws IOException {
	        scene.setRoot(loadFXML(fxml));
	    }

	    private static Parent loadFXML(String fxml) throws IOException {
	        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
	        return fxmlLoader.load();
	    }

	    public static void main(String[] args) {
	        launch();
	    }

	}


