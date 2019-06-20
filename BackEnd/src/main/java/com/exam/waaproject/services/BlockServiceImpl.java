package com.exam.waaproject.services;

import com.exam.waaproject.domain.Block;
import com.exam.waaproject.repository.BlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BlockServiceImpl implements BlockService {

    @Autowired
    BlockRepository blockRepository;

    @Override
    public List<Block> getAll() {
        return (List<Block>) blockRepository.findAll();
    }

    @Override
    public List<Block> getBlocksByEntryBlockId(Long entryBlockId) {
        return blockRepository.findBlocksByEntryBlockId(entryBlockId);
    }

    @Override
    public Block findBlockByRange(Date date) {
        return blockRepository.findBlockByRange(date);
    }

    @Override
    public Block save(Block block) {
        return blockRepository.save(block);
    }

}
