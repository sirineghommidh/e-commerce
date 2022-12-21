package com.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.spring5.SpringTemplateEngine;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
@Service
public class PdfService {

    private static final String PDF_RESOURCES = "../../../pdf-resources/";
    @Autowired
    private IFacture factureService;
    @Autowired
    private SpringTemplateEngine templateEngine;
/*
    @Autowired
    public PdfService(FactureServiceImpl factureService, SpringTemplateEngine templateEngine) {
        this.factureService = factureService;
        this.templateEngine = templateEngine;
    }
*/
    public File generatePdf() throws IOException, DocumentException {
        Context context = getContext();
        String html = loadAndFillTemplate(context);
        return renderPdf(html);
    }


    private File renderPdf(String html) throws IOException, DocumentException {
        File file = File.createTempFile("students", ".pdf");
        OutputStream outputStream = new FileOutputStream(file);
        ITextRenderer renderer = new ITextRenderer(20f * 4f / 3f, 20);
        renderer.setDocumentFromString(html, new ClassPathResource(PDF_RESOURCES).getURL().toExternalForm());
        renderer.layout();
        renderer.createPDF(outputStream);
        outputStream.close();
        file.deleteOnExit();
        return file;
    }

    private Context getContext() {
        Context context = new Context();
        context.setVariable("students", factureService.retrieveFacture(2L));
        return context;
    }

    private String loadAndFillTemplate(Context context) {
        return templateEngine.process("pdf_students", context);
    }


}


