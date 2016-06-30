/**
 * 
 */
package bank;

import javax.swing.JOptionPane;

import global.Constants;

/**
 * @date     : 2016. 6. 15.
 * @author   : jun.dev
 * @fileName : BankController.java
 * @story    : 
 */
public class BankController {
	String s = "";
	public static void main(String[] args) {
		AccountServiceImpl service = new AccountServiceImpl();
		AccountBean bean = null;
		while (true) {
			switch (JOptionPane.showInputDialog("1.개설. 2.입금 3.조회. 4.출금 5.통장내역 6.통장해지 0.종료")) {
			case "1":
				String spec = JOptionPane.showInputDialog("이름,ID,PW");
				String result[] = spec.split(",");
				service.openAccount(result[0],result[1],result[2]);
				break;
			case "2":
				String inputMoney = JOptionPane.showInputDialog("입금액?");
				service.deposit(Integer.parseInt(inputMoney));
				JOptionPane.showMessageDialog(null, "잔액 : "+service.findAccount()+"원");
				break;
			case "3":
				JOptionPane.showMessageDialog(null, "잔액 : "+service.findAccount()+"원");
				break;
			case "4":
				String outputMoney = JOptionPane.showInputDialog("출금액?");
				JOptionPane.showMessageDialog(null, service.withdraw(Integer.parseInt(outputMoney)));
				break;
			case "5":
				JOptionPane.showMessageDialog(null,service.showAccount());
				break;
			case "6":
				JOptionPane.showMessageDialog(null,service.deleteAccount());
				break;
			case "0":
				JOptionPane.showConfirmDialog(null, "종료하시겠습니까?");
				return;
			default:JOptionPane.showMessageDialog(null, "1~4의 메뉴를 입력해주세요");
			return;
			}
		}
	}
}
