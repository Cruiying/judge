package com.hqz.hzuoj.service.impl;

import com.hqz.hzuoj.entity.model.ContestRankInfo;
import com.hqz.hzuoj.mapper.ContestRankInfoMapper;
import com.hqz.hzuoj.service.ContestRankInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ContestRankInfo)表服务实现类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
@Service("contestRankInfoService")
public class ContestRankInfoServiceImpl implements ContestRankInfoService {
    @Resource
    private ContestRankInfoMapper contestRankInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param contestRankInfoId 主键
     * @return 实例对象
     */
    @Override
    public ContestRankInfo queryById(Integer contestRankInfoId) {
        return this.contestRankInfoDao.queryById(contestRankInfoId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ContestRankInfo> queryAllByLimit(int offset, int limit) {
        return this.contestRankInfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param contestRankInfo 实例对象
     * @return 实例对象
     */
    @Override
    public ContestRankInfo insert(ContestRankInfo contestRankInfo) {
        this.contestRankInfoDao.insert(contestRankInfo);
        return contestRankInfo;
    }

    /**
     * 修改数据
     *
     * @param contestRankInfo 实例对象
     * @return 实例对象
     */
    @Override
    public ContestRankInfo update(ContestRankInfo contestRankInfo) {
        this.contestRankInfoDao.update(contestRankInfo);
        return this.queryById(contestRankInfo.getContestRankInfoId());
    }

    /**
     * 通过主键删除数据
     *
     * @param contestRankInfoId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer contestRankInfoId) {
        return this.contestRankInfoDao.deleteById(contestRankInfoId) > 0;
    }
}
