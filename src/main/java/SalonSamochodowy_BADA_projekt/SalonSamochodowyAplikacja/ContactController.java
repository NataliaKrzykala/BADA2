package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ContactController {

    @PostMapping("/submitForm")
    public String submitForm(@RequestParam String name, @RequestParam String email, @RequestParam String message) {
        // Save the form data to a text file with creative formatting
        saveToFile(name, email, message);

        // Log the form submission to the console
        logFormSubmission(name, email, message);

        // Send email notification (you need to implement this part)
        sendEmailNotification(name, email, message);

        return "redirect:/index";  // Redirect to a success page
    }

    private void saveToFile(String name, String email, String message) {
        String fileName = "form_submissions.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            // Create a formatted header
            String header = "=== Form Submission ===";
            writer.println(header);

            // Format the date and time
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = dateFormat.format(new Date());

            // Write data to the file
            writer.println("Date and Time: " + formattedDate);
            writer.println("Name: " + name);
            writer.println("Email: " + email);
            writer.println("Message: " + message);
            writer.println("-----------------------");
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception accordingly
        }
    }

    private void logFormSubmission(String name, String email, String message) {
        // Log the form submission details to the console
        System.out.println("New Form Submission:");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Message: " + message);
        System.out.println("====================");
    }

    private void sendEmailNotification(String name, String email, String message) {
        // Implement email sending logic here
        // You can use JavaMail or some other library to send emails
    }
}
