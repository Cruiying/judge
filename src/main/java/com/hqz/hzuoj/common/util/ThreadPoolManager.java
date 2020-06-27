package com.hqz.hzuoj.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chenliqiao
 * @ClassName: ThreadPoolManager
 * @Description: 线程池管理类
 * @date 2017年9月15日 上午9:24:32
 */
public class ThreadPoolManager {

    private static ThreadPoolManager instance;

    private final static int initialThreadSize = 3;
    private final static int maxThreadSize = 8;
    private final static int threadWaitingTimeoutMillis = 30;
    private final static int backlogSize = 10000;

    private ThreadPoolExecutor taskExecutor = new ThreadPoolExecutor(initialThreadSize, maxThreadSize, threadWaitingTimeoutMillis,
            TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(backlogSize));

    private static final Logger logger = LoggerFactory.getLogger(ThreadPoolManager.class);

    // 防止直接new
    private ThreadPoolManager() {
    }



    private static class HolderClass {
        private static ThreadPoolManager manager = new ThreadPoolManager();
    }

    public static ThreadPoolManager getInstance() {
        if (instance == null) {
            instance = HolderClass.manager;
        }
        return instance;
    }

    public void addTask(Runnable task) {
        logger.info("ActiveThreadCount->{},", taskExecutor.getActiveCount());
        if (taskExecutor.getQueue().size() < backlogSize) {
            taskExecutor.execute(task);
        } else {
            logger.info("backlogSize has reach too limit!!");
        }
    }

    public void stop() {
        taskExecutor.getQueue().clear();
        taskExecutor.shutdownNow();
        logger.info("<<< BaseDataInitializeTaskManager Executor shutdown >>>");
    }

    public boolean isRunning() {
        return !taskExecutor.isShutdown();
    }

    public int getActiveThreadCount() {
        return taskExecutor.getActiveCount();
    }

}
