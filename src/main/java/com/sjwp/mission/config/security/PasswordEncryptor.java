package com.sjwp.mission.config.security;

public interface PasswordEncryptor {

  String encrypt(String rawPassword);
}
