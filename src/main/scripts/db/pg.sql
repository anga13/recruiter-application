--
-- PostgreSQL database dump
--

-- Dumped from database version 11.1
-- Dumped by pg_dump version 11.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: application; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.application (
    application_id bigint NOT NULL,
    person_id bigint NOT NULL,
    application_date timestamp without time zone,
    approval_status_id bigint NOT NULL
);

CREATE TABLE public.approval_status (
    approval_status_id bigint NOT NULL,
    name character varying NOT NULL
);

CREATE TABLE public.availability (
    availability_id bigint NOT NULL,
    person_id bigint,
    from_date timestamp without time zone,
    to_date timestamp without time zone
);

CREATE TABLE public.competence (
    competence_id bigint NOT NULL,
    name character varying(255)
);

CREATE TABLE public.competence_profile (
    competence_profile_id bigint NOT NULL,
    person_id bigint,
    competence_id bigint,
    years_of_experience numeric(4,2)
);


CREATE SEQUENCE public.myseq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE public.person (
    person_id bigint NOT NULL,
    name character varying(255),
    surname character varying(255),
    ssn character varying(255),
    email character varying(255),
    password character varying(255),
    role_id bigint,
    username character varying(255)
);



CREATE SEQUENCE public.recruite_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;



CREATE TABLE public.role (
    role_id bigint NOT NULL,
    name character varying(255)
);



COPY public.application (application_id, person_id, application_date, approval_status_id) FROM stdin;
\.


--
-- Data for Name: approval_status; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.approval_status (approval_status_id, name) FROM stdin;
\.


--
-- Data for Name: availability; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.availability (availability_id, person_id, from_date, to_date) FROM stdin;
1	2	2014-02-23	2014-05-25
2	2	2014-07-10	2014-08-10
\.


--
-- Data for Name: competence; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.competence (competence_id, name) FROM stdin;
1	Korvgrillning
2	Karuselldrift
\.


--
-- Data for Name: competence_profile; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.competence_profile (competence_profile_id, person_id, competence_id, years_of_experience) FROM stdin;
1	2	1	3.50
2	2	2	2.00
\.


--
-- Data for Name: person; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.person (person_id, name, surname, ssn, email, password, role_id, username) FROM stdin;
1	Greta	Borg	\N	\N	wl9nk23a	1	borg
2	Per	Strand	19671212-1211	per@strand.kth.se	\N	2	\N
\.


--
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.role (role_id, name) FROM stdin;
1	recruit
2	applicant
\.


--
-- Name: myseq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.myseq', 1, false);


--
-- Name: recruite_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.recruite_seq', 1, false);


--
-- Name: application application_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.application
    ADD CONSTRAINT application_pk PRIMARY KEY (application_id);


--
-- Name: approval_status approval_status_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.approval_status
    ADD CONSTRAINT approval_status_pk PRIMARY KEY (approval_status_id);


--
-- Name: availability availability_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.availability
    ADD CONSTRAINT availability_pkey PRIMARY KEY (availability_id);


--
-- Name: competence competence_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.competence
    ADD CONSTRAINT competence_pkey PRIMARY KEY (competence_id);


--
-- Name: competence_profile competence_profile_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.competence_profile
    ADD CONSTRAINT competence_profile_pkey PRIMARY KEY (competence_profile_id);


--
-- Name: person person_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.person
    ADD CONSTRAINT person_pkey PRIMARY KEY (person_id);


--
-- Name: role role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (role_id);


--
-- Name: application application_approval_status_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.application
    ADD CONSTRAINT application_approval_status_fk FOREIGN KEY (approval_status_id) REFERENCES public.approval_status(approval_status_id);


--
-- Name: application application_person_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.application
    ADD CONSTRAINT application_person_fk FOREIGN KEY (person_id) REFERENCES public.person(person_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: availability availability_person_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.availability
    ADD CONSTRAINT availability_person_id_fkey FOREIGN KEY (person_id) REFERENCES public.person(person_id);


--
-- Name: competence_profile competence_profile_competence_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.competence_profile
    ADD CONSTRAINT competence_profile_competence_id_fkey FOREIGN KEY (competence_id) REFERENCES public.competence(competence_id);


--
-- Name: competence_profile competence_profile_person_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.competence_profile
    ADD CONSTRAINT competence_profile_person_id_fkey FOREIGN KEY (person_id) REFERENCES public.person(person_id);


--
-- Name: person person_role_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.person
    ADD CONSTRAINT person_role_id_fkey FOREIGN KEY (role_id) REFERENCES public.role(role_id);


--
-- PostgreSQL database dump complete
--

