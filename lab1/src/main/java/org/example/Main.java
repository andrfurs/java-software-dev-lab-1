package org.example;

import java.util.List;
import java.util.Map;

/**
 * Головний клас для демонстрації генерації, аналізу та статистики хтонічних істот
 */
public class Main {
    /**
     * Основний метод для киконання. Демонструє: збір відфільтрованого списку об'єктів EvilSpirit; фільтрацію за роками
     * з моменту появи; групування духів за типом і виведення результатів на друк; обчислення статистики сили атаки;
     * аналіз викидів
     *
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        List<EvilSpirit> entities = Gatherer.gather(EvilSpiritGenerator.generate(), 25, "Підземний");

        List<EvilSpirit> filteredEntities = Filter.filterByYears(entities, 100, 500);
        Filter.groupAndPrintByType(entities);

        EvilSpiritStatistics stats = filteredEntities.stream()
                .collect(EvilSpiritStatistics.collector());
        System.out.println("Мінімальна сила атаки: " + stats.getMinAttackPower());
        System.out.println("Максимальна сила атаки: " + stats.getMaxAttackPower());
        System.out.println("Середня сила атаки: " + stats.getAverageAttackPower());
        System.out.println("СТандартне відхилення: " + stats.getStandardDeviation());

        Map<String, Long> outliersAnalysis = OutliersAnalysis.analyzeOutliers(entities);
        System.out.println("Викиди: " + outliersAnalysis);
    }
}
