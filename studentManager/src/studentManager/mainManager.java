package studentManager;

import java.sql.DatabaseMetaData;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;



public class mainManager extends JFrame  {
	private JTextArea textArea = new JTextArea();
	public static final connectData test = new connectData("127.0.0.1",3306,"root","","students");
	public JTable table = new JTable();
	public mainManager(){
		validate();
		pack();
	}
	public static void main(String[] args) {	
		List<ColsInfo> list =  test.getIn("stud");
		for(int i = 0; i<list.size() ; i++){
			System.out.printf("%s[%s:%d:%b] ",list.get(i).getColTitle(),list.get(i).getColType(),list.get(i).getColSize(),list.get(i).isAutoIncrement());
		}
		System.out.println("\n");
		for(int c = 0 ; c<test.getDataFromDB("stud").get(0).size() ; c++){
			for(int x = 0 ; x< test.getDataFromDB("stud").size(); x++){
	
						System.out.print(test.getDataFromDB("stud").get(x).get(c).toString()+" ");
			}
			System.out.println("\n");
		}
	}
}
class tabElka  implements TableModel{
	public tabElka(){
		
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}
	
}