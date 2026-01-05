import subprocess # to run shell commands
import os # to handle file paths

def run_command(command, cwd=None):
    print(f"Running command: {command}")
    result = subprocess.run(
        command,
        shell=True,
        cwd=cwd,
    )

    if result.returncode != 0:
        raise RuntimeError(f"Erro ao executar: {command}")
    
# Caminho base do projeto
BASE_DIR = os.getcwd()

# 1. mvn clean package dentro de helloworld
helloworld_dir = os.path.join(BASE_DIR, "HelloWorldFunction")
run_command("mvn clean package", cwd=helloworld_dir)

# 2. sam build
run_command("sam build", cwd=BASE_DIR)

# 3. sam local invoke HelloWorldFunction --event events/event.json
run_command("sam local invoke HelloWorldFunction --event events/event.json", cwd=BASE_DIR)

print("Script concluído com sucesso.")
