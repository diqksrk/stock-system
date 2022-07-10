# stock-system

### 1. 사용한 기술스택 목록<br/>
BACK END<br/>
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=Java&logoColor=white">
<img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white">
<img src="https://img.shields.io/badge/JPA-6DB33F?style=for-the-badge&logo=JPA&logoColor=white">  
<img src="https://img.shields.io/badge/Swagger-007396?style=for-the-badge&logo=Swagger&logoColor=white">
<img src="https://img.shields.io/badge/Hateoas-4479A1?style=for-the-badge&logo=Hateoas&logoColor=white">
<img src="https://img.shields.io/badge/Spring Validation-6DB33F?style=for-the-badge&logo=Spring Validation&logoColor=white">
<img src="https://img.shields.io/badge/H2-6DB33F?style=for-the-badge&logo=H2&logoColor=white">  

### 2. ERD<br/>
![image](https://user-images.githubusercontent.com/31757314/178143398-e20a6208-5d3b-4bf3-b753-cde0db252631.png)

### 3. ProJect Folder 구조<br/>
![image](https://user-images.githubusercontent.com/31757314/178143417-c1c9fb71-b671-4ef6-bb7d-dbe199c9ee99.png)<br/>
Hexagonal Architecture참조. <br/>
application : Service 및 응답 Response 위치 <br/>
Domain Model : Domain Entity 및 중요 비즈니스 로직 위치.<br/>
Infrastructure : 공통 클래스 및 설정 파일 위치<br/>
presentation : Controller 및 Request 요청 클래스 위치.<br/>
Domain 역할과 비즈니스 로직과 외부 계층과의 의존성과 결합도를 최소화하고 싶었습니다.<br/>
그래서 <br/>
Presentation layer : 외부 요청을 처리하는 영역<br/>
Infrastructure layer : 설정과 전반적인 layer에게 영향을 끼치는 영역<br/>
Domain Layer : 핵심적인 비즈니스 로직을 담당하는 영역<br/>
Application layer : 외부 영역과 Domain 영역 사이에서 추상화 역할을 담당하여 연결을 담당하는 영역<br/>
으로 나누었습니다.<br/>

### 4. API<br/>
![image](https://user-images.githubusercontent.com/31757314/178143620-bad1d7dc-715f-4032-b55b-f9fca2714bc9.png)

### 5. API Detail<br/>
![image](https://user-images.githubusercontent.com/31757314/178143680-aba33b87-d3c4-447b-ae28-4830ed0ada36.png)
page 처리 및 Hateoas를 통한 Self Link 및 관련 Link까지 API를 통해 전송


