package com.edge.addressBook.repository;

import com.edge.addressBook.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
