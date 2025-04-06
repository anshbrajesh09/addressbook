package com.edge.addressBook.controller;






import com.edge.addressBook.model.Address;
import com.edge.addressBook.model.Profile;
import com.edge.addressBook.repository.AddressRepository;
import com.edge.addressBook.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profiles")
@Tag(name = "Profiles", description = "Operations related to user profiles and their addresses")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileRepository profileRepository;
    private final AddressRepository addressRepository;

    @Operation(summary = "Get all profiles")
    @GetMapping("/")
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    @Operation(summary = "Get profile by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long id) {
        Optional<Profile> profile = profileRepository.findById(id);
        return profile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create a new profile")
    @PostMapping("/")
    public Profile createProfile(@RequestBody Profile profile) {
        return profileRepository.save(profile);
    }

    @Operation(summary = "Update an existing profile")
    @PutMapping("/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id, @RequestBody Profile profile) {
        if (profileRepository.existsById(id)) {
            profile.setId(id);
            return ResponseEntity.ok(profileRepository.save(profile));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Delete a profile")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
        if (profileRepository.existsById(id)) {
            profileRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Add an address to a profile")
    @PostMapping("/{profileId}/addresses")
    public Address addAddressToProfile(@PathVariable Long profileId, @RequestBody Address address) {
        Profile profile = profileRepository.findById(profileId).orElseThrow(() -> new RuntimeException("Profile not found"));
        address.setProfile(profile);
        return addressRepository.save(address);
    }

    @Operation(summary = "Get all addresses of a profile")
    @GetMapping("/{profileId}/addresses")
    public List<Address> getAddressesForProfile(@PathVariable Long profileId) {
        Profile profile = profileRepository.findById(profileId).orElseThrow(() -> new RuntimeException("Profile not found"));
        return profile.getAddresses();
    }
}

