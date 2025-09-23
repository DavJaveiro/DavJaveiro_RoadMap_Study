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

Sua API vai atuar como um "gancho" inteligente, logo após o cupom ser oficialmente gerado e antes da impressão.
Veja o fluxo modificado:
1. **(Passos 1 a 6 do fluxo padrão acontecem normalmente)** O PDV tem em mãos o **XML autorizado pela SEFAZ**. Este é o seu ponto de partida.
    
2. **PDV Chama sua API:** Em vez de mandar imprimir, o PDV fará uma chamada **HTTP POST** para um endpoint da sua API Java (ex: `https://api.byebyecupom.com.br/v1/coupons`). No corpo dessa requisição, ele enviará o **XML autorizado completo**.
    
3. **Sua API Java em Ação:** Aqui está o núcleo do seu desenvolvimento. Sua API irá executar as seguintes tarefas:
    - **Receber e Validar:** O endpoint recebe o XML. É uma boa prática fazer uma validação básica para garantir que o arquivo não está corrompido.
    - **Gerar o PDF (DANFE):** Usando uma biblioteca Java, sua API vai ler os dados do XML e "desenhar" o DANFE em um arquivo PDF, seguindo o layout visual padrão.
        
    - **Armazenar o PDF:** O PDF recém-gerado é salvo em um local seguro e de alta disponibilidade, como um serviço de armazenamento em nuvem (Amazon S3, Azure Blob Storage, etc.). O arquivo deve receber um nome único e não sequencial (ex: um UUID) para segurança.
        
    - **Gerar a URL de Download:** Sua API cria a URL pública e permanente que aponta para o PDF armazenado (ex: `https://storage.byebyecupom.com.br/coupons/uuid-aleatorio-aqui.pdf`).
        
    - **Retornar a URL ao PDV:** A API responde à chamada do PDV com um JSON simples, contendo a URL de download. Exemplo: `{ "downloadUrl": "https://..." }`.
        
4. **PDV Gera o QR Code:** O software PDV recebe essa URL da sua API e, usando uma biblioteca do ByeByeCupom, gera um novo QR Code que aponta para a sua URL de download.
    
5. **Disponibilização ao Cliente:** O PDV exibe este QR Code na tela do caixa ou em um display para o cliente, que escaneia e baixa o PDF.
    

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