package com.roje.manager.common;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Ro
 */
@Getter@Setter@Builder
public class RspBody<DATA> {
    private ResultCode code;
    private DATA data;
}
