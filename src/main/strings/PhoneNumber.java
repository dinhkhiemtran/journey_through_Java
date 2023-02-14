package main.strings;

public class PhoneNumber {

    private static String WRONG_LENGTH = "incorrect number of digits";
    private static String MORE_THAN_11_DIGITS = "more than 11 digits";
    private static String DIGITS_START_WITH_1 = "11 digits must start with 1";
    private static String ILLEGAL_CHARACTER = "letters not permitted";
    private static String ILLEGAL_PUNCTUATION = "punctuations not permitted";
    private static String AREA_CODE_START_WITH_ZERO = "area code cannot start with zero";
    private static String AREA_CODE_START_WITH_ONE = "area code cannot start with one";
    private static String EXCHANGE_CODE_START_WITH_ZERO = "exchange code cannot start with zero";
    private static String EXCHANGE_CODE_START_WITH_ONE = "exchange code cannot start with one";

    private String inputNumber;

    public PhoneNumber(String rawNumber) {
        inputNumber = processNumber(rawNumber);
    }

    private String processNumber(String rawNumber) {
        if (rawNumber.matches(".*[a-zA-Z].*")) { //regex A-Z,a-Z
            throw new IllegalArgumentException(ILLEGAL_CHARACTER);
        }
        if (!rawNumber.matches("^\\+?[0-9.() -]+$")) {
            throw new IllegalArgumentException(ILLEGAL_PUNCTUATION);
        }
        String digits = rawNumber.replaceAll("\\D+", "");
        if (digits.length() < 10) {
            throw new IllegalArgumentException(WRONG_LENGTH);
        }
        if (digits.length() > 11) {
            throw new IllegalArgumentException(MORE_THAN_11_DIGITS);
        }
        if (digits.length() == 11) {
            if (digits.charAt(0) != '1') {
                throw new IllegalArgumentException(DIGITS_START_WITH_1);
            }
            digits = digits.substring(1);
        }

        if (digits.charAt(0) == '0') {
            throw new IllegalArgumentException(AREA_CODE_START_WITH_ZERO);
        }
        if (digits.charAt(0) == '1') {
            throw new IllegalArgumentException(AREA_CODE_START_WITH_ONE);
        }
        if (digits.charAt(3) == '0') {
            throw new IllegalArgumentException(EXCHANGE_CODE_START_WITH_ZERO);
        }
        if (digits.charAt(3) == '1') {
            throw new IllegalArgumentException(EXCHANGE_CODE_START_WITH_ONE);
        }
        return digits;
    }

    public String getNumber() {
        return this.inputNumber;
    }

    public static void main(String[] args) {
        String number1 = "+1 (613)-995-0253";
        String number2 = "613-995-0253";
        String number3 = "1 613 995 0253";
        String number4 = "613.995.0253";
        String number5 = "6139950253";
        PhoneNumber phoneNumber1 = new PhoneNumber(number1);
        System.out.println(phoneNumber1.getNumber());
        PhoneNumber phoneNumber2 = new PhoneNumber(number2);
        System.out.println(phoneNumber2.getNumber());
        PhoneNumber phoneNumber3 = new PhoneNumber(number3);
        System.out.println(phoneNumber3.getNumber());
        PhoneNumber phoneNumber4 = new PhoneNumber(number4);
        System.out.println(phoneNumber4.getNumber());
        PhoneNumber phoneNumber5 = new PhoneNumber(number5);
        System.out.println(phoneNumber5.getNumber());
    }

}
