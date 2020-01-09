/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication15;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author user
 */

public class FXMLDocumentController implements Initializable {

    @FXML
    private MenuItem K;
    @FXML
    private MenuItem Z;
    @FXML
    private MenuItem A;
    @FXML
    private MenuItem S;
    @FXML
    private MenuItem V;
    @FXML
    private Button Out;
    @FXML
    private TextArea O;
    public void executeQuery(String query) {
          /*
    Подключение в БД
    */
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection conn;
        try {
   conn = DriverManager.getConnection("jdbc:mysql://mysql-162551.srv.hoster.ru/srv162551_samara", "srv162551_danil", "2010danil");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
  /*
        Создаем переходы от MenuItem к другим fxml для заполнения нашей бд
        */
        if (event.getSource() == A) {

   try {
                
             
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Filial.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                     Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setTitle("ABC");
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
           if (event.getSource() == Z) {
             try {
                
             
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Deliveryofgoods.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                     Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setTitle("ABC");
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
          

        }
           if (event.getSource() == S) {
             try {
                
             
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Gorod.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                     Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setTitle("ABC");
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
          

        }
              if (event.getSource() == K) {
             try {
                
             
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Category.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                     Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setTitle("ABC");
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }}
                /*
    Создание сложного запроса для отображения связи таблиц в нашей бд
    */
            if (event.getSource() == Out) {
             String query = "SELECT Samara.`Director` as `Director`, Apteca.City,Apteca.Filial , Apteca.Named FROM Apteca INNER JOIN Samara ON (Apteca.`id`= Samara.`id`)";
     
            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://mysql-162551.srv.hoster.ru/srv162551_samara", "srv162551_danil", "2010danil");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {

                    O.appendText("Директор  = " + rs.getString(1) + "; Город= " + rs.getString(2) + "; Филиал= " + rs.getString(3) + "; Название= " + rs.getString(4)+ "\n");
                    O.setEditable(false);
                }

            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
          

        }
                        if (event.getSource() == V) {
             try {
                
             
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Accounting.of.goods.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                     Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setTitle("ABC");
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
          

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
