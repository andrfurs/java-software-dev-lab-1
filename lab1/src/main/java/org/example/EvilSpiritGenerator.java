package org.example;

import java.util.Random;
import java.util.stream.Stream;

/**
 * Генератор, який створює об'єкти типу EvilSpirit з випадковими параметрами
 */
public class EvilSpiritGenerator {
    private static Random random = new Random();
    private static String[] types = {"Водяний", "Повітряний", "Підземний", "Вогняний"};
    private static String[] creatureTypes = {"Демон", "Відьма", "Дракон", "Дух", "Перевертень"};

    /**
     * Генерує нескінченній потік об'єктів типу EvilSpirit з випадковими параметрами
     *
     * @return потік об'єктів типу EvilSpirit
     */
    public static Stream<EvilSpirit> generate() {
        return Stream.generate(() -> {
            String type = types[random.nextInt(types.length)];
            String creatureType = creatureTypes[random.nextInt(creatureTypes.length)];
            int yearsFromAppear = random.nextInt(1000);
            Random random = new Random();
            int rand = random.nextInt(10000);
            int attackPower;
            if (rand < 100) {
                attackPower = rand / 20;
            } else if (rand > 9500) {
                attackPower = 100 + (10000 - rand) / 5;
            } else {
                attackPower = 10 + random.nextInt(90);
            }
            return new EvilSpirit(type, yearsFromAppear, creatureType, attackPower);
        });
    }
}
