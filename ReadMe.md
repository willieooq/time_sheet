[](https://)# worksheet討論
## 連接前後端: Postman
https://www.postman.com/
## 連接資料庫
https://ithelp.ithome.com.tw/articles/10187676

## 表格格式(Data部分)
worktime:
一人一張表
Time sheet現有的Data:
工作項目(job_type)
工種(T&D C2MA I&I DBTW Card+ FR Other iReward CFTW Fulfill)
 ![glossary](https://i.imgur.com/KbRHNu1.png "類別")


名子(name)
工作在一個項目的時間(time_in_worktype)
行程表(schedule)
一天工作總時(total)

## 欲增加的Data:
~~工作進度(description)~~
每人平均工時
薪資計算趴數(income_percentage) for HR 圓餅圖


## Data Base
SQL?
~~docker container?(connect bridge between HR and IT)~~


## 系統前端  (跟Ryan討論)
#### 電腦版網頁
![](https://i.imgur.com/E3osS42.png)



#### 登入頁面(7/14)
1. 帳號密碼登入
2. 註冊
3. 更改密碼
#### 輸入資料頁面
1. 日期
2. 時間(開始&結束)
3. platform
4. 上傳

## 系統後端
java spring
~~他們好像要開ec2給我們，但還不確定~~
local為優先
password改成*
給HR?
data
![資料格式](https://i.imgur.com/bmnVh6Q.png)

給IT?
~~description~~
~~工種時數表~~

## Debug
加班，正常工時
一天24hr

## Ryan 要求:
很久沒填(2DAYS)
超過工時(7.5HR)


# 工作:
## main
1. 串版面
2. 修改input
3. 下拉式選單
4. Description(工作類別)
5. host的版面(待討論)
6. 工時提醒
7. 
## 側邊選單(except login_page)
1. 變更個人資料
2. 登記工作時數
3. 新增工作項目
4. 工作日誌(包含刪除功能)--自己
5. 工作日誌--主管(權限設定)
6. 產出報表(權限設定)

## data base表單設定

#### 人事資料
1. ID(流水號)
2. email
3. password
4. Rank(在討論) 
5. last login
#### 公用時間表格
1. ID(流水號)
2. year-month-date
3. start_time(H-M)
4. end_time(H-M)
5. platform
6. detail
 ![](https://i.imgur.com/XSkyxFI.png)

#### 工作類別、項目
1. plateform
2. task
3. opcode
4. description

due next Mon
#### Jerry: 
1. 前端頁
2. 下拉式選單
3. host頁面
4. description
5. input格式
6. 側面選單
~~7. code share(main problem!!!)~~
#### Willie:
1. 串前後端(main problem)
2. 新增表單
#### Spring
我覺得接下來你可以準備研究SpringBoot的東西
可以參考以下網站
https://www.springcloud.cc/spring-boot.html
https://how2j.cn/k/springboot/springboot-eclipse/1640.html
https://blog.csdn.net/qq_25083447/article/details/106310201
https://www.books.com.tw/products/0010865153
###### Tues:
meeting(對帳號資料登入)

###### Wednes:
Ryan 的要求



## 進度
前端頁:
