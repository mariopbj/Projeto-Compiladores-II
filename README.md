# Projeto Compiladores
Dupla : Mário Pinheiro Borges Junior e Pedro Lovatto Zambon

## Execução no Linux (Base Debian)

1. Atualize os pacotes do sistema:

```bash
sudo apt update
```

2. Instale o Java:

```bash
sudo apt install openjdk-17-jdk
```

3. Verifique a instalação:

```bash
java --version
javac --version
```

4. Baixe o ANTLR4:

```bash
sudo apt install antlr4
```

5. Entre na pasta do projeto:
```bash
cd Projeto-Compiladores-I
```

6. Gerando os arquivos do ANTLR
```bash
antlr4 grammar/MiniLangLexer.g4 grammar/MiniLangParser.g4
```

7. Compile o Java
```bash
javac -cp ".:/usr/share/java/antlr4-runtime.jar" grammar/*.java src/*.java
```

8. Execute
```bash
java -cp ".:/usr/share/java/antlr4-runtime.jar:grammar:src" Main
```
