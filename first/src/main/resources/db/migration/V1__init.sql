CREATE TABLE public.team
(
    id serial NOT NULL,
    name varchar(255) NOT NULL,
    location varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.player
(
    id serial NOT NULL,
    name varchar(255) NOT NULL,
    position varchar(255) NOT NULL,
    team_id integer,
    CONSTRAINT player_pk PRIMARY KEY (id),
    CONSTRAINT player_team_id_fk FOREIGN KEY (team_id)
        REFERENCES public.team (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);