package net.braniumacademy.lesson24.exercises4;

import javax.management.MBeanRegistration;
import java.util.Scanner;

public class Exercises4 {
    public static void main(String[] args) {
        DoublyLinkedList<BankAccount> listBankAccount = new DoublyLinkedList<>();
        Scanner input = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("=============== MENU ===============");
            System.out.println("1. Thêm tài khoản mới.");
            System.out.println("2. Cập nhật số dư.");
            System.out.println("3. Hiện danh sách tài khoản hiện có.");
            System.out.println("0. Thoát chương trình.");
            System.out.println("Xin mời chọn: ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    BankAccount acc = createBankAcc(input);
                    listBankAccount.insertTail(acc);
                    break;
                case 2:
                    System.out.println("Nhập số tài khoản cần cập nhật: ");
                    String accNumber = input.nextLine();
                    var foundNode = listBankAccount.getNode(new BankAccount(accNumber));
                    if (foundNode != null) {
                        System.out.println("Nhập số dư mới: ");
                        BankAccount bankAccount = foundNode.getData();
                        long ballance = Long.parseLong(input.nextLine());
                        bankAccount.setBallance(ballance);
                        listBankAccount.updateNodeData(foundNode, bankAccount);
                        System.out.println("Cập nhật số dư thành công.");
                    } else {
                        System.out.println("Tài khoản này không tồn tại. Cập nhật số dư thất bại.");
                    }
                    break;
                case 3:
                    System.out.println("Danh sách tài khoản: ");
                    listBankAccount.traversalFromHead();
                    break;
                case 0:
                    System.out.println("<== CẢM ƠN QUÝ KHÁCH ĐÃ SỬ DỤNG DỊCH VỤ ==>");
                    break;
            }
        } while (choice != 0);
    }

    private static BankAccount createBankAcc(Scanner input) {
        BankAccount account = new BankAccount();
        System.out.println("Số thẻ: ");
        String cardNumber = input.nextLine();
        System.out.println("Số tài khoản: ");
        String accNumber = input.nextLine();
        System.out.println("Tên chủ thẻ: ");
        String owner = input.nextLine();
        System.out.println("Ngân hàng phát hành thẻ: ");
        String bankName = input.nextLine();
        System.out.println("Số dư: ");
        long ballance = Long.parseLong(input.nextLine());
        account.setAccountNumber(accNumber);
        account.setCardNumber(cardNumber);
        account.setOwner(owner);
        account.setBankName(bankName);
        account.setBallance(ballance);
        return account;
    }

}
