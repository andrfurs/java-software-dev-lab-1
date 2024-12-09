package org.example;

import java.util.List;
import java.util.Map;

/**
 * Клас, який має методи для аналізу викидів у списку об'єктів EvilSpirit на основі сили атаки
 */
public class OutliersAnalysis {
    /**
     * Аналізує викиди у силі атаки списку об'єктів EvilSpirit
     * @param evilSpirits список об'єктів EvilSpirit для аналізу
     * @return поветрає словник з ключами «data»: кількість духів, що не є викидами; «outliers»: кількість духів, що вийшли за межі
     */
    public static Map<String, Long> analyzeOutliers(List<EvilSpirit> evilSpirits) {
        List<Integer> sortedAttackPowers = evilSpirits.stream()
                .map(EvilSpirit::getAttackPower)
                .sorted()
                .toList();

        int q1 = sortedAttackPowers.get(sortedAttackPowers.size() / 4);
        int q3 = sortedAttackPowers.get(sortedAttackPowers.size() * 3 / 4);
        int iqr = q3 - q1;

        double lowerBound = q1 - 1.5 * iqr;
        double upperBound = q3 + 1.5 * iqr;

        long outlierCount = sortedAttackPowers.stream()
                .filter(attackPower -> attackPower < lowerBound || attackPower > upperBound)
                .count();
        return Map.of("data", sortedAttackPowers.size() - outlierCount, "outliners", outlierCount);
    }
}
