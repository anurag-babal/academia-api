USE academia;

alter table employee add constraint fk_department_id foreign key (department_id) references department(department_id);

alter table student add constraint fk_domain_id foreign key (domain_id) references domain(domain_id);

alter table student add constraint fk_specialisation_id foreign key (specialisation_id) references specialisation(specialisation_id);

alter table student add constraint fk_placement_id foreign key (placement_id) references placement(id);

alter table course add constraint fk_faculty_id foreign key (faculty_id) references employee(employee_id);

alter table student_course add constraint fk_student_course_student_id foreign key (student_id) references student(student_id);

alter table student_course add constraint fk_student_course_course_id foreign key (course_id) references course(course_id);

alter table student_course add constraint fk_grade_id foreign key (grade_id) references grade(grade_id);

alter table specialisation_course add constraint fk_specialisation_course_specialisation_id foreign key (specialisation_id) references specialisation(specialisation_id);

alter table specialisation_course add constraint fk_specialisation_course_course_id foreign key (course_id) references course(course_id);

alter table course_schedule add constraint fk_course_schedule_course_id foreign key (course_id) references course(course_id);

alter table placement add constraint fk_organisation_id foreign key (organisation_id) references organisation(id);

alter table user_roles add constraint fk_user_id FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table user_roles add constraint fk_role_id FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;