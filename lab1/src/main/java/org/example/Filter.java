package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Клас, який має методи для фільтрування та групуваання об'єктів типу EvilSpirit
 */
public class Filter {
    /**
     * Фільтрує список хтонічних істот за роками ії згадки у літературі за вказаним діапазоном
     *
     * @param evilSpiritList список об'єктів EvilSpirit для фільтрування
     * @param minYears       мінімальна кількість років з моменту появи у літературі
     * @param maxYears       максимальна кількість років з моменту появи у літературі
     * @return список об'єктів EvilSpirit, які потрапляють у вказаний діапазон
     */
    public static List<EvilSpirit> filterByYears(List<EvilSpirit> evilSpiritList, int minYears, int maxYears) {
        return evilSpiritList.stream()
                .filter(evilSpirit -> minYears <= evilSpirit.getYearsFromAppear()
                        && evilSpirit.getYearsFromAppear() <= maxYears)
                .toList();
    }

    /**
     * Групує об'єкти EvilSpirit за типами і виводить кількість об'єктів кожного типу
     *
     * @param evilSpirits список об'єктів EvilSpirit для групування
     */
    public static void groupAndPrintByType(List<EvilSpirit> evilSpirits) {
        Map<String, List<EvilSpirit>> grouped = evilSpirits.stream()
                .collect(Collectors.groupingBy(EvilSpirit::getType));
        grouped.forEach((type, evilSpiritList) -> System.out.println(
                "Тип: " + type + "; Кількість: " + evilSpiritList.size()));
    }
}