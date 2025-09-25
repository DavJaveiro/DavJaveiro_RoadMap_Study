# Estrutura
## Parte 1: O Fluxo Padrão da Emissão de Cupom Fiscal (Como Funciona Hoje)
Para entender onde sua API se encaixa, primeiro precisamos mapear o processo legal e padrão que todo software de Ponto de Venda (PDV) é obrigado a seguir para emitir uma **NFC-e (Nota Fiscal de Consumidor Eletrônica)**.

O processo é uma conversa direta entre o PDV e a SEFAZ (Secretaria da Fazenda do estado).
1. **Finalização da Venda:** O operador de caixa registra os produtos e o pagamento no sistema PDV.
2. **Geração do XML da NFC-e:** O software PDV cria um arquivo **XML** seguindo um layout padrão nacional. <span style="background:#fff88f">Este arquivo contém todos os detalhes da venda: dados do varejista, produtos, valores, impostos, forma de pagamento, etc. Este XML é o "rascunho" do cupom fiscal.</span>
3. **Assinatura Digital:** O PDV usa o **Certificado Digital A1 ou A3** da loja para "assinar" digitalmente esse arquivo XML. Essa assinatura garante a autoria e a integridade do documento, como uma assinatura de próprio punho no mundo digital.
4. **Transmissão para a SEFAZ:** O PDV envia o XML assinado para os servidores da SEFAZ através de um _WebService_ (uma API do governo).
5. **Validação e Autorização:** A SEFAZ recebe o XML, valida todas as regras (cálculo de impostos, numeração, etc.) e, se tudo estiver correto, ela **autoriza** a emissão. A SEFAZ então devolve um "Protocolo de Autorização" para o PDV.
6. **O Cupom "Nasce" Oficialmente:** O software PDV anexa esse Protocolo de Autorização ao XML original. **Este novo XML (XML original + protocolo) é o cupom fiscal eletrônico com validade jurídica.**
7. **Impressão do DANFE NFC-e (O Gargalo):** Aqui está o ponto que você quer revolucionar. O PDV gera uma representação visual e simplificada do cupom, chamada **DANFE NFC-e**. Este é o papel que a impressora térmica imprime. Por lei, este papel deve conter a chave de acesso (44 dígitos) e um **QR Code que aponta para o portal de consulta pública da SEFAZ**.

---

### Parte 2: Onde sua API "ByeBye Cupom!" Entra na Jogada

Excelente! A sua análise do problema e a decisão de adotar uma arquitetura de "package-by-feature" (ou fatia vertical) já colocam o projeto ByeByeCupom em um caminho de sucesso, escalabilidade e manutenibilidade.


### A Mudança de Paradigma: Do "Como" para o "O Quê"

|Nome Técnico (O Como)|Propósito de Negócio (O Quê)|Novo Módulo Sugerido|
|---|---|---|
|`xml`|É o ato de receber e processar o documento fiscal que chega.|`ingestion` (Ingestão)|
|`pdf`|É a geração da representação visual e legível do cupom. O nome oficial disso é DANFE.|`danfegeneration` (Geração de DANFE)|
|`qrcode`|É o mecanismo de entrega/acesso para o cliente final.|`distribution` (Distribuição)|

Com base nessa tradução, podemos criar uma estrutura de pacotes que conta a história do seu negócio.

---

## Estrutura de Pacotes Proposta para o ByeByeCupom

Aqui está uma proposta de estrutura de pacotes para um projeto Java (usando uma estrutura de nomenclatura comum, como em projetos Spring Boot), com explicações detalhadas de cada parte.

Plaintext

```
com
└── byebyecupom
    ├── ByeByeCupomApplication.java   // Ponto de entrada da aplicação
    │
    ├── ingestion/                    // Módulo: Ingestão e Processamento do Cupom
    │   ├── api/                      // Camada de Interface (Controllers)
    │   │   ├── IngestionController.java
    │   │   └── dto/
    │   │       ├── IngestionRequest.java  (Contém o XML como String ou Base64)
    │   │       └── IngestionResponse.java (Contém a imagem do QR Code e/ou a URL)
    │   ├── service/                  // Lógica de Negócio da Ingestão
    │   │   └── IngestionService.java
    │   └── exception/
    │       └── InvalidXmlException.java
    │
    ├── fiscaldocument/               // Módulo: O Domínio Central - O Documento Fiscal
    │   ├── model/
    │   │   └── FiscalDocument.java   // Entidade principal (JPA/NoSQL)
    │   ├── repository/
    │   │   └── FiscalDocumentRepository.java
    │   └── vo/                       // Value Objects (opcional, para tipos fortes)
    │       └── AccessKey.java        // Ex: Um objeto para a Chave de Acesso de 44 dígitos
    │
    ├── danfegeneration/              // Módulo: Geração do DANFE (PDF)
    │   ├── service/
    │   │   └── DanfeGeneratorService.java
    │   └── model/
    │       └── DanfeData.java        // Objeto com os dados extraídos do XML para gerar o PDF
    │
    ├── distribution/                 // Módulo: Distribuição e Acesso
    │   ├── service/
    │   │   └── QrCodeService.java
    │   └── model/
    │       └── PublicUrl.java        // Objeto que representa a URL pública do cupom
    │
    └── shared/                       // Módulo: Código compartilhado e Infraestrutura
        ├── config/
        │   └── StorageProperties.java // Configurações do S3, Azure, etc.
        └── infrastructure/
            └── storage/
                ├── FileStorageService.java   // Interface (Contrato)
                └── impl/
                    ├── S3FileStorageService.java // Implementação para AWS S3
```

### Detalhando as Responsabilidades de Cada Módulo

#### 1. `ingestion` (Ingestão)

Este é o portão de entrada do seu sistema.

- **Propósito:** Receber o XML autorizado do PDV, validar sua estrutura básica e orquestrar o fluxo de processamento.
    
- **`IngestionController.java`:** Define o endpoint `POST /v1/ingestion`. Ele recebe o `IngestionRequest`, chama o `IngestionService` e retorna o `IngestionResponse`. É a camada mais externa, lidando apenas com HTTP.
    
- **`IngestionService.java`:** O maestro do fluxo. Ele não sabe _como_ gerar um PDF ou _como_ salvar em nuvem, mas sabe _quem chamar_ para fazer isso.
    
    1. Recebe o XML.
        
    2. Chama um parser para extrair dados e validar.
        
    3. Cria e salva uma entidade `FiscalDocument` usando o `FiscalDocumentRepository`.
        
    4. Chama o `DanfeGeneratorService` para criar o PDF.
        
    5. Chama o `FileStorageService` para salvar o XML e o PDF, obtendo as URLs.
        
    6. Atualiza a entidade `FiscalDocument` com as URLs.
        
    7. Chama o `QrCodeService` para gerar o QR Code a partir da URL pública do PDF.
        
    8. Retorna os dados para o `Controller`.
        

#### 2. `fiscaldocument` (Documento Fiscal)

Este é o coração do seu domínio de negócio.

- **Propósito:** Representar o cupom fiscal como uma entidade central e persistente no sistema.
    
- **`FiscalDocument.java`:** É a classe que mapeia para o seu banco de dados (SQL ou NoSQL). Conteria campos como `id` (UUID), `accessKey` (chave de acesso), `xmlStorageUrl`, `pdfStorageUrl`, `issueDate`, `totalAmount`, etc.
    
- **`FiscalDocumentRepository.java`:** A interface para salvar e buscar instâncias de `FiscalDocument` no banco de dados (ex: `extends JpaRepository`).
    

#### 3. `danfegeneration` (Geração de DANFE)

Este módulo tem uma única e clara responsabilidade.

- **Propósito:** Transformar os dados de um cupom fiscal em uma representação visual (PDF) seguindo o layout oficial do DANFE NFC-e.
    
- **`DanfeGeneratorService.java`:** Recebe os dados necessários (provavelmente um objeto `DanfeData` ou o próprio XML), usa uma biblioteca como OpenPDF ou iText, e retorna o PDF como um array de bytes (`byte[]`). Ele não sabe nada sobre armazenamento ou HTTP.
    

#### 4. `distribution` (Distribuição)

Este módulo cuida de como o cliente final acessará o cupom.

- **Propósito:** Criar os mecanismos de acesso ao cupom gerado.
    
- **`QrCodeService.java`:** Recebe uma URL (ex: `https://storage.byebyecupom.com.br/coupons/{uuid}.pdf`) e retorna a imagem do QR Code, também como um array de bytes (`byte[]`), que pode ser facilmente convertido para Base64 no `IngestionResponse`.
    

#### 5. `shared` (Compartilhado)

Este é o local para código que não pertence a uma única funcionalidade de negócio, mas que é usado por várias.

- **Propósito:** Conter componentes de infraestrutura, configurações e utilitários transversais.
    
- **`infrastructure/storage/FileStorageService.java`:** Define um _contrato_ para armazenamento de arquivos (ex: `upload(fileBytes, fileName)`). Isso é crucial para desacoplar sua lógica de negócio da tecnologia de nuvem específica. Amanhã, se você quiser mudar do S3 para o Azure Blob Storage, só precisará criar uma nova implementação (`AzureFileStorageService.java`) sem tocar em nenhum outro módulo.
    

### Vantagens Desta Estrutura

1. **Clareza de Negócio:** Qualquer novo desenvolvedor que olhar a estrutura de pacotes entenderá imediatamente o que o sistema faz: ele ingere documentos, os representa como DANFEs e os distribui.
    
2. **Alta Coesão:** Todo o código relacionado à geração de PDF está em um único lugar (`danfegeneration`). Se a SEFAZ mudar uma regra visual do DANFE, você sabe exatamente qual módulo modificar.
    
3. **Baixo Acoplamento:** O módulo de `ingestion` não precisa saber como um PDF é gerado. Ele apenas chama um serviço que faz isso. O `danfegeneration` não sabe onde o PDF será salvo. Isso torna o sistema flexível a mudanças.
    
4. **Testabilidade:** Você pode testar a geração de QR Code (`distribution`) de forma totalmente isolada, sem precisar de um endpoint HTTP ou de um banco de dados.
    
5. **Escalabilidade Organizacional:** Se sua equipe crescer, você pode atribuir a "Equipe de Distribuição" para cuidar de novas formas de entrega (como enviar por WhatsApp ou E-mail), e eles trabalharão primariamente no módulo `distribution` sem causar conflitos com a equipe que cuida da `ingestion`.
    

Esta é uma base sólida e profissional para o seu Micro SaaS. Ela não apenas organiza o código de forma lógica, mas também alinha a estrutura do software diretamente com os processos de negócio que ele serve.
    

---
### Parte 3: Detalhes da API em Java (Estrutura e Ferramentas)

**Framework:**

- **Spring Boot:** padrão de mercado para criar APIs REST em Java. Simples, produtivo e robusto.
    

**Dependências Essenciais (Maven/Gradle):**

- `spring-boot-starter-web`: Para controllers e endpoints REST.
    
- **iText 7** ou **Apache PDFBox**: Para geração e manipulação de PDFs (DANFE).
    
- **JAXB** ou **Jackson XML**: Para parsing do XML autorizado enviado pelo PDV.
```xml
<?xml version="1.0" encoding="UTF-8"?>
<nfeProc versao="4.00" xmlns="http://www.portalfiscal.inf.br/nfe">
    <NFe xmlns="http://www.portalfiscal.inf.br/nfe">
        <infNFe versao="4.00" Id="NFe33250955997109000137650010000121351019252294">
            <ide>
                <cUF>33</cUF> <cNF>01925229</cNF>
                <natOp>VENDA</natOp>
                <mod>65</mod> <serie>1</serie>
                <nNF>12135</nNF>
                <dhEmi>2025-09-22T16:30:10-03:00</dhEmi>
                <tpNF>1</tpNF>
                <idDest>1</idDest>
                <cMunFG>3304201</cMunFG> <tpImp>4</tpImp> <tpEmis>1</tpEmis> <cDV>4</cDV>
                <tpAmb>1</tpAmb> <finNFe>1</finNFe>
                <indFinal>1</indFinal>
                <indPres>1</indPres>
                <procEmi>0</procEmi>
                <verProc>1.0</verProc>
            </ide>
            <emit>
                <CNPJ>55997109000137</CNPJ>
                <xNome>COMERCIO AGRO E PET PARAISO</xNome>
                <enderEmit>
                    <xLgr>AVENIDA JEFERSO GERALDO BRUNO</xLgr>
                    <nro>1640</nro>
                    <xBairro>PARAISO</xBairro>
                    <cMun>3304201</cMun>
                    <xMun>Resende</xMun>
                    <UF>RJ</UF>
                    <CEP>27535000</CEP> <cPais>1058</cPais>
                    <xPais>Brasil</xPais>
                </enderEmit>
                <IE>81181181</IE> <CRT>1</CRT> </emit>
            <det nItem="1">
                <prod>
                    <cProd>3574</cProd>
                    <cEAN/>
                    <xProd>WHISKAS CARNE GRANEL</xProd>
                    <NCM>23091000</NCM> <CFOP>5102</CFOP>
                    <uCom>UN</uCom>
                    <qCom>1.4200</qCom>
                    <vUnCom>16.90</vUnCom>
                    <vProd>24.00</vProd>
                    <cEANTrib/>
                    <uTrib>UN</uTrib>
                    <qTrib>1.4200</qTrib>
                    <vUnTrib>16.90</vUnTrib>
                    <indTot>1</indTot>
                </prod>
                <imposto>
                    <vTotTrib>2.50</vTotTrib> <ICMS>
                        <ICMSSN102>
                            <orig>0</orig>
                            <CSOSN>102</CSOSN> </ICMSSN102>
                    </ICMS>
                    <PIS>
                        <PISOutr>
                            <CST>99</CST>
                            <vBC>0.00</vBC>
                            <pPIS>0.00</pPIS>
                            <vPIS>0.00</vPIS>
                        </PISOutr>
                    </PIS>
                    <COFINS>
                        <COFINSOutr>
                            <CST>99</CST>
                            <vBC>0.00</vBC>
                            <pCOFINS>0.00</pCOFINS>
                            <vCOFINS>0.00</vCOFINS>
                        </COFINSOutr>
                    </COFINS>
                </imposto>
            </det>
            <det nItem="2">
                <prod>
                    <cProd>3293</cProd>
                    <cEAN/>
                    <xProd>SPECIAL DOG CARNE 15KG - 2G</xProd>
                    <NCM>23091000</NCM> <CFOP>5102</CFOP>
                    <uCom>UN</uCom>
                    <qCom>1.0000</qCom>
                    <vUnCom>109.90</vUnCom>
                    <vProd>109.90</vProd>
                    <cEANTrib/>
                    <uTrib>UN</uTrib>
                    <qTrib>1.0000</qTrib>
                    <vUnTrib>109.90</vUnTrib>
                    <indTot>1</indTot>
                </prod>
                <imposto>
                    <vTotTrib>11.50</vTotTrib> <ICMS>
                        <ICMSSN102>
                            <orig>0</orig>
                            <CSOSN>102</CSOSN>
                        </ICMSSN102>
                    </ICMS>
                    <PIS>
                        <PISOutr>
                            <CST>99</CST>
                            <vBC>0.00</vBC>
                            <pPIS>0.00</pPIS>
                            <vPIS>0.00</vPIS>
                        </PISOutr>
                    </PIS>
                    <COFINS>
                        <COFINSOutr>
                            <CST>99</CST>
                            <vBC>0.00</vBC>
                            <pCOFINS>0.00</pCOFINS>
                            <vCOFINS>0.00</vCOFINS>
                        </COFINSOutr>
                    </COFINS>
                </imposto>
            </det>
            <total>
                <ICMSTot>
                    <vBC>0.00</vBC>
                    <vICMS>0.00</vICMS>
                    <vICMSDeson>0.00</vICMSDeson>
                    <vFCP>0.00</vFCP>
                    <vBCST>0.00</vBCST>
                    <vST>0.00</vST>
                    <vFCPST>0.00</vFCPST>
                    <vFCPSTRet>0.00</vFCPSTRet>
                    <vProd>133.90</vProd>
                    <vFrete>0.00</vFrete>
                    <vSeg>0.00</vSeg>
                    <vDesc>0.00</vDesc>
                    <vII>0.00</vII>
                    <vIPI>0.00</vIPI>
                    <vIPIDevol>0.00</vIPIDevol>
                    <vPIS>0.00</vPIS>
                    <vCOFINS>0.00</vCOFINS>
                    <vOutro>0.00</vOutro>
                    <vNF>133.90</vNF>
                    <vTotTrib>14.00</vTotTrib> </ICMSTot>
            </total>
            <transp>
                <modFrete>9</modFrete> </transp>
            <pag>
                <detPag>
                    <tPag>04</tPag> <vPag>24.00</vPag>
                </detPag>
                <detPag>
                    <tPag>04</tPag> <vPag>109.90</vPag>
                </detPag>
                <vTroco>0.00</vTroco>
            </pag>
            <infAdic>
                <infCpl>Trib aprox R$: 14,00 (10.46%) Fonte: IBPT</infCpl>
            </infAdic>
            <infNFeSupl>
                <qrCode>
                    <![CDATA[https://www.fazenda.rj.gov.br/nfce/consulta?p=33250955997109000137650010000121351019252294|2|1|1|ABCDEF1234567890ABCDEF1234567890ABCDEF12]]>
                </qrCode>
                <urlChave>https://www.fazenda.rj.gov.br/nfce/consulta</urlChave>
            </infNFeSupl>
        </infNFe>
        <protNFe versao="4.00">
            <infProt>
                <tpAmb>1</tpAmb>
                <verAplic>4.00</verAplic>
                <chNFe>33250955997109000137650010000121351019252294</chNFe>
                <dhRecbto>2025-09-22T16:30:10-03:00</dhRecbto>
                <nProt>233252255253885</nProt>
                <digVal>dGlnaXZhbD1kZXVz</digVal> <cStat>100</cStat>
                <xMotivo>Autorizado o uso da NF-e</xMotivo>
            </infProt>
        </protNFe>
    </nfeProc>
```
    
- **AWS SDK for Java S3** (ou outro provedor de nuvem, ex: GCP, Azure): Upload seguro dos PDFs para nuvem.
    
- **ZXing** (`com.google.zxing:core` + `com.google.zxing:javase`): Biblioteca leve e consolidada para gerar **QR Codes** em Java.
    

---
**Estrutura de Código Sugerida (Spring Boot)**

1. **`CupomController.java` (A Porta de Entrada):**
    
    - `@RestController` com endpoint `@PostMapping("/v1/coupons")`.
        
    - Recebe o XML autorizado do PDV (via `String` ou `MultipartFile`).
        
    - Invoca `CupomService`.
        
    - Retorna `ResponseEntity` com JSON contendo **URL do PDF** e **imagem do QR Code (base64 ou link)**.
        
2. **`CupomService.java` (O Maestro):**
    
    - Classe `@Service` que orquestra toda a lógica:
        
        - Chama `XmlParser` para interpretar o XML.
            
        - Invoca `PdfGeneratorService` para gerar o PDF do DANFE.
            
        - Usa `StorageService` para salvar o PDF em nuvem.
            
        - Gera um UUID para referência.
            
        - Chama `QrCodeService` para criar a imagem do QR Code com a URL segura do PDF.
            
        - Retorna o **downloadUrl** + **qrCodeBase64** para o Controller.
            
3. **`PdfGeneratorService.java` (O Artista):**
    
    - Usa **iText 7** ou **PDFBox** para criar o DANFE.
        
    - Insere dados do XML no layout.
        
    - Retorna o arquivo PDF pronto para ser salvo.
        
4. **`S3StorageService.java` (O Armazenador):**
    
    - Implementa o upload para **S3** (ou outro storage).
        
    - Retorna a **URL segura/presigned URL** do PDF.
        
5. **`QrCodeService.java` (O Gravador de Símbolos):**
    
    - Usa **ZXing** para gerar o QR Code a partir da URL retornada pelo storage.
        
    - Exporta a imagem como **PNG** (ou retorna em **base64** se preferir enviar inline na resposta da API).
        
    - Retorna a string/base64 ou caminho da imagem.
        

---

### Fluxo Final (Resumido)

1. **PDV → API:** Envia XML autorizado.
    1. **API:**
    - Valida XML.
        
    - Gera PDF (DANFE).
        
    - Salva no Storage.
        
    - Gera QR Code apontando para a URL do PDF.
        
3. **API → PDV:** Retorna JSON com:
    
    ```json
    {
      "downloadUrl": "https://storage/.../cupom123.pdf",
      "qrCodeBase64": "iVBORw0KGgoAAAANSUhEUg..." 
    }
    ```
    
4. **PDV → Cliente:** Apenas **exibe o QR Code** recebido.
    
5. **Cliente:** Escaneia QR Code → baixa cupom digital.
    

---

👉 Essa arquitetura garante que toda a parte “pesada” (geração de PDF e QR Code) fica **centralizada na ByeByeCupom**, deixando o **PDV leve e simples**.

Quer que eu monte um **exemplo de código real em Java (Spring Boot)** para a classe `QrCodeService` usando ZXing?