package com.packt.nfce_xml_download;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.FileWriter;
import java.io.IOException;

public class NfceDownloader {

    // Suas credenciais da Nuvem Fiscal (mantenha como está)
    private static final String CLIENT_ID = "eOY5P2fuFE8F1qInTezF";
    private static final String CLIENT_SECRET = "JJxtQdw3o7XDfxPvSQtwcsjkzoa3UeLdknvkxHv9";

    public static void main(String[] args) {
        // CORREÇÃO: Use o ID da NFC-e obtido da API da Nuvem Fiscal, NÃO a chave de acesso de 44 dígitos.
        // Este é um ID de exemplo, substitua pelo ID real da sua nota.
        String idDaNfce = "233252255253885";

        String token = obterTokenOAuth2(CLIENT_ID, CLIENT_SECRET);
        if (token != null) {
            baixarXmlNfce(idDaNfce, token);
        } else {
            System.out.println("Falha na autenticação.");
        }
    }

    // Método para obter token OAuth2 (sem alterações, já está correto)
    private static String obterTokenOAuth2(String clientId, String clientSecret) {
        try {
            String url = "https://auth.nuvemfiscal.com.br/oauth/token";
            String credentials = "client_id=" + clientId +
                    "&client_secret=" + clientSecret +
                    "&grant_type=client_credentials" +
                    "&scope=nfce";

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            HttpEntity<String> entity = new HttpEntity<>(credentials, headers);
            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
            String body = response.getBody();

            JsonObject jsonObject = JsonParser.parseString(body).getAsJsonObject();
            if (jsonObject.has("access_token")) {
                String token = jsonObject.get("access_token").getAsString();
                System.out.println("Token obtido com sucesso!");
                return token;
            } else {
                System.out.println("Erro na resposta do OAuth2: " + body);
                return null;
            }
        } catch (Exception e) {
            System.err.println("Erro ao obter token: " + e.getMessage());
            return null;
        }
    }

    // CORREÇÃO: Método ajustado para usar o endpoint e o método corretos
    private static void baixarXmlNfce(String nfceId, String token) {
        try {
            // CORREÇÃO: URL correta conforme a documentação, usando o ID na rota.
            String url = "https://api.nuvemfiscal.com.br/nfce/" + nfceId + "/xml";

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + token);
            // O XML é o tipo de conteúdo esperado na resposta.
            headers.setAccept(java.util.Collections.singletonList(MediaType.APPLICATION_XML));

            // CORREÇÃO: Requisições GET não têm corpo (body), então passamos HttpEntity.EMPTY
            HttpEntity<Void> entity = new HttpEntity<>(headers);
            RestTemplate restTemplate = new RestTemplate();

            System.out.println("Buscando XML em: " + url);

            // CORREÇÃO: O método HTTP agora é GET.
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            String xml = response.getBody();

            // Salvar XML em arquivo
            if (response.getStatusCode() == HttpStatus.OK && xml != null) {
                String nomeArquivo = "NFCe_" + nfceId + ".xml";
                try (FileWriter writer = new FileWriter(nomeArquivo)) {
                    writer.write(xml);
                    System.out.println("XML da NFC-e " + nfceId + " salvo com sucesso como " + nomeArquivo);
                } catch (IOException e) {
                    System.err.println("Erro ao salvar o arquivo XML: " + e.getMessage());
                }
            } else {
                System.err.println("Resposta inesperada da API: " + response.getStatusCode());
            }

        } catch (Exception e) {
            // Imprime a exceção para obter mais detalhes do erro (404, 401, etc.)
            System.err.println("Falha ao baixar o XML da NFC-e. Causa: " + e.getMessage());
        }
    }
}