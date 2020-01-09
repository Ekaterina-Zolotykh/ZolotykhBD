/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication15;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author karos
 */
public class GorodController implements Initializable {
     public void executeQuery(String query) {
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
    @FXML
    private Button Add;
    @FXML
    private TextField id;
    @FXML
    private TextField Ad;
    @FXML
    private TextField Kat;
    @FXML
    private TextField Dir;
    @FXML
    private Button Exit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
         if (event.getSource() == Add) {
     String query = "insert into Samara values(" + id.getText() + "," + Ad.getText() + "," + Kat.getText() + ",'" + Dir.getText()+ "')";
           executeQuery(query);
         }
   if (event.getSource() == Exit) {
Stage stage = (Stage) Exit.getScene().getWindow();
      stage.close();
        }
     }
}
