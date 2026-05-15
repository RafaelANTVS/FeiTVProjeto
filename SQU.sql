--
-- PostgreSQL database dump
--

\restrict 2P6iaVMrjqGDGInfQJnFTdD5U6lDIaOxl8mffjc2nGY0PEJA4mPdGikfGnORkbG

-- Dumped from database version 18.3
-- Dumped by pg_dump version 18.3

-- Started on 2026-05-15 13:38:42

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 223 (class 1259 OID 16611)
-- Name: Playlist_Videos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Playlist_Videos" (
    id_playlist integer NOT NULL,
    id_video integer NOT NULL
);


ALTER TABLE public."Playlist_Videos" OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 16598)
-- Name: playlists; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.playlists (
    id integer CONSTRAINT "Playlists_id_not_null" NOT NULL,
    nome character varying(100) CONSTRAINT "Playlists_nome_not_null" NOT NULL,
    id_usuario integer
);


ALTER TABLE public.playlists OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16597)
-- Name: Playlists_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Playlists_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."Playlists_id_seq" OWNER TO postgres;

--
-- TOC entry 5060 (class 0 OID 0)
-- Dependencies: 221
-- Name: Playlists_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Playlists_id_seq" OWNED BY public.playlists.id;


--
-- TOC entry 220 (class 1259 OID 16587)
-- Name: videos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.videos (
    id integer CONSTRAINT "Videos_id_not_null" NOT NULL,
    titulo character varying(100) CONSTRAINT "Videos_titulo_not_null" NOT NULL,
    descricao text,
    url_video character varying(255),
    curtidas integer DEFAULT 0
);


ALTER TABLE public.videos OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16586)
-- Name: Videos_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Videos_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."Videos_id_seq" OWNER TO postgres;

--
-- TOC entry 5061 (class 0 OID 0)
-- Dependencies: 219
-- Name: Videos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Videos_id_seq" OWNED BY public.videos.id;


--
-- TOC entry 224 (class 1259 OID 16628)
-- Name: curtidas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.curtidas (
    id_usuario integer CONSTRAINT "Curtidas_id_usuario_not_null" NOT NULL,
    id_video integer CONSTRAINT "Curtidas_id_video_not_null" NOT NULL,
    tipo character varying(20)
);


ALTER TABLE public.curtidas OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 24630)
-- Name: playlist_videos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.playlist_videos (
    playlist_id integer NOT NULL,
    video_id integer NOT NULL
);


ALTER TABLE public.playlist_videos OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 24579)
-- Name: tbusuarios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tbusuarios (
    nome character varying NOT NULL,
    usuario character varying NOT NULL,
    senha character varying NOT NULL,
    id integer NOT NULL
);


ALTER TABLE public.tbusuarios OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 24587)
-- Name: tbusuarios_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tbusuarios_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tbusuarios_id_seq OWNER TO postgres;

--
-- TOC entry 5062 (class 0 OID 0)
-- Dependencies: 226
-- Name: tbusuarios_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tbusuarios_id_seq OWNED BY public.tbusuarios.id;


--
-- TOC entry 4880 (class 2604 OID 16601)
-- Name: playlists id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.playlists ALTER COLUMN id SET DEFAULT nextval('public."Playlists_id_seq"'::regclass);


--
-- TOC entry 4881 (class 2604 OID 24588)
-- Name: tbusuarios id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tbusuarios ALTER COLUMN id SET DEFAULT nextval('public.tbusuarios_id_seq'::regclass);


--
-- TOC entry 4878 (class 2604 OID 16590)
-- Name: videos id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.videos ALTER COLUMN id SET DEFAULT nextval('public."Videos_id_seq"'::regclass);


--
-- TOC entry 5050 (class 0 OID 16611)
-- Dependencies: 223
-- Data for Name: Playlist_Videos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Playlist_Videos" (id_playlist, id_video) FROM stdin;
\.


--
-- TOC entry 5051 (class 0 OID 16628)
-- Dependencies: 224
-- Data for Name: curtidas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.curtidas (id_usuario, id_video, tipo) FROM stdin;
1	2	like
1	5	like
\.


--
-- TOC entry 5054 (class 0 OID 24630)
-- Dependencies: 227
-- Data for Name: playlist_videos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.playlist_videos (playlist_id, video_id) FROM stdin;
\.


--
-- TOC entry 5049 (class 0 OID 16598)
-- Dependencies: 222
-- Data for Name: playlists; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.playlists (id, nome, id_usuario) FROM stdin;
2	Filmes	1
1	Sonoplastia	1
3	musicas	1
\.


--
-- TOC entry 5052 (class 0 OID 24579)
-- Dependencies: 225
-- Data for Name: tbusuarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tbusuarios (nome, usuario, senha, id) FROM stdin;
teste1	aaaa	123	1
Administrador	admin	admin	2
Rafael	rafael	123	3
\.


--
-- TOC entry 5047 (class 0 OID 16587)
-- Dependencies: 220
-- Data for Name: videos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.videos (id, titulo, descricao, url_video, curtidas) FROM stdin;
1	Rick Astley - Never Gonna Give You UP	The official video	https://www.youtube.com/watch?v=dQw4w9WgXcQ	0
2	Michael Jackson - Bad	For the first of nine short films for the “Bad” album	https://www.youtube.com/watch?v=dsUXAEzaC3Q	0
3	Royal Blood - Figure It Out	The official music video for Royal Blood - Figure It Out	https://www.youtube.com/watch?v=jhgVu2lsi_k	0
4	Bohemian Rhapsody - Queen	Clássico do rock	https://youtu.be/fJ9rUzIMcZQ	0
5	Billie Jean - Michael Jackson	Pop dos anos 80	https://youtu.be/Zi_XLOBDo_Y	0
6	Imagine - John Lennon	Hino pela paz	https://youtu.be/YkgkThdzX-8	0
7	Smells Like Teen Spirit - Nirvana	Grunge dos anos 90	https://youtu.be/hTWKbfoikeg	0
8	Rolling in the Deep - Adele	Pop soul	https://youtu.be/rYEDA3JcQqw	0
\.


--
-- TOC entry 5063 (class 0 OID 0)
-- Dependencies: 221
-- Name: Playlists_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Playlists_id_seq"', 3, true);


--
-- TOC entry 5064 (class 0 OID 0)
-- Dependencies: 219
-- Name: Videos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Videos_id_seq"', 8, true);


--
-- TOC entry 5065 (class 0 OID 0)
-- Dependencies: 226
-- Name: tbusuarios_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tbusuarios_id_seq', 3, true);


--
-- TOC entry 4889 (class 2606 OID 16634)
-- Name: curtidas Curtidas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.curtidas
    ADD CONSTRAINT "Curtidas_pkey" PRIMARY KEY (id_usuario, id_video);


--
-- TOC entry 4887 (class 2606 OID 16617)
-- Name: Playlist_Videos Playlist_Videos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Playlist_Videos"
    ADD CONSTRAINT "Playlist_Videos_pkey" PRIMARY KEY (id_playlist, id_video);


--
-- TOC entry 4885 (class 2606 OID 16605)
-- Name: playlists Playlists_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.playlists
    ADD CONSTRAINT "Playlists_pkey" PRIMARY KEY (id);


--
-- TOC entry 4883 (class 2606 OID 16596)
-- Name: videos Videos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.videos
    ADD CONSTRAINT "Videos_pkey" PRIMARY KEY (id);


--
-- TOC entry 4895 (class 2606 OID 24636)
-- Name: playlist_videos playlist_videos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.playlist_videos
    ADD CONSTRAINT playlist_videos_pkey PRIMARY KEY (playlist_id, video_id);


--
-- TOC entry 4893 (class 2606 OID 24591)
-- Name: tbusuarios tbusuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tbusuarios
    ADD CONSTRAINT tbusuarios_pkey PRIMARY KEY (id);


--
-- TOC entry 4891 (class 2606 OID 24609)
-- Name: curtidas unique_curtida; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.curtidas
    ADD CONSTRAINT unique_curtida UNIQUE (id_usuario, id_video);


--
-- TOC entry 4898 (class 2606 OID 16640)
-- Name: curtidas Curtidas_id_video_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.curtidas
    ADD CONSTRAINT "Curtidas_id_video_fkey" FOREIGN KEY (id_video) REFERENCES public.videos(id) ON DELETE CASCADE;


--
-- TOC entry 4896 (class 2606 OID 16618)
-- Name: Playlist_Videos Playlist_Videos_id_playlist_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Playlist_Videos"
    ADD CONSTRAINT "Playlist_Videos_id_playlist_fkey" FOREIGN KEY (id_playlist) REFERENCES public.playlists(id) ON DELETE CASCADE;


--
-- TOC entry 4897 (class 2606 OID 16623)
-- Name: Playlist_Videos Playlist_Videos_id_video_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Playlist_Videos"
    ADD CONSTRAINT "Playlist_Videos_id_video_fkey" FOREIGN KEY (id_video) REFERENCES public.videos(id) ON DELETE CASCADE;


-- Completed on 2026-05-15 13:38:43

--
-- PostgreSQL database dump complete
--

\unrestrict 2P6iaVMrjqGDGInfQJnFTdD5U6lDIaOxl8mffjc2nGY0PEJA4mPdGikfGnORkbG

