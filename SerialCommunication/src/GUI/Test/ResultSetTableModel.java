/**
 * Project Name: DatabaseGUI
 * Class Name: ResultSetTableModel
 * Engineers: Team Awesome 
 * Creation Date: Apr 25, 2014
 * Description:
 */
package GUI.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class ResultSetTableModel extends AbstractTableModel {
    
    private ResultSet resultSet; 
    private ResultSetMetaData metaData;

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
        if (resultSet != null) {
            try {
                metaData = resultSet.getMetaData();
                fireTableStructureChanged();
            } catch (SQLException ex) {
                Logger.getLogger(ResultSetTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
   
    @Override
    public int getRowCount() {
        int numberOfRows = 0;
        if (resultSet != null) {
            try {
                resultSet.last();
                numberOfRows = resultSet.getRow();
            } catch (SQLException ex) {
                Logger.getLogger(ResultSetTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }      
        }
        return numberOfRows;
    }

    @Override
    public int getColumnCount() {
        int numberOfColumns = 0;
        if (metaData != null) {
            try {
                numberOfColumns = metaData.getColumnCount();
            } catch (SQLException ex) {
                Logger.getLogger(ResultSetTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return numberOfColumns;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (resultSet != null) {
            try {
                resultSet.absolute(rowIndex+1);
                return resultSet.getObject(columnIndex+1);
            } catch (SQLException ex) {
                Logger.getLogger(ResultSetTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }      
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (metaData != null) {
            try {
                return metaData.getColumnName(column+1);
            } catch (SQLException ex) {
                Logger.getLogger(ResultSetTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (metaData != null) {
            try {
                String className = metaData.getColumnName(columnIndex+1);
                return Class.forName(className);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ResultSetTableModel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ResultSetTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return Object.class;
    }   
}
