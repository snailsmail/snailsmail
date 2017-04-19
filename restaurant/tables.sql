create database mydb;

#--Ա����
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

#--�û���
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

#--ְλ��
create table job(
  jobno varchar(10) primary key,
  jname varchar(20) not null
);

#--��ϵ��
create table cuisine(
  cuisineno varchar(10) primary key,
  cname varchar(20) not null
);

#--��Ʒ��
create table dishes(
  dishesno varchar(10) primary key,
  cuisineno varchar(10) not null,
  dname  varchar(100) not null,
  price float(10,2),
  url varchar(100)
);

#--������
create table board(
  boardno varchar(10) primary key,
  bname varchar(20) not null,
  state int,
  remark varchar(100)
);

#--�˵���
create table bill(
  billno varchar(10) primary key,
  userno varchar(10),
  dushno varchar(10),
  num int//��Ʒ����
);

#--������
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

#--���//�ϲ˱�(��Ҫ��Ҫcost�ֶε�����)
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

#--ְλ��
insert into job values('j001','����');
insert into job values('j002','����Ա');
insert into job values('j003','����Ա');
insert into job values('j004','����Ա');

#--Ա����
insert into emp values('e001','j001','jack','��',30,'123456',10000,
                            str_to_date('2015-10-20','%Y-%m-%d'),'13999999999','1002583770@qq.com','����ʡ�����л�����',1);

insert into emp values('e007','j001','admin','��',22,'123456',15000,
                              str_to_date('2015-3-22','%Y-%m-%d'),'13777777777','5675685854@qq.com','����ʡ�����������',1);

insert into emp values('e008','j002','lili','Ů',25,'123456',3500,
                              str_to_date('2015-2-23','%Y-%m-%d'),'13662266666','8948654656@qq.com','����ʡ������������',0);

insert into emp values('e002','j002','tom','��',28,'123456',5000,
                              str_to_date('2015-7-21','%Y-%m-%d'),'13888888888','2131241412@qq.com','����ʡ������ƽ����',0);

insert into emp values('e003','j003','amery','��',22,'123456',4500,
                              str_to_date('2015-8-22','%Y-%m-%d'),'13777777777','5675685854@qq.com','����ʡ�����и�����',0);

insert into emp values('e004','j004','rose','Ů',25,'123456',3500,
                              str_to_date('2014-10-23','%Y-%m-%d'),'13666222666','8948654656@qq.com','����ʡ�����й�����',0);

insert into emp values('e005','j002','jerry','��',22,'123456',4500,
                              str_to_date('2014-4-22','%Y-%m-%d'),'13772277777','5675685854@qq.com','����ʡ�����в�����',0);

insert into emp values('e006','j004','rose','Ů',25,'123456',3500,
                              str_to_date('2015-4-23','%Y-%m-%d'),'13666666666','8948654656@qq.com','����ʡ�����й�ҵ԰��',0);

insert into emp values('e009','j004','adou','Ů',25,'123456',3500,
                              str_to_date('2015-4-23','%Y-%m-%d'),'13666666666','8948654656@qq.com','����ʡ�����н�����',0);
insert into emp values('e010','j004','xujian','��',25,'123456',3500,
                              str_to_date('2015-4-23','%Y-%m-%d'),'13666666666','8948654656@qq.com','����ʡ�������żҸ���',0);

insert into emp values('e011','j004','wuwenqing','��',25,'123456',3500,
                              str_to_date('2015-4-23','%Y-%m-%d'),'13666666666','8948654656@qq.com','����ʡ�����г�����',0);

#--�û���
insert into users values('u001','����','��','13555555555',600,'����ʡ�����л�����',0);
insert into users values('u002','����','Ů','13444444444',2000,'����ʡ�����������',1);
insert into users values('u003','����','��','13222222222',100,'����ʡ������������',0);
insert into users values('u004','��һ','Ů','13555555555',200,'����ʡ������ƽ����',0);
insert into users values('u005','��һ','��','13444444444',2000,'����ʡ�����и�����',1);
insert into users values('u006','��һ','��','13224442222',300,'����ʡ�����й�����',0);
insert into users values('u007','����','Ů','13555445555',600,'����ʡ�����в�����',0);
insert into users values('u008','����','��','13444555444',1400,'����ʡ�����й�ҵ԰��',1);
insert into users values('u009','����','Ů','13222255222',1200,'����ʡ�����н�����',0);
insert into users values('u010','����','��','13222255222',1200,'����ʡ�������żҸ���',0);
insert into users values('u011','���','Ů','13222255222',1200,'����ʡ�����г�����',0);

#--��ϵ��
insert into cuisine values('c001','����');
insert into cuisine values('c002','��ʳ');
insert into cuisine values('c003','����');
insert into cuisine values('c004','����');
insert into cuisine values('c005','���Ͼ�ˮ');
insert into cuisine values('c006','����');
insert into cuisine values('c007','������');
insert into cuisine values('c008','����');

#--��Ʒ��
insert into dishes values('d001','c006','���ͳ���',58);
insert into dishes values('d002','c008','�ҳ�������',80);
insert into dishes values('d003','c008','���Ӽ���',60);
insert into dishes values('d004','c006','��������',50);
insert into dishes values('d005','c008','�Ĵ�����Ѽ',15);
insert into dishes values('d006','c006','��������˿',10);
insert into dishes values('d007','c007','��ζ�����',20);
insert into dishes values('d010','c007','���б�Ϻ',21);
insert into dishes values('d011','c002','�ϱ��������',15);
insert into dishes values('d012','c008','�ϱ����ⶡ������',80);
insert into dishes values('d013','c007','��֨��',70);
insert into dishes values('d014','c006','��ζ�϶�ѿ',50);
insert into dishes values('d015','c008','����С����',66);
insert into dishes values('d016','c008','ũ��ζ����',20);
insert into dishes values('d017','c003','ɽ�����',20);
insert into dishes values('d018','c008','��������',15);
insert into dishes values('d019','c006','зζ�ӱ���',10);
insert into dishes values('d020','c003','ԧ�쵰',20);
insert into dishes values('d021','c002','����������˳���',10);
insert into dishes values('d022','c008','��֦����',8);
insert into dishes values('d023','c008','Ȫ������',21);
insert into dishes values('d024','c002','�����',15);
insert into dishes values('d025','c008','������Ѽ',80);
insert into dishes values('d026','c004','����ζը����',70);
insert into dishes values('d027','c002','Ŵ�׼��Ⱦ�',50);
insert into dishes values('d028','c002','����С����',66);
insert into dishes values('d029','c001','��ź������',20);
insert into dishes values('d030','c001','�̶��ٺ�������',20);
insert into dishes values('d031','c001','��ĩ�����',15);
insert into dishes values('d032','c001','ɽҩ������',10);
insert into dishes values('d033','c001','ʯ��������',20);
insert into dishes values('d034','c001','���׺��ܲ��Ź���',10);
insert into dishes values('d035','c004','����',8);
insert into dishes values('d036','c004','��̢',21);
insert into dishes values('d037','c004','���',15);
insert into dishes values('d038','c004','��ʽ���',12);
insert into dishes values('d039','c004','�춹��',70);
insert into dishes values('d040','c004','��˿�㽶��',50);
insert into dishes values('d041','c004','����Ȧ',66);

insert into dishes values('d042','c005','�����֭',38);
insert into dishes values('d043','c005','���',21);
insert into dishes values('d044','c005','��β��',15);
insert into dishes values('d045','c005','��',80);
insert into dishes values('d046','c005','ơ��',70);
insert into dishes values('d047','c005','����',50);
insert into dishes values('d048','c003','����',38);
insert into dishes values('d049','c003','����',21);
insert into dishes values('d050','c003','������',15);
insert into dishes values('d051','c003','�ƹ�',80);
insert into dishes values('d052','c003','���',70);
insert into dishes values('d053','c003','��ĩ��',50);
insert into dishes values('d054','c003','��Ʒ����',15);
insert into dishes values('d055','c003','ľ��',80);
insert into dishes values('d056','c003','�ϲ�',70);
insert into dishes values('d057','c006','�ײ����������',21);
insert into dishes values('d058','c006','���ⴺ��',15);
insert into dishes values('d059','c006','�ε���������',80);
insert into dishes values('d060','c006','���軨��',70);
insert into dishes values('d061','c006','�����ܲ�˿',50);

UPDATE dishes set url='public/static/imgs/�ϲ�.jpg' where dishesno = 'd056';
UPDATE dishes set url='public/static/imgs/��� �ײ����������.jpg' where dishesno = 'd057';
UPDATE dishes set url='public/static/imgs/��� ���ⴺ��.gif' where dishesno = 'd058';
UPDATE dishes set url='public/static/imgs/��� �ε���������.jpg' where dishesno = 'd059';
UPDATE dishes set url='public/static/imgs/��� ���軨��.jpg' where dishesno = 'd060';

UPDATE dishes set url='public/static/imgs/����Ȧ.jpg' where dishesno = 'd041';
UPDATE dishes set url='public/static/imgs/�����֭.jpg' where dishesno = 'd042';
UPDATE dishes set url='public/static/imgs/���.jpg' where dishesno = 'd043';
UPDATE dishes set url='public/static/imgs/��β��.jpg' where dishesno = 'd044';
UPDATE dishes set url='public/static/imgs/��.jpg' where dishesno = 'd045';
UPDATE dishes set url='public/static/imgs/ơ��.jpg' where dishesno = 'd046';
UPDATE dishes set url='public/static/imgs/����.jpg' where dishesno = 'd048';
UPDATE dishes set url='public/static/imgs/����.jpg' where dishesno = 'd049';
UPDATE dishes set url='public/static/imgs/������.jpg' where dishesno = 'd050';
UPDATE dishes set url='public/static/imgs/�ƹ�.jpg' where dishesno = 'd051';

UPDATE dishes set url='public/static/imgs/��ĩ�����.png' where dishesno = 'd031';
UPDATE dishes set url='public/static/imgs/ɽҩ������.png' where dishesno = 'd032';
UPDATE dishes set url='public/static/imgs/ʯ��������.png' where dishesno = 'd033';
UPDATE dishes set url='public/static/imgs/���׺��ܲ��Ź���.png' where dishesno = 'd034';
UPDATE dishes set url='public/static/imgs/����.jpg' where dishesno = 'd035';
UPDATE dishes set url='public/static/imgs/��̢.jpg' where dishesno = 'd036';
UPDATE dishes set url='public/static/imgs/���.jpg' where dishesno = 'd037';
UPDATE dishes set url='public/static/imgs/��ʽ���.jpg' where dishesno = 'd038';
UPDATE dishes set url='public/static/imgs/�춹��.jpg' where dishesno = 'd039';
UPDATE dishes set url='public/static/imgs/��˿�㽶��.png' where dishesno = 'd040';

UPDATE dishes set url='public/static/imgs/����_���ͳ���.png' where dishesno = 'd001';
UPDATE dishes set url='public/static/imgs/���� �ҳ�������.png' where dishesno = 'd002';
UPDATE dishes set url='public/static/imgs/���� ���Ӽ���.jpg' where dishesno = 'd003';
UPDATE dishes set url='public/static/imgs/���� ��������.jpg' where dishesno = 'd004';
UPDATE dishes set url='public/static/imgs/���� �Ĵ�����Ѽ.png' where dishesno = 'd005';
UPDATE dishes set url='public/static/imgs/���� ��������˿.png' where dishesno = 'd006';
UPDATE dishes set url='public/static/imgs/��ζ�����.png' where dishesno = 'd007';
UPDATE dishes set url='public/static/imgs/���� ���б�Ϻ.jpg' where dishesno = 'd008';
UPDATE dishes set url='public/static/imgs/���� �ϱ��������.jpg' where dishesno = 'd009';
UPDATE dishes set url='public/static/imgs/���� ��֨��.jpg' where dishesno = 'd010';

UPDATE dishes set url='public/static/imgs/���� �ϱ��������.jpg' where dishesno = 'd011';
UPDATE dishes set url='public/static/imgs/���� �ϱ����ⶡ������.jpg' where dishesno = 'd012';
UPDATE dishes set url='public/static/imgs/���� ��֨��.jpg' where dishesno = 'd013';
UPDATE dishes set url='public/static/imgs/��ζ�϶�ѿ.png' where dishesno = 'd014';
UPDATE dishes set url='public/static/imgs/³�� ����С����.jpg' where dishesno = 'd015';
UPDATE dishes set url='public/static/imgs/³�� ũ��ζ����.png' where dishesno = 'd016';
UPDATE dishes set url='public/static/imgs/³�� ɽ�����.jpg' where dishesno = 'd017';
UPDATE dishes set url='public/static/imgs/³�� ��������.jpg' where dishesno = 'd018';
UPDATE dishes set url='public/static/imgs/³�� зζ�ӱ���.png' where dishesno = 'd019';
UPDATE dishes set url='public/static/imgs/³�� ԧ�쵰.jpg' where dishesno = 'd020';


UPDATE dishes set url='public/static/imgs/���� ����������˳���.png' where dishesno = 'd021';
UPDATE dishes set url='public/static/imgs/���� ��֦����.gif' where dishesno = 'd022';
UPDATE dishes set url='public/static/imgs/���� Ȫ������.jpg' where dishesno = 'd023';
UPDATE dishes set url='public/static/imgs/���� �����.gif' where dishesno = 'd024';
UPDATE dishes set url='public/static/imgs/���� ������Ѽ.jpg' where dishesno = 'd025';
UPDATE dishes set url='public/static/imgs/���� ������Ѽ.jpg' where dishesno = 'd026';
UPDATE dishes set url='public/static/imgs/���� ������Ѽ.jpg' where dishesno = 'd027';
UPDATE dishes set url='public/static/imgs/�ղ� ����С����.jpg' where dishesno = 'd028';
UPDATE dishes set url='public/static/imgs/��ź������.png' where dishesno = 'd029';
UPDATE dishes set url='public/static/imgs/�̶��ٺ�������.png' where dishesno = 'd030';



#--������
insert into board values('t001','һ����',1);
insert into board values('t002','������',0);
insert into board values('t003','������',0);
insert into board values('t004','�ĺ���',0);
insert into board values('t005','�����',0);
insert into board values('t006','������',0);
insert into board values('t007','�ߺ���',1);
insert into board values('t008','�˺���',0);
insert into board values('t009','�ź���',0);
insert into board values('t010','ʮ����',0);
insert into board values('t011','ʮһ����',0);

UPDATE board set remark='����������' where boardno = 't001';
UPDATE board set remark='����������' where boardno = 't002';
UPDATE board set remark='����������' where boardno = 't003';
UPDATE board set remark='������' where boardno = 't004';
UPDATE board set remark='������' where boardno = 't005';
UPDATE board set remark='������' where boardno = 't006';
UPDATE board set remark='������' where boardno = 't007';
UPDATE board set remark='������' where boardno = 't008';
UPDATE board set remark='������' where boardno = 't009';
UPDATE board set remark='������' where boardno = 't010';
UPDATE board set remark='����������' where boardno = 't011';

#--�˵���
insert into bill values('b001','��ĩ�ա�����С�����������ܲ�˿����̢');
insert into bill values('b002','��ĩ�����軨�ˡ��ε��������ӡ���̢��ɽҩ������');
insert into bill values('b003','���Ӽ�����Ŵ�׼��Ⱦ��ϲˡ�ơ��');
insert into bill values('b004','��ζ����㡢����С�����������ܲ�˿��ľ��');

#--������
insert into orders values('o001','b001','t001',str_to_date('2015-11-02 10:23:15','%Y-%m-%d %T'),200,0,0,null);
insert into orders values('o002','b002','t007',str_to_date('2015-10-20 15:23:15','%Y-%m-%d %T'),400,1,0,null);
insert into orders values('o003','b003','t002',str_to_date('2015-3-02 20:23:15','%Y-%m-%d %T'),200,0,1,null);
insert into orders values('o004','b004','t007',str_to_date('2015-4-20 12:23:15','%Y-%m-%d %T'),400,0,1,null);

