# 사다리 게임

현재는 5단계까지 구현되어 있으며, 실행 흐름은 4단계의 이름·결과 입력 방식이다.
2~3단계의 숫자 입력·숫자 결과 출력은 해당 단계의 커밋에 남아 있다.

## 5단계 - 함수형 문법 적용

- Participants와 Outcomes: 반복하며 값을 추가하던 코드를 `stream().map(...).toList()`로 변경했다.
- Ladder: 줄 생성에 `Stream.generate().limit()`, 경로 생성에 `IntStream.range()`와 메서드 참조를 사용했다.
- InputView: 쉼표 입력을 Stream으로 변환하고 공백을 정리한다.
- ResultView: `mapToInt().max()`로 간격을 계산하고 `Collectors.joining()`으로 출력을 조합한다.
- GameResults: `Optional.orElseThrow()`로 없는 참여자의 조회를 처리한다.
- ConnectionGenerator: 함수형 인터페이스로 명시하고 테스트에서 람다 또는 고정 생성기를 주입한다.

변환할 값과 동작을 표현하면 되는 부분에서 반복문과 임시 목록을 줄였다.
앞 구간의 연결 상태나 이전 줄의 위치에 의존하는 Line 생성·사다리 이동은 반복문을 유지했다.
모든 반복문을 Stream으로 바꾸거나 외부 상태를 변경하는 람다를 도입하지 않았다.

요구사항: [5단계 - 리팩터링](https://edu.nextstep.camp/s/EaGHivA8/ls/RnKnJ0jX)
학습 자료: [함수형 프로그래밍 학습 테스트](https://edu.nextstep.camp/s/EaGHivA8/ls/Yv4qTlBZ)

## 4단계 - 게임 실행

- 참여자 이름과 실행 결과를 각각 쉼표로 구분해 입력한다.
- 이름은 앞뒤 공백을 제외하고 1~5글자이며, 중복 이름과 조회 명령인 `all`은 사용할 수 없다.
- 사다리 넓이는 참여자 수로 정하고 높이를 입력받는다.
- 실행 결과는 참여자 수만큼 입력하며, 같은 결과를 여러 개 넣을 수 있다.
- 이름과 결과를 사다리의 위아래에 표시한다. 긴 결과가 있으면 출력 간격도 늘린다.
- 이름을 입력하면 개인 결과, `all`을 입력하면 입력 순서대로 전체 결과를 출력한다.
- 여러 번 조회해도 처음 생성한 사다리의 결과를 사용한다.
- 잘못된 조회 이름이나 빈 조회 입력에는 안내 메시지를 출력하고 다시 조회한다.
- 초기 게임 입력이 잘못되면 예외가 발생한다. 초기 입력은 자동으로 다시 받지 않는다.
- 조회는 입력이 끝날 때 종료한다. Windows 콘솔에서는 Ctrl+Z 후 Enter로 종료할 수 있다.

### 게임 실행 순서

```text
참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)
neo,brown,brie,tommy
실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)
꽝,5000,꽝,3000
최대 사다리 높이는 몇 개인가요?
5
```

### 추가된 객체

- ParticipantName / Participants: 이름 검증과 참여 순서 관리
- Outcome / Outcomes: 결과 값과 결과 개수 검증
- LadderGame: 한 번의 사다리 생성과 결과 계산 연결
- GameResults: 참여자별 결과와 조회
- ResultQuery: 개인 조회와 전체 조회 구분

요구사항: [4단계 - 게임 실행](https://edu.nextstep.camp/s/EaGHivA8/ls/MdraoI8u)

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
