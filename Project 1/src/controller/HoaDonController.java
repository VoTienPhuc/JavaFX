/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Util;
import model.HoaDon;
import model.HoaDonDAO;

/**
 * FXML Controller class
 *
 * @author May10
 */
public class HoaDonController implements Initializable {

    @FXML
    private TextField mahd;
    @FXML
    private TextField manv;
    @FXML
    private TextField tongtien;
    @FXML
    private DatePicker dpngay;
    @FXML
    private TextField gio;
    @FXML
    private Button btnInsert;
    @FXML
    private TableView<HoaDon> tbvHoaDon;
    @FXML
    private TableColumn<HoaDon, String> MaHD;
    @FXML
    private TableColumn<HoaDon, String> MaNV;
    @FXML
    private TableColumn<HoaDon, Integer> TongTien;
    @FXML
    private TableColumn<HoaDon, Date> Ngay;
    @FXML
    private TableColumn<HoaDon, Time> Gio;
    @FXML
    private Label txtFullName;
    
    HoaDonDAO dao=new HoaDonDAO();
    private Util user=new Util();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showHoaDon();
        txtFullName.setText("Xin chào "+Util.username);
        setRole(Util.role);
    }    

    private void disableButton()
    {
        btnInsert.setDisable(true);
    }
    
    private void enableButton()
    {
        btnInsert.setDisable(false);
        mahd.setEditable(false);
    }
    
    private void clearText()
    {
        mahd.setText("");
        manv.setText("");
        tongtien.setText("");
        dpngay.setValue(LocalDate.MAX);
    }
    
    private boolean kiemTraRong()
    {
        if(mahd.getText().equals("")||manv.getText().equals("")||tongtien.getText().equals("")||dpngay.getValue().equals(""))
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
     
     public void hoaDonInsertUpdateDelete(int a)
    {
        HoaDon e=new HoaDon();
        e.setMahd(mahd.getText());
        e.setManv(manv.getText());
        e.setTongtien(Integer.parseInt(tongtien.getText()));
        e.setNgay(java.sql.Date.valueOf(dpngay.getValue()));
        e.setGio(gio.getText());
        if(a==1)
            dao.insert(e);
        showHoaDon();
    }
     
    public void showHoaDon()
    {
        ObservableList<HoaDon> list=dao.selectAll();
        MaHD.setCellValueFactory(new PropertyValueFactory<>("mahd"));
        MaNV.setCellValueFactory(new PropertyValueFactory<>("manv"));
        TongTien.setCellValueFactory(new PropertyValueFactory<>("tongtien"));
        Ngay.setCellValueFactory(new PropertyValueFactory<>("ngay"));
        Gio.setCellValueFactory(new PropertyValueFactory<>("gio"));
        tbvHoaDon.setItems(list);
    }

    @FXML
    private void handleActionButton(ActionEvent event) {
        HoaDon e=tbvHoaDon.getSelectionModel().getSelectedItem();
        mahd.setText(e.getMahd());
        manv.setText(e.getManv());
        tongtien.setText(String.valueOf(e.getTongtien()));
        LocalDate date = LocalDate.parse(e.getNgay().toString());
        dpngay.setValue(date);
        mahd.setEditable(false);  
        enableButton();
    }

    @FXML
    private void handleMouseAction(MouseEvent event) {
         if(kiemTraRong()==false)          
            hoaDonInsertUpdateDelete(1);
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
