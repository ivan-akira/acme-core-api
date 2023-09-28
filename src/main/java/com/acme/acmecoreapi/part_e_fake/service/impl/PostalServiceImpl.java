package com.acme.acmecoreapi.part_e_fake.service.impl;

import com.acme.acmecoreapi.part_e_fake.api.client.NotificationApiClient;
import com.acme.acmecoreapi.part_e_fake.api.request.SendEmailRequest;
import com.acme.acmecoreapi.part_e_fake.service.PostalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PostalServiceImpl implements PostalService {
  @Autowired
  private NotificationApiClient notificationApiClient;

  private final int totalEmail = (new Random()).nextInt(10, 21);

  @Override
  public void prepareEmail() {
    for (int i = 0; i < totalEmail; i++) {
      SendEmailRequest sendEmailRequest = SendEmailRequest
        .builder()
        .from("no-reply@email.com")
        .to("to@email.com")
        .subject("Important Email")
        .body("Content of email.")
        .build();

      notificationApiClient.addEmailToQueue(sendEmailRequest);
    }
  }

  @Override
  public boolean isEmailPrepared() {
    return notificationApiClient.getAllEmails().size() == totalEmail;
  }
}
