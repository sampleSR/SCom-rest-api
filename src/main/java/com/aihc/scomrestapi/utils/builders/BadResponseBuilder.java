package com.aihc.scomrestapi.utils.builders;

public class BadResponseBuilder {
  public static String buildString() {
    return "{"
        + "\"error\":\"User or email wrong\","
        + "\"message\":\"Bad credentials\","
        + "\"success\":false,"
        + "\"data\":null"
        + "}";
  }
}
