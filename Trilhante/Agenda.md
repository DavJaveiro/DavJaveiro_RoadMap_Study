2026-03-09 - Instalar o concurrently e configurar no ambiente local para desenvolvimento, evitando ter que abrir três terminais para rodar o projeto localmente. 
npm install concurrently --save-dev

Editar o package.json e adicionar:
```json
{
  "scripts": {
    "dev:all": "concurrently \"php artisan serve --host=0.0.0.0 --port=8000\" \"npm run dev\" \"php artisan queue:work\""
  }
}
```
Agora podemos rodar 
npm run dev:all 
E ele irá iniciar
- O servidor Laravel
- Vite
- worker de fila
tudo no mesmo terminal.

