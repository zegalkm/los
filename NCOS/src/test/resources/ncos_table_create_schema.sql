--영웅정보
CREATE TABLE sa_hero
(
  heroid serial NOT NULL, -- 영웅ID
  hero_name character varying(50),
  type character varying(2),
  price character varying(20),
  mov_area integer, -- 이동범위
  force integer, -- 무력
  intellect integer,
  leadership integer, -- 통솔
  charm integer, -- 매력
  file_path character varying(100),
  CONSTRAINT sa_hero_pkey PRIMARY KEY (heroid )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE sa_hero
  OWNER TO jessica;
COMMENT ON TABLE sa_hero
  IS '영웅정보';
COMMENT ON COLUMN sa_hero.heroid IS '영웅ID';
COMMENT ON COLUMN sa_hero.mov_area IS '이동범위';
COMMENT ON COLUMN sa_hero.force IS '무력';
COMMENT ON COLUMN sa_hero.leadership IS '통솔';
COMMENT ON COLUMN sa_hero.charm IS '매력';

--맵정보
CREATE TABLE sa_map
(
  mapid serial NOT NULL,
  map_name character varying(100),
  width integer,
  height integer,
  file_path character varying(100),
  CONSTRAINT sa_map_pkey PRIMARY KEY (mapid )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE sa_map
  OWNER TO jessica;
  
--필드정보
CREATE TABLE sa_map_field
(
  mapid integer NOT NULL,
  gps_x integer NOT NULL,
  gps_y integer NOT NULL,
  geo_type character varying(10),
  CONSTRAINT sa_map_info_pkey PRIMARY KEY (mapid , gps_x , gps_y ),
  CONSTRAINT sa_map_info_mapid_fkey FOREIGN KEY (mapid)
      REFERENCES sa_map (mapid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE sa_map_field
  OWNER TO jessica;
