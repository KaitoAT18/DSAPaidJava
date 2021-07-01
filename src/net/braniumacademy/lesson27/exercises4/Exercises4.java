package net.braniumacademy.lesson27.exercises4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Exercises4 {
    public static void main(String[] args) {
        int choice = 0;
        Scanner input = new Scanner(System.in);
        DoublyLinkedList listAcc = new DoublyLinkedList();
        do {
            System.out.println("============== MENU ==============");
            System.out.println("1. Thêm mới tài khoản vào danh sách.");
            System.out.println("2. Sắp xếp danh sách tài khoản theo tên chủ thẻ a-z.");
            System.out.println("3. Sắp xếp danh sách tài khoản theo số thẻ a-z.");
            System.out.println("4. Sắp xếp danh sách tài khoản số số tài khoản z-a.");
            System.out.println("5. Sắp xếp danh sách tài khoản theo ngày phát hành cũ-mới.");
            System.out.println("6. Sắp xếp danh sách tài khoản theo số dư giảm dần.");
            System.out.println("7. Hiển thị danh sách tài khoản ra màn hình.");
            System.out.println("0. Thoát chương trình.");
            System.out.println("Bạn chọn? ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("<== Phiên giao dịch kết thúc. Xin chào và hẹn gặp lại quý khách. ==>");
                    break;
                case 1:
                    BankAccount account;
                    String owner;
                    String cardNumber;
                    String accountNumber;
                    String cardType;
                    String bankName;
                    long ballance;
                    Date startDate = null;
                    Date endDate = null;
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    System.out.println("Tên chủ thẻ: ");
                    owner = input.nextLine();
                    System.out.println("Số thẻ: ");
                    cardNumber = input.nextLine();
                    System.out.println("Số tài khoản: ");
                    accountNumber = input.nextLine();
                    System.out.println("Loại thẻ: ");
                    cardType = input.nextLine();
                    System.out.println("Tên ngân hàng: ");
                    bankName = input.nextLine();
                    System.out.println("Số dư: ");
                    ballance = input.nextLong();
                    input.nextLine(); // đọc bỏ kí tự thừa
                    System.out.println("Ngày phát hành, vd: 11/02/2026");
                    try {
                        startDate = dateFormat.parse(input.nextLine());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Ngày hết hạn, vd: 20/06/2030");
                    try {
                        endDate = dateFormat.parse(input.nextLine());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    account = new BankAccount(owner, cardNumber, accountNumber,
                            cardType, bankName, startDate, endDate, ballance);
                    listAcc.insertTail(account);
                    break;
                case 2:
                    if (!listAcc.isEmpty()) {
                        listAcc.sort(new SortingByOwner());
                    } else {
                        System.out.println("Danh sách tài khoản rỗng.");
                    }
                    break;
                case 3:
                    if (!listAcc.isEmpty()) {
                        listAcc.sort(new SortingByCardNumber());
                    } else {
                        System.out.println("Danh sách tài khoản rỗng.");
                    }
                    break;
                case 4:
                    if (!listAcc.isEmpty()) {
                        listAcc.sort(new SortingByAccNumber());
                    } else {
                        System.out.println("Danh sách tài khoản rỗng.");
                    }
                    break;
                case 5:
                    if (!listAcc.isEmpty()) {
                        listAcc.sort(new SortingByReleaseDate());
                    } else {
                        System.out.println("Danh sách tài khoản rỗng.");
                    }
                    break;
                case 6:
                    if (!listAcc.isEmpty()) {
                        listAcc.sort(new SortingByBallanceDESC());
                    } else {
                        System.out.println("Danh sách tài khoản rỗng.");
                    }
                    break;
                case 7:
                    if (!listAcc.isEmpty()) {
                        System.out.printf("%-25s%-20s%-20s%-15s%-20s%-15s%-15s%-20s\n",
                                "Chủ thẻ", "Số thẻ", "Số TK", "Loại thẻ", "Ngân hàng",
                                "Ngày PH", "Hạn SD", "Số dư");
                        listAcc.traversalFromHead();
                    } else {
                        System.out.println("Danh sách tài khoản rỗng.");
                    }
                    break;
                default:
                    System.out.println("Sai chức năng, vui lòng kiểm tra lại!");
                    break;
            }
        } while (choice != 0);
    }
}
