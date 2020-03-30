package com.roje.manager.utils;

import lombok.*;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @author Ro
 */
@Getter@Setter
@Builder
public class ImageCode {

    private BufferedImage image;

    private String code;

    private LocalDateTime expireDt;
}
