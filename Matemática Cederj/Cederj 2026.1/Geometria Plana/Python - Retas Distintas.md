- Desenhar linhas;
- Capturar mouse (clicar e arrastar)
- Atualizar a tela em tempo real

**pygame**
Tem uma boa interação
Fácil para capturar o mouse
Controle total da tela

Vamos precisar de alguns objetos principais:
- Reta
- Lista de retas
- Lista de pontos de interseção
- Loop principal
- Eventos do mouse

## Como representar uma reta?
Evitarmos "reta infinita" na tela.
Use reta definida por dois pontos.

Ponto A = (x1, y1)
Ponto B = (x2, y2)

Com isso, a gente consegue:
- Desenhar a reta
- Calcular interseções
- Mover os pontos

Cada reta = **objeto ou dicionário*

Prefira guardar a reta como: 
- Dois pontos
- Equação ax + by + c = 0
## Interação com o mouse (fluxo)
1. Clique - cria um ponto inicial
2. Arrasta - define o segundo ponto
3. Solta - reta criada

## Estrutura básica do projeto
Pensemos no projeto como **camadas**, não como um script único:

retas_intersecoes/
│
├── main.py
│
├── core/
│   ├── __init__.py
│   ├── line.py
│   ├── intersection.py
│
├── ui/
│   ├── __init__.py
│   ├── canvas.py
│   ├── events.py
│
├── utils/
│   ├── __init__.py
│   ├── geometry.py
│
└── config.py

**Main:**
Inicia o programa
Cria o loop principal
Conecta tudo

**Core:**
Aqui fica o **modelo matemático** da aplicação:
line.py
- representa uma reta
- guarda seus pontos
- talvez métodos como "mover", "atualizar"

**intersection.py**
- recebe duas retas
- calcular se existe interseção
- retornar um ponto ou nada

**ui.py**
Tudo que envolve **tela e interseção**
*canvas.py*: responsável por desenhar retas, desenhar pontos e limpar a tela e atualizar frame.

**events.py**, responsável por:
- mouse down
- mouse move
- mouse up
- decidir se está criando ou arrastando uma reta

### 🔹 `utils/`

Funções genéricas que ajudam tudo.

#### `geometry.py`
Boas candidatas:
- distância entre pontos
- checar proximidade (click perto da reta?)
- tolerância numérica
    

Nada específico de UI nem de lógica principal


### `config.py`

Centraliza:
- tamanho da tela
- cores
- tolerâncias (ex: distância mínima entre pontos)
- FPS
    
 Evita “números mágicos” espalhados.