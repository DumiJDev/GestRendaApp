package ao.dumijdev.gestreandaapp.models;

import java.util.Random;

public class GeneratorUtil {

    private static final Random random = new Random(1);

    public String generate(String nome) {
        StringBuilder generated = new StringBuilder();
        for (String s : nome.split(" ", 2)) {
            generated.append(s, 0, 4);
        }
        return generated.
                append(random.nextInt(100)).
                toString().
                toLowerCase().
                replaceAll(" ", "");
    }

    public String generate() {
        String abc = "abcdefghijklmnopqrstuvwxyz";
        String ABC = abc.toUpperCase();

        StringBuilder generated = new StringBuilder();

        Random random1 = new Random(1);

        while (generated.length() != 12)
            switch (random1.nextInt(4)) {
                case 1:
                    generated.append(abc.charAt(random.nextInt(26)));
                    break;
                case 2:
                    generated.append(ABC.charAt(random.nextInt(26)));
                    break;
                case 3:
                    generated.append(random.nextInt(10));
                    break;
                default:
                    break;
            }
        return generated.toString();
    }
}
