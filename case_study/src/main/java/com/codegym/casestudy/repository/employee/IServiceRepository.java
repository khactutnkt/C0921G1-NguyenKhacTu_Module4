package com.codegym.casestudy.repository.employee;

import com.codegym.casestudy.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface IServiceRepository extends JpaRepository<Service, Long> {
    @Query(value = "select * from service where service_status=1;", nativeQuery = true)
    Page<Service> getAllService(Pageable pageable);
}
