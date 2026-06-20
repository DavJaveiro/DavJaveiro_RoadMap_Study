## Preface
Quando a O’Reilly me abordou pela primeira vez sobre escrever um livro sobre _tuning_ de performance Java, fiquei inseguro. Performance Java, eu pensei—já não terminamos com esse assunto? Sim, eu ainda trabalho melhorando a performance de aplicações Java (e outras) diariamente, mas gosto de pensar que passo a maior parte do meu tempo lidando com ineficiências algorítmicas e gargalos de sistemas externos, em vez de qualquer coisa diretamente relacionada ao _tuning_ do Java.

Um momento de reflexão me convenceu de que eu estava (como sempre) me enganando. É certamente verdade que a performance de sistemas de ponta a ponta toma muito do meu tempo, e que às vezes encontro código que usa um algoritmo O(n²) quando poderia usar um com performance O(log N). Ainda assim, a realidade é que todos os dias eu penso sobre a performance do _Garbage Collection_ (GC), ou a performance do compilador da JVM, ou como obter a melhor performance das APIs do Java.

Isso não é para minimizar o enorme progresso que foi feito na performance do Java e das JVMs ao longo dos últimos 20 e tantos anos. Quando eu era um evangelista Java na Sun no final dos anos 1990, o único "benchmark" real disponível era o CaffeineMark 2.0 da Pendragon software. Por uma variedade de razões, o design daquele benchmark limitou rapidamente seu valor; ainda assim, em sua época, gostávamos de dizer a todos que a performance do Java 1.1.8 era oito vezes mais rápida que a performance do Java 1.0 com base naquele benchmark. E isso era verdade—o Java 1.1.8 tinha um compilador _just-in-time_ real, enquanto o Java 1.0 era quase completamente interpretado.

> A dúvida do autor é hoje ainda mais perigosa. Com o advento de Cloud, Containers e KUbernetes, assumir que a JVM "se vira" sozinha custa dinheiro vivo. Aplicações Spring Boot mal configuradas podem consumir gigabytes de *heap* desnecessariamente. A falta de otimização agora impacta diretamente o FinOps (custo em nuvem).                                                                                                                                                                                           

Escrever testes de performance manuais: avaliar performance usando *System.currentTimeMillis()*  em *loops* simples é uma prática severamente ultrapassada e perigosa. O compilador JIT do Java moderno fará o *loop unrolling*, removerá alocações (via Escape Analysis) e invalidará a métrica. Hoje, qualquer medição de código isolado deve ser feita obrigatoriamente com o framework JMH (Java Microbenchmark Harness).

**Aplicação prática em Java**
O texto menciona a otimização algorítmica de O(n<sup>2</sup>) para o O(log N). Em um cenário real de Spring Boot e persistência de dados, um erro comum é fazer buscas iterativas em memória em vez de usar estruturas eficientes ou delegar para o banco de dados.

**Exemplo Ruim (Abordagem ingênua O(n<sup>2</sup>**):
```java
// Anti-pattern: comparando duas liastas de 10.000 usuário em memória
// Isso gera alta utilização de CPU e aumento severo do allocation rate.
public List<User> findDuplicateUsers(List<User> listA, LIst<User> listB) {
	List<User> duplicates = new ArrayList<>();
	for (User userA: listA) {
		for (User userB : ListB) {
			if (userA.getId().equals(userB.getId())) { 
				duplicates.add(UserA);
			}
		}
	}
	return duplicates;
}
```

*Gargalo:* á medida que as listas crescem, o tempo de execução explode. O JIT não consegue salvar agente, aqui. A alocação excessiva de CPU fará outras *threads* do *thread* pool do Tomcat sofrerem de *starvation*, aumentando a *latency* geral dos endpoints REST.

**Exemplo Melhorado (O(N) com complexidade de busca O(1)):**
```java
public List<User> findDuplicateUsersOptimized(List<User> listA, List<User> listB) {
	Set<Long> idsLIstB = listB.stream().map(User::getId).collect(Collectors.toSet());
	
	return listA.stream()
			.filter(userA -> idsListB.contains(userA.getId())))
			.collect(Collectors.toList());
}
```

**Como medir e diagnosticar na prática**
- Métrica a observar: Tempo de resposta (p95 e p99) da requisição HTTP; Taxa de uso de CPU do container Kubernates;
- **Ferramentas:* Async-profiler*: para gerar um Flame Graph** e observar qual método está consumindo CPU (neste caso, ArrayList.contains) ou o equals dos objetos apareceria em chamas.
- **JFR (Java Flight Recorder):** Habilitar via `-XX:StartFlightRecording` para verificar o _allocation rate_ e ver se o algoritmo ruim está disparando pequenos ciclos de _Minor GC_ excessivamente.

Então, comitês de padrões começaram a desenvolver _benchmarks_ mais rigorosos, e a performance Java passou a se concentrar neles. O resultado foi uma melhoria contínua em todas as áreas da JVM — _garbage collection_, compilações e dentro das APIs. Esse processo continua hoje, é claro, mas um dos fatos interessantes sobre o trabalho de performance é que ele se torna sucessivamente mais difícil. Alcançar um aumento de performance de oito vezes introduzindo um compilador _just-in-time_ foi uma questão simples de engenharia e, embora o compilador continue a melhorar, não veremos uma melhoria como essa novamente. Paralelizar o _garbage collector_ foi uma enorme melhoria de performance, mas as mudanças mais recentes têm sido mais incrementais.

Este é um processo típico para aplicações (e a própria JVM é apenas mais uma aplicação): no início de um projeto, é fácil encontrar mudanças arquiteturais (ou _bugs_ de código) que, quando resolvidos, geram enormes melhorias de performance. Em uma aplicação madura, encontrar tais melhorias de performance é raro.

Esse preceito estava por trás da minha preocupação original de que, em grande medida, o mundo da engenharia poderia já ter terminado com a performance Java. Algumas coisas me convenceram de que eu estava errado. Primeiro, é o número de perguntas que vejo diariamente sobre como este ou aquele aspecto da JVM se comporta sob certas circunstâncias. Novos engenheiros chegam ao Java o tempo todo, e o comportamento da JVM permanece complexo o suficiente em certas áreas para que um guia sobre sua operação ainda seja benéfico. Segundo, as mudanças ambientais na computação parecem ter alterado as preocupações de performance que os engenheiros enfrentam hoje.

Ao longo dos últimos anos, as preocupações com performance se bifurcaram. Por um lado, máquinas muito grandes, capazes de executar JVMs com _heaps_ muito grandes, agora são comuns. A JVM se moveu para lidar com essas preocupações com um novo _garbage collector_ (G1), que — como uma nova tecnologia — requer um pouco mais de _tuning_ manual do que os coletores tradicionais. Ao mesmo tempo, a computação em nuvem renovou a importância de máquinas pequenas com uma única CPU: você pode ir à Oracle ou Amazon, ou a uma série de outras empresas, e alugar de forma barata uma máquina de uma única CPU para executar um pequeno servidor de aplicação. (Você não está realmente obtendo uma máquina de uma CPU: está obtendo uma imagem de SO virtual em uma máquina muito grande, mas o SO virtual é limitado ao uso de uma única CPU. Da perspectiva do Java, isso acaba sendo o mesmo que uma máquina de uma única CPU.) Nesses ambientes, gerenciar corretamente pequenas quantidades de memória acaba sendo muito importante.

A plataforma Java também continua a evoluir. Cada nova edição do Java fornece novos recursos de linguagem e novas APIs que melhoram a produtividade dos desenvolvedores — se não sempre a performance de suas aplicações. O uso das melhores práticas desses recursos de linguagem pode ajudar a diferenciar entre uma aplicação que brilha e uma que apenas se arrasta. E a evolução da plataforma levanta questões interessantes de performance: <span style="background:#fff88f">não há dúvida de que usar JSON para trocar informações entre dois programas é muito mais simples do que inventar um protocolo proprietário altamente otimizado.</span> Economizar tempo para os desenvolvedores é uma grande vitória — mas garantir que essa vitória em produtividade venha acompanhada de uma vitória em performance (ou pelo menos empate) é o verdadeiro objetivo.

**O Paradoxo JSON (Produtividade vs. Custo Computacional):** JSON é o padrão absoluto em APIs REST pela sua legibilidade e interoperabilidade, mas é extremamente ineficiente do ponto de vista de CPU e de uso de memória (_allocation rate_). A serialização/desserialização baseada em reflexão e conversão de _strings_ cria uma enorme quantidade de objetos de vida curta no _heap_, pressionando o _Garbage Collector_. O _trade-off_ direto aqui é **Custo de Desenvolvimento vs. Custo Operacional (Cloud)**.

## Introduction
Este livro é sobre a arte e a ciência da performance Java.
A parte da ciência desta afirmação não é surpreendente; discussões sobre performance incluem muitos números, medições e análises. A maioria dos engenheiros de performance tem formação em ciências, e aplicar o rigor científico é uma parte crucial para alcançar a performance máxima.

#Tuning: ajustar o sistema para melhorar o desempenho, estabilidade e uso de recursos. Fazer tuning é investigar alguns problemas clássicos:
- A rota demora 5 segundos para responder
- A aplicação consome muita memória
- A CPU fica em 100%
- O banco começa a travar
- O garbare collector fica rodando o tempo todo
- A aplicação aguenta poucos usuários simultâneos

E quanto à parte da arte? A noção de que o *tuning* de performance é parte arte e parte ciência dificilmente é nova, mas raramente recebe um reconhecimento explícito nas discussões sobre performance. Isso ocorre em parte porque a ideia de "arte" vai contra o nosso treinamento. Mas o que parece arte para algumas pessoas é fundamentalmente baseado em conhecimento profundo e experiência. Diz-se que a magia é indistinguível de tecnologias suficientemente avançadas, e certamente é verdade que um telefone celular pareceria mágico para um cavaleiro da Távola Redonda. Da mesma forma, o trabalho produzido por um bom engenheiro de performance pode parecer arte, mas essa arte é realmente uma aplicação de conhecimento profundo, experiência e intuição.

Este livro não pode ajudar com a parte de experiência e intuição dessa equação, mas pode fornecer o conhecimento profundo — com a visão de que aplicar o conhecimento ao longo do tempo o ajudará a desenvolver as habilidades necessárias para ser um bom engenheiro de performance Java. O objetivo é dar a você uma compreensão profunda dos aspectos de performance da plataforma Java.

Esse conhecimento se divide em duas categorias amplas. A primeira é a performance da própria Java Virtual Machine (JVM): a forma como a JVM é configurada afeta muitos aspectos da performance de um programa. Desenvolvedores que são experientes em outras linguagens podem achar a necessidade de *tuning* um pouco irritante, embora, na realidade, o *tuning* da JVM seja completamente análogo a testar e escolher *flags* de compilador durante a compilação para programadores C++, ou a configurar variáveis apropriadas em um arquivo php.ini para codificadores PHP, e assim por diante.

O segundo aspecto é entender como os recursos da plataforma Java afetam a performance. Anotemos a palavra plataforma aqui: alguns recursos (por exemplo, *threading* e sincronização) são parte da linguagem, e alguns recursos (por exemplo, manipulação de strings) são parte da API padrão do Java. Embora existam distinções importantes entre a linguagem Java e a API Java, neste caso elas serão tratadas de forma semelhante. Este livro cobre ambas as facetas da plataforma.

A performance da JVM é baseada em grande parte em *flags* de *tuning*, enquanto a performance da plataforma é determinada mais pelo uso de melhores práticas dentro do código de nossa aplicação. Por muito tempo, essas foram consideradas áreas separadas de especialidade: os desenvolvedores codificam, e o grupo de performance testa e recomenda correções para problemas de performance. Essa nunca foi uma distinção particularmente útil, qualquer pessoa que trabalhe com Java deve ser igualmente adepta a entender como o código se comporta na JVM e quais tipos de *tuning* provavelmente ajudarão em sua performance. À medida que os projetos migram para um modelo devops, essa dinstinção está começando a se tornar menos estrita. O conhecimento da esfera completa é o que dará ao seu trabalho a pátina de arte. 


**Insights**
- **A "Arte" é Metodologia Orientada a Dados:** O que o texto descreve como "intuição" e "arte" em um engenheiro sênior não é adivinhação, mas sim o reconhecimento rápido de padrões. Quando um especialista olha para um gráfico de uso de CPU em dente de serra associado a picos de memória, a sua "intuição" diagnostica um _allocation rate_ excessivo engasgando o _Garbage Collector_. Essa habilidade é construída puramente através do domínio de ferramentas de observabilidade e _profiling_ (JFR, Async-profiler).
- **O Fim do Silo "Código vs. Infraestrutura":** O autor acerta em cheio ao criticar a separação histórica entre quem escreve o código e quem faz o _tuning_ da JVM. Em arquiteturas modernas de microsserviços (como Spring Boot em Kubernetes), escrever um método que aloca muitos objetos temporários (uso ineficiente da plataforma API) exige mais memória RAM. Se o limite do container (`limits.memory`) não for suficiente, o pod sofrerá um _OOMKilled_. O desenvolvedor não pode mais delegar a performance para a equipe de infraestrutura adicionar mais `-Xmx`; ele precisa entender o impacto do seu código no _heap_.
- **Plataforma (API) limitando a JVM:** Muitas vezes o _tuning_ da JVM é inútil se o uso da API Java for equivocado. Você pode configurar o melhor coletor de lixo do mundo (como o ZGC para baixa _latency_), mas se o seu código usa classes com sincronização pesada ou faz requisições HTTP bloqueantes segurando _threads_ do _pool_ do Tomcat, sua aplicação sofrerá de _lock contention_ e baixo _throughput_ de qualquer forma. A JVM não salva código que ignora os fundamentos da ciência da computação.

## A Brief Outline
O capítulo 2 discute metodologias gerais para testar aplicações Java, incluindo armadilhas de *benchmarking* em Java. Uma vez que a análise de performance exige visibilidade do que a aplicação está fazendo, o Capítulo 3 fornece uma visão geral de algumas das ferramentas disponíveis para monitorar aplicações Java.

Então, é hora de mergulhar na performance, focando primeiro nos aspectos comuns de *tuning:* compilação *just-in-time* e *garbage collection*. Os capítulos restantes se concentram nas melhores práticas de uso de várias partes da plataforma Java: uso de memória com o heap do Java, uso de memória nativa, performance de threads, tecnologias de servidores Java, acesso a banco de dados e dicas gerais da API Java SE.

## Platforms and Conventions
Embora este livro trate do desempenho do Java, esse desempenho será influenciado por alguns fatores: a versão do próprio Java, é claro, bem como as plataformas de hardware e software em que está sendo executado.

### Java Platforms
Este livro cobre a performance da Oracle HotSpot Java Virtual Machine (JVM) e do Java Development Kit (JDK), versões 8 e 11. Isso também é conhecido como Java, Standard Edition (SE). O Java Runtime Environment (JRE) é um subconjunto do JDK contendo apenas a JVM, mas como as ferramentas no JDK são importantes para análise de performance, o JDK é o foco deste livro. Na prática, isso significa que ele também cobre plataformas derivadas do repositório OpenJDK dessa tecnologia, o que inclui as JVMs lançadas pelo projeto AdoptOpenJDK. Rigorosamente falando, os binários da Oracle exigem uma licença para uso em produção, e os binários do AdoptOpenJDK vêm com uma licença de código aberto. Para nossos propósitos, consideraremos as duas versões como a mesma coisa, as quais nos referiremos como o JDK ou a plataforma Java.

Esses lançamentos passaram por várias versões de correção de bugs. Enquanto escrevo isso, a versão atual do Java 8 é jdk8u222 (versão 222), e a versão atual do Java 11 é 11.0.5. É importante usar pelo menos essas versões (se não versões posteriores), particularmente no caso do Java 8. Lançamentos iniciais do Java 8 (até cerca da jdk8u60) não contêm muitos dos aprimoramentos de performance e recursos importantes discutidos ao longo deste livro (particularmente no que diz respeito ao Garbage Collection e ao G1 GC).

Essas versões do JDK foram selecionadas porque possuem suporte de longo prazo (LTS) da Oracle. A comunidade Java é livre para desenvolver seus próprios modelos de suporte, mas até agora tem seguido o modelo da Oracle. Portanto, esses lançamentos terão suporte e estarão disponíveis por um bom tempo: pelo menos até 2023 para o Java 8 (via AdoptOpenJDK; posteriormente via contratos estendidos de suporte da Oracle), e pelo menos até 2022 para o Java 11. O próximo lançamento de longo prazo é esperado para o final de 2021.

Para os lançamentos intermediários, a discussão sobre o Java 11 obviamente inclui recursos que foram disponibilizados inicialmente no Java 9 ou Java 10, mesmo que esses lançamentos não sejam suportados nem pela Oracle nem pela comunidade em geral. Na verdade, sou um tanto impreciso ao discutir tais recursos; pode parecer que estou dizendo que os recursos X e Y foram incluídos originalmente no Java 11, quando podem ter estado disponíveis no Java 9 ou 10. O Java 11 é o primeiro lançamento LTS que carrega esses recursos, e essa é a parte importante: uma vez que o Java 9 e o 10 não estão em uso, não importa realmente quando o recurso apareceu pela primeira vez. Da mesma forma, embora o Java 13 já tenha sido lançado no momento da publicação deste livro, não há muita cobertura sobre o Java 12 ou Java 13. Você pode usar esses lançamentos em produção, mas apenas por seis meses, após os quais precisará atualizar para uma nova versão (então, no momento em que você estiver lendo isto, o Java 12 já não terá suporte, e se o Java 13 tiver suporte, em breve será substituído pelo Java 14). Daremos uma espiada em alguns recursos desses lançamentos intermediários, mas como esses lançamentos provavelmente não serão colocados em produção na maioria dos ambientes, o foco permanece no Java 8 e 11.

Outras implementações da especificação da linguagem Java estão disponíveis, incluindo _forks_ da implementação de código aberto. O AdoptOpenJDK fornece uma dessas (Eclipse OpenJ9), e outras estão disponíveis através de outros fornecedores. Embora todas essas plataformas devam passar em um teste de compatibilidade para poder usar o nome Java, essa compatibilidade nem sempre se estende aos tópicos discutidos neste livro. Isso é particularmente verdadeiro em relação às _flags_ de _tuning_. Todas as implementações de JVM têm um ou mais Garbage Collectors, mas as _flags_ para realizar o _tuning_ da implementação de GC de cada fornecedor são específicas do produto. Assim, enquanto os conceitos deste livro se aplicam a qualquer implementação Java, as _flags_ específicas e recomendações se aplicam apenas à HotSpot JVM.

Essa ressalva é aplicável a lançamentos anteriores da HotSpot JVM — as _flags_ e seus valores padrão mudam de lançamento para lançamento. As _flags_ discutidas aqui são válidas para o Java 8 (especificamente, versão 222) e 11 (especificamente, 11.0.5). Lançamentos posteriores podem alterar ligeiramente algumas dessas informações. Sempre consulte as notas de lançamento para mudanças importantes.

No nível da API, diferentes implementações de JVM são muito mais compatíveis, embora, mesmo assim, diferenças sutis possam existir entre a maneira como uma classe específica é implementada na plataforma Oracle HotSpot Java e em uma plataforma alternativa. As classes devem ser funcionalmente equivalentes, mas a implementação real pode mudar. Felizmente, isso é infrequente e improvável de afetar drasticamente a performance.

Para o restante deste livro, os termos Java e JVM devem ser entendidos como referindo-se especificamente à implementação Oracle HotSpot. Rigorosamente falando, dizer "A JVM não compila o código na primeira execução" está incorreto; algumas implementações Java de fato compilam o código na primeira vez em que ele é executado. Mas essa forma abreviada é muito mais fácil do que continuar a escrever (e ler): "A Oracle HotSpot JVM...".

**JVM tuning flags**
Com poucas exceções, a JVM aceita dois tipos de flags: flags booleanas e flags que exigem um parâmetro.

Flags booleanas usam esta sintaxe: -XX:+FlagName habilita a flag e -XX: -FlagName desabilita a flag.

 Flags que exigem um parâmetro usam esta sintaxe: -XX:FlagName=algo, significando definir o valor da FlagName para algo. No texto, o valor da flag geralmente é renderizado com algo indicando um valor arbitrário. Por exemplo, -XX:NewRatio=N significa que a flag NewRatio pode ser definida com um valor arbitrário N (onde as implicações de N são o foco da discussão).

O valor padrão de cada flag é discutido à medida que a flag é introduzida. Esse padrão é frequentemente baseado em uma combinação de fatores: a plataforma na qual a JVM está rodando e outros argumentos de linha de comando para a JVM. Em caso de dúvida, "Informações Básicas da VM"na página 60 mostra como usar a flag -XX:+PrintFlagsFinal (por padrão, false) para determinar o valor padrão para uma flag particular em um ambiente particular, dada uma linha de comando particular. O processo de <span style="background:#d3f8b6">ajustar flags automaticamente</span> com base no ambiente é chamado de ergonomia.

A JVM que é baixada dos sites da Oracle e AdoptOpenJDK é chamada de _product build_ (build de produto) da JVM. Quando a JVM é construída a partir do código-fonte, muitos builds podem ser produzidos: *debug buildes* (builds de depuração), *developers builds* (builds de desenvolvedor), e assim por diante. Esses builds frequentemente têm funcionalidades adicionais. Em particular, builds de desenvolvedor incluem um conjunto ainda maior de flags de *tuning* para que os desenvolvedores possam experimentar com as operações mais minuciosas de vários algoritmos usados pela JVM. Essas flags geralmente não são consideradas neste livro.

1. **Poder da Ergonomia da JVM:** o conceito de "ergonomia" mencionado no texto é o coração da JVM moderna. Quando a JVM inicializa, ela não carrega simplesmente uma lista de configurações estáticas; ela "lê" o ambiente (memória física, número de processadores virtuais disponíveis) e ajusta dinamicamente componentes vitais. Por exemplo, o número de *threads* do Garbage Collector, o tamanho inicial do heap e o tamanho do pool padrão do ForkJoinPool (usado por Parallel Streams) são decididos pela ergonomia.

**Plataformas de Hardware**
Quando a primeira edição deste livro foi publicada, o cenário de hardware parecia diferente do que é hoje. Máquinas _multicore_ eram populares, mas plataformas de 32 bits e plataformas de uma única CPU ainda eram muito usadas. Outras plataformas em uso hoje — máquinas virtuais e _containers_ de software — estavam começando a se consolidar. Aqui está uma visão geral de como essas plataformas afetam os tópicos deste livro.

**Hardware multicore**
Virtualmente todas as máquinas hoje têm múltiplos núcleos de execução, que aparecem para a JVM (e para qualquer outro programa) como múltiplas CPUs. Tipicamente, cada núcleo é habilitado para _hyper-threading_. _Hyper-threading_ é o termo que a Intel prefere, embora a AMD (e outras) usem o termo _simultaneous multithreading_, e alguns fabricantes de chips se refiram a _hardware strands_ dentro de um núcleo. Todos esses são a mesma coisa, e nos referiremos a essa tecnologia como _hyper-threading_.

De uma perspectiva de performance, a coisa importante sobre uma máquina é o seu número de núcleos. Vamos pegar uma máquina básica de quatro núcleos: cada núcleo pode (em grande parte) processar independentemente dos outros, então uma máquina com quatro núcleos pode alcançar quatro vezes o *throughput* de uma máquina com um único núcleo. (Isso depende de outros fatores sobre o software, é claro).

Na maioria dos casos, cada núcleo conterá duas *threads* de hardware ou *hyper-threads*. Essas *threads* não são independentes uma das outras: o núcleo pode executar apenas uma delas por vez. Frequentemente, a *thread* irá travar (stall): ela precisará, por exemplo, carregar um valor da memória principal, e esse processo pode levar alguns ciclos. Em um núcleo com uma única thread, a thread trava nesse ponto, e esses ciclos de CPU são desperdiçados. Em um núcleo com duas threads, o núcleo pode alternar e executar instruções da outra *thread*.

Então, nossa máquina de quatro núcleos com *hyper-threading* habilitado parece que pode executar instruções de oito *threads* de uma vez (mesmo que, tecnicamente, ela possa executar apenas quatro instruções por ciclo de CPU). Para o sistema operacional, e, portanto, para o Java e outras aplicações, a máquina parece ter oito CPUs. Mas todas essas CPUs não são iguais de uma perspectiva de performance. Se rodarmos uma tarefa CPU-bound usará um segundo núcleo; e assim por diante até quatro: podemos rodar quatro tarefas CPU-bound independentes e obter nosso aumento de quatro vezes no *throughput*.

Se adicionarmos uma quinta tarefa, ela será capaz de rodar apenas quando uma das outras tarefas travar, o que em média acaba acontecendo entre 20% e 40% do tempo. Cada tarefa adicional enfrenta o mesmo desafio. Portanto, adicionar uma quinta tarefa adiciona apenas cerca de 30% a mais de performance; no final, as oitos CPUs nos darão cerca de cinco a seis vezes a performance de um único núcleo (sem *hyper-threading*).

Você verá este exemplo em algumas seções. O _Garbage Collection_ é uma tarefa muito _CPU-bound_, então o Capítulo 5 mostra como o _hyper-threading_ afeta a paralelização de algoritmos de _garbage collection_. O Capítulo 9 discute em geral como explorar os recursos de _threading_ do Java para obter o melhor efeito, então você verá um exemplo da escalabilidade de núcleos _hyper-threaded_ lá também.

1. **A Ilusão de `Runtime.getRuntime().availableProcessors()`:** O texto levanta um ponto vital sobre a diferença entre núcleos físicos e lógicos (vCPUs). O sistema operacional e a JVM veem as *hyper-threads* como CPUs reais. Quando a JVM inicializa, ela usa o número de processadores lógicos para dimensionar internamente estruturas cruciais, como o número de *threads* do *Garbage Collector*, o tamanho padrão do *ForkJoinPool* (usado em **Parallel Streams**) e os thread pools do compilador JIT (C1/C2). Se temos 4 núcleos físicos e 8 lógicos, a JVM otimizará tudo assumindo que tem 8 unidades de execução dedicadas, o que pode levar a um leve excesso de concorrência para cargas de trabalho puramente matemáticas ou intensivas em memória cache.
2. **Hyper-threading é excelente para I/O, medíocre para processamento pesado:** Como explicado, o _hyper-threading_ brilha quando a CPU sofre de _stalls_ (esperando a memória RAM ou cache L3). Em aplicações web típicas (Spring Boot, APIs REST, chamadas de banco de dados), as _threads_ passam muito tempo esperando pacotes de rede ou carregando grandes _arrays_ da memória. Nesses cenários, o ganho de *throughput* é imenso. Por outro lado, para algoritmos intensivos de CPU (criptografia intensa, *hashings*, ou processamento de imagens/vídeos), as *hyper-threads* competem pelos mesmos registradores físicos e ALUs (Unidades Lógicas Aritméticas) do núcleo, derrubando o desempenho relativo e aumentando a *latency* devido ao esvaziamento das pipelines da CPU (*cache trashing*).
3. **O GC Paralelo e a CPU:** Coletar lixo é uma atividade puramente ligada à CPU e à varredura de memória. O aviso do autor é fundamental: dimensionar o número de _threads_ de um coletor de lixo (como o _Parallel GC_ ou as fases concorrentes do G1GC) para um número maior do que os núcleos **físicos** reais raramente reduz o tempo de pausa (_Stop-The-World_) na mesma proporção geométrica, devido ao gargalo de hardware no nível do núcleo.

**A "Maldição" do Sucesso da JVM (Confiança Cega)**
A engenharia por trás do Java moderno é tão espetacular que ela se tornou vítima do próprio sucesso.
- O compilador JIT (C1/C2) otimiza códigos incrivelmente mal escritos em tempo de execução (fazendo *inlining*, removendo alocações inúteis via *Escape Analysis*).
- O G1GC moderno limpa montanhas de lixo (alto *allocation rate*) sem derrubar a aplicação na maioria das vezes.
- **O Resultado:** para 80% das aplicações CRUD corporativas com tráfego baixo ou moderado, a JVM "mascara" o código ruim. O desenvolvedor escreve um algoritmo ineficiente, gera milhares de objetos desnecessários, mas o servidor aguenta porque a JVM faz milagres nos bastidores. O problema é que, quando o sistema escala e cai nos 20% de alta performance (*high throughput* e baixa *latency*), a "mágica" quebra, o *Garbage Collector* entra em colapso (Stop-The-World excessivo), e o time não faz ideia de como diagnosticar.

#Profilling, é um termo muito utilizado para a análise de aplicações. O *profilling* é usado para descrever o processo de medição do **tempo de execução** de métodos, para que assim possamos localizar e corrigir gargalos de desempenho. No contexto do Java esse termo é expandido ainda mais o que inclui a coleta de várias métricas e permite a depuração de *threads* e objetos em tempo de execução.

Existem diversas razões para utilizarmos os *profillers* nas aplicações Java, entre eles, para investigarmos o uso do *heap* e a frequência que está ocorrendo a coleta de lixo, pesquisar a alocação de objetos e referências para encontrar e corrigir vazamentos de memória, investigar a alocação e a sincronização de threads para encontrar problemas de bloqueio e de concorrência no acesso a dados, identificar métodos custosos, ou investigar uma aplicação em tempo de execução para que possamos entender a sua estrutura.

O *profilling* ocorre normalmente após a fase de desenvolvimento e os principais objetivos da sua utilização é melhorar o desempenho das aplicações, corrigir bugs de difícil localização e entender o que está acontecendo em nossa aplicação enquanto ela executa.

**Profilers**
Existem três *profilers* muito utilizados em Java e considerados os melhores pela comunidade, são eles: *JProbe SUite (Quest Software)*, *OptimizedIt Suite (Borland)* e *JProfiler (Ej-Technologies)*.

Todos os três são considerados muitos bons, porém o JProfiler tem como vantagem integrar todas as funcionalidades em um único aplicativo, ao invés de possuir ferramentas separadas para *profilling*, depuração de memória e depuração de *threads*. 

**JProbe**
O JProbe Memory Debugger ajuda o desenvolvedor a eliminar vazamenos de memória, reduzir o excesso de coleta de lixo e identificar objetos que estão segurando referências à outros objetos no heap. O JProbe Threadalyzer é uma ferramenta poderosa para detecção de problemas com threads, deadlocks, race conditions, entre outros. 

Equipe de garantia da qualidade podem utilizar o JProfiler como uma ferramenta para QA. A ferramenta oferece suporte a operações em linha de comando através de tarefas do ant permitindo exportar informações ou criar comparações

**Investigando Heap e Coleta de Lixo**
O *garbage Collector* é um recurso fornecido pela plataforma Java que elimina a necessidade do desenvolvedor de liberar explicitamente objetos da memória. Porém, o custo disso é o overhead de desempenho quando a coleta de lixo é executada. 

Usando o Jprobe ou qualquer um dos outros profilers temos acesso a um gráfico resumido do *heap* para uma aplicação em execução. Com isso, podemos monitorar o tamanho total da memória alocada e da memória livre disponível.

Quando a quantidade de heap utilizada diminui é porque tivemos uma coleta de lixo realizada, ou seja, são procurados os objetos na memória que não são mais usados no programa e excluídos da memória, liberando assim mais espaço. Podemos verificar que criar muitos objetos novos pode resultar em operações complexas e demoradas em que a JVM gastará tempo do processador no gerenciamento de memória, ao invés de realizar operações que constituem a lógica de negócio. O problema pode se agravar quando a JVM tem pouca memória livre, assim sendo o coletor de lixo precisa ser executado mais frequentemente para que mais memória esteja disponível. Podemos melhorar o desempenho da aplicação aumentando o tamanho do *heap*. Como exemplo, podemos executar uma aplicação e experimentar tamanho de 5MB e 16MB para o heap e comprar a frequência de execução do coletor de lixo. <span style="background:#d3f8b6">No entanto, isso não significa que pode haver uma melhora no desempenho, visto que, por vezes executar vários ciclos de coleta de lixo pode ser quase tão rápido quando executar apenas um ciclo, mas teríamos que iterar por mais objetos. </span> Por isso é interessante experimentarmos valores para tamanhos inicias e máximos do heap para uma aplicação específica, o teste é a única forma de validarmos confiavelmente a melhor configuração.

**Encontrando E Corrigindo Vazamentos de Memória**
A maioria das aplicações em Java possuem problemas com **vazamento de memória**. Um vazamento de memória é quando a memória alocada não é liberada de volta ao *pool*. O *Garbage Collector* libera a memória mantida por objetos inacessíveis, porém se houver uma referência a um objeto, este objeto não estará elegível para coleta de lixo mesmo que nunca mais seja utilizado. Um exemplo disso é um objeto colocado em um *array*, se esse elemento nunca for removido ele permanecerá na memória. Se esses objetos permanecerem por muito tempo na memória eles podem consumir toda a memória e causar uma exceção *OutOfMemory*. Outro problema são objetos persistentes (<span style="background:#fff88f">conexão com banco de dados ou arquivos temporários</span>). Também quanto mais tempo os objetos permanecem na memória, mais custosa será a coleta de lixo, pois tem mais objetos a serem percorridos. Dessa forma, os *profilers* fornecem uma alternativa melhor de localizar esses objetos persistentes e identificar os objetos que estão dificultando a coleta de lixo. Com isso, podemos realizar uma pesquisa mais direcionada dentro do sistema para verificar o que está causando esse vazamento de memória.

**Overhead de desempenho** significa: o Garbage Collector ajuda a gente a não liberar memória manualmente, mas ele **cobra um custo** para fazer esse trabalho:
Esse custo pode aparecer como:
- mais uso de cpu
- pequenas pausas na aplicação
- aumento de latência
- queda temporária de desempenho

Exemplo simples:
```java
for (int i = 0; i < 1_000_000; i++) {
	new Pedido();
}
```
Esse código cria muitos objetos. Depois, o GC precisa identificar quais não são mais usados e limpar a memória.

Enquanto ele faz isso, a aplicação pode ficar um pouco mais lenta.

Então a ideia é:
> O GC evita que limpemos a memória manualmente, mas ele gasta processamento para descobrir o que pode ser removido e liberar essa memória.

**Contêineres de software**
A maior mudança nas implantações Java no últimos anos é que elas agora são frequentemente implantadas dentro de um contêiner de software. Essa mudança não se limita ao Java, é claro; é uma tendência da indústria acelerada pela mudança para a computação em nuvem.

Dois contêineres aqui são importantes. O primeiro é a máquina virtual, que configura uma cópia completamente isolada do sistema operacional em um subconjunto do hardware no qual a máquina virtual está sendo executada. Esta é a base da computação em nuvem: seu fornecedor de computação em nuvem tem um data center com máquinas muito grandes. Essas máquinas têm potencialmente 128 núcleos, embora sejam provavelmente menores devidos a eficiências de custo. Da perspectiva da máquina virtual, isso não importa realmente: a máquina virtual recebe acesso a um subconjunto desse hardware. Portanto, uma dada máquina virtual pode ter dois núcleos (e quatro CPUs, já que eles geralmente são _hyper-threaded_) e 16 GB de memória.


Da perspectiva do Java (e da perspectiva de outras aplicações), essa máquina virtual é indistinguível de uma máquina regular com dois núcleos e 16 GB de memória. Para fins de _tuning_ e performance, você só precisa considerá-la da mesma maneira.

O segundo contêiner digno de nota é o contêiner Docker. Um processo Java rodando dentro de um contêiner Docker não sabe necessariamente que está em tal contêiner (embora pudesse descobrir isso por inspeção), mas o contêiner Docker é apenas um processo (potencialmente com restrições de recursos) dentro de um SO em execução. Como tal, seu isolamento do uso de CPU e memória de outros processos é um pouco diferente. Como você verá, a maneira como o Java lida com isso difere entre as versões iniciais do Java 8 (até o update 192) e versões posteriores do Java 8 (e todas as versões do Java 11).

**Superalocação (*Oversubscription)* de máquina Virtual**
Os fornecedores de nuvem têm a opção de superalocar as máquinas virtuais em uma caixa física. Digamos que a caixa física tenha 32 núcleos; o fornecedor de nuvem geralmente escolherá implantar oito máquinas virtuais de 4 núcleos nessa caixa para que cada máquina virtual tenha os quatro núcleos dedicados que espera.

Para economizar dinheiro, o fornecedor poderia escolher implantar 16 máquinas virtuais de 4 núcleos. A teoria aqui é que é improvável que todas as 16 máquinas virtuais estejam ocupadas ao mesmo tempo; contanto que apenas metade delas esteja ocupada, haverá núcleos físicos suficientes para satisfazê-las. Se muitas delas estiverem ocupadas, no entanto, elas competirão por ciclos de CPU, e sua performance sofrerá.

Da mesma forma, os fornecedores de nuvem podem escolher limitar (_throttle_) a CPU usada por uma máquina virtual: eles podem permitir que a máquina virtual execute picos (_bursts_) durante os quais consome a CPU que lhe é alocada, mas não mantenha esse uso ao longo do tempo. Isso é frequentemente visto em ofertas gratuitas ou de teste, onde você tem uma expectativa diferente de performance.

Essas coisas obviamente afetam muito a performance, mas o efeito não se limita ao Java, nem impacta o Java de forma diferente de qualquer outra coisa rodando na máquina virtual.

Por padrão, um contêiner Docker é livre para usar todos os recursos da máquina: ele pode usar todas as CPUs disponíveis e toda a memória disponível na máquina. Isso é bom se quisermos usar o Docker meramente para simplificar a implantação de nossa única aplicação na máquina (e, portanto, a máquina executará apenas aquele contêiner Docker). Mas, frequentemente, queremos implantar múltiplos contêineres Docker em uma máquina e restringir os recursos de cada contêiner. Na prática, dada a nossa máquina de quatro núcleos com 16 GB de memória, podemos querer rodar dois contêineres Docker, cada um com acesso a apenas dois núcleos e 8 GB de memória.

Configurar o Docker para fazer isso é simples o suficiente, mas complicações podem surgir no nível do Java. Numerosos recursos do Java são configurados automaticamente (ou ergonomicamente) com base no tamanho da máquina que está executando a JVM. Isso inclui o tamanho padrão do _heap_ e o número de _threads_ usadas pelo _garbage collector_, explicados em detalhes no Capítulo 5, e algumas configurações de _thread pool_, mencionadas no Capítulo 9.

Se você estiver executando uma versão recente do Java 8 (versão de atualização 192 ou posterior) ou Java 11, a JVM lida com isso como você esperaria: se você limitar o contêiner Docker para usar apenas dois núcleos, os valores definidos ergonomicamente com base na contagem de CPU da máquina serão baseados no limite do contêiner Docker. Da mesma forma, o _heap_ e outras configurações que, por padrão, são baseadas na quantidade de memória de uma máquina serão baseados em qualquer limite de memória dado ao contêiner Docker.

Em versões anteriores do Java 8, a JVM não tem conhecimento de quaisquer limites que o contêiner irá impor: quando ela inspeciona o ambiente para descobrir quanta memória está disponível para que possa calcular o tamanho padrão do seu _heap_, ela verá toda a memória da máquina (em vez de, como preferiríamos, a quantidade de memória que o contêiner Docker tem permissão para usar). Da mesma forma, quando ela verifica quantas CPUs estão disponíveis para fazer o _tuning_ do _garbage collector_, ela verá todas as CPUs da máquina, em vez do número de CPUs atribuídas ao contêiner Docker. Como resultado, a JVM rodará de forma subótima: ela iniciará _threads_ demais e configurará um _heap_ grande demais. Ter _threads_ demais levará a alguma degradação de performance, mas o verdadeiro problema aqui é a memória: o tamanho máximo do _heap_ será potencialmente maior do que a memória atribuída ao contêiner Docker. Quando o _heap_ crescer até esse tamanho, o contêiner Docker (e, consequentemente, a JVM) será morto.

Em versões iniciais do Java 8, você pode definir os valores apropriados para o uso de memória e CPU manualmente. À medida que encontrarmos esses ajustes, apontarei aqueles que precisarão ser ajustados para esta situação, mas é melhor simplesmente atualizar para uma versão posterior do Java 8 (ou Java 11).

Contêineres Docker apresentam um desafio adicional para o Java: o Java vem com um conjunto rico de ferramentas para diagnosticar problemas de performance. Estas muitas vezes não estão disponíveis em um contêiner Docker. Veremos esse problema um pouco mais no Capítulo 3.

## A História Completa da Performance
Este livro é focado em como usar da melhor forma a JVM e as APIs da plataforma Java para que os programas rodem mais rápido, mas muitas influências externas afetam a performance. Essas influências surgem de tempos em tempos na discussão, mas por não serem específicas do Java, elas não são necessariamente discutidas em detalhes. A performance da JVM e da plataforma Java é uma pequena parte de alcançar uma performance rápida.

Esta seção introduz as influências externas que são pelo menos tão importantes quanto os tópicos de *tuning* do Java cobertos neste livro. A abordagem baseada em conhecimento Java deste livro complementa essas influências, mas muitas delas estão além do escopo do que discutiremos.

### Escreve Algoritmos Melhores
Muitos detalhes sobre o Java afetam a performance de uma aplicação, e muitas *flags* de tuning são discutidas. Mas não existe uma opção mágica *-XX:+RunReallyFast*.

Em última análise, a performance de uma aplicação é baseada em quão bem ela é escrita. Se o programa faz um loop por todos os elementos de um array, a JVM otimizará a maneira como ela realiza a verificação de limites (bounds checking) do array para que o loop rode mais rápido, e ela pode desenrolar (unroll) as operações do loop para fornecer um ganho de velocidade adicional. Mas se o propósito do loop é encontrar um item específico, nenhuma otimização no mundo fará o código baseado em *array* ser tão rápido quanto uma versão diferente que usa um *hash map*.

Um bom algoritmo é a coisa mais importante quando se trata de performance rápida.

### Escreva Menos Código
Alguns de nós escrevem programas por dinheiro, alguns por diversão, alguns para retribuir a uma comunidade, mas todos nós escrevemos programas (ou trabalhamos em times que escrevem programas). É difícil sentir que você está fazendo uma contribuição para um projeto podando código, e alguns gerentes ainda avaliam desenvolvedores pela quantidade de código que eles escrevem.

Eu entendo isso, mas o conflito aqui é que um programa pequeno e bem escrito rodará mais rápido do que um programa grande e bem escrito. Isso é geralmente verdade para todos os programas de computador, e se aplica especificamente a programas Java. Quanto mais código tiver que ser compilado, mais tempo levará até que esse código rode rapidamente. Quanto mais objetos tiverem que ser alocados e descartados, mais trabalho o _garbage collector_ terá que fazer. Quanto mais objetos forem alocados e retidos, mais tempo um ciclo de GC levará. Quanto mais classes tiverem que ser carregadas do disco para a JVM, mais tempo levará para um programa iniciar. Quanto mais código for executado, menos provável que ele caiba nos caches de hardware da máquina. E quanto mais código tiver que ser executado, mais longa será essa execução.

Eu penso nisso como o princípio da "morte por 1.000 cortes". Desenvolvedores argumentarão que estão apenas adicionando uma funcionalidade muito pequena e que isso não levará tempo nenhum (especialmente se a funcionalidade não for usada). E então outros desenvolvedores no mesmo projeto fazem a mesma afirmação, e de repente a performance regrediu alguns por cento. O ciclo se repete no próximo _release_, e agora a performance do programa regrediu 10%. Algumas vezes durante o processo, os testes de performance podem atingir um certo limite de recursos — um ponto crítico no uso de memória, um estouro do _code cache_ ou algo parecido. Nesses casos, testes de performance regulares pegarão essa condição em particular, e o time de performance pode consertar o que parece ser uma grande regressão. Mas com o tempo, à medida que as pequenas regressões se infiltram, será cada vez mais difícil consertá-las.

- **A Confusão entre "Menos Código Fonte" e "Menos Código Executado":** A afirmação de "escrever menos código" hoje é perigosamente mal interpretada. Desenvolvedores juniores e plenos frequentemente usam abstrações pesadas (como AOP, dezenas de anotações "mágicas", ou _frameworks_ de mapeamento dinâmico via reflexão) para reduzir a _quantidade de linhas no arquivo .java_. O perigo: uma anotação que esconde o código no fonte frequentemente gera milhares de linhas de _bytecode_ gerado dinamicamente via CGLIB ou ByteBuddy. Isso **aumenta** o tempo de inicialização (_warm-up_), incha o _Metaspace_ e prejudica o JIT. O foco deve ser escrever menos **código em tempo de execução**, favorecendo a simplicidade e clareza, não apenas menos linhas no editor.

- **A Cultura do Monólito vs Microserviços (Dependências Obesas):** No passado, "escrever menos código" era sobre o que o desenvolvedor digitava. Hoje, em ambientes de _Cloud_ e _Containers_ rodando Spring Boot, o maior inchaço de código não vem do seu time, vem do seu arquivo `pom.xml` ou `build.gradle`. Importar uma biblioteca inteira do AWS SDK só para usar uma classe utilitária de criptografia carrega centenas de classes para o _ClassLoader_. Em containers com restrição de CPU (ex: Kubernetes com limites agressivos), isso destrói o tempo de inicialização (causando falhas na _Liveness Probe_) e incha a memória base da JVM. "Escrever menos código" hoje se traduz em "Audite rigorosamente suas dependências".

### Nós em última Análise Perderemos A Guerra
Um aspecto da performance que pode ser contraintuitivo (e deprimente) é que se pode esperar que a performance de toda aplicação diminua com o tempo — ou seja, ao longo de novos ciclos de lançamento da aplicação. Frequentemente, essa diferença de performance não é notada, porque as melhorias de hardware tornam possível executar os novos programas a velocidades aceitáveis.

Pense como seria executar a interface do Windows 10 no mesmo computador que costumava rodar o Windows 95. Meu computador favorito de todos os tempos foi um Mac Quadra 950, mas ele não conseguiria rodar o macOS Sierra (e se rodasse, seria muito, muito lento em comparação com o Mac OS 7.5). Em uma escala menor, pode parecer que o Firefox 69.0 é mais rápido do que versões anteriores, mas essas são essencialmente versões de lançamentos menores. Com sua navegação por abas, rolagem sincronizada e recursos de segurança, o Firefox é muito mais poderoso do que o Mosaic jamais foi, mas o Mosaic consegue carregar arquivos HTML básicos localizados no meu disco rígido cerca de 50% mais rápido do que o Firefox 69.0.

Claro, o Mosaic não consegue carregar URLs reais de quase nenhum site popular; não é mais possível usar o Mosaic como um navegador principal. Isso também é parte do ponto geral aqui: particularmente entre lançamentos menores, o código pode ser otimizado e rodar mais rápido. Como engenheiros de performance, é nisso que podemos focar, e se formos bons no nosso trabalho, podemos vencer a batalha.

Isso é uma coisa boa e valiosa; meu argumento não é que não devamos trabalhar para melhorar a performance de aplicações existentes. Mas a ironia permanece: à medida que novos recursos são adicionados e novos padrões adotados — o que é um requisito para se igualar a programas concorrentes — pode-se esperar que os programas fiquem maiores e mais lentos.

Eu não estou defendendo que você nunca deva adicionar um novo recurso ou novo código ao seu produto; claramente há benefícios resultantes de aprimorar programas. <span style="background:#fff88f">Mas esteja ciente dos _trade-offs_ que você está fazendo e, quando puder, simplifique</span>.


---
## Stop The World
Exatamente! O termo **"Stop-the-World"** (parar o mundo) refere-se a um comportamento fundamental de muitos coletores de lixo (Garbage Collectors - GC) na JVM. Aqui está o que acontece exatamente nesse intervalo (6:17 - 7:22):

* **A Necessidade da Pausa:** Para que o coletor de lixo possa limpar a memória com segurança e precisão, ele precisa de um "estado estável". Se a aplicação continuasse criando ou movendo objetos enquanto o GC está tentando identificar o que é "lixo", ele poderia deletar acidentalmente um objeto que acabou de ser referenciado.
* **O Processo:**
    1. **Sinal de parada:** O coletor envia um sinal para todas as threads da aplicação.
    2. **Safe Point:** As threads da aplicação precisam atingir um ponto específico de execução (chamado de *JVM Safe Point*) onde é seguro parar.
    3. **Execução do GC:** Uma vez que todas as threads param, o coletor de lixo executa suas tarefas (limpeza, compactação, etc.) sem interferência externa.
    4. **Retomada:** Assim que o trabalho é concluído, o coletor libera as threads da aplicação para continuarem rodando.

**Por que isso era um grande problema?**
No passado, essa pausa poderia durar segundos, o que causava travamentos visíveis em aplicações interativas (como sistemas bancários ou jogos). O palestrante explica que a evolução da JVM focou muito em **minimizar esse tempo**, tornando as pausas cada vez menores, chegando a níveis de milissegundos ou quase imperceptíveis nos coletores mais modernos, como o **ZGC** (discutido posteriormente no vídeo).

**Otimização Extrema:** Coletores modernos como o **ZGC** (introduzido e aprimorado a partir do JDK 21) foram projetados para que a pausa não dependa mais do tamanho do _Heap_ (memória total). Isso significa que, mesmo com um _Heap_ de terabytes, a pausa permanece **abaixo de 1 milissegundo**. 

**Concorrência Real:** Em vez de parar tudo por muito tempo, esses coletores realizam a grande maioria do trabalho de marcação e compactação **concorrentemente** com as threads da aplicação. Ou seja, a aplicação continua processando dados enquanto o coletor trabalha.

**Coletores Estáticos e Dinâmicos**
No contexto de GArbage Collection (GC) na JVM, esses tempos geralmente se referem à estratégia de adaptação do coletor às mudanças na carga de trabalho da aplicação.

O que significa cada um:
- **Coletores "Estáticos" (ou tradicionais):** são aqueles cujas configurações e comportamento são mais rígidos. Eles seguem regras fixas (como pausas em momentos específicos) e não tentam ajustar sua agressividade ou ritmo baseando-se em quão rápido a aplicação está consumindo memória no momento. 


- **Coletores "Dinâmicos" (ou adaptativos):** são coletores modernos, como o G1 e o ZGC, que monitoram o comportamento da aplicação em tempo real. Eles ajustam dinamicamente quando e quanto limpar a memória para tentar manter um objetivo (como uma pausa máxima definida pelo usuário, ex: 200ms ou menos). Eles "aprendem" o ritmo de alocação de objetos da nossa aplicação e se autoajustam. 
**Compacting Collector** (ou coletor de compactação) é uma estratégia de gerenciamento de memória focada em organizar o *heap* para otimizar futuras alocações. Ele se enquadra na categoria de **coletores móveis** (moving collectors).

Como ele funciona: após identificar quais objetos ainda estão vivo (Mark) e liberar o espaço dos objetos mortos (Sweep), o coletor **move fisicamente** os objetos ativos para um dos extremos da memória, deixando todo o espaço livre contíguo (unido) em um único bloco. 

Por que é importante?
1. **Alocação Rápida:** com a memória compactada, a JVM não precisa buscar por "buracos" entre objetos. Ela simplesmente usa uma técnica chamada *bump-the-pointer*: como todo o espaço livre está contíguo, basta mover um ponteiro para o final do último objeto alocado para reservar espaço para o próximo.
2. **Fim da Fragmentação:** evita que a aplicação sofra um erro de *OutOfMemoryError*, por falta de um espaço grande o suficiente, mesmo que a memória total disponível fosse, teoricamente, suficiente.

**Em resumo:**
- **Estático:** Segue um script fixo. É previsível, mas menos eficiente se a carga de trabalho variar muito.
- **Dinâmico:** Ajusta-se conforme a necessidade. É mais complexo, mas ideal para sistemas modernos que precisam manter a performance estável sob diferentes níveis de uso.

**Hipótese da Geração Fraca** é um princípio fundamental que justifica a forma como o *Garbage Collector* da JVM organiza a memória. 
- **A maioria dos objetos morrem jovem:** a vasta maioria dos objetos alocados em uma aplicação possui um ciclo de vida muito curto (por exemplo, variáveis locais criadas dentro de um método que deixam de ser referenciadas assim que o método termina).
- **Poucos objetos vivem muito:** apenas uma pequena parcela de objetos sobrevive por longos períodos de tempo (como objetos de configuração global ou chaces de longo prazo).

**Por que isso é importante para a JVM?**
Essa observação permitiu que os engenheiros criassem um sistema de memória **geracional**, dividindo o *heap* em áreas distinas:
- **Young Generation (Eden e Survivor Spaces)**: é uma área otimizada para alocar e limpar objetos recém-criados rapidamente. Como a maioria dedes morre logo, a coleta aqui é muito eficiente.
- **Old Generation (Tenured Space):** onde são promovidos apenas os objetos que sobreviveram a vários ciclos de coleta na *Young Generation*. Como essa área contém objetos que provavelmente viverão por muito tempo, a estratégia de coleta aqui é menos frequente e mais robusta.

Essa estratégia é o que torna o gerenciamento de memória automático no Java eficiente, pois evita que a JVM perca tempo varrendo constantemente objetos que provavelmente já não são mais necessários.

**Card Table** é uma estrutura de dados fundamental em coletores de lixo (GC) geracionais na JVM, como o *Parallel GC* e G1. Ela é utilizada para otimizar a identificação de referências entre objetos de diferentes gerações.

Como funciona:
- **O problema (Referência Intergeracional):** em sistemas geracionais, é comum que objetos na Old Generation (mais antiga) apontem para objetos na Young Generation (mais nova). Durante uma coleta menor (*Minor GC*), o coletor precisa encontrar todos esses objetos sobreviventes na Young Generation. Verificar todo o heap da Old Generation. Verificar todo o heap da Old Generation para encontrar essas referências seria extreamente custoso e lento. 
- **A Estrutura:** A _Card Table_ é um mapa de bits ou um array de bytes onde cada entrada (ou "cartão") representa um pequeno bloco de memória do _heap_ da _Old Generation_ (geralmente 512 bytes).