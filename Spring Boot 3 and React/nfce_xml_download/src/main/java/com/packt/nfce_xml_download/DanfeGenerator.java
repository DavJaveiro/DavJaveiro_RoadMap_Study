package com.packt.nfce_xml_download;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class DanfeGenerator {

    // --- Constantes de Layout ---
    private static final float MARGIN = 40;
    private static final PDType1Font FONT_REGULAR = new PDType1Font(Standard14Fonts.FontName.HELVETICA);
    private static final PDType1Font FONT_BOLD = new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD);

    public static void main(String[] args) {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            // Carrega e faz o parse do XML
            Document xmlDoc = loadXmlDocument();

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                float yPosition = page.getMediaBox().getHeight() - MARGIN;

                // Desenha cada seção e atualiza a posição Y
                yPosition = drawHeader(contentStream, page, xmlDoc, yPosition);
                yPosition = drawItemTable(contentStream, page, xmlDoc, yPosition);
                yPosition = drawTotals(contentStream, page, xmlDoc, yPosition);
                yPosition = drawPayments(contentStream, page, xmlDoc, yPosition);
                yPosition = drawInfoSections(contentStream, page, xmlDoc, yPosition);

                // Adiciona a logo
                yPosition = drawLogo(contentStream, document, page, yPosition);

                // NOVO: Adiciona a seção de merchandising
                drawMerchandising(contentStream, page, yPosition);
            }

            document.save("danfe_nfce_final2.pdf");
            System.out.println("DANFE NFC-e final gerado com sucesso! 🚀");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Document loadXmlDocument() throws Exception {
        InputStream inputStream = DanfeGenerator.class.getClassLoader().getResourceAsStream("nota_fiscal.xml");
        if (inputStream == null) {
            throw new IllegalArgumentException("Arquivo 'nota_fiscal.xml' não encontrado em 'src/main/resources'.");
        }
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        return dBuilder.parse(inputStream);
    }

    private static float drawHeader(PDPageContentStream cs, PDPage page, Document doc, float y) throws IOException {
        String nomeEmitente = getXmlValue(doc, "xNome");
        String cnpj = formatCnpj(getXmlValue(doc, "CNPJ"));
        String ender = getXmlValue(doc, "xLgr") + ", " + getXmlValue(doc, "nro") + ", "
                + getXmlValue(doc, "xBairro") + ", " + getXmlValue(doc, "xMun") + " - " + getXmlValue(doc, "UF");

        float pageWidth = page.getMediaBox().getWidth();

        drawTextCentered(cs, FONT_BOLD, 14, pageWidth / 2, y, nomeEmitente);
        y -= 15;
        drawTextCentered(cs, FONT_REGULAR, 10, pageWidth / 2, y, "CNPJ: " + cnpj);
        y -= 15;
        drawTextCentered(cs, FONT_REGULAR, 10, pageWidth / 2, y, ender);
        y -= 25;

        return y;
    }

    private static float drawItemTable(PDPageContentStream cs, PDPage page, Document doc, float y) throws IOException {
        float rightEdge = page.getMediaBox().getWidth() - MARGIN;

        // Cabeçalho da Tabela
        cs.setFont(FONT_BOLD, 9);
        cs.beginText();
        cs.newLineAtOffset(MARGIN, y);
        cs.showText("Descrição (Código)");
        cs.endText();

        drawTextRightAligned(cs, FONT_BOLD, 9, rightEdge - 150, y, "Qtde.");
        drawTextRightAligned(cs, FONT_BOLD, 9, rightEdge - 80, y, "Vl. Unit.");
        drawTextRightAligned(cs, FONT_BOLD, 9, rightEdge, y, "Vl. Total");
        y -= 5;
        drawLine(cs, MARGIN, y, rightEdge);
        y -= 15;

        // Itens
        NodeList detList = doc.getElementsByTagName("det");
        DecimalFormat df = new DecimalFormat("#,##0.00");

        for (int i = 0; i < detList.getLength(); i++) {
            Element det = (Element) detList.item(i);
            String desc = getChildValue(det, "xProd");
            String cod = getChildValue(det, "cProd");
            double qtde = Double.parseDouble(getChildValue(det, "qCom"));
            double vUnit = Double.parseDouble(getChildValue(det, "vUnCom"));
            double vTotal = Double.parseDouble(getChildValue(det, "vProd"));

            cs.setFont(FONT_REGULAR, 9);
            cs.beginText();
            cs.newLineAtOffset(MARGIN, y);
            cs.showText(desc + " (Código: " + cod + ")");
            cs.endText();

            drawTextRightAligned(cs, FONT_REGULAR, 9, rightEdge - 150, y, String.format("%.2f", qtde));
            drawTextRightAligned(cs, FONT_REGULAR, 9, rightEdge - 80, y, df.format(vUnit));
            drawTextRightAligned(cs, FONT_BOLD, 9, rightEdge, y, df.format(vTotal));
            y -= 15;
        }
        y -= 10;
        return y;
    }

    private static float drawTotals(PDPageContentStream cs, PDPage page, Document doc, float y) throws IOException {
        float rightEdge = page.getMediaBox().getWidth() - MARGIN;
        NodeList detList = doc.getElementsByTagName("det");
        String valorTotal = getXmlValue(doc, "vNF");

        drawTextRightAligned(cs, FONT_REGULAR, 10, rightEdge - 50, y, "Qtd. total de itens:");
        drawTextRightAligned(cs, FONT_REGULAR, 10, rightEdge, y, String.valueOf(detList.getLength()));
        y -= 20;

        drawTextRightAligned(cs, FONT_REGULAR, 10, rightEdge - 50, y, "Valor a pagar R$:");
        drawTextRightAligned(cs, FONT_BOLD, 16, rightEdge, y, valorTotal);
        y -= 25;

        return y;
    }

    private static float drawPayments(PDPageContentStream cs, PDPage page, Document doc, float y) throws IOException {
        float rightEdge = page.getMediaBox().getWidth() - MARGIN;

        cs.setFont(FONT_BOLD, 10);
        cs.beginText();
        cs.newLineAtOffset(MARGIN, y);
        cs.showText("Forma de pagamento");
        cs.endText();

        drawTextRightAligned(cs, FONT_BOLD, 10, rightEdge, y, "Valor pago R$");
        y -= 5;
        drawLine(cs, MARGIN, y, rightEdge);
        y -= 15;

        NodeList pagList = doc.getElementsByTagName("detPag");
        for (int i = 0; i < pagList.getLength(); i++) {
            Element pag = (Element) pagList.item(i);
            String formaPag = getPaymentMethod(getChildValue(pag, "tPag"));
            String valorPag = getChildValue(pag, "vPag");

            cs.setFont(FONT_REGULAR, 10);
            cs.beginText();
            cs.newLineAtOffset(MARGIN, y);
            cs.showText(formaPag);
            cs.endText();
            drawTextRightAligned(cs, FONT_REGULAR, 10, rightEdge, y, valorPag);
            y -= 15;
        }

        cs.setFont(FONT_REGULAR, 10);
        cs.beginText();
        cs.newLineAtOffset(MARGIN, y);
        cs.showText("Troco");
        cs.endText();
        drawTextRightAligned(cs, FONT_REGULAR, 10, rightEdge, y, getXmlValue(doc, "vTroco"));
        y -= 25;
        return y;
    }

    private static float drawInfoSections(PDPageContentStream cs, PDPage page, Document doc, float y) throws IOException {
        // Seção: Informações gerais da Nota
        drawSectionHeader(cs, MARGIN, y, "Informações gerais da Nota");
        y -= 20;
        String nNF = getXmlValue(doc, "nNF");
        String serie = getXmlValue(doc, "serie");
        String dhEmi = formatDateTime(getXmlValue(doc, "dhEmi"));
        String nProt = getXmlValue(doc, "nProt");
        String dhRecbto = formatDateTime(getXmlValue(doc, "dhRecbto"));

        cs.setFont(FONT_REGULAR, 9);
        cs.beginText();
        cs.newLineAtOffset(MARGIN, y);
        cs.showText("Número: " + nNF + " Série: " + serie + " Emissão: " + dhEmi + " - Via Consumidor 2");
        y -= 12;
        cs.newLineAtOffset(0, -12);
        cs.showText("Protocolo de Autorização: " + nProt + " " + dhRecbto);
        y -= 12;
        cs.newLineAtOffset(0, -12);
        cs.showText("Ambiente de Produção - Versão XML: 4.00 - Versão XSLT: 2.07");
        cs.endText();
        y -= 25;

        // Seção: Chave de acesso
        drawSectionHeader(cs, MARGIN, y, "Chave de acesso");
        y -= 20;
        String chave = formatAccessKey(getXmlValue(doc, "chNFe"));
        String urlChave = getXmlValue(doc, "urlChave");

        cs.setFont(FONT_REGULAR, 9);
        cs.beginText();
        cs.newLineAtOffset(MARGIN, y);
        cs.showText("Consulte pela Chave de Acesso em " + urlChave);
        y -= 12;
        cs.newLineAtOffset(0, -12);
        cs.showText("Chave de acesso:");
        y -= 12;
        cs.newLineAtOffset(0, -12);
        cs.showText(chave);
        cs.endText();
        y -= 25;

        // Seção: Consumidor
        drawSectionHeader(cs, MARGIN, y, "Consumidor");
        y -= 20;
        cs.setFont(FONT_REGULAR, 9);
        cs.beginText();
        cs.newLineAtOffset(MARGIN, y);
        cs.showText("Consumidor não identificado");
        cs.endText();
        y -= 15;
        return y;
    }

    private static float drawLogo(PDPageContentStream cs, PDDocument doc, PDPage page, float y) {
        try {
            InputStream logoStream = DanfeGenerator.class.getClassLoader().getResourceAsStream("logo.jpg");
            if (logoStream == null) {
                throw new IOException("Arquivo 'logo.jpg' não encontrado em 'src/main/resources'.");
            }

            byte[] imageBytes = logoStream.readAllBytes();
            logoStream.close();
            PDImageXObject pdImage = PDImageXObject.createFromByteArray(doc, imageBytes, "logo.jpg");

            float desiredWidth = 150;
            float scale = desiredWidth / pdImage.getWidth();
            float scaledHeight = pdImage.getHeight() * scale;

            float pageWidth = page.getMediaBox().getWidth();
            float x_pos = (pageWidth - desiredWidth) / 2;
            float y_pos = y - scaledHeight - 25;

            cs.drawImage(pdImage, x_pos, y_pos, desiredWidth, scaledHeight);

            // Retorna a posição Y final, logo abaixo da imagem
            return y_pos;

        } catch (IOException e) {
            System.err.println("Falha ao carregar ou desenhar a logo: " + e.getMessage());
            return y; // Retorna a posição original se houver erro
        }
    }

    // --- NOVO MÉTODO PARA O MERCHANDISING ---
    private static void drawMerchandising(PDPageContentStream cs, PDPage page, float y) throws IOException {
        // Textos a serem exibidos
        String title = "Sua Revolução do Cupom Fiscal";
        String description = "Diga adeus aos cupons de papel! Organize suas notas fiscais de forma 100% digital, economize espaço e ajude o meio ambiente.";
        String url = "Veja mais em: https://byebyecupom.com.br/";

        float pageWidth = page.getMediaBox().getWidth();

        // Deixa um espaço após a logo
        y -= 30;

        // Desenha o título
        drawTextCentered(cs, FONT_BOLD, 11, pageWidth / 2, y, title);
        y -= 15;

        // Desenha a descrição
        drawTextCentered(cs, FONT_REGULAR, 9, pageWidth / 2, y, description);
        y -= 15;

        // Desenha a URL
        drawTextCentered(cs, FONT_REGULAR, 9, pageWidth / 2, y, url);
    }

    // --- MÉTODOS UTILITÁRIOS ---

    private static String getXmlValue(Document doc, String tagName) {
        NodeList nodeList = doc.getElementsByTagName(tagName);
        return nodeList.getLength() > 0 ? nodeList.item(0).getTextContent() : "";
    }

    private static String getChildValue(Element parent, String tagName) {
        NodeList nodeList = parent.getElementsByTagName(tagName);
        return nodeList.getLength() > 0 ? nodeList.item(0).getTextContent() : "";
    }

    private static void drawTextCentered(PDPageContentStream cs, PDType1Font font, int fontSize, float x, float y, String text) throws IOException {
        float textWidth = font.getStringWidth(text) / 1000f * fontSize;
        cs.setFont(font, fontSize);
        cs.beginText();
        cs.newLineAtOffset(x - textWidth / 2, y);
        cs.showText(text);
        cs.endText();
    }

    private static void drawTextRightAligned(PDPageContentStream cs, PDType1Font font, int fontSize, float x, float y, String text) throws IOException {
        float textWidth = font.getStringWidth(text) / 1000f * fontSize;
        cs.setFont(font, fontSize);
        cs.beginText();
        cs.newLineAtOffset(x - textWidth, y);
        cs.showText(text);
        cs.endText();
    }

    private static void drawLine(PDPageContentStream cs, float xStart, float y, float xEnd) throws IOException {
        cs.moveTo(xStart, y);
        cs.lineTo(xEnd, y);
        cs.stroke();
    }

    private static void drawSectionHeader(PDPageContentStream cs, float x, float y, String title) throws IOException {
        cs.setFont(FONT_BOLD, 11);
        cs.beginText();
        cs.newLineAtOffset(x, y);
        cs.showText(title);
        cs.endText();
        drawLine(cs, x, y - 5, x + 555); // 555 é a largura da página - 2*margem
    }

    private static String getPaymentMethod(String code) {
        switch (code) {
            case "03": return "Cartão de Crédito";
            case "04": return "Cartão de Débito";
            case "01": return "Dinheiro";
            case "17": return "PIX";
            default: return "Outros";
        }
    }

    private static String formatDateTime(String dateTimeStr) {
        try {
            OffsetDateTime odt = OffsetDateTime.parse(dateTimeStr);
            return odt.format(DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm:ss"));
        } catch (Exception e) {
            return dateTimeStr;
        }
    }

    private static String formatAccessKey(String key) {
        return key.replaceAll("(\\d{4})", "$1 ").trim();
    }

    private static String formatCnpj(String cnpj) {
        return cnpj.replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");
    }
}