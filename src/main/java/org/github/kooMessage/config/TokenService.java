package org.github.kooMessage.config;

import org.github.kooMessage.util.HwyToken;

public interface TokenService {
    default String  getToken ()  {
        return  HwyToken.getHwyToken(
                TokenMessage.getNAME(),
                TokenMessage.getPASSWORD(),
                TokenMessage.getTOKEN_URL(),
                TokenMessage.getDOMAIN(),
                TokenMessage.getPROJECT());
    }
}
