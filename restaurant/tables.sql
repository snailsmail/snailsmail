create database mydb;

#--员工表
create table emp(
  empno varchar(10) primary key,
  jobno varchar(10) not null,
  ename varchar(20) not null,
  sex char(10),
  age int,
  pwd varchar(10) default '666666' not null,
  sal float(10,2),
  hiredate date,
  tel varchar(11),
  email varchar(20),
  address varchar(40),
  isadmin int,
  url VARCHAR(100)
);

#--用户表
create table users(
  userno varchar(10) primary key,
  uname varchar(20)  not null,
  pwd varchar(10) default '666666' not null,
  sex char(10),
  tel varchar(11),
  balance float(10,2),
  address varchar(40),
  isvip int,
  url VARCHAR(100)
);

#--职位表
create table job(
  jobno varchar(10) primary key,
  jname varchar(20) not null
);

#--菜系表
create table cuisine(
  cuisineno varchar(10) primary key,
  cname varchar(20) not null
);

#--菜品表
create table dishes(
  dishesno varchar(10) primary key,
  cuisineno varchar(10) not null,
  dname  varchar(100) not null,
  price float(10,2),
  url varchar(100)
);

#--餐桌表
create table board(
  boardno varchar(10) primary key,
  bname varchar(20) not null,
  state int,
  remark varchar(100)
);

#--菜单表
create table bill(
  billno varchar(10) primary key,
  userno varchar(10),
  dushno varchar(10),
  num int//菜品数量
);

#--订单表
create table orders(
  orderno varchar(10) primary key,
  userno varchar(10) not null,
  boardno varchar(10),
  orderdate date,
  price float(10,2),
  isoutside int,
  ischeck int,
  remark varchar(20)
);

#--后厨//上菜表(主要是要cost字段的数据)
create table kitchen(
  kitchenno varchar(10) primary key,
  orderno varchar(10) not null,
  state int,
  cost float(10,2)
);


alter table kitchen add constraint fk_boardno foreign key(orderno) references orders(orderno) on delete cascade;

alter table kitchen add constraint ck_kc_state check(state in(0,1));

alter table kitchen drop foreign key fk_boardno;

alter table kitchen drop column `orderno`;

drop table kitchen;

select * from kitchen;

insert into kitchen values('koo1','o001',1,100.0);
insert into kitchen values('koo2','o002',0,200.0);
insert into kitchen values('koo3','o003',1,100.0);
insert into kitchen values('koo4','o004',0,200.0);





alter table emp add constraint fk_jobno foreign key(jobno) references job(jobno) on delete cascade;

alter table dishes add constraint fk_cuisineno foreign key(cuisineno) references cuisine(cuisineno) on delete cascade;

alter table orders add constraint fk_billno foreign key(billno) references bill(billno) on delete cascade;

alter table orders add constraint fk_boardno foreign key(boardno) references board(boardno) on delete cascade;

alter  table emp add constraint ck_isadmin check(isadmin in(0,1));
alter  table users add constraint ck_isvip check(isvip in(0,1));
alter  table board add constraint ck_state check(state in(0,1));
alter  table orders add constraint ck_isoutside check(isoutside in(0,1));
alter  table orders add constraint ck_ischeck check(ischeck in(0,1));

SELECT * from emp;

#--职位表
insert into job values('j001','经理');
insert into job values('j002','服务员');
insert into job values('j003','外卖员');
insert into job values('j004','收银员');

#--员工表
insert into emp values('e001','j001','jack','男',30,'123456',10000,
                            str_to_date('2015-10-20','%Y-%m-%d'),'13999999999','1002583770@qq.com','江苏省苏州市虎丘区',1);

insert into emp values('e007','j001','admin','男',22,'123456',15000,
                              str_to_date('2015-3-22','%Y-%m-%d'),'13777777777','5675685854@qq.com','江苏省苏州市相城区',1);

insert into emp values('e008','j002','lili','女',25,'123456',3500,
                              str_to_date('2015-2-23','%Y-%m-%d'),'13662266666','8948654656@qq.com','江苏省苏州市吴中区',0);

insert into emp values('e002','j002','tom','男',28,'123456',5000,
                              str_to_date('2015-7-21','%Y-%m-%d'),'13888888888','2131241412@qq.com','江苏省苏州市平江区',0);

insert into emp values('e003','j003','amery','男',22,'123456',4500,
                              str_to_date('2015-8-22','%Y-%m-%d'),'13777777777','5675685854@qq.com','江苏省苏州市高新区',0);

insert into emp values('e004','j004','rose','女',25,'123456',3500,
                              str_to_date('2014-10-23','%Y-%m-%d'),'13666222666','8948654656@qq.com','江苏省苏州市姑苏区',0);

insert into emp values('e005','j002','jerry','男',22,'123456',4500,
                              str_to_date('2014-4-22','%Y-%m-%d'),'13772277777','5675685854@qq.com','江苏省苏州市沧浪区',0);

insert into emp values('e006','j004','rose','女',25,'123456',3500,
                              str_to_date('2015-4-23','%Y-%m-%d'),'13666666666','8948654656@qq.com','江苏省苏州市工业园区',0);

insert into emp values('e009','j004','adou','女',25,'123456',3500,
                              str_to_date('2015-4-23','%Y-%m-%d'),'13666666666','8948654656@qq.com','江苏省苏州市金阊区',0);
insert into emp values('e010','j004','xujian','男',25,'123456',3500,
                              str_to_date('2015-4-23','%Y-%m-%d'),'13666666666','8948654656@qq.com','江苏省苏州市张家港市',0);

insert into emp values('e011','j004','wuwenqing','男',25,'123456',3500,
                              str_to_date('2015-4-23','%Y-%m-%d'),'13666666666','8948654656@qq.com','江苏省苏州市常熟市',0);

#--用户表
insert into users values('u001','张三','男','13555555555',600,'江苏省苏州市虎丘区',0);
insert into users values('u002','李四','女','13444444444',2000,'江苏省苏州市相城区',1);
insert into users values('u003','王五','男','13222222222',100,'江苏省苏州市吴中区',0);
insert into users values('u004','张一','女','13555555555',200,'江苏省苏州市平江区',0);
insert into users values('u005','李一','男','13444444444',2000,'江苏省苏州市高新区',1);
insert into users values('u006','王一','男','13224442222',300,'江苏省苏州市姑苏区',0);
insert into users values('u007','张五','女','13555445555',600,'江苏省苏州市沧浪区',0);
insert into users values('u008','李五','男','13444555444',1400,'江苏省苏州市工业园区',1);
insert into users values('u009','王六','女','13222255222',1200,'江苏省苏州市金阊区',0);
insert into users values('u010','王七','男','13222255222',1200,'江苏省苏州市张家港市',0);
insert into users values('u011','李八','女','13222255222',1200,'江苏省苏州市常熟市',0);

#--菜系表
insert into cuisine values('c001','汤类');
insert into cuisine values('c002','主食');
insert into cuisine values('c003','凉菜');
insert into cuisine values('c004','点心');
insert into cuisine values('c005','饮料酒水');
insert into cuisine values('c006','炒菜');
insert into cuisine values('c007','海鲜类');
insert into cuisine values('c008','肉类');

#--菜品表
insert into dishes values('d001','c006','红油抄手',58);
insert into dishes values('d002','c008','家常宫保鸡',80);
insert into dishes values('d003','c008','辣子鸡丁',60);
insert into dishes values('d004','c006','蚂蚁上树',50);
insert into dishes values('d005','c008','四川油烫鸭',15);
insert into dishes values('d006','c006','鱼香瘦肉丝',10);
insert into dishes values('d007','c007','川味酸菜鱼',20);
insert into dishes values('d010','c007','京葱爆虾',21);
insert into dishes values('d011','c002','老北京炒疙瘩',15);
insert into dishes values('d012','c008','老北京肉丁炒酱瓜',80);
insert into dishes values('d013','c007','咯吱盒',70);
insert into dishes values('d014','c006','辣味蚕豆芽',50);
insert into dishes values('d015','c008','豆角小炒肉',66);
insert into dishes values('d016','c008','农家味土鸡',20);
insert into dishes values('d017','c003','山东拌菜',20);
insert into dishes values('d018','c008','蒜香猪蹄',15);
insert into dishes values('d019','c006','蟹味杏鲍菇',10);
insert into dishes values('d020','c003','鸳鸯蛋',20);
insert into dishes values('d021','c002','福建闽清酸菜炒粉',10);
insert into dishes values('d022','c008','荔枝鸡球',8);
insert into dishes values('d023','c008','泉州腊肉',21);
insert into dishes values('d024','c002','五香卷',15);
insert into dishes values('d025','c008','香芋焖鸭',80);
insert into dishes values('d026','c004','奶香味炸薯条',70);
insert into dishes values('d027','c002','糯米鸡腿卷',50);
insert into dishes values('d028','c002','生煎小笼包',66);
insert into dishes values('d029','c001','莲藕棒骨汤',20);
insert into dishes values('d030','c001','绿豆百合莲子汤',20);
insert into dishes values('d031','c001','肉末疙瘩汤',15);
insert into dishes values('d032','c001','山药猪蹄汤',10);
insert into dishes values('d033','c001','石榴银耳汤',20);
insert into dishes values('d034','c001','玉米胡萝卜排骨汤',10);
insert into dishes values('d035','c004','蛋糕',8);
insert into dishes values('d036','c004','蛋挞',21);
insert into dishes values('d037','c004','糕点',15);
insert into dishes values('d038','c004','广式糕点',12);
insert into dishes values('d039','c004','红豆糕',70);
insert into dishes values('d040','c004','金丝香蕉球',50);
insert into dishes values('d041','c004','甜甜圈',66);

insert into dishes values('d042','c005','各类果汁',38);
insert into dishes values('d043','c005','红酒',21);
insert into dishes values('d044','c005','鸡尾酒',15);
insert into dishes values('d045','c005','酒',80);
insert into dishes values('d046','c005','啤酒',70);
insert into dishes values('d047','c005','饮料',50);
insert into dishes values('d048','c003','菠菜',38);
insert into dishes values('d049','c003','海带',21);
insert into dishes values('d050','c003','花生豆',15);
insert into dishes values('d051','c003','黄瓜',80);
insert into dishes values('d052','c003','芥菜',70);
insert into dishes values('d053','c003','芥末墩',50);
insert into dishes values('d054','c003','精品凉菜',15);
insert into dishes values('d055','c003','木瓜',80);
insert into dishes values('d056','c003','紫菜',70);
insert into dishes values('d057','c006','白菜腊肠炒年糕',21);
insert into dishes values('d058','c006','南肉春笋',15);
insert into dishes values('d059','c006','盐蛋黄烧茄子',80);
insert into dishes values('d060','c006','大盆花菜',70);
insert into dishes values('d061','c006','拌辣萝卜丝',50);

UPDATE dishes set url='public/static/imgs/紫菜.jpg' where dishesno = 'd056';
UPDATE dishes set url='public/static/imgs/浙菜 白菜腊肠炒年糕.jpg' where dishesno = 'd057';
UPDATE dishes set url='public/static/imgs/浙菜 南肉春笋.gif' where dishesno = 'd058';
UPDATE dishes set url='public/static/imgs/湘菜 盐蛋黄烧茄子.jpg' where dishesno = 'd059';
UPDATE dishes set url='public/static/imgs/湘菜 大盆花菜.jpg' where dishesno = 'd060';

UPDATE dishes set url='public/static/imgs/甜甜圈.jpg' where dishesno = 'd041';
UPDATE dishes set url='public/static/imgs/各类果汁.jpg' where dishesno = 'd042';
UPDATE dishes set url='public/static/imgs/红酒.jpg' where dishesno = 'd043';
UPDATE dishes set url='public/static/imgs/鸡尾酒.jpg' where dishesno = 'd044';
UPDATE dishes set url='public/static/imgs/酒.jpg' where dishesno = 'd045';
UPDATE dishes set url='public/static/imgs/啤酒.jpg' where dishesno = 'd046';
UPDATE dishes set url='public/static/imgs/菠菜.jpg' where dishesno = 'd048';
UPDATE dishes set url='public/static/imgs/海带.jpg' where dishesno = 'd049';
UPDATE dishes set url='public/static/imgs/花生豆.jpg' where dishesno = 'd050';
UPDATE dishes set url='public/static/imgs/黄瓜.jpg' where dishesno = 'd051';

UPDATE dishes set url='public/static/imgs/肉末疙瘩汤.png' where dishesno = 'd031';
UPDATE dishes set url='public/static/imgs/山药猪蹄汤.png' where dishesno = 'd032';
UPDATE dishes set url='public/static/imgs/石榴银耳汤.png' where dishesno = 'd033';
UPDATE dishes set url='public/static/imgs/玉米胡萝卜排骨汤.png' where dishesno = 'd034';
UPDATE dishes set url='public/static/imgs/蛋糕.jpg' where dishesno = 'd035';
UPDATE dishes set url='public/static/imgs/蛋挞.jpg' where dishesno = 'd036';
UPDATE dishes set url='public/static/imgs/糕点.jpg' where dishesno = 'd037';
UPDATE dishes set url='public/static/imgs/广式糕点.jpg' where dishesno = 'd038';
UPDATE dishes set url='public/static/imgs/红豆糕.jpg' where dishesno = 'd039';
UPDATE dishes set url='public/static/imgs/金丝香蕉球.png' where dishesno = 'd040';

UPDATE dishes set url='public/static/imgs/川菜_红油抄手.png' where dishesno = 'd001';
UPDATE dishes set url='public/static/imgs/川菜 家常宫保鸡.png' where dishesno = 'd002';
UPDATE dishes set url='public/static/imgs/川菜 辣子鸡丁.jpg' where dishesno = 'd003';
UPDATE dishes set url='public/static/imgs/川菜 蚂蚁上树.jpg' where dishesno = 'd004';
UPDATE dishes set url='public/static/imgs/川菜 四川油烫鸭.png' where dishesno = 'd005';
UPDATE dishes set url='public/static/imgs/川菜 鱼香瘦肉丝.png' where dishesno = 'd006';
UPDATE dishes set url='public/static/imgs/川味酸菜鱼.png' where dishesno = 'd007';
UPDATE dishes set url='public/static/imgs/京菜 京葱爆虾.jpg' where dishesno = 'd008';
UPDATE dishes set url='public/static/imgs/京菜 老北京炒疙瘩.jpg' where dishesno = 'd009';
UPDATE dishes set url='public/static/imgs/京菜 咯吱盒.jpg' where dishesno = 'd010';

UPDATE dishes set url='public/static/imgs/京菜 老北京炒疙瘩.jpg' where dishesno = 'd011';
UPDATE dishes set url='public/static/imgs/京菜 老北京肉丁炒酱瓜.jpg' where dishesno = 'd012';
UPDATE dishes set url='public/static/imgs/京菜 咯吱盒.jpg' where dishesno = 'd013';
UPDATE dishes set url='public/static/imgs/辣味蚕豆芽.png' where dishesno = 'd014';
UPDATE dishes set url='public/static/imgs/鲁菜 豆角小炒肉.jpg' where dishesno = 'd015';
UPDATE dishes set url='public/static/imgs/鲁菜 农家味土鸡.png' where dishesno = 'd016';
UPDATE dishes set url='public/static/imgs/鲁菜 山东拌菜.jpg' where dishesno = 'd017';
UPDATE dishes set url='public/static/imgs/鲁菜 蒜香猪蹄.jpg' where dishesno = 'd018';
UPDATE dishes set url='public/static/imgs/鲁菜 蟹味杏鲍菇.png' where dishesno = 'd019';
UPDATE dishes set url='public/static/imgs/鲁菜 鸳鸯蛋.jpg' where dishesno = 'd020';


UPDATE dishes set url='public/static/imgs/闽菜 福建闽清酸菜炒粉.png' where dishesno = 'd021';
UPDATE dishes set url='public/static/imgs/闽菜 荔枝鸡球.gif' where dishesno = 'd022';
UPDATE dishes set url='public/static/imgs/闽菜 泉州腊肉.jpg' where dishesno = 'd023';
UPDATE dishes set url='public/static/imgs/闽菜 五香卷.gif' where dishesno = 'd024';
UPDATE dishes set url='public/static/imgs/闽菜 香芋焖鸭.jpg' where dishesno = 'd025';
UPDATE dishes set url='public/static/imgs/闽菜 香芋焖鸭.jpg' where dishesno = 'd026';
UPDATE dishes set url='public/static/imgs/闽菜 香芋焖鸭.jpg' where dishesno = 'd027';
UPDATE dishes set url='public/static/imgs/苏菜 生煎小笼包.jpg' where dishesno = 'd028';
UPDATE dishes set url='public/static/imgs/莲藕棒骨汤.png' where dishesno = 'd029';
UPDATE dishes set url='public/static/imgs/绿豆百合莲子汤.png' where dishesno = 'd030';



#--餐桌表
insert into board values('t001','一号桌',1);
insert into board values('t002','二号桌',0);
insert into board values('t003','三号桌',0);
insert into board values('t004','四号桌',0);
insert into board values('t005','五号桌',0);
insert into board values('t006','六号桌',0);
insert into board values('t007','七号桌',1);
insert into board values('t008','八号桌',0);
insert into board values('t009','九号桌',0);
insert into board values('t010','十号桌',0);
insert into board values('t011','十一号桌',0);

UPDATE board set remark='四人桌靠窗' where boardno = 't001';
UPDATE board set remark='二人桌靠窗' where boardno = 't002';
UPDATE board set remark='二人桌靠窗' where boardno = 't003';
UPDATE board set remark='四人桌' where boardno = 't004';
UPDATE board set remark='二人桌' where boardno = 't005';
UPDATE board set remark='八人桌' where boardno = 't006';
UPDATE board set remark='八人桌' where boardno = 't007';
UPDATE board set remark='二人桌' where boardno = 't008';
UPDATE board set remark='二人桌' where boardno = 't009';
UPDATE board set remark='四人桌' where boardno = 't010';
UPDATE board set remark='四人桌靠窗' where boardno = 't011';

#--菜单表
insert into bill values('b001','芥末墩、生煎小笼包、拌辣萝卜丝、蛋挞');
insert into bill values('b002','芥末、大盆花菜、盐蛋黄烧茄子、蛋挞、山药猪蹄汤');
insert into bill values('b003','辣子鸡丁、糯米鸡腿卷、紫菜、啤酒');
insert into bill values('b004','川味酸菜鱼、生煎小笼包、拌辣萝卜丝、木瓜');

#--订单表
insert into orders values('o001','b001','t001',str_to_date('2015-11-02 10:23:15','%Y-%m-%d %T'),200,0,0,null);
insert into orders values('o002','b002','t007',str_to_date('2015-10-20 15:23:15','%Y-%m-%d %T'),400,1,0,null);
insert into orders values('o003','b003','t002',str_to_date('2015-3-02 20:23:15','%Y-%m-%d %T'),200,0,1,null);
insert into orders values('o004','b004','t007',str_to_date('2015-4-20 12:23:15','%Y-%m-%d %T'),400,0,1,null);

