-- ============================================================
-- FEITV - Script de criação do banco de dados PostgreSQL
-- Execute este script antes de rodar o projeto
-- ============================================================

-- Tabela de usuários
CREATE TABLE tbusuarios (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    usuario VARCHAR(50) UNIQUE NOT NULL,
    senha VARCHAR(50) NOT NULL
);

-- Tabela de vídeos
CREATE TABLE videos (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    descricao TEXT,
    url_video VARCHAR(500),
    curtidas INTEGER DEFAULT 0
);

-- Tabela de playlists
CREATE TABLE playlists (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    id_usuario INTEGER REFERENCES tbusuarios(id) ON DELETE CASCADE
);

-- Tabela de relação playlist_videos
CREATE TABLE playlist_videos (
    playlist_id INTEGER REFERENCES playlists(id) ON DELETE CASCADE,
    video_id INTEGER REFERENCES videos(id) ON DELETE CASCADE,
    PRIMARY KEY (playlist_id, video_id)
);

-- Tabela de curtidas
CREATE TABLE curtidas (
    id_usuario INTEGER REFERENCES tbusuarios(id) ON DELETE CASCADE,
    id_video INTEGER REFERENCES videos(id) ON DELETE CASCADE,
    tipo VARCHAR(20),
    PRIMARY KEY (id_usuario, id_video)
);

INSERT INTO videos (titulo, descricao, url_video) VALUES 
('Bohemian Rhapsody - Queen', 'Clássico do rock', 'https://youtu.be/fJ9rUzIMcZQ'),
('Billie Jean - Michael Jackson', 'Pop dos anos 80', 'https://youtu.be/Zi_XLOBDo_Y'),
('Imagine - John Lennon', 'Hino pela paz', 'https://youtu.be/YkgkThdzX-8');