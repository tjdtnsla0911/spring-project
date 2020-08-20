## create + insert

###################
```SQL
select * from user;

CREATE TABLE product (
	id int auto_increment primary key,
    title varchar(100) not null,
    thumb varchar(1500) not null,
    price int,
    disc varchar(100), #설명
    ad varchar(1500) not null, #광고 #메인에 걸꺼냐 안걸꺼냐
    discounted  int,
    content longtext,
    categoryId int, #1이면 개별상품 2면 세트상품
    bgImg varchar(1500) not null #메인 ㅈㄴ큰 사진 경로
) engine=InnoDB default charset=utf8;
select * from product;
CREATE TABLE product_status  (
	id int auto_increment primary key,
    sale boolean, #여긴 일단 null안해놧음 sale 없을수도있으니까
    newly  boolean, #여긴 몰라서 boolean 함
    best  boolean, #미투
    productId int
) engine=InnoDB default charset=utf8;
select * from product_status;
commit;

CREATE TABLE review   (
	id int auto_increment primary key,
    productId  int,
    content   varchar(500),
    userId  int,
    createDate timestamp,
    star int, #난 예전에 별개수를 int로 바꿔서 넣어서 일단 int로 했음
    img varchar(1500),
    existenceOfImg boolean, #이미지 올린놈인지아닌지
    orderId int #결제방법때문에필요
) engine=InnoDB default charset=utf8;
select * from review;
commit;
CREATE TABLE recomment   (
	id int auto_increment primary key,
    reviewId  int,
    comment   varchar(2000),
    createDate  timestamp
) engine=InnoDB default charset=utf8;
select * from recomment;
commit;
CREATE TABLE user   (
	id int auto_increment primary key,
    username varchar(300),
    password  varchar(1500),
    email  varchar(1500),
    name   varchar(200),
    gender  varchar(100), #boolean 인가? 헷갈리는데 varchar함
    phone varchar(1500),
    address varchar(2000),
    detail_address varchar(1500),
	provider varchar(2000), #이건 구글로 로그인하는사람 땜시 필요합니다.
    providerId varchar(2000),#이것도 구글로 로그인하는사람 땜시 필요합니다.
    birthday timestamp, #2020-12-21식으로넣을꺼 생각해서 varchar함
    total_amount int,
    role varchar(150),
    cancel varchar(1000), #취소 헷갈려서 varchar함 boolean 같은데..
    profile varchar(4500),
createDate timestamp
) engine=InnoDB default charset=utf8;


CREATE TABLE notice   (
	id int auto_increment primary key,
    title  varchar(1500),
    content   varchar(1000),
    createDate  timestamp,
    readCount int, #개수니까 int겟지?
    thumb varchar(2000)
) engine=InnoDB default charset=utf8;
select * from notice;
commit;
CREATE TABLE qna   (
	id int auto_increment primary key,
    title  varchar(1500),
    content   varchar(1000),
    createDate  timestamp,
    userId int,
    answer boolean ,
    productid int
) engine=InnoDB default charset=utf8;

drop table qna;

select * from qna;
commit;
CREATE TABLE orders   (
	id int auto_increment primary key,
    userId  int,
    orderDate   timestamp,
    totalPrice  int,
    howToPay varchar(300) #결제수단넣는건가 varchar인가?

) engine=InnoDB default charset=utf8;
select * from orders;

commit;
CREATE TABLE orders_detail   (
	id int auto_increment primary key,
    orderId  int,
    quantity   int,  #몇개냐 이말
    price  int,
    stats varchar(200) # 상태니까 boolean 해봄 헷갈림 ㅠ
) engine=InnoDB default charset=utf8;
select * from orders_detail;
commit;
CREATE TABLE wishlist   (
	id int auto_increment primary key,
    userId  int,
    productId   int
  ) engine=InnoDB default charset=utf8;
  select * from wishlist;
  commit;

CREATE TABLE coupon   (
	id int auto_increment primary key,
    userId  int,
    code   varchar(1000),
    start  date, #이건 일단 date타입으로해봄 나중에고치기바랍니다.
    end date,
    availability boolean# boolean 으로해봄 유효성 헷갈림

) engine=InnoDB default charset=utf8;

commit;
CREATE TABLE point   (
	id int auto_increment primary key,
    userId  int,
    date date, #이것도 일단 date타입으로함 입출금
    reason   varchar(500), #이유라서 varchar함
    point int,
    totalPoint int
) engine=InnoDB default charset=utf8;
select * from point;
commit;

commit;
CREATE TABLE related_product   ( #관련상품
	id int auto_increment primary key,
    parentProductId  int, #
    relatedProductId int
) engine=InnoDB default charset=utf8;
select * from related_product;
commit;
CREATE TABLE category   (
	id int auto_increment primary key,
    type  varchar(200), #type 헷갈려서 여긴 varchar함,
    parentTypeId int
) engine=InnoDB default charset=utf8;
select * from category;
commit;
##더미데이터

#user 더미 데이터
insert into user(id,username,password,email,name,gender,phone,address,detail_address,birthday,total_amount,role,cancel,profile,createDate,provider,providerId)
values(1,'cos','cos1234','tjdtnsla0321@nate.com','최주호','남','010-2222-7460','부산광역시 진구','서면 파이널센터 4층','1985-02-01',120000,'User','취소','사진경로',now(),"일반유저입니다","일반유저입니다.");

insert into user(id,username,password,email,name,gender,phone,address,detail_address,birthday,total_amount,role,cancel,profile,createDate,provider,providerId)
values(2,'tjdtn','tjdtn123','tjdd@nate.com','김성수','남','010-0000-0000','경북 포항시','북구 학잠동','1993-09-11',200000,'User','취소','사진경로',now(),"일반유저입니다","일반유저입니다.");

insert into user(id,username,password,email,name,gender,phone,address,detail_address,birthday,total_amount,role,cancel,profile,createDate,provider,providerId)
values(3,'tjsgus','tjsgus123','tjsgus@nate.com','문선현','여','010-1111-1111','부산광역시 어딘가','남포동 아파트','1993-12-31',50000,'User','취소','사진경로',now(),"일반유저입니다","일반유저입니다.");

insert into user(id,username,password,email,name,gender,phone,address,detail_address,birthday,total_amount,role,cancel,profile,createDate,provider,providerId)
values(4,'dnjswo','dnjswo1234','dnjswop321@nate.com','최원재','남','010-2322-7440','부산광역시 연산','연산역 집','1992-01-01',2000,'User','취소','사진경로',now(),"일반유저입니다","일반유저입니다.");

#product 더미데이터
insert into product(id,title,thumb,price,disc,ad,content,categoryId,bgImg) #여긴 sale없어서 null넣을려고 안넣엇습니다
values (1,'프레시 런드리 디터전트','thumb의 경로1',28000,'베이비 런드리 디터전트(무향)1L*1ea',true,'content1',1,'bgImg의 경로1');
insert into product(id,title,thumb,price,disc,ad,discounted,content,categoryId,bgImg)
values (2,'패밀리 키친 세트','thumb의 경로2',40000,'프레시 디시 앤 프루트 워시 (오렌지) 500ml * 1ea 베이비 보틀 앤 토이 워시 (무향) 500ml * 1ea',true,34000,'content2',2,'bgImg의 경로2');
insert into product(id,title,thumb,price,disc,ad,discounted,content,categoryId,bgImg)
values (3,'기프트 세트','thumb의 경로3',63000,'OPTION. 구성품 택1 (키친 세트,리빙케어 세트, 런드미 세트중) OPTION 2. 박스 색상 택1 (프레시 네이버,베이비 민트 중)',false,39000,'content3',2,'bgImg의 경로3');

#product_status 더미데이터
insert into product_status(id,sale,newly, best,productId)
values(1,false,true,false,1);
insert into product_status(id,sale,newly, best,productId)
values(2,true,true,true,2);
insert into product_status(id,sale,newly, best,productId)
values(3,true,false,false,3);
select * from product_status;


#review 더미데이터
insert into review(id,productId,content,userId,createDate,star,img,existenceOfImg,orderId)
values(1,1,'너무비싸서 놀랫네요..',1,now(),5,'img의 경로1',true,1);
insert into review(id,productId,content,userId,createDate,star,img,existenceOfImg,orderId)
values(2,2,'아르아르 믿을수가없다',2,now(),1,'img의 경로2',true,1);
insert into review(id,productId,content,userId,createDate,star,img,existenceOfImg,orderId)
values(3,1,'너무비싸서 놀랫네요..',1,now(),3,'img의 경로1',true,1);
select * from review;


#recomment 더미데이터
insert into recomment(reviewId,comment,createDate)
values (1,'고객님 너무비싸서 죄송합니다 ㅠ^ㅠ 그래도 사세요 ㅠ',now());
insert into recomment(reviewId,comment,createDate)
values (2,'사랑합니다 고객님 ^^',now());
insert into recomment(reviewId,comment,createDate)
values (3,'참신한 아르아르가 되겟습니다',now());
select * from recomment;

#notice 더미데이터

insert into notice(title,content,createDate,readcount,thumb)
values ('★경★아르아르 폐쇠★축★','2020년09월10일 아르아르가 드디어 역사속으로 사라집니다.',now(),1,'thumb의 경로1');
insert into notice(title,content,createDate,readcount,thumb)
values ('[EVENT]아르아르 우한점 오픈기념 코로나 1+1 이벤트','중국 우한점 오픈기념으로인한 제품구매시 증정품은 코로나를 1+1으로 2개를 드립니다',now(),1,'thumb의 경로2');
select * from notice;

#qna 더미데이터
insert into qna(title,content,createDate,userId,answer,productid)
values ('배송문의','신청한지 1년이넘었는데 죽기전 까진오겟죠?',now(),1,true,1);
insert into qna(title,content,createDate,userId,answer,productid)
values ('품질에 이상이있어요..','비누에서 거품이나요..',now(),2,true,1);
insert into qna(title,content,createDate,userId,answer,productid)
values ('품질에 이상이있어요..','비누에서 거품이나요..',now(),2,true,2);
insert into qna(title,content,createDate,userId,answer,productid)
values ('품질에 이상이있어요..','비누에서 거품이나요..',now(),2,true,3);
insert into qna(title,content,createDate,userId,answer,productid)
values ('품질에 이상이있어요..','비누에서 거품이나요..',now(),1,true,2);
select * from qna;

#orders 더미데이터
insert into orders(userId,orderDate,totalPrice,howToPay)
values(1,now(),68000,'카카오페이');
select * from orders;

#orders_detail 더미데이터
insert into orders_detail(orderId,quantity,price,stats)
values (1,1,28000,'배송중');
insert into orders_detail(orderId,quantity,price,stats)
values (1,1,40000,'배송중');
select * from orders_detail;
#wishlist 더미데이터
insert into wishlist(userid,productId)values(1,1);
 insert into wishlist(userid,productId)values(1,2);
insert into wishlist(userid,productId)values(1,3);
select * from wishlist;

#coupon 더미데이터
insert into coupon(userId,code,start,end,availability)
values(1,'1111-2222-3333-4444',now(),now(),true);
insert into coupon(userId,code,start,end,availability)
values(2,'1212-2222-3333-4444',now(),now(),true);
insert into coupon(userId,code,start,end,availability)
values(3,'4442-2522-9333-4444',now(),now(),true);
select * from coupon;

#point 더미데이터
insert into point(userId,date,reason,point,totalPoint)
values(1,now(),'썻으니까',2000,50000);
insert into point(userId,date,reason,point,totalPoint)
values(2,now(),'사용했으니까',1500,20000);
insert into point(userId,date,reason,point,totalPoint)
values(3,now(),'출금했으니까',1000,5200);
select * from point;


#related_product 더미데이터

select * from related_product;
insert into related_product(parentProductId,relatedProductId)
values (1,3);
insert into related_product(parentProductId,relatedProductId)
values (2,1);
insert into related_product(parentProductId,relatedProductId)
values (3,3);
insert into related_product(parentProductId,relatedProductId)
values (1,2);

#category 더미데이터
insert into category(type,parentTypeId)
values ("싱글상품",1);
insert into category(type,parentTypeId)
values ("세트상품",2);
select * from category;


################## 쿼리문 ##########################

#######################index페이지########################################

select * from user;
select * from product;
select * from review;
select * from product_status;

select pro.title,rev.title,rev.img
from  product pro inner JOIN review rev inner JOIN product_status pst  inner JOIN user us
on  pro.id = rev.id and us.id = rev.userid and pro.id=1
group by  pro.id;

select pro.title,pro.price,pro.discounted,pst.sale,pst.best,pst.newly
from product pro inner JOIN product_status pst  inner JOIN review rev  inner JOIN user us
on pro.id= pst.productId
group by pro.id;



#--------- 합치기전 -----------------------
select pro.title,rev.title,rev.img,us.name
from product pro,review rev,user us
where pro.id = rev.id and us.id = rev.userid and pro.id=1;


select pro.title,pro.price,pro.discounted,pst.sale,pst.best,pst.newly
from product pro inner JOIN product_status pst
on pro.id= pst.productId;
#----------------------------------------

############################상품클릭시###################################
# 일단 count 뺴고 다해놧음(구매평)
select pro.title,pro.discounted,pro.sale,pst.sale,pst.best,pst.newly,
pro.id,rev.star,rev.img,us.username,rev.createdate,rc.comment,rc.createdate
from product pro inner JOIN product_status pst inner JOIN review rev
inner join user us inner join recomment rc
on pro.id= pst.productId and rev.productId = pro.id and us.id = rev.userid and rc.reviewId=rev.id and pro.id=1;


#이것도 count 뺴고 다해놧음(Qna 리스트)
select q.answer,q.title,us.username,q.createdate
from user us inner join qna q inner join product pro
on us.id = q.userid and q.productid = pro.id and us.id=2;


select * from product p INNER JOIN product_status ps INNER JOIN related_product rp
on p.id=ps.productId and p.id = rp.relatedProductId and rp.parentProductId=1;





select * from product p INNER JOIN product_status ps INNER JOIN related_product rp
on p.id=ps.productId and p.id = rp.relatedProductId and p.id=1 in(select p2.id from product p2
);
```
