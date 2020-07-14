package com.hqz.hzuoj.service.impl;

import com.alibaba.fastjson.JSON;
import com.hqz.hzuoj.common.constants.RabbitMqConstants;
import com.hqz.hzuoj.controller.JudgeProducer;
import com.hqz.hzuoj.entity.DTO.CompileResultDTO;
import com.hqz.hzuoj.entity.model.JudgeResult;
import com.hqz.hzuoj.entity.model.Submit;
import com.hqz.hzuoj.entity.model.SubmitCase;
import com.hqz.hzuoj.service.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测评信息调度器
 */
@Service
public class JudgeMessageDispatcherImpl implements JudgeMessageDispatcherService {

    @Resource
    private SubmitCaseService submitCaseService;

    @Resource
    private SubmitService submitService;

    @Resource
    private LanguageService languageService;

    @Resource
    private JudgeResultService judgeResultService;

    @Resource
    private JudgeProducer judgeProducer;



    /**
     * 提交发送错误
     * @param submitId
     * @param submit
     * @param completed
     */
    @Override
    public void onSubmitErrorOccurred(Integer submitId, Submit submit, boolean completed) {
        JudgeResult judgeResult = judgeResultService.findJudgeResultByJudgeNameAbbr("SE");
        submit.setJudgeResultId(judgeResult.getJudgeResultId());
        submit.setScore(0);
        submit.setRuntimeTime(0);
        submit.setRuntimeMemory(0);
        submitService.update(submit);
        sendSubmitMessage(submitId, submit, null, "System Error", completed);
    }

    /**
     * 发送用户提交编译开始
     * @param submitId
     * @param submit
     */
    @Override
    public void onSubmitCompile(Integer submitId, Submit submit) {
        submit.setJudgeResultId(judgeResultService.findJudgeResultByJudgeNameAbbr("compile").getJudgeResultId());
        submit.setScore(0);
        submitService.update(submit);
        sendSubmitMessage(submitId, submit, null, "compile running", false);
    }

    /**
     * 发送用户编译结果
     * @param submitId
     * @param submit
     * @param completed
     */
    @Override
    public void onSubmitCompileFinished(Integer submitId, Submit submit, boolean completed) {
        submitService.update(submit);
        submit.setScore(0);
        submitService.update(submit);
        sendSubmitMessage(submitId, submit, null, "compile running final", false);
    }

    /**
     * 测试点运行完成
     * @param submitId
     * @param submit
     * @param submitCase
     * @param completed
     */
    @Override
    public void submitOneTestPointFinished(Integer submitId, Submit submit, SubmitCase submitCase, boolean completed) {
        submitService.update(submit);
        submitCaseService.insert(submitCase);
        sendSubmitMessage(submitId, submit, submitCase, "running one case", false);
    }

    /**
     * 所有测试点运行完成
     * @param submitId
     * @param submit
     * @param completed
     */
    @Override
    public void submitAllTestPointsFinished(Integer submitId, Submit submit, boolean completed) {
        submitService.update(submit);
        sendSubmitMessage(submitId, submit, null, "running case final", false);
    }


    /**
     * 向测评记录队列发送消息
     * @param submitId
     * @param submit
     * @param event
     * @param completed
     */
    private void sendSubmitMessage(Integer submitId, Submit submit, SubmitCase submitCase, String event, boolean completed) {
        Map<String, Object> map = new HashMap<>();
        map.put("event", event);
        map.put("completed", completed);
        map.put("submit", submit);
        map.put("submitCase", submitCase);
        map.put("submitId", submitId);
        judgeProducer.sendSubmitResult(RabbitMqConstants.RECEIVE_JUDGE_RESULT_QUEUE, map);
    }

}
