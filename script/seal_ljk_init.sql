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

ALTER TABLE IF EXISTS ONLY public.sys_dict_item DROP CONSTRAINT IF EXISTS fk_type_id;
ALTER TABLE IF EXISTS ONLY public.sys_role_menu DROP CONSTRAINT IF EXISTS fk_role_id;
ALTER TABLE IF EXISTS ONLY public.sys_role_menu DROP CONSTRAINT IF EXISTS fk_menu_id;
ALTER TABLE IF EXISTS ONLY public.sys_user DROP CONSTRAINT IF EXISTS fk_channel_mark;
ALTER TABLE IF EXISTS ONLY public.tz_message_info DROP CONSTRAINT IF EXISTS tz_message_info_pkey;
ALTER TABLE IF EXISTS ONLY public.sys_user_role DROP CONSTRAINT IF EXISTS sys_user_role_pkey;
ALTER TABLE IF EXISTS ONLY public.sys_user DROP CONSTRAINT IF EXISTS sys_user_pkey;
ALTER TABLE IF EXISTS ONLY public.sys_task DROP CONSTRAINT IF EXISTS sys_task_pk;
ALTER TABLE IF EXISTS ONLY public.sys_role DROP CONSTRAINT IF EXISTS sys_role_pkey;
ALTER TABLE IF EXISTS ONLY public.sys_role_menu DROP CONSTRAINT IF EXISTS sys_role_menu_pkey;
ALTER TABLE IF EXISTS ONLY public.sys_partner DROP CONSTRAINT IF EXISTS sys_partner_pkey;
ALTER TABLE IF EXISTS ONLY public.sys_partner DROP CONSTRAINT IF EXISTS sys_partner_channel_mark_key;
ALTER TABLE IF EXISTS ONLY public.sys_menu DROP CONSTRAINT IF EXISTS sys_menu_pkey;
ALTER TABLE IF EXISTS ONLY public.sys_dict_type DROP CONSTRAINT IF EXISTS sys_dict_type_pkey;
ALTER TABLE IF EXISTS ONLY public.sys_dict_item DROP CONSTRAINT IF EXISTS sys_dict_item_pkey;
ALTER TABLE IF EXISTS ONLY public.sys_banner DROP CONSTRAINT IF EXISTS sys_banner_pk;
ALTER TABLE IF EXISTS ONLY public.tz_revenue DROP CONSTRAINT IF EXISTS pk_tz_revenue;
ALTER TABLE IF EXISTS ONLY public.tz_notice_info DROP CONSTRAINT IF EXISTS pk_tz_notice_info;
ALTER TABLE IF EXISTS ONLY public.tz_invest_item DROP CONSTRAINT IF EXISTS pk_tz_invest_item;
ALTER TABLE IF EXISTS ONLY public.tz_invest_info DROP CONSTRAINT IF EXISTS pk_tz_invest_info;
ALTER TABLE IF EXISTS ONLY public.tz_agency_hold DROP CONSTRAINT IF EXISTS pk_tz_agency_hold;
ALTER TABLE IF EXISTS ONLY public.gf_manage_mise DROP CONSTRAINT IF EXISTS pk_gf_manage_mise;
DROP TABLE IF EXISTS public.tz_revenue;
DROP TABLE IF EXISTS public.tz_notice_info;
DROP TABLE IF EXISTS public.tz_message_info;
DROP TABLE IF EXISTS public.tz_invest_item;
DROP TABLE IF EXISTS public.tz_invest_info;
DROP TABLE IF EXISTS public.tz_agency_hold;
DROP TABLE IF EXISTS public.sys_user_role;
DROP TABLE IF EXISTS public.sys_user;
DROP TABLE IF EXISTS public.sys_task;
DROP TABLE IF EXISTS public.sys_role_menu;
DROP TABLE IF EXISTS public.sys_role;
DROP TABLE IF EXISTS public.sys_partner;
DROP TABLE IF EXISTS public.sys_menu;
DROP TABLE IF EXISTS public.sys_dict_type;
DROP TABLE IF EXISTS public.sys_dict_item;
DROP TABLE IF EXISTS public.sys_banner;
DROP TABLE IF EXISTS public.gf_manage_mise;
DROP SCHEMA IF EXISTS public;
--
-- Name: public; Type: SCHEMA; Schema: -; Owner: edward
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO edward;

--
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: edward
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: gf_manage_mise; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.gf_manage_mise (
    id character varying(40) DEFAULT NULL::character varying NOT NULL,
    gf_code character varying(40) DEFAULT NULL::character varying,
    address text,
    remark text,
    create_user character varying(40) DEFAULT NULL::character varying,
    create_date timestamp(6) without time zone DEFAULT NULL::timestamp without time zone,
    update_user character varying(40) DEFAULT NULL::character varying,
    update_date timestamp(6) without time zone DEFAULT NULL::timestamp without time zone,
    functional_module character varying(40) DEFAULT NULL::character varying NOT NULL
);


ALTER TABLE public.gf_manage_mise OWNER TO postgres;

--
-- Name: TABLE gf_manage_mise; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.gf_manage_mise IS '管理员';


--
-- Name: COLUMN gf_manage_mise.gf_code; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.gf_manage_mise.gf_code IS '编号';


--
-- Name: COLUMN gf_manage_mise.address; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.gf_manage_mise.address IS '钱包地址';


--
-- Name: COLUMN gf_manage_mise.remark; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.gf_manage_mise.remark IS '备注';


--
-- Name: COLUMN gf_manage_mise.create_user; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.gf_manage_mise.create_user IS '创建人';


--
-- Name: COLUMN gf_manage_mise.create_date; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.gf_manage_mise.create_date IS '创建时间';


--
-- Name: COLUMN gf_manage_mise.update_user; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.gf_manage_mise.update_user IS '更新人';


--
-- Name: COLUMN gf_manage_mise.update_date; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.gf_manage_mise.update_date IS '更新时间';


--
-- Name: COLUMN gf_manage_mise.functional_module; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.gf_manage_mise.functional_module IS '功能模块(1 GF管理 2 收益管理 3高级转账)';


--
-- Name: sys_banner; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sys_banner (
    id character varying(36) DEFAULT NULL::character varying NOT NULL,
    title character varying(255) DEFAULT NULL::character varying,
    img_path character varying(255) DEFAULT NULL::character varying,
    link_url text,
    type character varying(10) DEFAULT NULL::character varying,
    status character(1) DEFAULT '0'::bpchar NOT NULL,
    create_user character varying(36) DEFAULT NULL::character varying,
    create_date timestamp(6) without time zone DEFAULT NULL::timestamp without time zone,
    update_user character varying(36) DEFAULT NULL::character varying,
    update_date timestamp(6) without time zone DEFAULT NULL::timestamp without time zone,
    sort integer DEFAULT 0,
    lang character varying(10) DEFAULT NULL::character varying
);


ALTER TABLE public.sys_banner OWNER TO postgres;

--
-- Name: COLUMN sys_banner.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_banner.id IS 'id';


--
-- Name: COLUMN sys_banner.title; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_banner.title IS '标题';


--
-- Name: COLUMN sys_banner.img_path; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_banner.img_path IS '路径';


--
-- Name: COLUMN sys_banner.link_url; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_banner.link_url IS '跳转地址';


--
-- Name: COLUMN sys_banner.type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_banner.type IS '业务类型，tz:通证';


--
-- Name: COLUMN sys_banner.status; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_banner.status IS '状态，1启用，0禁用';


--
-- Name: COLUMN sys_banner.create_user; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_banner.create_user IS '创建人';


--
-- Name: COLUMN sys_banner.create_date; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_banner.create_date IS '创建时间';


--
-- Name: COLUMN sys_banner.update_user; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_banner.update_user IS '更新人';


--
-- Name: COLUMN sys_banner.update_date; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_banner.update_date IS '更新时间';


--
-- Name: COLUMN sys_banner.lang; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_banner.lang IS '语言版本，ch中文，en英文';


--
-- Name: sys_dict_item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sys_dict_item (
    id character varying(64) DEFAULT NULL::character varying NOT NULL,
    value character varying(200) DEFAULT NULL::character varying NOT NULL,
    show_val character varying(510) DEFAULT NULL::character varying,
    remark character varying(200) DEFAULT NULL::character varying NOT NULL,
    type_id character varying(64) DEFAULT NULL::character varying NOT NULL,
    sort integer NOT NULL,
    create_user character varying(40) DEFAULT NULL::character varying,
    create_date timestamp(6) with time zone DEFAULT NULL::timestamp with time zone,
    update_user character varying(40) DEFAULT NULL::character varying,
    update_date timestamp(6) with time zone DEFAULT NULL::timestamp with time zone,
    del_flag character varying(2) DEFAULT '0'::character varying NOT NULL
);


ALTER TABLE public.sys_dict_item OWNER TO postgres;

--
-- Name: TABLE sys_dict_item; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.sys_dict_item IS '数据字典项目';


--
-- Name: COLUMN sys_dict_item.value; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_dict_item.value IS '真实值';


--
-- Name: COLUMN sys_dict_item.show_val; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_dict_item.show_val IS '显示值';


--
-- Name: COLUMN sys_dict_item.remark; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_dict_item.remark IS '描述';


--
-- Name: COLUMN sys_dict_item.type_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_dict_item.type_id IS '字典id';


--
-- Name: COLUMN sys_dict_item.sort; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_dict_item.sort IS '项目排序';


--
-- Name: COLUMN sys_dict_item.del_flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_dict_item.del_flag IS '删除标识(0为未删除1为已删除)';


--
-- Name: sys_dict_type; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sys_dict_type (
    id character varying(64) DEFAULT NULL::character varying NOT NULL,
    code character varying(510) DEFAULT NULL::character varying NOT NULL,
    name character varying(510) DEFAULT NULL::character varying NOT NULL,
    create_user character varying(64) DEFAULT NULL::character varying,
    create_date timestamp(6) with time zone DEFAULT NULL::timestamp with time zone,
    update_user character varying(64) DEFAULT NULL::character varying,
    update_date timestamp(6) with time zone DEFAULT NULL::timestamp with time zone,
    del_flag character varying(2) DEFAULT '0'::character varying NOT NULL,
    remark character varying(255) DEFAULT NULL::character varying
);


ALTER TABLE public.sys_dict_type OWNER TO postgres;

--
-- Name: TABLE sys_dict_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.sys_dict_type IS '数据字典类型';


--
-- Name: COLUMN sys_dict_type.code; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_dict_type.code IS '编码';


--
-- Name: COLUMN sys_dict_type.name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_dict_type.name IS '字典名称';


--
-- Name: COLUMN sys_dict_type.del_flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_dict_type.del_flag IS '删除标识';


--
-- Name: COLUMN sys_dict_type.remark; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_dict_type.remark IS '描述';


--
-- Name: sys_menu; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sys_menu (
    id character varying(64) DEFAULT NULL::character varying NOT NULL,
    parent_id character varying(64) DEFAULT NULL::character varying,
    menu_name character varying(60) DEFAULT NULL::character varying,
    url character varying(600) DEFAULT NULL::character varying,
    sort integer,
    flag integer,
    icon character varying(400) DEFAULT NULL::character varying,
    type integer,
    partner_types character varying(40) DEFAULT NULL::character varying,
    create_date timestamp(6) with time zone DEFAULT NULL::timestamp with time zone,
    create_user character varying(200) DEFAULT NULL::character varying,
    update_date timestamp(6) with time zone DEFAULT NULL::timestamp with time zone,
    update_user character varying(200) DEFAULT NULL::character varying,
    menu_id integer,
    menu_as character varying(100) DEFAULT NULL::character varying
);


ALTER TABLE public.sys_menu OWNER TO postgres;

--
-- Name: COLUMN sys_menu.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_menu.id IS '主键id';


--
-- Name: COLUMN sys_menu.parent_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_menu.parent_id IS '父菜单ID，一级菜单为0';


--
-- Name: COLUMN sys_menu.menu_name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_menu.menu_name IS '菜单名称';


--
-- Name: COLUMN sys_menu.url; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_menu.url IS '菜单对应的页面url';


--
-- Name: COLUMN sys_menu.sort; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_menu.sort IS '显示顺序';


--
-- Name: COLUMN sys_menu.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_menu.flag IS '是否有效';


--
-- Name: COLUMN sys_menu.icon; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_menu.icon IS '菜单对应的图标';


--
-- Name: COLUMN sys_menu.type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_menu.type IS '类型,0模块1菜单2按钮';


--
-- Name: COLUMN sys_menu.partner_types; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_menu.partner_types IS '根据合作方类型过滤菜单（如：1,2）';


--
-- Name: COLUMN sys_menu.create_date; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_menu.create_date IS '创建时间';


--
-- Name: COLUMN sys_menu.create_user; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_menu.create_user IS '创建人';


--
-- Name: COLUMN sys_menu.update_date; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_menu.update_date IS '修改时间';


--
-- Name: COLUMN sys_menu.update_user; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_menu.update_user IS '修改人';


--
-- Name: COLUMN sys_menu.menu_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_menu.menu_id IS '菜单id';


--
-- Name: COLUMN sys_menu.menu_as; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_menu.menu_as IS '模块名称';


--
-- Name: sys_partner; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sys_partner (
    id character varying(64) DEFAULT NULL::character varying NOT NULL,
    channel_mark character varying(100) DEFAULT NULL::character varying,
    partner_name character varying(200) DEFAULT NULL::character varying,
    user_no character varying(200) DEFAULT NULL::character varying,
    wallet_addr character varying(200) DEFAULT NULL::character varying,
    open_flag character varying(2) DEFAULT NULL::character varying,
    create_date timestamp(6) with time zone DEFAULT NULL::timestamp with time zone,
    create_user character varying(200) DEFAULT NULL::character varying,
    update_date timestamp(6) with time zone DEFAULT NULL::timestamp with time zone,
    update_user character varying(200) DEFAULT NULL::character varying,
    remark character varying(1000) DEFAULT NULL::character varying,
    partner_type character varying(2) DEFAULT '1'::character varying
);


ALTER TABLE public.sys_partner OWNER TO postgres;

--
-- Name: COLUMN sys_partner.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_partner.id IS '主键id';


--
-- Name: COLUMN sys_partner.channel_mark; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_partner.channel_mark IS '渠道标识，字典表';


--
-- Name: COLUMN sys_partner.partner_name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_partner.partner_name IS '合作方名称';


--
-- Name: COLUMN sys_partner.user_no; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_partner.user_no IS '用户标识';


--
-- Name: COLUMN sys_partner.wallet_addr; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_partner.wallet_addr IS '钱包地址';


--
-- Name: COLUMN sys_partner.open_flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_partner.open_flag IS '是否开启';


--
-- Name: COLUMN sys_partner.create_date; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_partner.create_date IS '创建时间';


--
-- Name: COLUMN sys_partner.create_user; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_partner.create_user IS '创建人';


--
-- Name: COLUMN sys_partner.update_date; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_partner.update_date IS '修改时间';


--
-- Name: COLUMN sys_partner.update_user; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_partner.update_user IS '修改人';


--
-- Name: COLUMN sys_partner.remark; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_partner.remark IS '备注';


--
-- Name: COLUMN sys_partner.partner_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_partner.partner_type IS '合作类型，0为最高级别（seal）';


--
-- Name: sys_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sys_role (
    id character varying(64) DEFAULT NULL::character varying NOT NULL,
    role_name character varying(200) DEFAULT NULL::character varying,
    role_desc text,
    create_date timestamp(6) with time zone DEFAULT NULL::timestamp with time zone,
    create_user character varying(200) DEFAULT NULL::character varying,
    update_date timestamp(6) with time zone DEFAULT NULL::timestamp with time zone,
    update_user character varying(200) DEFAULT NULL::character varying,
    channel_mark character varying(40) DEFAULT NULL::character varying NOT NULL
);


ALTER TABLE public.sys_role OWNER TO postgres;

--
-- Name: COLUMN sys_role.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_role.id IS '主键id';


--
-- Name: COLUMN sys_role.role_name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_role.role_name IS '角色名称';


--
-- Name: COLUMN sys_role.role_desc; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_role.role_desc IS '角色描述';


--
-- Name: COLUMN sys_role.create_date; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_role.create_date IS '创建时间';


--
-- Name: COLUMN sys_role.create_user; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_role.create_user IS '创建人';


--
-- Name: COLUMN sys_role.update_date; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_role.update_date IS '修改时间';


--
-- Name: COLUMN sys_role.update_user; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_role.update_user IS '修改人';


--
-- Name: COLUMN sys_role.channel_mark; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_role.channel_mark IS '合作方表示';


--
-- Name: sys_role_menu; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sys_role_menu (
    id character varying(64) DEFAULT NULL::character varying NOT NULL,
    role_id character varying(64) DEFAULT NULL::character varying,
    menu_id character varying(64) DEFAULT NULL::character varying
);


ALTER TABLE public.sys_role_menu OWNER TO postgres;

--
-- Name: COLUMN sys_role_menu.role_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_role_menu.role_id IS '角色id';


--
-- Name: COLUMN sys_role_menu.menu_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_role_menu.menu_id IS '菜单id';


--
-- Name: sys_task; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sys_task (
    id character varying(36) DEFAULT NULL::character varying NOT NULL,
    task_code character varying(200) DEFAULT NULL::character varying NOT NULL,
    task_name character varying(200) DEFAULT NULL::character varying NOT NULL,
    update_date timestamp(6) without time zone DEFAULT NULL::timestamp without time zone NOT NULL
);


ALTER TABLE public.sys_task OWNER TO postgres;

--
-- Name: TABLE sys_task; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.sys_task IS '任务信息表';


--
-- Name: COLUMN sys_task.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_task.id IS 'id';


--
-- Name: COLUMN sys_task.task_code; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_task.task_code IS '任务代码';


--
-- Name: COLUMN sys_task.task_name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_task.task_name IS '任务名称';


--
-- Name: COLUMN sys_task.update_date; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_task.update_date IS '更新时间';


--
-- Name: sys_user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sys_user (
    id character varying(64) DEFAULT NULL::character varying NOT NULL,
    username character varying(200) DEFAULT NULL::character varying,
    init_pass character varying(200) DEFAULT NULL::character varying NOT NULL,
    password character varying(200) DEFAULT NULL::character varying,
    channel_mark character varying(200) DEFAULT NULL::character varying,
    name character varying(200) DEFAULT NULL::character varying,
    phone character varying(200) DEFAULT NULL::character varying,
    email character varying(200) DEFAULT NULL::character varying,
    open_flag character varying(2) DEFAULT NULL::character varying,
    user_type character varying(2) DEFAULT NULL::character varying NOT NULL,
    create_date timestamp(6) with time zone DEFAULT NULL::timestamp with time zone,
    create_user character varying(200) DEFAULT NULL::character varying,
    update_date timestamp(6) with time zone DEFAULT NULL::timestamp with time zone,
    update_user character varying(200) DEFAULT NULL::character varying
);


ALTER TABLE public.sys_user OWNER TO postgres;

--
-- Name: COLUMN sys_user.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_user.id IS '主键id';


--
-- Name: COLUMN sys_user.username; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_user.username IS '用户名';


--
-- Name: COLUMN sys_user.init_pass; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_user.init_pass IS '初始明文密码';


--
-- Name: COLUMN sys_user.password; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_user.password IS '密文密码';


--
-- Name: COLUMN sys_user.channel_mark; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_user.channel_mark IS '渠道标识';


--
-- Name: COLUMN sys_user.name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_user.name IS '姓名';


--
-- Name: COLUMN sys_user.phone; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_user.phone IS '手机号';


--
-- Name: COLUMN sys_user.email; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_user.email IS '邮箱';


--
-- Name: COLUMN sys_user.open_flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_user.open_flag IS '是否开启   0为是 1为否';


--
-- Name: COLUMN sys_user.user_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_user.user_type IS '用户类型，0超级管理员，1普通管理员，2普通用户';


--
-- Name: COLUMN sys_user.create_date; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_user.create_date IS '创建时间';


--
-- Name: COLUMN sys_user.create_user; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_user.create_user IS '创建人';


--
-- Name: COLUMN sys_user.update_date; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_user.update_date IS '修改时间';


--
-- Name: COLUMN sys_user.update_user; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_user.update_user IS '修改人';


--
-- Name: sys_user_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sys_user_role (
    id character varying(64) DEFAULT NULL::character varying NOT NULL,
    partner_id character varying(64) DEFAULT NULL::character varying,
    user_id character varying(64) DEFAULT NULL::character varying,
    role_id character varying(64) DEFAULT NULL::character varying,
    role_code character varying(100) DEFAULT NULL::character varying,
    create_date timestamp(6) with time zone DEFAULT NULL::timestamp with time zone,
    update_date timestamp(6) with time zone DEFAULT NULL::timestamp with time zone,
    create_user character varying(200) DEFAULT NULL::character varying,
    update_user character varying(200) DEFAULT NULL::character varying
);


ALTER TABLE public.sys_user_role OWNER TO postgres;

--
-- Name: COLUMN sys_user_role.partner_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_user_role.partner_id IS '合作方id';


--
-- Name: COLUMN sys_user_role.user_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_user_role.user_id IS '用户ID';


--
-- Name: COLUMN sys_user_role.role_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_user_role.role_id IS '角色ID';


--
-- Name: COLUMN sys_user_role.role_code; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_user_role.role_code IS '角色编码';


--
-- Name: COLUMN sys_user_role.create_date; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_user_role.create_date IS '创建时间';


--
-- Name: tz_agency_hold; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tz_agency_hold (
    id character varying(40) DEFAULT NULL::character varying NOT NULL,
    item_id character varying(40) DEFAULT NULL::character varying,
    mobile character varying(11) DEFAULT NULL::character varying,
    token_number numeric(12,4) DEFAULT NULL::numeric,
    price numeric(12,4) DEFAULT NULL::numeric,
    account character varying(255) DEFAULT NULL::character varying,
    create_date timestamp(6) without time zone DEFAULT NULL::timestamp without time zone,
    create_user character varying(40) DEFAULT NULL::character varying,
    update_date timestamp(6) without time zone DEFAULT NULL::timestamp without time zone,
    update_user character varying(40) DEFAULT NULL::character varying,
    area_code character varying(40) DEFAULT NULL::character varying,
    type character(1) DEFAULT NULL::bpchar,
    current_holdings numeric(12,4) DEFAULT NULL::numeric,
    remark character varying(255) DEFAULT NULL::character varying,
    token_name character varying(255) DEFAULT NULL::character varying,
    seal_account character varying(255) DEFAULT NULL::character varying
);


ALTER TABLE public.tz_agency_hold OWNER TO postgres;

--
-- Name: TABLE tz_agency_hold; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.tz_agency_hold IS '代持';


--
-- Name: COLUMN tz_agency_hold.item_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_agency_hold.item_id IS '投资项目id';


--
-- Name: COLUMN tz_agency_hold.mobile; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_agency_hold.mobile IS '用户手机号';


--
-- Name: COLUMN tz_agency_hold.token_number; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_agency_hold.token_number IS 'token数量';


--
-- Name: COLUMN tz_agency_hold.price; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_agency_hold.price IS '单价';


--
-- Name: COLUMN tz_agency_hold.account; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_agency_hold.account IS 'account账户';


--
-- Name: COLUMN tz_agency_hold.create_date; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_agency_hold.create_date IS '创建时间';


--
-- Name: COLUMN tz_agency_hold.create_user; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_agency_hold.create_user IS '创建人';


--
-- Name: COLUMN tz_agency_hold.update_date; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_agency_hold.update_date IS '更新时间';


--
-- Name: COLUMN tz_agency_hold.update_user; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_agency_hold.update_user IS '更新人';


--
-- Name: COLUMN tz_agency_hold.area_code; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_agency_hold.area_code IS '区号';


--
-- Name: COLUMN tz_agency_hold.type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_agency_hold.type IS '类型(0代持转入1代持转出)';


--
-- Name: COLUMN tz_agency_hold.current_holdings; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_agency_hold.current_holdings IS '当前持有量 ';


--
-- Name: COLUMN tz_agency_hold.remark; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_agency_hold.remark IS '备注';


--
-- Name: COLUMN tz_agency_hold.token_name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_agency_hold.token_name IS 'token名称';


--
-- Name: COLUMN tz_agency_hold.seal_account; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_agency_hold.seal_account IS '账户(Seal代持)';


--
-- Name: tz_invest_info; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tz_invest_info (
    id character varying(40) DEFAULT NULL::character varying NOT NULL,
    item_id character varying(40) DEFAULT NULL::character varying,
    area_code character varying(40) DEFAULT NULL::character varying,
    mobile character varying(11) DEFAULT NULL::character varying,
    buy_number numeric(12,4) DEFAULT NULL::numeric,
    buy_amount numeric(24,4) DEFAULT NULL::numeric,
    status character(1) DEFAULT NULL::bpchar,
    remarks text,
    type character(1) DEFAULT NULL::bpchar,
    create_date timestamp(6) without time zone DEFAULT now(),
    create_user character varying(40) DEFAULT NULL::character varying,
    update_date timestamp(6) without time zone DEFAULT now(),
    update_user character varying(40) DEFAULT NULL::character varying,
    account character varying(255) DEFAULT NULL::character varying,
    lang character varying(10) DEFAULT NULL::character varying,
    curr_price numeric(12,4) DEFAULT NULL::numeric
);


ALTER TABLE public.tz_invest_info OWNER TO postgres;

--
-- Name: TABLE tz_invest_info; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.tz_invest_info IS '投资信息';


--
-- Name: COLUMN tz_invest_info.item_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_info.item_id IS '投资项目id';


--
-- Name: COLUMN tz_invest_info.area_code; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_info.area_code IS '区号';


--
-- Name: COLUMN tz_invest_info.mobile; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_info.mobile IS '联系电话';


--
-- Name: COLUMN tz_invest_info.buy_number; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_info.buy_number IS '购买数量';


--
-- Name: COLUMN tz_invest_info.buy_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_info.buy_amount IS '购买金额';


--
-- Name: COLUMN tz_invest_info.status; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_info.status IS '状态(1买入申请2买入成功3买入失败4卖出申请5卖出成功6卖出失败7回购申请8回购失败9回购成功)';


--
-- Name: COLUMN tz_invest_info.remarks; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_info.remarks IS '备注';


--
-- Name: COLUMN tz_invest_info.type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_info.type IS '类型(1买入2卖出3回购)';


--
-- Name: COLUMN tz_invest_info.create_date; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_info.create_date IS '创建时间';


--
-- Name: COLUMN tz_invest_info.create_user; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_info.create_user IS '创建人';


--
-- Name: COLUMN tz_invest_info.update_date; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_info.update_date IS '更新时间';


--
-- Name: COLUMN tz_invest_info.update_user; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_info.update_user IS '更新人';


--
-- Name: COLUMN tz_invest_info.account; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_info.account IS '主链帐号';


--
-- Name: COLUMN tz_invest_info.lang; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_info.lang IS '使用语言';


--
-- Name: COLUMN tz_invest_info.curr_price; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_info.curr_price IS '下单时价格';


--
-- Name: tz_invest_item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tz_invest_item (
    id character varying(40) DEFAULT NULL::character varying NOT NULL,
    token_name character varying(255) DEFAULT NULL::character varying,
    token_short_name character varying(255) DEFAULT NULL::character varying,
    img_path character varying(255) DEFAULT NULL::character varying,
    expected_venue numeric(24,4) DEFAULT NULL::numeric,
    issue_amount numeric(24,4) DEFAULT NULL::numeric,
    allowance numeric(24,4) DEFAULT NULL::numeric,
    issue_price numeric(24,4) DEFAULT NULL::numeric,
    issue_time date,
    total_house_number numeric(24,4) DEFAULT NULL::numeric,
    rent_out_number numeric(20,4) DEFAULT NULL::numeric,
    sell_number numeric(24,4) DEFAULT NULL::numeric,
    using_flag character(1) DEFAULT NULL::bpchar,
    account character varying(255) DEFAULT NULL::character varying,
    create_date timestamp(6) without time zone DEFAULT NULL::timestamp without time zone,
    create_user character varying(40) DEFAULT NULL::character varying,
    update_date timestamp(6) without time zone DEFAULT NULL::timestamp without time zone,
    update_user character varying(40) DEFAULT NULL::character varying,
    issue_company character varying(255) DEFAULT NULL::character varying,
    token_identity character varying(255) DEFAULT NULL::character varying,
    tx_rule text,
    asset_details text,
    company_info text,
    issue_company_en character varying(255) DEFAULT NULL::character varying,
    token_identity_en character varying(255) DEFAULT NULL::character varying,
    tx_rule_en text,
    asset_details_en text,
    company_info_en text,
    asset_short character varying(255) DEFAULT NULL::character varying,
    asset_short_en character varying(255) DEFAULT NULL::character varying,
    token_no character varying(255) DEFAULT NULL::character varying,
    income_statement character varying(255) DEFAULT NULL::character varying,
    income_statement_en character varying(255) DEFAULT NULL::character varying,
    exchange_rate numeric(12,4) DEFAULT NULL::numeric
);


ALTER TABLE public.tz_invest_item OWNER TO postgres;

--
-- Name: TABLE tz_invest_item; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.tz_invest_item IS '投资项目';


--
-- Name: COLUMN tz_invest_item.token_name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_item.token_name IS 'token名称';


--
-- Name: COLUMN tz_invest_item.token_short_name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_item.token_short_name IS 'token简称';


--
-- Name: COLUMN tz_invest_item.img_path; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_item.img_path IS '图片地址';


--
-- Name: COLUMN tz_invest_item.expected_venue; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_item.expected_venue IS '预期收益';


--
-- Name: COLUMN tz_invest_item.issue_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_item.issue_amount IS '发行总量';


--
-- Name: COLUMN tz_invest_item.allowance; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_item.allowance IS '余量';


--
-- Name: COLUMN tz_invest_item.issue_price; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_item.issue_price IS '发行单价';


--
-- Name: COLUMN tz_invest_item.issue_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_item.issue_time IS '发行时间';


--
-- Name: COLUMN tz_invest_item.total_house_number; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_item.total_house_number IS '总房产数量';


--
-- Name: COLUMN tz_invest_item.rent_out_number; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_item.rent_out_number IS '已出租房产数量';


--
-- Name: COLUMN tz_invest_item.sell_number; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_item.sell_number IS '已出售房产数量';


--
-- Name: COLUMN tz_invest_item.using_flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_item.using_flag IS '是否启用';


--
-- Name: COLUMN tz_invest_item.account; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_item.account IS '钱包账户';


--
-- Name: COLUMN tz_invest_item.create_date; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_item.create_date IS '创建时间';


--
-- Name: COLUMN tz_invest_item.create_user; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_item.create_user IS '创建人';


--
-- Name: COLUMN tz_invest_item.update_date; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_item.update_date IS '更新时间';


--
-- Name: COLUMN tz_invest_item.update_user; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_item.update_user IS '更新人';


--
-- Name: COLUMN tz_invest_item.issue_company; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_item.issue_company IS '发行公司';


--
-- Name: COLUMN tz_invest_item.token_identity; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_item.token_identity IS 'token特点';


--
-- Name: COLUMN tz_invest_item.tx_rule; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_item.tx_rule IS '交易及收益规则';


--
-- Name: COLUMN tz_invest_item.asset_details; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_item.asset_details IS '资产详情';


--
-- Name: COLUMN tz_invest_item.company_info; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_item.company_info IS '公司介绍';


--
-- Name: COLUMN tz_invest_item.issue_company_en; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_item.issue_company_en IS '发行公司en';


--
-- Name: COLUMN tz_invest_item.token_identity_en; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_item.token_identity_en IS 'token特点en';


--
-- Name: COLUMN tz_invest_item.tx_rule_en; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_item.tx_rule_en IS '交易及收益规则en';


--
-- Name: COLUMN tz_invest_item.asset_details_en; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_item.asset_details_en IS '资产详情en';


--
-- Name: COLUMN tz_invest_item.company_info_en; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_item.company_info_en IS '公司介绍en';


--
-- Name: COLUMN tz_invest_item.asset_short; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_item.asset_short IS '资产简称';


--
-- Name: COLUMN tz_invest_item.asset_short_en; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_item.asset_short_en IS '资产简称en';


--
-- Name: COLUMN tz_invest_item.token_no; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_item.token_no IS 'token编号';


--
-- Name: COLUMN tz_invest_item.income_statement; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_item.income_statement IS '一句话收益说明';


--
-- Name: COLUMN tz_invest_item.income_statement_en; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_item.income_statement_en IS '一句话收益说明en';


--
-- Name: COLUMN tz_invest_item.exchange_rate; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_invest_item.exchange_rate IS '汇率';


--
-- Name: tz_message_info; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tz_message_info (
    id character varying(40) DEFAULT NULL::character varying NOT NULL,
    type character(1) DEFAULT NULL::bpchar,
    content text,
    create_date timestamp(6) without time zone DEFAULT now(),
    read_status character(1) DEFAULT 0,
    update_date timestamp(6) without time zone DEFAULT now(),
    mobile character varying(255) DEFAULT NULL::character varying,
    account character varying(255) DEFAULT NULL::character varying,
    title character varying(255) DEFAULT NULL::character varying,
    item_id character varying(255) DEFAULT NULL::character varying
);


ALTER TABLE public.tz_message_info OWNER TO postgres;

--
-- Name: TABLE tz_message_info; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.tz_message_info IS '通知';


--
-- Name: COLUMN tz_message_info.type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_message_info.type IS '通知类型';


--
-- Name: COLUMN tz_message_info.content; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_message_info.content IS '通知内容';


--
-- Name: COLUMN tz_message_info.create_date; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_message_info.create_date IS '创建时间';


--
-- Name: COLUMN tz_message_info.read_status; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_message_info.read_status IS '是否已读';


--
-- Name: COLUMN tz_message_info.update_date; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_message_info.update_date IS '更新时间';


--
-- Name: COLUMN tz_message_info.mobile; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_message_info.mobile IS '手机号';


--
-- Name: COLUMN tz_message_info.account; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_message_info.account IS '主链account';


--
-- Name: COLUMN tz_message_info.title; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_message_info.title IS '通知标题';


--
-- Name: COLUMN tz_message_info.item_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_message_info.item_id IS '关联tokenid';


--
-- Name: tz_notice_info; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tz_notice_info (
    id character varying(40) DEFAULT NULL::character varying NOT NULL,
    notice_title character varying(255) DEFAULT NULL::character varying,
    notice_content text,
    type character varying(40) DEFAULT NULL::character varying,
    using_flag character(1) DEFAULT NULL::bpchar,
    create_user character varying(40) DEFAULT NULL::character varying,
    create_date timestamp(6) without time zone DEFAULT NULL::timestamp without time zone,
    update_user character varying(40) DEFAULT NULL::character varying,
    update_date timestamp(6) without time zone DEFAULT NULL::timestamp without time zone,
    notice_title_en character varying(255) DEFAULT NULL::character varying,
    notice_content_en text,
    type_en character varying(40) DEFAULT NULL::character varying
);


ALTER TABLE public.tz_notice_info OWNER TO postgres;

--
-- Name: TABLE tz_notice_info; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.tz_notice_info IS '公告';


--
-- Name: COLUMN tz_notice_info.notice_title; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_notice_info.notice_title IS '公告标题';


--
-- Name: COLUMN tz_notice_info.notice_content; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_notice_info.notice_content IS '公告内容';


--
-- Name: COLUMN tz_notice_info.type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_notice_info.type IS '公告类型';


--
-- Name: COLUMN tz_notice_info.using_flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_notice_info.using_flag IS '是否启用';


--
-- Name: COLUMN tz_notice_info.create_user; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_notice_info.create_user IS '创建人';


--
-- Name: COLUMN tz_notice_info.create_date; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_notice_info.create_date IS '创建时间';


--
-- Name: COLUMN tz_notice_info.update_user; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_notice_info.update_user IS '更新人';


--
-- Name: COLUMN tz_notice_info.update_date; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_notice_info.update_date IS '更新时间';


--
-- Name: tz_revenue; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tz_revenue (
    id character varying(40) DEFAULT NULL::character varying NOT NULL,
    item_id character varying(40) DEFAULT NULL::character varying,
    total_revenue numeric(8,4) DEFAULT NULL::numeric,
    revenue_type character(1) DEFAULT NULL::bpchar,
    revenue_date date,
    status character(1) DEFAULT NULL::bpchar,
    create_user character varying(40) DEFAULT NULL::character varying,
    create_date timestamp(6) without time zone DEFAULT NULL::timestamp without time zone,
    update_user character varying(40) DEFAULT NULL::character varying,
    update_date timestamp(6) without time zone DEFAULT NULL::timestamp without time zone,
    pre_revenue numeric(8,4) DEFAULT NULL::numeric
);


ALTER TABLE public.tz_revenue OWNER TO postgres;

--
-- Name: TABLE tz_revenue; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.tz_revenue IS '总收益';


--
-- Name: COLUMN tz_revenue.item_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_revenue.item_id IS '投资项目id';


--
-- Name: COLUMN tz_revenue.total_revenue; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_revenue.total_revenue IS '总收益';


--
-- Name: COLUMN tz_revenue.revenue_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_revenue.revenue_type IS '收益类型,0租金分红,1出售分润';


--
-- Name: COLUMN tz_revenue.revenue_date; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_revenue.revenue_date IS '日期';


--
-- Name: COLUMN tz_revenue.status; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_revenue.status IS '状态，0未支付，1已支付';


--
-- Name: COLUMN tz_revenue.create_user; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_revenue.create_user IS '创建人';


--
-- Name: COLUMN tz_revenue.create_date; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_revenue.create_date IS '创建时间';


--
-- Name: COLUMN tz_revenue.update_user; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_revenue.update_user IS '更新人';


--
-- Name: COLUMN tz_revenue.update_date; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_revenue.update_date IS '更新时间';


--
-- Name: COLUMN tz_revenue.pre_revenue; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.tz_revenue.pre_revenue IS '每份收益';


--
-- Data for Name: gf_manage_mise; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: sys_banner; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: sys_dict_item; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.sys_dict_item VALUES ('c330b67f565d4d188e1fdb14871b5251', '0', '代持转入', '代持类型 - 代持转入', 'cfce281fb1b44fd295df08bdb987ccfc', 0, '2776cd3a081011e9bd39fa163e168207', '2019-01-04 13:35:42.107163+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 13:35:42.107163+08', '0');
INSERT INTO public.sys_dict_item VALUES ('f3d657d4690544a290b81a5afcda167b', '1', '代持转出', '代持类型- 代持转出', 'cfce281fb1b44fd295df08bdb987ccfc', 0, '2776cd3a081011e9bd39fa163e168207', '2019-01-04 13:35:53.948963+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 13:35:53.948963+08', '0');
INSERT INTO public.sys_dict_item VALUES ('660204f07dbf485bb028c20bc2c3b650', '1', 'GF管理', '管理员功能模块 - GF管理', '3184dd7f145e4b16b8dd10c1e0f8f052', 0, '2776cd3a081011e9bd39fa163e168207', '2019-01-04 13:41:49.286317+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 13:41:49.286317+08', '0');
INSERT INTO public.sys_dict_item VALUES ('5127c51425984a15a0dbdb35eb988352', '2', '收益管理', '管理员功能模块 - 收益管理', '3184dd7f145e4b16b8dd10c1e0f8f052', 0, '2776cd3a081011e9bd39fa163e168207', '2019-01-04 13:42:06.30707+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 13:42:06.30707+08', '0');
INSERT INTO public.sys_dict_item VALUES ('012673b78a5e48eea1b245e720d6c975', '2', '高级转账', '管理员功能模块 - 高级转账', '3184dd7f145e4b16b8dd10c1e0f8f052', 0, '2776cd3a081011e9bd39fa163e168207', '2019-01-04 13:42:18.898878+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 13:42:18.898878+08', '0');
INSERT INTO public.sys_dict_item VALUES ('5bd2766dd80f4fc6b231201d531ff014', '0', '超级管理员', '', 'ddd944cf9b9c4e0ba3d06d4c747df72a', 0, '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:49:44.703202+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:49:44.703202+08', '0');
INSERT INTO public.sys_dict_item VALUES ('8fa8c794db7c46febd21cf1b9c73e61c', '001', '公告', '公告类型', 'bc600652bc354bfeae0cdb9d4686efd3', 0, '2776cd3a081011e9bd39fa163e168207', '2019-01-04 10:54:26.154712+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 10:54:26.154712+08', '0');
INSERT INTO public.sys_dict_item VALUES ('26236c8e103f4744891a499d29b64d3b', '2', '买出', '投资信息类型 - 卖出', '1cb1827fa1244937a89adc3ddd11671b', 0, '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:42:30.393573+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:42:30.393573+08', '0');
INSERT INTO public.sys_dict_item VALUES ('ffa80867d95745a9bd06b3e8b7dd70be', '3', '回购', '投资信息类型 - 回购', '1cb1827fa1244937a89adc3ddd11671b', 0, '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:42:48.662901+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:42:48.662901+08', '0');
INSERT INTO public.sys_dict_item VALUES ('d60f5462d7d54a0ea79dbf270837f3da', '1', '买入', '投资信息类型 - 买入', '1cb1827fa1244937a89adc3ddd11671b', 0, '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:37:28.388475+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:37:28.388475+08', '0');
INSERT INTO public.sys_dict_item VALUES ('dd90f4a7519641db841f76684588ad66', '1', '买入申请', '投资信息状态 - 买入申请', 'ccba7e6bc58a4a95802275b5c520e82a', 0, '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:46:07.127057+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:46:07.127057+08', '0');
INSERT INTO public.sys_dict_item VALUES ('1bcc40ae65d247828d9b995de025f13c', '2', '买入成功', '投资信息状态 - 买入成功', 'ccba7e6bc58a4a95802275b5c520e82a', 0, '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:46:27.436604+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:46:27.436604+08', '0');
INSERT INTO public.sys_dict_item VALUES ('544a21a9714340dcb027a21a285ae6d9', '3', '买入失败', '投资信息状态 - 买入失败', 'ccba7e6bc58a4a95802275b5c520e82a', 0, '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:46:39.029304+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:46:39.029304+08', '0');
INSERT INTO public.sys_dict_item VALUES ('fafc64d944c64853a9ddfd8d099037d8', '4', '卖出申请', '投资信息状态 - 卖出申请', 'ccba7e6bc58a4a95802275b5c520e82a', 0, '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:47:11.766935+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:47:11.766935+08', '0');
INSERT INTO public.sys_dict_item VALUES ('9aad707ca4ca478ab638c89d35e270b7', '5', '卖出成功', '投资信息状态 - 卖出成功', 'ccba7e6bc58a4a95802275b5c520e82a', 0, '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:47:21.532989+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:47:21.532989+08', '0');
INSERT INTO public.sys_dict_item VALUES ('9145af97acdb4300ae8313fab5702715', '6', '卖出失败', '投资信息状态 - 卖出失败', 'ccba7e6bc58a4a95802275b5c520e82a', 0, '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:47:29.652665+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:47:29.652665+08', '0');
INSERT INTO public.sys_dict_item VALUES ('e23a4a7e1928435c8c427afe2fe4ac83', '7', '回购申请', '投资信息状态 - 回购申请', 'ccba7e6bc58a4a95802275b5c520e82a', 0, '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:48:55.645065+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:48:55.645065+08', '0');
INSERT INTO public.sys_dict_item VALUES ('30f6349fdc7140348a6ff92886278831', '8', '回购成功', '投资信息状态 - 回购成功', 'ccba7e6bc58a4a95802275b5c520e82a', 0, '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:49:27.026949+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:49:27.026949+08', '0');
INSERT INTO public.sys_dict_item VALUES ('5bd2766fd80f4fc6b231201d531ff014', '9', '回购失败', '投资信息状态 - 回购失败', 'ccba7e6bc58a4a95802275b5c520e82a', 0, '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:49:44.703202+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:49:44.703202+08', '0');
INSERT INTO public.sys_dict_item VALUES ('5bd2766dd80f4fc6b231201d531ff015', '1', '合作方管理员', '', 'ddd944cf9b9c4e0ba3d06d4c747df72a', 1, '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:49:44.703202+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:49:44.703202+08', '0');
INSERT INTO public.sys_dict_item VALUES ('5bd2766dd80f4fc6b231201d531ff016', '2', '普通用户', '', 'ddd944cf9b9c4e0ba3d06d4c747df72a', 2, '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:49:44.703202+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:49:44.703202+08', '0');
INSERT INTO public.sys_dict_item VALUES ('ddd944cf9b9c4ccba3d06d4c747df001', '0', '关闭', '', 'ddd944cf9b9c4ccba3d06d4c747df72a', 2, '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:49:44.703202+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:49:44.703202+08', '0');
INSERT INTO public.sys_dict_item VALUES ('ddd944cf9b9c4ccba3d06d4c747df002', '1', '开启', '', 'ddd944cf9b9c4ccba3d06d4c747df72a', 2, '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:49:44.703202+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:49:44.703202+08', '0');
INSERT INTO public.sys_dict_item VALUES ('666944cf9b9c4ccba3d06d4c747dfddd', '0', '内部合作方', '', 'ddd944cf9b9c4ccba3d06d4c747dfddd', 2, '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:49:44.703202+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:49:44.703202+08', '0');
INSERT INTO public.sys_dict_item VALUES ('666944cf9b9c4ccba3d06d4c747dfdbb', '1', '外部合作方', '', 'ddd944cf9b9c4ccba3d06d4c747dfddd', 2, '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:49:44.703202+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:49:44.703202+08', '0');
INSERT INTO public.sys_dict_item VALUES ('3226cd3a081011e9bd39fa163e1682c1', '0', '租金分红', '', '3226cd3a081011e9bd39fa163e168207', 2, '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:49:44.703202+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:49:44.703202+08', '0');
INSERT INTO public.sys_dict_item VALUES ('3226cd3a081011e9bd39fa163e1682c2', '1', '出售分红', '', '3226cd3a081011e9bd39fa163e168207', 2, '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:49:44.703202+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:49:44.703202+08', '0');
INSERT INTO public.sys_dict_item VALUES ('e11af81b061441eabf07186cf66dde21', '001', '简体中文', '简体中文', 'b02944cf9b9c4e0ba3d06d4c747df72a', 0, '2776cd3a081011e9bd39fa163e168207', '2019-01-08 20:33:34.694483+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-08 20:33:34.694483+08', '0');
INSERT INTO public.sys_dict_item VALUES ('7c0e428801654107987a28ead914ceaa', '001', '贷款申请', '用户提交申请贷款的后', 'fec08f87df0546aa9889c9899b943cff', 0, '2776cd3a081011e9bd39fa163e168207', '2019-01-08 20:36:27.382481+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-08 20:36:27.382481+08', '0');


--
-- Data for Name: sys_dict_type; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.sys_dict_type VALUES ('bc600652bc354bfeae0cdb9d4686efd3', 'noticeType', '公告类型', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 10:50:43.157581+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-08 20:39:12.38826+08', '1', '公告类型');
INSERT INTO public.sys_dict_type VALUES ('050e7327e81e447ea88b9ae8a8d8a40b', 'ewq', '小测试咯', '2776cd3a081011e9bd39fa163e168207', '2019-01-10 18:02:25.984443+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-10 18:02:25.984443+08', '0', '呵呵');
INSERT INTO public.sys_dict_type VALUES ('1cb1827fa1244937a89adc3ddd11671b', 'investInfoType', '投资信息类型', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:34:27.621416+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:34:27.621416+08', '0', NULL);
INSERT INTO public.sys_dict_type VALUES ('ccba7e6bc58a4a95802275b5c520e82a', 'investInfoStatus', '投资信息状态', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:44:06.669553+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 11:44:06.669553+08', '0', NULL);
INSERT INTO public.sys_dict_type VALUES ('cfce281fb1b44fd295df08bdb987ccfc', 'agencyHoldType', '代持状态', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 13:34:18.617863+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 13:34:18.617863+08', '0', NULL);
INSERT INTO public.sys_dict_type VALUES ('ddd944cf9b9c4ccba3d06d4c747dfddd', 'partnerType', '合作方类型', '2776cd3a081011e9bd39fa163e168207', '2019-01-03 20:23:49.053596+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-07 11:10:03.305565+08', '0', NULL);
INSERT INTO public.sys_dict_type VALUES ('3226cd3a081011e9bd39fa163e168207', 'revenueType', '分红类型', '2776cd3a081011e9bd39fa163e168207', '2019-01-03 20:23:49.053596+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-08 20:32:49.268863+08', '1', NULL);
INSERT INTO public.sys_dict_type VALUES ('ddd944cf9b9c4ccba3d06d4c747df72a', 'openFlag', '开关状态', '2776cd3a081011e9bd39fa163e168207', '2019-01-03 20:23:49.053596+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-08 20:32:50.860841+08', '1', NULL);
INSERT INTO public.sys_dict_type VALUES ('ddd944cf9b9c4e0ba3d06d4c747df72a', 'userType', '用户类型', '2776cd3a081011e9bd39fa163e168207', '2019-01-03 20:23:49.053596+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-08 20:32:52.014434+08', '1', NULL);
INSERT INTO public.sys_dict_type VALUES ('3184dd7f145e4b16b8dd10c1e0f8f052', 'gfMagMiseFuncMod', '管理员功能模块', '2776cd3a081011e9bd39fa163e168207', '2019-01-04 13:39:48.7077+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-08 20:33:00.439208+08', '1', NULL);
INSERT INTO public.sys_dict_type VALUES ('fec08f87df0546aa9889c9899b943cff', '001', '贷款状态', '2776cd3a081011e9bd39fa163e168207', '2019-01-08 20:35:38.664158+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-08 20:35:43.119025+08', '0', '本类型用于描述贷款的各种状态');
INSERT INTO public.sys_dict_type VALUES ('b02944cf9b9c4e0ba3d06d4c747df72a', 'language', '语言类型', '2776cd3a081011e9bd39fa163e168207', '2019-01-03 20:23:49.053596+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-08 20:38:17.403416+08', '1', NULL);
INSERT INTO public.sys_dict_type VALUES ('90abc3d7798a4e9da59c2d37f9ad9001', 'type', '公告类型', '2776cd3a081011e9bd39fa163e168207', '2019-01-08 20:38:45.698624+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-08 20:39:08.887855+08', '0', '公告类型');


--
-- Data for Name: sys_menu; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.sys_menu VALUES ('9ad5de8c8cf24d8babea2fae3797ac02', '9ad5de8c8cf24d8babea2fae3797ac1f', '融资管理', '/financemanage', 1, 1, '', 1, '0,1', '2019-01-04 10:06:11.702517+08', NULL, '2019-01-04 10:06:11.702517+08', NULL, 102, 'financeManage');
INSERT INTO public.sys_menu VALUES ('525abc902af840b984173cdefe6f2544', '0', '首页', '/', 0, 1, '', 0, '0,1', '2019-01-04 10:06:11.699159+08', NULL, '2019-01-04 10:06:11.699159+08', NULL, 0, 'home');
INSERT INTO public.sys_menu VALUES ('9ad5de8c8cf24d8babea2fae3797ac1f', '0', '链上数据', '/datachain', 1, 1, '', 0, '0,1', '2019-01-04 10:06:11.702517+08', NULL, '2019-01-04 10:06:11.702517+08', NULL, 1, 'dataChain');
INSERT INTO public.sys_menu VALUES ('9ad5de8c8cf24d8babea2fae3797ac23', '9ad5de8c8cf24d8babea2fae3797ac02', '投资信息', '/datachain/financemanage/riskmanage', 2, 1, '', 1, '0,1', '2019-01-04 10:06:11.702517+08', NULL, '2019-01-04 10:06:11.702517+08', NULL, 10203, 'riskManage');
INSERT INTO public.sys_menu VALUES ('9ad5de8c8cf24d8babea2fae3797ac01', '9ad5de8c8cf24d8babea2fae3797ac1f', '客户管理', '/clientmanage', 0, 1, '', 1, '0,1', '2019-01-04 10:06:11.702517+08', NULL, '2019-01-04 10:06:11.702517+08', NULL, 101, 'clientManage');
INSERT INTO public.sys_menu VALUES ('9ad5de8c8cf24d8babea2fae3797ac03', '9ad5de8c8cf24d8babea2fae3797ac1f', '数据验证', '/datavalidation', 2, 1, '', 1, '0,1', '2019-01-04 10:06:11.702517+08', NULL, '2019-01-04 10:06:11.702517+08', NULL, 103, 'dataValidation');
INSERT INTO public.sys_menu VALUES ('9ad5de8c8cf24d8babea2fae3797ac04', '9ad5de8c8cf24d8babea2fae3797ac1f', '统计分析', '/statistics', 3, 1, '', 1, '0,1', '2019-01-04 10:06:11.702517+08', NULL, '2019-01-04 10:06:11.702517+08', NULL, 104, 'statistics');
INSERT INTO public.sys_menu VALUES ('4c0872cfeabc4dbc849d06dd6abcbfae11', '4c0872cfeabc4dbc849d06dd6abcbfae01', '项目信息', '/financeinvestment/project/index', 0, 1, '', 1, '0,1', '2019-01-04 10:06:11.702517+08', NULL, '2019-01-04 10:06:11.702517+08', NULL, 20101, 'projectIndex');
INSERT INTO public.sys_menu VALUES ('4c0872cfeabc4dbc849d06dd6abcbfae01', '3c0872cfeabc4dbc849d06dd0abcbfae', '项目管理', '/project', 0, 1, '', 1, '0,1', '2019-01-04 10:06:11.702517+08', NULL, '2019-01-04 10:06:11.702517+08', NULL, 201, 'project');
INSERT INTO public.sys_menu VALUES ('3c0872cfeabc4dbc849d06dd0abcbfae', '0', '投资理财', '/financeinvestment', 2, 1, '', 0, '0,1', '2019-01-04 10:06:11.705369+08', NULL, '2019-01-04 10:06:11.705369+08', NULL, 2, 'financeInvestment');
INSERT INTO public.sys_menu VALUES ('4c0872cfeabc4dbc849d06dd6abcbfae21', '4c0872cfeabc4dbc849d06dd6abcbfae02', '用户投资信息', '/financeinvestment/investment/customer', 0, 1, '', 1, '0,1', '2019-01-04 10:06:11.702517+08', NULL, '2019-01-04 10:06:11.702517+08', NULL, 20201, 'customer');
INSERT INTO public.sys_menu VALUES ('4c0872cfeabc4dbc849d06dd6abcbfae22', '4c0872cfeabc4dbc849d06dd6abcbfae02', '用户代持管理', '/financeinvestment/investment/dai', 1, 1, '', 1, '0,1', '2019-01-04 10:06:11.702517+08', NULL, '2019-01-04 10:06:11.702517+08', NULL, 20202, 'dai');
INSERT INTO public.sys_menu VALUES ('4c0872cfeabc4dbc849d06dd6abcbfae12', '4c0872cfeabc4dbc849d06dd6abcbfae01', '收益管理（token总收益）', '/financeinvestment/project/all', 1, 1, '', 1, '0,1', '2019-01-04 10:06:11.702517+08', NULL, '2019-01-04 10:06:11.702517+08', NULL, 20102, 'projectAll');
INSERT INTO public.sys_menu VALUES ('4c0872cfeabc4dbc849d06dd6abcbfae02', '3c0872cfeabc4dbc849d06dd0abcbfae', '用户管理', '/investment', 1, 1, '', 1, '0,1', '2019-01-04 10:06:11.702517+08', NULL, '2019-01-04 10:06:11.702517+08', NULL, 202, 'investment');
INSERT INTO public.sys_menu VALUES ('4c0872cfeabc4dbc849d06dd6abcbfae23', '4c0872cfeabc4dbc849d06dd6abcbfae02', '管理员列表', '/financeinvestment/investment/gfadmin', 2, 1, '', 1, '0,1', '2019-01-04 10:06:11.702517+08', NULL, '2019-01-04 10:06:11.702517+08', NULL, 20203, 'gfadmin');
INSERT INTO public.sys_menu VALUES ('0ab8d1e7bb60496b8c0ca62fb102ff21', '0ab8d1e7bb60496b8c0ca62fb102ff02', '用户管理', '/system/management/user', 0, 1, '', 1, '0,1', '2019-01-04 10:06:11.702517+08', NULL, '2019-01-04 10:06:11.702517+08', NULL, 90201, 'partnerUser');
INSERT INTO public.sys_menu VALUES ('4c0872cfeabc4dbc849d06dd6abcbfae03', '3c0872cfeabc4dbc849d06dd0abcbfae', '内容管理', '/contentManagement', 2, 1, '', 1, '0,1', '2019-01-04 10:06:11.702517+08', NULL, '2019-01-04 10:06:11.702517+08', NULL, 203, 'contentManagement');
INSERT INTO public.sys_menu VALUES ('0ab8d1e7bb60496b8c0ca62fb102ff03', '0ab8d1e7bb60496b8c0ca62fb102fff4', '系统管理(合作方管理员)', '/cooperation', 2, 0, NULL, 1, '0', '2019-01-08 11:32:06+08', NULL, '2019-01-08 11:32:04+08', NULL, 903, 'cooperation');
INSERT INTO public.sys_menu VALUES ('0ab8d1e7bb60496b8c0ca62fb102ff01', '0ab8d1e7bb60496b8c0ca62fb102fff4', '我的信息', '/my', 0, 1, '', 1, NULL, '2019-01-04 10:06:11.702517+08', NULL, '2019-01-04 10:06:11.702517+08', NULL, 901, 'my');
INSERT INTO public.sys_menu VALUES ('0ab8d1e7bb60496b8c0ca62fb102fff4', '0', '系统设置', '/system', 9, 1, '', 0, '0,1', '2019-01-04 10:06:11.707459+08', NULL, '2019-01-04 10:06:11.707459+08', NULL, 9, 'system');
INSERT INTO public.sys_menu VALUES ('9ad5de8c8cf24d8babea2fae3797ac21', '9ad5de8c8cf24d8babea2fae3797ac02', '融资信息', '/datachain/financemanage/finance', 0, 1, '', 1, '0,1', '2019-01-04 10:06:11.702517+08', NULL, '2019-01-04 10:06:11.702517+08', NULL, 10201, 'finance');
INSERT INTO public.sys_menu VALUES ('0ab8d1e7bb60496b8c0ca62fb102ff02', '0ab8d1e7bb60496b8c0ca62fb102fff4', '系统管理', '/management', 1, 1, '', 1, '0,1', '2019-01-04 10:06:11.702517+08', NULL, '2019-01-04 10:06:11.702517+08', NULL, 902, 'management');
INSERT INTO public.sys_menu VALUES ('0ab8d1e7bb60496b8c0ca62fb102ff23', '0ab8d1e7bb60496b8c0ca62fb102ff02', '角色管理', '/system/management/role', 2, 1, '', 1, '0,1', '2019-01-04 10:06:11.702517+08', NULL, '2019-01-04 10:06:11.702517+08', NULL, 90203, 'role');
INSERT INTO public.sys_menu VALUES ('9ad5de8c8cf24d8babea2fae3797ac22', '9ad5de8c8cf24d8babea2fae3797ac02', '逾期信息', '/datachain/financemanage/overdue', 1, 1, '', 1, '0,1', '2019-01-04 10:06:11.702517+08', NULL, '2019-01-04 10:06:11.702517+08', NULL, 10202, 'overdue');
INSERT INTO public.sys_menu VALUES ('0ab8d1e7bb60496b8c0ca62fb102ff11', '0ab8d1e7bb60496b8c0ca62fb102ff01', '个人信息', '/system/my/userinfo', 0, 1, '', 1, '0,1', '2019-01-04 10:06:11.702517+08', NULL, '2019-01-04 10:06:11.702517+08', NULL, 90101, 'userinfo');
INSERT INTO public.sys_menu VALUES ('9ad5de8c8cf24d8babea2fae3797ac31', '9ad5de8c8cf24d8babea2fae3797ac03', '数据验证', '/datachain/datavalidation/validation', 0, 1, '', 1, '0,1', '2019-01-04 10:06:11.702517+08', NULL, '2019-01-04 10:06:11.702517+08', NULL, 10301, 'validation');
INSERT INTO public.sys_menu VALUES ('9ad5de8c8cf24d8babea2fae3797ac32', '9ad5de8c8cf24d8babea2fae3797ac03', '数据明细验证', '/datachain/datavalidation/detail', 1, 1, '', 1, '0,1', '2019-01-04 10:06:11.702517+08', NULL, '2019-01-04 10:06:11.702517+08', NULL, 10302, 'detail');
INSERT INTO public.sys_menu VALUES ('9ad5de8c8cf24d8babea2fae3797ac41', '9ad5de8c8cf24d8babea2fae3797ac04', '平台运营统计', '/datachain/statistics/platform', 0, 1, '', 1, '0,1', '2019-01-08 11:10:47.011657+08', '', '2019-01-08 11:10:47.011657+08', '', 10401, 'platform');
INSERT INTO public.sys_menu VALUES ('9ad5de8c8cf24d8babea2fae3797ac42', '9ad5de8c8cf24d8babea2fae3797ac04', '投资人收益统计', '/datachain/statistics/earnings', 1, 1, '', 1, '0,1', '2019-01-04 10:06:11.702517+08', NULL, '2019-01-04 10:06:11.702517+08', NULL, 10402, 'earnings');
INSERT INTO public.sys_menu VALUES ('9ad5de8c8cf24d8babea2fae3797ac43', '9ad5de8c8cf24d8babea2fae3797ac04', '平台运营统计（内部）', '/datachain/statistics/inside\bearnings', 2, 1, '', 1, '0,1', '2019-01-04 10:06:11.702517+08', NULL, '2019-01-04 10:06:11.702517+08', NULL, 10403, 'insideEarnings');
INSERT INTO public.sys_menu VALUES ('9ad5de8c8cf24d8babea2fae3797ac44', '9ad5de8c8cf24d8babea2fae3797ac04', '投资人收益统计（内部）', '/datachain/statistics/insideplatform', 3, 1, '', 1, '0,1', '2019-01-04 10:06:11.702517+08', NULL, '2019-01-04 10:06:11.702517+08', NULL, 10404, 'insidePlatform');
INSERT INTO public.sys_menu VALUES ('4c0872cfeabc4dbc849d06dd6abcbfae31', '4c0872cfeabc4dbc849d06dd6abcbfae03', '公告管理', '/financeinvestment/contentmanagement/index', 0, 1, '', 1, '0,1', '2019-01-04 10:06:11.702517+08', NULL, '2019-01-04 10:06:11.702517+08', NULL, 20301, 'notice');
INSERT INTO public.sys_menu VALUES ('0ab8d1e7bb60496b8c0ca62fb102ff22', '0ab8d1e7bb60496b8c0ca62fb102ff02', '合作方管理', '/system/management/partners', 1, 1, '', 1, '0', '2019-01-04 10:06:11.702517+08', NULL, '2019-01-04 10:06:11.702517+08', NULL, 90202, 'partners');
INSERT INTO public.sys_menu VALUES ('4c0872cfeabc4dbc849d06dd6abcbfae32', '4c0872cfeabc4dbc849d06dd6abcbfae03', '横幅管理', '/financeinvestment/contentmanagement/banner', 1, 1, '', 1, '0', '2019-01-04 10:06:11.702517+08', NULL, '2019-01-04 10:06:11.702517+08', NULL, 20302, 'banner');
INSERT INTO public.sys_menu VALUES ('0ab8d1e7bb60496b8c0ca62fb102ff12', '0ab8d1e7bb60496b8c0ca62fb102ff01', '密码修改', '/system/my/pws', 1, 1, '', 1, NULL, '2019-01-04 10:06:11.702517+08', NULL, '2019-01-04 10:06:11.702517+08', NULL, 90102, 'pws');
INSERT INTO public.sys_menu VALUES ('0ab8d1e7bb60496b8c0ca62fb102ff31', '0ab8d1e7bb60496b8c0ca62fb102ff03', '用户管理', '/system/cooperation/user', 0, 0, NULL, 1, '0', '2019-01-08 11:34:12+08', NULL, '2019-01-08 11:34:14+08', NULL, 90301, 'user');
INSERT INTO public.sys_menu VALUES ('9ad5de8c8cf24d8babea2fae3797ac11', '9ad5de8c8cf24d8babea2fae3797ac01', '客户信息', '/datachain/clientmanage/basicinfo', 0, 1, '', 1, '0,1', '2019-01-08 10:51:43.155492+08', '', '2019-01-08 10:51:43.155492+08', '', 10101, 'basicinfo');
INSERT INTO public.sys_menu VALUES ('f241f3152cb34f439e8eec86cdc3b3f4', '525abc902af840b984173cdefe6f2544', '首页', '/dashboard', 3, 1, '', 0, '0,1', '2019-01-08 10:37:25.044425+08', '', '2019-01-08 10:37:25.044425+08', '', 3, 'dashboard');
INSERT INTO public.sys_menu VALUES ('0ab8d1e7bb60496b8c0ca62fb102ff24', '0ab8d1e7bb60496b8c0ca62fb102ff02', '数据字典管理', '/system/management/dictionary', 3, 1, NULL, 1, '0', '2019-01-08 11:30:56+08', NULL, '2019-01-08 11:30:59+08', NULL, 90204, 'dictionary');


--
-- Data for Name: sys_partner; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.sys_partner VALUES ('2988e415237849d0b523d2a208fe1993', 'seal', 'seal', NULL, '222', '1', '2018-12-25 10:15:17+08', NULL, '2019-01-10 14:33:37.074788+08', '2776cd3a081011e9bd39fa163e168207', '2222', '0');


--
-- Data for Name: sys_role; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: sys_role_menu; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: sys_task; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.sys_task VALUES ('tt4ae0485cb64c75bf9fe4fc17d94df8', 'revenueInfoTask', '定时汇总分红信息', '2019-01-01 00:00:00');
INSERT INTO public.sys_task VALUES ('tt4ae0485cb64c75bf9fe4fc17d94df7', 'revenueDetailTask', '定时推送分送消息', '2019-01-01 00:00:00');


--
-- Data for Name: sys_user; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.sys_user VALUES ('88ae146c7f374b73a5ecf51173eae7ec', 'admin', 'seal@2018', 'f2c226ac61c0d1c54a0c3601b8d41677', 'seal', '超级管理员', '', '', '1', '1', '2019-01-16 15:42:40.739576+08', '2776cd3a081011e9bd39fa163e168207', '2019-01-16 15:42:40.739576+08', '2776cd3a081011e9bd39fa163e168207');


--
-- Data for Name: sys_user_role; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: tz_agency_hold; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: tz_invest_info; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: tz_invest_item; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: tz_message_info; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: tz_notice_info; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: tz_revenue; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Name: gf_manage_mise pk_gf_manage_mise; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gf_manage_mise
    ADD CONSTRAINT pk_gf_manage_mise PRIMARY KEY (id);


--
-- Name: tz_agency_hold pk_tz_agency_hold; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tz_agency_hold
    ADD CONSTRAINT pk_tz_agency_hold PRIMARY KEY (id);


--
-- Name: tz_invest_info pk_tz_invest_info; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tz_invest_info
    ADD CONSTRAINT pk_tz_invest_info PRIMARY KEY (id);


--
-- Name: tz_invest_item pk_tz_invest_item; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tz_invest_item
    ADD CONSTRAINT pk_tz_invest_item PRIMARY KEY (id);


--
-- Name: tz_notice_info pk_tz_notice_info; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tz_notice_info
    ADD CONSTRAINT pk_tz_notice_info PRIMARY KEY (id);


--
-- Name: tz_revenue pk_tz_revenue; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tz_revenue
    ADD CONSTRAINT pk_tz_revenue PRIMARY KEY (id);


--
-- Name: sys_banner sys_banner_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sys_banner
    ADD CONSTRAINT sys_banner_pk PRIMARY KEY (id);


--
-- Name: sys_dict_item sys_dict_item_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sys_dict_item
    ADD CONSTRAINT sys_dict_item_pkey PRIMARY KEY (id);


--
-- Name: sys_dict_type sys_dict_type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sys_dict_type
    ADD CONSTRAINT sys_dict_type_pkey PRIMARY KEY (id);


--
-- Name: sys_menu sys_menu_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sys_menu
    ADD CONSTRAINT sys_menu_pkey PRIMARY KEY (id);


--
-- Name: sys_partner sys_partner_channel_mark_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sys_partner
    ADD CONSTRAINT sys_partner_channel_mark_key UNIQUE (channel_mark);


--
-- Name: sys_partner sys_partner_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sys_partner
    ADD CONSTRAINT sys_partner_pkey PRIMARY KEY (id);


--
-- Name: sys_role_menu sys_role_menu_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sys_role_menu
    ADD CONSTRAINT sys_role_menu_pkey PRIMARY KEY (id);


--
-- Name: sys_role sys_role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sys_role
    ADD CONSTRAINT sys_role_pkey PRIMARY KEY (id);


--
-- Name: sys_task sys_task_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sys_task
    ADD CONSTRAINT sys_task_pk PRIMARY KEY (id);


--
-- Name: sys_user sys_user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sys_user
    ADD CONSTRAINT sys_user_pkey PRIMARY KEY (id);


--
-- Name: sys_user_role sys_user_role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sys_user_role
    ADD CONSTRAINT sys_user_role_pkey PRIMARY KEY (id);


--
-- Name: tz_message_info tz_message_info_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tz_message_info
    ADD CONSTRAINT tz_message_info_pkey PRIMARY KEY (id);


--
-- Name: sys_user fk_channel_mark; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sys_user
    ADD CONSTRAINT fk_channel_mark FOREIGN KEY (channel_mark) REFERENCES public.sys_partner(channel_mark);


--
-- Name: sys_role_menu fk_menu_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sys_role_menu
    ADD CONSTRAINT fk_menu_id FOREIGN KEY (menu_id) REFERENCES public.sys_menu(id);


--
-- Name: sys_role_menu fk_role_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sys_role_menu
    ADD CONSTRAINT fk_role_id FOREIGN KEY (role_id) REFERENCES public.sys_role(id);


--
-- Name: sys_dict_item fk_type_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sys_dict_item
    ADD CONSTRAINT fk_type_id FOREIGN KEY (type_id) REFERENCES public.sys_dict_type(id);


--
-- PostgreSQL database dump complete
--

