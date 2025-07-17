##  Objetivo

Construir e analisar modelos moleculares de proteínas virais do SABV (ex: NP e Z), aplicar docking molecular com compostos candidatos e métodos de química quântica (DFT) em regiões funcionais, com capacidade de propor mutações e mecanismos de ação.
## 📅 Pipeline de 7 Meses (Maio a Novembro de 2025)

---

### **📌 MÊS 1 – Fundamentos essenciais (Maio)**

**Objetivo:** Compreensão teórica de bioquímica estrutural, virologia do SABV e familiarização com ferramentas básicas.

- **Estudo teórico**
    
    - Biologia molecular de vírus da família Arenaviridae.
        
    - Papel das proteínas Z e NP no ciclo viral.
        
    - Revisar o artigo: "Structural and molecular biology of Sabiá virus".
        
    - Fundamentos de estrutura proteica (domínios, sítios ativos, hélices, folhas beta etc.).
        
- **Ferramentas**
    
    - Instalação e uso básico de:
        
        - **PyMOL** (visualização estrutural)
            
        - **UCSF Chimera / ChimeraX**
            
        - **NCBI / UniProt / PDB**
            
- **Entrega esperada:** fichamento dos artigos, mapa mental dos alvos e familiaridade com estruturas 3D.
    

---

### **📌 MÊS 2 – Modelagem estrutural (Junho)**

**Objetivo:** Obter ou modelar as estruturas 3D das proteínas de interesse (NP e Z do SABV).

- **Tarefas práticas**
    
    - Procurar estruturas experimentais (PDB, Cryo-EM).
        
    - Caso ausentes: **modelagem por homologia** com **Swiss-Model** ou **AlphaFold** (ColabFold).
        
    - Validação dos modelos com:
        
        - **MolProbity**, **Ramachandran plot**, **ProSA-web**
            
- **Estudo teórico**
    
    - Fundamentos de modelagem comparativa.
        
    - Domínio de FASTA, PDB, conceitos de identidade/similaridade.
        
- **Entrega esperada:** modelos confiáveis das proteínas alvo.
    

---

### **📌 MÊS 3 – Identificação de regiões funcionais e preparação (Julho)**

**Objetivo:** Delimitar regiões de interesse (ex: sítio de ligação de RNA na NP ou região de interação proteína-proteína).

- **Análises práticas**
    
    - Mapeamento de regiões conservadas com **Clustal Omega / Jalview**.
        
    - Análise de estruturas para identificar sítios catalíticos ou de interação.
        
    - Preparação de estruturas (remoção de água, correção de gaps).
        
- **Ferramentas**
    
    - **Consurf**, **InterPro**, **CASTp** (previsão de sítios ativos).
        
    - **ChimeraX** para seleção e extração de fragmentos.
        
- **Entrega esperada:** regiões definidas para estudo posterior (recortes para DFT e docking).
    

---

### **📌 MÊS 4 – Docking molecular e triagem virtual (Agosto)**

**Objetivo:** Simular a interação de ligantes com as regiões de interesse.

- **Ferramentas**
    
    - **AutoDock Vina**, **CB-Dock**, **PyRx**
        
    - Biblioteca de ligantes: **ZINC**, **PubChem**, ou banco próprio.
        
- **Procedimentos**
    
    - Preparação da proteína e ligantes (formatos PDBQT).
        
    - Rodar docking e interpretar ligações.
        
    - Refino com análise de ligações por **LigPlot+** ou **PLIP**.
        
- **Entrega esperada:** 5–10 compostos candidatos com maior afinidade.
    

---

### **📌 MÊS 5 – Química quântica (DFT em fragmentos) (Setembro)**

**Objetivo:** Estudar propriedades eletrônicas das regiões ativas via DFT.

- **Ferramentas**
    
    - **ORCA**, **Gaussian**, **Psi4**, ou **GAMESS** (versões locais ou cloud).
        
- **Procedimentos**
    
    - Recorte dos resíduos (10–20 ao redor do sítio).
        
    - Estudo com B3LYP/6-31G*, cálculo de HOMO/LUMO, MEP.
        
    - Análise do caráter nucleofílico/eletrofílico.
        
- **Estudo teórico**
    
    - Fundamentos de DFT, orbitais moleculares, potencial eletrostático.
        
- **Entrega esperada:** caracterização eletrônica de alvos e mapeamento de hotspots.
    

---

### **📌 MÊS 6 – Integração com dinâmica molecular e QM/MM (Outubro)**

**Objetivo:** Refino de interações mais promissoras e simulação em ambiente mais realista.

- **Ferramentas**
    
    - **GROMACS**, **Amber**, **CHARMM** (ou cloud-based: Google Colab + OpenMM)
        
    - **CP2K** ou QM/MM híbrido (opcional)
        
- **Procedimentos**
    
    - Simular estabilidade das interações proteína-ligante.
        
    - Refinar melhores poses de docking com solvatadas/dinâmica.
        
    - Aplicar QM/MM em regiões críticas.
        
- **Entrega esperada:** validação da ligação em ambiente dinâmico.
    

---

### **📌 MÊS 7 – Escrita científica e projeto de mestrado (Novembro)**

**Objetivo:** Consolidar os dados e elaborar um pré-projeto de pesquisa para submissão a programa de pós-graduação.

- **Tarefas**
    
    - Redação de artigo prévio ou pré-projeto.
        
    - Tabela comparativa dos ligantes e análises eletrônicas.
        
    - Justificativa para continuidade da linha de pesquisa.
        
- **Ferramentas**
    
    - **Zotero**, **Overleaf**, **Mendeley** para organização e formatação.
        
- **Entrega esperada:** versão final do projeto de pesquisa + apresentação dos resultados.
    

---

## 🔧 Infraestrutura necessária

- Notebook com ao menos 8 GB de RAM (ideal: 16 GB)
    
- Acesso à internet estável
    
- Conta no Google Colab, GitHub e ferramentas científicas gratuitas
    
- (Opcional) Acesso remoto a servidores de alto desempenho, se possível via orientador.
    

---

## 📚 Materiais de apoio (com links sob demanda)

- Curso básico de bioinformática estrutural (ex: EMBL-EBI, Coursera, edX)
    
- Tutoriais de AutoDock, PyMOL e ORCA
    
- Artigos e PDFs de revisão sobre DFT, docking e modelagem viral
    

---

Se quiser, posso montar também um **cronograma diário/semanal detalhado** com divisão de tarefas. Você gostaria disso?