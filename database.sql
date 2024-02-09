PGDMP      0         
        |            tourismAgency    16.1    16.1 (    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    24642    tourismAgency    DATABASE     �   CREATE DATABASE "tourismAgency" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
    DROP DATABASE "tourismAgency";
                postgres    false            �            1259    24644    user    TABLE     �   CREATE TABLE public."user" (
    user_id integer NOT NULL,
    user_name text NOT NULL,
    user_pass text NOT NULL,
    user_role text NOT NULL
);
    DROP TABLE public."user";
       public         heap    postgres    false            �            1259    24643    User_user_id_seq    SEQUENCE     �   ALTER TABLE public."user" ALTER COLUMN user_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."User_user_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    216            �            1259    24651    hotel    TABLE     �  CREATE TABLE public.hotel (
    hotel_id integer NOT NULL,
    hotel_name text NOT NULL,
    hotel_address text NOT NULL,
    hotel_mail text NOT NULL,
    hotel_phone text NOT NULL,
    hotel_star text NOT NULL,
    hotel_carpark boolean NOT NULL,
    hotel_wifi boolean NOT NULL,
    hotel_pool boolean NOT NULL,
    hotel_fitness boolean NOT NULL,
    hotel_concierge boolean NOT NULL,
    hotel_spa boolean NOT NULL,
    hotel_roomservice boolean NOT NULL
);
    DROP TABLE public.hotel;
       public         heap    postgres    false            �            1259    24658    hotel_hotel_id_seq    SEQUENCE     �   ALTER TABLE public.hotel ALTER COLUMN hotel_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.hotel_hotel_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    217            �            1259    24686    pencion    TABLE        CREATE TABLE public.pencion (
    pencion_id integer NOT NULL,
    hotel_id integer,
    pencion_type character varying(50)
);
    DROP TABLE public.pencion;
       public         heap    postgres    false            �            1259    24685    pencion_pencion_id_seq    SEQUENCE     �   CREATE SEQUENCE public.pencion_pencion_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.pencion_pencion_id_seq;
       public          postgres    false    222            �           0    0    pencion_pencion_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.pencion_pencion_id_seq OWNED BY public.pencion.pencion_id;
          public          postgres    false    221            �            1259    24718    reservation    TABLE     �  CREATE TABLE public.reservation (
    id integer NOT NULL,
    reservation_room_id integer NOT NULL,
    reservation_start_date date NOT NULL,
    reservation_end_date date NOT NULL,
    reservation_total_price integer NOT NULL,
    reservation_guest_number integer NOT NULL,
    reservation_guest_name text NOT NULL,
    reservation_mail text NOT NULL,
    reservation_phone text NOT NULL,
    reservation_guest_id text NOT NULL
);
    DROP TABLE public.reservation;
       public         heap    postgres    false            �            1259    24717    reservation_ID_seq    SEQUENCE     �   ALTER TABLE public.reservation ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."reservation_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    226            �            1259    24698    room    TABLE        CREATE TABLE public.room (
    room_id integer NOT NULL,
    hotel_id integer NOT NULL,
    pencion_id integer NOT NULL,
    season_id integer NOT NULL,
    room_type text NOT NULL,
    room_stock integer NOT NULL,
    room_adult_price integer NOT NULL,
    room_child_price integer NOT NULL,
    room_bed_capacity integer NOT NULL,
    room_squar_meter integer NOT NULL,
    room_tv boolean NOT NULL,
    room_minibar boolean NOT NULL,
    room_konsol boolean NOT NULL,
    room_kasa boolean NOT NULL,
    room_projeksiyon boolean NOT NULL
);
    DROP TABLE public.room;
       public         heap    postgres    false            �            1259    24697    room_room_id_seq    SEQUENCE     �   ALTER TABLE public.room ALTER COLUMN room_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.room_room_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    224            �            1259    24674    season    TABLE     �   CREATE TABLE public.season (
    season_id integer NOT NULL,
    hotel_id integer,
    season_startdate date,
    season_enddate date
);
    DROP TABLE public.season;
       public         heap    postgres    false            �            1259    24673    season_season_id_seq    SEQUENCE     �   CREATE SEQUENCE public.season_season_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.season_season_id_seq;
       public          postgres    false    220            �           0    0    season_season_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.season_season_id_seq OWNED BY public.season.season_id;
          public          postgres    false    219            4           2604    24689    pencion pencion_id    DEFAULT     x   ALTER TABLE ONLY public.pencion ALTER COLUMN pencion_id SET DEFAULT nextval('public.pencion_pencion_id_seq'::regclass);
 A   ALTER TABLE public.pencion ALTER COLUMN pencion_id DROP DEFAULT;
       public          postgres    false    222    221    222            3           2604    24677    season season_id    DEFAULT     t   ALTER TABLE ONLY public.season ALTER COLUMN season_id SET DEFAULT nextval('public.season_season_id_seq'::regclass);
 ?   ALTER TABLE public.season ALTER COLUMN season_id DROP DEFAULT;
       public          postgres    false    219    220    220            �          0    24651    hotel 
   TABLE DATA           �   COPY public.hotel (hotel_id, hotel_name, hotel_address, hotel_mail, hotel_phone, hotel_star, hotel_carpark, hotel_wifi, hotel_pool, hotel_fitness, hotel_concierge, hotel_spa, hotel_roomservice) FROM stdin;
    public          postgres    false    217   �0       �          0    24686    pencion 
   TABLE DATA           E   COPY public.pencion (pencion_id, hotel_id, pencion_type) FROM stdin;
    public          postgres    false    222   �1       �          0    24718    reservation 
   TABLE DATA           �   COPY public.reservation (id, reservation_room_id, reservation_start_date, reservation_end_date, reservation_total_price, reservation_guest_number, reservation_guest_name, reservation_mail, reservation_phone, reservation_guest_id) FROM stdin;
    public          postgres    false    226   32       �          0    24698    room 
   TABLE DATA           �   COPY public.room (room_id, hotel_id, pencion_id, season_id, room_type, room_stock, room_adult_price, room_child_price, room_bed_capacity, room_squar_meter, room_tv, room_minibar, room_konsol, room_kasa, room_projeksiyon) FROM stdin;
    public          postgres    false    224   �2       �          0    24674    season 
   TABLE DATA           W   COPY public.season (season_id, hotel_id, season_startdate, season_enddate) FROM stdin;
    public          postgres    false    220   �2       �          0    24644    user 
   TABLE DATA           J   COPY public."user" (user_id, user_name, user_pass, user_role) FROM stdin;
    public          postgres    false    216   83       �           0    0    User_user_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public."User_user_id_seq"', 51, true);
          public          postgres    false    215            �           0    0    hotel_hotel_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hotel_hotel_id_seq', 24, true);
          public          postgres    false    218            �           0    0    pencion_pencion_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.pencion_pencion_id_seq', 38, true);
          public          postgres    false    221            �           0    0    reservation_ID_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public."reservation_ID_seq"', 18, true);
          public          postgres    false    225            �           0    0    room_room_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.room_room_id_seq', 11, true);
          public          postgres    false    223            �           0    0    season_season_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.season_season_id_seq', 26, true);
          public          postgres    false    219            8           2606    24657    hotel HOTEL_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.hotel
    ADD CONSTRAINT "HOTEL_pkey" PRIMARY KEY (hotel_id);
 <   ALTER TABLE ONLY public.hotel DROP CONSTRAINT "HOTEL_pkey";
       public            postgres    false    217            6           2606    24648    user User_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public."user"
    ADD CONSTRAINT "User_pkey" PRIMARY KEY (user_id);
 <   ALTER TABLE ONLY public."user" DROP CONSTRAINT "User_pkey";
       public            postgres    false    216            <           2606    24691    pencion pencion_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.pencion
    ADD CONSTRAINT pencion_pkey PRIMARY KEY (pencion_id);
 >   ALTER TABLE ONLY public.pencion DROP CONSTRAINT pencion_pkey;
       public            postgres    false    222            @           2606    24722    reservation reservation_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.reservation DROP CONSTRAINT reservation_pkey;
       public            postgres    false    226            >           2606    24702    room room_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.room
    ADD CONSTRAINT room_pkey PRIMARY KEY (room_id);
 8   ALTER TABLE ONLY public.room DROP CONSTRAINT room_pkey;
       public            postgres    false    224            :           2606    24679    season season_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.season
    ADD CONSTRAINT season_pkey PRIMARY KEY (season_id);
 <   ALTER TABLE ONLY public.season DROP CONSTRAINT season_pkey;
       public            postgres    false    220            B           2606    24692    pencion pencion_hotel_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.pencion
    ADD CONSTRAINT pencion_hotel_id_fkey FOREIGN KEY (hotel_id) REFERENCES public.hotel(hotel_id);
 G   ALTER TABLE ONLY public.pencion DROP CONSTRAINT pencion_hotel_id_fkey;
       public          postgres    false    217    222    4664            A           2606    24680    season season_hotel_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.season
    ADD CONSTRAINT season_hotel_id_fkey FOREIGN KEY (hotel_id) REFERENCES public.hotel(hotel_id);
 E   ALTER TABLE ONLY public.season DROP CONSTRAINT season_hotel_id_fkey;
       public          postgres    false    217    4664    220            �   �   x�UOK� \Gq�XZ�K�.L���R%HZj���L
��L�~��{��8��Y5:a��5��j����Q,�*�g��u��%	�S�Ղ$��,/��'9J�h�/�:����W��_oAh������'���L�?m����f�Ul�o��Wn!9g��_�R      �   l   x�36�42�t����Q�H,�<�\��4'G!�(5%���،�Ȉ32����\��ļ����<.csN#CN��"���S+\32s��-8�L8�S�3�sJ�l����� &�      �   R   x�3��44�4202�54�50�38M8M83rSKRs���L,N"NScSSKCcKKCN3Sc#CC3S�=... ��      �   P   x�-�A
�0ϓ�Hm����'�� xi�o�20�e�w�Ol���Tc�Jd�r~�>1.xf}�qrԑ�~��G�AD^-G�      �   3   x�32�42�4202�54�50�3���8�L@F��@b�@�\1z\\\ ?�
      �   '   x�3�LL���C&�L8�S�85� '�25�+F��� C�t     