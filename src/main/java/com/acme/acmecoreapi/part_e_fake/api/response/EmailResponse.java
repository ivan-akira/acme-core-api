package com.acme.acmecoreapi.part_e_fake.api.response;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class EmailResponse {
  private UUID emailId;

  private String from;

  private String to;

  private String subject;

  private String body;
}
