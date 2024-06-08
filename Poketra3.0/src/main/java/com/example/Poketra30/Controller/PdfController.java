package com.example.Poketra30.Controller;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class PdfController {

    @GetMapping("/generate-pdf")
    public String generatePdf(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) {
        try {

            Document document = new Document();

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; filename=tata.pdf");
            PdfWriter.getInstance(document, response.getOutputStream());


            document.open();

            document.add(new Paragraph("Hello, this is a sample PDF ."));
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "pdfView";
    }
}
