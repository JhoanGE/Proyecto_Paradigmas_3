package co.edu.poli.Proyecto_3.Controlador;


import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.poli.Proyecto_3.Modelo.Arbol;
import co.edu.poli.Proyecto_3.Servicio.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

	public class FormControlador implements Initializable {

	    @FXML
	    private Button Actualizar;

	    @FXML
	    private Button Buscar;

	    @FXML
	    private Button Deserializar;

	    @FXML
	    private Button Eliminar;

	    @FXML
	    private TextField Especie;

	    @FXML
	    private ToggleGroup Estado;

	    @FXML
	    private DatePicker FechaPcker;

	    @FXML
	    private Button Guardar;

	    @FXML
	    private Button Mostrar;

	    @FXML
	    private RadioButton R1;

	    @FXML
	    private RadioButton R2;

	    @FXML
	    private Button Serializar;

	    @FXML
	    private TextField UbicacionArbol;

	    @FXML
	    private TableColumn<Arbol, String> colum1;

	    @FXML
	    private TableColumn<Arbol, String> colum2;

	    @FXML
	    private TableColumn<Arbol, String> colum3;

	    @FXML
	    private TableColumn<Arbol, String> colum4;

	    @FXML
	    private TableColumn<Arbol,	String > colum5;

	    @FXML
	    private TextField idarbol;
	    
	    @FXML
	    private TableView<Arbol> TablaArbol;
	    
	    ObservableList<Arbol> est;

	    
	    ImplemetacionOperaciones op;
	    

	    @FXML
	    void ActualizarArbol(ActionEvent event) {
	    	Alert a = new Alert(AlertType.CONFIRMATION);
    	    try {
    	    	Arbol olde = TablaArbol.getSelectionModel().getSelectedItem();
	            if (Especie.getText() == null || Especie.getText().isEmpty()) {
	                throw new IllegalArgumentException("La descripción no puede estar vacía.");
	            }
	            if (idarbol.getText() == null || idarbol.getText().isEmpty()) {
	                throw new IllegalArgumentException("El tiempo de descomposición no puede estar vacío.");
	            }
	            if (UbicacionArbol.getText() == null || UbicacionArbol.getText().isEmpty()) {
	                throw new IllegalArgumentException("El peso no puede estar vacío.");
	            }
	           
	            Arbol arbol = new Arbol();
	            arbol.setId(idarbol.getText());
	            arbol.setEspecie(Especie.getText());
	            arbol.setUbicacion(UbicacionArbol.getText());
	            if (FechaPcker.getValue() != null) {
	                arbol.setFechaPlantacion(FechaPcker.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	            } else {
	                System.out.println("Por favor selecciona una fecha.");
	            }
	            if (R1.isSelected()) {
	                arbol.setEstadoSalud(true);
	            } else if (R2.isSelected()) {
	                arbol.setEstadoSalud(false);
	            } else {
	                throw new IllegalArgumentException("Debe seleccionar si el residuo es peligroso o no.");
	            }

	            
	            est.set(est.indexOf(olde), arbol);
    	        a.setContentText(op.update(olde.getId(), arbol));
    			loadTable();
	            

	            a = new Alert(Alert.AlertType.CONFIRMATION);
	            a.setContentText("Residuo guardado exitosamente: " + arbol);
	            a.show();

	            limpiarFormulario();
	            
	            
	        } 
	        catch (IllegalArgumentException e) {
	            a = new Alert(Alert.AlertType.WARNING);
	            a.setContentText(e.getMessage());
	            a.show();
	        }
	        catch (Exception e) {

	            a = new Alert(Alert.AlertType.ERROR);
	            a.setContentText("Ocurrió un error inesperado: " + e.getMessage());
	            a.show();
	        }
	    } 

	    

	    @FXML
	    void BuscarArbol(ActionEvent event) {
	    	Alert alert;
	        try {
	            String idBusqueda = idarbol.getText().trim(); 

	            if (idBusqueda.isEmpty()) {
	                throw new IllegalArgumentException("El campo de búsqueda no puede estar vacío.");
	            }

	            ObservableList<Arbol> residuosEncontrados = FXCollections.observableArrayList();

	            for (Arbol arbol : est) {
	                if (arbol.getId().equalsIgnoreCase(idBusqueda)) {
	                    residuosEncontrados.add(arbol); 
	                }
	            }

	            if (residuosEncontrados.isEmpty()) {
	                throw new IllegalArgumentException("No se encontró ningún residuo con el ID: " + idBusqueda);
	            }

	            TablaArbol.setItems(residuosEncontrados);
	            alert = new Alert(Alert.AlertType.CONFIRMATION);
	            alert.setContentText("Se encontraron " + residuosEncontrados.size() + " residuos con el ID: " + idBusqueda);
	            alert.show();

	        } catch (IllegalArgumentException e) {
	            alert = new Alert(Alert.AlertType.WARNING);
	            alert.setContentText(e.getMessage());
	            alert.show();
	        } catch (Exception e) {
	            alert = new Alert(Alert.AlertType.ERROR);
	            alert.setContentText("Ocurrió un error inesperado: " + e.getMessage());
	            alert.show();
	        }
	    }
	    	

	    @FXML
	    void Create(ActionEvent event) {
	    	Alert a = new Alert(AlertType.CONFIRMATION);
	        try {
	        	List<String> listSkill = new ArrayList<String>();
	
	            if (Especie.getText() == null || Especie.getText().isEmpty()) {
	                throw new IllegalArgumentException("La descripción no puede estar vacía.");
	            }
	            if (idarbol.getText() == null || idarbol.getText().isEmpty()) {
	                throw new IllegalArgumentException("El tiempo de descomposición no puede estar vacío.");
	            }
	            if (UbicacionArbol.getText() == null || UbicacionArbol.getText().isEmpty()) {
	                throw new IllegalArgumentException("El peso no puede estar vacío.");
	            }
	           
	            Arbol arbol = new Arbol();
	            arbol.setId(idarbol.getText());
	            arbol.setEspecie(Especie.getText());
	            arbol.setUbicacion(UbicacionArbol.getText());
	            if (FechaPcker.getValue() != null) {
	                arbol.setFechaPlantacion(FechaPcker.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	            } else {
	                System.out.println("Por favor selecciona una fecha.");
	            }
	            
	            if (R1.isSelected()) {
	                arbol.setEstadoSalud(true);
	            } else if (R2.isSelected()) {
	                arbol.setEstadoSalud(false);
	            } else {
	                throw new IllegalArgumentException("Debe seleccionar si el residuo es peligroso o no.");
	            }
	            
	            est.add(arbol);
	            a.setContentText(op.crearArbol(arbol));
	            loadTable();
	            

	            a = new Alert(Alert.AlertType.CONFIRMATION);
	            a.setContentText("Residuo guardado exitosamente: " + arbol);
	            a.show();

	            limpiarFormulario();
	            
	            
	        } 
	        catch (IllegalArgumentException e) {
	            a = new Alert(Alert.AlertType.WARNING);
	            a.setContentText(e.getMessage());
	            a.show();
	        }
	        catch (Exception e) {

	            a = new Alert(Alert.AlertType.ERROR);
	            a.setContentText("Ocurrió un error inesperado: " + e.getMessage());
	            a.show();
	        }
	    } 

	  

	    @FXML
	    void Delete(ActionEvent event) {
	    	Alert a = new Alert(AlertType.CONFIRMATION);
			try {
				Arbol e = TablaArbol.getSelectionModel().getSelectedItem();
				est.remove(e);
				a.setContentText("Delete: " + op.delete(e.getId()));
				loadTable();
				limpiarFormulario();
			} catch (Exception e) {
				a.setContentText("Seleccionar un registro");
			}
			a.show();

		

	    }

	    @FXML
	    void DeserializarArbol(ActionEvent event) {
	    	Alert a = new Alert(AlertType.WARNING);
			try {
				op.setArboles(op.deserializar("", "binaryfile.bin"));
				est.clear();

				for (Arbol arboles : op.readall()) {
					if (arboles != null)
						est.add(arboles);
				}

				loadTable();
			} catch (Exception e) {
				a.setContentText("Error open file "+e.getMessage());
				a.show();
			}

		}
	    @FXML
	    void MostrarArbol(ActionEvent event) {
	    	TablaArbol.setItems(est); 

	    }

	    @FXML
	    void SerializarArbol(ActionEvent event) {
	    	Alert a = new Alert(AlertType.INFORMATION);
			a.setContentText(op.serializar(op.readall(), "", "binaryfile.bin"));
			a.show();

	}
	    void loadTable() {

			colum1.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getId()));
			colum2.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getEspecie()));
			colum3.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getUbicacion()));
			colum4.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getEstadoSalud()? "bueno" : "Malo"));
			colum5.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getFechaPlantacion()));
			TablaArbol.setItems(est);

		}
	    @FXML
		void displaySelected(MouseEvent event) {

			try {
	                Arbol arbol = TablaArbol.getSelectionModel().getSelectedItem();

	                if (arbol == null) {
	                    throw new IllegalArgumentException("Seleccionar un residuo para editar.");
	                }
	            		
		        	idarbol.setText(arbol.getId());
		        	Especie.setText(arbol.getEspecie());
		        	UbicacionArbol.setText(arbol.getUbicacion());
		        	FechaPcker.setValue(FechaPcker.getConverter().fromString(arbol.getFechaPlantacion()));

	                if (arbol.getEstadoSalud()) {
	                    R1.setSelected(true);  
	                } else {
	                    R2.setSelected(true);  
	                }
	                
			}
	                
				catch (IllegalArgumentException e) {
	                Alert alert = new Alert(Alert.AlertType.WARNING);
	                alert.setContentText("Debe seleccionar un residuo para editar.");
	                alert.show();
	            } catch (Exception e) {
	                Alert alert = new Alert(Alert.AlertType.ERROR);
	                alert.setContentText("Ocurrió un error inesperado: " + e.getMessage());
	                alert.show();
	            }
	    }
	    private void limpiarFormulario() {
	    	idarbol.clear();
	    	Especie.clear();
	    	UbicacionArbol.clear();
	    	FechaPcker.setValue(LocalDate.now());
	        R1.setSelected(false);
	        R2.setSelected(false);
	    }



		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			op = new ImplemetacionOperaciones();
			est = FXCollections.observableArrayList();
			TablaArbol.setItems(est);
			
		}
		@FXML
	    void Exit(ActionEvent event) {
	        System.out.println("Saliendo de la aplicación...");
	        System.exit(0);
	    }
	}

