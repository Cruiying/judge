package com.hqz.hzuoj.service.impl;

import com.hqz.hzuoj.common.constants.RabbitMqConstants;
import com.hqz.hzuoj.controller.JudgeProducer;
import com.hqz.hzuoj.entity.DTO.CompileResultDTO;
import com.hqz.hzuoj.entity.model.JudgeResult;
import com.hqz.hzuoj.entity.model.Submit;
import com.hqz.hzuoj.entity.model.SubmitCase;
import com.hqz.hzuoj.service.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
        sendSubmitMessage("System Error", completed, submit, submitId);
    }

    /**
     * 发送用户提交编译开始
     * @param submitId
     * @param submit
     */
    @Override
    public void onSubmitCompile(Integer submitId, Submit submit) {

    }

    /**
     * 发送用户编译结果
     * @param submitId
     * @param submit
     * @param compileResult
     * @param compileSuccess
     */
    @Override
    public void onSubmitCompileFinished(Integer submitId, Submit submit, CompileResultDTO compileResult, Boolean compileSuccess) {

    }

    /**
     * 测试点运行完成
     * @param submitId
     * @param submit
     * @param submitCase
     * @param usedTime
     * @param usedMemory
     * @param i
     * @param b
     */
    @Override
    public void submitOneTestPointFinished(Integer submitId, Submit submit, SubmitCase submitCase, int usedTime, int usedMemory, int i, boolean b) {

    }

    /**
     * 所有测试点运行完成
     * @param submitId
     * @param submit
     * @param submitCases
     * @param usedTime
     * @param usedMemory
     * @param i
     * @param b
     */
    @Override
    public void submitAllTestPointsFinished(Integer submitId, Submit submit, List<SubmitCase> submitCases, int usedTime, int usedMemory, int i, boolean b) {

    }


    /**
     * 向测评记录队列发送消息
     *
     * @param event
     * @param completed
     * @param submit
     * @param submitId
     */
    private void sendSubmitMessage(String event, Boolean completed, Submit submit, Integer submitId) {
        Map<String, Object> mapMessage = new HashMap<>();
        mapMessage.put("event", event);
        mapMessage.put("completed", completed);
        mapMessage.put("submit", submit);
        mapMessage.put("submitId", submitId);
        judgeProducer.sendSubmitResult(RabbitMqConstants.RECEIVE_JUDGE_RESULT_QUEUE, mapMessage);
    }

}
