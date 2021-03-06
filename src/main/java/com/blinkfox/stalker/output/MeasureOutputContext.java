package com.blinkfox.stalker.output;

import com.blinkfox.stalker.config.Options;
import com.blinkfox.stalker.result.MeasureResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * 用于输出测量结果的上下文.
 *
 * @author blinkfox on 2019-01-22.
 * @since v1.0.0
 */
@Slf4j
public final class MeasureOutputContext {

    /**
     * 将测量的相关参数和统计结果等信息输出出来.
     *
     * @param options 测量的选项参数
     * @param measureResults 多个测量统计结果的不定集合
     * @return 各个输出结果的集合，v1.1.0 新增的返回结果
     */
    public List<Object> output(Options options, MeasureResult... measureResults) {
        // 如果没有指定任何输出形式，则默认将结果输出到控制台中.
        List<MeasureOutput> outputs = options.getOutputs();
        if (outputs == null || outputs.isEmpty()) {
            log.warn("【stalker 警示】你没有指定输出结果，将输出空集合.");
            return Collections.emptyList();
        }

        // 如果有多种输出形式，就遍历得到结果，并将各个结果存入到 List 集合中.
        List<Object> results = new ArrayList<>();
        outputs.forEach(measureOutput -> results.add(measureOutput.output(options, measureResults)));
        return results;
    }

}
