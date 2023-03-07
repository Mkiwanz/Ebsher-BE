-- insert into project ("date", description, location, note, project_description, title)
-- values (CURRENT_DATE, 'تم بحمد الله الانتهاء من تركيب نظام طاقة شمسية بقدرة 24Kwp
-- لتغذية المــــول التجــــاري للسيد طــــــارق عبيـــــدات  المحـتـرم
-- ','Alramtha',':
-- موقعنا  : اربد - شارع الهاشمي- مقابل البنك الاسلامي
-- هاتف1 : 0777552904
-- هاتف 2 : 0797307612',' .
--   يغطي فاتورة بمعدل (400) دينار شهري .
--     مواصفات عالية و عمر افتراضي للنظام يصل الى (30 سنة)
--   الواح كهروضوئية Philadelphia SOLAR بقدرة عالية  545W كفالة مصنعية
--   سرعة في التنفيذ ومصداقية بالتعامل  .','Kiwan Project');
--

--
insert into project ("date", description, location, note, project_description, title)
values (CURRENT_DATE, 'description', 'Amman', 'note 1', 'steeel', 'project 1');
--        (CURRENT_DATE, 'description', 'Irbid', 'note 2', 'steeel', 'project 2'),
--        (CURRENT_DATE, 'description', 'Amman', 'note 3', 'steeel', 'project 3'),
--        (CURRENT_DATE, 'description', 'Amman', 'note 4', 'steeel', 'project 4');


insert into users (email, name, password, username)
values ('kiwan@gmail.com', 'kiwan', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 'kiwanz');