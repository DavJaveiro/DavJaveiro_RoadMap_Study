┌──────────────┐        HTTP        ┌──────────────────┐
│  API Java    │ ───────────────▶  │  API Python       │
│  Spring Boot│                                          │ Scraper NFC-e  │
└──────────────┘                        └──────────────────┘

### Responsabilidades

#### Java (Spring Boot)
- API pública
- Validação da URL
- Autenticação (futuro)
- Rate limit
- Cache
- Observabilidade
- Orquestração

#### Python
- Scraping NFC-e. Java nunca executa Playwrigth
- Playwright
- Parsing
- Normalização
- Retorno JSON puro
Python nunca conhece HTTP externo do cliente.

## Comunicação entre Java e Python



## Ambiente Virtual Python
Criar um ambiente virtual (python -m venv venv) é uma prática essencial em desenvolvimento Python, especialmente se você quer seguir boas práticas como engenheiro de IA ou software.

Um ambiente virtual é uma instalação isolada do Python e de seus pacotes. *Independente* da instalação global do sistema.

Ele cria uma pasta (no nosso caso: venv/) com:
- Uma cópia do interpretador Python (leve)
- Um diretório *site-packages* próprio, onde os pacotes (*fastapi*, *playwright*, etc) serão instalados.
- Scripts de ativação/desativação

Portanto, isso, evita conflito entre versões de pacotes.
Se instalarmos tudo globalmente, um projeto **quebrará** o outro.
Com ambientes virtuais, cada projeto tem sua própria versão.

Sem um ambiente virtual, instalamos tudo no Python global, logo, teremos dezenas de pacotes não relacionados misturados: Django, TensorFlow, FastAPI, bibliotecas antigas... difícil de gerenciar.

Com #venv: só o que o projeto precisa.

**Reprodutibilidade garantida**
Quando compartilhamos o nosso projeto (ex: no GitHub), outra pessoa pode:
```bash
git clone app
cd app
python -m venv venv
venv/Scripts/activate # ou source venv/bin/activate
pip install -r requirements.txt
```

E terá exatamente o mesmo ambiente que nós.

Isso é crucial para deploy, CI/CD e trabalho em equipe.

**Segurança e estabilidade do sistema**
Alguns pacotes exigem permissões de administrador para instalar globlmente (sudo pip install). Isso pode corromper pacotes críticos do sistema .

#venv funciona **sem permissões elevadas**.

1. Criando ambiente virtual:
`python -m venv venv`
Isso vai criar uma pasta chamada *venv* em nosso projeto.

2. Ative o ambiente virtual
`venv\Scripts\activate`

Se funcionar, nosso prompt vai mudar para:
`(venv) PS C:\Users\davja\Desktop\nfce-scaper> `

3. Instale as dependências do projeto
Agora, com o ambiente ativado, podemos instalar tudo *requirements.txt*:
`pip install -r requirements.txt`

➡️ Isso instalará `fastapi`, `uvicorn`, `playwright`, `pydantic` **apenas dentro do ambiente virtual**, sem afetar o Python global.

4. Como usamos o Playwright
Precisamos instalar os navegadores também:
`playwright install chromium`

