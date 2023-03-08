insert into users (email, name, password, username)
values ('kiwan@gmail.com', 'kiwan', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 'kiwanz');

INSERT INTO public.project (id, date, description, location, note, project_description, title)
VALUES (2, '2023-03-16', 'ssssssssss', 'Amman', 'asdasdas', 'asdasdasd', 'asdasdsad');
INSERT INTO public.project (id, date, description, location, note, project_description, title)
VALUES (3, '2023-03-29', 'New Project', 'Amman', 'aaaaaaaaaaaaaaaaa', 'aklsnmlkasmd', 'Project Amman');
INSERT INTO public.project (id, date, description, location, note, project_description, title)
VALUES (4, '2023-03-22', 'A new project with Ebsher Team', 'Zarqa', 'Contact Us', 'Steel Galvanized, 30 M height  ',
        'Project Zarqa');
INSERT INTO public.project (id, date, description, location, note, project_description, title)
VALUES (5, '2023-03-09', 'A new Ebsher Project', 'Irbid', 'Contact Us', 'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',
        'Project Irbid');
INSERT INTO public.project (id, date, description, location, note, project_description, title)
VALUES (6, '2023-03-21', 'asas', 'Jarash', 'aaaaaaaaaaaa', 'aaaaaaaaaa', 'Last Test');

INSERT INTO public.image (id, created_at, name, path, size, project_id)
VALUES (1, null, '1.jpg', 'https://s3.amazonaws.com/ebsher/1.jpg', null, 2);
INSERT INTO public.image (id, created_at, name, path, size, project_id)
VALUES (2, null, '2.jpg', 'https://s3.amazonaws.com/ebsher/2.jpg', null, 2);
INSERT INTO public.image (id, created_at, name, path, size, project_id)
VALUES (3, null, '3.jpg', 'https://s3.amazonaws.com/ebsher/3.jpg', null, 2);
INSERT INTO public.image (id, created_at, name, path, size, project_id)
VALUES (4, null, '11.jpg', 'https://s3.amazonaws.com/ebsher/11.jpg', null, 3);
INSERT INTO public.image (id, created_at, name, path, size, project_id)
VALUES (5, null, '22.jpg', 'https://s3.amazonaws.com/ebsher/22.jpg', null, 3);
INSERT INTO public.image (id, created_at, name, path, size, project_id)
VALUES (6, null, '6.jpg', 'https://s3.amazonaws.com/ebsher/6.jpg', null, 4);
INSERT INTO public.image (id, created_at, name, path, size, project_id)
VALUES (7, null, '7.jpg', 'https://s3.amazonaws.com/ebsher/7.jpg', null, 4);
INSERT INTO public.image (id, created_at, name, path, size, project_id)
VALUES (8, null, '8.jpg', 'https://s3.amazonaws.com/ebsher/8.jpg', null, 4);
INSERT INTO public.image (id, created_at, name, path, size, project_id)
VALUES (9, null, '50.jpg', 'https://s3.amazonaws.com/ebsher/50.jpg', null, 5);
INSERT INTO public.image (id, created_at, name, path, size, project_id)
VALUES (10, null, '51.jpg', 'https://s3.amazonaws.com/ebsher/51.jpg', null, 5);
INSERT INTO public.image (id, created_at, name, path, size, project_id)
VALUES (11, null, '52.jpg', 'https://s3.amazonaws.com/ebsher/52.jpg', null, 5);
INSERT INTO public.image (id, created_at, name, path, size, project_id)
VALUES (12, null, '1.jpg', 'https://s3.amazonaws.com/ebsher/1.jpg', null, 6);
INSERT INTO public.image (id, created_at, name, path, size, project_id)
VALUES (13, null, '51.jpg', 'https://s3.amazonaws.com/ebsher/51.jpg', null, 6);
INSERT INTO public.image (id, created_at, name, path, size, project_id)
VALUES (14, null, 'eb1.jpg', 'https://s3.amazonaws.com/ebsher/eb1.jpg', null, 6);
