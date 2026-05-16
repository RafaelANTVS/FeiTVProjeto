**FEI-TV Plataforma de de Vídeos**

 **Sobre o Projeto**
- Sistema desenvolvido em Java para pesquisa de vídeos onde os usuários podem pesquisar vídeos, curtir/descurtir e gerenciar playlists.

**Tecnologias Utilizadas**
- Java 21 (Swing para interface gráfica)
- PostgreSQL (Banco de dados)
- JDBC (Conexão com o banco)
- MVC (Model-View-Controller)

**Funcionalidades**
- Cadastro de usuários
- Login de usuários
- Pesquisar vídeos por nome de músicas
- Curtir e descurtir vídeos
- Criar, editar e excluir playlists
- Adicionar e remover playlists

**Estrutura do SQL**
- tbusuarios: Armazena os usuários
- videos: Armazenamm nome de músicas e a descrição
- playlists: Armazena as listas de músicas.
- playlist_videos: Relação entre playlists e vídeos
- curtidas: Relação entre usuários e vídeos curtidos

 **Como Usar**
1. Instalar PostgreSQL
2. Executar os scripts SQL (scripts.sql)
3. Abrir o projeto no NetBeans
4. Adicionar a biblioteca JDBC do PostgreSQL
5. Executar o projeto

**Desenvolvido por:**
Rafael Antonio, disciplina Rede de computadores
05/26
