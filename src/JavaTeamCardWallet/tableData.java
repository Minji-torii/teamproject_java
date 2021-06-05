package JavaTeamCardWallet;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.table.AbstractTableModel;

/**
 * 
 */

/**
 * @author 지오
 *
 */
public class tableData extends AbstractTableModel {
	// 리스트 이름 private List<>  list;
	
	public tableData() {
		updateList();
	}
	public void updateList() {
		list = new ArrayList<>();
		try {
		Scanner sc = new Scanner(new File("./data.csv"));
			for(int i=0; sc.hasNextLine(); i++) {
				String[]data = sc.nextLine().split(",");
				if(i !=0) {
			/*	불러올 데이터 클래스 이름 Transaction t = new Transaction();
				 TransactionBuilder tb = new TransactionBuilder(t);			
				t = tb
						.cardNum(Int.parseInt(data[0]))
						.date(Int.parseInt(data[1]))
						.spentAmount(Int.parseInt(data[2])) 
			list.add(t);
			*/
			}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(cell) {
		case 0:
			return list.get(row).getCardNum();
		case 1:	
			return list.get(row).getDate();
		case 2:
			return list.get(row).getAmount();
			
		}
		return null;
	}

}
