DROP DATABASE IF EXISTS academia;
CREATE DATABASE IF NOT EXISTS academia;
USE academia;

DROP TABLE IF EXISTS employee, student, course, student_course, specialisation, specialisation_course, course_schedule, department, placement, organisation, grade, domain;

create table employee(
	employee_id int NOT NULL AUTO_INCREMENT,
    first_name varchar(30) not null,
    last_name varchar(30),
    email varchar(50) unique not null,
    title varchar(30),
    photograph_path varchar(50),
    department_id int,
    constraint pk_employee primary key (employee_id)
);

create table student(
	student_id int NOT NULL AUTO_INCREMENT,
    roll_number varchar(15) unique not null,
    first_name varchar(30) not null,
    last_name varchar(30),
    email varchar(50) unique not null,
    photograph_path varchar(50),
    cgpa decimal(3,2) not null default 0.0,
    total_credits int not null,
    graduation_year int,
    domain_id int,
    specialisation_id int,
    placement_id int,
    constraint pk_student primary key (student_id)
);

create table course(
	course_id int NOT NULL AUTO_INCREMENT,
    course_code varchar(5) unique not null,
    `name` varchar(30) not null,
    `description` varchar(100),
    `year` varchar(4) not null,
    term int not null,
    credits int not null,
    capacity int not null,
    faculty_id int,
    constraint pk_course primary key (course_id)
);

create table student_course(
	id int NOT NULL AUTO_INCREMENT,
    student_id int,
    course_id int,
    grade_id int,
    comments varchar(30),
    constraint pk_student_course primary key (id)
);

create table grade(
	grade_id int NOT NULL AUTO_INCREMENT,
    letter_grade varchar(2) unique,
    grade_points decimal(3,2) not null,
    `comment` varchar(30),
    constraint pk_grade primary key (grade_id)
);

create table specialisation(
	specialisation_id int NOT NULL AUTO_INCREMENT,
    `code` varchar(10) unique not null,
    `name` varchar(30) not null,
    `description` varchar(100),
    `year` varchar(4) not null,
    credits_required int not null,
    constraint pk_specialisation primary key (specialisation_id)
);

create table specialisation_course(
	id int NOT NULL AUTO_INCREMENT,
    specialisation_id int,
    course_id int,
    constraint pk_specialisation_course primary key (id)
);

create table course_schedule(
	id int NOT NULL AUTO_INCREMENT,
    course_id int,
    `time` varchar(5) not null,
    `day` varchar(10) not null,
    room int not null,
    building varchar(30),
    constraint pk_course_schedule primary key (id)
);

create table department(
	department_id int NOT NULL AUTO_INCREMENT,
    `name` varchar(30) not null,
    capacity int not null,
    constraint pk_department primary key (department_id)
);

create table placement(
	id int NOT NULL AUTO_INCREMENT,
    organisation_id int,
    `profile` varchar(30) not null,
    `description` varchar(50),
    intake int not null,
    minimum_grade decimal(3,2),
    constraint pk_placement primary key (id)
);

create table organisation(
	id int NOT NULL AUTO_INCREMENT,
    `name` varchar(30) not null,
    address varchar(200),
    constraint pk_organisation primary key (id)
);

create table domain(
	domain_id int NOT NULL AUTO_INCREMENT,
    program varchar(20) not null,
    batch varchar(10) not null,
    capacity int not null,
    qualification varchar(30),
    constraint pk_domain primary key (domain_id)
);

CREATE TABLE `user` (
  id int NOT NULL AUTO_INCREMENT,
  username varchar(50) NOT NULL unique,
  `password` char(100) NOT NULL,
  enabled tinyint NOT NULL,  
  PRIMARY KEY (id)
);

CREATE TABLE `role` (
  id int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE user_roles (
  user_id int NOT NULL,
  role_id int NOT NULL,
  
  PRIMARY KEY (user_id, role_id)
);