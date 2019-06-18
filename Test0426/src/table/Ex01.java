package table;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class Ex01 extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex01 frame=new Ex01();
		frame.pack();
		frame.setVisible(true);
	}
	public Ex01()
	{
		MyModel myModel=new MyModel();
		JTable table=new JTable(myModel);
		getContentPane().add(table.getTableHeader(),BorderLayout.NORTH);
		getContentPane().add(table,BorderLayout.CENTER);
	}
	private class MyModel extends AbstractTableModel
	{

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 3;
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return 2;
		}

		@Override
		public Object getValueAt(int row, int col) {
			// TODO Auto-generated method stub
			return "데이타"+(col+1);
		}
		public String getColumnName(int col)
		{
			String str="";
			switch(col)
			{
			case 0:str="하나";
			break;
			case 1:str="둘";
			break;
			case 2:str="셋";
			break;
			}
			return str;
		}
	}
	public interface TableCellRendere
	{
		public Component getTableCellComponent(JTable table,Object value,boolean isSelected,int row,int column);    
	}
}
