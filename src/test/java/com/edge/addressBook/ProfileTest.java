package com.edge.addressBook;

import com.edge.addressBook.model.Profile;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProfileTest {

    @Test
    public void testProfileSetters() {
        Profile profile = new Profile();
        profile.setId(1L);
        profile.setName("Camron Whiteman");
        profile.setEmail("camron.whiteman@example.com");

        assertEquals(1L, profile.getId());
        assertEquals("Camron Whiteman", profile.getName());
        assertEquals("camron.whiteman@example.com", profile.getEmail());
    }
}
