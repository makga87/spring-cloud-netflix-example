# spring-cloud-netflix-example
- MSA 시스템을 가벼운 예제를 통해 구축해보기.
- 멀티모듈로 작성하였으며, 각 테스트한 코드는 단계별로 tag를 붙였습니다.
- 작업예제가 단순하고, 미흡점이 많습니다. 기능 동작의 참조용 정도로 체크하시면 될 것 같습니다.


### 1. git으로 현재 repository를 clone 한다.
    git clone https://github.com/makga87/spring-cloud-netflix-example.git




### 2. step0 : eureka 서버, 클라이언트 1대씩 띄워보기.
- 클론된 디렉터리로 들어가서 git bash를 띄운 후, step0으로 체크아웃
    git checkout step0

- 체크아웃을 완료하면, sts File - Open Projects from File System을 이용하여 Import 해줍니다.
- Import가 완료 되면, 등록된 eureka-server, user 모듈을 실행해줍니다.
- http://localhost:8761로 접속하여, eureka-server 대시보드를 확인합니다.




### 3. step1 : eureka 클라이언트를 추가 등록해보기.
    git checkout step1

- 체크아웃이 완료되면, 추가된 status, customer-service 모듈을 import 후, 실행해줍니다.
- http://localhost:8761로 접속하여, eureka-server 대시보드를 확인합니다.




### 4. step2 : zuull proxy를 이용하여, api gateway 기능 실행해보기.
    git checkout step2

- 추가된 api-gateway 프로젝트를 import 후, 실행해줍니다.
- api-gateway의 주소인 http://localhost:7777 로, request 요청을 보내줍니다.
- (요청 전문의 body는 없고 uri만 존재하며, 각 모듈들의 controller에서 확인가능합니다.)




### 5. step3 : loadbalance 기능 적용해보기.
    git checkout step3

- 추가된 status-peer 모듈을 import 후, 실행해줍니다.
- api-gateway를 통하여, status 쪽으로 요청을 날려보고, 응답 코드를 확인합니다.




### 6. step4 : hystrix를 이용하여, 장애상황 대처해보기.
    git checkout step4

- 추가된 platform-connector, hura-platform 모듈을 import 후, 실행해 줍니다.
- api-gateway를 통하여, platform-connector쪽으로 5회이상 요청을 보내며, 서킷브레이커의 활성화를 확인합니다.
- (필수) api-gateway의 application.yml 중, eureka.client.service-url.registry-fetch-interval-seconds 값을 변경 후, 테스트 바랍니다.



### 7. step5 : zipkin, sleuth 로 분산 시스템 로깅해보기
    git checkout step5
- zipkin 적용을 위해, 공식 사이트의 가이드를 따릅니다. [zipkin 공식홈페이지-quickstart](https://zipkin.io/pages/quickstart.html)
- 지금까지 등록된 모듈 중, 하나를 택하여 요청전문을 보낸 후, http://localhost:9411 로 접속하여, 로깅된 내용을 확인합니다.


