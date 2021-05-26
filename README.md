# hello-spring
스프링 뿌셔 2


### intellij 꿀 단축키 모음 1
- <kbd>cmd</kbd> + <kbd>n</kbd> : 만능생성 (클래스든 패키지든 생성자든 뭐든!)
- <kbd>cmd</kbd> + <kbd>shift</kbd> + <kbd>enter</kbd> : 만능 끝맺음 (닫는중괄호 + 세미콜론 이런거 그냥 다 해결해줌)
- 프로젝트탭 <-> 에디터 : <kbd>cmd</kbd> + <kbd>1</kbd> <-> <kbd>esc</kbd>



### intellij 꿀 단축키 모음 2
- <kbd>ctrl</kbd> + <kbd>r</kbd> : 이전 실행 반복
- <kbd>cmd</kbd> + <kbd>shift</kbd> + <kbd>T</kbd> : 테스트 자동생성
- <kbd>cmd</kbd> + <kbd>opt</kbd> + <kbd>v</kbd>: 담겨질 객체 자동완성
- <kbd>ctrl</kbd> + <kbd>t</kbd> : 함수로 뽑아내기
- <kbd>ctrl</kbd> + <kbd>r</kbd> : 이전에 실행한 앱실행 or 테스트 재실행
- <kbd>shift</kbd> + <kbd>F6</kbd> : 해당 문단 내 단어 일괄 바꾸기



### 스프링 기본 디자인패턴
- controller : 익숙하지? 해당 uri로 요청받아 넘겨주는 역할
- domain : 속성/getter&setter만 들어가있는 순수한 클래스
- repository : 개발자와 db에 가까운 함수. save, findby.. 등.
- service : 사용자와 기능에 가까운 함수. 회원가입, 검증 등등.



### tmis
- 현업에선 로그찍을때 System.out.println을 거의 안씀.
- 대신 java.util.logging을 많이 씀 : logback & slf4j