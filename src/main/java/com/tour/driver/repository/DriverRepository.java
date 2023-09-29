package com.tour.driver.repository;


import com.tour.driver.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;


@EnableJpaRepositories
@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    List<Driver> findByNameContaining(String name);

}
