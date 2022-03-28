
package Controller;

import Model.BudgetCategory;
import Model.BudgetCategoryDAO;
import Model.dbConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;


public class BudgetCategoryController implements Initializable
{
    @FXML
    private TableView<BudgetCategory> tblView = new TableView<>();
    @FXML
    private TableColumn<BudgetCategory, String> col_Name;
    @FXML
    private TableColumn<BudgetCategory, Double> col_Amt;
    @FXML
    private TableColumn<BudgetCategory, Double> col_ThreshLimit;
    @FXML
    private Button btnSave;
    
    // laod event - SELECT ALL
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        col_Name.setCellValueFactory(new PropertyValueFactory<>("CategoryName"));
        col_Amt.setCellValueFactory(new PropertyValueFactory<>("CategoryAmt"));
        col_ThreshLimit.setCellValueFactory(new PropertyValueFactory<>("ThresholdLimit"));
        ObservableList<BudgetCategory> catList;
        try{        
            catList = BudgetCategoryDAO.getBudgetCategoriesOList();        
            tblView.setItems(catList);
        } catch (SQLException ex) {
            Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }    
    
    // INSERT
    
    // UPDATE
    
    // DELETE
}
