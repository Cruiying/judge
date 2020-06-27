package com.hqz.hzuoj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqz.hzuoj.entity.DO.DiscussionUserDO;
import com.hqz.hzuoj.common.base.CurrentUser;
import com.hqz.hzuoj.common.util.PageUtils;
import com.hqz.hzuoj.entity.model.Discussion;
import com.hqz.hzuoj.mapper.DiscussionMapper;
import com.hqz.hzuoj.service.DiscussionService;
import com.hqz.hzuoj.entity.VO.DiscussionQueryVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (Discussion)表服务实现类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
@Service("discussionService")
public class DiscussionServiceImpl implements DiscussionService {

    @Resource
    private DiscussionMapper discussionMapper;



    /**
     * 通过ID查询单条数据
     *
     * @param discussionId 主键
     * @return 实例对象
     */
    @Override
    public Discussion queryById(Integer discussionId) {
        return this.discussionMapper.queryById(discussionId);
    }

    /**
     * 通过ID查询讨论
     * @param discussionId
     * @return
     */
    @Override
    public DiscussionUserDO findById(Integer discussionId) {
        return this.discussionMapper.findById(discussionId);
    }

    /**
     * 新增数据
     *
     * @param discussion 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public Discussion insert(Discussion discussion) {
        discussion.setUserId(CurrentUser.getUserId());
        discussion.setBrowseCount(0);
        discussion.setCommendCount(0);
        discussion.setCommentCount(0);
        discussion.setCreateTime(new Date());
        discussion.setTop(0);
        discussion.setModifyTime(new Date());
        this.discussionMapper.insert(discussion);
        return discussion;
    }

    /**
     * 修改数据
     *
     * @param discussion 实例对象
     * @return 实例对象
     */
    @Override
    public Discussion update(Discussion discussion) {
        this.discussionMapper.update(discussion);
        return this.queryById(discussion.getDiscussionId());
    }

    /**
     * 通过主键删除数据
     *
     * @param discussionId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer discussionId) {
        return this.discussionMapper.deleteById(discussionId) > 0;
    }

    /**
     * 获取讨论列表
     * @param discussionQueryVO
     * @return
     */
    @Override
    public PageUtils findDiscussions(DiscussionQueryVO discussionQueryVO) {
        System.err.println(discussionQueryVO);
        PageHelper.startPage(discussionQueryVO.getCurrPage(), discussionQueryVO.getPageSize(), true);
        List<DiscussionUserDO> discussions = discussionMapper.findDiscussions(discussionQueryVO);
        PageInfo<DiscussionUserDO> pageInfo = new PageInfo<>(discussions);
        return new PageUtils(pageInfo);
    }

}
