package common.passport.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.passport.model.Passport;
import java.util.Base64;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
public class PassportUtils {
  private final ObjectMapper objectMapper;

  public String encode(Passport passport) {
    try {
      byte[] bytes = objectMapper.writeValueAsBytes(passport);
      String encoded = Base64.getEncoder().encodeToString(bytes);
      return encoded;
    } catch (Exception e) {
      log.error("인코딩 오류: " + e.getMessage());
      e.printStackTrace();
      throw new RuntimeException("Passport Encoding 작업 중 오류", e);
    }
  }

  public Passport decode(String encodedPassport) {
    try {
      byte[] bytes = Base64.getDecoder().decode(encodedPassport);
      Passport passport = objectMapper.readValue(bytes, Passport.class);
      return passport;
    } catch (Exception e) {
      log.error("디코딩 오류: " + e.getMessage());
      e.printStackTrace();
      throw new RuntimeException("Passport Decoding 작업 중 오류", e);
    }
  }
}