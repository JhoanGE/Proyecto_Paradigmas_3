module Proyecto_3_pp {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	requires java.sql;
	requires java.desktop;
	
	opens co.edu.poli.Proyecto_3.Modelo to 
		javafx.graphics, javafx.fxml, javafx.fxml.FXMLLoader;

	opens co.edu.poli.Proyecto_3.Controlador to 
		javafx.graphics, javafx.fxml, javafx.fxml.FXMLLoader;
	
	opens co.edu.poli.Proyecto_3.Vista to 
		javafx.graphics, javafx.fxml, javafx.fxml.FXMLLoader;
	
	opens co.edu.poli.Proyecto_3.Servicio to 
	javafx.graphics, javafx.fxml, javafx.fxml.FXMLLoader;
}