package net.braniumacademy.lesson28.exercises4;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.PrimitiveIterator;
import java.util.Scanner;

public class Exercises4 {
    public static void main(String[] args) {
        int choice = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Scanner input = new Scanner(System.in);
        DoublyLinkedList listAcc = new DoublyLinkedList();
        createFakeData(listAcc);
        do {
            System.out.println("============== MENU ==============");
            System.out.println("1. Thêm mới tài khoản vào danh sách.");
            System.out.println("2. Tìm tài khoản theo số tài khoản.");
            System.out.println("3. Tìm tài khoản theo số thẻ.");
            System.out.println("4. Tìm tài khoản có mã thẻ chứa cụm số x nhập vào từ bàn phím.");
            System.out.println("5. Liệt kê tất cả các tài khoản phát hành vào ngày x.");
            System.out.println("6. Liệt kê tất cả các tài khoản có số dư >= x.");
            System.out.println("7. Liệt kê tất cả các tài khỏan hết hạn vào ngày x.");
            System.out.println("8. Liệt kê các tài khoản có tên chủ thẻ là x.");
            System.out.println("9. Hiển thị danh sách tài khoản ra màn hình.");
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
                        System.out.println("Nhập số tài khoản: ");
                        accountNumber = input.nextLine();
                        var result = listAcc.search(new BankAccount(accountNumber));
                        if (result != null) {
                            System.out.println("Tìm thấy tài khoản có số tài khoản \"" + accountNumber + "\"");
                            showHeader();
                            showBankAccInfo(result.getData());
                        } else {
                            System.out.println("Tài khoản cần tìm không tồn tại.");
                        }
                    } else {
                        System.out.println("Danh sách tài khoản rỗng.");
                    }
                    break;
                case 3:
                    if (!listAcc.isEmpty()) {
                        System.out.println("Nhập vào số thẻ: ");
                        cardNumber = input.nextLine();
                        int counter = 0;
                        for (var e : listAcc) {
                            if (e.getCardNumber().compareTo(cardNumber) == 0) {
                                System.out.println("Tìm thấy tài khoản có số thẻ \"" + e.getCardNumber() + "\"");
                                showHeader();
                                showBankAccInfo(e);
                                counter++;
                                break;
                            }
                        }
                        if (counter == 0) {
                            System.out.println("Không tìm thấy tài khoản với số thẻ \"" + cardNumber + "\"");
                        }

                    } else {
                        System.out.println("Danh sách tài khoản rỗng.");
                    }
                    break;
                case 4:
                    if (!listAcc.isEmpty()) {
                        System.out.println("Nhập cụm số trong số thẻ cần tìm: ");
                        String key = input.nextLine();
                        int countResult = 0;
                        showHeader();
                        for (var acc : listAcc) {
                            if (acc.getCardNumber().matches(".*" + key + ".*")) {
                                showBankAccInfo(acc);
                                countResult++;
                            }
                        }
                        if (countResult == 0) {
                            System.out.println("Không tìm thấy kết quả nào.");
                        }
                    } else {
                        System.out.println("Danh sách tài khoản rỗng.");
                    }
                    break;
                case 5:
                    if (!listAcc.isEmpty()) {
                        System.out.println("Nhập ngày phát hành cần tìm, vd 20/01/2025: ");
                        String releaseDate = input.nextLine();
                        int countResult = 0;
                        showHeader();
                        for (var acc : listAcc) {
                            if (dateFormat.format(acc.getReleaseDate()).compareTo(releaseDate) == 0) {
                                showBankAccInfo(acc);
                                countResult++;
                            }
                        }
                        if (countResult == 0) {
                            System.out.println("Không tìm thấy kết quả nào.");
                        }
                    } else {
                        System.out.println("Danh sách tài khoản rỗng.");
                    }
                    break;
                case 6:
                    if (!listAcc.isEmpty()) {
                        System.out.println("Nhập số dư cần tìm: ");
                        ballance = input.nextLong();
                        int countResult = 0;
                        showHeader();
                        for (var acc : listAcc) {
                            if (acc.getBallance() >= ballance) {
                                showBankAccInfo(acc);
                                countResult++;
                            }
                        }
                        if (countResult == 0) {
                            System.out.println("Không tìm thấy kết quả nào.");
                        }
                    } else {
                        System.out.println("Danh sách tài khoản rỗng.");
                    }
                    break;
                case 7:
                    if (!listAcc.isEmpty()) {
                        System.out.println("Nhập ngày hết hạn cần tìm, vd 20/01/2025: ");
                        String expiryDate = input.nextLine();
                        try {
                            Date giventDate = dateFormat.parse(expiryDate);
                            int countResult = 0;
                            showHeader();
                            for (var acc : listAcc) { // quy đổi ra mili giây cho dễ so sánh
                                if (acc.getExpirationDate().getTime() <= giventDate.getTime()) {
                                    showBankAccInfo(acc);
                                    countResult++;
                                }
                            }
                            if (countResult == 0) {
                                System.out.println("Không tìm thấy kết quả nào.");
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                    } else {
                        System.out.println("Danh sách tài khoản rỗng.");
                    }
                    break;
                case 8:
                    if (!listAcc.isEmpty()) {
                        System.out.println("Nhập tên chủ thẻ: ");
                        String name = input.next(); // chỉ nhập TÊN please!
                        int countResult = 0;
                        showHeader();
                        for (var acc : listAcc) {
                            int lastIndexOfSpace = acc.getOwner().lastIndexOf(" ");
                            String firtName = acc.getOwner().substring(lastIndexOfSpace + 1);
                            if (firtName.compareTo(name) == 0) {
                                showBankAccInfo(acc);
                                countResult++;
                            }
                        }
                        if (countResult == 0) {
                            System.out.println("Không tìm thấy kết quả nào.");
                        }
                    } else {
                        System.out.println("Danh sách tài khoản rỗng.");
                    }
                    break;
                case 9:
                    if (!listAcc.isEmpty()) {
                        showHeader();
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

    private static void showHeader() {
        System.out.printf("%-25s%-20s%-20s%-15s%-20s%-15s%-15s%-20s\n",
                "Chủ thẻ", "Số thẻ", "Số TK", "Loại thẻ", "Ngân hàng",
                "Ngày PH", "Hạn SD", "Số dư");
    }

    private static void createFakeData(DoublyLinkedList listAcc) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Scanner input = null;
        try {
            input = new Scanner(new File("bankacc.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        while (input.hasNextLine()) {
            Date startDate = null;
            Date endDate = null;
            String owner = input.nextLine();
            String cardNumber = input.nextLine();
            String accountNumber = input.nextLine();
            String cardType = input.nextLine();
            String bankName = input.nextLine();
            try {
                startDate = dateFormat.parse(input.nextLine());
                endDate = dateFormat.parse(input.nextLine());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            long ballance = Long.parseLong(input.nextLine());
            BankAccount account = new BankAccount(owner, cardNumber, accountNumber,
                    cardType, bankName, startDate, endDate, ballance);
            listAcc.insertTail(account);
        }
    }

    private static void showBankAccInfo(BankAccount acc) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        System.out.printf("%-25s%-20s%-20s%-15s%-20s%-15s%-15s%-20d\n",
                acc.getOwner(), acc.getCardNumber(),
                acc.getAccountNumber(), acc.getCardType(),
                acc.getBankName(), format.format(acc.getReleaseDate()),
                format.format(acc.getExpirationDate()), acc.getBallance());
    }
}
