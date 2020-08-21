package cn.sus.edu.partymemberdevelopment.service;

import cn.sus.edu.partymemberdevelopment.entity.PartyBranchCharHistory;
import java.util.Map;

public interface PartyBranchCharHistoryService {

    Map<String, Object> findAll(Map<String, Object> params) throws RuntimeException;

    PartyBranchCharHistory findOne(PartyBranchCharHistory history) throws RuntimeException;

    int addOne(PartyBranchCharHistory history) throws RuntimeException;

    int modifyOne(PartyBranchCharHistory history) throws RuntimeException;

    int deleteOne(Long recordId) throws RuntimeException;

}
