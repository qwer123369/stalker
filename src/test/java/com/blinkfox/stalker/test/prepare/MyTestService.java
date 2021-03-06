package com.blinkfox.stalker.test.prepare;

import java.util.Random;
import lombok.extern.slf4j.Slf4j;

/**
 * 用于测量（仅测试使用）该类中的方法的执行耗时的类.
 *
 * @author blinkfox on 2019-02-03.
 * @since v1.0.0
 */
@Slf4j
public class MyTestService {

    /**
     * 测试方法1，模拟业务代码耗时 2~5 ms，且会有约 1% 的几率执行异常.
     */
    public void hello() {
        // 模拟运行抛出异常.
        if (new Random().nextInt(100) == 5) {
            throw new MyServiceException("My Service Exception.");
        }

        // 模拟运行占用约 2~5 ms 的时间.
        this.sleep(2L + new Random().nextInt(3));
    }

    /**
     * 测试方法2，模拟业务代码耗时 2 ms.
     */
    public void fastHello() {
        this.sleep(1L);
    }

    /**
     * 测试方法3，模拟业务代码耗时 20~100 ms，且会有约 3% 的几率执行异常.
     */
    public void slowHello() {
        // 模拟运行抛出异常.
        if (new Random().nextInt(100) < 3) {
            throw new MyServiceException("My Service Exception.");
        }

        // 模拟运行占用约 20~100 ms 的时间.
        this.sleep(20L + new Random().nextInt(80));
    }

    /**
     * 本线程调用该方法时，睡眠指定时间，用来模拟业务耗时.
     *
     * @param time 时间
     */
    private void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            log.error("【Stalker 提示】本方法的执行已中断，异常简述为：【{}】.", e.getMessage());
        }
    }

    /**
     * 测试执行异常的方法.
     */
    public void helloException() {
        throw new MyServiceException("My Service Exception.");
    }

}
