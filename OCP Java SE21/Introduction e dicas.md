São 50 questões
90 minutos ou 5400 segundos
68% Pontuação para aprovação

5400/50 = 108s
68% de 50 = 34
O tempo médio gasto para cada questão é de 1 min 48 sec.
Precisamos acertar, no mínimo, 34 questões.

Este livro é para quem deseja realizar o exame *Java SE 21 Developer Professional (1Z0-830)* e obter o título Java 21 Developer Certified Professional. Esse exame é comumente chamado de OCP (Oracle Certified Professional) 21.

Também é destinado a quem busca um entendimento mais profundo e uma maior apreciação da linguagem Java. Não queremos apenas que você passe nos exames, mas também que melhore suas habilidades e se torna um *software developer* mais capacitado.

O livro oferece preparação detalhada para o seguinte exame de certificação da Oracle:

**Exame 1Z0-830: Java SE 21 Developer Professional**

O exame Developer Professional abrange uma ampla variedade de tópicos essenciais do Java 21, incluindo *classes*, *interfaces*, *streams*, *collections*, *concurrency* e *modules*.

Nesta introdução, começamos abordando informações importantes sobre diversos exames. Em seguida, passamos para detalhes sobre a estrutura deste livro. Por fim, concluímos com um *assessment test* para que você possa avaliar quanto estudo ainda precisa ser feito.

## Entendendo o Exame
No final das contas, o exame consiste em uma lista de perguntas. Quanto mais soubermos sobre a estrutura do exame, melhor será o nosso desempenho. Por exemplo, saber quantas perguntas o exame contém permite que gerenciemos melhor o nosso progresso e o tempo restante.

Nesta seção, discutimos os detalhes do exame, além de um pouco da história das certificações anteriores.

## Escolhendo Qual Exame Fazer
O Java já tem cerca de 30 anos, comemorando seu "nascimento" em 1995. Como qualquer tecnologia dessa idade, há uma boa dose de história e variações entre as diferentes versões do Java. Ao longo dos anos, os exames de certificação mudaram para cobrir tópicos diferentes. O número de exames e os nomes das certificações também mudaram.

A Oracle simplificou as coisas com o tempo. Tornar-se um _Oracle Certified Professional_ agora exige passar em apenas um exame, não dois, e não há exames de atualização (_upgrade exams_) para o Java 21. Independentemente das certificações anteriores que você possua, todos fazem o mesmo exame _Java 21_ para se tornarem um _Oracle Certified Professional_.

Há outro exame menos popular chamado _Java Foundations exam_. Nosso conselho é fazer o exame _Java Foundations_ apenas se o seu empregador solicitar especificamente, pois ele não é voltado para profissionais que trabalham com Java diariamente. Nossa página do livro explica como usar este material para estudar para o _Java Foundations exam_.

**Diferenças entre o exame 21 e os exames anteriores**
Se você já é certificado em uma versão mais antiga do Java, pode esperar que o exame **Java 21** seja muito parecido com os exames que você fez no passado. Embora existam algumas semelhanças, o exame também apresenta diferenças significativas que você deve conhecer:

- **As questões são geralmente mais longas**, com mais código para ler e muito mais opções de resposta (até 10).
    
- **As perguntas frequentemente abrangem múltiplos objetivos independentes**.
    
- **Há maior risco de ficar sem tempo** neste exame.
    
- **Não há mais o recurso no software do exame** de clicar com o botão direito e riscar as opções que você já descartou.
    

Em nossa experiência, percebemos que este é um exame **mais desafiador** do que alguns dos exames anteriores de Java. Por isso, é essencial **dedicar um tempo adequado aos estudos** para se preparar bem.

### Realizando o Exame Online

No passado, o exame era oferecido tanto em **centros de teste físicos** quanto **online**, com um **proctor remoto**. Atualmente, a Oracle oferece o exame **apenas no formato online**, o que significa que você precisará fazê-lo remotamente.

#### Requisitos para o Exame Remoto:

- **Ambiente silencioso**, sem interrupções durante toda a duração do exame.
    
- **Instalação de um software de monitoramento** antes do exame, que garante a integridade da avaliação.
    
    - Por esse motivo, **não recomendamos usar um computador corporativo**, onde a instalação de softwares adicionais pode ser restrita.


### Revisando o Formato do Exame
No momento da publicação deste livro, os detalhes do exame são os seguintes:

- **Tempo limite:** 120 minutos
    
- **Número de questões:** 50
    
- **Pontuação para aprovação:** 68% (34 questões corretas)
    

#### Observações Importantes:

- A Oracle tem o hábito de ajustar a **duração do exame** e a **pontuação mínima para aprovação** após o lançamento.
    
- A Oracle também costuma fazer **pequenas alterações nos objetivos do exame (exam objectives)** ao longo do tempo.
    
- Não seria surpresa se a Oracle modificasse levemente os **objetivos do exame**, o **número de questões** ou a **nota de corte** após a impressão deste livro.

## Analisando os Objetivos do Exame
A Oracle fornece uma lista de **objetivos (exam objectives)** para orientar seus estudos. Cada objetivo inclui **sub-objetivos (sub-objectives)** que detalham o conteúdo cobrado. No entanto, esses objetivos **não abrangem todo o material necessário** para passar no exame.

#### Então, como saber o que estudar?

- **Este guia de estudos foi criado exatamente para isso!**
    
    - Passamos anos analisando as versões anteriores dos exames de certificação.
        
    - Selecionamos cuidadosamente **tópicos, material e questões práticas** que aumentam suas chances de sucesso.
        
    - Nos últimos 10 anos, trabalhamos diretamente com a Oracle no desenvolvimento e refinamento dos objetivos para os exames **Java 8, Java 11, Java 17 e Java 21**.
        
    - Inclusive, fomos responsáveis por **remover o JDBC do exame Java 21** – isso significa um capítulo a menos para estudar! 🎉

### Escopo dos Objetivos do Exame

#### Evolução dos Objetivos de Certificação
Nos exames de certificação anteriores (como OCP 8 - 1Z0-809), os objetivos eram extremamente específicos:

**Exemplo OCP 8:**
```plaintext
Usar BufferedReader, BufferedWriter, File, FileReader, 
FileWriter, FileInputStream, FileOutputStream, 
ObjectOutputStream, ObjectInputStream e PrintWriter 
do pacote java.io.
```

Em contraste, a versão atual (OCP 21 - 1Z0-830) apresenta objetivos mais amplos:

**Equivalente OCP 21:**
```plaintext
Ler e escrever dados no console e arquivos usando I/O Streams.
```
#### Principais Diferenças:
1. **Especificidade vs. Generalização**
   - Antes: Listagem explícita de classes e APIs
   - Agora: Descrições conceituais mais abrangentes

2. **Flexibilidade para a Oracle**
   - Permite incluir novos recursos sem atualizar os objetivos
   - Dá mais liberdade aos elaboradores do exame

3. **Impacto nos Estudos**
   - Exige conhecimento mais profundo dos conceitos fundamentais
   - Amplia o leque de possíveis questões sobre cada tópico

*(Termos técnicos mantidos em inglês: OCP, I/O Streams, APIs, java.io package)*

**Dica Crítica:** Prepare-se para ir além do básico - o exame moderno testa sua capacidade de aplicar conceitos, não apenas memorizar classes específicas!

#### 1. Declarações de Pacote e Import Ausentes

- Quando um código de exemplo <span style="background:#d4b106">não incluir declarações</span> `package` ou `import`:
    
    - Assuma que todo o código está no **mesmo pacote**
        
    - Ou que as **declarações de import necessárias** existem
        
    - A menos que a questão mencione explicitamente essas ausências

#### 2. Nomes de Arquivo e Diretórios Não Especificados

- Quando não forem fornecidos nomes de arquivo ou locais de diretório:
    - Considere uma destas situações (o que for necessário para compilar/executar):
        1. **Todas as classes em um único arquivo** (.java)
        2. **Cada classe em arquivo separado**, mas todos no **mesmo diretório**
            

