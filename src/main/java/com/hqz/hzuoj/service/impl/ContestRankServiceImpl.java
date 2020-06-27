package com.hqz.hzuoj.service.impl;

import com.hqz.hzuoj.entity.model.ContestRank;
import com.hqz.hzuoj.mapper.ContestRankMapper;
import com.hqz.hzuoj.service.ContestRankService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ContestRank)表服务实现类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
@Service("contestRankService")
public class ContestRankServiceImpl implements ContestRankService {
    @Resource
    private ContestRankMapper contestRankMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param contestRankId 主键
     * @return 实例对象
     */
    @Override
    public ContestRank queryById(Integer contestRankId) {
        return this.contestRankMapper.queryById(contestRankId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ContestRank> queryAllByLimit(int offset, int limit) {
        return this.contestRankMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param contestRank 实例对象
     * @return 实例对象
     */
    @Override
    public ContestRank insert(ContestRank contestRank) {
        this.contestRankMapper.insert(contestRank);
        return contestRank;
    }

    /**
     * 修改数据
     *
     * @param contestRank 实例对象
     * @return 实例对象
     */
    @Override
    public ContestRank update(ContestRank contestRank) {
        this.contestRankMapper.update(contestRank);
        return this.queryById(contestRank.getContestRankId());
    }

    /**
     * 通过主键删除数据
     *
     * @param contestRankId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer contestRankId) {
        return this.contestRankMapper.deleteById(contestRankId) > 0;
    }
}
