package com.exam.waaproject.repository;

import com.exam.waaproject.domain.Block;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface BlockRepository extends CrudRepository<Block, Long> {

    @Query("Select b from Block b Where id >= ?1")
    public List<Block> findBlocksByEntryBlockId(Long entryBlockId);

    @Query("Select b from Block b Where  ?1 between startDate and endDate")
    public Block findBlockByRange(Date date);

}
