package com.exam.waaproject.services;

import com.exam.waaproject.domain.Block;

import java.util.Date;
import java.util.List;


public interface BlockService {

    public List<Block> getAll();

    public List<Block> getBlocksByEntryBlockId(Long entryBlockId);

    public Block findBlockByRange(Date date);

    public Block save(Block block);

}
