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
