개발 스택 : JAVA 17, Springboot 3.2.2 , gradle, H2 Database
문서화 도구 : OpenAPI 3.0

실행방법
[1]
H2 데이터베이스 다운 :
1. https://www.h2database.com/html/download.html
2. 시작 메뉴에서 H2 > H2 Console 혹은 설치 폴더의 bin\h2.bat 파일을 실행
3. 실행 후 데이터베이스 연결
4. JDBC URL : jdbc:h2:tcp://localhost/~/jpashop

![image](https://github.com/yunaahn/news/assets/86057836/2571c127-7c71-4e76-9b7a-618e0b515959)


[2]
프로젝트 빌드 후 http://localhost:8081/swagger-ui 로 연결

[3]
API test 

화면

![image](https://github.com/yunaahn/news/assets/86057836/1401065c-074f-45b2-a236-0cfad7b1faf4)

