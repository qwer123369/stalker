package com.blinkfox.stalker.output;

import com.blinkfox.stalker.config.Options;
import com.blinkfox.stalker.result.bean.Measurement;

/**
 * 将最终的测量统计结果输出出来.
 *
 * @author blinkfox on 2019-1-11.
 */
public interface MeasureOutput {

    /**
     * 将测量的相关参数和统计结果等信息输出出来.
     *
     * @param options 测量的选项参数
     * @param measurements 多种测量结果
     */
    void output(Options options, Measurement... measurements);

}