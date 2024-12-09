package org.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Збирає і фільтрує потік об'єктів EvilSpirit за роками появи у літературі
 */
public class Gatherer {
    /**
     * Збирає до 500 об'єктів EvilSpirit із заданого потоку, пропускаючи вказану кількість і виключаючи хтонічні істоти
     * певного типу
     *
     * @param stream     потік об'єктів EvilSpirit
     * @param skipNum    кількість об'єктів EvilSpirit, які потрібно пропустити
     * @param typeToSkip тип, який потрібно виключити з результатів
     * @return список об'єктів EvilSpirit, які відповідають критеріям
     */
    public static List<EvilSpirit> gather(Stream<EvilSpirit> stream, int skipNum, String typeToSkip) {
        return stream.filter(evilSpirit -> !evilSpirit.getType().equals(typeToSkip))
                .skip(skipNum)
                .limit(500)
                .collect(Collectors.toList());
    }
}
