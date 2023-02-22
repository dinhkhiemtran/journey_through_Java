package main.encode_decode;

public class RunLengthEncoding {

    public String encode(String code) {
        StringBuilder encoded = new StringBuilder();
        int counter = 1;
        for (int i = 0; i < code.length() - 1; i++) {
            if (code.charAt(i) != code.charAt(i + 1)) {
                if (counter > 1) {
                    encoded.append(counter);
                }
                encoded.append(code.charAt(i));
                counter = 1;
                if (i == code.length() - 2) {
                    encoded.append(code.charAt(i + 1));
                }
            } else {
                counter++;
                if (i == code.length() - 2) {
                    if (counter > 1) {
                        encoded.append(counter);
                    }
                    encoded.append(code.charAt(i + 1));
                }
            }
        }
        return encoded.toString();
    }

    public String decode(String decode) {
        StringBuilder decoded = new StringBuilder();
        for (int i = 0; i < decode.length(); i++) {
            if (Character.isDigit(decode.charAt(i))) {
                int count = Character.getNumericValue(decode.charAt(i));
                if (Character.isDigit(decode.charAt(i + 1))) {
                    StringBuilder digits = new StringBuilder();
                    digits.append(decode.charAt(i));
                    digits.append(decode.charAt(i + 1));
                    count = Integer.parseInt(digits.toString());
                    i++;
                    for (int k = 0; k < count; k++) {
                        decoded.append(decode.charAt(i + 1));
                    }
                } else {
                    for (int k = 0; k < count; k++) {
                        decoded.append(decode.charAt(i + 1));
                    }
                }
            } else {
                if (i == 0) {
                    decoded.append(decode.charAt(i));
                } else if (!Character.isDigit(decode.charAt(i - 1))) {
                    decoded.append(decode.charAt(i));
                }
            }
        }
        return decoded.toString();
    }
}
