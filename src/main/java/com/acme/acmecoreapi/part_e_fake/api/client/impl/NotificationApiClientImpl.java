package com.acme.acmecoreapi.part_e_fake.api.client.impl;

import com.acme.acmecoreapi.part_e_fake.api.client.NotificationApiClient;
import com.acme.acmecoreapi.part_e_fake.api.request.SendEmailRequest;
import com.acme.acmecoreapi.part_e_fake.api.response.EmailResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationApiClientImpl implements NotificationApiClient {
  @Override
  public void addEmailToQueue(SendEmailRequest sendEmailRequest) {
    // this is an implementation of API to queue email to be sent later
    // ...
    // ...
    // ...
    // this is an implementation of API to queue email to be sent later
  }

  @Override
  public List<EmailResponse> getAllEmails() {
    // this is an implementation of API to get all emails in queue
    // ...
    // ...
    // ...
    // this is an implementation of API to get all emails in queue
    return null;
  }
}
