Grande parte do que os programas de rede fazem é simplesmente entrada e saída I/O: mover bytes de um sistema para o outro. Bytes são bytes; em grande partem ler os dados que um servidor nos envia não é tão diferente de ler um arquivo. Enviar texto para um cliente não é tão diferente de escrever em um arquivo. No entanto, a entrada e a saída I/O em Java é organizada de forma diferente do que na maioria das outras linguagens, como Fortran, C e C++. Consequentemente, levarei algumas páginas para resumir a abordagem exclusiva do Java para I/O.

O I/O em Java é construído sobre #streams (fluxos). #Streams de entrada leem dados; streams de saída escrevem dados. Diferentes classes de #stream, como #FileInputStream e #TelnetOutputStream, leem e escrevem fontes específicas de dados. No entanto, todos os streams de saída possuem os mesmos métodos básicos para escrever dados, e todos os streams de entrada usam os mesmos métodos básicos para ler dados. Depois que um _stream_ é criado, você frequentemente pode ignorar os detalhes exatos do que está lendo ou escrevendo.

Streams de filtro podem ser encadeados a um stream de entrada ou de saída. Os filtros podem modificar os dados à medida que são lidos ou escritos, por exemplo, criptografando-os ou compactando-os, ou podem simplesmente fornecer métodos adicionais para converter os dados lidos ou escritos em outros formatos. Por exemplo, a classe #DataOutputStream fornece um método que converte um #int em quatro bytes e escreve esses bytes em seu stream de saída subjacente.

#Readers e #Writers podem ser encadeados a streams de entrada e saída para permitir que os programas leiam e escrevam texto (ou seja, caracteres) em vez de bytes. Usado corretamente, readers e writers podem lidar com uma ampla variedade de codificações de caracteres, incluindo conjuntos de caracteres multibyte como SJIS e UTF-8.

Os #streams são síncronos, ou seja, quando um programa (na verdade, uma #thread) pede a um stream para ler ou escrever um dado, ele espera que os dados sejam lidos ou escritos antes de fazer qualquer outra coisa. O Java também oferece I/O não bloqueante (nonblocking I/O) usando canais #channels e buffers. O I/O não bloqueante é um pouco mais complicado, mas pode ser muito mais rápido em algumas aplicações de alto volume, como servidores web. Normalmente, o modelo básico de stream é tudo que precisamos e tudo que deveriamos usar para clientes. Como canais e buffers dependem de streams, começarei com streams e clientes e, mais tarde, discutirei o I/O não bloqueante para uso com servidores no Capítulo 11.

> O middleware usa channels e buffers, mas não usa I/O não bloqueante.

Os fundamentos de `java.io` e `java.nio` seguem atuais, mas pacotes `sun.*` são obsoletos. Além disso, a introdução das _Virtual Threads_ no Java 21 trouxe o I/O síncrono bloqueante de volta como o padrão moderno e escalável para servidores.


