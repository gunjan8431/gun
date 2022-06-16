package com.Bitwise.TimeSheet.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Bitwise.TimeSheet.model.Resource;
import com.Bitwise.TimeSheet.model.TotalSum;
@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer> {

public Optional<Resource> findByresourseId(int resourseId);

List<Resource> getByTimesheet_Month(String month);

}
