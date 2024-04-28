import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SolutionBuilder {
    //    Вывести в консоль из строки которую пользователь вводит с клавиатуры все
//    аббревиатуры. Аббревиатурой будем считать слово от 2 до 6 символов, состоящее
//    только из прописных букв, без чисел.
    public static void buildTask1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку:");
        String input = scanner.nextLine() + " ";

        Pattern pattern = Pattern.compile("([А-Я]{2,6}|[A-Z]{2,6})[ -,.:;!?]");
        Matcher matcher = pattern.matcher(input);

        System.out.println("Аббревиатуры в строке:");
        while (matcher.find()) {
            System.out.println(matcher.group().replaceAll("[ -,.:;!?]", ""));
        }
    }

    //    Программа на вход получает произвольный текст. В этом тексте может быть номер
//    документа(один или несколько), емейл и номер телефона. Номер документа в формате:
//    xxxx-xxxx-xx, где x - это любая цифра; номер телефона в формате: +(xx)xxxxxxx. Документ
//    может содержать не всю информацию, т.е. например, может не содержать номер
//    телефона, или другое. Необходимо найти эту информацию и вывести в консоль в
//    формате:
//    email: teachmeskills@gmail.com
//    document number: 1423-1512-51
//    и т.д
    public static void buildTaskStar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст:");
        String input = scanner.nextLine();

        // Поиск адреса электронной почты
        Pattern emailPattern = Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b");
        Matcher emailMatcher = emailPattern.matcher(input);

        // Поиск номера документа
        Pattern documentPattern = Pattern.compile("\\b\\d{4}-\\d{4}-\\d{2}\\b");
        Matcher documentMatcher = documentPattern.matcher(input);

        // Поиск номера телефона
        Pattern phonePattern = Pattern.compile("\\+\\(\\d{2}\\)\\d{7}");
        Matcher phoneMatcher = phonePattern.matcher(input);

        while (emailMatcher.find()) {
            System.out.println("Email: " + emailMatcher.group());
        }

        while (documentMatcher.find()) {
            System.out.println("Номер документа: " + documentMatcher.group());
        }

        while (phoneMatcher.find()) {
            System.out.println("Номер телефона: " + phoneMatcher.group());
        }
    }
}
