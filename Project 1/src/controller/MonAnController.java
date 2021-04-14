/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.MonAn;
import model.Util;
import model.MonAnDAO;

/**
 * FXML Controller class
 *
 * @author May10
 */
public class MonAnController implements Initializable {

    @FXML
    private TextField mamon;
    @FXML
    private TextField tenmon;
    @FXML
    private TextField dongia;
    @FXML
    private TextField trangthai;
    @FXML
    private Button btnInsert;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private TableColumn<MonAn, String> MaMon;
    @FXML
    private TableColumn<MonAn, String> TenMon;
    @FXML
    private TableColumn<MonAn, Integer> DonGia;
    @FXML
    private TableColumn<MonAn, Integer> TrangThai;
    @FXML
    private Label txtFullName;
    @FXML
    private TableView<MonAn> tbvMonAn;
    
    MonAnDAO dao=new MonAnDAO();
    private Util user=new Util();

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showMonAn();
        txtFullName.setText("Xin chào "+Util.username);
        setRole(Util.role);
    }    
    
    
    private void disableButton()
    {
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
        btnInsert.setDisable(true);
    }
    
    private void enableButton()
    {
        btnUpdate.setDisable(false);
        btnDelete.setDisable(false);
        btnInsert.setDisable(false);
        mamon.setEditable(false);
    }
    
    private void clearText()
    {
        mamon.setText("");
        tenmon.setText("");
        dongia.setText("");
        trangthai.setText("");
    }
    
    private boolean kiemTraRong()
    {
        if(mamon.getText().equals("")||tenmon.getText().equals("")||dongia.getText().equals("")||trangthai.getText().equals(""))
            return true;
        return false;
    }
    
     private void setRole(int role)
    {
        if(role==1)
           enableButton();
        if(role==3)
           disableButton();
    }
     
     public void monAnInsertUpdateDelete(int a)
    {
        MonAn e=new MonAn();
        e.setMamon(mamon.getText());
        e.setTenmon(tenmon.getText());
        e.setDongia(Integer.parseInt(dongia.getText()));
        e.setTrangthai(Integer.parseInt(trangthai.getText()));      
        if(a==1)
            dao.insert(e);
        else if(a==2)
            dao.update(e);
        else
            dao.delete(e);
        showMonAn();
    }
     
    public void showMonAn()
    {
        ObservableList<MonAn> list=dao.selectAll();
        MaMon.setCellValueFactory(new PropertyValueFactory<>("mamon"));
        TenMon.setCellValueFactory(new PropertyValueFactory<>("tenmon"));
        DonGia.setCellValueFactory(new PropertyValueFactory<>("dongia"));
        TrangThai.setCellValueFactory(new PropertyValueFactory<>("trangthai"));
        
        tbvMonAn.setItems(list);
    }

    @FXML
    private void handleActionButton(ActionEvent event) {
        MonAn e=tbvMonAn.getSelectionModel().getSelectedItem();
        mamon.setText(e.getMamon());
        tenmon.setText(e.getTenmon());
        trangthai.setText(""+e.getDongia());
        dongia.setText(""+e.getTrangthai());
        mamon.setEditable(false);  
        enableButton();
    }

    @FXML
    private void handleMouseAction(MouseEvent event) {
         if(kiemTraRong()==false)
        {
            if(event.getSource()==btnInsert)
                monAnInsertUpdateDelete(1);
            if(event.getSource()==btnUpdate)
                monAnInsertUpdateDelete(2);
            if(event.getSource()==btnDelete)
                monAnInsertUpdateDelete(3);
        }
        else
        {
            Alert a =new Alert(Alert.AlertType.WARNING);
            a.setTitle("Cảnh báo");
            a.setHeaderText("");
            a.setContentText("Phải nhập đầy đủ các ô dữ liệu");
            a.showAndWait();
        }
    }
    
}
