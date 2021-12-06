--
-- PostgreSQL database dump
--

-- Dumped from database version 14.0
-- Dumped by pg_dump version 14.0

-- Started on 2021-12-06 14:47:22 +06

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
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
-- TOC entry 215 (class 1259 OID 32923)
-- Name: Bill; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Bill" (
    res_id integer,
    bill_id integer NOT NULL,
    guest_id integer,
    sum integer
);


ALTER TABLE public."Bill" OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 33177)
-- Name: Cleaning; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Cleaning" (
    emp_id integer NOT NULL,
    "days " character varying(100),
    start_clean time without time zone,
    end_clean time without time zone,
    room_id integer,
    clean_id integer NOT NULL
);


ALTER TABLE public."Cleaning" OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 32857)
-- Name: Employee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Employee" (
    emp_id integer NOT NULL,
    fname character varying(50) NOT NULL,
    lname character varying(50) NOT NULL,
    hotel_id integer
);


ALTER TABLE public."Employee" OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 32812)
-- Name: Guest; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Guest" (
    guest_id integer NOT NULL,
    id_type character varying(100) NOT NULL,
    number character varying(100) NOT NULL,
    address character varying(100) NOT NULL,
    hphone_number character varying(100),
    mobile_number character varying(100) NOT NULL,
    email character varying(100)
);


ALTER TABLE public."Guest" OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 32787)
-- Name: Hotel; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Hotel" (
    hotel_id integer NOT NULL,
    name character varying(100) NOT NULL,
    address character varying(100) NOT NULL,
    "phone number " character varying(40)
);


ALTER TABLE public."Hotel" OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 32819)
-- Name: Reservations; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Reservations" (
    guest_id integer NOT NULL,
    hotel_id integer NOT NULL,
    room_id integer NOT NULL,
    check_in date NOT NULL,
    check_out date,
    res_id integer NOT NULL
);


ALTER TABLE public."Reservations" OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 32802)
-- Name: Room; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Room" (
    roomtype_id integer NOT NULL,
    room_id integer NOT NULL,
    "room number" character varying(20) NOT NULL,
    floor integer
);


ALTER TABLE public."Room" OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 32792)
-- Name: RoomTypes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."RoomTypes" (
    hotel_id integer NOT NULL,
    roomtype_id integer NOT NULL,
    room_type character varying(50) NOT NULL,
    size integer NOT NULL,
    capacity integer NOT NULL
);


ALTER TABLE public."RoomTypes" OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 33123)
-- Name: Users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Users" (
    email character varying(100) NOT NULL,
    "Name" character varying,
    "Surname" character varying,
    "Password" character varying
);


ALTER TABLE public."Users" OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 33152)
-- Name: auth_deskclerk; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.auth_deskclerk (
    email character varying NOT NULL
);


ALTER TABLE public.auth_deskclerk OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 33140)
-- Name: auth_guest; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.auth_guest (
    email character varying NOT NULL
);


ALTER TABLE public.auth_guest OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 33164)
-- Name: auth_manager; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.auth_manager (
    email character varying NOT NULL
);


ALTER TABLE public.auth_manager OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 33196)
-- Name: dk_schedule; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.dk_schedule (
    emp_id integer NOT NULL,
    schedule "char"
);


ALTER TABLE public.dk_schedule OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 33206)
-- Name: price; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.price (
    roomtype_id integer,
    week_day character varying,
    price integer,
    price_id integer NOT NULL
);


ALTER TABLE public.price OWNER TO postgres;

--
-- TOC entry 3669 (class 0 OID 32923)
-- Dependencies: 215
-- Data for Name: Bill; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Bill" (res_id, bill_id, guest_id, sum) FROM stdin;
10001	1	1	1039320
10002	2	1	87923
\.


--
-- TOC entry 3674 (class 0 OID 33177)
-- Dependencies: 220
-- Data for Name: Cleaning; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Cleaning" (emp_id, "days ", start_clean, end_clean, room_id, clean_id) FROM stdin;
3	M,T,W,R,F,S,Sn	09:00:00	10:00:00	1	1
3	M,T,W,R,F,S,Sn	10:00:00	11:00:00	2	2
3	M,T,W,R,F,S,Sn	11:00:00	12:00:00	3	3
3	M,T,W,R,F,S,Sn	12:00:00	13:00:00	4	4
3	M,T,W,R,F,S,Sn	14:00:00	15:00:00	5	5
3	M,T,W,R,F,S,Sn	15:00:00	16:00:00	6	6
5	M,T,W,R,F,S,Sn	09:00:00	10:00:00	7	7
5	M,T,W,R,F,S,Sn	10:00:00	11:00:00	8	8
5	M,T,W,R,F,S,Sn	11:00:00	12:00:00	9	9
5	M,T,W,R,F,S,Sn	12:00:00	13:00:00	10	10
5	M,T,W,R,F,S,Sn	14:00:00	15:00:00	11	11
5	M,T,W,R,F,S,Sn	15:00:00	16:00:00	12	12
8	M,T,W,R,F,S,Sn	09:00:00	10:00:00	13	13
8	M,T,W,R,F,S,Sn	10:00:00	11:00:00	14	14
8	M,T,W,R,F,S,Sn	11:00:00	12:00:00	15	15
8	M,T,W,R,F,S,Sn	12:00:00	13:00:00	16	16
8	M,T,W,R,F,S,Sn	14:00:00	15:00:00	17	17
8	M,T,W,R,F,S,Sn	15:00:00	16:00:00	18	18
\.


--
-- TOC entry 3668 (class 0 OID 32857)
-- Dependencies: 214
-- Data for Name: Employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Employee" (emp_id, fname, lname, hotel_id) FROM stdin;
1	John	Week	1
2	Hillary	Clinton	1
3	Kim	Kardashian	1
4	Jason	Kook	2
5	Kate	Johnson	2
6	Manager	One	2
7	Three	Clean	3
8	Clerk	Three	3
9	Manager	Three	3
\.


--
-- TOC entry 3666 (class 0 OID 32812)
-- Dependencies: 212
-- Data for Name: Guest; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Guest" (guest_id, id_type, number, address, hphone_number, mobile_number, email) FROM stdin;
1	Passport	N00000000	Shymkent	+7252425076	87088536276	user.one@gmail.com
2	ID	034304332	Almaty	+72520000	84374742933	user.two@gmail.com
\.


--
-- TOC entry 3663 (class 0 OID 32787)
-- Dependencies: 209
-- Data for Name: Hotel; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Hotel" (hotel_id, name, address, "phone number ") FROM stdin;
1	Spring	Astana	+11111
2	Autumn	Almaty	+22222
3	Winter	Shymkent	+33333
\.


--
-- TOC entry 3667 (class 0 OID 32819)
-- Dependencies: 213
-- Data for Name: Reservations; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Reservations" (guest_id, hotel_id, room_id, check_in, check_out, res_id) FROM stdin;
1	1	3	2021-03-02	2021-07-02	10001
1	1	5	2021-03-04	2021-03-05	10002
\.


--
-- TOC entry 3665 (class 0 OID 32802)
-- Dependencies: 211
-- Data for Name: Room; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Room" (roomtype_id, room_id, "room number", floor) FROM stdin;
101	1	2001	2
101	2	3001	3
101	3	4001	4
201	4	2002	2
201	5	3002	3
201	6	4002	4
102	7	2001	2
102	8	3001	3
102	9	4001	4
202	10	2002	2
202	11	3002	3
202	12	4002	4
103	13	2001	2
103	14	3001	3
103	15	4001	4
203	16	2002	2
203	17	3002	3
203	18	4002	4
\.


--
-- TOC entry 3664 (class 0 OID 32792)
-- Dependencies: 210
-- Data for Name: RoomTypes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."RoomTypes" (hotel_id, roomtype_id, room_type, size, capacity) FROM stdin;
1	101	Single	15	1
1	201	Double	24	2
2	102	Single	12	1
2	202	Double	27	2
3	103	Single	15	1
3	203	Double	30	2
\.


--
-- TOC entry 3670 (class 0 OID 33123)
-- Dependencies: 216
-- Data for Name: Users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Users" (email, "Name", "Surname", "Password") FROM stdin;
desk.clerk@gmail.com	Desk	Clerk	123456
jason.kook@gmail.com	Jason	Cook	123456
john.week@gmail.com	John	Week	123456
kim.kardashian@gmail.com	Kim	Kardashian	123456
manager.one@gmail.com	Manager	One	123456
manager.three@gmail.com	Manager	Three	123456
three.clean@gmail.com	Three	Clean	123456
user.one@gmail.com	User	One	123456
user.two@gmail.com	User	Two	123456
\.


--
-- TOC entry 3672 (class 0 OID 33152)
-- Dependencies: 218
-- Data for Name: auth_deskclerk; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.auth_deskclerk (email) FROM stdin;
jason.kook@gmail.com
john.week@gmail.com
three.clean@gmail.com
\.


--
-- TOC entry 3671 (class 0 OID 33140)
-- Dependencies: 217
-- Data for Name: auth_guest; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.auth_guest (email) FROM stdin;
user.one@gmail.com
user.two@gmail.com
\.


--
-- TOC entry 3673 (class 0 OID 33164)
-- Dependencies: 219
-- Data for Name: auth_manager; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.auth_manager (email) FROM stdin;
kim.kardashian@gmail.com
manager.one@gmail.com
manager.three@gmail.com
\.


--
-- TOC entry 3675 (class 0 OID 33196)
-- Dependencies: 221
-- Data for Name: dk_schedule; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.dk_schedule (emp_id, schedule) FROM stdin;
1	9
4	9
7	9
\.


--
-- TOC entry 3676 (class 0 OID 33206)
-- Dependencies: 222
-- Data for Name: price; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.price (roomtype_id, week_day, price, price_id) FROM stdin;
101	Monday	15000	1
101	Tuesday	15000	2
101	Wednesday	15000	3
101	Thursday	15000	4
101	Friday	15000	5
101	Saturday	20000	6
101	Sunday	20000	7
201	Monday	25000	8
201	Tuesday	25000	9
201	Wednesday	25000	10
201	Thursday	25000	11
201	Friday	25000	12
201	Saturday	30000	13
201	Sunday	30000	14
102	Monday	18000	15
102	Tuesday	18000	16
102	Wednesday	18000	17
102	Thursday	18000	18
102	Friday	18000	19
102	Saturday	22000	20
102	Sunday	22000	21
202	Monday	28000	22
202	Tuesday	28000	23
202	Wednesday	28000	24
202	Thursday	28000	25
202	Friday	28000	26
202	Saturday	35000	27
202	Sunday	35000	28
103	Monday	17000	29
103	Tuesday	17000	30
103	Wednesday	17000	31
103	Thursday	17000	32
103	Friday	17000	33
103	Saturday	20000	34
103	Sunday	20000	35
203	Monday	25000	36
203	Tuesday	25000	37
203	Wednesday	25000	38
203	Thursday	25000	39
203	Friday	25000	40
203	Saturday	25000	41
203	Sunday	28000	42
\.


--
-- TOC entry 3494 (class 2606 OID 32927)
-- Name: Bill Bill_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Bill"
    ADD CONSTRAINT "Bill_pkey" PRIMARY KEY (bill_id);


--
-- TOC entry 3504 (class 2606 OID 33191)
-- Name: Cleaning Cleaning_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Cleaning"
    ADD CONSTRAINT "Cleaning_pkey" PRIMARY KEY (clean_id);


--
-- TOC entry 3492 (class 2606 OID 32861)
-- Name: Employee Employee_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Employee"
    ADD CONSTRAINT "Employee_pkey" PRIMARY KEY (emp_id);


--
-- TOC entry 3488 (class 2606 OID 32818)
-- Name: Guest Guest_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Guest"
    ADD CONSTRAINT "Guest_pkey" PRIMARY KEY (guest_id);


--
-- TOC entry 3482 (class 2606 OID 32791)
-- Name: Hotel Hotel_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Hotel"
    ADD CONSTRAINT "Hotel_pkey" PRIMARY KEY (hotel_id);


--
-- TOC entry 3490 (class 2606 OID 32823)
-- Name: Reservations Reservations_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Reservations"
    ADD CONSTRAINT "Reservations_pkey" PRIMARY KEY (res_id);


--
-- TOC entry 3484 (class 2606 OID 32796)
-- Name: RoomTypes RoomTypes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."RoomTypes"
    ADD CONSTRAINT "RoomTypes_pkey" PRIMARY KEY (roomtype_id);


--
-- TOC entry 3486 (class 2606 OID 32806)
-- Name: Room Room_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Room"
    ADD CONSTRAINT "Room_pkey" PRIMARY KEY (room_id);


--
-- TOC entry 3496 (class 2606 OID 33129)
-- Name: Users Users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Users"
    ADD CONSTRAINT "Users_pkey" PRIMARY KEY (email);


--
-- TOC entry 3500 (class 2606 OID 33158)
-- Name: auth_deskclerk auth_deskclerk_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.auth_deskclerk
    ADD CONSTRAINT auth_deskclerk_pkey PRIMARY KEY (email);


--
-- TOC entry 3498 (class 2606 OID 33146)
-- Name: auth_guest auth_guest_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.auth_guest
    ADD CONSTRAINT auth_guest_pkey PRIMARY KEY (email);


--
-- TOC entry 3502 (class 2606 OID 33170)
-- Name: auth_manager auth_manager_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.auth_manager
    ADD CONSTRAINT auth_manager_pkey PRIMARY KEY (email);


--
-- TOC entry 3506 (class 2606 OID 33200)
-- Name: dk_schedule dk_schedule_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dk_schedule
    ADD CONSTRAINT dk_schedule_pkey PRIMARY KEY (emp_id);


--
-- TOC entry 3508 (class 2606 OID 33217)
-- Name: price price_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.price
    ADD CONSTRAINT price_pkey PRIMARY KEY (price_id);


--
-- TOC entry 3517 (class 2606 OID 33147)
-- Name: auth_guest email; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.auth_guest
    ADD CONSTRAINT email FOREIGN KEY (email) REFERENCES public."Users"(email) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;


--
-- TOC entry 3518 (class 2606 OID 33159)
-- Name: auth_deskclerk email; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.auth_deskclerk
    ADD CONSTRAINT email FOREIGN KEY (email) REFERENCES public."Users"(email);


--
-- TOC entry 3519 (class 2606 OID 33171)
-- Name: auth_manager email; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.auth_manager
    ADD CONSTRAINT email FOREIGN KEY (email) REFERENCES public."Users"(email) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3520 (class 2606 OID 33180)
-- Name: Cleaning emp_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Cleaning"
    ADD CONSTRAINT emp_id FOREIGN KEY (emp_id) REFERENCES public."Employee"(emp_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3522 (class 2606 OID 33201)
-- Name: dk_schedule emp_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dk_schedule
    ADD CONSTRAINT emp_id FOREIGN KEY (emp_id) REFERENCES public."Employee"(emp_id) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;


--
-- TOC entry 3512 (class 2606 OID 32834)
-- Name: Reservations guest_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Reservations"
    ADD CONSTRAINT guest_id FOREIGN KEY (guest_id) REFERENCES public."Guest"(guest_id);


--
-- TOC entry 3516 (class 2606 OID 33118)
-- Name: Bill guest_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Bill"
    ADD CONSTRAINT guest_id FOREIGN KEY (guest_id) REFERENCES public."Guest"(guest_id) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;


--
-- TOC entry 3509 (class 2606 OID 32797)
-- Name: RoomTypes hotel_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."RoomTypes"
    ADD CONSTRAINT hotel_id FOREIGN KEY (hotel_id) REFERENCES public."Hotel"(hotel_id);


--
-- TOC entry 3511 (class 2606 OID 32829)
-- Name: Reservations hotel_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Reservations"
    ADD CONSTRAINT hotel_id FOREIGN KEY (hotel_id) REFERENCES public."Hotel"(hotel_id);


--
-- TOC entry 3514 (class 2606 OID 32948)
-- Name: Employee hotel_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Employee"
    ADD CONSTRAINT hotel_id FOREIGN KEY (hotel_id) REFERENCES public."Hotel"(hotel_id) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;


--
-- TOC entry 3515 (class 2606 OID 32928)
-- Name: Bill res_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Bill"
    ADD CONSTRAINT res_id FOREIGN KEY (res_id) REFERENCES public."Reservations"(res_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3513 (class 2606 OID 32938)
-- Name: Reservations room_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Reservations"
    ADD CONSTRAINT room_id FOREIGN KEY (room_id) REFERENCES public."Room"(room_id) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;


--
-- TOC entry 3521 (class 2606 OID 33185)
-- Name: Cleaning room_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Cleaning"
    ADD CONSTRAINT room_id FOREIGN KEY (room_id) REFERENCES public."Room"(room_id);


--
-- TOC entry 3510 (class 2606 OID 32807)
-- Name: Room roomtype_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Room"
    ADD CONSTRAINT roomtype_id FOREIGN KEY (roomtype_id) REFERENCES public."RoomTypes"(roomtype_id);


--
-- TOC entry 3523 (class 2606 OID 33211)
-- Name: price roomtype_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.price
    ADD CONSTRAINT roomtype_id FOREIGN KEY (roomtype_id) REFERENCES public."RoomTypes"(roomtype_id) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;


-- Completed on 2021-12-06 14:47:22 +06

--
-- PostgreSQL database dump complete
--

