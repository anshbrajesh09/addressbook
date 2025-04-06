package com.edge.addressBook;

import com.edge.addressBook.model.Address;
import com.edge.addressBook.model.Profile;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddressTest {

    @Test
    public void testAddressSetters() {
        Profile profile = new Profile();
        profile.setId(1L);
        profile.setName("Camron Whiteman");
        profile.setEmail("camron.whiteman@example.com");

        Address address = new Address();
        address.setId(2L);
        address.setStreet("456 Elm St");
        address.setCity("New City");
        address.setState("New State");
        address.setPostalCode("54321");
        address.setProfile(profile);

        assertEquals(2L, address.getId());
        assertEquals("456 Elm St", address.getStreet());
        assertEquals("New City", address.getCity());
        assertEquals("New State", address.getState());
        assertEquals("54321", address.getPostalCode());
        assertEquals(profile, address.getProfile());
    }
}
