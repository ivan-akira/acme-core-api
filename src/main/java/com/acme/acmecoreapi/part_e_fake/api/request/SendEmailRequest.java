package com.acme.acmecoreapi.part_e_fake.api.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SendEmailRequest {
  private String from;

  private String to;

  private String subject;

  private String body;
}
