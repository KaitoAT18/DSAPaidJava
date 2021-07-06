package net.braniumacademy.lesson210.exercises2;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercises4 {
    public static void main(String[] args) {
        int choice;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Scanner input = new Scanner(System.in);
        ArrayList<BankAccount> listAcc = new ArrayList<>();
        createFakeData(listAcc);
        do {
            System.out.println("======================== MENU ========================");
            System.out.println("1. Thêm mới tài khoản vào danh sách.");
            System.out.println("2. Tìm tài khoản theo số tài khoản.");
            System.out.println("3. Xóa tài khoản theo số tài khoản.");
            System.out.println("4. Cập nhật số dư theo số tài khoản.");
            System.out.println("5. Chuyển khoản.");
            System.out.println("6. Sắp xếp danh sách theo số dư giảm dần.");
            System.out.println("7. Tìm tài khoản theo số thẻ.");
            System.out.println("8. Liệt kê các tài khoản trong số thẻ có cụm số x.");
            System.out.println("9. Liệt kê các tài khoản có ngày phát hành x.");
            System.out.println("10. Liệt kê tất cả các tài khoản có số dư >= x.");
            System.out.println("11. Liệt kê tất cả các tài khoản hết hạn tính đến ngày x.");
            System.out.println("12. Liệt kê các tài khoản có tên chủ thẻ là x.");
            System.out.println("13. Hiển thị danh sách tài khoản ra màn hình.");
            System.out.println("0. Thoát chương trình.");
            System.out.println("Bạn chọn? ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("<== Phiên giao dịch kết thúc. Xin chào và hẹn gặp lại quý khách. ==>");
                    break;
                case 1:
                    long ballance;
                    Date startDate = null;
                    Date endDate = null;
                    System.out.println("Tên chủ thẻ: ");
                    String owner = input.nextLine();
                    System.out.println("Số thẻ: ");
                    String cardNumber = input.nextLine();
                    System.out.println("Số tài khoản: ");
                    String accountNumber = input.nextLine();
                    System.out.println("Loại thẻ: ");
                    String cardType = input.nextLine();
                    System.out.println("Tên ngân hàng: ");
                    String bankName = input.nextLine();
                    System.out.println("Số dư: ");
                    ballance = input.nextLong();
                    input.nextLine(); // đọc bỏ kí tự thừa
                    System.out.println("Ngày phát hành, vd: 11/02/2026");
                    try {
                        startDate = dateFormat.parse(input.nextLine());
                        System.out.println("Ngày hết hạn, vd: 20/06/2030");
                        endDate = dateFormat.parse(input.nextLine());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    BankAccount account = new BankAccount(owner, cardNumber, accountNumber,
                            cardType, bankName, startDate, endDate, ballance);
                    listAcc.add(account);
                    break;
                case 2:
                    if (!listAcc.isEmpty()) {
                        System.out.println("Nhập số tài khoản: ");
                        accountNumber = input.nextLine();
                        var index = listAcc.indexOf(new BankAccount(accountNumber));
                        if (index != -1) {
                            System.out.println("Tìm thấy tài khoản có số tài khoản \"" + accountNumber + "\"");
                            showHeader();
                            showBankAccInfo(listAcc.get(index));
                        } else {
                            System.out.println("Tài khoản cần tìm không tồn tại.");
                        }
                    } else {
                        System.out.println("Danh sách tài khoản rỗng.");
                    }
                    break;
                case 3:
                    if (!listAcc.isEmpty()) {
                        System.out.println("Nhập số tài khoản của tài khoản cần xóa: ");
                        cardNumber = input.nextLine();
                        boolean result = listAcc.remove(new BankAccount(cardNumber));

                        if (result) {
                            System.out.println("Xóa thành công.");
                        } else {
                            System.out.println("Không tìm thấy tài khoản có số tài khoản \"" + cardNumber + "\"");
                        }

                    } else {
                        System.out.println("Danh sách tài khoản rỗng.");
                    }
                    break;
                case 4:
                    if (!listAcc.isEmpty()) {
                        System.out.println("Nhập số tài khoản cần cập nhật số dư: ");
                        accountNumber = input.nextLine();
                        int index = listAcc.indexOf(new BankAccount(accountNumber));
                        if (index == -1) {
                            System.out.println("Tài khoản bạn vừa nhập không tồn tại.");
                        } else {
                            System.out.println("Nhập số dư mới: ");
                            ballance = input.nextLong();
                            BankAccount account1 = listAcc.get(index);
                            account1.setBallance(ballance);
                            listAcc.set(index, account1);
                            System.out.println("Cập nhật số dư thành công!");
                        }
                    } else {
                        System.out.println("Danh sách tài khoản rỗng.");
                    }
                    break;
                case 5:
                    System.out.println("Nhập số tài khoản của tài khoản nguồn");
                    String sourceAcc = input.nextLine();
                    int sourceIndex = listAcc.indexOf(new BankAccount(sourceAcc));
                    if (sourceIndex != -1) {
                        System.out.println("Nhập số tài khoản của tài khoản đích");
                        String destAcc = input.nextLine();
                        int destIndex = listAcc.indexOf(new BankAccount(destAcc));
                        if (destIndex == -1) {
                            System.out.println("Tài khoản đích không tồn tại. Vui lòng kiểm tra lại.");
                        } else {
                            System.out.println("Nhập số tiền cần chuyển: ");
                            long amount = input.nextLong();
                            if (listAcc.get(sourceIndex).withdraw(amount)) {
                                if (listAcc.get(destIndex).deposit(amount)) {
                                    System.out.println("Chuyển khoản thành công!");
                                }
                            } else {
                                System.out.println("Tài khoản gốc không đủ để thực hiện giao dịch này!");
                            }
                        }
                    } else {
                        System.out.println("Tài khoản nguồn không tồn tại. Vui lòng kiểm tra lại.");
                    }
                    break;
                case 6:
                    if (!listAcc.isEmpty()) {
                        listAcc.sort(new SortingByBallanceDESC());
                        System.out.println("Sắp xếp danh sách thành công!");
                    } else {
                        System.out.println("Danh sách tài khoản rỗng.");
                    }
                    break;
                case 7:
                    if (!listAcc.isEmpty()) {
                        int count = 0;
                        System.out.println("Nhập số thẻ: ");
                        cardNumber = input.nextLine();
                        for (var acc : listAcc) {
                            if (acc.getCardNumber().compareTo(cardNumber) == 0) {
                                showBankAccInfo(acc);
                                count++;
                                break;
                            }
                        }
                        if (count == 0) {
                            System.out.println("Không tìm thấy tài khoản nào!");
                        }
                    } else {
                        System.out.println("Danh sách tài khoản rỗng.");
                    }
                    break;
                case 8:
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
                case 9:
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
                case 10:
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
                case 11:
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
                case 12:
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
                case 13:
                    if (!listAcc.isEmpty()) {
                        showHeader();
                        showListElements(listAcc);
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

    private static void showListElements(ArrayList<BankAccount> listAcc) {
        for (var e : listAcc) {
            showBankAccInfo(e);
        }
    }

    private static void showHeader() {
        System.out.printf("%-25s%-20s%-20s%-15s%-20s%-15s%-15s%-20s\n",
                "Chủ thẻ", "Số thẻ", "Số TK", "Loại thẻ", "Ngân hàng",
                "Ngày PH", "Hạn SD", "Số dư");
    }

    private static void createFakeData(ArrayList<BankAccount> listAcc) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Scanner input;
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
            listAcc.add(account);
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
