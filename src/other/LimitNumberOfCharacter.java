package other;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LimitNumberOfCharacter {
    public static void main(String[] args) {
        String regex  = "^([a-zA-ZẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴ]\s?){2,30}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE|Pattern.UNICODE_CASE|Pattern.CANON_EQ);
        String input = new Scanner(System.in).nextLine();
        Matcher matcher = pattern.matcher(input);
        if(matcher.matches()) {
            System.out.println("OK");
        } else {
            System.out.println("NOT OK");
        }
    }
}
