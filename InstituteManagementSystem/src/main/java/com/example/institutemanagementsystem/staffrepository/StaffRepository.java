package com.example.institutemanagementsystem.staffrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.institutemanagementsystem.staffentity.StaffEntity;

@Repository
public interface StaffRepository extends JpaRepository<StaffEntity, Long> {

}
