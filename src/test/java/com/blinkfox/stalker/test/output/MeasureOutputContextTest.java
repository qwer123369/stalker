package com.blinkfox.stalker.test.output;

import com.blinkfox.stalker.config.Options;
import com.blinkfox.stalker.output.MeasureOutput;
import com.blinkfox.stalker.output.MeasureOutputContext;
import com.blinkfox.stalker.result.MeasureResult;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * MeasureOutputContextTest.
 *
 * @author blinkfox on 2019-02-04.
 * @since v1.0.0
 */
public class MeasureOutputContextTest {

    /**
     * 测试 outputs 没有的情况.
     */
    @Test
    public void outputWithoutOutputs() {
        List<MeasureOutput> outputs = null;
        new MeasureOutputContext().output(Options.of().outputs(outputs), new MeasureResult());
        new MeasureOutputContext().output(Options.of().outputs(new ArrayList<>()), new MeasureResult());
    }

}
