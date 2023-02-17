use javaee_training;
drop table if exists QuestionManagement;
create table QuestionManagement(
question_id varchar(10) primary key,
question_section enum('Instructor','Course Material','Learning Effectiveness','Environment','Job Impact'),
question_text varchar(300)
);


insert into QuestionManagement values
('Q1','Instructor','Instructor knowledgeable and handle all your queries'),
('Q2','Instructor','All the topics in a particular course handled by the trainer without any gaps or slipages'),
('Q3','Course Material','The course material(presentation,hands on,etc.) referred during the training are relevent and useful'),
('Q4','Course Material','The reference material referred for each module are adequate'),
('Q5','Learning Effectiveness','Knoweledge and skills presented in this training are applicable to your work'),
('Q6','Environment','The physical environment(classroom space,air-conditioning) was conductive to learning'),
('Q7','Environment','The software/hardware environment provided was sufficient for the purpose of the training'),
('Q8','Job Impact','This training will improve your job performance');

select * from QuestionManagement order by question_id;
