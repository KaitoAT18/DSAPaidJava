package net.braniumacademy.lesson26.exercises4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Exercises4 {
    public static void main(String[] args) {
        int choice = 8;
        Scanner input = new Scanner(System.in);
        DoublyLinkedList listAcc = new DoublyLinkedList();
        do {
            System.out.println("============== MENU ==============");
            System.out.println("1. Thêm mới tài khoản vào danh sách.");
            System.out.println("2. Xóa tài khoản theo số tài khoản.");
            System.out.println("3. Xóa tài khoản theo số thẻ.");
            System.out.println("4. Xóa tài khoản có số dư nhỏ hơn x.");
            System.out.println("5. Xóa tất cả các tài khoản hết hạn vào hôm nay.");
            System.out.println("6. Xóa tối đa n tài khoản của ngân hàng x.");
            System.out.println("7. Hiển thị danh sách tài khoản ra màn hình.");
            System.out.println("8. Thoát chương trình.");
            System.out.println("Bạn chọn? ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
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
                        System.out.println("Nhập số tài khoản cần xóa: ");
                        accountNumber = input.nextLine();
                        boolean result = listAcc.removeNode(new BankAccount(accountNumber));
                        if (result) {
                            System.out.println("Xóa thành công!");
                        } else {
                            System.out.println("Xóa thất bại!");
                        }
                    } else {
                        System.out.println("Danh sách tài khoản rỗng.");
                    }
                    break;
                case 3:
                    if (!listAcc.isEmpty()) {
                        System.out.println("Nhập số thẻ của tài khoản cần xóa: ");
                        cardNumber = input.nextLine();
                        account = new BankAccount();
                        account.setCardNumber(cardNumber);
                        boolean isRemoved = listAcc.removeNode(account);
                        if (isRemoved) {
                            System.out.println("Xóa tài khoản thành công!");
                        } else {
                            System.out.println("tài khoản cần xóa không tồn tại!");
                        }
                    } else {
                        System.out.println("Danh sách tài khoản rỗng.");
                    }
                    break;
                case 4:
                    if (!listAcc.isEmpty()) {
                        System.out.println("Nhập số dư của tài khoản cần xóa: ");
                        ballance = input.nextLong();
                        boolean isRemoved = false;
                        while (true) {
                            boolean result = listAcc.removeByBallance(ballance);
                            if (!result) {
                                break;
                            } else {
                                isRemoved = true;
                            }
                        }
                        if (isRemoved) {
                            System.out.printf("Các tài khoản có số dư bằng %d đã được xóa khỏi danh sách!\n", ballance);
                        } else {
                            System.out.printf("Không có tài khoản nào có số dư bằng %d.\n", ballance);
                        }
                    } else {
                        System.out.println("Danh sách tài khoản rỗng.");
                    }
                    break;
                case 5:
                    if (!listAcc.isEmpty()) {
                        int counter = 0;
                        while (true) {
                            boolean result = listAcc.removeByEndDate();
                            if (!result) {
                                break;
                            } else {
                                counter++;
                            }
                        }
                        if (counter > 0) {
                            System.out.printf("%d tài khoản đã bị xóa.\n", counter);
                        } else {
                            System.out.println("Không có tài khoản nào hết hạn vào ngày hôm nay.");
                        }
                    } else {
                        System.out.println("Danh sách tài khoản rỗng.");
                    }
                    break;
                case 6:
                    if (!listAcc.isEmpty()) {
                        int n;
                        System.out.println("Nhập số lượng tài khoản tối đa muốn xóa: ");
                        n = input.nextInt();
                        input.nextLine();
                        if (n < 1) {
                            System.out.println("Số lượng tài khoản cần xóa không hợp lệ. Nhập số > 0.");
                        } else {
                            System.out.println("Nhập tên ngân hàng phát hành: ");
                            bankName = input.nextLine();
                            int counter = 0;
                            while (true) {
                                boolean result = listAcc.removeByBankName(bankName);
                                if (!result || counter >= n) {
                                    break;
                                } else {
                                    counter++;
                                }
                            }
                            System.out.printf("%d tài khoản đã bị xóa khỏi danh sách.\n", counter);
                        }
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
                case 8:
                    System.out.println("<== Phiên giao dịch kết thúc. Xin chào và hẹn gặp lại quý khách. ==>");
                    break;
                default:
                    System.out.println("Sai chức năng, vui lòng kiểm tra lại!");
                    break;
            }

        } while (choice != 8);
    }
}
