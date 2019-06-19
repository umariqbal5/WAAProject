package com.exam.waaproject.repository;

import com.exam.waaproject.domain.Block;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlockRepository extends CrudRepository<Block, Long> {

    @Query("Select b from Block b Where id >= :entryBlockId")
    public List<Block> findBlocksByEntryBlockId(Long entryBlockId);

}
