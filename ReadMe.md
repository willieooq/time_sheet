# worksheet討論
## TABLE

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
2. USER_ID *(foreign key (USERID) references memberaccount(NAME))*
3. year-month-date
4. start_time(H-M)
5. end_time(H-M)
6. platform
7. detail
 ![](https://i.imgur.com/rnnsBHr.png)


#### 工作類別、項目
1. plateform
2. task
3. opcode
4. description

due next Mon
#### Jerry: 
1. 前端頁
~~2. 下拉式選單~~(小bug, 只能用chrome, edge, safari去開)
3. host頁面
4. description
~~5. input格式~~
6. 側面選單
7. 登入登出
8. 觀看所有人的時間形成
~~7. code share(main problem!!!)~~
#### Willie:
1. 實現登陸
2. Roles(先放置)
3. ~~session新增~~(改為使用spring security)
4. 新增表單
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
org.apache.ibatis.binding.BindingException: Invalid bound statement (not found): com.timesheet.mapper.WorkTimeMapper.insert
	at org.apache.ibatis.binding.MapperMethod$SqlCommand.<init>(MapperMethod.java:235)
	at org.apache.ibatis.binding.MapperMethod.<init>(MapperMethod.java:53)
	at org.apache.ibatis.binding.MapperProxy.lambda$cachedInvoker$0(MapperProxy.java:108)
	at java.base/java.util.concurrent.ConcurrentHashMap.computeIfAbsent(ConcurrentHashMap.java:1705)
	at org.apache.ibatis.util.MapUtil.computeIfAbsent(MapUtil.java:36)
	at org.apache.ibatis.binding.MapperProxy.cachedInvoker(MapperProxy.java:95)
	at org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:86)
	at com.sun.proxy.$Proxy106.insert(Unknown Source)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:344)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:198)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)
	at org.springframework.dao.support.PersistenceExceptionTranslationInterceptor.invoke(PersistenceExceptionTranslationInterceptor.java:137)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:215)
	at com.sun.proxy.$Proxy107.insert(Unknown Source)
	at com.timesheet.service.UserService.new_work(UserService.java:35)
	at com.timesheet.controller.MemberController.insert(MemberController.java:80)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:197)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:141)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:895)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1064)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:963)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:909)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:681)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:228)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:163)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:190)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:163)
	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:327)
	at org.springframework.security.web.access.intercept.FilterSecurityInterceptor.invoke(FilterSecurityInterceptor.java:115)
	at org.springframework.security.web.access.intercept.FilterSecurityInterceptor.doFilter(FilterSecurityInterceptor.java:81)
	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)
	at org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:121)
	at org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:115)
	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)
	at org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:126)
	at org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:81)
	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)
	at org.springframework.security.web.authentication.AnonymousAuthenticationFilter.doFilter(AnonymousAuthenticationFilter.java:105)
	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)
	at org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationFilter.doFilter(RememberMeAuthenticationFilter.java:101)
	at org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationFilter.doFilter(RememberMeAuthenticationFilter.java:92)
	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)
	at org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter.doFilter(SecurityContextHolderAwareRequestFilter.java:149)
	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)
	at org.springframework.security.web.savedrequest.RequestCacheAwareFilter.doFilter(RequestCacheAwareFilter.java:63)
	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)
	at org.springframework.security.web.authentication.www.BasicAuthenticationFilter.doFilterInternal(BasicAuthenticationFilter.java:149)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)
	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)
	at org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter.doFilter(AbstractAuthenticationProcessingFilter.java:218)
	at org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter.doFilter(AbstractAuthenticationProcessingFilter.java:212)
	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)
	at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:103)
	at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:89)
	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)
	at org.springframework.security.web.header.HeaderWriterFilter.doHeadersAfter(HeaderWriterFilter.java:90)
	at org.springframework.security.web.header.HeaderWriterFilter.doFilterInternal(HeaderWriterFilter.java:75)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)
	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)
	at org.springframework.security.web.context.SecurityContextPersistenceFilter.doFilter(SecurityContextPersistenceFilter.java:110)
	at org.springframework.security.web.context.SecurityContextPersistenceFilter.doFilter(SecurityContextPersistenceFilter.java:80)
	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)
	at org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter.doFilterInternal(WebAsyncManagerIntegrationFilter.java:55)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)
	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)
	at org.springframework.security.web.FilterChainProxy.doFilterInternal(FilterChainProxy.java:211)
	at org.springframework.security.web.FilterChainProxy.doFilter(FilterChainProxy.java:183)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:358)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:271)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:190)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:163)
	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:190)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:163)
	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:190)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:163)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:190)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:163)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:202)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:97)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:542)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:143)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:78)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:357)
	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:382)
	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65)
	at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:893)
	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1723)
	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.base/java.lang.Thread.run(Thread.java:834)
not null login service
2021-08-06 16:22:56.177 DEBUG 27848 --- [nio-8080-exec-9] c.t.mapper.MemberMapper.set_login_date   : ==>  Preparing: update memberaccount set LAST_LOGIN = CURDATE() where NAME = ?
2021-08-06 16:22:56.177 DEBUG 27848 --- [nio-8080-exec-9] c.t.mapper.MemberMapper.set_login_date   : ==> Parameters: willie(String)
2021-08-06 16:22:56.178 DEBUG 27848 --- [nio-8080-exec-9] c.t.mapper.MemberMapper.set_login_date   : <==    Updates: 1
2021-08-06 16:22:56.179 DEBUG 27848 --- [nio-8080-exec-9] c.t.mapper.MemberMapper.set_login_date   : ==>  Preparing: update memberaccount set LAST_LOGIN = CURDATE() where NAME = ?
2021-08-06 16:22:56.179 DEBUG 27848 --- [nio-8080-exec-9] c.t.mapper.MemberMapper.set_login_date   : ==> Parameters: willie(String)
2021-08-06 16:22:56.180 DEBUG 27848 --- [nio-8080-exec-9] c.t.mapper.MemberMapper.set_login_date   : <==    Updates: 1
willie

