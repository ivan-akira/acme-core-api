package com.acme.acmecoreapi.part_e_fake.api.client;

import com.acme.acmecoreapi.part_e_fake.api.request.SendEmailRequest;
import com.acme.acmecoreapi.part_e_fake.api.response.EmailResponse;

import java.util.List;

public interface NotificationApiClient {
  void addEmailToQueue(SendEmailRequest sendEmailRequest);

  List<EmailResponse> getAllEmails();
}
