## 🚗 **Plano de Estudos: Sistemas Embarcados Automotivos (24 meses)**

🎯 **Objetivo**: Tornar-se desenvolvedor automotivo com foco em ECUs, sistemas embarcados, multimídia e veículos autônomos.

---

### 🧭 Estrutura geral:

|Fase|Duração|Objetivo Principal|
|---|---|---|
|Fundamentos em Hardware + Eletrônica|2 meses|Compreender microcontroladores, circuitos e sinais|
|Programação Baixo Nível (C/C++) + RTOS|4 meses|Aprender a programar microcontroladores com controle total|
|Comunicação Veicular (CAN, LIN, FlexRay)|2 meses|Dominar redes automotivas|
|AUTOSAR + Sistemas Críticos|3 meses|Padrão da indústria automotiva|
|Sistemas Multimídia (Android Automotive)|3 meses|Construção de interfaces e middleware automotivo|
|Veículos Autônomos + IA embarcada|5 meses|Sensoriamento, controle, percepção, simulações|
|Integração com Java/Cloud/IoT|3 meses|Criar sistemas conectados entre embarcado e serviços|
|Portfólio + Preparação para Mercado|2 meses|Projetos finais, GitHub, currículo, certificações|

---

## 📅 **Plano Mensal (24 meses detalhado)**

### 🔧 **Ano 1 — Fundamentos, Baixo Nível e Redes**

#### **Mês 1-2: Eletrônica e Sistemas Embarcados**

- Conceitos de corrente, tensão, resistores, capacitores, transistores
    
- Microcontroladores vs. microprocessadores
    
- Arduino UNO, ESP32, Raspberry Pi (introdução)
    
- Ferramentas: multímetro, breadboard, datasheets
    

📘 Fontes:

- Livro: _Make: Electronics_ – Charles Platt
    
- Curso: [Curso de Arduino e Eletrônica Básica – Udemy](https://www.udemy.com/course/arduino-essencial/)
    
- Canal YouTube: WR Kits, Brincando com Ideias
    

🎯 Projeto: sensor de temperatura + controle de LED com PWM + monitor serial

---

#### **Mês 3-6: C/C++ + RTOS + Microcontroladores**

- Linguagem C: ponteiros, structs, interrupções, manipulação de bits
    
- Drivers e periféricos: GPIO, I2C, SPI, ADC, PWM
    
- RTOS: FreeRTOS (task, semáforo, mutex, queue)
    
- Plataforma: STM32 ou ESP32
    

📘 Fontes:

- Livro: _The C Programming Language_ – Kernighan & Ritchie
    
- Curso: [Mastering Microcontroller with Embedded Driver Development (Udemy)](https://www.udemy.com/course/mastering-microcontroller-with-peripheral-driver-development/)
    
- Curso: FreeRTOS com ESP32 (YouTube/FreeRTOS.org)
    

🎯 Projeto: sistema multitarefa com FreeRTOS para controlar sensor + alarme

---

#### **Mês 7-8: Redes CAN, LIN, FlexRay**

- CAN Bus: frames, arbitration, bit stuffing
    
- LIN: comunicação mestre/escravo
    
- Ferramentas: módulo MCP2515 com Arduino ou ESP32
    
- Análise de pacotes CAN via software
    

📘 Fontes:

- Livro: _A Comprehensible Guide to CAN_ – Wilfried Voss
    
- Curso: [CAN Bus Hacking and Security – Udemy](https://www.udemy.com/course/can-bus-hacking-and-security/)
    
- Ferramenta: SocketCAN + Linux + Wireshark
    

🎯 Projeto: simular comunicação CAN entre dois microcontroladores com sensores

---

#### **Mês 9-11: AUTOSAR + Sistemas Reais**

- AUTOSAR Classic & Adaptive
    
- RTE, MCAL, SWC, BSW
    
- ISO 26262 (segurança funcional)
    
- Ferramentas: EB tresos, DaVinci Developer (demo)
    

📘 Fontes:

- Livro: _Automotive Embedded Systems Handbook_
    
- Curso: [AUTOSAR Adaptive Platform – Udemy](https://www.udemy.com/course/autosar-adaptive-platform/)
    
- Curso gratuito: [Vector eLearning](https://elearning.vector.com/)
    

🎯 Projeto: modelar um componente AUTOSAR e simular o comportamento em arquitetura de software

---

#### **Mês 12: Projeto Integrador (Ano 1)**

- Criar um projeto completo:
    
    - Microcontrolador com RTOS
        
    - Comunicação via CAN
        
    - Reação a eventos simulando ECU real (ex. ABS, airbag, sensores)
        

🎯 Objetivo: consolidar hardware + software embarcado + rede CAN

---

### 📺 **Ano 2 — Sistemas Multimídia, Autônomos e Integração**

#### **Mês 13-15: Android Automotive e Java Embarcado**

- Android para carros (UI, sensores, mídia)
    
- Java em embarcados (Java SE Embedded)
    
- Comunicação entre app e ECU via Bluetooth ou rede
    

📘 Fontes:

- Site: [developer.android.com/cars](https://developer.android.com/cars)
    
- Livro: _Professional Android_ – Reto Meier
    
- Curso: [Android Automotive OS Basics – YouTube/Android Dev](https://www.youtube.com/@androiddevelopers)
    

🎯 Projeto: App Android para leitura de sensores (velocidade, RPM, temperatura)

---

#### **Mês 16-20: Veículos Autônomos + IA embarcada**

- Percepção: câmera, LiDAR, radar, GPS
    
- Controle PID, SLAM, planejamento de rotas
    
- Ferramentas: CARLA Simulator, ROS, Python, OpenCV
    

📘 Fontes:

- Curso: [Self-Driving Car Engineer – Udacity](https://www.udacity.com/course/self-driving-car-engineer-nanodegree--nd013)
    
- Livro: _Programming Self-Driving Cars_ (MIT)
    
- Simulador: [CARLA](https://carla.org/)
    

🎯 Projeto: controle autônomo de veículo em simulação (desvio de obstáculos, seguir faixa)

---

#### **Mês 21-23: Integração IoT + Java + Nuvem**

- MQTT, HTTP, WebSocket
    
- Comunicação entre carro e servidor (telemática)
    
- Java para backend de dados do veículo (Spring Boot)
    
- Protocolo OBD-II, APIs REST para veículos
    

📘 Fontes:

- Curso: [IoT do Zero com ESP32 – YouTube](https://www.youtube.com/c/CFBCursos)
    
- Projeto: ESP32 envia dados do carro para API Java na nuvem (Heroku, AWS)
    

🎯 Projeto: sistema embarcado que reporta dados do veículo via MQTT para uma API Spring Boot

---

#### **Mês 24: Portfólio e Preparação para Mercado**

- Revisar todos os projetos e documentar no GitHub
    
- Criar um site com portfólio técnico (pode usar React ou HTML simples)
    
- Simular entrevistas técnicas, preparar currículo
    
- Buscar contatos via LinkedIn, fóruns, eventos da SAE Brasil, Meetups
    

🎯 Certificações (opcional):

- AUTOSAR (Vector/Elektrobit)
    
- Curso ROS, C++ Embarcado, Android Automotive
    

---

## 📁 Posso te entregar isso como:

- 📄 PDF bem formatado (com links clicáveis)
    
- ✅ Checklist interativo (Google Sheets ou Notion)
    
- 📆 Planner mensal com entregas e metas
    
- 💬 Grupo ou canal privado (Telegram ou Discord) para motivação
    

Quer que eu gere um planner em PDF agora? Ou prefere montar juntos no Notion?