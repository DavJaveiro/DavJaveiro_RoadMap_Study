## 1. Preparação e Sincronização
Sempre comece garantindo que o nosso código local é o mesmo que está no servidor (GitHub).
- **Volte para a branch principal:** git checkout main
- **Sincronize:** git pull origin main
- **Limpeza (Opcional):** se houver branches antigas já mescladas, delete-as: git branch -d 'nome-da-branch'.

## 2. Criando uma Branch de Correção (Fix)

Nunca trabalhe direto na *main*. Crie uma branch específica para a tarefa. 
- **Crie a branch:** git checkout -b fix/nome-da-correcao (ex: fix/paginacao-ebooks).

## 3. Desenvolvimento e Ambiente Local
Com a branch criada, suba os serviços necessários para testar sua alteração. 
- **Suba o Backend:** php artisan serve
- **Suba o Frontend:** npm run dev
- **Processamento de Filas/Milisearch:** php artisan horizon
	- Nota: se houver erro de conexão com o Meilisearch na porta 7700, verifique que o serviço está rodando ou desative o Scout no .env.

## 4. Qualidade e Validação de Código 
Ante de enviar, use as ferramentas que já estão no nosso projeto para garantir que o Roberto não precise pedir correções bobas.
- **Formatação Automática:** ./vendor/bin/pint.
- **Análise Estática:** `./vendor/bin/phpstan analyse --memory-limit=1G`.
- **Testes de Interface:** `npx playwright test`.

### 5. Committing (O Momento do Husky)
Ao realizar o commit, o seu **Husky** e o **lint-staged** entrarão em ação.
- **Adicione as mudanças:** `git add .`
- **Commit:** `git commit -m "fix: resolve erro non-numeric em apiEbooksByCategoria"`.
    > Se o `lint-staged` encontrar erros de formatação ou de lógica (PHPStan), o commit será interrompido para você corrigir.
    

### 6. Publicação e Pull Request (PR)
- **Envie para o GitHub:** `git push origin fix/nome-da-correcao`.
- **Abra o PR:** Vá ao GitHub e clique em "Compare & pull request".
- **Revisão da IA:** Fique atento aos comentários do **Greptile/Copilot**. Se ele sugerir algo como "Validation failure may redirect", aplique a correção conforme discutimos para evitar o erro de redirecionamento HTTP 302 em APIs.

### 7. Finalização Pós-Merge
Uma vez que o Roberto deu o **Approve** e o **Merge** foi feito:
- **Volte para a main:** `git checkout main`.
- **Atualize tudo:** `git pull origin main`.
- **Delete a branch local:** `git branch -d fix/nome-da-correcao`.