package com.example.RestartSIHproject.Service;

import ch.qos.logback.core.pattern.parser.OptionTokenizer;
import com.example.RestartSIHproject.Model.FacultyProfileModel;
import com.example.RestartSIHproject.Repository.FacultyProfileRepo;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private FacultyProfileRepo facultyProfileRepo;

    public ResponseEntity<?> sendEmail(String toEmail, String username) throws MessagingException {
        Optional<FacultyProfileModel> facultyProfileModel=facultyProfileRepo.findByUsername(username);
        if(facultyProfileModel.isPresent()){
            FacultyProfileModel facultyProfile= facultyProfileModel.get();
            facultyProfile.setEmail(toEmail);
            Random random=new Random();
            int otp=1000+ random.nextInt(10000);
            facultyProfile.setOtp(otp);
            facultyProfileRepo.save(facultyProfile);

        MimeMessage message=javaMailSender.createMimeMessage();
        String subject="Email Verification";



        MimeMessageHelper helper=new MimeMessageHelper(message,true);
        helper.setFrom("nn9619807@gmail.com");
        helper.setTo(toEmail);
        helper.setSubject(subject);

        String htmlContent="<h1>Welcome to XYZ University</h1>"
                +
                "<h2> Your Otp is</h2>"+otp;
        helper.setText(htmlContent,true);
        javaMailSender.send(message);
        return ResponseEntity.ok().build();
        }
        else{
            return ResponseEntity.notFound().build();

        }
    }
    public ResponseEntity<?> verifyEmail(int otp, String username) throws MessagingException {
        Optional<FacultyProfileModel> facultyProfileModel = facultyProfileRepo.findByUsername(username);
        if (facultyProfileModel.isPresent()) {
            FacultyProfileModel facultyProfile = facultyProfileModel.get();
            if (facultyProfile.getOtp() == otp) {
                facultyProfile.setVerified(true);
                facultyProfileRepo.save(facultyProfile);
                return ResponseEntity.ok().build();

            } else {
               return ResponseEntity.status(422).body("Invalid OTP");
            }
        }
        else {
            return ResponseEntity.notFound().build();

        }
    }
}
