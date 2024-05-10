package pl.kowalczyk.maciej.java.app.bookingapp.config.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.kowalczyk.maciej.java.app.bookingapp.api.core.RoleType;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.RoleEntity;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BookingAppUserDetailServiceTest {

    @Test
    void convertRolesToStringArray() {
        // given
        BookingAppUserDetailService bookingAppUserDetailService = new BookingAppUserDetailService();

        RoleEntity roleEntityService = new RoleEntity();
        roleEntityService.setName(RoleType.SERVICE);

        RoleEntity roleEntityGuest = new RoleEntity();
        roleEntityGuest.setName(RoleType.GUEST);

        Set<RoleEntity> roles = new HashSet<>();
        roles.add(roleEntityService);
        roles.add(roleEntityGuest);

        // when
        String[] rolesAsStrings = bookingAppUserDetailService.convertRolesToStringArray(roles);
        int arrayLength = rolesAsStrings.length;

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(rolesAsStrings, "Array is NULL"),
                () -> Assertions.assertEquals(2, arrayLength, "Table length is not equal 2")
        );
    }
}