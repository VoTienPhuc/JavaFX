/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;
import model.NhanVien;
import model.NhanVienDAO;
import model.Util;

/**
 * FXML Controller class
 *
 * @author May10
 */
public class NhanVienController implements Initializable {
    @FXML
    private Button btnInsert;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;

    NhanVienDAO dao=new NhanVienDAO();

    @FXML
    private Label txtFullName;   
    private Util user=new Util();
    @FXML
    private TableColumn<NhanVien, String> MaNV;
    @FXML
    private TableColumn<NhanVien, String> HoTen;
    @FXML
    private TableColumn<NhanVien, Integer> NgaySinh;
    @FXML
    private TableColumn<NhanVien, String> SDT;
    @FXML
    private TableColumn<NhanVien, Integer> TrangThai;
    @FXML
    private TextField manv;
    @FXML
    private TextField hoten;
    @FXML
    private TextField sdt;
    @FXML
    private TextField trangthai;
    @FXML
    private TableView<NhanVien> tbvNhanVien;
    @FXML
    private DatePicker dpngaysinh;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        showNhanVien();
        disableButton();
        txtFullName.setText("Xin chào "+Util.username);
        setRole(Util.role);
    }
    
    private void disableButton()
    {
        btnInsert.setDisable(true);
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
    }
       
    private void setRole(int role)
    {
        if(role==3)
           disableButton();
        if(role==1)
            enableButton();
    }
    private void enableButton()
    {
        btnInsert.setDisable(false);
        btnUpdate.setDisable(false);
        btnDelete.setDisable(false);
        MaNV.setEditable(false);
    }
    
    private void clearText()
    {
        manv.setText("");
        hoten.setText("");
        dpngaysinh.setValue(LocalDate.now());
        sdt.setText("");
        trangthai.setText("");
    }
    
    private boolean kiemTraRong()
    {
        if(manv.getText().equals("")||hoten.getText().equals("")||sdt.getText().equals("")||trangthai.getText().equals(0))
            return true;
        return false;
    }
    
    public void showNhanVien()
    {
        try {
            ObservableList<NhanVien> list=dao.selectAll();
            MaNV.setCellValueFactory(new PropertyValueFactory<>("manv"));
            HoTen.setCellValueFactory(new PropertyValueFactory<>("hoten"));
            NgaySinh.setCellValueFactory(new PropertyValueFactory<>("ngaysinh"));
            SDT.setCellValueFactory(new PropertyValueFactory<>("sdt"));
            TrangThai.setCellValueFactory(new PropertyValueFactory<>("trangthai"));
            tbvNhanVien.setItems(list);
        } catch (Exception e) {
            e.toString();
        } 
    }
    
    public void employeeInsertUpdateDelete(int a)
    {
        try {
            NhanVien e=new NhanVien();
            e.setManv(manv.getText());
            e.setHoten(hoten.getText());

            e.setSdt(sdt.getText());
            e.setTrangthai(Integer.parseInt(trangthai.getText()));
            if(a==1)
                dao.insert(e);
            else if(a==2)
                dao.update(e);
                else
                    dao.delete(e);
            showNhanVien();
        } catch (Exception e) {
            e.toString();
        }
    }
   
    @FXML
    private void handleMouseAction(MouseEvent event) {
        NhanVien e=tbvNhanVien.getSelectionModel().getSelectedItem();
        manv.setText(e.getManv());
        hoten.setText(e.getHoten());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        sdt.setText(e.getSdt());
        trangthai.setText(""+e.getTrangthai());
        dpngaysinh.setValue(LocalDate.parse(e.getNgaysinh().toString(),formatter));
        manv.setEditable(false); 
        
        enableButton();
    }

    @FXML
    private void handleActionButton(ActionEvent event) {
        if(kiemTraRong()==false)
        {
            if(event.getSource()==btnInsert)
                employeeInsertUpdateDelete(1);
            if(event.getSource()==btnUpdate)
                employeeInsertUpdateDelete(2);
            if(event.getSource()==btnDelete)
                employeeInsertUpdateDelete(3);
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
