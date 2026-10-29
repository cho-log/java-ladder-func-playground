# 사다리 게임

## 3단계 - 사다리 타기

- 시작 위치는 왼쪽부터 0으로 표시한다.
- 각 줄에서 왼쪽 연결이 있으면 왼쪽, 오른쪽 연결이 있으면 오른쪽으로 한 번 이동한다.
- 연결이 없으면 현재 위치를 유지한다.
- 마지막 줄까지 이동한 뒤 시작점과 도착점을 출력한다.
- Position은 위치를, Direction은 이동 방향을, LadderPath는 시작과 도착을 표현한다.

요구사항: [3단계 - 사다리 타기](https://edu.nextstep.camp/s/EaGHivA8/ls/UOVOrjPW)

## 2단계 - 사다리 생성

- 입력한 넓이와 높이에 맞춰 사다리를 생성한다.
- 넓이와 높이는 각각 1 이상의 정수로 입력한다.
- LadderWidth와 LadderHeight에서 크기를 검증한다.
- InputView는 입력과 숫자 변환을 담당한다.
- 한 명인 경우 가로선 없이 세로선만 출력한다.

요구사항: [2단계 - 사다리 생성](https://edu.nextstep.camp/s/EaGHivA8/ls/3LLZD9KF)

## 1단계 - 사다리 출력

### 기능 목록

- 사다리는 높이 4줄, 세로선 4개로 고정한다.
- 한 줄에는 세로선 사이의 연결 구간이 3개 있다.
- 가로선의 연결 여부를 무작위로 정한다.
- 바로 앞 구간이 연결되어 있으면 다음 구간은 연결하지 않는다.
- 연결된 구간은 `-----`, 연결되지 않은 구간은 공백 5칸으로 출력한다.
- 1단계에서는 입력 없이 출력했으며, 2단계부터는 입력한 크기로 생성한다.

### 실행 예시

```text
실행결과

|-----|     |-----|
|     |-----|     |
|-----|     |     |
|     |-----|     |
```

실행할 때마다 연결 상태는 달라진다.

### 프로그래밍 요구사항

- 메서드는 10줄 이하로 작성한다.
- 들여쓰기 깊이는 1까지만 허용한다.
- 삼항 연산자, else, switch/case를 사용하지 않는다.
- 배열 대신 컬렉션을 사용하고 이름을 축약하지 않는다.
- 원시 값과 문자열을 포장하고 일급 컬렉션과 Enum을 사용한다.
- 클래스의 인스턴스 변수는 2개 이하로 유지한다.

### domain

- Connection: 가로선의 연결 상태를 표현하고 다음 구간의 연결 여부를 결정한다.
- ConnectionGenerator: 연결 상태를 생성하는 기능을 정의한다.
- RandomConnectionGenerator: 연결 상태를 무작위로 생성한다.
- Line: 한 줄의 연결 상태를 관리한다.
- Ladder: 4개의 Line을 관리한다.

### view

- ResultView: 세로선과 가로선으로 사다리를 출력한다.

Application은 사다리 생성과 출력을 연결한다.

### 테스트

- 바로 앞 구간이 연결되어 있으면 다음 구간은 연결되지 않는다.
- 앞 구간이 연결되지 않았으면 생성기가 다음 연결 상태를 정한다.
- 한 줄의 연결 구간은 3개이며 연결된 구간이 연속으로 생기지 않는다.
- 사다리는 4줄이고, 각 줄은 서로 독립적으로 생성된다.

### 실행 방법

```powershell
.\gradlew.bat test
.\gradlew.bat classes
java -cp build/classes/java/main Application
```

IntelliJ에서는 Application의 main 메서드를 실행한다. 이 프로젝트의 Gradle 8.4 실행에는 JDK 20을 사용할 수 있다.

Windows에서 Gradle 캐시의 한글 경로 때문에 `GradleWorkerMain`을 찾지 못하면, `--gradle-user-home`으로 영문 경로의 캐시를 지정해서 실행한다.

```powershell
.\gradlew.bat --gradle-user-home C:\gradle-cache test
```

### 요구사항 출처

- [1단계 - 사다리 출력](https://edu.nextstep.camp/s/EaGHivA8/ls/UzGWA0qh)
- [1단계 - 사다리 출력 힌트](https://edu.nextstep.camp/s/EaGHivA8/ls/eT7ShKh7)
