/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.dbConnection;
import static Model.dbConnection.connectDB;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author shirk
 */
public class BudgetCategoryDAO {
     Connection con = dbConnection.connectDB();
     
     
    // INSERT new BudgetCategory into database
    public void InsertBudgetCategory(String CategoryName, Double CategoryAmt, Double ThresholdLimit) throws SQLException
    {
        PreparedStatement pst;
        
        pst = con.prepareStatement("INSERT INTO budgetcategories VALUES ?,?,?");
        pst.setString(1, CategoryName);
        pst.setDouble(2, CategoryAmt);
        pst.setDouble(3,ThresholdLimit);
        
        pst.execute();
    }
    // UPDATE existing BudgetCategory
    
    // DELETE BudgeCategory
    
    
  
    public ResultSet getBudgetCategoriesResultSet() throws SQLException
    {        
        PreparedStatement pst;
        ResultSet rs;
        
        pst = con.prepareStatement("Select * from budgetcategories");
        rs = pst.executeQuery();
        return rs;
    }
    
    public ArrayList getBudgetCategoriesArrayList() throws SQLException
    {
        ArrayList<BudgetCategory> categories = new ArrayList<>();
        PreparedStatement pst;
        ResultSet rs;
        
        pst = con.prepareStatement("Select * from budgetcategories");
        rs = pst.executeQuery();
                    
        while(rs.next())
        {
            BudgetCategory category = new BudgetCategory();
            category.setCategoryName(rs.getString("CategoryName"));
            category.setCategoryAmt(rs.getDouble("CategoryAmount"));
            category.setThresholdLimit(rs.getDouble("ThresholdLimit"));
            categories.add(category);
        }         
    return categories;    
    }
    
    public static ObservableList<BudgetCategory> getBudgetCategoriesOList() throws SQLException
    {
        Connection conn = connectDB();
        ObservableList<BudgetCategory> list = FXCollections.observableArrayList();
        
        try {
            PreparedStatement pst = conn.prepareStatement("Select * from budgetcategories");
            ResultSet rs = pst.executeQuery();
            
            while (rs.next())
            {
                list.add(new BudgetCategory(rs.getString("CategoryName"), rs.getDouble("CategoryAmount"), rs.getDouble("ThresholdLimit")));
            }                   
            
        } catch (SQLException ex) {
            Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
         
}
