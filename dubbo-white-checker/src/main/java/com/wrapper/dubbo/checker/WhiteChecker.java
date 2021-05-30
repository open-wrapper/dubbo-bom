package com.wrapper.dubbo.checker;

import org.apache.dubbo.common.extension.SPIMetaInfo;
import org.apache.dubbo.common.extension.checker.SPIMetaChecker;

import java.util.List;

public class WhiteChecker implements SPIMetaChecker {
    public void check(List<SPIMetaInfo> metaInfos) {
        if (metaInfos == null) {
            return;
        }
        for (SPIMetaInfo info : metaInfos) {
            if (info.getType().startsWith("com.alibaba")) {
                throw new IllegalStateException("请联系相关人员,系统含有非法dubbo老包" +
                        info.getResourceURL().toString());
            }
        }
    }
}
