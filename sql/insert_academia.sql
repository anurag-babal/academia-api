USE academia;

insert into department(department_id, name, capacity) values
(1, 'Faculty', 30),
(2, 'Account', 20);

insert into organisation(id, name, address) values
(1, 'CISCO', 'Cisco Systems INDIA Pvt Ltd, Cessna Business Park, Kadubeesanahalli Village, Varthur Hobli, Sarjapur Marathalli, Bengaluru, Karnataka, 560103, India'),
(2, 'Mercedes', 'Mercedes-Benz Research & Development India Whitefield Palms, Plot No. 9 & 10, Whitefield Main Rd, EPIP Zone, Phase 1 Bangalore Karnataka 560066 India');

insert into employee(employee_id, first_name, last_name, email, title, photograph_path, department_id) values
(1, 'Anurag', 'Babal', 'abc@gmail.com', 'Software Engineer', null, 1),
(2, 'Priya', 'Sharma', 'xyz@gmail.com', 'Project Manager', null, 1),
(3, 'Rahul', 'Kumar', 'mno@gmail.com', 'Senior Developer', null, 1),
(4, 'Anjali', 'Singh', 'pqr@gmail.com', 'Data Analyst', null, 1),
(5, 'Vikas', 'Patel', 'stu@gmail.com', 'Business Analyst', null, 2),
(6, 'Monika', 'Joshi', 'abc1@gmail.com', 'Human Resources Specialist', null, 2);

insert into course(course_id, course_code, name, description, year, term, credits, capacity, faculty_id) values
(1, 'CS513', 'Software Systems', null, 1, 1, 4, 180, 1),
(2, 'CS511', 'Advanced Algorithms', null, 1, 1, 4, 160, 1),
(3, 'AI511', 'Machine Learning', 'Machine Learning', 1, 1, 4, 180, 2),
(4, 'CS211', 'Data Structures and Algorithms', null, 2, 1, 4, 200, 2),
(5, 'CS322', 'Object-Oriented Programming', null, 3, 1, 3, 160, 3),
(6, 'CS405', 'Computer Networks', null, 4, 2, 4, 140, 4),
(7, 'CS523', 'Database Management Systems', null, 1, 2, 3, 120, 2),
(8, 'IT233', 'Web Application Development', null, 2, 2, 3, 100, 1);

insert into grade(grade_id, letter_grade, grade_points, comment) values
(1, 'A', 4.0, 'Excellent'),
(2, 'A-', 3.75, null),
(3, 'B+', 3.5, null),
(4, 'B', 3.0, null),
(5, 'B-', 2.75, null),
(6, 'C+', 2.5, null),
(7, 'C', 2.0, null),
(8, 'C-', 1.75, null),
(9, 'D+', 1.5, null),
(10, 'D', 1.0, null),
(11, 'F', 0.0, null);

insert into domain(domain_id, program, batch, capacity, qualification) values
(1, 'CSE', '2023', 150, null),
(2, 'ECE', '2023', 30, null),
(3, 'IT', '2023', 120, null),
(4, 'CE', '2023', 100, null),
(5, 'ME', '2023', 80, null),
(6, 'EE', '2023', 60, null),
(7, 'AE', '2023', 40, null);

insert into specialisation(specialisation_id, code, name, description, year, credits_required) values
(1, 'AI', 'Artificial Intelligence', null, 1, 8),
(2, 'NC', 'Networking and Communication', null, 1, 4),
(3, 'CN', 'Computer Networks', null, 2021, 6),
(4, 'SE', 'Software Engineering', null, 2023, 10),
(5, 'DBMS', 'Database Management Systems', null, 2020, 8),
(6, 'IT', 'Information Technology', null, 2019, 4),
(7, 'ML', 'Machine Learning', null, 2022, 8),
(8, 'CSE', 'Computer Science Engineering', null, 1, 8);

insert into specialisation_course(id, specialisation_id, course_id) values
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5),
(6, 6, 6),
(7, 8, 7);

insert into course_schedule(id, course_id, time, day, room, building) values
(1, 1, '09:30', 'Monday', 203, 'Ramanujan'),
(2, 1, '09:30', 'Wednesday', 203, 'Ramanujan'),
(3, 2, '11:15', 'Monday', 203, 'Ramanujan'),
(4, 2, '11:15', 'Monday', 203, 'Ramanujan'),
(5, 3, '03:30', 'Monday', 203, 'Ramanujan'),
(6, 4, '11:00', 'Tuesday', 305, 'Visvesvaraya'),
(7, 3, '03:30', 'Wednesday', 407, 'Vikramaditya'),
(8, 4, '15:00', 'Thursday', 210, 'Ramanujan'),
(9, 5, '16:30', 'Friday', 105, 'Visvesvaraya');

insert into placement(id, organisation_id, profile, description, intake, minimum_grade) values
(1, 1, 'SDE', 'Software Developer', 5, 2.85),
(2, 2, 'SE', 'Software Engineer', 10, 2.6);

insert into student(student_id, roll_number, first_name, last_name, email, photograph_path, cgpa, total_credits, graduation_year, domain_id, specialisation_id, placement_id) values
(1, 'MT2023102', 'Anurag', 'Babal', 'abc@gmail.com', null, 2.84, 16, '2025', 1, 2, null),
(2, 'MT2023123', 'Souvik', null, 'def@gmail.com', null, 3.24, 16, '2025', 1, 1, 2),
(3, 'MT2023104', 'Rahul', 'Kumar', 'mno@gmail.com', null, 2.98, 8, '2025', 3, 3, null),
(4, 'MT2023105', 'Anjali', 'Singh', 'pqr@gmail.com', null, 3.21, 4, '2024', 1, 2, null),
(5, 'MT2023106', 'Vikas', 'Patel', 'stu@gmail.com', null, 3.95, 18, '2024', 2, 1, null),
(6, 'MT2023107', 'Monika', 'Joshi', 'abc1@gmail.com', null, 3.52, 14, '2024', 3, 3, null),
(7, 'MT2023103', 'Priya', 'Sharma', 'xyz@gmail.com', null, 3.67, 12, '2025', 2, 1, null);

insert into student_course(id, student_id, course_id, grade_id, comments) values
(1, 1, 1, 1, 'Excellent'),
(2, 1, 3, 2, 'Good'),
(3, 1, 4, 3, 'Needs Improvement'),
(4, 2, 2, 4, 'Excellent'),
(5, 2, 3, 5, 'Good'),
(6, 2, 5, 6, 'Needs Improvement'),
(7, 3, 1, 7, 'Excellent'),
(8, 3, 3, 8, 'Good'),
(10, 4, 2, 10, 'Excellent'),
(13, 5, 5, 2, 'Excellent'),
(14, 5, 4, 3, 'Good'),
(15, 5, 2, 4, 'Needs Improvement'),
(17, 6, 5, 6, 'Good');

insert into login(id, username, password, role, employee_id) values
(1, "admin", "password", "ADMIN", 6),
(2, "anurag", "pass", "FACULTY", 1),
(3, "priya", "pass", "FACULTY", 2),
(4, "rahul", "pass", "FACULTY", 3),
(5, "user", "pass", "ACCOUNT", 5);

INSERT INTO `user` (`username`,`password`,`enabled`) VALUES 
('john','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1),
('mary','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1),
('susan','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1);

INSERT INTO `role` (name) VALUES 
('ROLE_EMPLOYEE'),
('ROLE_MANAGER'),
('ROLE_ADMIN');

INSERT INTO `user_roles` (user_id,role_id) VALUES 
(1, 1),
(2, 1),
(2, 2),
(3, 1),
(3, 2),
(3, 3);