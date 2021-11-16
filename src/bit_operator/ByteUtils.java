package bit_operator;

public class ByteUtils {
    public static void main(String[] args) {
        // HEX: 0080004000
        // Byte: 00|80|00|40|00
        var input = "0080004000";
        int k = 2;
        int t = 5;
        var byteResult = findSpecificByte(input, k);
        var bitResult = findSpecificBit(byteResult, t);
        System.out.printf("Byte %d: %s", k, byteResult);
        System.out.println();
        System.out.printf("Bit %d của byte %d: %s", t, k, bitResult);
    }

    // tìm byte thứ k tại vị trí pos
    private static String findSpecificByte(String input, int pos) {
        int maxPosition = input.length() / 2; // vị trí byte tối đa của input
        String value = null;
        if (pos >= 1 && pos <= maxPosition) {
            value = input.substring(2 * pos - 2, 2 * pos); // 2*k - 1, 2*k + 1
        }
        return value;
    }

    // tìm bit tại vị trí bất kì trong byte thứ k
    private static char findSpecificBit(String hex, int index) {
        int decimalValue = 0;
        // đưa hex 80 -> hệ 10: 8 * 16^1 + 0 * 16^0 = 128
        decimalValue += hexToDecimal(hex.charAt(0)) * 16;
        decimalValue += hexToDecimal(hex.charAt(1)) * 1;
        StringBuilder builder = new StringBuilder();
        // đưa giá trị hệ 10 vừa có được về hệ 2
        String binaryString = toBinary(decimalValue);
        char value = ' '; // None hoặc null trong ngôn ngữ robot
        if (index >= 1 && index <= 8) {
            System.out.println("Danh sách bit cấu thành của byte đang xét: " + binaryString);
            // lấy bit tại vị trí index. (do chỉ số string trong java bắt đầu từ 0 nên phải trừ 1)
            value = binaryString.charAt(index - 1);
        }
        return value;
    }

    // lấy giá trị của kí tự biểu diễn hệ hex.
    // kí tự cần lấy ở vị trí nào thì trả về giá trị vị trí tương ứng tại đó
    // tức nếu kí tự là 8 thì giá trị của nó là 8, kí tự là d thì giá trị là 13...
    static int hexToDecimal(char c) {
        String hexCharacters = "0123456789abcdef";
        for (int i = 0; i < hexCharacters.length(); i++) {
            if(Character.toLowerCase(c) == hexCharacters.charAt(i)) {
                return i;
            }
        }
        return 0;
    }

    private static String toBinary(int number) {
        StringBuilder binary = new StringBuilder();
        while (number > 0) {
            binary.append(number % 2);
            number /= 2;
        }
        // thêm các bit 0 vào cho đủ 8 bit của 1 byte
        while(binary.length() < 8) {
            binary.append(0);
        }
        // đảo ngược thứ tự bit và trả về chuỗi bit kết quả
        return binary.reverse().toString();
    }
}
