# worksheet討論
github連結 : [https://github.com/willieooq/time_sheet](https://github.com/willieooq/time_sheet)
# TABLE
## member account:
![](https://i.imgur.com/lMOoF3s.png)
```
create table `member_account`(
    `Id` int auto_increment not null ,
   `Name` varchar(40) unique not null ,
   `Password` varchar(45) not null ,
   `LastLogin` date  ,
   primary key (ID,NAME),
    `Role` enum('MEMBER','ADMIN') not null default 'MEMBER')
```
## work_time:
![](https://i.imgur.com/xLjfW82.png)

```
create table `work_time`(
    `Id` int auto_increment not null primary key ,
   `UserId` varchar(40) not null ,
   `Date` date not null ,
   `StartTime` time not null  ,
   `EndTime` time not null ,
   `Platform` varchar(30) not null ,
   `Detail` varchar(30) not null ,
   constraint fk_UserId_Name foreign key (UserId) references memberaccount(Name),
   constraint fk_P_D foreign key (Platform,Detail) references work(Platform,Detail));
```
## work
![](https://i.imgur.com/a21hwsR.png)

```
create table `work`(
   `Platform` varchar(40) not null ,
   `Detail` varchar(40) not null ,
   `PcCode` varchar(4) not null  unique ,
   `Description` varchar(40) ,
   `CreatedBy` varchar(40) not null,
   `CreationDate` date not null,
   `ModifiedBy` varchar(40),
   `ModificationDate` date);
```
```
CreatedBy --- reference MemberAccount.ID
	
CreationDate --- GateDate(), Date Format: yyyy/MM/dd
	
ModifiedBy --- reference MemberAccount.ID
	
ModificationDate --- GateDate(), Date Format: yyyy/MM/dd
```
## 欲增加的Data:
薪資計算趴數(income_percentage) for HR 圓餅圖


## Data Base
Mysql
```
#Mysql
spring.datasource.url=jdbc:mysql://localhost:3306/time_sheet?characterEncoding=UTF-8
spring.datasource.username=root
spring.datasource.password=admin
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```


## 系統前端
#### 電腦版網頁

#### 登入頁面
- [x] 1. 帳號密碼登入
- [ ] 2. 註冊
- [ ] 3. 忘記密碼
![](https://i.imgur.com/E3osS42.png)
#### 輸入資料頁面
  新增資料功能已完成
![](https://i.imgur.com/iwoSpsY.png)
#### 註冊帳號頁面
尚未實裝(待討論可行性)
![](https://i.imgur.com/wY9KR1y.png)

## 系統後端
- [x] 1. 登入功能(Spring Security)
- [x] 2. 新增工作紀錄
- [ ] 3. 查看工作紀錄(進行中)
- [ ] 4. 刪除工作紀錄
- [ ] 4. 權限控制解決方法(無法使用@ROLLALLOWED註解)


# 代辦事項:
1. 很久沒填(2DAYS)登入要有提醒
1. 超過工時(7.5HR)提示報加班


### 側邊選單(except login_page)
1. 變更個人資料
2. 登記工作時數
3. 新增工作項目
4. 工作日誌(包含刪除功能)--自己
5. 工作日誌--主管(Admin)
6. 產出報表(Admin)
> 註記:4,5先合併 之後視討論決定

# 個人紀錄專區
#### Jerry: 
> 1. 前端頁  
> ~~2. 下拉式選單~~(小bug, 只能用chrome, edge, safari去開)  
> 3. host頁面  
> 4. description  
> ~~4. input格式~~  
> 6. 側面選單
> 7. 登入登出
> 8. 觀看所有人的時間形成  
~~7. code share(main problem!!!)~~
#### Willie:
> 1. ~~實現登陸~~
> 2. Roles(先放置)
> 3. ~~session新增~~(改為使用spring security)
> 4. ~~新增表單~~
> 5. 查看紀錄
> #### Spring
> 我覺得接下來你可以準備研究SpringBoot的東西
> 可以參考以下網站
> https://www.springcloud.cc/spring-boot.html
> https://how2j.cn/k/springboot/springboot-eclipse/1640.html
> https://blog.csdn.net/qq_25083447/article/details/106310201
> https://www.books.com.tw/products/0010865153

### 臨時要丟東西用
