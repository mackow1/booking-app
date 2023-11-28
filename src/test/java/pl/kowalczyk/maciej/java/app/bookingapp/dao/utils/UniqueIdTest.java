package pl.kowalczyk.maciej.java.app.bookingapp.dao.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UniqueIdTest {

    @Test
    void generate() {
        // given
        // when
        long firstUniqueId = UniqueId.generate();
        long secondUniqueId = UniqueId.generate();

        // then
        Assertions.assertNotEquals(firstUniqueId, secondUniqueId, "UniqueID's are equal");
    }
}