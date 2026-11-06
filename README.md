# 🪜 Java 사다리 

## 1단계 - 사다리 출력
- 4x4 크기로 고정된 사다리를 생성
- 랜덤하게 연결 상태를 생성
- 사다리 가로 연결은 연속될 수 없음

## 2단계 - 사다리 생성
- 사다리의 너비 값을 입력받음
- 너비의 최소값은 2로 설정. 최소 2개 있어야 가로줄을 연결할 수 있기 때문이다.
- 사다리의 높이 값을 입력받음
- 높이의 최소값은 1
- 입력받은 사다리 크기에 맞는 사다리 생성

## 3단계 - 사다리 타기
- 사다리 타기 로직을 구현
- 사다리의 시작점과 도착점을 출력

## 4단계 - 게임 실행
- 참여할 사람의 이름 입력받기
- 이름은 쉼표로 분리, 5자 이하
- 넓이 입력 받는 대신 사람 수로 사다리 너비를 결정
- 실행 결과 입력받기
- 실행 결과는 쉼표로 분리
- 사다리 출력시 각 시작점에 참여자 이름, 도착점에 실행 결과를 함께 출력
- 원하는 사람의 이름을 입력 받아서 결과 조회 가능
- 'all' 입력시 전체 결과 조회

## 클래스 역할

### 실행 및 입출력

| 클래스 | 역할 |
| --- | --- |
| `Application` | 입력 객체와 사다리 생성 객체를 구성하고 `LadderController`를 실행하는 진입점이다. |
| `LadderController` | 참여자와 실행 결과 입력, 사다리 생성, 결과 계산 및 출력 흐름을 관리하고 입력 오류를 출력한다. |
| `ResultController` | 이름을 입력받아 개인 결과를 반복 조회하고, `all` 입력 시 전체 결과를 출력한 뒤 조회를 종료한다. |
| `InputView` | 콘솔에서 참여자 이름, 실행 결과, 사다리 높이, 조회할 이름을 입력받고 숫자 입력을 정수로 변환한다. |
| `OutputView` | 참여자 이름, 사다리 모양, 실행 결과와 오류 메시지를 출력한다. |
| `GameInputParser` | 쉼표로 구분된 입력 문자열을 `Participant` 또는 `Outcome` 목록으로 변환한다. |

### 게임 및 참여자, 결과

| 클래스 | 역할 |
| --- | --- |
| `GameSetup` | 참여자 수와 실행 결과 수가 같은지 검증하고 참여자 수를 기준으로 사다리 너비를 결정한다. |
| `GameResult` | 참여자 한 명과 해당 참여자에게 배정된 실행 결과를 함께 보관한다. |
| `GameResults` | 사다리 도착 위치를 실행 결과와 연결해 모든 참여자의 결과를 생성하고, 개인 또는 전체 결과를 제공한다. |
| `Participant` | 참여자 이름의 앞뒤 공백을 제거하고 빈 이름과 5자 초과 이름을 검증한다. |
| `Participants` | 참여자 목록과 순서를 관리하고 최소 2명인지 검증하며, 이름 또는 시작 위치로 참여자를 조회한다. |
| `Outcome` | 실행 결과 값의 앞뒤 공백을 제거하고 빈 값인지 검증한다. |
| `Outcomes` | 실행 결과 목록과 순서를 관리하고 도착 위치에 해당하는 결과를 제공한다. |

### 사다리 생성 및 이동

| 클래스 | 역할 |
| --- | --- |
| `LadderFactory` | 너비와 높이에 맞춰 연결 상태를 생성하고 여러 `Line`을 조합해 `Ladder`를 만든다. |
| `ConnectionGenerator` | 한 행의 가로줄 연결 상태를 무작위로 생성하며, 가로줄이 연속해서 연결되지 않도록 한다. |
| `Connection` | 가로줄의 연결 여부를 `CONNECTED`, `DISCONNECTED`로 표현하는 Enum이다. |
| `Line` | 사다리 한 행의 연결 상태를 관리하고 인접 가로줄을 검증하며, 현재 위치에서의 좌우 이동을 계산한다. |
| `Ladder` | 너비가 같은 여러 행을 관리하고, 시작 위치에서 각 행을 차례로 이동해 최종 도착 위치를 계산한다. |
| `LadderResults` | 모든 시작 위치의 도착 위치를 미리 계산해 보관하고, 시작 위치별 도착 위치를 제공한다. |
| `Position` | 0 이상인 세로줄 위치를 표현하고 좌우로 이동한 새 위치를 생성한다. |
| `Width` | 세로줄 개수를 표현하고 최소 2개인지 검증하며, 가로줄을 놓을 수 있는 칸 수를 계산한다. |
| `Height` | 사다리 행 수를 표현하고 최소 1개인지 검증한다. |

## 프로젝트 구조
```aiignore
src
    ├── main
    │   └── java
    │       ├── Application.java
    │       ├── controller
    │       │   ├── LadderController.java
    │       │   └── ResultController.java
    │       ├── domain
    │       │   ├── game
    │       │   │   ├── GameResult.java
    │       │   │   ├── GameResults.java
    │       │   │   └── GameSetup.java
    │       │   ├── ladder
    │       │   │   ├── Connection.java
    │       │   │   ├── ConnectionGenerator.java
    │       │   │   ├── Height.java
    │       │   │   ├── Ladder.java
    │       │   │   ├── LadderFactory.java
    │       │   │   ├── LadderResults.java
    │       │   │   ├── Line.java
    │       │   │   ├── Position.java
    │       │   │   └── Width.java
    │       │   ├── outcome
    │       │   │   ├── Outcome.java
    │       │   │   └── Outcomes.java
    │       │   └── participant
    │       │       ├── Participant.java
    │       │       └── Participants.java
    │       ├── parser
    │       │   └── GameInputParser.java
    │       └── view
    │           ├── InputView.java
    │           └── OutputView.java
    └── test
        └── java
            ├── domain
            │   ├── game
            │   │   ├── GameResultTest.java
            │   │   └── GameResultsTest.java
            │   ├── ladder
            │   │   ├── ConnectionGeneratorTest.java
            │   │   ├── HeightTest.java
            │   │   ├── LadderFactoryTest.java
            │   │   ├── LadderResultsTest.java
            │   │   ├── LadderTest.java
            │   │   ├── LineTest.java
            │   │   ├── PositionTest.java
            │   │   └── WidthTest.java
            │   ├── outcome
            │   │   ├── OutcomeTest.java
            │   │   └── OutcomesTest.java
            │   └── participant
            │       ├── ParticipantTest.java
            │       └── ParticipantsTest.java
            └── view
                └── InputViewTest.java
```
