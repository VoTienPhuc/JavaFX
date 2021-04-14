/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.mysql.cj.xdevapi.PreparableStatement;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import util.ConnectDB;
import model.NhanVienDAO;
import model.Login;
import model.User;

/**
 * FXML Controller class
 *
 * @author May10
 */
public class LoginController implements Initializable {
    @FXML
    private Button face;
    @FXML
    private Button twit;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Button btnLogin;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        face.setGraphic(taoIcon("/img/facebookicon.png"));
        twit.setGraphic(taoIcon("/img/twittericon.png"));
        username.setText("phuonganh");
        password.setText("123456");
    }
    
    public ImageView taoIcon(String path)
    {
        Image h1=new Image(getClass().getResourceAsStream(path));
        ImageView imageView = new ImageView(h1);
        
        imageView.setFitHeight(30);
        imageView.setFitWidth(30);
        
        return imageView;        
    }
  
    @FXML
    private void handleLoginButton(ActionEvent event) {
        String user=username.getText();
        String pass=password.getText();
        Login login=new Login();
        try {           
            if(login.checklogin(user, pass))
            {
//                Alert a =new Alert(Alert.AlertType.INFORMATION);
//                a.setTitle("");
//                a.setHeaderText("");
//                a.setContentText("Đăng nhập thành công,chào mừng ");
//                a.showAndWait();
                Stage appStage=(Stage)((Node)event.getSource()).getScene().getWindow();
                Parent root3 = FXMLLoader.load(getClass().getResource("/view/Database.fxml"));
                Scene scene = new Scene(root3);
                appStage.setScene(scene);
                appStage.show();
            }
            else
            {
                Alert a =new Alert(Alert.AlertType.INFORMATION);
                a.setTitle("");
                a.setHeaderText("");
                a.setContentText("Đăng nhập thất bại");
                a.showAndWait();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
