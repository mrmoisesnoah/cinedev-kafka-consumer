package br.com.dbc.vemser.notascinedevconsumidor.service;

import br.com.dbc.vemser.notascinedevconsumidor.entity.NotaEntity;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {
    private final freemarker.template.Configuration fmConfiguration;
    @Value("${spring.mail.username}")
    private String from;
    @Value("${email.cinedev}")
    private String to;
    private final JavaMailSender emailSender;

    public void sendEmail(NotaEntity notaEntity) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject("Notas compra Ingresso");
            mimeMessageHelper.setText(getContentFromTemplate(notaEntity), true);
            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public String getContentFromTemplate(NotaEntity notaEntity) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("texto1", "O relatório geral está disponível.");
        dados.put("texto2", "Obrigado!");
        Template template = fmConfiguration.getTemplate("email-template.html");
        return FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
    }
}
