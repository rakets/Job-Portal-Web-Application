package com.project.jobportal.services;

import com.project.jobportal.dto.NotificationDTO;
import com.project.jobportal.entity.JobPostActivity;
import com.project.jobportal.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

//Сервис для отправки уведомлений
//Инжектируем SimpMessagingTemplate для отправки сообщений через брокер.
@Service
public class NotificationService {

    private final SimpMessagingTemplate messagingTemplate;
    private final UsersService usersService;

    @Autowired
    public NotificationService(SimpMessagingTemplate messagingTemplate, UsersService usersService) {
        this.messagingTemplate = messagingTemplate;
        this.usersService = usersService;
    }

//     Отправляет личное уведомление конкретному пользователю.
//     @param targetUserEmail Email пользователя, которому отправляется уведомление.
//     @param notificationDTO Объект уведомления.
    public void sendPrivateNotification(String targetUserEmail, NotificationDTO notificationDTO) {
        System.out.println(">>> WS: Попытка отправки уведомления пользователю: " + targetUserEmail);
        // Отправка в приватный канал пользователя: /user/{targetUserEmail}/queue/notifications
        // Spring Security автоматически маппит аутентифицированного пользователя на этот канал.
        messagingTemplate.convertAndSendToUser(
                targetUserEmail,
                "/queue/notifications",// <-- Конечный адрес, на который подписывается клиент
                notificationDTO
        );
        System.out.println(">>> WS: Сообщение отправлено в брокер для: " + targetUserEmail);
    }

    // --- Логика Уведомления Рекрутера ---
    public void notifyRecruiterOfNewApplication(JobPostActivity job, String candidateName) {
        Users recruiter = job.getPostedById();
        //Проверяем владельца вакансии
        if (recruiter == null) {
            System.out.println(">>> WS ОШИБКА: У вакансии ID=" + job.getJobPostId() + " нет автора (recruiter is null)!");
            return;
        }
        String recruiterEmail = recruiter.getEmail();
        System.out.println(">>> WS: Вакансия ID=" + job.getJobPostId() + " принадлежит: " + recruiterEmail);

        String content = "Новый отклик от " + candidateName + " на вакансию: " + job.getJobTitle();
        NotificationDTO notification = new NotificationDTO(
                content,
                "NEW_APPLY",
                job.getJobPostId()
        );

        // Отправка уведомления рекрутеру
        sendPrivateNotification(recruiterEmail, notification);
    }
}