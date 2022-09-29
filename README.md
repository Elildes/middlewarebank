# ufrn-2022.2-MiddlewareBank

Programação Distribuída

# Pacotes Java JDK 8
Fonte: https://docs.oracle.com/javase/8/docs/api/index.html

# App Diagrams.Net
Fonte: [AppDiagrams.Net](https://app.diagrams.net/)

# TUTORIAL GIT HUB

Documentação:  
Fonte: https://docs.github.com/pt - GitHub Docs  
Fonte: https://git-scm.com/book/pt-br/v1/Primeiros-passos-Sobre-Controle-de-Vers%C3%A3o  
Fonte: https://git-scm.com/book/pt-br/v1/Primeiros-passos-Configura%C3%A7%C3%A3o-Inicial-do-Git  
Fonte: https://www.youtube.com/watch?v=udw3J335ZHo (Curso Git - LCM Aquino)  

## Configuração inicial do Git:  

### Criar novos usuário/email (identidade):  

```
git config --global user.email "you@example.com"`
git config --global user.name "Your Name"
```

**Obs.1**: --global: caso vc precise definir outros usuarios/emails para outros projetos não precisa digitar --global.  
**Obs.2**: Usando --global, basta fazer isso apenas uma vez, pois o Git usará esta identidade toda vez que o sistema for usado.  
**Obs.3**: A identidade deverá ser criada após instalar o o Git (todos commits usam este usuário).  

### Editor padrão:  
. Para configurar o editor de texto padrão que será utilizado no Git:  

```
git config --global <nome_editor>
```

. **Ex.**: core.editor emacs ou core.editor="C:\\Program Files\\Sublime Text 3\\subl.exe" -w  

(...)

## Obter um repositório/projeto git:  

(...)  

### Segunda forma (baixar/clonar do git para o pc):  
. No seu pc, abra o terminal e vá até a pasta que queira baixar o repositório  
. Copiar a url do repositório. Ex.: https://github.com/Elildes/ufrn-2019.1-itp-projeto.git  
. No PC (programa do git já instalado):  

`com o terminal`, entre na pasta de destino do reporitório.  
`git clone <url do repositório>`(salva uma pasta com o mesmo nome do projeto. Ex.: ufrn-2019.1-itp-projeto (nome da pasta criada)  

**Obs.01**: após o comando acima, o repositório do projeto será baixado dentro da pasta onde o terminal está acessando.  

**Obs.02**: caso queira clonar o repositório em um diretório diferente do projeto, especifique esse diretório conforme abaixo:  
`git clone https://github.com/Elildes/ufrn-2019.1-itp-projeto.git projeto` (o repositório será salvo na pasta projeto)  

**Obs.03**: Se não tiver clonado um repositório existente e quer conectar seu repositório a um
servidor remoto, você deve adicioná-lo com:  
`git remote add origin <servidor>`  

**Obs.04**:  
`git fork <URL do github>`  (baixa o repositório de terceiros).????????  

## Gravando alterações no repositório (Adicionar/enviar ao GitHub e enviar atualizações):  
`git add <file.ext>` (adiciona um arquivo) ou:  
`git add *` (todos arquivos)  
`git commit -m "Mensagem xxx"` (empacota as alterações feitas no repositório baixado)  
`git remote add origin <URL do Git>` (se tiver dentro do seu git não precisa)  
`git push` (envia as alterações feitas ao repositório remoto), ou:  
`git push -u origin master` (alteracões estão no head local: enviar ao repositório remoto)  
... irá pedir senha/usuário (quando for feito o projeto, clonado não pede senha???)  

`pull request` (requisição de alteração de arquivo: solicitar ao dono do perfil)  

## Diversos:  
`git status` (verifica o status dos arquivos: quais arquivos não foram enviados ao repositório...)  
`git diff [chave]` (ver diferenças entre commits: chave é o rash, apenas 7 char)  
`git pull` (atualiza o repositório no pc: fazer isto logo após abrir o projeto monitorado)  

### Verificar as configirações:  
**Ex.**: mostra todas as configurações:  

```
git config --list
user.name=Scott Chacon
user.email=schacon@gmail.com
color.status=auto
color.branch=auto
color.interactive=auto
color.diff=auto
...
```

### Verificar nome de usuário (identidade):  
```
git config user.name
```

### Verificar e-mail do usuário (identidade):  
```
git config user.mail
```
**Obs**.: `git config {key}`  

### Histórico de commits (listar todos os commits):  
`gitk`  (ferramenta gráfica)  
`git log`  
`git log -p -2` (mostra o diff introduzido em cada commit ref. aos 2 últimos commits)  
`git log stat` (lista arquivos: quais foram modificados, quantos modificados e quantas linhas foram adicionadas/removidas)  

