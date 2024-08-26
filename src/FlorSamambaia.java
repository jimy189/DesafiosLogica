public class Desafio2 {

    public static String tentativaDesenhar(int r1, int x1, int y1, int r2, int x2, int y2) {
        // Calcula a distância entre os centros dos dois círculos
        double distanciaCentros = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        // Verifica se o círculo do caçador cobre totalmente o círculo da flor
        if (distanciaCentros + r2 <= r1) {
            return "RICO";
        } else {
            return "MORTO";
        }
    }

    public static void main(String[] args) {

        // Testes
        System.out.println(tentativaDesenhar(5, 0, 0, 3, 1, 1)); // RICO
        System.out.println(tentativaDesenhar(5, 0, 0, 3, 4, 4)); // MORTO
        System.out.println(tentativaDesenhar(10, 5, 5, 4, 5, 5)); // RICO
        System.out.println(tentativaDesenhar(7, 0, 0, 5, 10, 10)); // MORTO

    }
}
