import java.util.HashMap;
import java.util.Map;

public class Desafio1 {
    // Mapeia os dígitos para as cores correspondentes
    private static final Map<Character, String> colorMap = new HashMap<>();

    static {
        colorMap.put('0', "preto");
        colorMap.put('1', "marrom");
        colorMap.put('2', "vermelho");
        colorMap.put('3', "laranja");
        colorMap.put('4', "amarelo");
        colorMap.put('5', "verde");
        colorMap.put('6', "azul");
        colorMap.put('7', "violeta");
        colorMap.put('8', "cinza");
        colorMap.put('9', "branco");
    }

    public static String getResistorColorCode(String input) {
        String[] parts = input.split(" ");
        String value = parts[0];
        StringBuilder colorCode = new StringBuilder();

        if (value.contains("k")) { // Casos de 1k a 999k ohms
            double number = Double.parseDouble(value.replace("k", ""));
            int firstDigit = (int) number;
            int secondDigit = (int) (number * 10) % 10;
            int multiplier = 2;

            colorCode.append(colorMap.get((char) ('0' + firstDigit))).append(" ");
            colorCode.append(colorMap.get((char) ('0' + secondDigit))).append(" ");
            colorCode.append(colorMap.get((char) ('0' + multiplier))).append(" ");
        } else if (value.contains("M")) { // Casos de 1M a 999M ohms
            double number = Double.parseDouble(value.replace("M", ""));
            int firstDigit = (int) number;
            int secondDigit = (int) (number * 10) % 10;
            int multiplier = 5;

            colorCode.append(colorMap.get((char) ('0' + firstDigit))).append(" ");
            colorCode.append(colorMap.get((char) ('0' + secondDigit))).append(" ");
            colorCode.append(colorMap.get((char) ('0' + multiplier))).append(" ");
        } else { // Casos de até 999 ohms
            int ohmsValue = Integer.parseInt(value);
            String ohmsStr = String.valueOf(ohmsValue);
            int multiplier = ohmsStr.length() - 2;

            colorCode.append(colorMap.get(ohmsStr.charAt(0))).append(" ");
            colorCode.append(colorMap.get(ohmsStr.charAt(1))).append(" ");
            colorCode.append(colorMap.get((char) ('0' + multiplier))).append(" ");
        }

        colorCode.append("dourado"); // Tolerância padrão de 5%

        return colorCode.toString().trim();
    }

    public static void main(String[] args) {
        // Testes
        System.out.println(getResistorColorCode("10 ohms"));
        System.out.println(getResistorColorCode("100 ohms"));
        System.out.println(getResistorColorCode("220 ohms"));
        System.out.println(getResistorColorCode("330 ohms"));
        System.out.println(getResistorColorCode("470 ohms"));
        System.out.println(getResistorColorCode("680 ohms"));
        System.out.println(getResistorColorCode("1k ohms"));
        System.out.println(getResistorColorCode("2M ohms"));
    }
}
