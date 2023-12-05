package pl.kowalczyk.maciej.java.app.bookingapp.dao.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UniqueIdTest {

    @Test
    void whenGenerateTwoRandomNumbers_thenGeneratedNumbersNotEqual() {
        // given
        // when
        long firstUniqueId = UniqueId.generate();
        long secondUniqueId = UniqueId.generate();

        // then
        Assertions.assertNotEquals(firstUniqueId, secondUniqueId, "UniqueID's are equal");
    }

    @Test
    void whenGenerateMultipleRandomNumbers_thenAllOfThemArePositive() {
        // given
        // when
        long firstNumber = UniqueId.generate();
        long secondNumber = UniqueId.generate();
        long thirdNumber = UniqueId.generate();
        long fourthNumber = UniqueId.generate();
        long fifthNumber = UniqueId.generate();
        long sixthNumber = UniqueId.generate();
        long seventhNumber = UniqueId.generate();

        // then
        Assertions.assertAll(
                () -> Assertions.assertTrue(firstNumber > 0),
                () -> Assertions.assertTrue(secondNumber > 0),
                () -> Assertions.assertTrue(thirdNumber > 0),
                () -> Assertions.assertTrue(fourthNumber > 0),
                () -> Assertions.assertTrue(fifthNumber > 0),
                () -> Assertions.assertTrue(sixthNumber > 0),
                () -> Assertions.assertTrue(seventhNumber > 0)
        );
    }
}